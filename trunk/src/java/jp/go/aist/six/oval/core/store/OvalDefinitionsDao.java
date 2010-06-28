/*
 *  @ProductName@
 *  Copyright (C) @CopyrightYear@
 *    National Institute of Advanced Industrial Science and Technology (AIST)
 *    Registration Number: @AISTRegistrationNumber@
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

import jp.go.aist.six.oval.core.model.definition.DefinitionTestAssociation;
import jp.go.aist.six.oval.core.model.definition.OvalDefinitionsDefinitionAssociation;
import jp.go.aist.six.oval.core.model.definition.OvalDefinitionsHelper;
import jp.go.aist.six.oval.core.model.definition.OvalDefinitionsObjectAssociation;
import jp.go.aist.six.oval.core.model.definition.OvalDefinitionsTestAssociation;
import jp.go.aist.six.oval.model.definition.Definition;
import jp.go.aist.six.oval.model.definition.Definitions;
import jp.go.aist.six.oval.model.definition.OvalDefinitions;
import jp.go.aist.six.oval.model.definition.SystemObject;
import jp.go.aist.six.oval.model.definition.SystemObjects;
import jp.go.aist.six.oval.model.definition.Test;
import jp.go.aist.six.oval.model.definition.Tests;
import jp.go.aist.six.util.castor.CastorDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.Collection;
import java.util.UUID;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalDefinitionsDao
    extends CastorDao<OvalDefinitions>
{

    /**
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( OvalDefinitionsDao.class );



    /**
     * Constructor.
     */
    public OvalDefinitionsDao()
    {
        // Which is correct???

        super( OvalDefinitions.class );

        // IMPORTANT:
        // If we use the interface type, instances can NOT be loaded.
        // This is because the Castor JDO mapping does NOT include
        // mapping for the interface type.
//        super( OvalDefinitions.class );
    }



    //**************************************************************
    //  Dao, CastorDao
    //**************************************************************

    @Override
    public Object create(
                    final OvalDefinitions defs
                    )
    {
        if (defs.getPersistentID() == null) {
            String  uuid = UUID.randomUUID().toString();
            defs.setPersistentID( uuid );
        }

        Tests  test_list = defs.getTests();
        if (test_list != null) {
            Tests  p_tests = new Tests();
            for (Test  test : test_list) {
                Test  p_test = getForwardingDao( Test.class ).sync( test );
                p_tests.add( p_test );
                OvalDefinitionsTestAssociation  assoc =
                    new OvalDefinitionsTestAssociation( defs, p_test );
                getForwardingDao( OvalDefinitionsTestAssociation.class ).sync( assoc );
            }

            defs.setTests( p_tests );
        }


        SystemObjects  objects = defs.getObjects();
        if (objects != null) {
            SystemObjects  p_objects = new SystemObjects();
            for (SystemObject  object : objects) {
                SystemObject  p_object = getForwardingDao( SystemObject.class ).sync( object );
                p_objects.add( p_object );
                OvalDefinitionsObjectAssociation  assoc =
                    new OvalDefinitionsObjectAssociation( defs, p_object );
                getForwardingDao( OvalDefinitionsObjectAssociation.class ).sync( assoc );
            }

            defs.setObjects( p_objects );
        }


//        Collection<SystemObject>  object_list = defs.getObjects().getElements();
//        if (object_list != null  &&  object_list.size() > 0) {
//            List<SystemObject>  p_object_list = new ArrayList<SystemObject>();
//            for (SystemObject  object : object_list) {
////                if (_LOG.isTraceEnabled()) {
////                    _LOG.trace( "object: " + object );
////                }
//                SystemObject  p_object = getForwardingDao().sync( SystemObject.class, object );
//                p_object_list.add( p_object );
//
//                OvalDefinitionsObjectAssociation  assoc =
//                    new OvalDefinitionsObjectAssociation( defs, p_object );
//                getForwardingDao().sync( OvalDefinitionsObjectAssociation.class, assoc );
//            }
//            defs.setObjects( p_object_list );
//        }

        OvalDefinitionsHelper  helper = OvalDefinitionsHelper.newInstance( defs );
        Definitions  def_list = defs.getDefinitions();
        if (def_list != null) {
            Definitions  p_def_list = new Definitions();
            for (Definition  def : def_list) {
                if (_LOG.isInfoEnabled()) {
                    _LOG.info( "creating Definition: " + def.getOvalID() );
                }
                Definition  p_def = getForwardingDao( Definition.class ).sync( def );
                p_def_list.add( p_def );

                OvalDefinitionsDefinitionAssociation  assoc =
                    new OvalDefinitionsDefinitionAssociation( defs, p_def );
                getForwardingDao( OvalDefinitionsDefinitionAssociation.class ).sync( assoc );

                final String  defID = def.getOvalID();
                Collection<String>  testIDs = helper.getTestsOfDefinition( defID );
                for (String  testID : testIDs) {
                    DefinitionTestAssociation  dt_assoc =
                        new DefinitionTestAssociation( def, defs.getTest( testID ) );
                    getForwardingDao( DefinitionTestAssociation.class ).sync( dt_assoc );
                }
            }
            defs.setDefinitions( p_def_list );
        }

        return super.create( defs );
    }

}
// OvalDefinitionsDao
