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
import jp.go.aist.six.util.BeansUtil;
import jp.go.aist.six.util.castor.CastorDao;
import jp.go.aist.six.util.persist.PersistenceException;
import java.util.UUID;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalDefinitionsSmallDao
    extends CastorDao<String, OvalDefinitions>
{

//    /**
//     * Logger.
//     */
//    private static Log  _LOG = LogFactory.getLog( OvalDefinitionsDao.class );



    /**
     * Constructor.
     */
    public OvalDefinitionsSmallDao()
    {
        this( OvalDefinitions.class );
    }



    /**
     * Constructor.
     */
    public OvalDefinitionsSmallDao(
                    final Class<? extends OvalDefinitions> type
                    )
    {
        this( type, new OvalDefinitionsHelper() );
    }



    /**
     * Constructor.
     */
    public OvalDefinitionsSmallDao(
                    final Class<? extends OvalDefinitions> type,
                    final OvalDefinitionsHelper helper
                    )
    {
        super( type, helper );
    }



    /**
     */
    protected void _beforePersist(
                    final OvalDefinitions ovalDefs
                    )
    throws PersistenceException
    {
        if (ovalDefs.getPersistentID() == null) {
            String  uuid = UUID.randomUUID().toString();
            ovalDefs.setPersistentID( uuid );
        }


        Definitions  definitions = ovalDefs.getDefinitions();
        if (definitions != null  &&  definitions.size() > 0) {
            for (Definition  def : definitions) {
                OvalDefinitionsDefinitionAssociationEntry  assoc =
                    new OvalDefinitionsDefinitionAssociationEntry( ovalDefs, def );
                _sync( OvalDefinitionsDefinitionAssociationEntry.class, assoc );
            }
        }

    }



    //**************************************************************
    //  Dao, CastorDao
    //**************************************************************

    @Override
    protected void _createRelatedTo(
                    final OvalDefinitions object
                    )
    throws PersistenceException
    {
        final OvalDefinitions  ovalDefs = object;

        _beforePersist( ovalDefs );

        SystemObjects  sysobjs = ovalDefs.getObjects();
        if (sysobjs != null  &&  sysobjs.size() > 0) {
            SystemObjects  p_sysobjs = new SystemObjects();
            for (SystemObject  sysobj : sysobjs) {
                SystemObject  p_sysobj = _loadOrCreate( SystemObject.class, sysobj );
                p_sysobjs.add( p_sysobj );
            }
            ovalDefs.setObjects( p_sysobjs );
        }


        States  states = ovalDefs.getStates();
        if (states != null  &&  states.size() > 0) {
            States  p_states = new States();
            for (State  state : states) {
                State  p_state = _loadOrCreate( State.class, state );
                p_states.add( p_state );
            }
            ovalDefs.setStates( p_states );
        }


        Variables  vars = ovalDefs.getVariables();
        if (vars != null  &&  vars.size() > 0) {
            Variables  p_vars = new Variables();
            for (Variable  var : vars) {
                Variable  p_var = _loadOrCreate( Variable.class, var );
                p_vars.add( p_var );
            }
            ovalDefs.setVariables( p_vars );
        }


        Tests  tests = ovalDefs.getTests();
        if (tests != null  &&  tests.size() > 0) {
            Tests  p_tests = new Tests();
            for (Test  test : tests) {
                Test  p_test = _loadOrCreate( Test.class, test );
                p_tests.add( p_test );
            }
            ovalDefs.setTests( p_tests );
        }


//        Definitions  definitions = defs.getDefinitions();
//        if (definitions != null  &&  definitions.size() > 0) {
//            Definitions  p_definitions = new Definitions();
//            for (Definition  def : definitions) {
//                Definition  p_def = _loadOrCreate( Definition.class, def );
//                p_definitions.add( p_def );
//            }
//            defs.setDefinitions( p_definitions );
//        }
    }



    @Override
    protected void _updateDeeply(
                    final OvalDefinitions object
                    )
    throws PersistenceException
    {
        final OvalDefinitions  defs = object;

        SystemObjects  sysobjs = defs.getObjects();
        if (sysobjs != null  &&  sysobjs.size() > 0) {
            for (SystemObject  sysobj : sysobjs) {
                _update( SystemObject.class, sysobj );
            }
        }

        States  states = defs.getStates();
        if (states != null  &&  states.size() > 0) {
            for (State  state : states) {
                _update( State.class, state );
            }
        }

        Variables  vars = defs.getVariables();
        if (vars != null  &&  vars.size() > 0) {
            for (Variable  var : vars) {
                _update( Variable.class, var );
            }
        }

        Tests  tests = defs.getTests();
        if (tests != null  &&  tests.size() > 0) {
            for (Test  test : tests) {
                _update( Test.class, test );
            }
        }

        Definitions  definitions = defs.getDefinitions();
        if (definitions != null  &&  definitions.size() > 0) {
            for (Definition  def : definitions) {
                _update( Definition.class, def );
            }
        }
    }



    protected static final String[]  _EXCEPTED_PROPERTIES_ =
        new String[] {
        "persistentID",
        "objects",
        "states",
        "tests",
        "variables"
        };


    @Override
    protected void _copyProperties(
                    final OvalDefinitions p_object,
                    final OvalDefinitions object
                    )
    {
        if (p_object == null) {
            return;
        }

        BeansUtil.copyPropertiesExcept(
                        p_object, object, _EXCEPTED_PROPERTIES_ );
    }



    @Override
    protected void _syncDeeply(
                    final OvalDefinitions object,
                    final OvalDefinitions p_object
                    )
    throws PersistenceException
    {
        super._syncDeeply( object, p_object );
        _beforePersist( object );

        SystemObjects  sysobjs = object.getObjects();
        SystemObjects  p_sysobjs = new SystemObjects();
        if (sysobjs != null  &&  sysobjs.size() > 0) {
            for (SystemObject  sysobj : sysobjs) {
                SystemObject  p_sysobj = _sync( SystemObject.class, sysobj );
                if (p_sysobj == null) {
                    p_sysobjs.add( sysobj );
                } else {
                    p_sysobjs.add( p_sysobj );
                }
            }
        }

        States  states = object.getStates();
        States  p_states = new States();
        if (states != null  &&  states.size() > 0) {
            for (State  state : states) {
                State  p_state = _sync( State.class, state );
                if (p_state == null) {
                    p_states.add( state );
                } else {
                    p_states.add( p_state );
                }
            }
        }

        Variables  vars = object.getVariables();
        Variables  p_vars = new Variables();
        if (vars != null  &&  vars.size() > 0) {
            for (Variable  var : vars) {
                Variable  p_var = _sync( Variable.class, var );
                if (p_var == null) {
                    p_vars.add( var );
                } else {
                    p_vars.add( p_var );
                }
            }
        }

        Tests  tests = object.getTests();
        Tests  p_tests = new Tests();
        if (tests != null  &&  tests.size() > 0) {
            for (Test  test : tests) {
                Test  p_test = _sync( Test.class, test );
                if (p_test == null) {
                    p_tests.add( test );
                } else {
                    p_tests.add( p_test );
                }
            }
        }

//        Definitions  definitions = object.getDefinitions();
//        Definitions  p_definitions = new Definitions();
//        if (definitions != null  &&  definitions.size() > 0) {
//            for (Definition  def : definitions) {
//                Definition  p_def = _sync( Definition.class, def );
//                if (p_def == null) {
//                    p_definitions.add( def );
//                } else {
//                    p_definitions.add( p_def );
//                }
//            }
//        }


        if (p_object == null) {
            object.setObjects( p_sysobjs );
            object.setStates( p_states );
            object.setVariables( p_vars );
            object.setTests( p_tests );
//            object.setDefinitions( p_definitions );
        } else {
            p_object.setObjects( p_sysobjs );
            p_object.setStates( p_states );
            p_object.setVariables( p_vars );
            p_object.setTests( p_tests );
//            p_object.setDefinitions( p_definitions );
        }
    }

}
// OvalDefinitionsDao
