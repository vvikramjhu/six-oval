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
import java.util.Iterator;



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



    /**
     * Constructor.
     */
    public NetworkInterfaces(
                    NetworkInterface[] ifs
                    )
    {
        super( ifs );
    }




    public void setInterface(
                    final Collection<? extends NetworkInterface> netifs
                    )
    {
        reset( netifs );
    }


    public boolean addInterface(
                    final NetworkInterface netif
                    )
    {
        return add( netif );
    }


    public Collection<NetworkInterface> getInterface()
    {
        return _values();
    }


    public Iterator<NetworkInterface> iterateInterface()
    {
        return iterator();
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
    //  java.lang.Object
    //**************************************************************

}
// NetworkInterfaces
