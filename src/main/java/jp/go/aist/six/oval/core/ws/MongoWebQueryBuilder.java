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
import jp.go.aist.six.oval.model.OvalComponentType;
import jp.go.aist.six.oval.model.OvalEntity;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.common.ClassEnumeration;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.model.definitions.TestType;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.model.results.ResultEnumeration;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import jp.go.aist.six.oval.repository.CommonQueryParams;
import jp.go.aist.six.oval.repository.DefinitionQueryParams;
import jp.go.aist.six.oval.repository.OvalEntityQueryParams;
import jp.go.aist.six.oval.repository.OvalRepositoryException;
import jp.go.aist.six.oval.repository.OvalResultsQueryParams;
import jp.go.aist.six.oval.repository.OvalSystemCharacteristicsQueryParams;
import jp.go.aist.six.oval.repository.QueryParams;
import jp.go.aist.six.oval.repository.TestQueryParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.code.morphia.query.Query;




/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class MongoWebQueryBuilder
implements QueryBuilder
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ =
        LoggerFactory.getLogger( MongoWebQueryBuilder.class );



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
        } else if (OvalResults.class.isAssignableFrom( type )) {
            return (new OvalResultsBuilder( params ));
        }

        return (new BasicBuilder( params ));
    }



    protected static final Handler  _DEFAULT_HANDLER_ = new FilterHandler();



    private QueryParams  _params;



    /**
     * Constructor.
     */
    protected MongoWebQueryBuilder()
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
        _params = params;
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
        _LOG_.debug( "field mapping: " + key + " --> " + field );

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
            _operator = operator;
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
        public static final PatternHandler INSTANCE = new PatternHandler();


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
    extends MongoWebQueryBuilder
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
            mapping.put( CommonQueryParams.Key.START_INDEX,  offsetHandler );
            mapping.put( CommonQueryParams.Key.COUNT,   limitHandler );
            mapping.put( CommonQueryParams.Key.ORDER,   new OrderHandler());

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

            mapping.put( OvalEntityQueryParams.Key.ID,                "oval_id" );
            mapping.put( OvalEntityQueryParams.Key.VERSION,           "oval_version" );

            mapping.put( OvalEntityQueryParams.Key.SCHEMA_VERSION,    "_oval_generator.schema_version" );
            mapping.put( OvalEntityQueryParams.Key.PLATFORM,          "_oval_platform_type" );
            mapping.put( OvalEntityQueryParams.Key.COMPONENT,         "_oval_component_type" );

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
//                    _LOG_.debug( "component type handler: value=" + value + ", component=" + component );
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

            mapping.put( DefinitionQueryParams.Key.DEFINITION_CLASS,    "class" );
            mapping.put( DefinitionQueryParams.Key.TITLE,               "metadata.title" );
            mapping.put( DefinitionQueryParams.Key.FAMILY,              "metadata.affected.family" );

            mapping.put( DefinitionQueryParams.Key.PLATFORM,            "metadata.affected.platform" ); //override
            mapping.put( DefinitionQueryParams.Key.PRODUCT,             "metadata.affected.product" );
            mapping.put( DefinitionQueryParams.Key.REF_ID,              "metadata.reference.ref_id" );

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


            Map<String, Handler>  mapping = OvalEntityBuilder._createHandlers();
            mapping.put( DefinitionQueryParams.Key.DEFINITION_CLASS,    definitionClassHandler );
            mapping.put( DefinitionQueryParams.Key.TITLE,               PatternHandler.INSTANCE );
            mapping.put( DefinitionQueryParams.Key.FAMILY,              _DEFAULT_HANDLER_ );
            mapping.put( DefinitionQueryParams.Key.PLATFORM,            _DEFAULT_HANDLER_ );
            mapping.put( DefinitionQueryParams.Key.PRODUCT,             _DEFAULT_HANDLER_ );
            mapping.put( DefinitionQueryParams.Key.REF_ID,              _DEFAULT_HANDLER_ );

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

            Map<String, Handler>  mapping = OvalEntityBuilder._createHandlers();
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



    /**
     */
    public static class OvalSystemCharacteristicsBuilder
    extends BasicBuilder
    {

        protected static Map<String, String> _createFieldMapping()
        {
            Map<String, String>  mapping = new HashMap<String, String>();

            mapping.put( OvalSystemCharacteristicsQueryParams.Key.PRIMARY_HOST_NAME, "system_info.os_name" );
            mapping.put( OvalSystemCharacteristicsQueryParams.Key.OS_NAME,           "system_info.primary_host_name" );

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



    /**
     */
    public static class OvalResultsBuilder
    extends BasicBuilder
    {

        protected static Map<String, String> _createFieldMapping()
        {
            Map<String, String>  mapping = new HashMap<String, String>();

            mapping.put( OvalResultsQueryParams.Key.PRIMARY_HOST_NAME, "results.system.oval_system_characteristics.system_info.primary_host_name" );
            mapping.put( OvalResultsQueryParams.Key.OS_NAME,           "results.system.oval_system_characteristics.system_info.os_name" );
            mapping.put( OvalResultsQueryParams.Key.RESULT_TRUE_DEF,   "results.system.definitions.definition" );

            return mapping;
        }


        private static final Map<String, String>  _FIELDS_ = _createFieldMapping();



        protected static Map<String, Handler> _createHandlers()
        {
            Handler  resultTrueHandler = new Handler()
            {
                @Override
                public void build(
                                final Query<?> query,
                                final String field,
                                final String value  //def's oval_id
                                )
                {
                    if (value == null  ||  value.length() == 0) {
                        return;
                    }

                    jp.go.aist.six.oval.model.results.DefinitionType  result_def =
                                    new jp.go.aist.six.oval.model.results.DefinitionType();
                    result_def.setOvalID( value );
                    result_def.setResult( ResultEnumeration.TRUE );
                    query.filter( field + " elem", result_def );
                }
            };


            Map<String, Handler>  mapping = BasicBuilder._createHandlers();
            mapping.put( OvalResultsQueryParams.Key.PRIMARY_HOST_NAME,  _DEFAULT_HANDLER_ );
            mapping.put( OvalResultsQueryParams.Key.OS_NAME,            _DEFAULT_HANDLER_ );
            mapping.put( OvalResultsQueryParams.Key.RESULT_TRUE_DEF,    resultTrueHandler );

            return mapping;
        }


        private static final Map<String, Handler>  _HANDLERS_ = _createHandlers();



        public OvalResultsBuilder(
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
    //OvalReuslts

}
// MongoQueryBuilder

