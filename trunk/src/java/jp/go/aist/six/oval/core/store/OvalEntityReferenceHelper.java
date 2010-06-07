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

import jp.go.aist.six.oval.model.OvalAnalysisElement;
import jp.go.aist.six.util.castor.DefaultPersistenceHelper;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id: OvalEntityReferenceHelper.java 440 2010-03-23 05:11:44Z akihito $
 */
public class OvalEntityReferenceHelper<T extends OvalAnalysisElement>
extends DefaultPersistenceHelper<T>
{

    public OvalEntityReferenceHelper()
    {
    }



    //**************************************************************
    //  PersistenceHelper
    //**************************************************************

    public Object getUnique(
                    final T entity
                    )
    {
        return (new Object[] {
                        entity.getOvalID(),
                        Integer.valueOf( entity.getOvalVersion() )
        });
    }



    public String getUniqueFilter()
    {
        return "WHERE o.ovalID = $1 AND o.ovalVersion = $2";
    }

}
// OvalEntityReferenceHelper

