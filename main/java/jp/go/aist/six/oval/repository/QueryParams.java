/*
 *  @product.title@
 *  Copyright (C) @product.copyright-year@
 *    @product.vendor@
 *    Registration Number: @product.registration-number@
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.go.aist.six.oval.repository;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import jp.go.aist.six.oval.model.OvalEnumeration;



/**
 * A set of query parameters to be interpreted as a filter
 * for collections of OVAL objects.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class QueryParams
    implements Cloneable, Serializable
{

    public static final String  LIST_DELIMITER = ",";


    private final Map<String, String>  _params = new HashMap<String, String>();



    /**
     * Constructor.
     */
    public QueryParams()
    {
    }


    public QueryParams(
                    final Map<String, String> params
                    )
    {
        _params.putAll( params );
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
    public QueryParams set(
                    final String key,
                    final String value
                    )
    {
        _params.put( key, value );

        return this;
    }


    public QueryParams set(
                    final String key,
                    final String[] values
                    )
    {
        StringBuilder  s = new StringBuilder();
        boolean  first = true;
        for (String  v : values) {
            if (first) {
                first = false;
            } else {
                s.append( "," );
            }
            s.append( v );
        }
        _params.put( key, s.toString() );

        return this;
    }


    public QueryParams set(
                    final String key,
                    final OvalEnumeration[] values
                    )
    {
        StringBuilder  s = new StringBuilder();
        boolean  first = true;
        for (OvalEnumeration  e : values) {
            if (first) {
                first = false;
            } else {
                s.append( "," );
            }
            s.append( e.value() );
        }
        _params.put( key, s.toString() );

        return this;
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


    public int getAsInt(
                    final String key
                    )
    {
        String  v = _params.get( key );
        if (v == null) {
            throw new IllegalArgumentException( "no such key: " + key );
        }

        return Integer.valueOf( v ).intValue();
    }



    /**
     */
    public boolean containsKey(
                    final String key
                    )
    {
        return _params.containsKey( key );
    }



    /**
     *
     */
    public String remove(
                    final String key
                    )
    {
        return _params.remove( key );
    }



    /**
     *
     */
    public int size()
    {
        return _params.size();
    }



    //**************************************************************
    //  java.lang.Cloneable
    //**************************************************************

    @Override
    public Object clone()
    throws CloneNotSupportedException
    {
        return (new QueryParams( _params ));
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
//

