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
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import jp.go.aist.six.oval.core.repository.mongodb.QueryBuilder;
import jp.go.aist.six.oval.model.OvalComponentType;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.v5.common.ClassEnumeration;
import jp.go.aist.six.oval.repository.OvalRepositoryException;
import com.google.code.morphia.query.Query;




/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class MongoWebQueryBuilder
implements QueryBuilder
{

    /**
     * Query key - database field mapping.
     */
    private static final Map<String, String>  _fields = new HashMap<String, String>();


    /**
     * Registered handlers.
     * Map keys are URI query param keys.
     */
    private static final Map<String, Handler>  _handlers = new HashMap<String, Handler>();


    private static final Handler  DEFAULT_HANDLER = new FilterHandler();



    static
    {
        Collection<Entry>  entries = _createDefaultEntries();
        if (entries != null) {
            for (Entry  entry : entries) {
                if (entry != null) {
                    _fields.put( entry.key, entry.field );

//                    entry.handler.setBuilder( this );
                    _handlers.put( entry.key, entry.handler );
                }
            }
        }

    }



    private QueryParams  _params;




    /**
     * Constructor.
     */
    public MongoWebQueryBuilder()
    {
    }


    public MongoWebQueryBuilder(
                    final QueryParams params
                    )
    {
        setParams( params );
    }



    /**
     */
    public void setParams(
                    final QueryParams params
                    )
    {
        this._params = params;
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



    public static final String getField(
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

    @Override
    public <T>
    Query<T> build(
                    final Query<T> query
                    )
    throws OvalRepositoryException
    {
        buildQuery( query, _params );

        return query;
    }



    /**
     */
    public <T>
    void buildQuery(
                    final Query<T> query,
                    final QueryParams params
                    )
    {
        for (String  key : params.keys()) {
            Handler  handler = _getHandler( key );
            handler.build( query, params, key );
        }
    }
//    {
//        for (String  key : params.keys()) {
//            Handler  handler = _getHandler( key );
//            String  field = getField( key );
//            String  value = params.get( key );
//
//            handler.build( query, field, value );
//        }
//    }



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

        public Handler()
        {
        }


        /**
         */
        public abstract void build( Query<?> query, QueryParams params, String key );

    }
    // Handler



    protected static class FilterHandler
    extends Handler
    {

        public static final String  DEFAULT_OPERATOR = "=";

        public FilterHandler()
        {
        }


        @Override
        public void build(
                        final Query<?> query,
                        final QueryParams params,
                        final String key
                        )
        {
            String  value = params.get( key );
            if (value == null  ||  value.length() == 0) {
                return;
            }

            String  field = params.field( key );
            query.filter( field, value );
        }

    }
    // FilterHandler



    /**
     * A query param handler for result ordering.
     */
    protected static class OrderHandler
    extends Handler
    {

        public OrderHandler()
        {
        }


        private String _convertFields(
                        final String ordering,
                        final QueryParams params
                        )
        {
            StringBuilder  s = new StringBuilder();
            String[]  keys = ordering.split( "," );
            for (String  key : keys) {
                if (s.length() > 0) {
                    s.append( "," );
                }

                if (key.startsWith( "-" )) {
                    key = key.substring( 1 );
                    s.append( "-" );
                }
                String  field = params.field( key );
                s.append( field );
            }

            return s.toString();
        }


        @Override
        public void build(
                        final Query<?> query,
                        final QueryParams params,
                        final String key
                        )
        {
            String  value = params.get( key );
            if (value == null  ||  value.length() == 0) {
                return;
            }

            String  fields = _convertFields( key, params );
            query.order( fields );
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


        @Override
        public void build(
                        final Query<?> query,
                        final QueryParams params,
                        final String key
                        )
        {
            String  value = params.get( key );
            if (value == null  ||  value.length() == 0) {
                return;
            }

            String  field = params.field( key );
            Pattern  pattern = Pattern.compile( ".*" + value + ".*", Pattern.CASE_INSENSITIVE );
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


        private static SimpleDateFormat  _DATE_FORMATTER_ =
            new SimpleDateFormat( "yyyy-MM-dd" );


        @Override
        public void build(
                        final Query<?> query,
                        final QueryParams params,
                        final String key
                        )
        {
            String  value = params.get( key );
            if (value == null  ||  value.length() == 0) {
                return;
            }

            // validation
            try {
                _DATE_FORMATTER_.parse( value );
            } catch (ParseException ex) {
                throw new OvalRepositoryException( ex );
            }

            String  field = params.field( key );
            query.filter( field, value );
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


    private static Collection<Entry> _createDefaultEntries()
    {
        Handler  offsetHandler = new Handler()
        {
            @Override
            public void build(
                            final Query<?> query,
                            final QueryParams params,
                            final String key
                            )
            {
                String  value = params.get( key );
                if (value == null  ||  value.length() == 0) {
                    return;
                }

                int  offset = Integer.valueOf( value ).intValue();
                query.offset( offset );
            }
        };


        Handler  limitHandler = new Handler()
        {
            @Override
            public void build(
                            final Query<?> query,
                            final QueryParams params,
                            final String key
                            )
            {
                String  value = params.get( key );
                if (value == null  ||  value.length() == 0) {
                    return;
                }

                int  limit = Integer.valueOf( value ).intValue();
                query.limit( limit );
            }
        };


        Handler  definitionClassHandler = new Handler()
        {
            @Override
            public void build(
                            final Query<?> query,
                            final QueryParams params,
                            final String key
                            )
            {
                String  value = params.get( key );
                if (value == null  ||  value.length() == 0) {
                    return;
                }

                ClassEnumeration  clazz = ClassEnumeration.fromValue( value );
                String  field = params.field( key );
                query.filter( field, clazz );
            }
        };


        Handler  versionHandler = new Handler()
        {
            @Override
            public void build(
                            final Query<?> query,
                            final QueryParams params,
                            final String key
                            )
            {
                String  value = params.get( key );
                if (value == null  ||  value.length() == 0) {
                    return;
                }

                Integer  version = Integer.valueOf( value );
                String  field = params.field( key );
                query.filter( field, version );
            }
        };


        Handler  ovalComponentTypeHandler = new Handler()
        {
            @Override
            public void build(
                            final Query<?> query,
                            final QueryParams params,
                            final String key
                            )
            {
                String  value = params.get( key );
                if (value == null  ||  value.length() == 0) {
                    return;
                }

                OvalComponentType  component = OvalComponentType.valueOf( value );
                String  field = params.field( key );
                query.filter( field, component );
            }
        };

        Handler  ovalPlatformTypeHandler = new FilterHandler()
        {
            @Override
            public void build(
                            final Query<?> query,
                            final QueryParams params,
                            final String key
                            )
            {
                String  value = params.get( key );
                if (value == null  ||  value.length() == 0) {
                    return;
                }

                OvalPlatformType  platform = OvalPlatformType.valueOf( value );
                String  field = params.field( key );
                query.filter( field, platform );
            }
        };


        Collection<Entry>  entries = new ArrayList<Entry>();

        // common
        entries.add( new Entry( CommonQueryParams.Key.OFFSET, null, offsetHandler ) );
        entries.add( new Entry( CommonQueryParams.Key.LIMIT,  null, limitHandler ) );
        entries.add( new Entry( CommonQueryParams.Key.ORDER,  null, new OrderHandler() ) );

        // entity
        entries.add( new Entry( OvalEntityQueryParams.Key.ID,      "oval_id" ) );
        entries.add( new Entry( OvalEntityQueryParams.Key.VERSION, "oval_version",  versionHandler ) );

        entries.add( new Entry( OvalEntityQueryParams.Key.SCHEMA_VERSION,  "_oval_generator.schema_version" ) );
        entries.add( new Entry( OvalEntityQueryParams.Key.PLATFORM,    "_oval_platform_type",  ovalPlatformTypeHandler   ) );
        entries.add( new Entry( OvalEntityQueryParams.Key.COMPONENT,   "_oval_component_type", ovalComponentTypeHandler  ) );


        // definition
        entries.add( new Entry( DefinitionsQueryParams.Key.DEFINITION_CLASS, "class",         definitionClassHandler ) );
        entries.add( new Entry( DefinitionsQueryParams.Key.FAMILY,           "metadata.affected.family"   ) );
        //TODO: vs. OvalEntityQueryParams.Key.PLATFORM, different field mapping!!!
        //      Add prefix "affected"???
        //      Move field mappings to concrete QueryParams classes???
//        entries.add( new Entry( DefinitionsQueryParams.Key.PLATFORM,         "metadata.affected.platform" ) );
        entries.add( new Entry( DefinitionsQueryParams.Key.PRODUCT,          "metadata.affected.product"  ) );
        entries.add( new Entry( DefinitionsQueryParams.Key.REF_ID,           "metadata.reference.ref_id"  ) );

        // test
        entries.add( new Entry( TestQueryParams.Key.OBJECT_REF,  "object.object_ref"  ) );
        entries.add( new Entry( TestQueryParams.Key.STATE_REF,   "state.state_ref"  ) );

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

