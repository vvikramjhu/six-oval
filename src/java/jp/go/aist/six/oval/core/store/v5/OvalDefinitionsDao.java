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

import java.util.UUID;
import jp.go.aist.six.oval.model.v5.common.GeneratorType;
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
import jp.go.aist.six.util.BeansUtil;
import jp.go.aist.six.util.castor.CastorDao;
import jp.go.aist.six.util.castor.PersistenceHelper;
import jp.go.aist.six.util.persist.PersistenceException;



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


    public OvalDefinitionsDao(
                    final Class<? extends OvalDefinitions> type
                    )
    {
        this( type, new OvalDefinitionsHelper() );
    }


    public OvalDefinitionsDao(
                    final Class<? extends OvalDefinitions> type,
                    final OvalDefinitionsHelper helper
                    )
    {
        super( type, helper );
    }


    /**
     */
    private void _computeDigests(
                    final OvalDefinitions ovalDefs
                    )
    {
        String  digest = ovalDefs.getDefinitionsDigest();
        if (digest == null) {
            DefinitionsType  defs = ovalDefs.getDefinitions();
            if (defs != null) {
                digest = defs.getDigest();
                ovalDefs.setDefinitionsDigest( digest );
            }
        }
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

        _computeDigests( ovalDefs );

        VariablesType  variables = ovalDefs.getVariables();
        if (variables != null) {
            for (VariableType  variable : variables) {
                OvalDefinitionsVariableAssociationEntry  assoc =
                    new OvalDefinitionsVariableAssociationEntry(
                                    ovalDefsPID, variable.getPersistentID() );
                _sync( OvalDefinitionsVariableAssociationEntry.class, assoc );
            }
        }

        StatesType  states = ovalDefs.getStates();
        if (states != null) {
            for (StateType  state : states) {
                OvalDefinitionsStateAssociationEntry  assoc =
                    new OvalDefinitionsStateAssociationEntry(
                                    ovalDefsPID, state.getPersistentID() );
                _sync( OvalDefinitionsStateAssociationEntry.class, assoc );
            }
        }

        SystemObjectsType  sysobjs = ovalDefs.getObjects();
        if (sysobjs != null) {
            for (SystemObjectType  sysobj : sysobjs) {
                OvalDefinitionsSystemObjectAssociationEntry  assoc =
                    new OvalDefinitionsSystemObjectAssociationEntry(
                                    ovalDefsPID, sysobj.getPersistentID() );
                _sync( OvalDefinitionsSystemObjectAssociationEntry.class, assoc );
            }
        }

        TestsType  tests = ovalDefs.getTests();
        if (tests != null) {
            for (TestType  test : tests) {
                OvalDefinitionsTestAssociationEntry  assoc =
                    new OvalDefinitionsTestAssociationEntry(
                                    ovalDefsPID, test.getPersistentID() );
                _sync( OvalDefinitionsTestAssociationEntry.class, assoc );
            }
        }

        DefinitionsType  definitions = ovalDefs.getDefinitions();
        if (definitions != null) {
            for (DefinitionType  def : definitions) {
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
    protected void _daoBeforeCreate(
                    final OvalDefinitions object
                    )
    throws PersistenceException
    {
        _beforePersist( object );
    }



    @Override
    protected void _daoBeforeUpdate(
                    final OvalDefinitions object
                    )
    throws PersistenceException
    {
        final OvalDefinitions  ovalDefs = object;

        VariablesType  vars = ovalDefs.getVariables();
        if (vars != null  &&  vars.size() > 0) {
            for (VariableType  var : vars) {
                _update( VariableType.class, var );
            }
        }

        StatesType  states = ovalDefs.getStates();
        if (states != null  &&  states.size() > 0) {
            for (StateType  state : states) {
                _update( StateType.class, state );
            }
        }

        SystemObjectsType  sysobjs = ovalDefs.getObjects();
        if (sysobjs != null  &&  sysobjs.size() > 0) {
            for (SystemObjectType  sysobj : sysobjs) {
                _update( SystemObjectType.class, sysobj );
            }
        }

        TestsType  tests = ovalDefs.getTests();
        if (tests != null  &&  tests.size() > 0) {
            for (TestType  test : tests) {
                _update( TestType.class, test );
            }
        }

        DefinitionsType  definitions = ovalDefs.getDefinitions();
        if (definitions != null  &&  definitions.size() > 0) {
            for (DefinitionType  def : definitions) {
                _update( DefinitionType.class, def );
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
    protected void _syncProperties(
                    final OvalDefinitions object,
                    final OvalDefinitions p_object
                    )
    {
        if (p_object == null) {
            return;
        }

        BeansUtil.copyPropertiesExcept(
                        p_object, object, _EXCEPTED_PROPERTIES_ );
    }



    @Override
    protected void _daoBeforeSync(
                    final OvalDefinitions object,
                    final OvalDefinitions p_object
                    )
    throws PersistenceException
    {
//        super._syncDeeply( object, p_object );
        _beforePersist( object );
    }




    /**
     */
    public static class OvalDefinitionsHelper
        extends PersistenceHelper<OvalDefinitions>
    {

        public OvalDefinitionsHelper()
        {
        }



        //**************************************************************
        //  PersistenceHelper
        //**************************************************************

        @Override
        public boolean hasUnique()
        {
            return true;
        }



        @Override
        public Object getUnique(
                        final OvalDefinitions object
                        )
        {
            GeneratorType  generator = object.getGenerator();
            String  digest = object.getDefinitionsDigest();

            return (new Object[] {
                            generator.getSchemaVersion(),
                            generator.getTimestamp(),
                            generator.getProductName(),
                            digest
            });
        }



        @Override
        public String getUniqueFilter()
        {
            return "WHERE o.generator.schemaVersion = $1 AND o.generator.timestamp = $2 AND o.generator.productName = $3 AND o.definitionsDigest = $4";
        }

    }
    // OvalDefinitionsHelper

}
// OvalDefinitionsDao
