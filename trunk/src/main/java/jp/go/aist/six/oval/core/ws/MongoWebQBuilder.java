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
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import jp.go.aist.six.oval.core.repository.mongodb.QueryBuilder;
import jp.go.aist.six.oval.core.ws.OvalEntityQueryParams.Key;
import jp.go.aist.six.oval.model.OvalComponentType;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.v5.OvalEntity;
import jp.go.aist.six.oval.model.v5.common.ClassEnumeration;
import jp.go.aist.six.oval.model.v5.definitions.DefinitionType;
import jp.go.aist.six.oval.model.v5.definitions.TestType;
import jp.go.aist.six.oval.model.v5.sc.OvalSystemCharacteristics;
import jp.go.aist.six.oval.repository.OvalRepositoryException;
import com.google.code.morphia.query.Query;




/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class MongoWebQBuilder
implements QueryBuilder
{

    /**
     * A factory method.
     */
    public static QueryBuilder createInstance(
                    final Class<?> type,
                    final QueryParams params
                    )
    {
        if (DefinitionType.class.isAssignableFrom( type )) {
            return (new DefinitionBuilder( params ));
        } else if (TestType.class.isAssignableFrom( type )) {
            return (new TestBuilder( params ));
        } else if (OvalEntity.class.isAssignableFrom( type )) {
            return (new OvalEntityBuilder( params ));
        } else if (OvalSystemCharacteristics.class.isAssignableFrom( type )) {
            return (new OvalSystemCharacteristicsBuilder( params ));
        }

        return (new BasicBuilder( params ));
    }



    protected static final Handler  _DEFAULT_HANDLER_ = new FilterHandler();



    private QueryParams  _params;



    /**
     * Constructor.
     */
    protected MongoWebQBuilder()
    {

    }


    public MongoWebQBuilder(
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
            String  field = _getField( key );
            String  value = params.get( key );

            if (CommonQueryParams.Key.ORDER.equalsIgnoreCase( key )) {
                value = _convertOrderingFields( value );
            }

            handler.build( query, field, value );
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



    /**
     * Subclasses may override this to define own key-handler mapping.
     */
    protected abstract Map<String, Handler> _handlerMapping();


    protected Handler _getHandler(
                    final String key
                    )
    {
        Handler  handler = _handlerMapping().get( key );
        return (handler == null ? _DEFAULT_HANDLER_ : handler);
    }



    /**
     * Subclasses may override this to define own key-field mapping.
     */
    protected abstract Map<String, String> _fieldMapping();


    protected String _getField(
                    final String key
                    )
    {
        String  field = _fieldMapping().get( key );
        return (field == null ? key : field);
    }



    protected String _convertOrderingFields(
                    final String ordering
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
            String  field = _getField( key );
            s.append( field );
        }

        return s.toString();
    }




    //**************************************************************
    //  QueryBuilder
    //**************************************************************

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
        public abstract void build( Query<?> query, String field, String value );

    }
    // Handler



    protected static class FilterHandler
    extends Handler
    {

        public static final String  DEFAULT_OPERATOR = "=";

        private String  _operator;


        public FilterHandler()
        {
        }


        public FilterHandler(
                        final String operator
                        )
        {
            this._operator = operator;
        }


        @Override
        public void build(
                        final Query<?> query,
                        final String field,
                        final String value
                        )
        {
            if (value == null  ||  value.length() == 0) {
                return;
            }

            if (_operator == null) {
                query.filter( field, value );
            } else {
                query.filter( field + " " + _operator, value );
            }
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


//        private String _convertFields(
//                        final String ordering
//                        )
//        {
//            StringBuilder  s = new StringBuilder();
//            String[]  keys = ordering.split( "," );
//            for (String  key : keys) {
//                if (s.length() > 0) {
//                    s.append( "," );
//                }
//
//                if (key.startsWith( "-" )) {
//                    key = key.substring( 1 );
//                    s.append( "-" );
//                }
//                String  field = _fields.get( key );
//                s.append( (field == null ? key : field) );
//            }
//
//            return s.toString();
//        }


        @Override
        public void build(
                        final Query<?> query,
                        final String field,
                        final String value
                        )
        {
            if (value == null  ||  value.length() == 0) {
                return;
            }

            query.order( value );
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
                        final String field,
                        final String value
                        )
        {
            if (value == null  ||  value.length() == 0) {
                return;
            }

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
                        final String field,
                        final String value
                        )
        {
            if (value == null  ||  value.length() == 0) {
                return;
            }

            // validation
            try {
                _DATE_FORMATTER_.parse( value );
            } catch (ParseException ex) {
                throw new OvalRepositoryException( ex );
            }

            query.filter( field, value );
        }
    }
    // DatetimeHandler



    //==============================================================
    //  builders
    //==============================================================


    public static class BasicBuilder
    extends MongoWebQBuilder
    {

        /**
         * Query key --> database field
         */
        private static final Map<String, String>  _FIELDS_ = Collections.emptyMap();
        // CommonQueryParams contains key NOT mapped to the fields.


        // Handlers //

        protected static Map<String, Handler> _createHandlers()
        {
            Handler  offsetHandler = new Handler()
            {
                @Override
                public void build(
                                final Query<?> query,
                                final String field,
                                final String value
                                )
                {
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
                                final String field,
                                final String value
                                )
                {
                    if (value == null  ||  value.length() == 0) {
                        return;
                    }

                    int  limit = Integer.valueOf( value ).intValue();
                    query.limit( limit );
                }
            };


            Map<String, Handler>  mapping = new HashMap<String, Handler>();
            mapping.put( Key.OFFSET,  offsetHandler );
            mapping.put( Key.LIMIT,   limitHandler );
            mapping.put( Key.ORDER,   new OrderHandler());

            return mapping;
        }


        /**
         * Query key --> Handler
         */
        private static final Map<String, Handler>  _HANDLERS_ = _createHandlers();



        public BasicBuilder(
                        final QueryParams params
                        )
        {
            super( params );
        }



        @Override
        protected Map<String, Handler> _handlerMapping()
        {
            return _HANDLERS_;
        }


        @Override
        protected Map<String, String> _fieldMapping()
        {
            return _FIELDS_;
        }

    }
    // Basic



    public static class OvalEntityBuilder
    extends BasicBuilder
    {

        protected static Map<String, String> _createFieldMapping()
        {
            Map<String, String>  mapping = new HashMap<String, String>();

            mapping.put( Key.ID,                "oval_id" );
            mapping.put( Key.VERSION,           "oval_version" );

            mapping.put( Key.SCHEMA_VERSION,    "_oval_generator.schema_version" );
            mapping.put( Key.PLATFORM,          "_oval_platform_type" );
            mapping.put( Key.COMPONENT,         "_oval_component_type" );

            return mapping;
        }


        private static final Map<String, String>  _FIELDS_ = _createFieldMapping();



        protected static Map<String, Handler> _createHandlers()
        {
            Handler  versionHandler = new Handler()
            {
                @Override
                public void build(
                                final Query<?> query,
                                final String field,
                                final String value
                                )
                {
                    if (value == null  ||  value.length() == 0) {
                        return;
                    }

                    Integer  version = Integer.valueOf( value );
                    query.filter( field, version );
                }
            };


            Handler  ovalComponentTypeHandler = new Handler()
            {
                @Override
                public void build(
                                final Query<?> query,
                                final String field,
                                final String value
                                )
                {
                    if (value == null  ||  value.length() == 0) {
                        return;
                    }

                    OvalComponentType  component = OvalComponentType.valueOf( value );
                    query.filter( field, component );
                }
            };

            Handler  ovalPlatformTypeHandler = new FilterHandler()
            {
                @Override
                public void build(
                                final Query<?> query,
                                final String field,
                                final String value
                                )
                {
                    if (value == null  ||  value.length() == 0) {
                        return;
                    }

                    OvalPlatformType  platform = OvalPlatformType.valueOf( value );
                    query.filter( field, platform );
                }
            };


            Map<String, Handler>  mapping = BasicBuilder._createHandlers();
            mapping.put( OvalEntityQueryParams.Key.ID,              _DEFAULT_HANDLER_ );
            mapping.put( OvalEntityQueryParams.Key.VERSION,         versionHandler );
            mapping.put( OvalEntityQueryParams.Key.SCHEMA_VERSION,  _DEFAULT_HANDLER_ );
            mapping.put( OvalEntityQueryParams.Key.PLATFORM,        ovalPlatformTypeHandler );
            mapping.put( OvalEntityQueryParams.Key.COMPONENT,       ovalComponentTypeHandler );

            return mapping;
        }


        private static final Map<String, Handler>  _HANDLERS_ = _createHandlers();



        public OvalEntityBuilder(
                        final QueryParams params
                        )
        {
            super( params );
        }



        @Override
        protected Map<String, Handler> _handlerMapping()
        {
            return _HANDLERS_;
        }


        @Override
        protected Map<String, String> _fieldMapping()
        {
            return _FIELDS_;
        }

    }
    // OvalEntity



    public static class DefinitionBuilder
    extends OvalEntityBuilder
    {

        protected static Map<String, String> _createFieldMapping()
        {
            Map<String, String>  mapping = OvalEntityBuilder._createFieldMapping();

            mapping.put( DefinitionsQueryParams.Key.DEFINITION_CLASS,  "class" );
            mapping.put( DefinitionsQueryParams.Key.FAMILY,            "metadata.affected.family" );

            mapping.put( DefinitionsQueryParams.Key.PLATFORM,          "metadata.affected.platform" ); //override
            mapping.put( DefinitionsQueryParams.Key.PRODUCT,           "metadata.affected.product" );
            mapping.put( DefinitionsQueryParams.Key.REF_ID,            "metadata.reference.ref_id" );

            return mapping;
        }


        private static final Map<String, String>  _FIELDS_ = _createFieldMapping();



        protected static Map<String, Handler> _createHandlers()
        {
            Handler  definitionClassHandler = new Handler()
            {
                @Override
                public void build(
                                final Query<?> query,
                                final String field,
                                final String value
                                )
                {
                    if (value == null  ||  value.length() == 0) {
                        return;
                    }

                    ClassEnumeration  clazz = ClassEnumeration.fromValue( value );
                    query.filter( field, clazz );
                }
            };


            Map<String, Handler>  mapping = BasicBuilder._createHandlers();
            mapping.put( DefinitionsQueryParams.Key.DEFINITION_CLASS, definitionClassHandler );
            mapping.put( DefinitionsQueryParams.Key.FAMILY,           _DEFAULT_HANDLER_ );
            mapping.put( DefinitionsQueryParams.Key.PLATFORM,         _DEFAULT_HANDLER_ );
            mapping.put( DefinitionsQueryParams.Key.PRODUCT,          _DEFAULT_HANDLER_ );
            mapping.put( DefinitionsQueryParams.Key.REF_ID,           _DEFAULT_HANDLER_ );

            return mapping;
        }


        private static final Map<String, Handler>  _HANDLERS_ = _createHandlers();



        public DefinitionBuilder(
                        final QueryParams params
                        )
        {
            super( params );
        }



        @Override
        protected Map<String, Handler> _handlerMapping()
        {
            return _HANDLERS_;
        }


        @Override
        protected Map<String, String> _fieldMapping()
        {
            return _FIELDS_;
        }

    }
    // Definition



    public static class TestBuilder
    extends OvalEntityBuilder
    {

        protected static Map<String, String> _createFieldMapping()
        {
            Map<String, String>  mapping = OvalEntityBuilder._createFieldMapping();

            mapping.put( TestQueryParams.Key.OBJECT_REF,    "object.object_ref" );
            mapping.put( TestQueryParams.Key.STATE_REF,     "state.state_ref" );

            return mapping;
        }


        private static final Map<String, String>  _FIELDS_ = _createFieldMapping();



        protected static Map<String, Handler> _createHandlers()
        {

            Map<String, Handler>  mapping = BasicBuilder._createHandlers();
            mapping.put( TestQueryParams.Key.OBJECT_REF,    _DEFAULT_HANDLER_ );
            mapping.put( TestQueryParams.Key.STATE_REF,     _DEFAULT_HANDLER_ );

            return mapping;
        }


        private static final Map<String, Handler>  _HANDLERS_ = _createHandlers();



        public TestBuilder(
                        final QueryParams params
                        )
        {
            super( params );
        }



        @Override
        protected Map<String, Handler> _handlerMapping()
        {
            return _HANDLERS_;
        }


        @Override
        protected Map<String, String> _fieldMapping()
        {
            return _FIELDS_;
        }

    }
    // Test



    public static class OvalSystemCharacteristicsBuilder
    extends BasicBuilder
    {

        protected static Map<String, String> _createFieldMapping()
        {
            Map<String, String>  mapping = new HashMap<String, String>();

            mapping.put( OvalSystemCharacteristicsQueryParams.Key.PRIMARY_HOST_NAME, "system_info.os_name" );
            mapping.put( OvalSystemCharacteristicsQueryParams.Key.OS_NAME,           "system_info.primaary_host_name" );

            return mapping;
        }


        private static final Map<String, String>  _FIELDS_ = _createFieldMapping();



        protected static Map<String, Handler> _createHandlers()
        {

            Map<String, Handler>  mapping = BasicBuilder._createHandlers();

            return mapping;
        }


        private static final Map<String, Handler>  _HANDLERS_ = _createHandlers();



        public OvalSystemCharacteristicsBuilder(
                        final QueryParams params
                        )
        {
            super( params );
        }



        @Override
        protected Map<String, Handler> _handlerMapping()
        {
            return _HANDLERS_;
        }


        @Override
        protected Map<String, String> _fieldMapping()
        {
            return _FIELDS_;
        }

    }
    // OvalSystemCharacteristics

}
// MongoQueryBuilder

