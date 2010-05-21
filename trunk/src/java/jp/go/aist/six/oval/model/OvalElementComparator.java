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

package jp.go.aist.six.oval.model;

import java.util.Comparator;



/**
 * A comparison function for OvalElement objects.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id: OvalElementComparator.java 543 2010-04-08 09:13:47Z akihito $
 */
public class OvalElementComparator
implements Comparator<OvalElement>
{

    /**
     * Constructor.
     */
    public OvalElementComparator()
    {
    }




    //**************************************************************
    //  Comparator
    //**************************************************************

    public int compare(
                    final OvalElement e1,
                    final OvalElement e2
                    )
    {
        String  id1 = e1.getOvalID();
        String  id2 = e2.getOvalID();
        int  order = id1.compareTo( id2 );
        if (order != 0) {
            return order;
        }

        int  version1 = e1.getOvalVersion();
        int  version2 = e2.getOvalVersion();
        return (version1 - version2);
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        return (obj instanceof OvalElementComparator);
    }

}
// OvalElementComparator
