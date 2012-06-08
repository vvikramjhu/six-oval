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

package jp.go.aist.six.oval.model.sc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import jp.go.aist.six.oval.model.ElementContainer;



/**
 * A collection of all the objects that have been collected
 * by the system characteristics file.
 * The name "objects" in the OVAL Schema is renamed
 * because the name has the special meaning in Java.
 *
 * <p>Constraints:
 * The combination of id, version, and variable instance of each object is unique in this container.
 * </p>
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class CollectedSystemObjectsType
    extends ElementContainer<SystemObjectType>    //{1..*}
{

    //TODO: Uniqueness constraints, i.e. xsd:key.
    private final Collection<SystemObjectType>  object = new ArrayList<SystemObjectType>();
    //{1..*}



    /**
     * Constructor.
     */
    public CollectedSystemObjectsType()
    {
    }


    public CollectedSystemObjectsType(
                    final Collection<? extends SystemObjectType> object_list
                    )
    {
//        super( objects );

//        object.addAll( object_list );
        _copy( object, object_list );
    }


    public CollectedSystemObjectsType(
                    final SystemObjectType[] object_list
                    )
    {
//        super( objects );

        this( Arrays.asList( object_list ) );
    }



    /**
     */
    public void setObject(
                    final Collection<? extends SystemObjectType> object_list
                    )
    {
        reset( object_list );
//        _setElement( object );
    }


    public void setObject(
                    final SystemObjectType[] object_list
                    )
    {
        reset( object_list );
//        _setElement( object );
    }


    public Collection<SystemObjectType> getObject()
    {
        return _getCollection();
    }



//    public boolean addObject(
//                    final SystemObjectType object
//                    )
//    {
//        return add( object );
//    }
//
//
//    public Iterator<SystemObjectType> iterateObject()
//    {
//        return iterator();
//    }



    //**************************************************************
    //  Container
    //**************************************************************

    @Override
    protected Collection<SystemObjectType> _getCollection()
    {
        return object;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

//    @Override
//    public String toString()
//    {
//        return "["
//                        + _getCollection()
//                        + "]";
//    }

}
//