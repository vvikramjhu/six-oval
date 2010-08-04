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

import jp.go.aist.six.oval.core.model.definition.DefinitionCriteria;
import jp.go.aist.six.oval.core.store.OvalStore;
import jp.go.aist.six.oval.core.xml.OvalXml;
import jp.go.aist.six.oval.model.OvalEntity;
import jp.go.aist.six.oval.model.definition.Criteria;
import jp.go.aist.six.oval.model.definition.Definition;
import jp.go.aist.six.oval.model.definition.Definitions;
import jp.go.aist.six.oval.model.definition.OvalDefinitions;
import jp.go.aist.six.oval.model.definition.State;
import jp.go.aist.six.oval.model.definition.States;
import jp.go.aist.six.oval.model.definition.SystemObject;
import jp.go.aist.six.oval.model.definition.SystemObjects;
import jp.go.aist.six.oval.model.definition.Test;
import jp.go.aist.six.oval.model.definition.Tests;
import jp.go.aist.six.oval.model.definition.Variable;
import jp.go.aist.six.oval.model.definition.Variables;
import jp.go.aist.six.oval.model.result.OvalResults;
import jp.go.aist.six.oval.model.system.Item;
import jp.go.aist.six.oval.model.system.OvalSystemCharacteristics;
import jp.go.aist.six.oval.service.OvalServiceException;
import jp.go.aist.six.util.search.Binding;
import jp.go.aist.six.util.search.RelationalBinding;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.Collection;
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


    public Collection<Item> getAllItems(
                    final Collection<String> pids
                    )
    throws OvalServiceException
    {
        Collection<Item>  items = null;
        try {
            items = _store.getAll( Item.class, pids );
        } catch (Exception ex) {
            throw new OvalServiceException( ex );
        }

        return items;
    }




    // OvalDefinitions //

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



    // OvalResutls //

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

