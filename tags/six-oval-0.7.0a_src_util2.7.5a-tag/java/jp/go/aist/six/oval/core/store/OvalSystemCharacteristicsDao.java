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



    //**************************************************************
    //  Dao, CastorDao
    //**************************************************************

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



    @Override
    public String create(
                    final OvalSystemCharacteristics sc
                    )
    throws PersistenceException
    {
        if (sc.getPersistentID() == null) {
            String  uuid = UUID.randomUUID().toString();
            sc.setPersistentID( uuid );
        }

        SystemInfo  sysinfo = sc.getSystemInfo();
        sysinfo.setMasterObject( sc );

        for (NetInterface  netif : sysinfo.getInterfaces()) {
            netif.setMasterObject( sc );
//            netif.setMasterObject( sysinfo );
        }


        SystemData  sd = sc.getSystemData();
        if (sd != null  &&  sd.size() > 0) {
            for (Item  item : sd) {
                item.setMasterObject( sc );
                getForwardingDao( Item.class).create( item );
            }
        }


        CollectedSystemObjects  objects = sc.getCollectedObjects();
        if (objects != null  &&  objects.size() > 0) {
            for (CollectedSystemObject  object : objects) {
                object.setMasterObject( sc );
//                getForwardingDao( CollectedSystemObject.class ).create( object );

//                OvalSystemCharacteristicsObjectAssociation  sco_assoc =
//                    new OvalSystemCharacteristicsObjectAssociation( sc, object );
//                getForwardingDao( OvalSystemCharacteristicsObjectAssociation.class).sync( sco_assoc );

                Collection<VariableValue>  vvs = object.getVariableValue();
                if (vvs != null  &&  vvs.size() > 0) {
                    for (VariableValue  vv : vvs) {
                        vv.setMasterObject( object );
                    }
                }

                Collection<ItemReference>  references = object.getReference();
                if (references != null  &&  references.size() > 0) {
                    for (ItemReference  reference : references) {
                        reference.setMasterObject( object );
                    }
                }
            }
        }

        return super.create( sc );
    }

}
// OvalSystemCharacteristicsDao
