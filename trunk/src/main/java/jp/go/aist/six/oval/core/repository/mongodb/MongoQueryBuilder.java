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

package jp.go.aist.six.oval.core.repository.mongodb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import jp.go.aist.six.oval.model.Component;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.common.ClassEnumeration;
import jp.go.aist.six.oval.model.common.FamilyEnumeration;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.model.definitions.DefinitionsElement;
import jp.go.aist.six.oval.model.definitions.TestType;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.model.results.ResultEnumeration;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import jp.go.aist.six.oval.repository.CommonQueryParams;
import jp.go.aist.six.oval.repository.DefinitionQueryParams;
import jp.go.aist.six.oval.repository.DefinitionsElementQueryParams;
import jp.go.aist.six.oval.repository.OvalRepositoryException;
import jp.go.aist.six.oval.repository.OvalResultsQueryParams;
import jp.go.aist.six.oval.repository.OvalSystemCharacteristicsQueryParams;
import jp.go.aist.six.oval.repository.QueryParams;
import jp.go.aist.six.oval.repository.TestQueryParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.code.morphia.query.Criteria;
import com.google.code.morphia.query.Query;




/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class MongoQueryBuilder
implements QueryBuilder
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ =
        LoggerFactory.getLogger( MongoQueryBuilder.class );



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
        } else if (DefinitionsElement.class.isAssignableFrom( type )) {
            return (new DefinitionsElementBuilder( params ));
        } else if (OvalSystemCharacteristics.class.isAssignableFrom( type )) {
            return (new OvalSystemCharacteristicsBuilder( params ));
        } else if (OvalResults.class.isAssignableFrom( type )) {
            return (new OvalResultsBuilder( params ));
        }

        return (new BasicBuilder( params ));
    }



