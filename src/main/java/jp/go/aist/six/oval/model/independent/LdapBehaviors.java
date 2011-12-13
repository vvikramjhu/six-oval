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

import jp.go.aist.six.oval.model.OvalObject;



/**
 * The LdapBehaviors defines a number of behaviors that allow
 * a more detailed definition of the ldap_object being specified.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class LdapBehaviors
    implements OvalObject
{

    public static final LdapBehaviorsEnumeration  DEFAULT_SCOPE =
        LdapBehaviorsEnumeration.BASE;

    private LdapBehaviorsEnumeration  scope;
    //{optional, default='BASE'}



    /**
     * Constructor.
     */
    public LdapBehaviors()
    {
    }



    /**
     */
    public void setScope(
                    final LdapBehaviorsEnumeration scope
                    )
    {
        this.scope = scope;
    }


    public LdapBehaviorsEnumeration getScope()
    {
        return this.scope;
    }


    protected static final LdapBehaviorsEnumeration _scope(
                    final LdapBehaviors behaviors
                    )
    {
        LdapBehaviorsEnumeration  scope = behaviors.getScope();
        return (scope == null ? DEFAULT_SCOPE : scope);
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = super.hashCode();

        result = prime * result + _scope( this ).hashCode();

        return result;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof LdapBehaviors)) {
            return false;
        }

        if (super.equals( obj )) {
            LdapBehaviors  other = (LdapBehaviors)obj;
            if (_scope( this ) == _scope( other )) {
                return true;
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return super.toString()
                        + ", scope=" + getScope()
                        ;
    }

}
// LdapBehaviors
