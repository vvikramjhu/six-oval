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
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import jp.go.aist.six.oval.model.OvalObject;
import jp.go.aist.six.oval.model.v5.common.ClassEnumeration;
import jp.go.aist.six.oval.repository.CommonQueryKey;
import jp.go.aist.six.oval.repository.DefinitionQueryKey;
import jp.go.aist.six.oval.repository.OvalRepositoryException;
import jp.go.aist.six.oval.repository.QueryParams;
import jp.go.aist.six.oval.repository.TestQueryKey;
import jp.go.aist.six.util.persist.Persistable;
import com.google.code.morphia.query.Query;




/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class MongoQueryBuilder
{

    /**
     * Query key - database field mapping.
     */
    private final Map<String, String>  _fields = new HashMap<String, String>();


    /**
     * Registered handlers.
     * Map keys are URI query param keys.
     */
    private final Map<String, Handler>  _handlers = new HashMap<String, Handler>();


    private static final Handler  DEFAULT_HANDLER = new FilterHandler();




    /**
     * Constructor.
     */
    public MongoQueryBuilder()
    {
        this( _entries() );
    }


    public MongoQueryBuilder(
                    final Map<String, String> fieldMapping,
                    final Map<String, Handler> handlerMapping
                    )
    {
        setFieldMapping( fieldMapping );
        setHandlerMapping( handlerMapping );
    }


    public MongoQueryBuilder(
                    final Collection<Entry> entries
                    )
    {
        _addEntries( entries );
    }



    /**
     */
    protected void _addEntries(
                    final Collection<Entry> entries
                    )
    {
        if (entries != null) {
            for (Entry  entry : entries) {
                _addEntry( entry );
            }
        }
    }


    protected void _addEntry(
                    final Entry entry
                    )
    {
        if (entry != null) {
            _addField( entry.key, entry.field );
            _addHandler( entry.key, entry.handler );
        }
    }




    /**
     */
    public final void setFieldMapping(
                    final Map<String, String> mapping
                    )
    {
        if (mapping != null) {
            _fields.putAll( mapping );
        }
    }


    protected final void _addField(
                    final String key,
                    final String field
                    )
    {
        if (key == null) {
            throw new IllegalArgumentException( "no key specified" );
        }

        _fields.put( key, field );
    }



    /**
     */
    public final void setHandlerMapping(
                    final Map<String, Handler> mapping
                    )
    {
        if (mapping != null) {
            for (String  key : mapping.keySet()) {
                _addHandler( key, mapping.get( key ) );
            }
        }
    }


    protected final Map<String, Handler> _getHandlers()
    {
        return _handlers;
    }



    protected final void _addHandler(
                    final String key,
                    final Handler handler
                    )
    {
        if (handler == null) {
            throw new IllegalArgumentException( "null handler" );
        }

        handler.setBuilder( this );
        _handlers.put( key, handler );
    }



    protected final Handler _getHandler(
                    final String key
                    )
    {
        Handler  handler = _handlers.get( key );
        if (handler == null) {
            handler = DEFAULT_HANDLER;
        }

        return handler;
    }



    public final String getField(
                    final String key
                    )
    {
        String  field = _fields.get( key );
        if (field == null) {
            field = key;
        }

        return field;
    }



    //==============================================================
    //  Query
    //==============================================================


    /**
     */
    public <K, T extends OvalObject & Persistable<K>>
    void buildQuery(
//                    final Class<T> type,
                    final Query<T> query,
                    final QueryParams params
                    )
    {
        for (String  key : params.keys()) {
            Handler  handler = _getHandler( key );
            String  field = getField( key );
            Object  value = params.get( key );

            handler.build( query, field, value );
        }
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

//    @Override
//    public String toString()
//    {
//        return _fields.toString();
//    }



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

        private MongoQueryBuilder  _builder;


        public Handler()
        {
        }


        public Handler(
                        final MongoQueryBuilder builder
                        )
        {
            setBuilder( builder );
        }



        /**
         */
        public final void setBuilder(
                        final MongoQueryBuilder builder
                        )
        {
            _builder = builder;
        }


        public final MongoQueryBuilder getBuilder()
        {
            return _builder;
        }



        /**
         */
        public abstract // <K, T extends OvalObject & Persistable<K>>
        void build( Query<?> query, String field, Object value );



        //**************************************************************
        //  java.lang.Object
        //**************************************************************

    }
    // Handler



    protected static class FilterHandler
    extends Handler
    {

        public static final String  DEFAULT_OPERATOR = "=";

        public FilterHandler()
        {
        }


        public FilterHandler(
                        final MongoQueryBuilder builder
                        )
        {
            super( builder );
        }



        @Override
        public //<K, T extends OvalObject & Persistable<K>>
        void build(
                        final Query<?> query,
                        final String field,
                        final Object value
                        )
        {
            query.filter( field, value );
        }



//        public <K, T extends OvalObject & Persistable<K>>
//        void build(
//                        final Query<T> query,
//                        final String field,
//                        final Object value,
//                        final String operator
//                        )
//        {
//            query.filter( field + " " + operator, value );
//        }

    }
    // FilterHandler



    /**
     * A query param handler for result ordering.
     */
    protected static class OrderHandler
    extends Handler
    {

//        private final Map<String, String>  _fieldMapping;


        public OrderHandler()
        {
        }


        public OrderHandler(
                        final MongoQueryBuilder builder
                        )
        {
            super( builder );
        }


//        public OrderHandler(
//                        final Map<String, String> fieldMapping
//                        )
//        {
//            _fieldMapping = fieldMapping;
//        }



        @Override
        public //<K, T extends OvalObject & Persistable<K>>
        void build(
                        final Query<?> query,
                        final String field,
                        final Object value
                        )
        {
            String  order = String.valueOf( value );
            if (value == null  ||  order.length() == 0) {
                return;
            }

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
                String  orderingField = getBuilder().getField( orderKey );
                s.append( (orderingField == null ? orderKey : orderingField) );
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

        public PatternHandler()
        {
        }


        public PatternHandler(
                        final MongoQueryBuilder builder
                        )
        {
            super( builder );
        }



        @Override
        public //<K, T extends OvalObject & Persistable<K>>
        void build(
                        final Query<?> query,
                        final String field,
                        final Object value
                        )
        {
            String  string = String.valueOf( value );
            Pattern  pattern = Pattern.compile( ".*" + string + ".*", Pattern.CASE_INSENSITIVE );
            query.filter( field, pattern );
        }

    }
    // PatternHandler



    protected static class DatetimeHandler
    extends Handler
    {

        public DatetimeHandler()
        {
        }


        public DatetimeHandler(
                        final MongoQueryBuilder builder
                        )
        {
            super( builder );
        }



        private static SimpleDateFormat  _DATE_FORMATTER_ =
            new SimpleDateFormat( "yyyy-MM-dd" );


        @Override
        public //<K, T extends OvalObject & Persistable<K>>
        void build(
                        final Query<?> query,
                        final String field,
                        final Object value
                        )
        {
            String  datetimeString = String.valueOf( value );

            // validation
            try {
                _DATE_FORMATTER_.parse( datetimeString );
            } catch (ParseException ex) {
                throw new OvalRepositoryException( ex );
            }

            query.filter( field, datetimeString );
        }

    }
    // DatetimeHandler



    //==============================================================
    //
    //==============================================================

    protected static class Entry
    {
        private final String   key;
        private final String   field;
        private final Handler  handler;


        public Entry(
                        final String key,
                        final String field
                        )
        {
            this( key, field, DEFAULT_HANDLER );
        }


        public Entry(
                        final String key,
                        final String field,
                        final Handler handler
                        )
        {
            this.key = key;
            this.field = field;
            this.handler = handler;
        }

    }
    // Entry


    private static Collection<Entry> _entries()
    {
        Handler  offsetHandler = new Handler()
        {
            @Override
            public void build(
                        final Query<?> query,
                        final String field,
                        final Object value
                        )
            {
                query.offset( Integer.valueOf( String.valueOf( value ) ).intValue() );
            }
        };

        Handler  limitHandler = new Handler()
        {
            @Override
            public void build(
                            final Query<?> query,
                            final String field,
                            final Object value
                            )
            {
                query.limit( Integer.valueOf( String.valueOf( value ) ).intValue() );
            }
        };

        Handler  definitionClassHandler = new FilterHandler()
        {
            @Override
            public void build(
                            final Query<?> query,
                            final String field,
                            final Object value
                            )
            {
                ClassEnumeration  clazzValue = ClassEnumeration.fromValue( String.valueOf( value ) );
                super.build( query, field, clazzValue );
            }
        };

        Handler  versionHandler = new FilterHandler()
        {
            @Override
            public void build(
                            final Query<?> query,
                            final String key,
                            final Object value
                            )
            {
                int  intValue = Integer.valueOf( String.valueOf( value ) ).intValue();
                super.build( query, key, intValue );
            }
        };


        Collection<Entry>  entries = new ArrayList<Entry>();

        // common
        entries.add( new Entry( CommonQueryKey.OFFSET, null, offsetHandler ) );
        entries.add( new Entry( CommonQueryKey.LIMIT,  null, limitHandler ) );
        entries.add( new Entry( CommonQueryKey.ORDER,  null, new OrderHandler() ) );

        // entity
        entries.add( new Entry( DefinitionQueryKey.ID,               "oval_id" ) );
        entries.add( new Entry( DefinitionQueryKey.VERSION,          "oval_version",  versionHandler ) );

        // definition
        entries.add( new Entry( DefinitionQueryKey.DEFINITION_CLASS, "class",         definitionClassHandler ) );
        entries.add( new Entry( DefinitionQueryKey.FAMILY,           "metadata.affected.family"   ) );
        entries.add( new Entry( DefinitionQueryKey.PLATFORM,         "metadata.affected.platform" ) );
        entries.add( new Entry( DefinitionQueryKey.PRODUCT,          "metadata.affected.product"  ) );
        entries.add( new Entry( DefinitionQueryKey.REF_ID,           "metadata.reference.ref_id"  ) );

        // test
        entries.add( new Entry( TestQueryKey.OBJECT_REF,  "object.object_ref"  ) );
        entries.add( new Entry( TestQueryKey.STATE_REF,   "state.state_ref"  ) );

        return entries;
    }



//    //==============================================================
//    //  builders
//    //==============================================================
//
//    public static class BasicQueryBuilder
//    extends MongoQueryBuilder
//    {
//
//        private static Collection<Entry> _entries()
//        {
//            Handler  offsetHandler = new Handler()
//            {
//                @Override
//                public void build(
//                            final Query<?> query,
//                            final String field,
//                            final Object value
//                            )
//                {
//                    query.offset( Integer.valueOf( String.valueOf( value ) ).intValue() );
//                }
//            };
//
//            Handler  limitHandler = new Handler()
//            {
//                @Override
//                public void build(
//                                final Query<?> query,
//                                final String field,
//                                final Object value
//                                )
//                {
//                    query.limit( Integer.valueOf( String.valueOf( value ) ).intValue() );
//                }
//            };
//
//            Collection<Entry>  entries = new ArrayList<Entry>();
//            entries.add( new Entry( CommonQueryKey.OFFSET, null, offsetHandler ) );
//            entries.add( new Entry( CommonQueryKey.LIMIT,  null, limitHandler ) );
//            entries.add( new Entry( CommonQueryKey.ORDER,  null, new OrderHandler() ) );
//
//            return entries;
//        }
//
//
//
//        public BasicQueryBuilder()
//        {
//            _addEntries( _entries() );
//        }
//
//    }
//    // BasicQueryBuilder
//
//
//
//    public static class DefinitionQueryBuilder
//    extends BasicQueryBuilder
//    {
//
//        private static Collection<Entry> _entries()
//        {
//            Handler  definitionClassHandler = new FilterHandler()
//            {
//                @Override
//                public void build(
//                                final Query<?> query,
//                                final String field,
//                                final Object value
//                                )
//                {
//                    ClassEnumeration  clazzValue = ClassEnumeration.fromValue( String.valueOf( value ) );
//                    super.build( query, field, clazzValue );
//                }
//            };
//
//            Handler  versionHandler = new FilterHandler()
//            {
//                @Override
//                public void build(
//                                final Query<?> query,
//                                final String key,
//                                final Object value
//                                )
//                {
//                    int  intValue = Integer.valueOf( String.valueOf( value ) ).intValue();
//                    super.build( query, key, intValue );
//                }
//            };
//
//            Collection<Entry>  entries = new ArrayList<Entry>();
//            entries.add( new Entry( DefinitionQueryKey.ID,               "oval_id",       DEFAULT_HANDLER ) );
//            entries.add( new Entry( DefinitionQueryKey.VERSION,          "oval_version",  versionHandler ) );
//            entries.add( new Entry( DefinitionQueryKey.DEFINITION_CLASS, "class",         definitionClassHandler ) );
//            entries.add( new Entry( DefinitionQueryKey.FAMILY,           "metadata.affected.family",   DEFAULT_HANDLER ) );
//            entries.add( new Entry( DefinitionQueryKey.PLATFORM,         "metadata.affected.platform", DEFAULT_HANDLER ) );
//            entries.add( new Entry( DefinitionQueryKey.PRODUCT,          "metadata.affected.product",  DEFAULT_HANDLER  ) );
//            entries.add( new Entry( DefinitionQueryKey.REF_ID,           "metadata.reference.ref_id",  DEFAULT_HANDLER  ) );
//
//            return entries;
//        }
//
//
//
//        public DefinitionQueryBuilder()
//        {
//            _addEntries( _entries() );
//        }
//
//    }
//    // DefinitionQueryBuilder

}
// MongoQueryBuilder

