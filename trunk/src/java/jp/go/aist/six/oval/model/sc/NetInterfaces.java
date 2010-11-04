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

import jp.go.aist.six.oval.model.Container;
import java.util.Collection;
import java.util.Iterator;



/**
 * A container for one or more NetInterface instances.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class NetInterfaces
    extends Container<NetInterface> //{0..*}
{

    /**
     * Constructor.
     */
    public NetInterfaces()
    {
    }


    /**
     * Constructor.
     */
    public NetInterfaces(
                    final Collection<? extends NetInterface> netifs
                    )
    {
        super( netifs );
    }


    /**
     * Constructor.
     */
    public NetInterfaces(
                    final NetInterface[] netifs
                    )
    {
        super( netifs );
    }



    public void setInterface(
                    final Collection<? extends NetInterface> netifs
                    )
    {
        _setElement( netifs );
    }


    public boolean addInterface(
                    final NetInterface netif
                    )
    {
        return add( netif );
    }


    public Collection<NetInterface> getInterface()
    {
        return _getElement();
    }


    public Iterator<NetInterface> iterateInterface()
    {
        return iterator();
    }



    //**************************************************************
    //  Container
    //**************************************************************

//    protected String _getKey(
//                    final NetInterface netif
//                    )
//    {
//        return netif.getInterfaceName();
//    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

}
// NetInterfaces
