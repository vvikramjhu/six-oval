/*
 *  @ProductName@
 *  Copyright (C) @CopyrightYear@
 *    National Institute of Advanced Industrial Science and Technology (AIST)
 *    Registration Number: @AISTRegistrationNumber@
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

import jp.go.aist.six.oval.core.model.definitions.DefinitionCriteria;
import jp.go.aist.six.oval.core.store.OvalStore;
import jp.go.aist.six.oval.core.xml.OvalXml;
import jp.go.aist.six.oval.model.OvalEntity;
import jp.go.aist.six.oval.model.common.Generator;
import jp.go.aist.six.oval.model.definitions.Criteria;
import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.Definitions;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.definitions.State;
import jp.go.aist.six.oval.model.definitions.States;
import jp.go.aist.six.oval.model.definitions.SystemObject;
import jp.go.aist.six.oval.model.definitions.SystemObjects;
import jp.go.aist.six.oval.model.definitions.Test;
import jp.go.aist.six.oval.model.definitions.Tests;
import jp.go.aist.six.oval.model.definitions.Variable;
import jp.go.aist.six.oval.model.definitions.Variables;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.model.sc.Item;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import jp.go.aist.six.oval.service.OvalServiceException;
import jp.go.aist.six.util.search.Binding;
import jp.go.aist.six.util.search.Limit;
import jp.go.aist.six.util.search.Order;
import jp.go.aist.six.util.search.RelationalBinding;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class LocalOvalRepository
{

    /**
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( LocalOvalRepository.class );



    /**
     * The data store sole instance.
     */
    private OvalStore  _store;


    /**
     * The XML processor sole instance.
     */
    private OvalXml  _xml;



    /**
     * Constructor.
     */
    public LocalOvalRepository()
    throws Exception
    {
        _initialize();
    }



    /**
     */
    private void _initialize()
    throws Exception
    {
        OvalContext  context = new OvalContext();
        _store = context.getStore();
        _xml = context.getXml();
    }



    /**
     */
    private void _createRelated(
                    final OvalDefinitions defs
                    )
    {
//        if (defs.getPersistentID() == null) {
//            String  uuid = UUID.randomUUID().toString();
//            defs.setPersistentID( uuid );
//        }

        Tests  test_list = defs.getTests();
        if (test_list != null) {
            Tests  p_tests = new Tests();
            for (Test  test : test_list) {
                Test  p_test = _store.sync( Test.class, test );
                p_tests.add( p_test );
            }

            defs.setTests( p_tests );
        }


        SystemObjects  objects = defs.getObjects();
        if (objects != null) {
            SystemObjects  p_objects = new SystemObjects();
            for (SystemObject  object : objects) {
                if (_LOG.isInfoEnabled()) {
                    _LOG.info( "creating Definition: " + object.getOvalID() );
                }
                SystemObject  p_object = _store.sync( SystemObject.class, object );
                p_objects.add( p_object );
            }

            defs.setObjects( p_objects );
        }

        States  states = defs.getStates();
        if (states != null) {
            States  p_objects = new States();
            for (State  object : states) {
                State  p_object = _store.sync( State.class, object );
                p_objects.add( p_object );
            }

            defs.setStates( p_objects );
        }


        Variables  variables = defs.getVariables();
        if (variables != null) {
            Variables  p_objects = new Variables();
            for (Variable  object : variables) {
                Variable  p_object = _store.sync( Variable.class, object );
                p_objects.add( p_object );
            }

            defs.setVariables( p_objects );
        }


        Definitions  def_list = defs.getDefinitions();
        if (def_list != null) {
            Definitions  p_def_list = new Definitions();
            for (Definition  def : def_list) {
                if (_LOG.isInfoEnabled()) {
                    _LOG.info( "creating Definition: " + def.getOvalID() );
                }
                Definition  p_def = _store.sync( Definition.class, def );
                p_def_list.add( p_def );
            }
            defs.setDefinitions( p_def_list );
        }
    }



    //**************************************************************
    //  OvalRepository
    //**************************************************************

    public OvalSystemCharacteristics getOvalSystemCharacteristics(
                    final String pid
                    )
    throws OvalServiceException
    {
        OvalSystemCharacteristics  sc = null;
        try {
            sc = _store.get( OvalSystemCharacteristics.class, pid );
        } catch (Exception ex) {
            throw new OvalServiceException( ex );
        }

        return sc;
    }
