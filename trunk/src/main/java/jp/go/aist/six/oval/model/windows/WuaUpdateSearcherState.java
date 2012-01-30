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
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.definitions.StateType;



/**
 * The wuaupdatesearcher state defines entities that can be tested 
 * related to a uaupdatesearcher object. 
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class WuaUpdateSearcherState
    extends StateType
{

    //{0..1}
    private EntityStateStringType       search_criteria;
    private EntityStateStringType       update_id;



    /**
     * Constructor.
     */
    public WuaUpdateSearcherState()
    {
        this( null, 0 );
    }


    public WuaUpdateSearcherState(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public WuaUpdateSearcherState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

        _oval_platform_type = OvalPlatformType.windows;
        _oval_component_type = OvalComponentType.wuaupdatesearcher;
    }



    /**
     */
    public void setSearchCriteria(
                    final EntityStateStringType search_criteria
                    )
    {
        this.search_criteria = search_criteria;
    }


    public EntityStateStringType getSearchCriteria()
    {
        return this.search_criteria;
    }



    /**
     */
    public void setUpdateId(
                    final EntityStateStringType update_id
                    )
    {
        this.update_id = update_id;
    }


    public EntityStateStringType getUpdateId()
    {
        return this.update_id;
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
        if (!(obj instanceof WuaUpdateSearcherState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "wuaupdatesearcher_state[" + super.toString()
             + ", search_criteria="     + getSearchCriteria()
             + ", update_id="           + getUpdateId()
             + "]";
    }
}
//WuaUpdateSearcherState
