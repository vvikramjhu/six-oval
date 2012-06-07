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

import jp.go.aist.six.oval.model.ComponentType;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.sc.EntityItemIPAddressStringType;
import jp.go.aist.six.oval.model.sc.EntityItemIntType;
import jp.go.aist.six.oval.model.sc.EntityItemStringType;
import jp.go.aist.six.oval.model.sc.ItemType;



/**
 * An inet listening server item stores the results of checking
 * for network servers currently active on a system.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class InetListeningServersItem
    extends ItemType
{

    //{0..1}
    private EntityItemStringType           protocol;
    private EntityItemIPAddressStringType  local_address;
    private EntityItemIntType              local_port;
    private EntityItemStringType           local_full_address;
    private EntityItemStringType           program_name;
    private EntityItemIPAddressStringType  foreign_address;
    private EntityItemIntType              foreign_port;
    private EntityItemStringType           foreign_full_address;
    private EntityItemIntType              pid;
    private EntityItemIntType              user_id;



    /**
     * Constructor.
     */
    public InetListeningServersItem()
    {
        this( 0 );
    }


    public InetListeningServersItem(
                    final int id
                    )
    {
        super( id );

//        _oval_platform_type = OvalPlatformType.linux;
//        _oval_component_type = OvalComponentType.inetlisteningservers;
        _oval_family = Family.LINUX;
        _oval_component = ComponentType.INETLISTENINGSERVERS;
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
    public void setLocalAddress(
                    final EntityItemIPAddressStringType local_address
                    )
    {
        this.local_address = local_address;
    }


    public EntityItemIPAddressStringType getLocalAddress()
    {
        return local_address;
    }



    /**
     */
    public void setLocalPort(
                    final EntityItemIntType local_port
                    )
    {
        this.local_port = local_port;
    }


    public EntityItemIntType getLocalPort()
    {
        return local_port;
    }



    /**
     */
    public void setLocalFullAddress(
                    final EntityItemStringType local_full_address
                    )
    {
        this.local_full_address = local_full_address;
    }


    public EntityItemStringType getLocalFullAddress()
    {
        return local_full_address;
    }



    /**
     */
    public void setProgramName(
                    final EntityItemStringType program_name
                    )
    {
        this.program_name = program_name;
    }


    public EntityItemStringType getProgramName()
    {
        return program_name;
    }



    /**
     */
    public void setForeignAddress(
                    final EntityItemIPAddressStringType foreign_address
                    )
    {
        this.foreign_address = foreign_address;
    }


    public EntityItemIPAddressStringType getForeignAddress()
    {
        return foreign_address;
    }



    /**
     */
    public void setForeignPort(
                    final EntityItemIntType foreign_port
                    )
    {
        this.foreign_port = foreign_port;
    }


    public EntityItemIntType getForeignPort()
    {
        return foreign_port;
    }



    /**
     */
    public void setForeignFullAddress(
                    final EntityItemStringType foreign_full_address
                    )
    {
        this.foreign_full_address = foreign_full_address;
    }


    public EntityItemStringType getForeignFullAddress()
    {
        return foreign_full_address;
    }



    /**
     */
    public void setPid(
                    final EntityItemIntType pid
                    )
    {
        this.pid = pid;
    }


    public EntityItemIntType getPid()
    {
        return pid;
    }



    /**
     */
    public void setUserId(
                    final EntityItemIntType user_id
                    )
    {
        this.user_id = user_id;
    }


    public EntityItemIntType getUserId()
    {
        return user_id;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "inetlisteningserver_item[" + super.toString()
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
//InetListeningServersItem
