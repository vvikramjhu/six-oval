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
import jp.go.aist.six.oval.model.definitions.EntityStateAnySimpleType;
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.definitions.StateType;



/**
 * The activedirectory state defines the different information
 * that can be used to evaluate the specified entries in active directory.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class ActiveDirectoryState
    extends StateType
{

    private EntityStateNamingContextType  naming_context;
    //{0..1}

    private EntityStateStringType  relative_dn;
    //{0..1}

    private EntityStateStringType  attribute;
    //{0..1}

    private EntityStateStringType  object_class;
    //{0..1}

    private EntityStateAdstypeType  adstype;
    //{0..1}

    private EntityStateAnySimpleType  value;
    //{0..1}



    /**
     * Constructor.
     */
    public ActiveDirectoryState()
    {
        this( null, 0 );
    }


    public ActiveDirectoryState(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public ActiveDirectoryState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

        _oval_platform_type = OvalPlatformType.windows;
        _oval_component_type = OvalComponentType.activedirectory;
    }



    /**
     */
    public void setNamingContext(
                    final EntityStateNamingContextType hive
                    )
    {
        this.naming_context = hive;
    }


    public EntityStateNamingContextType getNamingContext()
    {
        return this.naming_context;
    }



    /**
     */
    public void setRelativeDn(
                    final EntityStateStringType relative_dn
                    )
    {
        this.relative_dn = relative_dn;
    }


    public EntityStateStringType getRelativeDn()
    {
        return this.relative_dn;
    }



    /**
     */
    public void setAttribute(
                    final EntityStateStringType attribute
                    )
    {
        this.attribute = attribute;
    }


    public EntityStateStringType getAttribute()
    {
        return this.attribute;
    }



    /**
     */
    public void setObjectClass(
                    final EntityStateStringType object_class
                    )
    {
        this.object_class = object_class;
    }


    public EntityStateStringType getObjectClass()
    {
        return this.object_class;
    }



    /**
     */
    public void setAdstype(
                    final EntityStateAdstypeType adstype
                    )
    {
        this.adstype = adstype;
    }


    public EntityStateAdstypeType getAdstype()
    {
        return this.adstype;
    }



    /**
     */
    public void setValue(
                    final EntityStateAnySimpleType value
                    )
    {
        this.value = value;
    }


    public EntityStateAnySimpleType getValue()
    {
        return this.value;
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
        if (!(obj instanceof ActiveDirectoryState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "activedirectory_state[" + super.toString()
                        + ", naming_context="   + getNamingContext()
                        + ", relative_dn="      + getRelativeDn()
                        + ", attribute="        + getAttribute()
                        + ", object_class="     + getObjectClass()
                        + ", adstype="          + getAdstype()
                        + ", value="            + getValue()
                        + "]";
    }

}
//ActiveDirectoryState
