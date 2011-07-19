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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import com.google.code.morphia.query.Query;




/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class QueryParams<T>
{

    public static final String  LIMIT  = "limit";
    public static final String  OFFSET = "offset";
    public static final String  ORDER  = "order";

    public static final String  DEFAULT_LIMIT = "10";
//    public static final String  DEFAULT_OFFSET = "0";



    /**
     * Registered handlers.
     * Map keys are URI query param keys.
     */
    private final Map<String, Handler>  _handlers = new HashMap<String, Handler>();



    /**
     * Constructor.
     */
    public QueryParams()
    {
        Handler  offsetHandler = new Handler( OFFSET, null )
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

        Handler  limitHandler = new Handler( LIMIT, null )
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



    //==============================================================
    //  Handler
    //==============================================================

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
    //  URI query params
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
    }


    protected String _getParam(
                    final String key,
                    final String defaultValue
                    )
    {
        String  value = _getParam( key );

        return (value == null ? defaultValue : value);
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
    //  Morphia Query
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
    }



//    /**
//     */
//    protected void _buildFilterQueryParam(
//                    final Query<T> query,
//                    final String param
//    )
//    {
//        String  value = _getParam( param );
//        if (value != null) {
//            query.filter( param, value );
//        }
//    }



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



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return _handlers.toString();
    }



    //**************************************************************
    //  nested classes
    //**************************************************************

    /**
     * A query param handler.
     * It holds key-value pair in an URI query param and
     * the correspondent field name in the MongoDB document object.
     * This handler generates "=" filter in the query.
     */
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



    /**
     * A query param handler for result ordering.
     */
    protected static class OrderHandler
    extends Handler
    {
        private final QueryParams<?>  _params;


        public OrderHandler(
                        final QueryParams<?> queryParams
                        )
        {
            super( ORDER, null );
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



    /**
     * A query param handler generating string pattern match filter in the query.
     * e.g. {name:/Joe/} in MongoDB, name like ''%Joe%' in SQL
     */
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



    public static class DatetimeHandler
    extends Handler
    {
        public static final String  AFTER  = "after";
        public static final String  BEFORE = "before";



        public static DatetimeHandler newAfterHandler(
                        final String field
                        )
        {
            return new DatetimeHandler( AFTER, field );
        }


        public static DatetimeHandler newBeforeHandler(
                        final String field
                        )
        {
            return new DatetimeHandler( BEFORE, field );
        }



        private static SimpleDateFormat  _DATE_FORMATTER_ =
            new SimpleDateFormat( "yyyy-MM-dd" );



        public DatetimeHandler(
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

            try {
                _DATE_FORMATTER_.parse( value );
            } catch (ParseException ex) {
                throw new RuntimeException( ex.getMessage() );
            }

            if (AFTER.equalsIgnoreCase( queryKey )) {
                query.field( field ).greaterThanOrEq( value );
            } else if (BEFORE.equalsIgnoreCase( queryKey )) {
                query.field( field ).lessThan( value );
            } else {
                query.filter( field, value );
            }
        }

    }
    // PatternHandler

}
// QueryParams

