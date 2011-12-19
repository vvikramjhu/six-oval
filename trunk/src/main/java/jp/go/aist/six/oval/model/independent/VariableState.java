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

import jp.go.aist.six.oval.model.OvalComponentType;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.definitions.EntityStateAnySimpleType;
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.definitions.StateType;



/**
 * The ldap state defines the different information that can be used
 * to evaluate the specified entries in an LDAP directory.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class LdapState
    extends StateType
{

    private EntityStateStringType  suffix;
    //{0..1}

    private EntityStateStringType  relative_dn;
    //{0..1}

    private EntityStateStringType  attribute;
    //{0..1}

    private EntityStateStringType  object_class;
    //{0..1}

    private EntityStateLdaptypeType  ldaptype;
    //{0..1}


    private EntityStateAnySimpleType  value;
    //{0..1}



    /**
     * Constructor.
     */
    public LdapState()
    {
        this( null, 0 );
    }


    public LdapState(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public LdapState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

        _oval_platform_type = OvalPlatformType.independent;
        _oval_component_type = OvalComponentType.ldap;
    }



    /**
     */
    public void setSuffix(
                    final EntityStateStringType suffix
                    )
    {
        this.suffix = suffix;
    }


    public EntityStateStringType getSuffix()
    {
        return this.suffix;
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
    public void setLdaptype(
                    final EntityStateLdaptypeType ldaptype
                    )
    {
        this.ldaptype = ldaptype;
    }


    public EntityStateLdaptypeType getLdaptype()
    {
        return this.ldaptype;
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
        if (!(obj instanceof LdapState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "ldap_state[" + super.toString()
                        + ", suffix="       + getSuffix()
                        + ", relative_dn="  + getRelativeDn()
                        + ", attribute="    + getAttribute()
                        + ", object_class=" + getObjectClass()
                        + ", ldaptype="     + getLdaptype()
                        + ", value="        + getValue()
                        + "]";
    }

}
// LdapState
