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

package jp.go.aist.six.oval.model.independent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import jp.go.aist.six.oval.model.ComponentType;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.sc.EntityItemAnySimpleType;
import jp.go.aist.six.oval.model.sc.EntityItemStringType;
import jp.go.aist.six.oval.model.sc.ItemType;



/**
 * This element holds information about specific entries in the LDAP directory.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class LdapItem
    extends ItemType
{

    private EntityItemStringType  suffix;
    //{0..1}

    private EntityItemStringType  relative_dn;
    //{0..1}

    private EntityItemStringType  attribute;
    //{0..1}

    private EntityItemStringType  object_class;
    //{0..1}

    private EntityItemLdaptypeType  ldaptype;
    //{0..1}


    private final Collection<EntityItemAnySimpleType>  value = new ArrayList<EntityItemAnySimpleType>();
    //{0..*}



    /**
     * Constructor.
     */
    public LdapItem()
    {
        this( 0 );
    }


    public LdapItem(
                    final int id
                    )
    {
        super( id );

//        _oval_platform_type = OvalPlatformType.independent;
//        _oval_component_type = OvalComponentType.ldap;
        _oval_family = Family.INDEPENDENT;
        _oval_component = ComponentType.LDAP;
    }



    /**
     */
    public void setSuffix(
                    final EntityItemStringType suffix
                    )
    {
        this.suffix = suffix;
    }


    public EntityItemStringType getSuffix()
    {
        return suffix;
    }



    /**
     */
    public void setRelativeDn(
                    final EntityItemStringType relative_dn
                    )
    {
        this.relative_dn = relative_dn;
    }


    public EntityItemStringType getRelativeDn()
    {
        return relative_dn;
    }



    /**
     */
    public void setAttribute(
                    final EntityItemStringType attribute
                    )
    {
        this.attribute = attribute;
    }


    public EntityItemStringType getAttribute()
    {
        return attribute;
    }



    /**
     */
    public void setLdaptype(
                    final EntityItemLdaptypeType ldaptype
                    )
    {
        this.ldaptype = ldaptype;
    }


    public EntityItemLdaptypeType getLdaptype()
    {
        return ldaptype;
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
        return object_class;
    }



    /**
     */
    public void setValue(
                    final Collection<? extends EntityItemAnySimpleType> values
                    )
    {
        value.clear();
        if (values != null  &&  values.size() > 0) {
            for (EntityItemAnySimpleType  value : values) {
                addValue( value );
            }
        }
    }


    public boolean addValue(
                    final EntityItemAnySimpleType value
                    )
    {
        if (value == null) {
            throw new IllegalArgumentException( "empty value" );
        }

        return this.value.add( value );
    }


    public Collection<EntityItemAnySimpleType> getValue()
    {
        return value;
    }


    public Iterator<EntityItemAnySimpleType> iterateValue()
    {
        return value.iterator();
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
        if (!(obj instanceof LdapItem)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "ldap_item[" + super.toString()
                        + ", suffix="       + getSuffix()
                        + ", relative_dn="  + getRelativeDn()
                        + ", attribute="    + getAttribute()
                        + ", ldaptype="     + getLdaptype()
                        + ", object_class=" + getObjectClass()
                        + ", value="        + getValue()
                        + "]";
    }

}
// LdapItem
