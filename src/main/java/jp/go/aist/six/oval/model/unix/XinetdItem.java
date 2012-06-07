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

import jp.go.aist.six.oval.model.ComponentType;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.sc.EntityItemBoolType;
import jp.go.aist.six.oval.model.sc.EntityItemIPAddressStringType;
import jp.go.aist.six.oval.model.sc.EntityItemIntType;
import jp.go.aist.six.oval.model.sc.EntityItemStringType;
import jp.go.aist.six.oval.model.sc.ItemType;
import jp.go.aist.six.oval.model.sc.StatusEnumeration;



/**
 * The xinetd item holds information associated with different Internet services.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class XinetdItem
    extends ItemType
{

    //{0..1}
    private EntityItemStringType           protocol;
    private EntityItemStringType           service_name;
    private EntityItemStringType           flags;
    private EntityItemStringType           no_access;
    private EntityItemIPAddressStringType  only_from;
    private EntityItemIntType              port;
    private EntityItemStringType           server;
    private EntityItemStringType           server_arguments;
    private EntityItemStringType           socket_type;
    private EntityItemXinetdTypeStatusType type;
    private EntityItemStringType           user;
    private EntityItemBoolType             wait;
    private EntityItemBoolType             disabled;



    /**
     * Constructor.
     */
    public XinetdItem()
    {
        this( 0 );
    }


    public XinetdItem(
                    final int id
                    )
    {
        this( id, null );
    }


    public XinetdItem(
                    final int id,
                    final StatusEnumeration status
                    )
    {
        super( id, status );

//        _oval_platform_type = OvalPlatformType.unix;
//        _oval_component_type = OvalComponentType.xinetd;
        _oval_family = Family.UNIX;
        _oval_component = ComponentType.XINETD;
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
    public void setFlags(
                    final EntityItemStringType flags
                    )
    {
        this.flags = flags;
    }


    public EntityItemStringType getFlags()
    {
        return flags;
    }



    /**
     */
    public void setNoAccess(
                    final EntityItemStringType no_access
                    )
    {
        this.no_access = no_access;
    }


    public EntityItemStringType getNoAccess()
    {
        return no_access;
    }



    /**
     */
    public void setOnlyFrom(
                    final EntityItemIPAddressStringType only_from
                    )
    {
        this.only_from = only_from;
    }


    public EntityItemIPAddressStringType getOnlyFrom()
    {
        return only_from;
    }



    /**
     */
    public void setPort(
                    final EntityItemIntType port
                    )
    {
        this.port = port;
    }


    public EntityItemIntType getPort()
    {
        return port;
    }



    /**
     */
    public void setServer(
                    final EntityItemStringType server
                    )
    {
        this.server = server;
    }


    public EntityItemStringType getServer()
    {
        return server;
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
    public void setSocketType(
                    final EntityItemStringType socket_type
                    )
    {
        this.socket_type = socket_type;
    }


    public EntityItemStringType getSocketType()
    {
        return socket_type;
    }



    /**
     */
    public void setType(
                    final EntityItemXinetdTypeStatusType type
                    )
    {
        this.type = type;
    }


    public EntityItemXinetdTypeStatusType getType()
    {
        return type;
    }



    /**
     */
    public void setUser(
                    final EntityItemStringType user
                    )
    {
        this.user = user;
    }


    public EntityItemStringType getUser()
    {
        return user;
    }



    /**
     */
    public void setWait(
                    final EntityItemBoolType wait
                    )
    {
        this.wait = wait;
    }


    public EntityItemBoolType getWait()
    {
        return wait;
    }



    /**
     */
    public void setDisabled(
                    final EntityItemBoolType disabled
                    )
    {
        this.disabled = disabled;
    }


    public EntityItemBoolType getDisabled()
    {
        return disabled;
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
        if (!(obj instanceof XinetdItem)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "xinetd_item[" + super.toString()
                        + ", protocol="         + getProtocol()
                        + ", service_name="     + getServiceName()
                        + ", flags="            + getFlags()
                        + ", no_access="        + getNoAccess()
                        + ", only_from="        + getOnlyFrom()
                        + ", port="             + getPort()
                        + ", server="           + getServer()
                        + ", server_arguments=" + getServerArguments()
                        + ", socket_type="      + getSocketType()
                        + ", type="             + getType()
                        + ", user="             + getUser()
                        + ", wait="             + getWait()
                        + ", disabled="         + getDisabled()
             + "]";
    }

}
//XinetdItem
