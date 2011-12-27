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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import jp.go.aist.six.oval.model.OvalComponentType;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.sc.EntityItemAnySimpleType;
import jp.go.aist.six.oval.model.sc.EntityItemStringType;
import jp.go.aist.six.oval.model.sc.ItemType;



/**
 * The active directory item holds information about specific entries
 * in the Windows Active Directory.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class ActiveDirectoryItem
    extends ItemType
{

    private EntityItemNamingContextType  naming_context;
    //{0..1}

    private EntityItemStringType  relative_dn;
    //{0..1, nillable="true"}

    private EntityItemStringType  attribute;
    //{0..1, nillable="true"}

    private EntityItemStringType  object_class;
    //{0..1}

    private EntityItemAdstypeType  adstype;
    //{0..1}


    private final Collection<EntityItemAnySimpleType>  value =
        new ArrayList<EntityItemAnySimpleType>();
    //{0..*}



    /**
     * Constructor.
     */
    public ActiveDirectoryItem()
    {
        this( 0 );
    }


    public ActiveDirectoryItem(
                    final int id
                    )
    {
        super( id );

        _oval_platform_type = OvalPlatformType.windows;
        _oval_component_type = OvalComponentType.activedirectory;
    }



    /**
     */
    public void setNamingContext(
                    final EntityItemNamingContextType hive
                    )
    {
        this.naming_context = hive;
    }


    public EntityItemNamingContextType getNamingContext()
    {
        return this.naming_context;
    }



    /**
     */
    public EntityItemStringType getRelativeDn()
    {
        return this.relative_dn;
    }


    public void setRelativeDn(
                    final EntityItemStringType relative_dn
                    )
    {
        this.relative_dn = relative_dn;
    }



    /**
     */
    public EntityItemStringType getAttribute()
    {
        return this.attribute;
    }


    public void setAttribute(
                    final EntityItemStringType attribute
                    )
    {
        this.attribute = attribute;
    }



    /**
     */
    public void setObjectClass(
                    final EntityItemStringType object_class
                    )
    {
        this.object_class = object_class;
    }


    public EntityItemStringType getObjectClass()
    {
        return this.object_class;
    }



    /**
     */
    public EntityItemAdstypeType getAdstype()
    {
        return this.adstype;
    }


    public void setAdstype(
                    final EntityItemAdstypeType adstype
                    )
    {
        this.adstype = adstype;
    }



    /**
     */
    public void setValue(
                    final Collection<? extends EntityItemAnySimpleType> value
                    )
    {
        if (this.value != value) {
            this.value.clear();
            if (value != null  &&  value.size() > 0) {
                this.value.addAll( value );
            }
        }
    }


    public Collection<EntityItemAnySimpleType> getValue()
    {
        return this.value;
    }


    public Iterator<EntityItemAnySimpleType> iterateValue()
    {
        return this.value.iterator();
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "activedirectory_item[" + super.toString()
             + ", naming_context="  + getNamingContext()
             + ", relative_dn="     + getRelativeDn()
             + ", attribute="       + getAttribute()
             + ", object_class="    + getObjectClass()
             + ", asdtype="         + getAdstype()
             + ", value="           + getValue()
             + "]";
    }

}
//ActiveDirectoryItem