//    protected static final Handler  _DEFAULT_HANDLER_ = new FilterHandler();



    public static final String  LIST_DELIMITER = ",";
    public static final String  WILD_CARD = "*";
    private static final String  _INTERNAL_WILD_CARD_ = ".*";


    private QueryParams  _params;



    /**
     * Constructor.
     */
    protected MongoQueryBuilder()
    {

    }


    public MongoQueryBuilder(
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
//        query.disableValidation();

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



    /**
     * Subclasses may override this to define own key-handler mapping.
     */
    protected abstract Map<String, Handler> _handlerMapping();


    protected Handler _getHandler(
                    final String key
                    )
    {
        Handler  handler = _handlerMapping().get( key );
        return (handler == null ? FilterHandler.INSTANCE : handler);
//        return (handler == null ? _DEFAULT_HANDLER_ : handler);
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



    protected static class IgnoringHandler
    extends Handler
    {
        public static final IgnoringHandler  INSTANCE = new IgnoringHandler();

        public IgnoringHandler()
        {
        }


        @Override
        public void build(
                        final Query<?> query,
                        final String field,
                        final String value
                        )
        {
            //Ignore the field!
        }

    }
    //IgnoringHandler



    protected static class FilterHandler
    extends Handler
    {
        public static final FilterHandler  INSTANCE = new FilterHandler();

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



    protected static class HasAnyOfHandler
    extends Handler
    {
        public static final HasAnyOfHandler  INSTANCE = new HasAnyOfHandler();


        public HasAnyOfHandler()
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

            String[]  elements = value.split( LIST_DELIMITER );
            if (elements.length > 1) {
                query.filter( field + " in", elements );
            } else {
                query.filter( field, value );
            }
        }

    }
    //HasAnyOf



    /**
     * A query param handler for result ordering.
     */
    protected static class OrderHandler
    extends Handler
    {

        public static final OrderHandler  INSTANCE = new OrderHandler();


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
            if (field.contains( "," )) {
                // e.g. title,comment = ".*buffer overflow.*"
                String[]  fs = field.split( "," );
                int  size = fs.length;
                Criteria[]  criteria = new Criteria[size];
                for (int  i = 0; i < size; i++) {
                    criteria[i] = query.criteria( fs[i] ).equal( pattern );
                }
                query.or( criteria );
            } else {

//                Pattern  pattern = Pattern.compile( ".*" + value + ".*", Pattern.CASE_INSENSITIVE );
                query.criteria( field ).equal( pattern );
            }

            //backup
//            Pattern  pattern = Pattern.compile( ".*" + value + ".*", Pattern.CASE_INSENSITIVE );
//            query.filter( field, pattern );
        }

    }
    // PatternHandler



    /**
     * f=a
     * f=a,b,c
     * f=x*
     * f=x*,y
     * f=x*,y,z*
     */
    protected static class ListPatternHandler
    extends Handler
    {
        public static final ListPatternHandler INSTANCE = new ListPatternHandler();


        public ListPatternHandler()
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

            String[]  value_elem = (value.contains( LIST_DELIMITER )
                                            ? value.split( LIST_DELIMITER )
                                            : (new String[] { value }));
            int  num_value_elem = value_elem.length;
            boolean  wild_card_contained = value.contains( WILD_CARD );

            if (wild_card_contained) {
                if (num_value_elem > 1) {
                    // f=x*,y
                    // f=x*,y,z*
                    Criteria[]  criteria = new Criteria[num_value_elem];
                    for (int  i = 0; i < num_value_elem; i++) {
                        Object  normalized_value = null;
                        if (value_elem[i].contains( WILD_CARD )) {
                            // x*
                            String  pattern_value = value_elem[i].replace( WILD_CARD, _INTERNAL_WILD_CARD_ );
                            normalized_value = Pattern.compile( pattern_value, Pattern.CASE_INSENSITIVE );
                        } else {
                            // y
                            normalized_value = value_elem[i];
                        }
                        criteria[i] = query.criteria( field ).equal( normalized_value );
                    }
                    query.or( criteria );
                } else {
                    // f=x*
                    String  pattern_value = value.replace( WILD_CARD, _INTERNAL_WILD_CARD_ );
                    Pattern  pattern = Pattern.compile( pattern_value, Pattern.CASE_INSENSITIVE );
                    query.filter( field, pattern );
                }
            } else {
                if (num_value_elem > 1) {
                    // f=a,b,c
                    query.filter( field + " in", value_elem );
                } else {
                    // f=a
                    query.filter( field, value );
                }
            }
        }
    }
    //ListPatternHandler



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
    extends MongoQueryBuilder
    {

        /**
         * Query key --> database field
         */
        private static final Map<String, String>  _FIELDS_ = Collections.emptyMap();
        // CommonQueryParams contains key NOT mapped to the fields.


        // Handlers //

        protected static Map<String, Handler> _createHandlers()
        {
            Handler  offset_handler = new Handler()
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


            Handler  limit_handler = new Handler()
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
            mapping.put( CommonQueryParams.Key.START_INDEX, offset_handler );
            mapping.put( CommonQueryParams.Key.COUNT,       limit_handler );
            mapping.put( CommonQueryParams.Key.ORDER,       OrderHandler.INSTANCE );

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
    //BasicBuilder



    /**
     * QueryBuilder for the DefinitionsElement.
     *
     * @author	Akihito Nakamura, AIST
     * @version $Id$
     */
    public static class DefinitionsElementBuilder
    extends BasicBuilder
    {

        protected static Map<String, String> _createFieldMapping()
        {
            Map<String, String>  mapping = new HashMap<String, String>();

            mapping.put( DefinitionsElementQueryParams.Key.ID,          "oval_id" );
            mapping.put( DefinitionsElementQueryParams.Key.VERSION,     "oval_version" );
            mapping.put( DefinitionsElementQueryParams.Key.FAMILY,      "_oval_family" );
            mapping.put( DefinitionsElementQueryParams.Key.COMPONENT,   "_oval_component" );

            mapping.put( DefinitionsElementQueryParams.Key.SCHEMA,      "_oval_generator.schema_version" );

            //common params
            mapping.put( CommonQueryParams.Key.SEARCH_TERMS,            "comment" );

            return mapping;
        }


        private static final Map<String, String>  _FIELDS_ = _createFieldMapping();



        protected static Map<String, Handler> _createHandlers()
        {
            Handler  version_handler = new Handler()
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


            Handler  component_handler = new Handler()
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

                    Component  component = Component.fromValue( value );
//                    _LOG_.debug( "component type handler: value=" + value + ", component=" + component );
                    query.filter( field, component );
                }
            };


            Handler  family_handler = new FilterHandler()
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

                    Family  family = Family.fromValue( value );
                    query.filter( field, family );
                }
            };


            Map<String, Handler>  mapping = BasicBuilder._createHandlers();
            mapping.put( CommonQueryParams.Key.SEARCH_TERMS,            PatternHandler.INSTANCE );

            mapping.put( DefinitionsElementQueryParams.Key.ID,          HasAnyOfHandler.INSTANCE );
