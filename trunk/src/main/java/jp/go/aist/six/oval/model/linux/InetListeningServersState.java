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

package jp.go.aist.six.oval.model.linux;

import java.util.ArrayList;
import java.util.Collection;
import jp.go.aist.six.oval.model.Component;
import jp.go.aist.six.oval.model.ElementRef;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.definitions.EntityStateIPAddressStringType;
import jp.go.aist.six.oval.model.definitions.EntityStateIntType;
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.definitions.StateType;



/**
 * The inetlisteningservers state defines the different information
 * that can be used to evaluate the specified inet listening server.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class InetListeningServersState
    extends StateType
{

    //{0..1}
    private EntityStateStringType           protocol;
    private EntityStateIPAddressStringType  local_address;
    private EntityStateIntType              local_port;
    private EntityStateStringType           local_full_address;
    private EntityStateStringType           program_name;
    private EntityStateIPAddressStringType  foreign_address;
    private EntityStateIntType              foreign_port;
    private EntityStateStringType           foreign_full_address;
    private EntityStateIntType              pid;
    private EntityStateIntType              user_id;



    /**
     * Constructor.
     */
    public InetListeningServersState()
    {
        this( null, 0 );
    }


    public InetListeningServersState(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public InetListeningServersState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

//        _oval_platform_type = OvalPlatformType.linux;
//        _oval_component_type = OvalComponentType.inetlisteningservers;
        _oval_family = Family.LINUX;
        _oval_component = Component.INETLISTENINGSERVERS;
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
    public void setLocalFullAddress(
                    final EntityStateStringType local_full_address
                    )
    {
        this.local_full_address = local_full_address;
    }


    public EntityStateStringType getLocalFullAddress()
    {
        return local_full_address;
    }



    /**
     */
    public void setProgramName(
                    final EntityStateStringType program_name
                    )
    {
        this.program_name = program_name;
    }


    public EntityStateStringType getProgramName()
    {
        return program_name;
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



    /**
     */
    public void setForeignFullAddress(
                    final EntityStateStringType foreign_full_address
                    )
    {
        this.foreign_full_address = foreign_full_address;
    }


    public EntityStateStringType getForeignFullAddress()
    {
        return foreign_full_address;
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
    public void setUserId(
                    final EntityStateIntType user_id
                    )
    {
        this.user_id = user_id;
    }


    public EntityStateIntType getUserId()
    {
        return user_id;
    }



    //*********************************************************************
    //  DefinitionsElement
    //*********************************************************************

    @Override
    public Collection<ElementRef> ovalGetElementRef()
    {
        Collection<ElementRef>  ref_list = new ArrayList<ElementRef>();
        ref_list.add( getProtocol() );
        ref_list.add( getLocalAddress() );
        ref_list.add( getLocalPort() );
        ref_list.add( getLocalFullAddress() );
        ref_list.add( getProgramName() );
        ref_list.add( getForeignAddress() );
        ref_list.add( getForeignPort() );
        ref_list.add( getForeignFullAddress() );
        ref_list.add( getPid() );
        ref_list.add( getUserId() );

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
        if (!(obj instanceof InetListeningServersState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "inetlisteningservers_state[" + super.toString()
                        + ", protocol="             + getProtocol()
                        + ", local_address="        + getLocalAddress()
                        + ", local_port="           + getLocalPort()
                        + ", local_full_address="   + getLocalFullAddress()
                        + ", program_name="         + getProgramName()
                        + ", foreign_address="      + getForeignAddress()
                        + ", foreign_port="         + getForeignPort()
                        + ", foreign_full_address=" + getForeignFullAddress()
                        + ", pid="                  + getPid()
                        + ", user_id="              + getUserId()
                        + "]";
    }

}
//InetListeningServersState
