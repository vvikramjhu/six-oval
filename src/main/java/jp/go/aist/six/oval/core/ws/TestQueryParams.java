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

package jp.go.aist.six.oval.core.ws;





/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class TestQueryParams
    extends BasicQueryParams
{

    /**
     * The default sorting order.
     */
    public static final String  DEFAULT_ORDER = "oval_id";



    /**
     * Constructor.
     */
    public TestQueryParams()
    {
        setOrder( DEFAULT_ORDER );
    }



    /**
     */
    public void setId(
                    final String id
    )
    {
        set( DefinitionQueryKey.ID, id );
    }


    public String getId()
    {
        return String.class.cast( get( DefinitionQueryKey.ID ) );
    }



    /**
     */
    public void setVersion(
                    final String version
    )
    {
        set( DefinitionQueryKey.VERSION, version );
    }


    public String getVersion()
    {
        return String.class.cast( get( DefinitionQueryKey.VERSION ) );
    }



    /**
     */
    public void setObject_ref(
                    final String object_ref
    )
    {
        set( TestQueryKey.OBJECT_REF, object_ref );
    }


    public String getObject_ref()
    {
        return String.class.cast( get( TestQueryKey.OBJECT_REF ) );
    }



    /**
     */
    public void setState_ref(
                    final String state_ref
    )
    {
        set( TestQueryKey.STATE_REF, state_ref );
    }


    public String getState_ref()
    {
        return String.class.cast( get( TestQueryKey.STATE_REF ) );
    }



    /**
     */
    public void setType(
                    final String type
    )
    {
        set( TestQueryKey.TYPE, type );
    }


    public String getType()
    {
        return String.class.cast( get( TestQueryKey.TYPE ) );
    }

}
// TestQueryParams
