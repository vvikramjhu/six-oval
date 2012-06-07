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

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import jp.go.aist.six.oval.model.Container;
import com.google.code.morphia.annotations.Embedded;



/**
 * The InterfacesType is a container for zero or more interface elements.
 * Each interface element is used to describe an existing network interface on the system.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class InterfacesType
    extends Container<InterfaceType> //{0..*}
{

    @Embedded( "interface" )
    private final Set<InterfaceType>  network_interface =
        new HashSet<InterfaceType>();



    /**
     * Constructor.
     */
    public InterfacesType()
    {
    }


    public InterfacesType(
                    final Collection<? extends InterfaceType> network_interface_list
                    )
    {
//        super( netifs );

        network_interface.addAll( network_interface_list );
    }


    public InterfacesType(
                    final InterfaceType[] network_interface_list
                    )
    {
//        super( netifs );

        this( Arrays.asList( network_interface_list ) );
    }



    /**
     */
    public void setInterface(
                    final Collection<? extends InterfaceType> network_interface_list
                    )
    {
        _setElement( network_interface_list );
    }


    public void setInterface(
                    final InterfaceType[] network_interface
                    )
    {
        _setElement( network_interface );
    }


    public boolean addInterface(
                    final InterfaceType network_interface
                    )
    {
        return _addElement( network_interface );
    }


    public Collection<InterfaceType> getInterface()
    {
        return _getElement();
    }


    public Iterator<InterfaceType> iterateInterface()
    {
        return iterator();
    }



    //**************************************************************
    //  Container
    //**************************************************************

    @Override
    protected Collection<InterfaceType> _getElement()
    {
        return network_interface;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

}
//InterfacesType
