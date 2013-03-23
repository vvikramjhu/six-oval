/**
 * SIX OVAL - http://code.google.com/p/six-oval/
 * Copyright (C) 2010
 *   National Institute of Advanced Industrial Science and Technology (AIST)
 *   Registration Number: H22PRO-1124
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jp.go.aist.six.oval.core.repository.morphia;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import jp.go.aist.six.oval.core.model.OvalEnumerationHelper;
import jp.go.aist.six.oval.model.ComponentType;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.OvalEnumeration;
import jp.go.aist.six.oval.model.common.ClassEnumeration;
import jp.go.aist.six.oval.model.common.FamilyEnumeration;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.model.definitions.DefinitionsElement;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.model.results.ResultEnumeration;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import jp.go.aist.six.oval.repository.DefinitionQueryParams;
import jp.go.aist.six.oval.repository.DefinitionsElementQueryParams;
import jp.go.aist.six.oval.repository.OvalRepositoryException;
import jp.go.aist.six.oval.repository.OvalResultsQueryParams;
import jp.go.aist.six.oval.repository.OvalSystemCharacteristicsQueryParams;
import jp.go.aist.six.util.repository.CommonQueryParams;
import jp.go.aist.six.util.repository.QueryParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.jmkgreen.morphia.query.Criteria;
import com.github.jmkgreen.morphia.query.Query;




/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class MorphiaQueryBuilder
implements QueryBuilder
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ = LoggerFactory.getLogger( MorphiaQueryBuilder.class );



    /**
     * A factory method.
     */
    public static QueryBuilder getInstance(
                    final Class<?> type
                    )
    {
        if (DefinitionType.class.isAssignableFrom( type )) {
            return DefinitionBuilder.INSTANCE;
        } else if (DefinitionsElement.class.isAssignableFrom( type )) {
            return DefinitionsElementBuilder.INSTANCE;
        } else if (OvalSystemCharacteristics.class.isAssignableFrom( type )) {
            return OvalSystemCharacteristicsBuilder.INSTANCE;
        } else if (OvalResults.class.isAssignableFrom( type )) {
            return OvalResultsBuilder.INSTANCE;
        }

        return CommonBuilder.INSTANCE;
    }



    public static final String  LIST_DELIMITER = ",";
    public static final String  WILD_CARD = "*";
    private static final String  _INTERNAL_WILD_CARD_ = ".*";



    /**
     * Constructor.
     */
    protected MorphiaQueryBuilder()
    {
    }



    ///////////////////////////////////////////////////////////////////////
    //  template methods
    ///////////////////////////////////////////////////////////////////////

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

    public <T>
    Query<T> build(
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

        return query;
    }




    //**************************************************************
    //  Handler variations
    //**************************************************************

    /**
     * A query parameter handler.
     * It appends an expression that represents the given key-value pair.
     * e.g. given the URI http://.../xxx?key1=value1&key2=value2&...
     */
    protected static interface Handler
    {

        /**
         */
        public abstract void build( Query<?> query, String field, String value );

    }
    // Handler



    protected static class IgnoringHandler
    implements Handler
    {
        public static final IgnoringHandler  INSTANCE = new IgnoringHandler();

        public IgnoringHandler()
        {
        }


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
    implements Handler
    {
        public static final FilterHandler  INSTANCE = new FilterHandler();

        public static final String  DEFAULT_OPERATOR = "=";

        private static final char[]       _QUERY_OPERATORS_ = new   char[] { '!',  '<', '>' };
        private static final String[]  _INTERNAL_OPERATORS_ = new String[] { "!=", "<", ">" };


        public FilterHandler()
        {
        }


        public void build(
                        final Query<?> query,
                        final String field,
                        final String value
                        )
        {
            if (_isEmpty( value )) {
                return;
            }

            String  op = DEFAULT_OPERATOR;
            String  v = value;
            char  c = value.charAt( 0 );
            for (int  i = 0; i < _QUERY_OPERATORS_.length; i++) {
                if (_QUERY_OPERATORS_[i] == c) {
                    op = _INTERNAL_OPERATORS_[i];
                    v = value.substring( 1 );
                    break;
                }
            }

            query.filter( field + " " + op, v );
        }
    }
    // FilterHandler

    protected static class FilterHandler2
    implements Handler
    {
        public static final FilterHandler2  INSTANCE = new FilterHandler2();

        public static final String  DEFAULT_OPERATOR = "=";

        private String  _operator;


        public FilterHandler2()
        {
        }


        public FilterHandler2(
                        final String operator
                        )
        {
            _operator = operator;
        }


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
    // Filter2



    protected static class IntegerHandler
    implements Handler
    {
        public static final IntegerHandler  INSTANCE = new IntegerHandler();


        public IntegerHandler()
        {
        }


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



    protected static class BooleanHandler
    implements Handler
    {
        public static final BooleanHandler  INSTANCE = new BooleanHandler();


        public BooleanHandler()
        {
        }


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
            if (operator == '!') {
                Boolean  bool_value = Boolean.valueOf( value.substring( 1 ) );
                query.filter( field + " !=", bool_value );
            } else {
                Boolean  bool_value = Boolean.valueOf( value );
                query.filter( field, bool_value );
            }
        }
    }
    //Boolean



    /**
     * { field: { $in: [<value1>, <value2>, ... <valueN> ] } }
     */
    protected static class HasAnyOfHandler
    implements Handler
    {
        public static final HasAnyOfHandler  INSTANCE = new HasAnyOfHandler();


        public HasAnyOfHandler()
        {
        }


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
            if (value_elements.length > 1) {
                query.filter( field + " in", value_elements );
            } else {
                query.filter( field, value );
            }
        }
    }
    //HasAnyOfHandler



    /**
     * A query param handler for result ordering.
     */
    protected static class OrderHandler
    implements Handler
    {

        public static final OrderHandler  INSTANCE = new OrderHandler();


        public OrderHandler()
        {
        }


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
    implements Handler
    {
        public static final PatternHandler INSTANCE = new PatternHandler();


        public PatternHandler()
        {
        }


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
                String[]  field_elem = _asList( field );
                int  num_field_elem = field_elem.length;
                Criteria[]  criteria = new Criteria[num_field_elem];
                for (int  i = 0; i < num_field_elem; i++) {
                    criteria[i] = query.criteria( field_elem[i] ).equal( pattern );
                }
                query.or( criteria );
            } else {
                query.criteria( field ).equal( pattern );
            }
        }
    }
    // PatternHandler



    //NOTE: According to some tests, this implementation is slower than the SearchTermsHandler2.
    // A value-list can be represented as a regex ".*X|Y|Z.*" .
    // f1=.*X|Y|Z.* OR
    // f2=.*X|Y|Z.* OR
    // ...
    protected static class SearchTermsHandler
    implements Handler
    {
        public static final SearchTermsHandler  INSTANCE = new SearchTermsHandler();


        public SearchTermsHandler()
        {
        }


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
            int  num_field_elem = field_elem.length;

            String[] value_elem = _asList( value );
            int  num_value_elem = value_elem.length;

            Pattern  pattern = null;
            if (num_value_elem > 1) {
                //...=v1,v2,...
                StringBuilder  s = new StringBuilder();
                for (int  j = 0; j < num_value_elem; j++) {
                    if (s.length() > 0) {
                        s.append( "|" );
                    }
                    s.append( value_elem[j] );
                }
                pattern = Pattern.compile( ".*" + s.toString() + ".*", Pattern.CASE_INSENSITIVE );
            } else {
                //...=v1
                pattern = Pattern.compile( ".*" + value + ".*", Pattern.CASE_INSENSITIVE );
            }


            if (num_field_elem > 1) {
                //f1,f2,...=...
                Criteria[]  criteria = new Criteria[num_field_elem];
                for (int  i = 0; i < num_field_elem; i++) {
                    criteria[i] = query.criteria( field_elem[i] ).equal( pattern );
                }
                query.or( criteria );

            } else {
                //f1=...
                query.criteria( field ).equal( pattern );
            }
        }
    }
    // SearchTerms

    // f1=.*X.* OR f1=.*Y.* OR f1=.*Z.*" OR
    // f2=.*X.* OR f2=.*Y.* OR f2=.*Z.*" OR
    // ...
    protected static class SearchTermsHandler2
    implements Handler
    {
        public static final SearchTermsHandler2  INSTANCE = new SearchTermsHandler2();


        public SearchTermsHandler2()
        {
        }


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
            int  num_field_elem = field_elem.length;

            String[] value_elem = _asList( value );
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
                        for (int  j = 0; j < num_value_elem; j++) {
                            int  index = i * num_value_elem + j;
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
    // SearchTerms2



    /**
     * f=a
     * f=a,b,c
     * f=x*
     * f=x*,y
     * f=x*,y,z*
     */
    protected static class PatternListHandler
    implements Handler
    {
        public static final PatternListHandler INSTANCE = new PatternListHandler();


        public PatternListHandler()
        {
        }


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

            if (_isPattern( value )) {
                if (num_value_elem > 1) {
                    // f=x*,y
                    // f=x*,y,z*
                    Criteria[]  criteria = new Criteria[num_value_elem];
                    for (int  i = 0; i < num_value_elem; i++) {
                        criteria[i] = query.criteria( field ).equal( _asMatchingObject( value_elem[i] ) );
                    }
                    query.or( criteria );
                } else {
                    // f=x*
                    query.filter( field, _asMatchingObject( value ) );
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
    //PatternListHandler



    protected static class OvalEnumerationListHandler
    implements Handler
    {

        private final Class<? extends OvalEnumeration>  _type;


        public OvalEnumerationListHandler(
                        final Class<? extends OvalEnumeration> type
                        )
        {
            _type = type;
        }


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
                List<OvalEnumeration>  list = new ArrayList<OvalEnumeration>();
                for (String  v : value_elem) {
                    list.add( OvalEnumerationHelper.fromValue( _type, v ) );
                }
                query.filter( field + " in", list );
            } else {
                query.filter( field, OvalEnumerationHelper.fromValue( _type, value ) );
            }
        }
    }
    //OvalEnumerationListHandler



    protected static class DatetimeHandler
    implements Handler
    {

        public DatetimeHandler()
        {
        }


        private static SimpleDateFormat  _DATE_FORMATTER_ =
            new SimpleDateFormat( "yyyy-MM-dd" );


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



    ///////////////////////////////////////////////////////////////////////
    //  QueryBuilder variations
    ///////////////////////////////////////////////////////////////////////

    /**
     */
    public static class CommonBuilder
    extends MorphiaQueryBuilder
    {
        public static final CommonBuilder  INSTANCE = new CommonBuilder();


        // Query key --> database field
        private static final Map<String, String>  _FIELDS_ = Collections.emptyMap();
        // CommonQueryParams contains keys which are NOT mapped to the fields.


        protected static Map<String, Handler> _createHandlerMapping()
        {
            Handler  offset_handler = new Handler()
            {
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

            Map<String, Handler>  handler_mapping = new HashMap<String, Handler>();
            handler_mapping.put( CommonQueryParams.Key.START_INDEX, offset_handler );
            handler_mapping.put( CommonQueryParams.Key.COUNT,       limit_handler );
            handler_mapping.put( CommonQueryParams.Key.ORDER,       OrderHandler.INSTANCE );

            return handler_mapping;
        }


        // Query key --> Handler
        private static final Map<String, Handler>  _HANDLERS_ = _createHandlerMapping();


        public CommonBuilder()
        {
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
    //CommonBuilder



    /**
     * oval-def:{definition,test,object,state,variable}
     */
    public static class DefinitionsElementBuilder
    extends CommonBuilder
    {
        public static final DefinitionsElementBuilder  INSTANCE = new DefinitionsElementBuilder();


        protected static Map<String, String> _createFieldMapping()
        {
            Map<String, String>  field_mapping = new HashMap<String, String>();
            field_mapping.put( DefinitionsElementQueryParams.Key.ID,          "oval_id" );
            field_mapping.put( DefinitionsElementQueryParams.Key.VERSION,     "oval_version" );
            field_mapping.put( DefinitionsElementQueryParams.Key.DEPRECATED,  "deprecated" );
            field_mapping.put( DefinitionsElementQueryParams.Key.TYPE,        null );
            //NOTE: TYPE parameter is handled by the Repository implementation class.
            field_mapping.put( DefinitionsElementQueryParams.Key.FAMILY,      "_oval_family" );
            field_mapping.put( DefinitionsElementQueryParams.Key.COMPONENT,   "_oval_component" );
            field_mapping.put( DefinitionsElementQueryParams.Key.SCHEMA,      "_oval_generator.schema_version" );

            //override:
            field_mapping.put( CommonQueryParams.Key.SEARCH_TERMS,            "comment" );

            return field_mapping;
        }

        private static final Map<String, String>  _FIELDS_ = _createFieldMapping();


        protected static Map<String, Handler> _createHandlerMapping()
        {
            Map<String, Handler>  mapping = CommonBuilder._createHandlerMapping();
            mapping.put( DefinitionsElementQueryParams.Key.ID,          PatternListHandler.INSTANCE );
            mapping.put( DefinitionsElementQueryParams.Key.VERSION,     IntegerHandler.INSTANCE );

            // TODO:
            mapping.put( DefinitionsElementQueryParams.Key.DEPRECATED,  BooleanHandler.INSTANCE );

            mapping.put( DefinitionsElementQueryParams.Key.TYPE,        IgnoringHandler.INSTANCE );
            mapping.put( DefinitionsElementQueryParams.Key.SCHEMA,      FilterHandler2.INSTANCE );
            mapping.put( DefinitionsElementQueryParams.Key.FAMILY,      new OvalEnumerationListHandler( Family.class ) );
            mapping.put( DefinitionsElementQueryParams.Key.COMPONENT,   new OvalEnumerationListHandler( ComponentType.class ) );

            //override:
            mapping.put( CommonQueryParams.Key.SEARCH_TERMS,            SearchTermsHandler2.INSTANCE );
            //NOTE: slower implementation
//            mapping.put( CommonQueryParams.Key.SEARCH_TERMS,            SearchTermsHandler.INSTANCE );

            return mapping;
        }

        private static final Map<String, Handler>  _HANDLERS_ = _createHandlerMapping();



        public DefinitionsElementBuilder()
        {
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
     * oval-def:definition
     */
    public static class DefinitionBuilder
    extends DefinitionsElementBuilder
    {
        public static final DefinitionBuilder  INSTANCE = new DefinitionBuilder();


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

            // override
            mapping.put( CommonQueryParams.Key.SEARCH_TERMS,            "metadata.title,metadata.description" );

            return mapping;
        }

        private static final Map<String, String>  _FIELDS_ = _createFieldMapping();


        protected static Map<String, Handler> _createHandlerMapping()
        {
            Map<String, Handler>  mapping = DefinitionsElementBuilder._createHandlerMapping();
            mapping.put( DefinitionQueryParams.Key.DEFINITION_CLASS,    new OvalEnumerationListHandler( ClassEnumeration.class ) );
            mapping.put( DefinitionQueryParams.Key.PLATFORM,            PatternListHandler.INSTANCE );
            mapping.put( DefinitionQueryParams.Key.PRODUCT,             PatternListHandler.INSTANCE );
            mapping.put( DefinitionQueryParams.Key.REF_SOURCE,          HasAnyOfHandler.INSTANCE );
            mapping.put( DefinitionQueryParams.Key.REF_ID,              PatternListHandler.INSTANCE );
            mapping.put( DefinitionQueryParams.Key.CVE,                 PatternListHandler.INSTANCE );

            //override
            mapping.put( DefinitionsElementQueryParams.Key.FAMILY,      new OvalEnumerationListHandler( FamilyEnumeration.class ) );
//          mapping.put( CommonQueryParams.Key.SEARCH_TERMS,            SearchTermHandler.INSTANCE );

            return mapping;
        }

        private static final Map<String, Handler>  _HANDLERS_ = _createHandlerMapping();



        public DefinitionBuilder()
        {
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



    /**
     * oval-sc:oval_system_characteristics
     */
    public static class OvalSystemCharacteristicsBuilder
    extends CommonBuilder
    {
        public static final OvalSystemCharacteristicsBuilder  INSTANCE = new OvalSystemCharacteristicsBuilder();


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


        protected static Map<String, Handler> _createHandlerMapping()
        {
            Map<String, Handler>  mapping = CommonBuilder._createHandlerMapping();
            mapping.put( OvalSystemCharacteristicsQueryParams.Key.HOST,         PatternListHandler.INSTANCE );
            mapping.put( OvalSystemCharacteristicsQueryParams.Key.OS,           PatternListHandler.INSTANCE );
            mapping.put( OvalSystemCharacteristicsQueryParams.Key.OS_VERSION,   FilterHandler.INSTANCE );
//            mapping.put( OvalSystemCharacteristicsQueryParams.Key.OS_VERSION,   FilterHandler2.INSTANCE );
            mapping.put( OvalSystemCharacteristicsQueryParams.Key.IP,           PatternListHandler.INSTANCE );
            mapping.put( OvalSystemCharacteristicsQueryParams.Key.MAC,          PatternListHandler.INSTANCE );

            //override
//          mapping.put( CommonQueryParams.Key.SEARCH_TERMS,            SearchTermsHandler2.INSTANCE );

            return mapping;
        }

        private static final Map<String, Handler>  _HANDLERS_ = _createHandlerMapping();



        public OvalSystemCharacteristicsBuilder()
        {
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
    //OvalSystemCharacteristicsBuilder



    /**
     * oval-res:oval_results
     */
    public static class OvalResultsBuilder
    extends CommonBuilder
    {
        public static final OvalResultsBuilder  INSTANCE = new OvalResultsBuilder();


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


        protected static Map<String, Handler> _createHandlerMapping()
        {
            Handler  definition_true_handler = new Handler()
            {
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
                            result_def.setOvalId( value_elem[i] );
                            result_def.setResult( ResultEnumeration.TRUE );
                            criteria[i] = query.criteria( field ).hasThisElement( result_def );
                        }
                        query.or( criteria );
                    } else {
                        jp.go.aist.six.oval.model.results.DefinitionType  result_def =
                                        new jp.go.aist.six.oval.model.results.DefinitionType();
                        result_def.setDefinitionId( value );
                        result_def.setResult( ResultEnumeration.TRUE );
                        query.filter( field + " elem", result_def );
                    }

                }
            };


            Map<String, Handler>  mapping = OvalSystemCharacteristicsBuilder._createHandlerMapping();
            mapping.put( OvalResultsQueryParams.Key.DEFINITION_TRUE,    definition_true_handler );
            mapping.put( OvalResultsQueryParams.Key.DEFINITION,         HasAnyOfHandler.INSTANCE );

            return mapping;
        }

        private static final Map<String, Handler>  _HANDLERS_ = _createHandlerMapping();



        public OvalResultsBuilder()
        {
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
    //OvalResultsBuilder

}
//MorphiaQueryBuilder

