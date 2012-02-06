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

import jp.go.aist.six.oval.model.OvalComponentType;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.definitions.EntityStateAnySimpleType;
import jp.go.aist.six.oval.model.definitions.EntityStateEVRStringType;
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.definitions.StateType;



/**
 * The dpkginfo state defines the different information
 * that can be used to evaluate the specified DPKG package.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class DpkgInfoState
    extends StateType
{

    //{0..1}
    private EntityStateStringType       name;
    private EntityStateStringType       arch;
    private EntityStateAnySimpleType    epoch;
    private EntityStateAnySimpleType    release;
    private EntityStateAnySimpleType    version;
    private EntityStateEVRStringType    evr;

    
    
    /**
     * Constructor.
     */
    public DpkgInfoState()
    {
        this( null, 0 );
    }


    public DpkgInfoState(
                    final String id,
                    final int version
                    )
    {
        super( id, version );

        _oval_platform_type = OvalPlatformType.linux;
        _oval_component_type = OvalComponentType.dpkginfo;
    }



    /**
     */
    public void setName(
                    final EntityStateStringType name
                    )
    {
        this.name = name;
    }


    public EntityStateStringType getName()
    {
        return this.name;
    }



    /**
     */
    public void setArch(
                    final EntityStateStringType arch
                    )
    {
        this.arch = arch;
    }


    public EntityStateStringType getArch()
    {
        return this.arch;
    }



    /**
     */
    public void setEpoch(
                    final EntityStateAnySimpleType epoch
                    )
    {
        this.epoch = epoch;
    }


    public EntityStateAnySimpleType getEpoch()
    {
        return this.epoch;
    }



    /**
     */
    public void setRelease(
                    final EntityStateAnySimpleType release
                    )
    {
        this.release = release;
    }


    public EntityStateAnySimpleType getRelease()
    {
        return this.release;
    }



    /**
     */
    public void setVersion(
                    final EntityStateAnySimpleType version
                    )
    {
        this.version = version;
    }


    public EntityStateAnySimpleType getVersion()
    {
        return this.version;
    }

    
    
    /**
     */
    public void setEvr(
                    final EntityStateEVRStringType evr
                    )
    {
        this.evr = evr;
    }


    public EntityStateEVRStringType getEvr()
    {
        return this.evr;
    }


    public DpkgInfoState evr(
                    final EntityStateEVRStringType evr
                    )
    {
        setEvr( evr );
        return this;
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
        if (!(obj instanceof DpkgInfoState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "dpkginfo_state[" + super.toString()
                        + ", name="     + getName()
                        + ", arch="     + getArch()
                        + ", epoch="    + getEpoch()
                        + ", release="  + getRelease()
                        + ", version="  + getVersion()
                        + ", evr="      + getEvr()
                        + "]";
    }

}
//DpkgInfoState
