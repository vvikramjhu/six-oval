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
import jp.go.aist.six.oval.model.sc.EntityItemBoolType;
import jp.go.aist.six.oval.model.sc.EntityItemStringType;
import jp.go.aist.six.oval.model.sc.ItemType;
import jp.go.aist.six.oval.model.sc.StatusEnumeration;



/**
 * The runlevel item holds information
 * about the start or kill state of a specified service at a given runlevel.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class RunlevelItem
    extends ItemType
{

    //{0..1}
    private EntityItemStringType       service_name;
    private EntityItemStringType       runlevel;
    private EntityItemBoolType         start;
    private EntityItemBoolType         kill;



    /**
     * Constructor.
     */
    public RunlevelItem()
    {
        this( 0 );
    }


    public RunlevelItem(
                    final int id
                    )
    {
        this( id, null );
    }


    public RunlevelItem(
                    final int id,
                    final StatusEnumeration status
                    )
    {
        super( id, status );

//        _oval_platform_type = OvalPlatformType.unix;
//        _oval_component_type = OvalComponentType.runlevel;
        _oval_family = Family.UNIX;
        _oval_component = Component.RUNLEVEL;
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
    public void setRunlevel(
                    final EntityItemStringType runlevel
                    )
    {
        this.runlevel = runlevel;
    }


    public EntityItemStringType getRunlevel()
    {
        return runlevel;
    }



    /**
     */
    public void setStart(
                    final EntityItemBoolType start
                    )
    {
        this.start = start;
    }


    public EntityItemBoolType getStart()
    {
        return start;
    }



    /**
     */
    public void setKill(
                    final EntityItemBoolType kill
                    )
    {
        this.kill = kill;
    }


    public EntityItemBoolType getKill()
    {
        return kill;
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
        if (!(obj instanceof RunlevelItem)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "inetd_item[" + super.toString()
                        + ", service_name="     + getServiceName()
                        + ", runlevel="         + getRunlevel()
                        + ", start="            + getStart()
                        + ", kill="             + getKill()
             + "]";
    }

}
//RunlevelItem
