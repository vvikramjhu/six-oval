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

import jp.go.aist.six.oval.model.OvalComponentType;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.definitions.EntityStateBoolType;
import jp.go.aist.six.oval.model.definitions.EntityStateIPAddressStringType;
import jp.go.aist.six.oval.model.definitions.EntityStateIntType;
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.definitions.StateType;



/**
 * The xinetd state defines the different information 
 * associated with a specific Internet service.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class XinetdState
    extends StateType
{

    //{0..1}
    private EntityStateStringType           protocol;
    private EntityStateStringType           service_name;
    private EntityStateStringType           flags;
    private EntityStateStringType           no_access;
    private EntityStateIPAddressStringType  only_from;
    private EntityStateIntType              port;
    private EntityStateStringType           server;
    private EntityStateStringType           server_arguments;
    private EntityStateStringType           socket_type;
    private EntityStateXinetdTypeStatusType type;
    private EntityStateStringType           user;
    private EntityStateBoolType             wait;
    private EntityStateBoolType             disabled;



    /**
     * Constructor.
     */
    public XinetdState()
    {
        this( null, 0 );
    }


    public XinetdState(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public XinetdState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

        _oval_platform_type = OvalPlatformType.unix;
        _oval_component_type = OvalComponentType.xinetd;
    }



    /**
     */
    public void setProtocol(
                    final EntityStateStringType protocol
                    )
    {
        this.protocol = protocol;
    }


    public EntityStateStringType getProtocol()
    {
        return this.protocol;
    }



    /**
     */
    public void setServiceName(
                    final EntityStateStringType service_name
                    )
    {
        this.service_name = service_name;
    }


    public EntityStateStringType getServiceName()
    {
        return this.service_name;
    }



    /**
     */
    public void setFlags(
                    final EntityStateStringType flags
                    )
    {
        this.flags = flags;
    }


    public EntityStateStringType getFlags()
    {
        return this.flags;
    }



    /**
     */
    public void setNoAccess(
                    final EntityStateStringType no_access
                    )
    {
        this.no_access = no_access;
    }


    public EntityStateStringType getNoAccess()
    {
        return this.no_access;
    }



    /**
     */
    public void setOnlyFrom(
                    final EntityStateIPAddressStringType only_from
                    )
    {
        this.only_from = only_from;
    }


    public EntityStateIPAddressStringType getOnlyFrom()
    {
        return this.only_from;
    }



    /**
     */
    public void setPort(
                    final EntityStateIntType port
                    )
    {
        this.port = port;
    }


    public EntityStateIntType getPort()
    {
        return this.port;
    }



    /**
     */
    public void setServer(
                    final EntityStateStringType server
                    )
    {
        this.server = server;
    }


    public EntityStateStringType getServer()
    {
        return this.server;
    }



    /**
     */
    public void setServerArguments(
                    final EntityStateStringType server_arguments
                    )
    {
        this.server_arguments = server_arguments;
    }


    public EntityStateStringType getServerArguments()
    {
        return this.server_arguments;
    }



    /**
     */
    public void setSocketType(
                    final EntityStateStringType socket_type
                    )
    {
        this.socket_type = socket_type;
    }


    public EntityStateStringType getSocketType()
    {
        return this.socket_type;
    }



    /**
     */
    public void setType(
                    final EntityStateXinetdTypeStatusType type
                    )
    {
        this.type = type;
    }


    public EntityStateXinetdTypeStatusType getType()
    {
        return this.type;
    }



    /**
     */
    public void setUser(
                    final EntityStateStringType user
                    )
    {
        this.user = user;
    }


    public EntityStateStringType getUser()
    {
        return this.user;
    }



    /**
     */
    public void setWait(
                    final EntityStateBoolType wait
                    )
    {
        this.wait = wait;
    }


    public EntityStateBoolType getWait()
    {
        return this.wait;
    }



    /**
     */
    public void setDisabled(
                    final EntityStateBoolType disabled
                    )
    {
        this.disabled = disabled;
    }


    public EntityStateBoolType getDisabled()
    {
        return this.disabled;
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
        if (!(obj instanceof XinetdState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "xinetd_state[" + super.toString()
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
//XinetdState