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

package jp.go.aist.six.oval.model.results;

import jp.go.aist.six.oval.model.Container;
import java.util.Collection;
import java.util.Iterator;



/**
 * The SystemResult is a container for one or more SystemResult instances.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class SystemResults
    extends Container<SystemResult> //{1..*}
{

    /**
     * Constructor.
     */
    public SystemResults()
    {
    }


    /**
     * Constructor.
     */
    public SystemResults(
                    final Collection<? extends SystemResult> systems
                    )
    {
        super( systems );
    }


    /**
     * Constructor.
     */
    public SystemResults(
                    final SystemResult[] systems
                    )
    {
        super( systems );
    }



    public void setSystem(
                    final Collection<? extends SystemResult> systems
                    )
    {
        _setElement( systems );
    }


    public boolean addSystem(
                    final SystemResult system
                    )
    {
        return add( system );
    }


    public Collection<SystemResult> getSystem()
    {
        return _getElement();
    }


    public Iterator<SystemResult> iterateSystem()
    {
        return iterator();
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

//    @Override
//    public String toString()
//    {
//        return "[" + super.toString() + "]";
//    }

}
// SystemResults
