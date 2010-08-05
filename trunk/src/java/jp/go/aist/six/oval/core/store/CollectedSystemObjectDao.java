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

import jp.go.aist.six.oval.model.sc.CollectedSystemObject;
import jp.go.aist.six.oval.model.sc.ItemReference;
import jp.go.aist.six.oval.model.sc.VariableValue;
import java.util.Collection;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class CollectedSystemObjectDao
    extends OvalEntityReferenceDao<CollectedSystemObject>
{

    /**
     * Constructor.
     */
    public CollectedSystemObjectDao()
    {
        super( CollectedSystemObject.class );
    }



    //**************************************************************
    //  Dao, CastorDao
    //**************************************************************

    @Override
    public String create(
                    final CollectedSystemObject object
                    )
    {
        Collection<VariableValue>  vv = object.getVariableValue();
        if (vv != null  &&  vv.size() > 0) {
            for(VariableValue v : vv) {
                v.setMasterObject( object );
            }
        }

        Collection<ItemReference>  references = object.getReference();
        for (ItemReference  r : references) {
            r.setMasterObject( object );
        }

        return super.create( object );
    }

}
// CollectedSystemObjectDao
