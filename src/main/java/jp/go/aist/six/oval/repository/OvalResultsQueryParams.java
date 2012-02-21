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
        public static final String  RESULT_TRUE_DEF = "result_true_def";
        public static final String  RESULT_FALSE_DEF = "result_false_def";
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
    public void setResult_true_def(
                    final String oval_id
                    )
    {
        set( Key.RESULT_TRUE_DEF, oval_id );
    }


    public String getResult_true_def()
    {
        return get( Key.RESULT_TRUE_DEF );
    }



    /**
     */
    public void setResult_false_def(
                    final String oval_id
                    )
    {
        set( Key.RESULT_FALSE_DEF, oval_id );
    }


    public String getResult_false_def()
    {
        return get( Key.RESULT_FALSE_DEF );
    }

}
//OvalResultsQueryParams

