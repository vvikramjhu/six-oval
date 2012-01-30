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
 * The WuaUpdateSearcherBehaviors defines behaviors that allow 
 * a more detailed definition of the wuaupdatesearcher object being specified. 
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class WuaUpdateSearcherBehaviors
    implements OvalObject
{

    public static final Boolean  DEFAULT_INCLUDE_SUPERSEDED_UPDATES = Boolean.TRUE;

    private Boolean  include_superseded_updates;
    //{optional, default='true'}


    
    /**
     * Constructor.
     */
    public WuaUpdateSearcherBehaviors()
    {
    }



    /**
     */
    public void setIncludeSupersededUpdates(
                    final Boolean include_superseded_updates
                    )
    {
        this.include_superseded_updates = include_superseded_updates;
    }


    public Boolean getIncludeSupersededUpdates()
    {
        return this.include_superseded_updates;
    }


    protected final boolean _includeSupersededUpdates()
    {
        Boolean  include_group = getIncludeSupersededUpdates();
        return (include_group == null 
        		        ? DEFAULT_INCLUDE_SUPERSEDED_UPDATES.booleanValue() 
        				: include_group.booleanValue());
    }


    public static boolean includeSupersededUpdates(
                    final WuaUpdateSearcherBehaviors behaviors 
                    )
    {
        if (behaviors == null) {
            return DEFAULT_INCLUDE_SUPERSEDED_UPDATES.booleanValue();
        }
        
        Boolean  include_group = behaviors.getIncludeSupersededUpdates();
        return (include_group == null
                        ? DEFAULT_INCLUDE_SUPERSEDED_UPDATES.booleanValue() 
                        : include_group.booleanValue());
    }





    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        result = prime * result + (includeSupersededUpdates( this ) ? 0 : 1);

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

        if (!(obj instanceof WuaUpdateSearcherBehaviors)) {
            return false;
        }

        if (super.equals( obj )) {
            WuaUpdateSearcherBehaviors  other = (WuaUpdateSearcherBehaviors)obj;
            if (includeSupersededUpdates( this ) == includeSupersededUpdates( other )) {
                return true;
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return super.toString()
                        + ", include_superseded_updates=" + getIncludeSupersededUpdates()
                        ;
    }

}
//WuaUpdateSearcherBehaviors
