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

package jp.go.aist.six.oval.core.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import jp.go.aist.six.oval.model.OvalObject;
import jp.go.aist.six.oval.repository.CommonQueryKey;
import jp.go.aist.six.oval.repository.DefinitionQueryKey;
import jp.go.aist.six.oval.repository.OvalSystemCharacteristicsQueryKey;
import jp.go.aist.six.oval.repository.QueryParams;
import com.google.code.morphia.query.Query;




/**
 * @author  Akihito Nakamura, AIST
 * @version $Id: QueryParams.java 1906 2011-07-21 02:41:01Z nakamura5akihito $
 */
public class MongoQueryBuilder
{

//    public static final String  LIMIT  = "limit";
//    public static final String  OFFSET = "offset";
//    public static final String  ORDER  = "order";

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
    public MongoQueryBuilder()
    {
        Handler  offsetHandler = new Handler( CommonQueryKey.OFFSET, null )
        {
            @Override
            public <S extends OvalObject>
            void buildQuery(
                            final Query<S> query,
                            final QueryParams params,
                            final Map<String, Handler> handlers
                            )
            {
                Object  value = params.get( this.key );
                if (value != null) {
                    query.offset( Integer.valueOf( String.valueOf( value ) ).intValue() );
                }
            }
        };

        Handler  limitHandler = new Handler( CommonQueryKey.LIMIT, null )
        {
            @Override
            public <S extends OvalObject>
            void buildQuery(
                            final Query<S> query,
                            final QueryParams params,
                            final Map<String, Handler> handlers
                            )
            {
                Object  value = params.get( this.key, DEFAULT_LIMIT );
                if (value != null) {
                    query.limit( Integer.valueOf( String.valueOf( value ) ).intValue() );
                }
            }
        };

        _addHandler( offsetHandler );
        _addHandler( limitHandler );
        _addHandler( new OrderHandler() );


        // definition
        _addHandler( new Handler( DefinitionQueryKey.ID,               "oval_id"                    ) );
        _addHandler( new Handler( DefinitionQueryKey.DEFINITION_CLASS, "class"                      ) );
        _addHandler( new Handler( DefinitionQueryKey.FAMILY,           "metadata.affected.family"   ) );
        _addHandler( new Handler( DefinitionQueryKey.PLATFORM,         "metadata.affected.platform" ) );
        _addHandler( new Handler( DefinitionQueryKey.PRODUCT,          "metadata.affected.product"  ) );

        Handler  versionHandler = new Handler( DefinitionQueryKey.VERSION, "oval_version" )
        {
            @Override
            public <S extends OvalObject>
            void buildQuery(
                            final Query<S> query,
                            final QueryParams params,
                            final Map<String, Handler> handlers
                            )
            {
                Object  value = params.get( this.key );
                if (value != null) {
                    query.filter( this.field, Integer.valueOf( String.valueOf( value ) ).intValue() );
                }
            }
        };
        _addHandler( versionHandler );

        //TODO:
//        setOrder( "oval_id" );


        // SC
        _addHandler( DatetimeHandler.newStartHandler(  "generator.timestamp" ) );
        _addHandler( DatetimeHandler.newEndHandler(    "generator.timestamp" ) );
        _addHandler( new PatternHandler( OvalSystemCharacteristicsQueryKey.PRIMARY_HOST_NAME, "system_info.primary_host_name" ) );
        _addHandler( new PatternHandler( OvalSystemCharacteristicsQueryKey.OS_NAME,           "system_info.os_name"           ) );

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

        _handlers.put( handler.key, handler );
    }


    protected final String _toField(
                    final String queryKey
                    )
    {
        Handler  handler = _handlers.get( queryKey );
        if (handler == null) {
            return queryKey;
//            throw new IllegalArgumentException( "unknown query key: " + queryKey );
        }

        return handler.field;
    }



