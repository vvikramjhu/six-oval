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
import jp.go.aist.six.oval.model.sc.EntityItemStringType;
import jp.go.aist.six.oval.model.sc.ItemType;
import jp.go.aist.six.oval.model.sc.StatusEnumeration;



/**
 * The wuaupdatesearcher item outlines information defined 
 * through the Search method of the IUpdateSearcher interface 
 * as part of Microsoft's WUA (Windows Update Agent) API.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class WuaUpdateSearcherItem
    extends ItemType
{

    private EntityItemStringType  search_criteria;
    //{0..1}
    
    private final Collection<EntityItemStringType>  update_id = new ArrayList<EntityItemStringType>();
    //{0..*}



    /**
     * Constructor.
     */
    public WuaUpdateSearcherItem()
    {
        this( 0 );
    }


    public WuaUpdateSearcherItem(
                    final int id
                    )
    {
        this( id, null );
    }


    public WuaUpdateSearcherItem(
                    final int id,
                    final StatusEnumeration status
                    )
    {
        super( id, status );
        
        _oval_platform_type = OvalPlatformType.windows;
        _oval_component_type = OvalComponentType.wuaupdatesearcher;
    }



    /**
     */
    public void setSearchCriteria(
                    final EntityItemStringType search_criteria
                    )
    {
        this.search_criteria = search_criteria;
    }


    public EntityItemStringType getSearchCriteria()
    {
        return this.search_criteria;
    }



    /**
     */
    public void setUpdateId(
                    final Collection<? extends EntityItemStringType> update_ids
                    )
    {
        if (this.update_id != update_ids) {
            this.update_id.clear();
            if (update_ids != null  &&  update_ids.size() > 0) {
                this.update_id.addAll( update_ids );
            }
        }
    }


    public boolean addUpdateId(
                    final EntityItemStringType update_id
                    )
    {
        if (update_id == null) {
            return false;
        }

        return this.update_id.add( update_id );
    }


    public Collection<EntityItemStringType> getUpdateId()
    {
        return this.update_id;
    }


    public Iterator<EntityItemStringType> iterateUpdateId()
    {
        return update_id.iterator();
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
        if (!(obj instanceof WuaUpdateSearcherItem)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "wuaupdatesearcher_item[" + super.toString()
                        + ", search_criteria="  + getSearchCriteria()
                        + ", update_id="        + getUpdateId()
             + "]";
    }
}
//WuaUpdateSearcherItem
