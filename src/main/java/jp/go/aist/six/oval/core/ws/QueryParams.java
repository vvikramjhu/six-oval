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

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;



/**
 * A set of URL query parameters.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class QueryParams
{

    private static final Map<String, String>  _FIELDS_ = Collections.emptyMap();


    private final Map<String, String>  _params = new HashMap<String, String>();



    /**
     * Constructor.
     */
    public QueryParams()
    {
    }



    /**
     * Subclasses may override this to define own key-field mapping.
     */
    protected Map<String, String> _fieldMapping()
    {
        return _FIELDS_;
    }


    public String field(
                    final String key
                    )
    {
        String  field = _fieldMapping().get( key );
        return (field == null ? key : field);
    }



    /**
     */
    public Set<String> keys()
    {
        return _params.keySet();
    }



    /**
     *
     */
    public boolean isEmpty()
    {
        return _params.isEmpty();
    }



    /**
     */
    public void set(
                    final String key,
                    final String value
                    )
    {
        _params.put( key, value );
    }



    public String get(
                    final String key
                    )
    {
        return _params.get( key );
    }



    public String get(
                    final String key,
                    final String defaultValue
                    )
    {
        String  value = get( key );
        return (value == null ? defaultValue : value);
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return _params.toString();
    }

}
// QueryParams

