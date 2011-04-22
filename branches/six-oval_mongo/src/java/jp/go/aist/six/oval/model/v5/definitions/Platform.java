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

package jp.go.aist.six.oval.model.v5.definitions;

import jp.go.aist.six.oval.model.v5.OvalObject;
import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Transient;



/**
 * A platform name.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
@Embedded
public class Platform
    implements OvalObject<String>
//    extends NameEntity
//extends NamedEntry<Integer>
{

    private String  name;



    /**
     * Constructor.
     */
    public Platform()
    {
    }


    public Platform(
                    final String name
                    )
    {
        setName( name );
//        super( name );
    }



    // We use the name as the persistent ID.
    public void setName(
                    final String name
                    )
    {
        this.name = name;
    }


    public String getName()
    {
        return this.name;
    }



    //**************************************************************
    //  Persistable
    //**************************************************************

    @Transient
    private String  _objectID;


    @Override
    public final void setPersistentID(
                    final String pid
                    )
    {
        _objectID = pid;
    }


    @Override
    public synchronized String getPersistentID()
    {
        return this._objectID;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof Platform)) {
            return false;
        }

        return super.equals( obj );
    }



//    /**
//     * @see java.lang.Object#toString()
//     */
//    @Override
//    public String toString()
//    {
//        return "Platform[" + getName()
//                    + "]";
//    }

}
//public class Platform
//extends NameEntity
//{
//
///**
// * Constructor.
// */
//public Platform()
//{
//}
//
//
///**
// * Constructor.
// */
//public Platform(
//                final String name
//                )
//{
//    super( name );
//}
//
//
//
////**************************************************************
////  java.lang.Object
////**************************************************************
//
//@Override
//public int hashCode()
//{
//    return super.hashCode();
//}
//
//
//
//@Override
//public boolean equals(
//                final Object obj
//                )
//{
//    if (!(obj instanceof Platform)) {
//        return false;
//    }
//
//    return super.equals( obj );
//}
//
//
//
/////**
//// * @see java.lang.Object#toString()
//// */
////@Override
////public String toString()
////{
////    return "Platform[" + getName()
////                + "]";
////}
//
//}
// Platform
