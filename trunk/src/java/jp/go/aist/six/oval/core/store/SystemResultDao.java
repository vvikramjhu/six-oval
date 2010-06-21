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

import jp.go.aist.six.oval.model.result.DefinitionResult;
import jp.go.aist.six.oval.model.result.DefinitionResults;
import jp.go.aist.six.oval.model.result.SystemResult;
import jp.go.aist.six.oval.model.system.OvalSystemCharacteristics;
import jp.go.aist.six.util.castor.CastorDao;
import java.util.UUID;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id: SystemResultDao.java 758 2010-05-10 06:28:46Z akihito $
 */
public class SystemResultDao
    extends CastorDao<SystemResult>
{

    public SystemResultDao()
    {
        super( SystemResult.class );
    }



    //**************************************************************
    //  Dao, CastorDao
    //**************************************************************

    @Override
    public Object create(
                    final SystemResult system
                    )
    {
        if (system.getPersistentID() == null) {
            String  uuid = UUID.randomUUID().toString();
            system.setPersistentID( uuid );
        }

        OvalSystemCharacteristics  sc = system.getOvalSystemCharacteristics();
        getForwardingDao( OvalSystemCharacteristics.class ).create( sc );


        DefinitionResults  dr_list = system.getDefinitions();
        if (dr_list != null  &&  dr_list.size() > 0) {
            DefinitionResults  p_dr_list = new DefinitionResults();
            for (DefinitionResult  dr : dr_list) {
                dr.setMasterObject( system );
                DefinitionResult  p_dr = getForwardingDao( DefinitionResult.class ).sync( dr );
                p_dr_list.add( p_dr );
            }

            system.setDefinitions( p_dr_list );
        }

        return super.create( system );
    }

}
// SystemResultDao
