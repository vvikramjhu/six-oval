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
public class OvalDefinitionsDao
    extends CastorDao<String, OvalDefinitions>
{

//    /**
//     * Logger.
//     */
//    private static Log  _LOG = LogFactory.getLog( OvalDefinitionsDao.class );



    /**
     * Constructor.
     */
    public OvalDefinitionsDao()
    {
        this( OvalDefinitions.class );
    }



    /**
     * Constructor.
     */
    public OvalDefinitionsDao(
                    final Class<? extends OvalDefinitions> type
                    )
    {
        this( type, new OvalDefinitionsHelper() );
    }



    /**
     * Constructor.
     */
    public OvalDefinitionsDao(
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
        String  ovalDefsPID = ovalDefs.getPersistentID();
        if (ovalDefsPID == null) {
            ovalDefsPID = UUID.randomUUID().toString();
            ovalDefs.setPersistentID( ovalDefsPID );
        }


        Variables  variables = ovalDefs.getVariables();
        if (variables != null) {
            for (Variable  variable : variables) {
                OvalDefinitionsVariableAssociationEntry  assoc =
                    new OvalDefinitionsVariableAssociationEntry(
                                    ovalDefsPID, variable.getPersistentID() );
                _sync( OvalDefinitionsVariableAssociationEntry.class, assoc );
            }
        }

        States  states = ovalDefs.getStates();
        if (states != null) {
            for (State  state : states) {
                OvalDefinitionsStateAssociationEntry  assoc =
                    new OvalDefinitionsStateAssociationEntry(
                                    ovalDefsPID, state.getPersistentID() );
                _sync( OvalDefinitionsStateAssociationEntry.class, assoc );
            }
        }

        SystemObjects  sysobjs = ovalDefs.getObjects();
        if (sysobjs != null) {
            for (SystemObject  sysobj : sysobjs) {
                OvalDefinitionsSystemObjectAssociationEntry  assoc =
                    new OvalDefinitionsSystemObjectAssociationEntry(
                                    ovalDefsPID, sysobj.getPersistentID() );
                _sync( OvalDefinitionsSystemObjectAssociationEntry.class, assoc );
            }
        }

        Tests  tests = ovalDefs.getTests();
        if (tests != null) {
            for (Test  test : tests) {
                OvalDefinitionsTestAssociationEntry  assoc =
                    new OvalDefinitionsTestAssociationEntry(
                                    ovalDefsPID, test.getPersistentID() );
                _sync( OvalDefinitionsTestAssociationEntry.class, assoc );
            }
        }

        Definitions  definitions = ovalDefs.getDefinitions();
        if (definitions != null) {
            for (Definition  def : definitions) {
                OvalDefinitionsDefinitionAssociationEntry  assoc =
                    new OvalDefinitionsDefinitionAssociationEntry(
                                    ovalDefsPID, def.getPersistentID() );
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
        _beforePersist( object );
    }



    @Override
    protected void _updateDeeply(
                    final OvalDefinitions object
                    )
    throws PersistenceException
    {
        final OvalDefinitions  defs = object;

        Variables  vars = defs.getVariables();
        if (vars != null  &&  vars.size() > 0) {
            for (Variable  var : vars) {
                _update( Variable.class, var );
            }
        }

        States  states = defs.getStates();
        if (states != null  &&  states.size() > 0) {
            for (State  state : states) {
                _update( State.class, state );
            }
        }

        SystemObjects  sysobjs = defs.getObjects();
        if (sysobjs != null  &&  sysobjs.size() > 0) {
            for (SystemObject  sysobj : sysobjs) {
                _update( SystemObject.class, sysobj );
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
        "generator",
        "definitionsDigest" //,
//        "definitions",
//        "objects",
//        "states",
//        "tests",
//        "variables"
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
    }

}
// OvalDefinitionsDao
