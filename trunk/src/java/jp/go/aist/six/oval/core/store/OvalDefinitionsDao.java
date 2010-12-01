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
import jp.go.aist.six.util.castor.CastorDao;
import jp.go.aist.six.util.persist.PersistenceException;
import java.util.Collection;
import java.util.List;
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
        this( OvalDefinitions.class, new OvalDefinitionsHelper() );
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



    //**************************************************************
    //  Dao, CastorDao
    //**************************************************************

    @Override
    public String create(
                    final OvalDefinitions defs
                    )
    throws PersistenceException
    {
        if (defs.getPersistentID() == null) {
            String  uuid = UUID.randomUUID().toString();
            defs.setPersistentID( uuid );
        }

        Tests  tests = defs.getTests();
        if (tests != null) {
            Collection<Test>  test_list = tests.getTest();
            if (test_list != null  &&  test_list.size() > 0) {
                List<Test>  p_test_list =
                    getForwardingDao( Test.class ).syncAll( test_list );
                defs.setTests( new Tests( p_test_list ) );
            }
        }
//        Tests  test_list = defs.getTests();
//        if (test_list != null) {
//            Tests  p_tests = new Tests();
//            for (Test  test : test_list) {
//                Test  p_test = getForwardingDao( Test.class ).sync( test );
//                p_tests.addTest( p_test );
//                OvalDefinitionsTestAssociation  assoc =
//                    new OvalDefinitionsTestAssociation( defs, p_test );
//                getForwardingDao( OvalDefinitionsTestAssociation.class ).sync( assoc );
//            }
//
//            defs.setTests( p_tests );
//        }


        SystemObjects  objects = defs.getObjects();
        if (objects != null) {
            Collection<SystemObject>  object_list = objects.getObject();
            if (object_list != null  &&  object_list.size() > 0) {
                List<SystemObject>  p_object_list =
                    getForwardingDao( SystemObject.class ).syncAll( object_list );
                defs.setObjects( new SystemObjects( p_object_list ) );
            }
        }


        States  states = defs.getStates();
        if (states != null) {
            Collection<State>  state_list = states.getState();
            if (state_list != null  &&  state_list.size() > 0) {
                List<State>  p_state_list =
                    getForwardingDao( State.class ).syncAll( state_list );
                defs.setStates( new States( p_state_list ) );
            }
        }


        Variables  variables = defs.getVariables();
        if (variables != null) {
            Collection<Variable>  variable_list = variables.getVariable();
            if (variable_list != null  &&  variable_list.size() > 0) {
                List<Variable>  p_variable_list =
                    getForwardingDao( Variable.class ).syncAll( variable_list );
                defs.setVariables( new Variables( p_variable_list ) );
            }
        }


        Definitions  definitions = defs.getDefinitions();
        if (definitions != null) {
            Collection<Definition>  def_list = definitions.getDefinition();
            if (def_list != null  &&  def_list.size() > 0) {
                List<Definition>  p_def_list =
                    getForwardingDao( Definition.class ).syncAll( def_list );
                defs.setDefinitions( new Definitions( p_def_list ) );
            }
        }



////        OvalDefinitionsUtil  util = OvalDefinitionsUtil.newInstance( defs );
//        Definitions  def_list = defs.getDefinitions();
//        if (def_list != null) {
//            Definitions  p_def_list = new Definitions();
//            for (Definition  def : def_list) {
//                if (_LOG.isInfoEnabled()) {
//                    _LOG.info( "creating Definition: " + def.getOvalID() );
//                }
//                Definition  p_def = getForwardingDao( Definition.class ).sync( def );
//                p_def_list.addDefinition( p_def );
//
//                OvalDefinitionsDefinitionAssociation  assoc =
//                    new OvalDefinitionsDefinitionAssociation( defs, p_def );
//                getForwardingDao( OvalDefinitionsDefinitionAssociation.class ).sync( assoc );
//
//                //TODO: move this part to DefinitionDao,
//                // and create 1:N definition-Criteria relation?
////                final String  defID = def.getOvalID();
////                Collection<String>  testIDs = util.getRelatedTestIDOfDefinition( defID );
////                for (String  testID : testIDs) {
////                    DefinitionTestAssociation  dt_assoc =
////                        new DefinitionTestAssociation( def, defs.getTest( testID ) );
////                    getForwardingDao( DefinitionTestAssociation.class ).sync( dt_assoc );
////                }
//            }
//            defs.setDefinitions( p_def_list );
//        }

        return super.create( defs );
    }

}
// OvalDefinitionsDao
