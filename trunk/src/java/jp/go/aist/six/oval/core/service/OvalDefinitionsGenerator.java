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
import jp.go.aist.six.oval.model.definitions.Criteria;
import jp.go.aist.six.oval.model.definitions.CriteriaElement;
import jp.go.aist.six.oval.model.definitions.Criterion;
import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.Definitions;
import jp.go.aist.six.oval.model.definitions.ExtendDefinition;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.definitions.State;
import jp.go.aist.six.oval.model.definitions.StateRef;
import jp.go.aist.six.oval.model.definitions.States;
import jp.go.aist.six.oval.model.definitions.SystemObject;
import jp.go.aist.six.oval.model.definitions.SystemObjectRef;
import jp.go.aist.six.oval.model.definitions.SystemObjects;
import jp.go.aist.six.oval.model.definitions.Test;
import jp.go.aist.six.oval.model.definitions.Tests;
import jp.go.aist.six.oval.service.OvalException;
import jp.go.aist.six.util.IsoDate;
import jp.go.aist.six.util.persist.DataStore;
import jp.go.aist.six.util.search.Binding;
import jp.go.aist.six.util.search.RelationalBinding;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;



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
    private void _buildDefinitions(
                    final OvalDefinitions ovalDefs,
                    final Set<String> defIDs
                    )
    throws OvalException
    {
        Definitions  defList = new Definitions();
        for (String  defID : defIDs) {
            if (defID == null) {
                if (_LOG.isWarnEnabled()) {
                    _LOG.warn( "null definition ID specified" );
                }
                continue;
            }

            Definition  def = _loadLatestEntity( Definition.class, defID );
            //TODO: PersistentDefinition.class
            defList.add( def );
        }

        ovalDefs.setDefinitions( defList );
    }




    /**
     */
    private void _buildEntitiesForDefinition(
                    final OvalDefinitions ovalDefs,
                    final Definition def
                    )
    throws OvalException
    {
        if (_LOG.isTraceEnabled()) {
            _LOG.trace( "building entities for Definition: ID=" + def.getOvalID() );
        }

        Criteria  criteria = def.getCriteria();
        if (criteria == null) {
            if (_LOG.isTraceEnabled()) {
                _LOG.trace( "NO Definition criteria: ID=" + def.getOvalID() );
            }

            return;
        }

        Tests  tests = ovalDefs.getTests();
        if (tests == null) {
            tests = new Tests();
            ovalDefs.setTests( tests );
        }

        Definitions  defs = ovalDefs.getDefinitions();

        for (CriteriaElement  element : criteria) {
            if (Criterion.class.isInstance( element )) {
                Criterion  criterion = (Criterion)element;
                String  testID = criterion.getTestRef();
                Test  test = tests.find( testID );
                if (test == null) {
                    // This test have NOT loaded yet.
                    test = _loadLatestEntity( Test.class, testID );
                    tests.add( test );

                    _buildEntitiesForTest( ovalDefs, test );
                }
            } else if (ExtendDefinition.class.isInstance( element )) {
                ExtendDefinition  extdef = (ExtendDefinition)element;
                String  def2ID = extdef.getDefinitionRef();
                Definition  def2 = defs.find( def2ID );
                if (def2 == null) {
                    def2 = _loadLatestEntity( Definition.class, def2ID );
                    defs.add( def2 );

                    _buildEntitiesForDefinition( ovalDefs, def2 );
                }
            }
        }
    }



    /**
     */
    private void _buildEntitiesForTest(
                    final OvalDefinitions ovalDefs,
                    final Test test
                    )
    throws OvalException
    {
        SystemObjectRef  sysObjRef = test.getObject();
        if (sysObjRef != null) {
            SystemObjects  sysObjs = ovalDefs.getObjects();
            if (sysObjs == null) {
                sysObjs = new SystemObjects();
                ovalDefs.setObjects( sysObjs );
            }

            String  sysObjID = sysObjRef.getObjectRef();
            SystemObject  sysObj = sysObjs.find( sysObjID );
            if (sysObj == null) {
                sysObj = _loadLatestEntity( SystemObject.class, sysObjID );
                sysObjs.add( sysObj );

                //TODO: load variables!!!
            }
        }


        Collection<StateRef>  stateRefs = test.getState();
        if (stateRefs != null  &&  stateRefs.size() > 0) {
            States  states = ovalDefs.getStates();
            if (states == null) {
                states = new States();
                ovalDefs.setStates( states );
            }

            for (StateRef  stateRef : stateRefs) {
                String  stateID = stateRef.getStateRef();
                State  state = states.find( stateID );
                if (state == null) {
                    state = _loadLatestEntity( State.class, stateID );
                    states.add( state );
                }
            }
        }
    }



    /**
     */
    private void _buildAllEntities(
                    final OvalDefinitions ovalDefs,
                    final Set<String> definitionIDs
                    )
    throws OvalException
    {
        _buildDefinitions( ovalDefs, definitionIDs );

        for (Definition  def : ovalDefs.getDefinitions()) {
            _buildEntitiesForDefinition( ovalDefs, def );
        }
    }



    /**
     */
    public OvalDefinitions generateIncludingDefinitions(
                    final Collection<String> definitionIDs
                    )
    throws OvalException
    {
        if (definitionIDs == null  ||  definitionIDs.size() == 0) {
            throw new IllegalArgumentException( "no definition ID specified" );
        }

        OvalDefinitions  ovalDefs = new OvalDefinitions();
        Set<String>  defIDs = new HashSet<String>( definitionIDs );
        _buildAllEntities( ovalDefs, defIDs );

        ovalDefs.setGenerator( _createGenerator() );
        return ovalDefs;
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

