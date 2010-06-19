/*
 *  @ProductName@
 *  Copyright (C) @CopyrightYear@
 *    National Institute of Advanced Industrial Science and Technology (AIST)
 *    Registration Number: @AISTRegistrationNumber@
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

package jp.go.aist.six.oval.model.system;

import jp.go.aist.six.oval.model.Container;
import java.util.Collection;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class NetworkInterfaces
    extends Container<NetworkInterface>
//implements Serializable, Iterable<NetworkInterface>
{

    /**
     * Constructor.
     */
    public NetworkInterfaces()
    {
    }



    /**
     * Constructor.
     */
    public NetworkInterfaces(
                    Collection<? extends NetworkInterface> ifs
                    )
    {
        super( ifs );
    }



    public void setInterface(
                    final Collection<? extends NetworkInterface> netifs
                    )
    {
        setElements( netifs );
    }


//    public boolean addInterface(
//                    final NetworkInterface netif
//                    )
//    {
//        addElement( netif );
//
//        return true;
//    }


    public Collection<NetworkInterface> getInterface()
    {
        return getElements();
    }



    //**************************************************************
    //  Container
    //**************************************************************

    protected Object _getKey(
                    final NetworkInterface netif
                    )
    {
        return netif.getInterfaceName();
    }



    //**************************************************************
    //  Iterable
    //**************************************************************

//    public Iterator<NetworkInterface> iterator()
//    {
//        return _interface.iterator();
//    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

//    @Override
//    public String toString()
//    {
//        return String.valueOf( getInterface() );
//    }

}
// NetworkInterfaces
