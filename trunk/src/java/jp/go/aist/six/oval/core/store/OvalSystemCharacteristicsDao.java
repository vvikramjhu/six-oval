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

import jp.go.aist.six.oval.model.system.Item;
import jp.go.aist.six.oval.model.system.NetworkInterface;
import jp.go.aist.six.oval.model.system.OvalSystemCharacteristics;
import jp.go.aist.six.oval.model.system.SystemData;
import jp.go.aist.six.oval.model.system.SystemInfo;
import jp.go.aist.six.util.castor.CastorDao;
import java.util.UUID;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id: OvalSystemCharacteristicsDao.java 763 2010-05-10 08:30:29Z akihito $
 */
public class OvalSystemCharacteristicsDao
    extends CastorDao<OvalSystemCharacteristics>
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

    @Override
    public String create(
                    final OvalSystemCharacteristics sc
                    )
    {
        if (sc.getPersistentID() == null) {
            String  uuid = UUID.randomUUID().toString();
            sc.setPersistentID( uuid );
        }

        SystemInfo  sysinfo = sc.getSystemInfo();
        sysinfo.setMasterObject( sc );

        for (NetworkInterface  netif : sysinfo.getInterfaces()) {
            netif.setMasterObject( sysinfo );
        }


        SystemData  sd = sc.getSystemData();
        if (sd != null  &&  sd.size() > 0) {
            for (Item  item : sd.getElements()) {
                item.setMasterObject( sc );
                getForwardingDao( Item.class ).create( item );
            }
        }

        /*
        for (Item  item : sc.getCollectedItems()) {
            item.setMasterObject( sc );
            getForwardingDao( Item.class ).create( item );
        }

        for (SystemObjectStatus  object : sc.getCollectedObjects()) {
            object.setMasterObject( sc );
            for (ItemReference  item_ref : object.getItems()) {
                item_ref.setMasterObject( object );
            }
            getForwardingDao( SystemObjectStatus.class ).create( object );

//            OvalSystemCharacteristicsObjectAssociation  sco_assoc =
//                new OvalSystemCharacteristicsObjectAssociation( sc, object );
//            getForwardingDao().create( OvalSystemCharacteristicsObjectAssociation.class, sco_assoc );
        }
*/

        return super.create( sc );
    }

}
// OvalSystemCharacteristicsDao
