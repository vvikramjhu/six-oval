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

import jp.go.aist.six.oval.model.sc.CollectedSystemObject;
import jp.go.aist.six.oval.model.sc.CollectedSystemObjects;
import jp.go.aist.six.oval.model.sc.Item;
import jp.go.aist.six.oval.model.sc.ItemReference;
import jp.go.aist.six.oval.model.sc.NetInterface;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import jp.go.aist.six.oval.model.sc.SystemData;
import jp.go.aist.six.oval.model.sc.SystemInfo;
import jp.go.aist.six.oval.model.sc.VariableValue;
import jp.go.aist.six.util.BeansUtil;
import jp.go.aist.six.util.castor.CastorDao;
import jp.go.aist.six.util.persist.PersistenceException;
import java.util.Collection;
import java.util.UUID;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalSystemCharacteristicsDao
    extends CastorDao<String, OvalSystemCharacteristics>
{

    /**
     * Constructor.
     */
    public OvalSystemCharacteristicsDao()
    {
        super( OvalSystemCharacteristics.class );
    }



    /**
     */
    protected void _beforePersist(
                    final OvalSystemCharacteristics ovalSC
                    )
    throws PersistenceException
    {
        if (ovalSC.getPersistentID() == null) {
            String  uuid = UUID.randomUUID().toString();
            ovalSC.setPersistentID( uuid );
        }
    }



    /**
     */
    private void _associateDependents(
                    final OvalSystemCharacteristics ovalSC
                    )
    throws PersistenceException
    {
        SystemInfo  sysinfo = ovalSC.getSystemInfo(); //{1..1}
        sysinfo.setMasterObject( ovalSC );

        for (NetInterface  netif : sysinfo.getInterfaces()) {
            netif.setMasterObject( ovalSC );
        }


        SystemData  sd = ovalSC.getSystemData();
        if (sd != null) {
            for (Item  item : sd) {
                item.setMasterObject( ovalSC );
            }
        }


        CollectedSystemObjects  sysobjs = ovalSC.getCollectedObjects();
        if (sysobjs != null) {
            for (CollectedSystemObject  sysobj : sysobjs) {
                sysobj.setMasterObject( ovalSC );

                Collection<VariableValue>  vvs = sysobj.getVariableValue();
                if (vvs != null) {
                    for (VariableValue  vv : vvs) {
                        vv.setMasterObject( sysobj );
                    }
                }

                Collection<ItemReference>  references = sysobj.getReference();
                if (references != null) {
                    for (ItemReference  reference : references) {
                        reference.setMasterObject( sysobj );
                    }
                }
            }
        }
    }



    //**************************************************************
    //  Dao, CastorDao
    //**************************************************************

    @Override
    protected void _daoBeforeCreate(
                    final OvalSystemCharacteristics object
                    )
    throws PersistenceException
    {
        _beforePersist( object );
        _associateDependents( object );
    }



    @Override
    protected void _daoBeforeUpdate(
                    final OvalSystemCharacteristics object
                    )
    throws PersistenceException
    {
        _associateDependents( object );
    }



    private static final String[]  _EXCEPTED_PROPERTIES_ =
        new String[] {
        "persistentID",
//        "systemInfo",
//        "systemData",
//        "collectedObjects"
        };


//    private static final String[]  _EXCEPTED_PROPERTIES_SYSTEMINFO_ =
//        new String[] {
//        "interfaces"
//        };


    @Override
    protected void _syncProperties(
                    final OvalSystemCharacteristics object,
                    final OvalSystemCharacteristics p_object
                    )
    {
        if (p_object == null) {
            return;
        }

        final OvalSystemCharacteristics  sc = object;
        final OvalSystemCharacteristics  p_sc = p_object;
        BeansUtil.copyPropertiesExcept( p_sc, sc, _EXCEPTED_PROPERTIES_ );

//        final SystemInfo  sysinfo = sc.getSystemInfo();
//        final SystemInfo  p_sysinfo = p_sc.getSystemInfo();
//        BeansUtil.copyPropertiesExcept( p_sysinfo, sysinfo, _EXCEPTED_PROPERTIES_SYSTEMINFO_ );
//        p_sysinfo.setInterfaces( sysinfo.getInterfaces() );
//
//        p_sc.setSystemData( sc.getSystemData() );
//
//        p_sc.setCollectedObjects( sc.getCollectedObjects() );


//        _associateDependents( p_sc );
    }



    @Override
    protected void _daoBeforeSync(
                    final OvalSystemCharacteristics object,
                    final OvalSystemCharacteristics p_object
                    )
    throws PersistenceException
    {
//        super._syncDeeply( object, p_object );
        _associateDependents( object );
        _beforePersist( object );
    }

//    // workaround:
//    @Override
//    public OvalSystemCharacteristics get(
//                    final Object identity
//                    )
//    {
//        List<OvalSystemCharacteristics>  p_objects = find(
//                        RelationalBinding.equalBinding( "persistentID", identity ) );
//        return (p_objects.size() == 0 ? null : p_objects.get( 0 ) );
//    }

}
// OvalSystemCharacteristicsDao
