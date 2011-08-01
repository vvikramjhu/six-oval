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
 * @version $Id$
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
        Handler  offsetHandler = new Handler( this, CommonQueryKey.OFFSET, null )
        {
            @Override
            public <S extends OvalObject>
            void build(
                            final Query<S> query,
                            final String key,
                            final Object value
                            )
            {
                query.offset( Integer.valueOf( String.valueOf( value ) ).intValue() );
            }


//            @Override
//            public <S extends OvalObject>
//            void build(
//                            final Query<S> query,
//                            final String key,
//                            final Map<String, Handler> handlers
//                            )
//            {
//                Object  value = params.get( this.key );
//                if (value != null) {
//                    query.offset( Integer.valueOf( String.valueOf( value ) ).intValue() );
//                }
//            }
        };

        Handler  limitHandler = new Handler( this, CommonQueryKey.LIMIT, null )
        {
            @Override
            public <S extends OvalObject>
            void build(
                            final Query<S> query,
                            final String key,
                            final Object value
                            )
            {
                query.limit( Integer.valueOf( String.valueOf( value ) ).intValue() );
            }


//            @Override
//            public <S extends OvalObject>
//            void buildQuery(
//                            final Query<S> query,
//                            final QueryParams params,
//                            final Map<String, Handler> handlers
//                            )
//            {
//                Object  value = params.get( this.key, DEFAULT_LIMIT );
//                if (value != null) {
//                    query.limit( Integer.valueOf( String.valueOf( value ) ).intValue() );
//                }
//            }
        };

        _addHandler( offsetHandler );
        _addHandler( limitHandler );
        _addHandler( new OrderHandler( this ) );


        // definition
        _addHandler( new Handler( this, DefinitionQueryKey.ID,               "oval_id"                    ) );
        _addHandler( new Handler( this, DefinitionQueryKey.DEFINITION_CLASS, "class"                      ) );
        _addHandler( new Handler( this, DefinitionQueryKey.FAMILY,           "metadata.affected.family"   ) );
        _addHandler( new Handler( this, DefinitionQueryKey.PLATFORM,         "metadata.affected.platform" ) );
        _addHandler( new Handler( this, DefinitionQueryKey.PRODUCT,          "metadata.affected.product"  ) );

        Handler  versionHandler = new Handler( this, DefinitionQueryKey.VERSION, "oval_version" )
        {
            @Override
            public <S extends OvalObject>
            void build(
                            final Query<S> query,
                            final String key,
                            final Object value
                            )
            {
                query.filter( toField( key ), Integer.valueOf( String.valueOf( value ) ).intValue() );
            }


//            @Override
//            public <S extends OvalObject>
//            void buildQuery(
//                            final Query<S> query,
//                            final QueryParams params,
//                            final Map<String, Handler> handlers
//                            )
//            {
//                Object  value = params.get( this.key );
//                if (value != null) {
//                    query.filter( this.field, Integer.valueOf( String.valueOf( value ) ).intValue() );
//                }
//            }
        };
        _addHandler( versionHandler );

        //TODO:
