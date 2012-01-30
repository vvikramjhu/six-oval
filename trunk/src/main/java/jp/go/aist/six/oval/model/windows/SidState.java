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

import jp.go.aist.six.oval.model.OvalComponentType;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.definitions.StateType;



/**
 * The sid state defines the different metadata 
 * associate with a Windows trustee (identified by name). 
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class SidState
    extends StateType
{

    //{0..1}
    private EntityStateStringType   trustee_name;
    private EntityStateStringType   trustee_sid;
    private EntityStateStringType   trustee_domain;



    /**
     * Constructor.
     */
    public SidState()
    {
        this( null, 0 );
    }


    public SidState(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public SidState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

        _oval_platform_type = OvalPlatformType.windows;
        _oval_component_type = OvalComponentType.sid;
    }



    /**
     */
    public void setTrusteeName(
                    final EntityStateStringType trustee_name
                    )
    {
        this.trustee_name = trustee_name;
    }


    public EntityStateStringType getTrusteeName()
    {
        return this.trustee_name;
    }



    /**
     */
    public void setTrusteeSid(
                    final EntityStateStringType trustee_sid
                    )
    {
        this.trustee_sid = trustee_sid;
    }


    public EntityStateStringType getTrusteeSid()
    {
        return this.trustee_sid;
    }



    /**
     */
    public void setTrusteeDomain(
                    final EntityStateStringType trustee_domain
                    )
    {
        this.trustee_domain = trustee_domain;
    }


    public EntityStateStringType getTrusteeDomain()
    {
        return this.trustee_domain;
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
        if (!(obj instanceof SidState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "sid_state[" + super.toString()
             + ", trustee_name="    + getTrusteeName()
             + ", trustee_sid="     + getTrusteeSid()
             + ", trustee_domain="  + getTrusteeDomain()
             + "]";
    }
}
//SidState
