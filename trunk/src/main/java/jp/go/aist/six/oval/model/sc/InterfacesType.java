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
    private final Collection<InterfaceType>  network_interface =
        new ArrayList<InterfaceType>();



    /**
     * Constructor.
     */
    public InterfacesType()
    {
    }


    public InterfacesType(
                    final Collection<? extends InterfaceType> interface_list
                    )
    {
//        super( network_interface_list );

//        network_interface.addAll( network_interface_list );
        _copy( network_interface, interface_list );
    }


    public InterfacesType(
                    final InterfaceType[] interface_list
                    )
    {
//        super( network_interface_list );

        this( Arrays.asList( interface_list ) );
    }



    /**
     */
    public void setInterface(
                    final Collection<? extends InterfaceType> interface_list
                    )
    {
        reset( interface_list );
    }


    public void setInterface(
                    final InterfaceType[] interface_list
                    )
    {
        reset( interface_list );
    }


    public Collection<InterfaceType> getInterface()
    {
        return _getCollection();
    }


//    public boolean addInterface(
//                    final InterfaceType network_interface
//                    )
//    {
//        return add( network_interface );
//    }
//
//
//    public Iterator<InterfaceType> iterateInterface()
//    {
//        return iterator();
//    }



    //**************************************************************
    //  Container
    //**************************************************************

    @Override
    protected Collection<InterfaceType> _getCollection()
    {
        return network_interface;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

}
//