    //==============================================================
    //  URI query params
    //==============================================================

//    /**
//     */
//    protected void _setParam(
//                    final String key,
//                    final String value
//                    )
//    {
//        Handler  handler = _handlers.get( key );
//        if (handler == null) {
//            throw new IllegalArgumentException( "unknown query param: " + key );
//        }
//
//        handler.setValue( value );
//    }
//
//
//    protected String _getParam(
//                    final String key
//                    )
//    {
//        Handler  handler = _handlers.get( key );
//        if (handler == null) {
//            throw new IllegalArgumentException( "unknown query param: " + key );
//        }
//
//        return handler.getValue();
//    }
//
//
//    protected String _getParam(
//                    final String key,
//                    final String defaultValue
//                    )
//    {
//        String  value = _getParam( key );
//
//        return (value == null ? defaultValue : value);
//    }


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
    protected static int _asInt(
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
    public <T extends OvalObject>
    void buildQuery(
                    final Query<T> query,
                    final QueryParams params
                    )
    {
        for (Handler  handler : _handlers.values()) {
            handler.buildQuery( query, params, _handlers );
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



//    //==============================================================
//    //  common params
//    //==============================================================
//
//    /**
//     * @param   limit
//     *  a maximum number of results to return.
//     */
//    public void setLimit(
//                    final String limit
//    )
//    {
//        if (limit != null) {
//            if (_asInt( limit ) < 1) {
//                throw new IllegalArgumentException( "negative or zero limit: " + limit );
//            }
//            _setParam( LIMIT, limit );
//        }
//    }
//
//
//    public String getLimit()
//    {
//        return _getParam( LIMIT, DEFAULT_LIMIT );
//    }
//
//
//
//    /**
//     * @param   offset
//     *  at which object the service should begin returning results.
//     */
//    public void setOffset(
//                    final String offset
//    )
//    {
//        if (offset != null) {
//            if (_asInt( offset ) < 0) {
//                throw new IllegalArgumentException( "negative offset: " + offset );
//            }
//            _setParam( OFFSET, offset );
//        }
//
//    }
//
//
//    public String getOffset()
//    {
//        return _getParam( OFFSET );
//    }
//
//
//
//    /**
//     * @param   order
//     *  items be returned in a particular order.
//     *  The content must be comma-separated, e.g. "age,-date"
//     */
//    public void setOrder(
//                    final String order
//    )
//    {
//        _setParam( ORDER, order );
//    }
//
//
//    public String getOrder()
//    {
//        return _getParam( ORDER );
//    }



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
        public final String  key;
        public final String  field;
//        public String  _value;


        public Handler(
                        final String queryKey,
                        final String field
                        )
        {
            if (queryKey == null) {
                throw new IllegalArgumentException( "null query key" );
            }

            this.key = queryKey;
            this.field = field;
        }


//        public final void setValue(
//                        final String value
//                        )
//        {
//            _value = value;
//        }
//
//
//        public final String getValue()
//        {
//            return _value;
//        }


        public <T extends OvalObject>
        void buildQuery(
                        final Query<T> query,
                        final QueryParams params,
                        final Map<String, Handler> handlers
                        )
        {
            Object  value = params.get( this.key );
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
            return "[" + key + ", " + field + "]";
        }

    }
    // Handler



    /**
     * A query param handler for result ordering.
     */
    protected static class OrderHandler
    extends Handler
    {
//        private final MongoQueryBuilder<?>  _params;


        public OrderHandler()
        {
            super( CommonQueryKey.ORDER, null );
//            _params = queryParams;
        }


        @Override
        public <T extends OvalObject>
        void buildQuery(
                        final Query<T> query,
                        final QueryParams params,
                        final Map<String, Handler> handlers
                        )
        {
            Object  value = params.get( this.key );
            if (value == null) {
                return;
            }

            String  order = String.valueOf( value );

            StringBuilder  s = new StringBuilder();
            String[]  orderKeys = order.split( "," );
            for (String  orderKey : orderKeys) {
                if (s.length() > 0) {
                    s.append( "," );
                }

                if (orderKey.startsWith( "-" )) {
                    orderKey = orderKey.substring( 1 );
                    s.append( "-" );
                }
                Handler  handler = handlers.get( orderKey );
                s.append( (handler == null ? orderKey : handler.field) );
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
        public <T extends OvalObject>
        void buildQuery(
                        final Query<T> query,
                        final QueryParams params,
                        final Map<String, Handler> handlers
                        )
        {
            Object  value = params.get( this.key );
            if (value == null) {
                return;
            }

            String  pattern = String.valueOf( value );
            Pattern  pat = Pattern.compile( ".*" + pattern + ".*", Pattern.CASE_INSENSITIVE );
            query.filter( field, pat );
        }

    }
    // PatternHandler



    public static class DatetimeHandler
    extends Handler
    {
//        public static final String  AFTER  = "after";
//        public static final String  BEFORE = "before";



        public static DatetimeHandler newStartHandler(
                        final String field
                        )
        {
            return new DatetimeHandler( CommonQueryKey.DT_START, field );
        }


        public static DatetimeHandler newEndHandler(
                        final String field
                        )
        {
            return new DatetimeHandler( CommonQueryKey.DT_END, field );
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
        public <T extends OvalObject>
        void buildQuery(
                        final Query<T> query,
                        final QueryParams params,
                        final Map<String, Handler> handlers
                        )
        {
            Object  value = params.get( this.key );
            if (value == null) {
                return;
            }

            try {
                _DATE_FORMATTER_.parse( String.valueOf( value ) );
            } catch (ParseException ex) {
                throw new RuntimeException( ex.getMessage() );
            }

            if (CommonQueryKey.DT_START.equalsIgnoreCase( this.key )) {
                query.field( this.field ).greaterThanOrEq( value );
            } else if (CommonQueryKey.DT_END.equalsIgnoreCase( this.key )) {
                query.field( this.field ).lessThan( value );
            } else {
                query.filter( this.field, value );
            }
        }

    }
    // PatternHandler

}
// MongoQueryBuilder

