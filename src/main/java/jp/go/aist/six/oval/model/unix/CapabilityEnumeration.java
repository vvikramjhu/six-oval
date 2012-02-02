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
 * The set of values that describe POSIX capability types associated with a process service.  
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public enum CapabilityEnumeration
    implements OvalEnumeration
{

    CAP_CHOWN               ( "CAP_CHOWN" ),
    CAP_DAC_OVERRIDE        ( "CAP_DAC_OVERRIDE" ),
    CAP_DAC_READ_SEARCH     ( "CAP_DAC_READ_SEARCH" ),
    CAP_FOWNER              ( "CAP_FOWNER" ),
    CAP_FSETID              ( "CAP_FSETID " ),
    CAP_KILL                ( "CAP_KILL" ),
    CAP_SETGID              ( "CAP_SETGID" ),
    CAP_SETUID              ( "CAP_SETUID" ),
    CAP_SETPCAP             ( "CAP_SETPCAP" ),
    CAP_LINUX_IMMUTABLE     ( "CAP_LINUX_IMMUTABLE" ),
    CAP_NET_BIND_SERVICE    ( "CAP_NET_BIND_SERVICE" ),
    CAP_NET_BROADCAST       ( "CAP_NET_BROADCAST" ),
    CAP_NET_ADMIN           ( "CAP_NET_ADMIN" ),
    CAP_NET_RAW             ( "CAP_NET_RAW" ),
    CAP_IPC_LOCK            ( "CAP_IPC_LOCK" ),
    CAP_IPC_OWNER           ( "CAP_IPC_OWNER" ),
    CAP_SYS_MODULE          ( "CAP_SYS_MODULE" ),
    CAP_SYS_RAWIO           ( "CAP_SYS_RAWIO" ),
    CAP_SYS_CHROOT          ( "CAP_SYS_CHROOT" ),
    CAP_SYS_PTRACE          ( "CAP_SYS_PTRACE" ),
    CAP_SYS_ADMIN           ( "CAP_SYS_ADMIN" ),
    CAP_SYS_BOOT            ( "CAP_SYS_BOOT" ),
    CAP_SYS_NICE            ( "CAP_SYS_NICE" ),
    CAP_SYS_RESOURCE        ( "CAP_SYS_RESOURCE" ),
    CAP_SYS_TIME            ( "CAP_SYS_TIME" ),
    CAP_SYS_TTY_CONFIG      ( "CAP_SYS_TTY_CONFIG" ),
    CAP_MKNOD               ( "CAP_MKNOD" ),
    CAP_LEASE               ( "CAP_LEASE" ),
    CAP_AUDIT_WRITE         ( "CAP_AUDIT_WRITE" ),
    CAP_AUDIT_CONTROL       ( "CAP_AUDIT_CONTROL" ),
    CAP_SETFCAP             ( "CAP_SETFCAP" ),
    CAP_MAC_OVERRIDE        ( "CAP_MAC_OVERRIDE" ),
    CAP_MAC_ADMIN           ( "CAP_MAC_ADMIN" ),
    NONE                    ( "" );



    /**
     * A factory method.
     */
    public static CapabilityEnumeration fromValue(
                    final String value
                    )
    {
        for (CapabilityEnumeration  e : CapabilityEnumeration.values()) {
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
    CapabilityEnumeration(
                    final String value
                    )
    {
        this.value = value;
    }



    @Override
    public String value()
    {
        return this.value;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return this.value;
    }

}
//CapabilityEnumeration
