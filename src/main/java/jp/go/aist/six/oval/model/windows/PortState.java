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

package jp.go.aist.six.oval.model.windows;

import jp.go.aist.six.oval.model.Component;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.definitions.EntityStateIPAddressStringType;
import jp.go.aist.six.oval.model.definitions.EntityStateIntType;
import jp.go.aist.six.oval.model.definitions.StateType;



/**
 * The port state defines the different metadata associate with a Windows port.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class PortState
    extends StateType
{

    //{0..1}
    private EntityStateIPAddressStringType  local_address;
    private EntityStateIntType              local_port;
    private EntityStateProtocolType         protocol;
    private EntityStateIntType              pid;
    private EntityStateIPAddressStringType  foreign_address;
    private EntityStateIntType              foreign_port;



    /**
     * Constructor.
     */
    public PortState()
    {
        this( null, 0 );
    }


    public PortState(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public PortState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

//        _oval_platform_type = OvalPlatformType.windows;
//        _oval_component_type = OvalComponentType.port;
        _oval_family = Family.WINDOWS;
        _oval_component = Component.PORT;
    }



    /**
     */
    public void setLocalAddress(
                    final EntityStateIPAddressStringType local_address
                    )
    {
        this.local_address = local_address;
    }


    public EntityStateIPAddressStringType getLocalAddress()
    {
        return local_address;
    }



    /**
     */
    public void setLocalPort(
                    final EntityStateIntType local_port
                    )
    {
        this.local_port = local_port;
    }


    public EntityStateIntType getLocalPort()
    {
        return local_port;
    }



    /**
     */
    public void setProtocol(
                    final EntityStateProtocolType protocol
                    )
    {
        this.protocol = protocol;
    }


    public EntityStateProtocolType getProtocol()
    {
        return protocol;
    }



    /**
     */
    public void setPid(
                    final EntityStateIntType pid
                    )
    {
        this.pid = pid;
    }


    public EntityStateIntType getPid()
    {
        return pid;
    }



    /**
     */
    public void setForeignAddress(
                    final EntityStateIPAddressStringType foreign_address
                    )
    {
        this.foreign_address = foreign_address;
    }


    public EntityStateIPAddressStringType getForeignAddress()
    {
        return foreign_address;
    }



    /**
     */
    public void setForeignPort(
                    final EntityStateIntType foreign_port
                    )
    {
        this.foreign_port = foreign_port;
    }


    public EntityStateIntType getForeignPort()
    {
        return foreign_port;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof PortState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "port_state[" + super.toString()
                        + ", local_address="    + getLocalAddress()
                        + ", local_port="       + getLocalPort()
                        + ", protocol="         + getProtocol()
                        + ", pid="              + getPid()
                        + ", foreign_address="  + getForeignAddress()
                        + ", foreign_port="     + getForeignPort()
                        + "]";
    }

}
//PortState
