/*
 *  @product.title@
 *  Copyright (C) @product.copyright-year@
 *    @product.vendor@
 *    Registration Number: @product.registration-number@
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package jp.go.aist.six.oval.core.service;

import jp.go.aist.six.oval.model.OvalEntity;
import jp.go.aist.six.oval.model.common.Generator;
import jp.go.aist.six.oval.model.definitions.Component;
import jp.go.aist.six.oval.model.definitions.Criteria;
import jp.go.aist.six.oval.model.definitions.CriteriaElement;
import jp.go.aist.six.oval.model.definitions.Criterion;
import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.Definitions;
import jp.go.aist.six.oval.model.definitions.EntityBase;
import jp.go.aist.six.oval.model.definitions.ExtendDefinition;
import jp.go.aist.six.oval.model.definitions.LocalVariable;
import jp.go.aist.six.oval.model.definitions.ObjectComponent;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.definitions.State;
import jp.go.aist.six.oval.model.definitions.StateRef;
import jp.go.aist.six.oval.model.definitions.States;
import jp.go.aist.six.oval.model.definitions.SystemObject;
import jp.go.aist.six.oval.model.definitions.SystemObjectRef;
import jp.go.aist.six.oval.model.definitions.SystemObjects;
import jp.go.aist.six.oval.model.definitions.Test;
import jp.go.aist.six.oval.model.definitions.Tests;
import jp.go.aist.six.oval.model.definitions.Variable;
import jp.go.aist.six.oval.model.definitions.Variables;
import jp.go.aist.six.oval.service.OvalException;
import jp.go.aist.six.util.IsoDate;
import jp.go.aist.six.util.persist.DataStore;
import jp.go.aist.six.util.search.Binding;
import jp.go.aist.six.util.search.PropertyProjection;
import jp.go.aist.six.util.search.RelationalBinding;
import jp.go.aist.six.util.search.SearchCriteria;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalDefinitionsGenerator
{

    /**
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( OvalDefinitionsGenerator.class );


    public static final String  PRODUCT_NAME    = "SIX OVAL";
    public static final String  PRODUCT_VERSION = "0.7.0";
    public static final String  SCHEMA_VERSION  = "5.8";




    private DataStore  _store;



    /**
     * Constructor.
     */
    public OvalDefinitionsGenerator()
    {
        _init();
    }



    /**
     *
     */
    private void _init()
    {
        OvalContext  context = new OvalContext();
        DataStore  store = context.getBean( "ovalStore", DataStore.class );
        setStore( store );
    }



    /**
     */
    public void setStore(
                    final DataStore store
                    )
    {
        _store = store;
    }



    /**
     */
    private Generator _createGenerator()
    {
        Date  timestamp = new Date();
        Generator  generator = new Generator(
                        SCHEMA_VERSION,
                        IsoDate.format( timestamp ),
                        PRODUCT_NAME,
                        PRODUCT_VERSION
                        );

        return generator;
    }



    /**
     */
    private void _buildDefinition(
                    final OvalDefinitions ovalDefs,
                    final String defID
                    )
    throws OvalException
    {
        Definitions  defs = ovalDefs.getDefinitions();
        Definition  def = null;
        if (defs == null) {
            defs = new Definitions();
            ovalDefs.setDefinitions( defs );
        } else {
            def = defs.find( defID );
            if (def != null) {
                // The Definition has already loaded.
                return;
            }
        }


        if (_LOG.isTraceEnabled()) {
            _LOG.trace( "building entities for Definition: ID=" + defID );
        }

        def = _loadLatestEntity( Definition.class, defID );
        defs.add( def );

        Criteria  criteria = def.getCriteria();
        _buildCriteriaElement( ovalDefs, criteria );
    }



    /**
     */
    private void _buildCriteriaElement(
                    final OvalDefinitions ovalDefs,
                    final CriteriaElement element
                    )
    throws OvalException
    {
        if (element == null) {
            return;
        }

        if (_LOG.isTraceEnabled()) {
            _LOG.trace( "building entities for Criteria" );
        }

        if (Criteria.class.isInstance( element )) {
            Criteria  criteria = Criteria.class.cast( element );
            for (CriteriaElement  childElement : criteria) {
                _buildCriteriaElement( ovalDefs, childElement );
            }
        } else if (Criterion.class.isInstance( element )) {
            Criterion  criterion = Criterion.class.cast( element );
            String  testID = criterion.getTestRef();
            _buildTest( ovalDefs, testID );
        } else if (ExtendDefinition.class.isInstance( element )) {
            ExtendDefinition  extdef = ExtendDefinition.class.cast( element );
            String  defID = extdef.getDefinitionRef();
            _buildDefinition( ovalDefs, defID );
        }
    }



    /**
     */
    private void _buildTest(
                    final OvalDefinitions ovalDefs,
                    final String testID
                    )
    throws OvalException
    {
        Tests  tests = ovalDefs.getTests();
        Test  test = null;
        if (tests == null) {
            tests = new Tests();
            ovalDefs.setTests( tests );
        } else {
            test = tests.find( testID );
            if (test != null) {
                // The Test has already loaded.
                return;
            }
        }

        test = _loadLatestEntity( Test.class, testID );
        tests.add( test );


        SystemObjectRef  sysObjRef = test.getObject();
        if (sysObjRef != null) {
            String  sysObjID = sysObjRef.getObjectRef();
            _buildObject( ovalDefs, sysObjID );
        }


        Collection<StateRef>  stateRefs = test.getState();
        if (stateRefs != null  &&  stateRefs.size() > 0) {
            for (StateRef  stateRef : stateRefs) {
                String  stateID = stateRef.getStateRef();
                _buildState( ovalDefs, stateID );
            }
        }
    }



    /**
     * SystemObject by ovalID
     */
    private void _buildObject(
                    final OvalDefinitions ovalDefs,
                    final String sysObjID
                    )
    throws OvalException
    {
        SystemObjects  sysObjs = ovalDefs.getObjects();
        SystemObject  sysObj = null;
        if (sysObjs == null) {
            sysObjs = new SystemObjects();
            ovalDefs.setObjects( sysObjs );
        } else {
            sysObj = sysObjs.find( sysObjID );
            if (sysObj != null) {
                // The SystemObject has already loaded.
                return;
            }
        }

        sysObj = _loadLatestEntity( SystemObject.class, sysObjID );
        sysObjs.add( sysObj );

        Iterator<EntityBase>  itrProps = sysObj.iterateProperties();
        while (itrProps.hasNext()) {
            EntityBase  prop = itrProps.next();
            String  variableID = prop.getVarRef();
            if (variableID != null) {
                _buildVariable( ovalDefs, variableID );
            }
        }
    }



    /**
     * State by ovalID
     */
    private void _buildState(
                    final OvalDefinitions ovalDefs,
                    final String sysObjID
                    )
    throws OvalException
    {
        States  states = ovalDefs.getStates();
        State  state = null;
        if (states == null) {
            states = new States();
            ovalDefs.setStates( states );
        } else {
            state = states.find( sysObjID );
            if (state != null) {
                // The State has already loaded.
                return;
            }
        }

        state = _loadLatestEntity( State.class, sysObjID );
        states.add( state );
    }



    /**
     * Variable by ovalID
     */
    private void _buildVariable(
                    final OvalDefinitions ovalDefs,
                    final String ovalID
                    )
    throws OvalException
    {
        Variables  variables = ovalDefs.getVariables();
        Variable  variable = null;
        if (variables == null) {
            variables = new Variables();
            ovalDefs.setVariables( variables );
        } else {
            variable = variables.find( ovalID );
            if (variable != null) {
                // The Variable has already loaded.
                return;
            }
        }

        variable = _loadLatestEntity( Variable.class, ovalID );
        variables.add( variable );

        if (! LocalVariable.class.isInstance( variable )) {
            return;
        }

        LocalVariable  localVariable = LocalVariable.class.cast( variable );
        Component   component = localVariable.getComponent();
        if (! ObjectComponent.class.isInstance( component )) {
            return;
        }

        ObjectComponent  objectComponent = ObjectComponent.class.cast( component );
        String  sysObjID = objectComponent.getObjectRef(); //{required}

        _buildObject( ovalDefs, sysObjID );
    }



    /**
     */
    private void _buildAll(
                    final OvalDefinitions ovalDefs,
                    final Collection<String> defIDs
                    )
    throws OvalException
    {
        if (defIDs == null  ||  defIDs.size() == 0) {
            return;
        }

        for (String  defID : defIDs) {
            _buildDefinition( ovalDefs, defID );
        }
    }



    /**
     */
    public OvalDefinitions generateFromDefinitionIDs(
                    final Collection<String> defIDs
                    )
    throws OvalException
    {
        if (defIDs == null  ||  defIDs.size() == 0) {
            throw new IllegalArgumentException( "no definition ID specified" );
        }

        OvalDefinitions  ovalDefs = new OvalDefinitions();
        _buildAll( ovalDefs, defIDs );

        ovalDefs.setGenerator( _createGenerator() );
        return ovalDefs;
    }



    /**
     */
    public OvalDefinitions generateByDefinitionFilter(
                    final Binding filter
                    )
    throws OvalException
    {
//        if (filter == null) {
//            throw new IllegalArgumentException( "no filter specified" );
//        }

        SearchCriteria  criteria = new SearchCriteria( filter );
        criteria.addProjection( new PropertyProjection( "ovalID" ) );

        Collection<Object>  defIDsTemp = _store.search( Definition.class, criteria );

        Collection<String>  defIDs = new ArrayList<String>();
        for (Object  obj : defIDsTemp) {
            String  defID = (String)obj;
            defIDs.add( defID );
        }
        if (_LOG.isDebugEnabled()) {
            _LOG.debug( "definition IDs=" + defIDs );
        }

        return generateFromDefinitionIDs( defIDs );
    }



    /**
     */
    private <T extends OvalEntity> T _loadLatestEntity(
                    final Class<T> type,
                    final String ovalID
                    )
    throws OvalException
    {
        if (_LOG.isTraceEnabled()) {
            _LOG.trace( "loading latest entity: ID=" + ovalID );
        }

        Binding  filter = RelationalBinding.equalBinding( "ovalID", ovalID );
        Collection<T>  entities = _store.find( type, filter );

        T  latestEntity = null;
        if (entities.size() == 0) {
            throw new OvalException( "no such entity: " + ovalID );
        } else if (entities.size() == 1) {
            latestEntity = entities.iterator().next();
        } else {
            // multiple versions exist.
            int  maxVersion = 0;
            T  max = null;
            for (T  entity : entities) {
                if (max == null) {
                    max = entity;
                    maxVersion = entity.getOvalVersion();
                } else {
                    int  version = entity.getOvalVersion();
                    if (maxVersion < version) {
                        max = entity;
                        maxVersion = version;
                    }
                }
                latestEntity = max;
            }
        }

        if (_LOG.isTraceEnabled()) {
            _LOG.trace( "latest entity loaded: " + latestEntity );
        }

        return latestEntity;
    }

}
// OvalDefinitionsGenerator

