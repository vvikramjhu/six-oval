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

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import com.google.code.morphia.query.Query;




/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class QueryParams<T>
//extends Properties
{

    public static final String  LIMIT  = "limit";
    public static final String  OFFSET = "offset";
    public static final String  ORDER  = "order";

    public static final String  DEFAULT_LIMIT = "10";
//    public static final String  DEFAULT_OFFSET = "0";




//    private final Properties  _params = new Properties();



    /**
     * Constructor.
     */
    public QueryParams()
    {
        Handler  offsetHandler = new Handler( "offset", null )
        {
            @Override
            public void buildQuery(
                            final Query<?> query
                            )
            {
                String  offset = getValue();
                if (offset != null) {
                    query.offset( _asInt( offset ) );
                }
            }
        };

        Handler  limitHandler = new Handler( "limit", null )
        {
            @Override
            public void buildQuery(
                            final Query<?> query
                            )
            {
                String  limit = getValue();
                if (limit != null) {
                    query.limit( _asInt( limit ) );
                }
            }
        };

        _addHandler( offsetHandler );
        _addHandler( limitHandler );
        _addHandler( new OrderHandler( this ) );
    }



    private final Map<String, Handler>  _handlers = new HashMap<String, Handler>();


    protected final void _addHandler(
                    final Handler handler
                    )
    {
        if (handler == null) {
            throw new IllegalArgumentException( "null handler" );
        }

        _handlers.put( handler.queryKey, handler );
    }


    protected final String _toField(
                    final String queryKey
                    )
    {
        Handler  handler = _handlers.get( queryKey );
        if (handler == null) {
            throw new IllegalArgumentException( "unknown query key: " + queryKey );
        }

        return handler.field;
    }



    //==============================================================
    //  key-value handling
    //==============================================================

    /**
     */
    protected void _setParam(
                    final String key,
                    final String value
                    )
    {
        Handler  handler = _handlers.get( key );
        if (handler == null) {
            throw new IllegalArgumentException( "unknown query param: " + key );
        }

        handler.setValue( value );


//        _params.setProperty( key, value );
    }


    protected String _getParam(
                    final String key
                    )
    {
        Handler  handler = _handlers.get( key );
        if (handler == null) {
            throw new IllegalArgumentException( "unknown query param: " + key );
        }

        return handler.getValue();

//        return _params.getProperty( key );
    }


    protected String _getParam(
                    final String key,
                    final String defaultValue
                    )
    {
        String  value = _getParam( key );
        return (value == null ? defaultValue : value);

//        return _params.getProperty( key, defaultValue );
    }


//    protected int _getIntParam(
//                    final String key
//                    )
//    {
//        String  value = _getParam( key );
//        if (value == null) {
//            throw new IllegalArgumentException( "no such param: " + key );
//        }
//
//        return Integer.valueOf( value ).intValue();
//    }



    /**
     */
    protected int _asInt(
                    final String value
                    )
    {
        return Integer.valueOf( value ).intValue();
                       //throws NumberFormatException (runtime)
    }




    //==============================================================
    //  Query building
    //==============================================================

    /**
     */
    public void buildQuery(
                    final Query<T> query
                    )
    {
        for (Handler  handler : _handlers.values()) {
            handler.buildQuery( query );
        }

//        _buildLimit( query );
//        _buildOffset( query );
//        _buildOrder( query );
    }



    /**
     */
    protected void _buildFilterQueryParam(
                    final Query<T> query,
                    final String param
    )
    {
        String  value = _getParam( param );
        if (value != null) {
            query.filter( param, value );
        }
    }



    //==============================================================
    //  common params
    //==============================================================

    /**
     * @param   limit
     *  a maximum number of results to return.
     */
    public void setLimit(
                    final String limit
    )
    {
        if (limit != null) {
            if (_asInt( limit ) < 1) {
                throw new IllegalArgumentException( "negative or zero limit: " + limit );
            }
            _setParam( LIMIT, limit );
        }
    }


    public String getLimit()
    {
        return _getParam( LIMIT, DEFAULT_LIMIT );
    }


    protected void _buildLimit(
                    final Query<T> query
                    )
    {
        int  limit = _asInt( getLimit() );
        query.limit( limit );
    }



    /**
     * @param   offset
     *  at which object the service should begin returning results.
     */
    public void setOffset(
                    final String offset
    )
    {
        if (offset != null) {
            if (_asInt( offset ) < 0) {
                throw new IllegalArgumentException( "negative offset: " + offset );
            }
            _setParam( OFFSET, offset );
        }

    }


    public String getOffset()
    {
        return _getParam( OFFSET );
    }


    protected void _buildOffset(
                    final Query<T> query
                    )
    {
        String  offset = getOffset();
        if (offset != null) {
            query.offset( _asInt( offset ) );
        }
    }



    /**
     * @param   order
     *  items be returned in a particular order.
     *  The content must be comma-separated, e.g. "age,-date"
     */
    public void setOrder(
                    final String order
    )
    {
        _setParam( ORDER, order );
    }


    public String getOrder()
    {
        return _getParam( ORDER );
    }


//    protected List<String> _orderAsList()
//    {
//        String  order = getOrder();
//        if (order == null) {
//            return Collections.emptyList();
//        } else {
//            String[]  array = order.split( "," );
//            return Arrays.asList( array );
//        }
//    }


    protected void _buildOrder(
                    final Query<T> query
                    )
    {
        String  order = getOrder();
        if (order != null) {
            query.order( order );
        }
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return _handlers.toString();

//        return _params.toString();
    }



    //**************************************************************
    //  nested classes
    //**************************************************************


    protected static class Handler
    {
        public final String  queryKey;
        public final String  field;
        public String  _value;


        public Handler(
                        final String queryKey,
                        final String field
                        )
        {
            if (queryKey == null) {
                throw new IllegalArgumentException( "null query key" );
            }

            this.queryKey = queryKey;
            this.field = field;
        }


        public final void setValue(
                        final String value
                        )
        {
            _value = value;
        }


        public final String getValue()
        {
            return _value;
        }


        public void buildQuery(
                        final Query<?> query
                        )
        {
            String  value = getValue();
            if (value != null) {
                query.filter( field, value );
            }
        }



        //**************************************************************
        //  java.lang.Object
        //**************************************************************

        @Override
        public String toString()
        {
            return String.valueOf( field ) + "=" + getValue();
        }

    }
    // Handler



    protected static class OrderHandler
    extends Handler
    {
        private final QueryParams<?>  _params;


        public OrderHandler(
                        final QueryParams<?> queryParams
                        )
        {
            super( "order", null );
            _params = queryParams;
        }


        @Override
        public void buildQuery(
                        final Query<?> query
                        )
        {
            String  order = getValue();
            if (order == null) {
                return;
            }

            StringBuilder  s = new StringBuilder();
            String[]  keys = order.split( "," );
            for (String  key : keys) {
                if (s.length() > 0) {
                    s.append( "," );
                }

                if (key.startsWith( "-" )) {
                    key = key.substring( 1 );
                    s.append( "-" );
                }
                s.append( _params._toField( key ) );
            }

            query.order( s.toString() );
        }

    }
    // OrderHandler



    protected static class PatternHandler
    extends Handler
    {

        public PatternHandler(
                        final String queryKey,
                        final String field
                        )
        {
            super( queryKey, field );
        }


        @Override
        public void buildQuery(
                        final Query<?> query
                        )
        {
            String  value = getValue();
            if (value == null) {
                return;
            }

            Pattern  pat = Pattern.compile( ".*" + value + ".*", Pattern.CASE_INSENSITIVE );
            query.filter( field, pat );
        }

    }
    // PatternHandler

}
// QueryParams

