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

package jp.go.aist.six.oval.model.v5.sc;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import jp.go.aist.six.oval.model.Container;
import com.google.code.morphia.annotations.Embedded;



/**
 * A container for one or more NetInterface instances.
 * The name "interfaces" in the OVAL Schema is renamed
 * because the name "Object" has the special meaning in Java.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class NetworkInterfacesType
    extends Container<NetworkInterfaceType> //{0..*}
{

    @Embedded( "interface" )
    private final Set<NetworkInterfaceType>  network_interface =
        new HashSet<NetworkInterfaceType>();



    /**
     * Constructor.
     */
    public NetworkInterfacesType()
    {
    }


    public NetworkInterfacesType(
                    final Collection<? extends NetworkInterfaceType> netifs
                    )
    {
        super( netifs );
    }


    public NetworkInterfacesType(
                    final NetworkInterfaceType[] netifs
                    )
    {
        super( netifs );
    }



    /**
     */
    public void setInterface(
                    final Collection<? extends NetworkInterfaceType> network_interface
                    )
    {
        _setElement( network_interface );
    }


    public void setInterface(
                    final NetworkInterfaceType[] network_interface
                    )
    {
        _setElement( network_interface );
    }


    public boolean addInterface(
                    final NetworkInterfaceType network_interface
                    )
    {
        return _addElement( network_interface );
    }


    public Collection<NetworkInterfaceType> getInterface()
    {
        return _getElement();
    }


    public Iterator<NetworkInterfaceType> iterateInterface()
    {
        return _iterateElement();
    }



    //**************************************************************
    //  Container
    //**************************************************************

    @Override
    protected Collection<NetworkInterfaceType> _getElement()
    {
        return this.network_interface;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

}
// NetworkInterfacesType
