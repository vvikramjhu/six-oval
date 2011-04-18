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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.Collection;



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
    private static Log  _LOG = LogFactory.getLog( OvalDefinitionsStoreWorker.class );



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
        if (_LOG.isTraceEnabled()) {
            _LOG.trace( "*** beforePersist ***" );
        }

        Variables  variables = ovalDefs.getVariables();
        if (variables != null) {
            for (Variable  variable : variables) {
                _sync( Variable.class, variable );
            }
        }

        SystemObjects  sysobjs = ovalDefs.getObjects();
        if (sysobjs != null) {
            for (SystemObject  sysobj : sysobjs) {
                _sync( SystemObject.class, sysobj );
            }
        }

        States  states = ovalDefs.getStates();
        if (states != null) {
            for (State  state : states) {
                _sync( State.class, state );
            }
        }

        Tests  tests = ovalDefs.getTests();
        if (tests != null) {
            for (Test  test : tests) {
                _sync( Test.class, test );
            }
        }

        Definitions  definitions = ovalDefs.getDefinitions();
        if (definitions != null) {
            for (Definition  d : definitions) {
                _sync( Definition.class, d );
            }
        }
    }



    @Override
    protected void _afterLoad(
                    final OvalDefinitions ovalDefs
                    )
    throws PersistenceException
    {
        if (_LOG.isTraceEnabled()) {
            _LOG.trace( "*** afterLoad ***" );
        }

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

}
// OvalDefinitionsStoreWorker

