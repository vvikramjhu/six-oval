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

package jp.go.aist.six.oval.core.store;

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
import jp.go.aist.six.util.persist.DataStore;
import jp.go.aist.six.util.persist.PersistenceException;
import jp.go.aist.six.util.search.Binding;
import jp.go.aist.six.util.search.Limit;
import jp.go.aist.six.util.search.Order;
import jp.go.aist.six.util.search.SearchCriteria;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalDefinitionsWorker
    extends Worker<String, OvalDefinitions>
{

    /**
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( OvalDefinitionsWorker.class );



    /**
     * Constructor.
     */
    public OvalDefinitionsWorker(
                    final DataStore store
                    )
    {
        super( OvalDefinitions.class, store );
    }



    /**
     */
    private void _syncRelated(
                    final OvalDefinitions ovalDefs
                    )
    throws PersistenceException
    {
        if (_LOG.isTraceEnabled()) {
            _LOG.trace( "*** sync related objects ***" );
        }

        Variables  variables = ovalDefs.getVariables();
        if (variables != null) {
            for (Variable  variable : variables) {
                _getStore().sync( Variable.class, variable );
            }
        }

        SystemObjects  sysobjs = ovalDefs.getObjects();
        if (sysobjs != null) {
            for (SystemObject  sysobj : sysobjs) {
                _getStore().sync( SystemObject.class, sysobj );
            }
        }

        States  states = ovalDefs.getStates();
        if (states != null) {
            for (State  state : states) {
                _getStore().sync( State.class, state );
            }
        }

        Tests  tests = ovalDefs.getTests();
        if (tests != null) {
            for (Test  test : tests) {
                _getStore().sync( Test.class, test );
            }
        }

        Definitions  definitions = ovalDefs.getDefinitions();
        if (definitions != null) {
            for (Definition  d : definitions) {
                _getStore().sync( Definition.class, d );
            }
        }
    }



    /**
     */
    private void _loadRelated(
                    final OvalDefinitions ovalDefs
                    )
    throws PersistenceException
    {
        final String  pid = ovalDefs.getPersistentID();

        Definitions  defs = new Definitions();
        Collection<Definition>  p_defs = _loadAssociated( pid, Definition.class,
                            OvalDefinitionsDefinitionAssociationEntry.class );
        if (p_defs != null) {
            defs.addAll( p_defs );
        }

        Tests  tests = new Tests();
        Collection<Test>  p_tests = _loadAssociated( pid, Test.class,
                        OvalDefinitionsTestAssociationEntry.class );
        if (p_tests != null) {
            tests.addAll( p_tests );
        }

        SystemObjects  sysobjs = new SystemObjects();
        Collection<SystemObject>  p_sysobjs = _loadAssociated( pid, SystemObject.class,
                        OvalDefinitionsSystemObjectAssociationEntry.class );
        if (p_sysobjs != null) {
            sysobjs.addAll( p_sysobjs );
        }

        States  states = new States();
        Collection<State>  p_states = _loadAssociated( pid, State.class,
                        OvalDefinitionsStateAssociationEntry.class );
        if (p_states != null) {
            states.addAll( p_states );
        }

        Variables  variables = new Variables();
        Collection<Variable>  p_variables = _loadAssociated( pid, Variable.class,
                        OvalDefinitionsVariableAssociationEntry.class );
        if (p_variables != null) {
            variables.addAll( p_variables );
        }

        ovalDefs.setDefinitions( defs );
        ovalDefs.setTests( tests );
        ovalDefs.setObjects( sysobjs );
        ovalDefs.setStates( states );
        ovalDefs.setVariables( variables );
    }



    //**************************************************************
    // Worker
    //**************************************************************

    @Override
    public String create(
                    final OvalDefinitions object
                    )
    throws PersistenceException
    {
        _syncRelated( object );

        return _getStore().create( getObjectType(), object );
    }



    @Override
    public OvalDefinitions sync(
                    final OvalDefinitions object
                    )
    throws PersistenceException
    {
        _syncRelated( object );

        return _getStore().sync( getObjectType(), object );
    }



    @Override
    public OvalDefinitions load(
                    final String identity
                    )
    throws PersistenceException
    {
        OvalDefinitions  defs = _getStore().load( getObjectType(), identity );
        _loadRelated( defs );

        return defs;
    }



    @Override
    public Collection<OvalDefinitions> find(
                    final Binding filter,
                    final List<? extends Order> ordering,
                    final Limit limit
                    )
    throws PersistenceException
    {
        Collection<String>  ovalDefsPIDs =
            _getStore().findIdentity( getObjectType(), filter, ordering, limit );

        Collection<OvalDefinitions>  results = new ArrayList<OvalDefinitions>();
        if (ovalDefsPIDs != null) {
            for (String  pid : ovalDefsPIDs) {
                OvalDefinitions  ovalDefs = load( pid );
                results.add( ovalDefs );
            }
        }

        return results;
    }



    @Override
    public List<OvalDefinitions> search(
                    final SearchCriteria criteria
                    )
    throws PersistenceException
    {
        if (criteria == null) {
            return (new ArrayList<OvalDefinitions>( find() ));
        } else {
            return (new ArrayList<OvalDefinitions>(
                            find( criteria.getBinding(),
                                  criteria.getOrders(),
                                  criteria.getLimit()))
                                  );
        }
    }

}
// OvalDefinitionsWorker

