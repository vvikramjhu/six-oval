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

import java.util.ArrayList;
import java.util.Collection;
import jp.go.aist.six.oval.model.ComponentType;
import jp.go.aist.six.oval.model.ElementRef;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.definitions.StateType;



/**
 * The inetd state defines the different information
 * associated with a specific Internet service.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class InetdState
    extends StateType
{

    //{0..1}
    private EntityStateStringType       protocol;
    private EntityStateStringType       service_name;
    private EntityStateStringType       server_program;
    private EntityStateStringType       server_arguments;
    private EntityStateEndpointType     endpoint_type;
    private EntityStateStringType       exec_as_user;
    private EntityStateWaitStatusType   wait_status;



    /**
     * Constructor.
     */
    public InetdState()
    {
        this( null, 0 );
    }


    public InetdState(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public InetdState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

//        _oval_platform_type = OvalPlatformType.unix;
//        _oval_component_type = OvalComponentType.inetd;
        _oval_family = Family.UNIX;
        _oval_component = ComponentType.INETD;
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
        return protocol;
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
        return service_name;
    }



    /**
     */
    public void setServerProgram(
                    final EntityStateStringType server_program
                    )
    {
        this.server_program = server_program;
    }


    public EntityStateStringType getServerProgram()
    {
        return server_program;
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
        return server_arguments;
    }



    /**
     */
    public void setEndpointType(
                    final EntityStateEndpointType endpoint_type
                    )
    {
        this.endpoint_type = endpoint_type;
    }


    public EntityStateEndpointType getEndpointType()
    {
        return endpoint_type;
    }



    /**
     */
    public void setExecAsUser(
                    final EntityStateStringType exec_as_user
                    )
    {
        this.exec_as_user = exec_as_user;
    }


    public EntityStateStringType getExecAsUser()
    {
        return exec_as_user;
    }



    /**
     */
    public void setWaitStatus(
                    final EntityStateWaitStatusType wait_status
                    )
    {
        this.wait_status = wait_status;
    }


    public EntityStateWaitStatusType getWaitStatus()
    {
        return wait_status;
    }



    //*********************************************************************
    //  DefinitionsElement
    //*********************************************************************

    @Override
    public Collection<ElementRef> ovalGetElementRef()
    {
        Collection<ElementRef>  ref_list = new ArrayList<ElementRef>();
        ref_list.add( getProtocol() );
        ref_list.add( getServiceName() );
        ref_list.add( getServerProgram() );
        ref_list.add( getServerArguments() );
        ref_list.add( getEndpointType() );
        ref_list.add( getExecAsUser() );
        ref_list.add( getWaitStatus() );

        return ref_list;
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
        if (!(obj instanceof InetdState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "inetd_state[" + super.toString()
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
//InetdState