//        setOrder( "oval_id" );


        // SC
        _addHandler( DatetimeHandler.newStartHandler(  this, "generator.timestamp" ) );
        _addHandler( DatetimeHandler.newEndHandler(    this, "generator.timestamp" ) );
        _addHandler( new PatternHandler( this, OvalSystemCharacteristicsQueryKey.PRIMARY_HOST_NAME, "system_info.primary_host_name" ) );
        _addHandler( new PatternHandler( this, OvalSystemCharacteristicsQueryKey.OS_NAME,           "system_info.os_name"           ) );

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



    protected final Handler _getHandler(
                    final String key
                    )
    {
        Handler  handler = _handlers.get( key );
        return handler;
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
    //  building query
    //==============================================================

    public <T extends OvalObject>
    void buildFilter(
                    final Query<T> query,
                    final String field,
                    final Object value
                    )
    {
        query.filter( field, value );
    }



    public <T extends OvalObject>
    void buildFilter(
                    final Query<T> query,
                    final String field,
                    final String operator,
                    final Object value
                    )
    {
        query.filter( field + " " + operator, value );
    }



    public <T extends OvalObject>
    void buildPatternFilter(
                    final Query<T> query,
                    final String field,
                    final Object value
                    )
    {
        String  pattern = String.valueOf( value );
        Pattern  pat = Pattern.compile( ".*" + pattern + ".*", Pattern.CASE_INSENSITIVE );
        query.filter( field, pat );
    }



    public <T extends OvalObject>
    void buildOrder(
                    final Query<T> query,
                    final String order
                    )
    {
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
            Handler  handler = _getHandler( orderKey );
            s.append( (handler == null ? orderKey : handler.getField()) );
        }

        query.order( s.toString() );
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

    private final Handler  DEFAULT_HANDLER = new Handler( this, null, null );



    /**
     */
    public <T extends OvalObject>
    void buildQuery(
                    final Query<T> query,
                    final QueryParams params
                    )
    {
        for (String  key : params.keys()) {
            Handler  handler = _getHandler( key );
            if (handler == null) {
                handler = DEFAULT_HANDLER;
            }

            handler.build( query, key, params.get( key ) );
        }
    }
//    {
//        for (Handler  handler : _handlers.values()) {
//            handler.buildQuery( query, params, _handlers );
//        }
//    }



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

        private final MongoQueryBuilder  _builder;
        public final String  key;
        public final String  field;
//        public String  _value;


        public Handler(
                        final MongoQueryBuilder builder,
                        final String key,
                        final String field
                        )
        {
//            if (queryKey == null) {
//                throw new IllegalArgumentException( "null query key" );
//            }

            this._builder = builder;
            this.key = key;
            this.field = field;
        }



        protected final MongoQueryBuilder getBuilder()
        {
            return _builder;
        }



        public final String getKey()
        {
            return this.key;
        }


        public final String getField()
        {
            return (this.field == null ? this.key : this.field);
        }


        public final String toField(
                        final String key
                        )
        {
            String  field = getField();
            return (field == null ? key : field);
        }



        public <T extends OvalObject>
        void build(
                        final Query<T> query,
                        final String key,
                        final Object value
                        )
        {
            getBuilder().buildFilter( query, toField( key ), value );
        }



//        public <T extends OvalObject>
//        void buildQuery(
//                        final Query<T> query,
//                        final QueryParams params,
//                        final Map<String, Handler> handlers
//                        )
//        {
//            Object  value = params.get( this.key );
//            if (value != null) {
//                query.filter( field, value );
//            }
//        }



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

        public OrderHandler(
                        final MongoQueryBuilder builder
                        )
        {
            super( builder, CommonQueryKey.ORDER, null );
//            _params = queryParams;
        }


        @Override
        public <T extends OvalObject>
        void build(
                        final Query<T> query,
                        final String key,
                        final Object value
                        )
        {
            getBuilder().buildOrder( query, String.valueOf( value ) );
        }



//        @Override
//        public <T extends OvalObject>
//        void buildQuery(
//                        final Query<T> query,
//                        final QueryParams params,
//                        final Map<String, Handler> handlers
//                        )
//        {
//            Object  value = params.get( this.key );
//            if (value == null) {
//                return;
//            }
//
//            String  order = String.valueOf( value );
//
//            StringBuilder  s = new StringBuilder();
//            String[]  orderKeys = order.split( "," );
//            for (String  orderKey : orderKeys) {
//                if (s.length() > 0) {
//                    s.append( "," );
//                }
//
//                if (orderKey.startsWith( "-" )) {
//                    orderKey = orderKey.substring( 1 );
//                    s.append( "-" );
//                }
//                Handler  handler = handlers.get( orderKey );
//                s.append( (handler == null ? orderKey : handler.field) );
//            }
//
//            query.order( s.toString() );
//        }

    }
    // OrderHandler



    /**
     * A query param handler generating string pattern match filter in the query.
     * e.g. {name:/Joe/} in MongoDB, name like ''%Joe%' in SQL
     */
    protected class PatternHandler
    extends Handler
    {

        public PatternHandler(
                        final MongoQueryBuilder builder,
                        final String key,
                        final String field
                        )
        {
            super( builder, key, field );
        }



        @Override
        public <T extends OvalObject>
        void build(
                        final Query<T> query,
                        final String key,
                        final Object value
                        )
        {
            getBuilder().buildPatternFilter( query, toField( key ), value );
        }



//        @Override
//        public <T extends OvalObject>
//        void buildQuery(
//                        final Query<T> query,
//                        final QueryParams params,
//                        final Map<String, Handler> handlers
//                        )
//        {
//            Object  value = params.get( this.key );
//            if (value == null) {
//                return;
//            }
//
//            String  pattern = String.valueOf( value );
//            Pattern  pat = Pattern.compile( ".*" + pattern + ".*", Pattern.CASE_INSENSITIVE );
//            query.filter( field, pat );
//        }

    }
    // PatternHandler



    protected static class DatetimeHandler
    extends Handler
    {
//        public static final String  AFTER  = "after";
//        public static final String  BEFORE = "before";



        public static DatetimeHandler newStartHandler(
                        final MongoQueryBuilder builder,
                        final String field
                        )
        {
            return new DatetimeHandler( builder, CommonQueryKey.DT_START, field, ">=" );
        }


        public static DatetimeHandler newEndHandler(
                        final MongoQueryBuilder builder,
                        final String field
                        )
        {
            return new DatetimeHandler( builder, CommonQueryKey.DT_END, field, "<" );
        }



        private static SimpleDateFormat  _DATE_FORMATTER_ =
            new SimpleDateFormat( "yyyy-MM-dd" );


        private final String  _operator;


        public DatetimeHandler(
                        final MongoQueryBuilder builder,
                        final String key,
                        final String field
                        )
        {
            this( builder, key, "=", field );
        }


        public DatetimeHandler(
                        final MongoQueryBuilder builder,
                        final String key,
                        final String field,
                        final String operator
                        )
        {
            super( builder, key, field );
            this._operator = operator;
        }



        @Override
        public <T extends OvalObject>
        void build(
                        final Query<T> query,
                        final String key,
                        final Object value
                        )
        {
            try {
                _DATE_FORMATTER_.parse( String.valueOf( value ) );
            } catch (ParseException ex) {
                throw new RuntimeException( ex.getMessage() );
            }

            getBuilder().buildFilter( query, toField( key ), _operator, value );
        }



//        @Override
//        public <T extends OvalObject>
//        void buildQuery(
//                        final Query<T> query,
//                        final QueryParams params,
//                        final Map<String, Handler> handlers
//                        )
//        {
//            Object  value = params.get( this.key );
//            if (value == null) {
//                return;
//            }
//
//            try {
//                _DATE_FORMATTER_.parse( String.valueOf( value ) );
//            } catch (ParseException ex) {
//                throw new RuntimeException( ex.getMessage() );
//            }
//
//            if (CommonQueryKey.DT_START.equalsIgnoreCase( this.key )) {
//                query.field( this.field ).greaterThanOrEq( value );
//            } else if (CommonQueryKey.DT_END.equalsIgnoreCase( this.key )) {
//                query.field( this.field ).lessThan( value );
//            } else {
//                query.filter( this.field, value );
//            }
//        }

    }
    // DatetimeHandler

}
// MongoQueryBuilder

