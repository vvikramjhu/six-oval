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

        return (new CommonBuilder( params ));
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
        String[]  keys = _asList( ordering );
//        String[]  keys = ordering.split( "," );
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



    ////////////////////////////////////////////////////////////////
    //  utility functions
    ////////////////////////////////////////////////////////////////

    /**
     * "aaa,b*,cc" --> new String[] { "aaa", "b*", "cc" }
     * null or ""  --> new String[0]
     */
    protected static String[] _asList(
                    final String value
                    )
    {
        if (value == null  ||  value.length() == 0) {
            return (new String[0]);
        }

        return (value.contains( LIST_DELIMITER ) ? value.split( LIST_DELIMITER ) : (new String[] { value }));
    }


//TODO:
//    protected static <T extends OvalEnumeration> T[] _asList(
//                    final Class<T> type,
//                    final String value
//                    )
//    {
//        .....
//    }


    protected static boolean _isList(
                    final String value
                    )
    {
        if (value == null  ||  value.length() == 0) {
            return false;
        }

        return value.contains( LIST_DELIMITER );
    }



    protected static boolean _isEmpty(
                    final String s
                    )
    {
        return (s == null  ||  s.length() == 0);
    }



    protected static boolean _isPattern(
                    final String s
                    )
    {
        return (_isEmpty( s ) ? false : s.contains( WILD_CARD ));
    }


    protected static Object _asMatchingObject(
                    final String s
                    )
    {
        if (!_isPattern( s )) {
            return s;
        }

        String  regex = s.replace( ".", "\\." );
        regex = s.replace( WILD_CARD, _INTERNAL_WILD_CARD_ );
        return Pattern.compile( regex, Pattern.CASE_INSENSITIVE );
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
            if (_isEmpty( value )) {
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



    protected static class IntegerHandler
    extends Handler
    {
        public static final IntegerHandler  INSTANCE = new IntegerHandler();


        public IntegerHandler()
        {
        }


        @Override
        public void build(
                        final Query<?> query,
                        final String field,
                        final String value
                        )
        {
            if (_isEmpty( value )) {
                return;
            }

            char  operator = value.charAt( 0 );
            if (operator == '>'  ||  operator == '<') {
                Integer  int_value = Integer.valueOf( value.substring( 1 ) );
                query.filter( field + " " + operator, int_value );
            } else {
                Integer  int_value = Integer.valueOf( value );
                query.filter( field, int_value );
            }
        }

    }
    //Integer



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
            if (_isEmpty( value )) {
                return;
            }

            String[]  value_elements = _asList( value );
//            String[]  value_elements = value.split( LIST_DELIMITER );
            if (value_elements.length > 1) {
                query.filter( field + " in", value_elements );
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
            if (_isEmpty( value )) {
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
            if (_isEmpty( value )) {
                return;
            }


            Pattern  pattern = Pattern.compile( ".*" + value + ".*", Pattern.CASE_INSENSITIVE );
            if (_isList( field )) {
                // e.g. title,comment = ".*buffer overflow.*"
                String[]  fs = _asList( field );
//                String[]  fs = field.split( "," );
                int  size = fs.length;
                Criteria[]  criteria = new Criteria[size];
                for (int  i = 0; i < size; i++) {
                    criteria[i] = query.criteria( fs[i] ).equal( pattern );
                }
                query.or( criteria );
            } else {
                query.criteria( field ).equal( pattern );
            }
        }

    }
    // PatternHandler



    protected static class SearchTermHandler
    extends Handler
    {
        public static final SearchTermHandler  INSTANCE = new SearchTermHandler();


        public SearchTermHandler()
        {
        }


        @Override
        public void build(
                        final Query<?> query,
                        final String field,
                        final String value
                        )
        {
            if (_isEmpty( value )) {
                return;
            }

            String[] field_elem = _asList( field );
//            String[] field_elem = (field.contains( LIST_DELIMITER ) ? field.split( LIST_DELIMITER )
//                            : (new String[] { field }));
            int  num_field_elem = field_elem.length;

            // prepare patterns
            String[] value_elem = _asList( value );
//            String[] value_elem = (value.contains( LIST_DELIMITER ) ? value.split( LIST_DELIMITER )
//                            : (new String[] { value }));
            int  num_value_elem = value_elem.length;
            Pattern[]  pattern = new Pattern[num_value_elem];
            for (int  j = 0; j < num_value_elem; j++) {
                pattern[j] = Pattern.compile( ".*" + value_elem[j] + ".*", Pattern.CASE_INSENSITIVE );
            }


            if (num_field_elem > 1) {
                if (num_value_elem > 1) {
                    //f1,f2,...=v1,v2,...
                    int  num_criteria = num_field_elem * num_value_elem;
                    Criteria[]  criteria = new Criteria[num_criteria];
                    for (int  i = 0; i < num_field_elem; i++) {
                        for (int  j = 0; j < num_field_elem; j++) {
                            int  index = i * j + j;
                            criteria[index] = query.criteria( field_elem[i] ).equal( pattern[j] );
                        }
                    }
                    query.or( criteria );
                } else {
                    //f1,f2,...=v1
                    int  num_criteria = num_field_elem;
                    Criteria[]  criteria = new Criteria[num_criteria];
                    for (int  i = 0; i < num_field_elem; i++) {
                        criteria[i] = query.criteria( field_elem[i] ).equal( pattern[0] );
                    }
                    query.or( criteria );
                }

            } else {
                if (num_value_elem > 1) {
                    //f1=v1,v2,...
                    int  num_criteria = num_value_elem;
                    Criteria[]  criteria = new Criteria[num_criteria];
                    for (int  j = 0; j < num_value_elem; j++) {
                        criteria[j] = query.criteria( field ).equal( pattern[j] );
                    }
                    query.or( criteria );
                } else {
                    //f1=v1
                    query.criteria( field ).equal( pattern[0] );
                }
            }
        }
    }
    // SearchTermHandler



    /**
     * f=a
     * f=a,b,c
     * f=x*
     * f=x*,y
     * f=x*,y,z*
     */
    protected static class PatternListHandler
    extends Handler
    {
        public static final PatternListHandler INSTANCE = new PatternListHandler();


        public PatternListHandler()
        {
        }


        @Override
        public void build(
                        final Query<?> query,
                        final String field,
                        final String value
                        )
        {
            if (_isEmpty( value )) {
                return;
            }

            String[]  value_elem = _asList( value );
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
    //PatternList



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
            if (_isEmpty( value )) {
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



    ////////////////////////////////////////////////////////////////
    //  builders
    ////////////////////////////////////////////////////////////////

    public static class CommonBuilder
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
                    if (_isEmpty( value )) {
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
                    if (_isEmpty( value )) {
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



        public CommonBuilder(
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
    //Common



    /**
     * DefinitionsElement.
     *
     * @author	Akihito Nakamura, AIST
     * @version $Id$
     */
    public static class DefinitionsElementBuilder
    extends CommonBuilder
    {

        protected static Map<String, String> _createFieldMapping()
        {
            Map<String, String>  mapping = new HashMap<String, String>();

            //NOTE:
            // DefinitionsElementQueryParams.Key.TYPE param is handled by the MongoOvalDefinitionRepository.

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
            Handler  component_handler = new Handler()
            {
                @Override
                public void build(
                                final Query<?> query,
                                final String field,
                                final String value
                                )
                {
                    if (_isEmpty( value )) {
                        return;
                    }

                    if (_isList( value )) {
                        String[]  value_elem = _asList( value );
                        int  size = value_elem.length;
                        Component[]  component_list = new Component[size];
                        for (int  i = 0; i < size; i++) {
                            component_list[i] = Component.fromValue( value_elem[i] );
                        }
                        query.filter( field + " in", component_list );
                    } else {
                        Component  component = Component.fromValue( value );
                        query.filter( field, component );
                    }
//backup
//                    if (value.contains( LIST_DELIMITER )) {
//                        String[]  value_elem = value.split( LIST_DELIMITER );
//                        int  size = value_elem.length;
//                        Component[]  component_list = new Component[size];
//                        for (int  i = 0; i < size; i++) {
//                            component_list[i] = Component.fromValue( value_elem[i] );
//                        }
//                        query.filter( field + " in", component_list );
//                    } else {
//                        Component  component = Component.fromValue( value );
//                        query.filter( field, component );
//                    }
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
                    if (_isEmpty( value )) {
                        return;
                    }

                    if (_isList( value )) {
                        String[]  value_elem = _asList( value );
                        int  size = value_elem.length;
                        Family[]  family_list = new Family[size];
                        for (int  i = 0; i < size; i++) {
                            family_list[i] = Family.fromValue( value_elem[i] );
                        }
                        query.filter( field + " in", family_list );
                    } else {
                        Family  family = Family.fromValue( value );
                        query.filter( field, family );
                    }
                }
            };


            Map<String, Handler>  mapping = CommonBuilder._createHandlers();
            mapping.put( CommonQueryParams.Key.SEARCH_TERMS,            SearchTermHandler.INSTANCE );
//            mapping.put( CommonQueryParams.Key.SEARCH_TERMS,            PatternHandler.INSTANCE );

            //definitions element
            mapping.put( DefinitionsElementQueryParams.Key.ID,          PatternListHandler.INSTANCE );
//            mapping.put( DefinitionsElementQueryParams.Key.ID,          HasAnyOfHandler.INSTANCE );
            mapping.put( DefinitionsElementQueryParams.Key.VERSION,     IntegerHandler.INSTANCE );
//            mapping.put( DefinitionsElementQueryParams.Key.VERSION,     version_handler );
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



    /**
     * Definition.
     */
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
                    if (_isEmpty( value )) {
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
                    if (_isEmpty( value )) {
                        return;
                    }

                    FamilyEnumeration  family = FamilyEnumeration.fromValue( value );
                    query.filter( field, family );
                }
            };


            Map<String, Handler>  mapping = DefinitionsElementBuilder._createHandlers();
            //common
            mapping.put( CommonQueryParams.Key.SEARCH_TERMS,            SearchTermHandler.INSTANCE );
//            mapping.put( CommonQueryParams.Key.SEARCH_TERMS,            PatternHandler.INSTANCE );

            //definition
            mapping.put( DefinitionQueryParams.Key.DEFINITION_CLASS,    class_handler );
            mapping.put( DefinitionQueryParams.Key.PLATFORM,            HasAnyOfHandler.INSTANCE );
            mapping.put( DefinitionQueryParams.Key.PRODUCT,             HasAnyOfHandler.INSTANCE );
            mapping.put( DefinitionQueryParams.Key.REF_SOURCE,          FilterHandler.INSTANCE );
            mapping.put( DefinitionQueryParams.Key.REF_ID,              FilterHandler.INSTANCE );
            mapping.put( DefinitionQueryParams.Key.CVE,                 PatternListHandler.INSTANCE );
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
    extends CommonBuilder
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
            Map<String, Handler>  mapping = CommonBuilder._createHandlers();
            //common
//            mapping.put( CommonQueryParams.Key.SEARCH_TERMS,            PatternHandler.INSTANCE );
            //sc
            mapping.put( OvalSystemCharacteristicsQueryParams.Key.HOST,         PatternListHandler.INSTANCE );
            mapping.put( OvalSystemCharacteristicsQueryParams.Key.OS,           PatternListHandler.INSTANCE );
            mapping.put( OvalSystemCharacteristicsQueryParams.Key.OS_VERSION,   FilterHandler.INSTANCE );
            mapping.put( OvalSystemCharacteristicsQueryParams.Key.IP,           PatternListHandler.INSTANCE );
            mapping.put( OvalSystemCharacteristicsQueryParams.Key.MAC,          PatternListHandler.INSTANCE );

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
    extends CommonBuilder
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
                    if (_isEmpty( value )) {
                        return;
                    }

                    if (_isList( value )) {
                        String[]  value_elem = _asList( value );
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

