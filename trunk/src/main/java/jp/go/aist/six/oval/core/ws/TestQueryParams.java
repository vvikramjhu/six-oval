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
    extends OvalEntityQueryParams
{

    public static class Key
    extends OvalEntityQueryParams.Key
    {
        public static final String  OBJECT_REF  = "object_ref";
        public static final String  STATE_REF   = "state_ref";
    }
    // Key



    /**
     * Constructor.
     */
    public TestQueryParams()
    {
    }



    /**
     */
    public void setObject_ref(
                    final String object_ref
    )
    {
        set( Key.OBJECT_REF, object_ref );
    }


    public String getObject_ref()
    {
        return get( Key.OBJECT_REF );
    }



    /**
     */
    public void setState_ref(
                    final String state_ref
    )
    {
        set( Key.STATE_REF, state_ref );
    }


    public String getState_ref()
    {
        return get( Key.STATE_REF );
    }

}
// TestQueryParams

