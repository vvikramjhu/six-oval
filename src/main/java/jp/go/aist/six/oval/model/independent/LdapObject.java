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

import jp.go.aist.six.oval.model.Component;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.definitions.EntityObjectStringType;
import jp.go.aist.six.oval.model.definitions.Set;
import jp.go.aist.six.oval.model.definitions.SystemObjectType;



/**
 * The ldap object is used by an LDAP test to define the objects
 * to be evaluated based on a specified state.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class LdapObject
    extends SystemObjectType
{
    // XSD model:
    // choice(
    //         set
    //         sequence(
    //                   behaviors
    //                   suffix
    //                   relative_dn
    //                   attribute
    //          )
    // )

    private Set  set;

    private LdapBehaviors  behaviors;
    //{0..1}

    private EntityObjectStringType  suffix;

    private EntityObjectStringType  relative_dn;
    //{nillable="true"}

    private EntityObjectStringType  attribute;
    //{nillable="true"}



    /**
     * Constructor.
     */
    public LdapObject()
    {
        this( null, 0 );
    }


    public LdapObject(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public LdapObject(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

//        _oval_platform_type = OvalPlatformType.independent;
//        _oval_component_type = OvalComponentType.ldap;
        _oval_family = Family.INDEPENDENT;
        _oval_component = Component.LDAP;
    }



    /**
     */
    public void setSet(
                    final Set set
                    )
    {
        this.set = set;
    }


    public Set getSet()
    {
        return set;
    }



    /**
     */
    public void setBehaviors(
                    final LdapBehaviors behaviors
                    )
    {
        this.behaviors = behaviors;
    }


    public LdapBehaviors getBehaviors()
    {
        return behaviors;
    }



    /**
     */
    public void setSuffix(
                    final EntityObjectStringType suffix
                    )
    {
        this.suffix = suffix;
    }


    public EntityObjectStringType getSuffix()
    {
        return suffix;
    }



    /**
     */
    public void setRelativeDn(
                    final EntityObjectStringType relative_dn
                    )
    {
        this.relative_dn = relative_dn;
    }


    public EntityObjectStringType getRelativeDn()
    {
        return relative_dn;
    }



    /**
     */
    public void setAttribute(
                    final EntityObjectStringType attribute
                    )
    {
        this.attribute = attribute;
    }


    public EntityObjectStringType getAttribute()
    {
        return attribute;
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
        if (!(obj instanceof LdapObject)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "ldap_object[" + super.toString()
                        + ", set="       + getSet()
                        + ", behaviors=" + getBehaviors()
                        + ", suffix="    + getSuffix()
                        + ", relative_dn=" + getRelativeDn()
                        + ", attribute=" + getAttribute()
                       + "]";
    }

}
//LdapObject
