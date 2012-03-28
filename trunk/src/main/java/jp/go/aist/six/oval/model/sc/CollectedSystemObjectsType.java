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

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import jp.go.aist.six.oval.model.ElementContainer;



/**
 * A collection of all the objects that have been collected
 * by the system characteristics file.
 * The name "objects" in the OVAL Schema is renamed
 * because the name has the special meaning in Java.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class CollectedSystemObjectsType
    extends ElementContainer<SystemObjectType>    //{1..*}
{

    private final Set<SystemObjectType>  object = new HashSet<SystemObjectType>();
    //{1..*}



    /**
     * Constructor.
     */
    public CollectedSystemObjectsType()
    {
    }


    public CollectedSystemObjectsType(
                    final Collection<? extends SystemObjectType> objects
                    )
    {
        super( objects );
    }


    public CollectedSystemObjectsType(
                    final SystemObjectType[] objects
                    )
    {
        super( objects );
    }



    /**
     */
    public void setObject(
                    final Collection<? extends SystemObjectType> object
                    )
    {
        _setElement( object );
    }


    public void setObject(
                    final SystemObjectType[] object
                    )
    {
        _setElement( object );
    }


    public boolean addObject(
                    final SystemObjectType object
                    )
    {
        return _addElement( object );
    }


    public Collection<SystemObjectType> getObject()
    {
        return _getElement();
    }



    public Iterator<SystemObjectType> iterateObject()
    {
        return _iterateElement();
    }



    //**************************************************************
    //  Container
    //**************************************************************

    @Override
    protected Collection<SystemObjectType> _getElement()
    {
        return this.object;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "["
                        + _getElement()
                        + "]";
    }

}
// CollectedSystemObjectsType