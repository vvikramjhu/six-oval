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

package jp.go.aist.six.oval.model;





/**
 * A marker interface for all the OVAL domain objects except enumerations.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public final class OvalID
implements Comparable<OvalID>
{

    private String  _ovalID;


    /**
     * Constructor.
     */
    public OvalID()
    {
        // TODO: private???
    }


    public OvalID(
                    final String id
                    )
    {
        setValue( id );
    }



    /**
     */
    public void setValue(
                    final String ovalID
                    )
    {
        _ovalID = ovalID;
    }


    public String getValue()
    {
        return _ovalID;
    }



    //**************************************************************
    //  Comparable
    //**************************************************************

    @Override
    public int compareTo(
                    final OvalID o
                    )
    {
        String  id1 = getValue();
        String  id2 = o.getValue();

        return id1.compareTo( id2 );
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        result = prime * result + ((_ovalID == null) ? 0 : _ovalID.hashCode());

        return result;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof OvalID)) {
            return false;
        }

        OvalID  other = (OvalID)obj;
        String  other_id = other.getValue();
        String   this_id =  this.getValue();

        return (this_id == other_id
                        ||  (this_id != null  &&  this_id.equals( other_id )));
    }



    @Override
    public String toString()
    {
        return _ovalID;
    }

}
// OvalID
