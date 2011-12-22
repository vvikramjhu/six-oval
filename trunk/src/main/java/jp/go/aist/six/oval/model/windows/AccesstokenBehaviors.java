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

import jp.go.aist.six.oval.model.OvalObject;



/**
 * The AccesstokenBehaviors defines a number of behaviors
 * that allow a more detailed definition of the accesstoken object
 * being specified.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class AccesstokenBehaviors
    implements OvalObject
{

    public static final Boolean  DEFAULT_INCLUDE_GROUP =Boolean.TRUE;

    private Boolean  include_group;
    //{optional, default='true'}


    public static final Boolean  DEFAULT_RESOLVE_GROUP =Boolean.TRUE;

    private Boolean  resolve_group;
    //{optional, default='true'}



    /**
     * Constructor.
     */
    public AccesstokenBehaviors()
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


    protected static final Boolean _includeGroup(
                    final AccesstokenBehaviors behaviors
                    )
    {
        Boolean  include_group = behaviors.getIncludeGroup();
        return (include_group == null ? DEFAULT_INCLUDE_GROUP : include_group);
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


    protected static final Boolean _resolveGroup(
                    final AccesstokenBehaviors behaviors
                    )
    {
        Boolean  scope = behaviors.getResolveGroup();
        return (scope == null ? DEFAULT_RESOLVE_GROUP : scope);
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = super.hashCode();

        result = prime * result + _includeGroup( this ).hashCode();
        result = prime * result + _resolveGroup( this ).hashCode();

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

        if (!(obj instanceof AccesstokenBehaviors)) {
            return false;
        }

        if (super.equals( obj )) {
            AccesstokenBehaviors  other = (AccesstokenBehaviors)obj;
            if (_includeGroup( this ) == _includeGroup( other )) {
                if (_resolveGroup( this ) == _resolveGroup( other )) {
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
//AccesstokenBehaviors
