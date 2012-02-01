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
import jp.go.aist.six.oval.model.sc.EntityItemIntType;
import jp.go.aist.six.oval.model.sc.EntityItemStringType;
import jp.go.aist.six.oval.model.sc.ItemType;



/**
 * This item describes the SELinux security context of a file or process on the local system.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class SelinuxSecurityContextItem
    extends ItemType
{

    //{0..1}
    private EntityItemStringType   filepath;
    private EntityItemStringType   path;
    private EntityItemStringType   filename;
    private EntityItemIntType      pid;
    private EntityItemStringType   user;
    private EntityItemStringType   role;
    private EntityItemStringType   type;
    private EntityItemStringType   low_sensitivity;
    private EntityItemStringType   low_category;
    private EntityItemStringType   high_sensitivity;
    private EntityItemStringType   high_category;
    private EntityItemStringType   rawlow_sensitivity;
    private EntityItemStringType   rawlow_category;
    private EntityItemStringType   rawhigh_sensitivity;
    private EntityItemStringType   rawhigh_category;



    /**
     * Constructor.
     */
    public SelinuxSecurityContextItem()
    {
        this( 0 );
    }


    public SelinuxSecurityContextItem(
                    final int id
                    )
    {
        super( id );

        _oval_platform_type = OvalPlatformType.linux;
        _oval_component_type = OvalComponentType.selinuxsecuritycontext;
    }



    /**
     */
    public void setFilepath(
                    final EntityItemStringType filepath
                    )
    {
        this.filepath = filepath;
    }


    public EntityItemStringType getFilepath()
    {
        return this.filepath;
    }



    /**
     */
    public void setPath(
                    final EntityItemStringType path
                    )
    {
        this.path = path;
    }


    public EntityItemStringType getPath()
    {
        return this.path;
    }



    /**
     */
    public void setFilename(
                    final EntityItemStringType filename
                    )
    {
        this.filename = filename;
    }


    public EntityItemStringType getFilename()
    {
        return this.filename;
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
        return this.pid;
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
        return this.user;
    }



    /**
     */
    public void setRole(
                    final EntityItemStringType role
                    )
    {
        this.role= role;
    }


    public EntityItemStringType getRole()
    {
        return this.role;
    }



    /**
     */
    public void setType(
                    final EntityItemStringType type
                    )
    {
        this.type = type;
    }


    public EntityItemStringType getType()
    {
        return this.type;
    }



    /**
     */
    public void setLowSensitivity(
                    final EntityItemStringType low_sensitivity
                    )
    {
        this.low_sensitivity = low_sensitivity;
    }


    public EntityItemStringType getLowSensitivity()
    {
        return this.low_sensitivity;
    }



    /**
     */
    public void setLowCategory(
                    final EntityItemStringType low_category
                    )
    {
        this.low_category = low_category;
    }


    public EntityItemStringType getLowCategory()
    {
        return this.low_category;
    }



    /**
     */
    public void setHighSensitivity(
                    final EntityItemStringType high_sensitivity
                    )
    {
        this.high_sensitivity = high_sensitivity;
    }


    public EntityItemStringType getHighSensitivity()
    {
        return this.high_sensitivity;
    }



    /**
     */
    public void setHighCategory(
                    final EntityItemStringType high_category
                    )
    {
        this.high_category = high_category;
    }


    public EntityItemStringType getHighCategory()
    {
        return this.high_category;
    }



    /**
     */
    public void setRawLowSensitivity(
                    final EntityItemStringType rawlow_sensitivity
                    )
    {
        this.rawlow_sensitivity = rawlow_sensitivity;
    }


    public EntityItemStringType getRawLowSensitivity()
    {
        return this.rawlow_sensitivity;
    }



    /**
     */
    public void setRawLowCategory(
                    final EntityItemStringType rawlow_category
                    )
    {
        this.rawlow_category = rawlow_category;
    }


    public EntityItemStringType getRawLowCategory()
    {
        return this.rawlow_category;
    }



    /**
     */
    public void setRawHighSensitivity(
                    final EntityItemStringType rawhigh_sensitivity
                    )
    {
        this.rawhigh_sensitivity = rawhigh_sensitivity;
    }


    public EntityItemStringType getRawHighSensitivity()
    {
        return this.rawhigh_sensitivity;
    }



    /**
     */
    public void setRawHighCategory(
                    final EntityItemStringType rawhigh_category
                    )
    {
        this.rawhigh_category = rawhigh_category;
    }


    public EntityItemStringType getRawHighCategory()
    {
        return this.rawhigh_category;
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
        if (!(obj instanceof SelinuxSecurityContextItem)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "selinuxsecuritycontext_item[" + super.toString()
                        + ", filepath="             + getFilepath()
                        + ", path="                 + getPath()
                        + ", filename="             + getFilename()
                        + ", pid="                  + getPid()
                        + ", user="                 + getUser()
                        + ", role="                 + getRole()
                        + ", type="                 + getType()
                        + ", low_sensitivity="      + getLowSensitivity()
                        + ", low_category="         + getLowCategory()
                        + ", high_sensitivity="     + getHighSensitivity()
                        + ", high_category="        + getHighCategory()
                        + ", rawlow_sensitivity="   + getRawLowSensitivity()
                        + ", rawlow_category="      + getRawLowCategory()
                        + ", rawhigh_sensitivity="  + getRawHighSensitivity()
                        + ", rawhigh_category="     + getRawHighCategory()
                        + "]";
    }

}
//SelinuxSecurityContextItem
