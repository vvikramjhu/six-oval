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

package jp.go.aist.six.oval.core.store.v5;

import java.util.Collection;
import jp.go.aist.six.oval.core.store.StoreWorker;
import jp.go.aist.six.oval.core.store.StoreWorkerRegistry;
import jp.go.aist.six.oval.model.v5.definitions.DefinitionType;
import jp.go.aist.six.oval.model.v5.definitions.DefinitionsType;
import jp.go.aist.six.oval.model.v5.definitions.OvalDefinitions;
import jp.go.aist.six.util.persist.DataStore;
import jp.go.aist.six.util.persist.PersistenceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalDefinitionsStoreWorker
    extends StoreWorker<String, OvalDefinitions>
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ = LoggerFactory.getLogger( OvalDefinitionsStoreWorker.class );



    /**
     * Constructor.
     */
    public OvalDefinitionsStoreWorker(
                    final DataStore store
                    )
    {
        this( store, null );
    }



    /**
     * Constructor.
     */
    public OvalDefinitionsStoreWorker(
                    final DataStore store,
                    final StoreWorkerRegistry registry
                    )
    {
        super( OvalDefinitions.class, store, registry );
    }



    //**************************************************************
    // StoreWorker
    //**************************************************************

    @Override
    protected void _beforePersist(
                    final OvalDefinitions ovalDefs
                    )
    throws PersistenceException
    {
        if (_LOG_.isTraceEnabled()) {
            _LOG_.trace( "*** beforePersist ***" );
        }

//        Variables  variables = ovalDefs.getVariables();
//        if (variables != null) {
//            for (Variable  variable : variables) {
//                _sync( Variable.class, variable );
//            }
//        }
//
//        SystemObjects  sysobjs = ovalDefs.getObjects();
//        if (sysobjs != null) {
//            for (SystemObject  sysobj : sysobjs) {
//                _sync( SystemObject.class, sysobj );
//            }
//        }
//
//        States  states = ovalDefs.getStates();
//        if (states != null) {
//            for (State  state : states) {
//                _sync( State.class, state );
//            }
//        }
//
//        Tests  tests = ovalDefs.getTests();
//        if (tests != null) {
//            for (Test  test : tests) {
//                _sync( Test.class, test );
//            }
//        }
//
        DefinitionsType  definitions = ovalDefs.getDefinitions();
        if (definitions != null) {
            for (DefinitionType  d : definitions) {
                _sync( DefinitionType.class, d );
            }
        }
    }



    @Override
    protected void _afterLoad(
                    final OvalDefinitions ovalDefs
                    )
    throws PersistenceException
    {
        if (_LOG_.isTraceEnabled()) {
            _LOG_.trace( "*** afterLoad ***" );
        }

        final String  pid = ovalDefs.getPersistentID();

        DefinitionsType  defs = new DefinitionsType();
        Collection<DefinitionType>  p_defs = _loadAssociated( pid, DefinitionType.class,
                            OvalDefinitionsDefinitionAssociationEntry.class );
        if (p_defs != null) {
            defs.addAll( p_defs );
        }

//        Tests  tests = new Tests();
//        Collection<Test>  p_tests = _loadAssociated( pid, Test.class,
//                        OvalDefinitionsTestAssociationEntry.class );
//        if (p_tests != null) {
//            tests.addAll( p_tests );
//        }
//
//        SystemObjects  sysobjs = new SystemObjects();
//        Collection<SystemObject>  p_sysobjs = _loadAssociated( pid, SystemObject.class,
//                        OvalDefinitionsSystemObjectAssociationEntry.class );
//        if (p_sysobjs != null) {
//            sysobjs.addAll( p_sysobjs );
//        }
//
//        States  states = new States();
//        Collection<State>  p_states = _loadAssociated( pid, State.class,
//                        OvalDefinitionsStateAssociationEntry.class );
//        if (p_states != null) {
//            states.addAll( p_states );
//        }
//
//        Variables  variables = new Variables();
//        Collection<Variable>  p_variables = _loadAssociated( pid, Variable.class,
//                        OvalDefinitionsVariableAssociationEntry.class );
//        if (p_variables != null) {
//            variables.addAll( p_variables );
//        }
//
        ovalDefs.setDefinitions( defs );
//        ovalDefs.setTests( tests );
//        ovalDefs.setObjects( sysobjs );
//        ovalDefs.setStates( states );
//        ovalDefs.setVariables( variables );
    }

}
// OvalDefinitionsStoreWorker

