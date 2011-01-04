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
import jp.go.aist.six.util.persist.AssociationEntry;
import jp.go.aist.six.util.persist.DataStore;
import jp.go.aist.six.util.persist.Persistable;
import jp.go.aist.six.util.persist.PersistenceException;
import jp.go.aist.six.util.search.Binding;
import jp.go.aist.six.util.search.RelationalBinding;
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
                    final OvalDefinitions object
                    )
    throws PersistenceException
    {
        if (_LOG.isTraceEnabled()) {
            _LOG.trace( "*** sync related objects ***" );
        }

        final OvalDefinitions  ovalDefs = object;

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

        Definitions  definitions = object.getDefinitions();
        if (definitions != null) {
            for (Definition  d : definitions) {
                _getStore().sync( Definition.class, d );
            }
        }
    }


//    private void _syncAssociation(
//                    final DataStore store,
//                    final OvalDefinitions object
//                    )
//    throws OvalRepositoryException
//    {
//        Definitions  definitions = object.getDefinitions();
//        if (definitions != null) {
//            for (Definition  d : definitions) {
//                // AssociationEntry
//                OvalDefinitionsDefinitionAssociationEntry  assoc =
//                    new OvalDefinitionsDefinitionAssociationEntry( object, d );
//                store.sync( OvalDefinitionsDefinitionAssociationEntry.class, assoc );
//            }
//        }
//    }



    /**
     */
    private <K, L, M, A extends AssociationEntry<K, L, M>>
    List<M> _findAssocID(
                    final Class<A> assocType,
                    final L anteID
                    )
    throws PersistenceException
    {
        Binding  filter =
            RelationalBinding.equalBinding( "antecendentPersistentID", anteID );
        Collection<A>  list = _getStore().find( assocType, filter );

        List<M>  depIDs = new ArrayList<M>();
        if (list.size() > 0) {
            for (A  assoc : list) {
                if (_LOG.isTraceEnabled()) {
                    _LOG.trace( "association: " + assoc );
                }
                M  depID = assoc.getDependentPersistentID();
                depIDs.add( depID );
            }
        }

        return depIDs;
    }



    /**
     */
    private <L, T extends Persistable<L>, M, S extends Persistable<M>,
    K, A extends AssociationEntry<K, L, M>>
    Collection<S> _loadRelatedEntity(
                    final L entityID,
                    final Class<S> relatedType,
                    final Class<A> assocType
                    )
    throws PersistenceException
    {
        List<M>  depIDs = _findAssocID( assocType, entityID );
        List<S>  deps = _getStore().loadAll( relatedType, depIDs );
        return deps;
    }



    /**
     */
    private void _loadRelated(
                    final OvalDefinitions object
                    )
    throws PersistenceException
    {
        String  pid = object.getPersistentID();

        Definitions  defs = new Definitions();
        Collection<Definition>  p_defs = _loadRelatedEntity(
                        pid, Definition.class, OvalDefinitionsDefinitionAssociationEntry.class );
        if (p_defs.size() > 0) {
            defs.addAll( p_defs );
        }

        Tests  tests = new Tests();
        Collection<Test>  p_tests = _loadRelatedEntity(
                        pid, Test.class, OvalDefinitionsTestAssociationEntry.class );
        if (p_tests.size() > 0) {
            tests.addAll( p_tests );
        }

        SystemObjects  sysobjs = new SystemObjects();
        Collection<SystemObject>  p_sysobjs = _loadRelatedEntity(
                        pid, SystemObject.class, OvalDefinitionsSystemObjectAssociationEntry.class );
        if (p_sysobjs.size() > 0) {
            sysobjs.addAll( p_sysobjs );
        }

        States  states = new States();
        Collection<State>  p_states = _loadRelatedEntity(
                        pid, State.class, OvalDefinitionsStateAssociationEntry.class );
        if (p_states.size() > 0) {
            states.addAll( p_states );
        }

        Variables  variables = new Variables();
        Collection<Variable>  p_variables = _loadRelatedEntity(
                        pid, Variable.class, OvalDefinitionsVariableAssociationEntry.class );
        if (p_variables.size() > 0) {
            variables.addAll( p_variables );
        }

        object.setDefinitions( defs );
        object.setTests( tests );
        object.setObjects( sysobjs );
        object.setStates( states );
        object.setVariables( variables );

//        Binding  filter =
//            RelationalBinding.equalBinding( "antecendentPersistentID", object.getPersistentID() );
//        Collection<OvalDefinitionsDefinitionAssociationEntry>  list =
//            _getStore().find( OvalDefinitionsDefinitionAssociationEntry.class, filter );
//
//        Definitions  defs = new Definitions();
//        if (list.size() > 0) {
//            Set<String>  defPIDs = new HashSet<String>();
//            for (OvalDefinitionsDefinitionAssociationEntry  assoc : list) {
//                if (_LOG.isTraceEnabled()) {
//                    _LOG.trace( "association: " + assoc );
//                }
//                String  defPID = assoc.getDependentPersistentID();
//                defPIDs.add( defPID );
//            }
//
//            List<String>  defPID_list = new ArrayList<String>( defPIDs );
//
//            Collection<Definition>  p_defs = _getStore().loadAll( Definition.class, defPID_list );
//            defs.addAll( p_defs );
//        }
//
//        object.setDefinitions( defs );
    }



    //**************************************************************
    // StoreWorker
    //**************************************************************

    @Override
    public String create(
                    final OvalDefinitions object
                    )
    throws PersistenceException
    {
        _syncRelated( object );

        return _getStore().create( getType(), object );
    }



    @Override
    public OvalDefinitions sync(
                    final OvalDefinitions object
                    )
    throws PersistenceException
    {
        _syncRelated( object );
//        _syncAssociation( store, object );

        return _getStore().sync( getType(), object );
    }



    @Override
    public OvalDefinitions load(
                    final String identity
                    )
    throws PersistenceException
    {
        OvalDefinitions  defs = _getStore().load( getType(), identity );
        _loadRelated( defs );

        return defs;
    }

}
// OvalDefinitionsWorker

