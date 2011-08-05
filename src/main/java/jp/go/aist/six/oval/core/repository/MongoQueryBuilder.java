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
import jp.go.aist.six.oval.model.v5.common.ClassEnumeration;
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

    public static final String  DEFAULT_LIMIT = "10";



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
            void build(
                            final Query<S> query,
                            final String key,
                            final Object value
                            )
            {
                query.offset( Integer.valueOf( String.valueOf( value ) ).intValue() );
            }
        };

        Handler  limitHandler = new Handler( CommonQueryKey.LIMIT, null )
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
        };

        _addHandler( offsetHandler );
        _addHandler( limitHandler );
        _addHandler( new OrderHandler( _handlers ) );


        // definition

        Handler  definitionClassHandler = new FilterHandler( DefinitionQueryKey.DEFINITION_CLASS, "class" )
        {
            @Override
            public <S extends OvalObject>
            void build(
                            final Query<S> query,
                            final String key,
                            final Object value
                            )
            {
                ClassEnumeration  clazz = ClassEnumeration.fromValue( String.valueOf( value ) );
                super.build( query, key, clazz );
            }
        };

        _addHandler( new FilterHandler( DefinitionQueryKey.ID,               "oval_id"                    ) );
        _addHandler( definitionClassHandler );
        _addHandler( new FilterHandler( DefinitionQueryKey.FAMILY,           "metadata.affected.family"   ) );
        _addHandler( new FilterHandler( DefinitionQueryKey.PLATFORM,         "metadata.affected.platform" ) );
        _addHandler( new FilterHandler( DefinitionQueryKey.PRODUCT,          "metadata.affected.product"  ) );
        _addHandler( new FilterHandler( DefinitionQueryKey.REF_ID,           "metadata.reference.ref_id"  ) );

        Handler  versionHandler = new Handler( DefinitionQueryKey.VERSION, "oval_version" )
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
        };
        _addHandler( versionHandler );


        // SC
        _addHandler( DatetimeHandler.newStartHandler(  this, "generator.timestamp" ) );
        _addHandler( DatetimeHandler.newEndHandler(    this, "generator.timestamp" ) );
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
    //  Morphia Query
    //==============================================================

    private final Handler  DEFAULT_HANDLER = new FilterHandler( null );



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
    protected static abstract class Handler
    {

        public final String  key;
        public final String  field;


        public Handler(
                        final String key,
                        final String field
                        )
        {
//            if (queryKey == null) {
//                throw new IllegalArgumentException( "null query key" );
//            }

            this.key = key;
            this.field = field;
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



        public abstract <T extends OvalObject>
        void build(
                        final Query<T> query,
                        final String key,
                        final Object value
                        );
//        {
//            getBuilder().buildFilter( query, toField( key ), value );
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



    protected static class FilterHandler
    extends Handler
    {

        public static final String  DEFAULT_OPERATOR = "=";

        private final String  _operator;


        public FilterHandler(
                        final String key
                        )
        {
            this( key, null );
        }


        public FilterHandler(
                        final String key,
                        final String field
                        )
        {
            this( key, field, DEFAULT_OPERATOR );
        }


        public FilterHandler(
                        final String key,
                        final String field,
                        final String operator
                        )
        {
            super( key, field );
            _operator = operator;
        }



        public final String getOperator()
        {
            return (_operator == null ? DEFAULT_OPERATOR : _operator);
        }



        @Override
        public <T extends OvalObject>
        void build(
                        final Query<T> query,
                        final String key,
                        final Object value
                        )
        {
            query.filter( toField( key ) + " " + getOperator(), value );
        }

    }
    // FilterHandler



    /**
     * A query param handler for result ordering.
     */
    protected static class OrderHandler
    extends Handler
    {

        private final Map<String, Handler>  _handlers;


        public OrderHandler(
                        final Map<String, Handler> handlers
                        )
        {
            super( CommonQueryKey.ORDER, null );
            _handlers = handlers;
        }


        @Override
        public <T extends OvalObject>
        void build(
                        final Query<T> query,
                        final String key,
                        final Object value
                        )
        {
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
                Handler  handler = _handlers.get( orderKey );
                s.append( (handler == null ? orderKey : handler.getField()) );
            }

            query.order( s.toString() );
        }

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
                        final String key,
                        final String field
                        )
        {
            super( key, field );
        }



        @Override
        public <T extends OvalObject>
        void build(
                        final Query<T> query,
                        final String key,
                        final Object value
                        )
        {
          String  pattern = String.valueOf( value );
          Pattern  pat = Pattern.compile( ".*" + pattern + ".*", Pattern.CASE_INSENSITIVE );
          query.filter( toField( key ), pat );
        }

    }
    // PatternHandler



    protected static class DatetimeHandler
    extends FilterHandler
    {

        public static DatetimeHandler newStartHandler(
                        final MongoQueryBuilder builder,
                        final String field
                        )
        {
            return new DatetimeHandler( CommonQueryKey.DT_START, field, ">=" );
        }


        public static DatetimeHandler newEndHandler(
                        final MongoQueryBuilder builder,
                        final String field
                        )
        {
            return new DatetimeHandler( CommonQueryKey.DT_END, field, "<" );
        }



        public DatetimeHandler(
                        final String key
                        )
        {
            super( key );
        }


        public DatetimeHandler(
                        final String key,
                        final String field
                        )
        {
            super( key, field );
        }


        public DatetimeHandler(
                        final String key,
                        final String field,
                        final String operator
                        )
        {
            super( key, field, operator );
        }



        private static SimpleDateFormat  _DATE_FORMATTER_ =
            new SimpleDateFormat( "yyyy-MM-dd" );


        @Override
        public <T extends OvalObject>
        void build(
                        final Query<T> query,
                        final String key,
                        final Object value
                        )
        {
            // validation
            try {
                _DATE_FORMATTER_.parse( String.valueOf( value ) );
            } catch (ParseException ex) {
                throw new RuntimeException( ex.getMessage() );
            }

            super.build( query, key, value );
        }

    }
    // DatetimeHandler

}
// MongoQueryBuilder