//            mapping.put( DefinitionsElementQueryParams.Key.ID,          FilterHandler.INSTANCE );
            mapping.put( DefinitionsElementQueryParams.Key.VERSION,     version_handler );
            mapping.put( DefinitionsElementQueryParams.Key.SCHEMA,      FilterHandler.INSTANCE );
            mapping.put( DefinitionsElementQueryParams.Key.FAMILY,      family_handler );
            mapping.put( DefinitionsElementQueryParams.Key.COMPONENT,   component_handler );

            return mapping;
        }


        private static final Map<String, Handler>  _HANDLERS_ = _createHandlers();



        public DefinitionsElementBuilder(
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
    //DefinitionsElementBuilder



    public static class DefinitionBuilder
    extends DefinitionsElementBuilder
    {

        protected static Map<String, String> _createFieldMapping()
        {
            Map<String, String>  mapping = DefinitionsElementBuilder._createFieldMapping();

            mapping.put( DefinitionQueryParams.Key.DEFINITION_CLASS,    "class" );
            mapping.put( DefinitionQueryParams.Key.FAMILY,              "metadata.affected.family" );   //override
            mapping.put( DefinitionQueryParams.Key.PLATFORM,            "metadata.affected.platform" );
            mapping.put( DefinitionQueryParams.Key.PRODUCT,             "metadata.affected.product" );
            mapping.put( DefinitionQueryParams.Key.REF_SOURCE,          "metadata.reference.source" );
            mapping.put( DefinitionQueryParams.Key.REF_ID,              "metadata.reference.ref_id" );
            mapping.put( DefinitionQueryParams.Key.CVE,                 "metadata.reference.ref_id" );

            // common
            mapping.put( CommonQueryParams.Key.SEARCH_TERMS,            "metadata.title,metadata.description" );
//            mapping.put( CommonQueryParams.Key.SEARCH_TERMS,            "metadata.title" );

            return mapping;
        }


        private static final Map<String, String>  _FIELDS_ = _createFieldMapping();



        protected static Map<String, Handler> _createHandlers()
        {
            Handler  class_handler = new Handler()
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


            Handler  family_handler = new FilterHandler()
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

                    FamilyEnumeration  family = FamilyEnumeration.fromValue( value );
                    query.filter( field, family );
                }
            };


            Map<String, Handler>  mapping = DefinitionsElementBuilder._createHandlers();
            //common
            mapping.put( CommonQueryParams.Key.SEARCH_TERMS,            PatternHandler.INSTANCE );
            //definition
            mapping.put( DefinitionQueryParams.Key.DEFINITION_CLASS,    class_handler );
            mapping.put( DefinitionQueryParams.Key.PLATFORM,            HasAnyOfHandler.INSTANCE );
            mapping.put( DefinitionQueryParams.Key.PRODUCT,             HasAnyOfHandler.INSTANCE );
            mapping.put( DefinitionQueryParams.Key.REF_SOURCE,          FilterHandler.INSTANCE );
            mapping.put( DefinitionQueryParams.Key.REF_ID,              FilterHandler.INSTANCE );
            mapping.put( DefinitionQueryParams.Key.CVE,                 ListPatternHandler.INSTANCE );
            // Overrides.
            mapping.put( DefinitionsElementQueryParams.Key.FAMILY,      family_handler );

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
    //DefinitionBuilder



    public static class TestBuilder
    extends DefinitionsElementBuilder
    {

        protected static Map<String, String> _createFieldMapping()
        {
            Map<String, String>  mapping = DefinitionsElementBuilder._createFieldMapping();

            mapping.put( TestQueryParams.Key.OBJECT_REF,    "object.object_ref" );
            mapping.put( TestQueryParams.Key.STATE_REF,     "state.state_ref" );

            return mapping;
        }


        private static final Map<String, String>  _FIELDS_ = _createFieldMapping();



        protected static Map<String, Handler> _createHandlers()
        {

            Map<String, Handler>  mapping = DefinitionsElementBuilder._createHandlers();
            mapping.put( TestQueryParams.Key.OBJECT_REF,    FilterHandler.INSTANCE );
            mapping.put( TestQueryParams.Key.STATE_REF,     FilterHandler.INSTANCE );

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

            mapping.put( OvalSystemCharacteristicsQueryParams.Key.HOST,         "system_info.primary_host_name" );
            mapping.put( OvalSystemCharacteristicsQueryParams.Key.OS,           "system_info.os_name" );
            mapping.put( OvalSystemCharacteristicsQueryParams.Key.OS_VERSION,   "system_info.os_version" );
            mapping.put( OvalSystemCharacteristicsQueryParams.Key.IP,           "system_info.interfaces.interface.ip_address" );
            mapping.put( OvalSystemCharacteristicsQueryParams.Key.MAC,          "system_info.interfaces.interface.mac_address" );

            return mapping;
        }


        private static final Map<String, String>  _FIELDS_ = _createFieldMapping();



//        protected static Map<String, Handler> _createHandlers()
//        {
//
//            Map<String, Handler>  mapping = BasicBuilder._createHandlers();
//
//            return mapping;
//        }
        protected static Map<String, Handler> _createHandlers()
        {
            Map<String, Handler>  mapping = BasicBuilder._createHandlers();
            //common
//            mapping.put( CommonQueryParams.Key.SEARCH_TERMS,            PatternHandler.INSTANCE );
            //sc
            mapping.put( OvalSystemCharacteristicsQueryParams.Key.HOST,         ListPatternHandler.INSTANCE );
            mapping.put( OvalSystemCharacteristicsQueryParams.Key.OS,           ListPatternHandler.INSTANCE );
            mapping.put( OvalSystemCharacteristicsQueryParams.Key.OS_VERSION,   FilterHandler.INSTANCE );
            mapping.put( OvalSystemCharacteristicsQueryParams.Key.IP,           ListPatternHandler.INSTANCE );
            mapping.put( OvalSystemCharacteristicsQueryParams.Key.MAC,          ListPatternHandler.INSTANCE );

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
            Map<String, String>  mapping = OvalSystemCharacteristicsBuilder._createFieldMapping();
            for (String  key : mapping.keySet()) {
                String  field = mapping.get( key );
                field = "results.system.oval_system_characteristics." + field;
                mapping.put( key, field );
            }

            mapping.put( OvalResultsQueryParams.Key.DEFINITION,         "results.system.definitions.definition.oval_id" );
            mapping.put( OvalResultsQueryParams.Key.DEFINITION_TRUE,    "results.system.definitions.definition" );

            return mapping;
        }


        private static final Map<String, String>  _FIELDS_ = _createFieldMapping();



        protected static Map<String, Handler> _createHandlers()
        {
            Handler  definitionTrueHandler = new Handler()
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

                    if (value.contains( LIST_DELIMITER )) {
                        String[]  value_elem = value.split( LIST_DELIMITER );
                        int  num_value_elem = value_elem.length;
                        Criteria[]  criteria = new Criteria[num_value_elem];
                        for (int  i = 0; i < num_value_elem; i++) {
                            jp.go.aist.six.oval.model.results.DefinitionType  result_def =
                                            new jp.go.aist.six.oval.model.results.DefinitionType();
                            result_def.setOvalID( value_elem[i] );
                            result_def.setResult( ResultEnumeration.TRUE );
                            criteria[i] = query.criteria( field ).hasThisElement( result_def );
                        }
                        query.or( criteria );
                    } else {
                        jp.go.aist.six.oval.model.results.DefinitionType  result_def =
                                        new jp.go.aist.six.oval.model.results.DefinitionType();
                        result_def.setDefinitionID( value );
                        result_def.setResult( ResultEnumeration.TRUE );
                        query.filter( field + " elem", result_def );
                    }

                }
            };


            Map<String, Handler>  mapping = OvalSystemCharacteristicsBuilder._createHandlers();
            mapping.put( OvalResultsQueryParams.Key.DEFINITION_TRUE,    definitionTrueHandler );
            mapping.put( OvalResultsQueryParams.Key.DEFINITION,         HasAnyOfHandler.INSTANCE );

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

