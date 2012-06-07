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

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import jp.go.aist.six.oval.model.Container;



/**
 * The SystemResult is a container for one or more SystemResult instances.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class ResultsType
    extends Container<SystemType> //{1..*}
{

//    @Reference
    private final Set<SystemType>  system = new HashSet<SystemType>();



    /**
     * Constructor.
     */
    public ResultsType()
    {
    }


    public ResultsType(
                    final Collection<? extends SystemType> system_list
                    )
    {
//        super( systems );

        system.addAll( system_list );
    }


    public ResultsType(
                    final SystemType[] system_list
                    )
    {
//        super( systems );

        this( Arrays.asList( system_list ) );
    }



    /**
     */
    public void setSystem(
                    final Collection<? extends SystemType> systemList
                    )
    {
        _setElement( systemList );
    }


    public void setSystem(
                    final SystemType[] systemList
                    )
    {
        _setElement( systemList );
    }


    public boolean addSystem(
                    final SystemType system
                    )
    {
        return _addElement( system );
    }


    public Collection<SystemType> getSystem()
    {
        return _getElement();
    }


    public Iterator<SystemType> iterateSystem()
    {
        return iterator();
    }



    //**************************************************************
    //  Container
    //**************************************************************

    @Override
    protected Collection<SystemType> _getElement()
    {
        return system;
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
// ResultsType
