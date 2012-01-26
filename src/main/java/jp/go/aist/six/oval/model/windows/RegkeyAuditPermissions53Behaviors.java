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



/**
 * The RegkeyAuditPermissions53Behaviors defines a number of behaviors 
 * that allow a more detailed definition of the registrykeyauditedpermissions53 object 
 * being specified.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class RegkeyAuditPermissions53Behaviors
    extends RegistryBehaviors
{

    public static final Boolean  DEFAULT_INCLUDE_GROUP = Boolean.TRUE;

    private Boolean  include_group;
    //{optional, default='true'}


    public static final Boolean  DEFAULT_RESOLVE_GROUP = Boolean.FALSE;

    private Boolean  resolve_group;
    //{optional, default='false'}



    /**
     * Constructor.
     */
    public RegkeyAuditPermissions53Behaviors()
    {
    }



    /**
     */
    public void setIncludeGroup(
                    final Boolean include_group
                    )
    {
        this.include_group = include_group;
    }


    public Boolean getIncludeGroup()
    {
        return this.include_group;
    }


    protected final boolean _includeGroup()
    {
        Boolean  include_group = getIncludeGroup();
        return (include_group == null 
        		? DEFAULT_INCLUDE_GROUP.booleanValue() 
        				: include_group.booleanValue());
    }



    /**
     */
    public void setResolveGroup(
                    final Boolean resolve_group
                    )
    {
        this.resolve_group = resolve_group;
    }


    public Boolean getResolveGroup()
    {
        return this.resolve_group;
    }


    protected final boolean _resolveGroup()
    {
        Boolean  resolve_group = getResolveGroup();
        return (resolve_group == null ? DEFAULT_RESOLVE_GROUP.booleanValue() : resolve_group.booleanValue());
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        result = prime * result + (_includeGroup() ? 0 : 1);
        result = prime * result + (_resolveGroup()  ? 0 : 1);

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

        if (!(obj instanceof RegkeyAuditPermissions53Behaviors)) {
            return false;
        }

        if (super.equals( obj )) {
            RegkeyAuditPermissions53Behaviors  other = (RegkeyAuditPermissions53Behaviors)obj;
            if (this._includeGroup() == other._includeGroup()) {
                if (this._resolveGroup() == other._resolveGroup()) {
                	return true;
                }
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return super.toString()
                        + ", include_group=" + getIncludeGroup()
                        + ", resolve_group=" + getResolveGroup()
                        ;
    }

}
//RegkeyAuditPermissions53Behaviors