//    {
//        RelationalBinding  filter = RelationalBinding.equalBinding(
//                        "persistentID", pid );
//        List<OvalSystemCharacteristics>  sc = null;
//        try {
//            sc = _store.find( OvalSystemCharacteristics.class, filter);
//        } catch (Exception ex) {
//            throw new OvalServiceException( ex );
//        }
//
//        return (sc.size() == 0 ? null : sc.get( 0 ));
//    }


    public Collection<Item> getItem(
                    final String scPID
                    )
    throws OvalServiceException
    {
        RelationalBinding  filter = RelationalBinding.equalBinding(
                        "masterPersistentID", scPID );

        Collection<Item>  items = null;
        try {
            items = _store.find( Item.class, filter );
        } catch (Exception ex) {
            throw new OvalServiceException( ex );
        }

        return items;
    }



    //==============================================================
    // oval-definitions
    //==============================================================

    public String createOvalDefinitions(
                    final OvalDefinitions defs
                    )
    throws OvalServiceException
    {
        String  pid = null;
        try {
//            _createRelated( defs );
            pid = _store.create( OvalDefinitions.class, defs );
        } catch (Exception ex) {
            throw new OvalServiceException( ex );
        }

        return pid;
    }


    public OvalDefinitions getOvalDefinitions(
                    final String pid
                    )
    throws OvalServiceException
    {
        OvalDefinitions  defs = null;
        try {
            defs = _store.get( OvalDefinitions.class, pid );
        } catch (Exception ex) {
            throw new OvalServiceException( ex );
        }

        return defs;
    }



    public Definition getDefinition(
                    final String pid
                    )
    throws OvalServiceException
    {
        Definition  def = null;
        try {
            def = _store.get( Definition.class, pid );
        } catch (Exception ex) {
            throw new OvalServiceException( ex );
        }

        return def;
    }



    /**
     */
    public OvalDefinitions buildOvalDefinitionsFor(
                    final String defID
                    )
    throws OvalServiceException
    {
        RelationalBinding  filter = RelationalBinding.equalBinding(
                        "ovalID", defID );
        Order  order = new Order( "ovalVersion", true );
        List<Definition>  defList = null;
        try {
            defList = _store.find( Definition.class,
                            filter,
                            Arrays.asList( new Order[] { order } ),
                            new Limit( 1 ) );
        } catch (Exception ex) {
            throw new OvalServiceException( ex );
        }

        if (defList == null  ||  defList.size() == 0) {
            throw new OvalServiceException( "no such OVAL Definition: " + defID );
        }

        Definition  def = defList.get( 0 );
        Criteria  criteria = _getDefinitionCriteria( def.getPersistentID() );
        def.setCriteria( criteria );

        Definitions  defs = new Definitions();
        defs.add( def );

        OvalDefinitions  ovalDefs = new OvalDefinitions();
        Generator  generator = new Generator(
                        "5.7",
                        new Date(),
                        "SIX OVAL Repository Replica",
                        "0.5.0" );
        ovalDefs.setGenerator( generator );
        ovalDefs.setDefinitions( defs );
        if (_LOG.isInfoEnabled()) {
            _LOG.info( "oval_definitions built: " + ovalDefs );
        }

        return ovalDefs;
    }



    private Criteria _getDefinitionCriteria(
                    final String defPID
                    )
    throws OvalServiceException
    {
        DefinitionCriteria  defCriteria = null; // may be NULL!!!
        try {
            defCriteria = _store.get( DefinitionCriteria.class, defPID );
        } catch (Exception ex) {
            throw new OvalServiceException( ex );
        }

        Criteria  criteria = null;
        if (defCriteria != null) {
            try {
                OvalXml  xmlMapper = OvalContext.INSTANCE.getXml();
                criteria = (Criteria)xmlMapper.unmarshalFromString(
                                defCriteria.getCriteriaXml() );
            } catch (Exception ex) {
                throw new OvalServiceException(
                                "internal ERROR - get OVAL Definition Criteria: "
                                + defPID + ", " + ex.getMessage() );
            }
        }

        return criteria;
    }




    //==============================================================
    // oval-results
    //==============================================================

    public String createOvalResults(
                    final OvalResults resutls
                    )
    throws OvalServiceException
    {
        String  pid = null;
        try {
            pid = _store.create( OvalResults.class, resutls );
        } catch (Exception ex) {
            throw new OvalServiceException( ex );
        }

        return pid;
    }


    public OvalResults getOvalResults(
                    final String pid
                    )
    throws OvalServiceException
    {
        OvalResults  results = null;
        try {
            results = _store.get( OvalResults.class, pid );
        } catch (Exception ex) {
            throw new OvalServiceException( ex );
        }

        return results;
    }


    public List<OvalResults> findOvalResults(
                    final Binding filter,
                    final List<Order> ordering,
                    final Limit limit
                    )
    throws OvalServiceException
    {
        List<OvalResults>  results = null;
        try {
            results = _store.find( OvalResults.class, filter, ordering, limit );
        } catch (Exception ex) {
            throw new OvalServiceException( ex );
        }

        return results;
    }



    public List<String> findDefinitionID(
                    final Binding filter
                    )
    throws OvalServiceException
    {
        return _store.findIdentity( Definition.class, filter );
    }



    public Collection<String> findDefinitionIDByCve(
                    final String cve
                    )
    throws OvalServiceException
    {
        RelationalBinding  filter = RelationalBinding.equalBinding(
                        "relatedCves.persistentID", cve );
        Collection<String>  ovalIDList = _store.findIdentity( Definition.class, filter );

        return ovalIDList;
    }



    public Criteria getDefinitionCriteria(
                    final Definition  def
                    )
    throws OvalServiceException
    {
        return getDefinitionCriteria( def.getOvalID(), def.getOvalVersion() );
    }


    public Criteria getDefinitionCriteria(
                    final String defID,
                    final int defVersion
                    )
    throws OvalServiceException
    {
        String  pid = OvalEntity.generatePersistentID( defID, defVersion );
        DefinitionCriteria  dc = _store.get( DefinitionCriteria.class, pid );
        Criteria  criteria = null;
        if (dc != null) {
            try {
                criteria = (Criteria)_xml.unmarshalFromString( dc.getCriteriaXml() );
            } catch (Exception ex) {
                _LOG.error( "unmarshal criteria: " + ex.getMessage() );
                throw new OvalServiceException( ex );
            }
        }

        return criteria;
    }

}
// LocalOvalRepository

