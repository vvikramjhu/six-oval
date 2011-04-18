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

package jp.go.aist.six.oval.model.debian;

import jp.go.aist.six.oval.model.definitions.Reference;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class DebianBugReference
    extends Reference
{

    public static final String  SOURCE = "DebianBugReport";



    /**
     * Constructor.
     */
    public DebianBugReference()
    {
    }


    /**
     * Constructor.
     */
    public DebianBugReference(
                    final String refID,
                    final String refURL
                    )
    {
        super( SOURCE, refID, refURL );
    }



    //**************************************************************
    //  Reference
    //**************************************************************

    @Override
    public void setSource(
                    final String source
                    )
    {
    }


    @Override
    public String getSource()
    {
        return SOURCE;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "DebianBugReport [id=" + getRefID()
                        + ", href=" + getRefURL()
                        + "]";
    }

}
// DebianBugReference
