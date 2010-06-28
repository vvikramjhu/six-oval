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

import jp.go.aist.six.oval.core.model.result.OvalResultsSystemAssociation;
import jp.go.aist.six.oval.model.definition.OvalDefinitions;
import jp.go.aist.six.oval.model.result.OvalResults;
import jp.go.aist.six.oval.model.result.SystemResult;
import jp.go.aist.six.util.castor.CastorDao;
import java.util.UUID;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalResultsDao
    extends CastorDao<OvalResults>
{

    /**
     * Constructor.
     */
    public OvalResultsDao()
    {
        super( OvalResults.class );
    }



    //**************************************************************
    //  Dao, CastorDao
    //**************************************************************

    @Override
    public Object create(
                    final OvalResults results
                    )
    {
        if (results.getPersistentID() == null) {
            String  uuid = UUID.randomUUID().toString();
            results.setPersistentID( uuid );
        }

        for (SystemResult  system : results.getResults()) {
            system.setMasterObject( results );
            getForwardingDao( SystemResult.class ).create( system );

            OvalResultsSystemAssociation  assoc =
                new OvalResultsSystemAssociation( results, system );
            getForwardingDao( OvalResultsSystemAssociation.class ).sync( assoc );
        }

        OvalDefinitions  defs = results.getDefinitions();
        if (defs != null) {
            getForwardingDao( OvalDefinitions.class ).create( defs );
        }

        return super.create( results );
    }

}
// OvalResultsDao
