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

package jp.go.aist.six.oval.repository;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalResultsQueryParams
    extends OvalSystemCharacteristicsQueryParams
{

    public static class Key
    extends OvalSystemCharacteristicsQueryParams.Key
    {
        public static final String  DEFINITION = "definition";
        public static final String  DEFINITION_TRUE = "definition_true";
    }
    // Key



    /**
     * Constructor.
     */
    public OvalResultsQueryParams()
    {
    }



    /**
     */
    public void setDefinition(
                    final String oval_id
                    )
    {
        set( Key.DEFINITION, oval_id );
    }


    public String getDefinition()
    {
        return get( Key.DEFINITION );
    }



    /**
     */
    public void setDefinitionTrue(
                    final String oval_id
                    )
    {
        set( Key.DEFINITION_TRUE, oval_id );
    }


    public String getDefinitionTrue()
    {
        return get( Key.DEFINITION_TRUE );
    }

}
//OvalResultsQueryParams

