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
 * A reference to an OVAL entity, independent of its version.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class OvalEntityRefType
    implements OvalObject
{

//    private String  _ovalID;


    /**
     * Constructor.
     */
    public OvalEntityRefType()
    {
    }


//    public OvalEntityRef(
//                    final String ref
//                    )
//    {
//        _setRef( ref );
//    }



    /**
     */
    protected abstract void _setRef( String id );
    protected abstract String _getRef();



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        String  id = _getRef();
        result = prime * result + ((id == null) ? 0 : id.hashCode());

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

        if (!(obj instanceof OvalEntityRefType)) {
            return false;
        }

        OvalEntityRefType  other = (OvalEntityRefType)obj;
        String  other_id = other._getRef();
        String   this_id =  this._getRef();
        if (this_id == other_id
                        ||  (this_id != null  &&  this_id.equals( other_id ))) {
            return true;
        }

        return false;
    }



    @Override
    public String toString()
    {
        return _getRef();
    }

}
//OvalEntityRefType

