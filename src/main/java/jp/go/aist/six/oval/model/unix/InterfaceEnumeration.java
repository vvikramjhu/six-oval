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

package jp.go.aist.six.oval.model.unix;

import jp.go.aist.six.oval.model.OvalEnumeration;



/**
 * The network interface type enumeration.
 * These values are defined in 'if_arp.h'.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public enum InterfaceEnumeration
    implements OvalEnumeration
{

    ARPHRD_ETHER,
    ARPHRD_FDDI,
    ARPHRD_LOOPBACK,
    ARPHRD_VOID,
    ARPHRD_PPP,
    ARPHRD_SLIP,
    ARPHRD_PRONET,
    NONE( "" );



    /**
     * A factory method.
     */
    public static InterfaceEnumeration fromValue(
                    final String value
                    )
    {
        for (InterfaceEnumeration  e : InterfaceEnumeration.values()) {
            if (e.value.equals( value )) {
                return e;
            }
        }

        throw new IllegalArgumentException( value );
    }



    private String  value = null;



    /**
     * Constructor.
     */
    InterfaceEnumeration()
    {
        value = name();
    }


    InterfaceEnumeration(
                    final String value
                    )
    {
        this.value = value;
    }



    @Override
    public String value()
    {
        return value;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return value;
    }

}
//InterfaceEnumeration
