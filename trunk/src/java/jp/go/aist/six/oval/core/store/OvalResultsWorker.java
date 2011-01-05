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

import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.results.OvalResults;
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
public class OvalResultsWorker
    extends Worker<String, OvalResults>
{

    /**
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( OvalResultsWorker.class );



    /**
     * Constructor.
     */
    public OvalResultsWorker(
                    final DataStore store
                    )
    {
        super( OvalResults.class, store );
    }



    /**
     */
    private void _syncRelated(
                    final OvalResults ovalResults
                    )
    throws PersistenceException
    {
        if (_LOG.isTraceEnabled()) {
            _LOG.trace( "*** sync related objects ***" );
        }

        OvalDefinitions  ovalDefs = ovalResults.getOvalDefinitions();
        if (ovalDefs != null) {
            _getStore().sync( OvalDefinitions.class, ovalDefs );
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
                    final OvalResults object
                    )
    throws PersistenceException
    {
        String  pid = object.getPersistentID();

//        OvalDefinitions  ovalDefs = ovalResults.getOvalDefinitions();
//        if (ovalDefs != null) {
//            _getStore().sync( OvalDefinitions.class, ovalDefs );
//        }
//
//        Definitions  defs = new Definitions();
//        Collection<Definition>  p_defs = _loadRelatedEntity(
//                        pid, Definition.class, OvalDefinitionsDefinitionAssociationEntry.class );
//        if (p_defs.size() > 0) {
//            defs.addAll( p_defs );
//        }
//
//        Tests  tests = new Tests();
//        Collection<Test>  p_tests = _loadRelatedEntity(
//                        pid, Test.class, OvalDefinitionsTestAssociationEntry.class );
//        if (p_tests.size() > 0) {
//            tests.addAll( p_tests );
//        }
//
//        SystemObjects  sysobjs = new SystemObjects();
//        Collection<SystemObject>  p_sysobjs = _loadRelatedEntity(
//                        pid, SystemObject.class, OvalDefinitionsSystemObjectAssociationEntry.class );
//        if (p_sysobjs.size() > 0) {
//            sysobjs.addAll( p_sysobjs );
//        }
//
//        States  states = new States();
//        Collection<State>  p_states = _loadRelatedEntity(
//                        pid, State.class, OvalDefinitionsStateAssociationEntry.class );
//        if (p_states.size() > 0) {
//            states.addAll( p_states );
//        }
//
//        Variables  variables = new Variables();
//        Collection<Variable>  p_variables = _loadRelatedEntity(
//                        pid, Variable.class, OvalDefinitionsVariableAssociationEntry.class );
//        if (p_variables.size() > 0) {
//            variables.addAll( p_variables );
//        }
//
//        object.setDefinitions( defs );
//        object.setTests( tests );
//        object.setObjects( sysobjs );
//        object.setStates( states );
//        object.setVariables( variables );

    }



    //**************************************************************
    // StoreWorker
    //**************************************************************

    @Override
    public String create(
                    final OvalResults object
                    )
    throws PersistenceException
    {
        _syncRelated( object );

        return _getStore().create( getObjectType(), object );
    }



    @Override
    public OvalResults sync(
                    final OvalResults object
                    )
    throws PersistenceException
    {
        _syncRelated( object );
//        _syncAssociation( store, object );

        return _getStore().sync( getObjectType(), object );
    }



    @Override
    public OvalResults load(
                    final String identity
                    )
    throws PersistenceException
    {
        OvalResults  ovalResults = _getStore().load( getObjectType(), identity );
        _loadRelated( ovalResults );

        return ovalResults;
    }

}
// OvalResultsWorker

