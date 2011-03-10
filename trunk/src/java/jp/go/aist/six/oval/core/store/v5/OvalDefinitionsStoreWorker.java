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
import jp.go.aist.six.oval.model.v5.definitions.StateType;
import jp.go.aist.six.oval.model.v5.definitions.StatesType;
import jp.go.aist.six.oval.model.v5.definitions.SystemObjectType;
import jp.go.aist.six.oval.model.v5.definitions.SystemObjectsType;
import jp.go.aist.six.oval.model.v5.definitions.TestType;
import jp.go.aist.six.oval.model.v5.definitions.TestsType;
import jp.go.aist.six.oval.model.v5.definitions.VariableType;
import jp.go.aist.six.oval.model.v5.definitions.VariablesType;
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

        VariablesType  variables = ovalDefs.getVariables();
        if (variables != null) {
            for (VariableType  variable : variables) {
                _sync( VariableType.class, variable );
            }
        }

        SystemObjectsType  sysobjs = ovalDefs.getObjects();
        if (sysobjs != null) {
            for (SystemObjectType  sysobj : sysobjs) {
                _sync( SystemObjectType.class, sysobj );
            }
        }

        StatesType  states = ovalDefs.getStates();
        if (states != null) {
            for (StateType  state : states) {
                _sync( StateType.class, state );
            }
        }

        TestsType  tests = ovalDefs.getTests();
        if (tests != null) {
            _LOG_.debug( "#tests=" + tests.size() );
            for (TestType  test : tests) {
                _LOG_.debug( "test=" + test );
                _sync( TestType.class, test );
            }
        }

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

        TestsType  tests = new TestsType();
        Collection<TestType>  p_tests = _loadAssociated( pid, TestType.class,
                        OvalDefinitionsTestAssociationEntry.class );
        if (p_tests != null) {
            tests.addAll( p_tests );
        }

        SystemObjectsType  sysobjs = new SystemObjectsType();
        Collection<SystemObjectType>  p_sysobjs = _loadAssociated( pid, SystemObjectType.class,
                        OvalDefinitionsSystemObjectAssociationEntry.class );
        if (p_sysobjs != null) {
            sysobjs.addAll( p_sysobjs );
        }

        StatesType  states = new StatesType();
        Collection<StateType>  p_states = _loadAssociated( pid, StateType.class,
                        OvalDefinitionsStateAssociationEntry.class );
        if (p_states != null) {
            states.addAll( p_states );
        }

        VariablesType  variables = new VariablesType();
        Collection<VariableType>  p_variables = _loadAssociated( pid, VariableType.class,
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

}
// OvalDefinitionsStoreWorker

