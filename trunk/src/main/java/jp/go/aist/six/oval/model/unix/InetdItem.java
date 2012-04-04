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

import jp.go.aist.six.oval.model.Component;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.sc.EntityItemStringType;
import jp.go.aist.six.oval.model.sc.ItemType;
import jp.go.aist.six.oval.model.sc.StatusEnumeration;



/**
 * The file item holds information about the individual files found on a system.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class InetdItem
    extends ItemType
{

    //{0..1}
    private EntityItemStringType       protocol;
    private EntityItemStringType       service_name;
    private EntityItemStringType       server_program;
    private EntityItemStringType       server_arguments;
    private EntityItemEndpointType     endpoint_type;
    private EntityItemStringType       exec_as_user;
    private EntityItemWaitStatusType   wait_status;



    /**
     * Constructor.
     */
    public InetdItem()
    {
        this( 0 );
    }


    public InetdItem(
                    final int id
                    )
    {
        this( id, null );
    }


    public InetdItem(
                    final int id,
                    final StatusEnumeration status
                    )
    {
        super( id, status );

//        _oval_platform_type = OvalPlatformType.unix;
//        _oval_component_type = OvalComponentType.inetd;
        _oval_family = Family.UNIX;
        _oval_component = Component.INETD;
    }



    /**
     */
    public void setProtocol(
                    final EntityItemStringType protocol
                    )
    {
        this.protocol = protocol;
    }


    public EntityItemStringType getProtocol()
    {
        return protocol;
    }



    /**
     */
    public void setServiceName(
                    final EntityItemStringType service_name
                    )
    {
        this.service_name = service_name;
    }


    public EntityItemStringType getServiceName()
    {
        return service_name;
    }



    /**
     */
    public void setServerProgram(
                    final EntityItemStringType server_program
                    )
    {
        this.server_program = server_program;
    }


    public EntityItemStringType getServerProgram()
    {
        return server_program;
    }



    /**
     */
    public void setServerArguments(
                    final EntityItemStringType server_arguments
                    )
    {
        this.server_arguments = server_arguments;
    }


    public EntityItemStringType getServerArguments()
    {
        return server_arguments;
    }



    /**
     */
    public void setEndpointType(
                    final EntityItemEndpointType endpoint_type
                    )
    {
        this.endpoint_type = endpoint_type;
    }


    public EntityItemEndpointType getEndpointType()
    {
        return endpoint_type;
    }



    /**
     */
    public void setExecAsUser(
                    final EntityItemStringType exec_as_user
                    )
    {
        this.exec_as_user = exec_as_user;
    }


    public EntityItemStringType getExecAsUser()
    {
        return exec_as_user;
    }



    /**
     */
    public void setWaitStatus(
                    final EntityItemWaitStatusType wait_status
                    )
    {
        this.wait_status = wait_status;
    }


    public EntityItemWaitStatusType getWaitStatus()
    {
        return wait_status;
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
        if (!(obj instanceof InetdItem)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "inetd_item[" + super.toString()
                        + ", protocol="         + getProtocol()
                        + ", service_name="     + getServiceName()
                        + ", server_program="   + getServerProgram()
                        + ", server_arguments=" + getServerArguments()
                        + ", endpoint_type="    + getEndpointType()
                        + ", exec_as_user="     + getExecAsUser()
                        + ", wait_status="      + getWaitStatus()
             + "]";
    }

}
//InetdItem
