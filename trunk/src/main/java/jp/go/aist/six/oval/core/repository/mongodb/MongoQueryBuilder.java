/*
 *  @product.title@
 *  Copyright (C) @product.copyright-year@
 *    @product.vendor@
 *    Registration Number: @product.registration-number@
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

package jp.go.aist.six.oval.core.repository.mongodb;

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
import jp.go.aist.six.oval.repository.CommonQueryParams;
import jp.go.aist.six.oval.repository.DefinitionQueryParams;
import jp.go.aist.six.oval.repository.DefinitionsElementQueryParams;
import jp.go.aist.six.oval.repository.OvalRepositoryException;
import jp.go.aist.six.oval.repository.OvalResultsQueryParams;
import jp.go.aist.six.oval.repository.OvalSystemCharacteristicsQueryParams;
import jp.go.aist.six.oval.repository.QueryParams;
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
        } else if (DefinitionsElement.class.isAssignableFrom( type )) {
            return (new DefinitionsElementBuilder( params ));
        } else if (OvalSystemCharacteristics.class.isAssignableFrom( type )) {
            return (new OvalSystemCharacteristicsBuilder( params ));
        } else if (OvalResults.class.isAssignableFrom( type )) {
            return (new OvalResultsBuilder( params ));
        }

        return (new CommonBuilder( params ));
    }



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

    @Override
    public <T>
    Query<T> build(
                    final Query<T> query
                    )
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

        private static final char[]       _QUERY_OPERATORS_ = new   char[] { '!',  '<', '>' };
        private static final String[]  _INTERNAL_OPERATORS_ = new String[] { "!=", "<", ">" };


        public FilterHandler()
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
    // Filter

    protected static class FilterHandler2
    extends Handler
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
    // Filter2



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
    extends Handler
    {
        public static final SearchTermsHandler  INSTANCE = new SearchTermsHandler();


        public SearchTermsHandler()
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
    extends Handler
    {
        public static final SearchTermsHandler2  INSTANCE = new SearchTermsHandler2();


        public SearchTermsHandler2()
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
    //PatternList



    protected static class OvalEnumerationListHandler
    extends Handler
    {

        private final Class<? extends OvalEnumeration>  _type;


        public OvalEnumerationListHandler(
                        final Class<? extends OvalEnumeration> type
                        )
        {
            _type = type;
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
    //OvalEnumerationList



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

        // Query key --> database field
        private static final Map<String, String>  _FIELDS_ = Collections.emptyMap();
        // CommonQueryParams contains key NOT mapped to the fields.


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


        // Query key --> Handler
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
     * oval-def:{definition,test,object,state,variable}
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
            mapping.put( DefinitionsElementQueryParams.Key.TYPE,        null );
            mapping.put( DefinitionsElementQueryParams.Key.FAMILY,      "_oval_family" );
            mapping.put( DefinitionsElementQueryParams.Key.COMPONENT,   "_oval_component" );
            mapping.put( DefinitionsElementQueryParams.Key.SCHEMA,      "_oval_generator.schema_version" );

            //common
            mapping.put( CommonQueryParams.Key.SEARCH_TERMS,            "comment" );

            return mapping;
        }


        private static final Map<String, String>  _FIELDS_ = _createFieldMapping();



        protected static Map<String, Handler> _createHandlers()
        {
            Map<String, Handler>  mapping = CommonBuilder._createHandlers();
            mapping.put( CommonQueryParams.Key.SEARCH_TERMS,            SearchTermsHandler2.INSTANCE );
//            mapping.put( CommonQueryParams.Key.SEARCH_TERMS,            SearchTermsHandler.INSTANCE ); //slower

            //definitions element
            mapping.put( DefinitionsElementQueryParams.Key.ID,          PatternListHandler.INSTANCE );
            mapping.put( DefinitionsElementQueryParams.Key.VERSION,     IntegerHandler.INSTANCE );
            mapping.put( DefinitionsElementQueryParams.Key.TYPE,        IgnoringHandler.INSTANCE );
            mapping.put( DefinitionsElementQueryParams.Key.SCHEMA,      FilterHandler2.INSTANCE );
            mapping.put( DefinitionsElementQueryParams.Key.FAMILY,      new OvalEnumerationListHandler( Family.class ) );
            mapping.put( DefinitionsElementQueryParams.Key.COMPONENT,   new OvalEnumerationListHandler( ComponentType.class ) );

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
    //DefinitionsElement



    /**
     * oval-def:definition
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

            // override common
            mapping.put( CommonQueryParams.Key.SEARCH_TERMS,            "metadata.title,metadata.description" );

            return mapping;
        }


        private static final Map<String, String>  _FIELDS_ = _createFieldMapping();



        protected static Map<String, Handler> _createHandlers()
        {
            Map<String, Handler>  mapping = DefinitionsElementBuilder._createHandlers();
            //common
//            mapping.put( CommonQueryParams.Key.SEARCH_TERMS,            SearchTermHandler.INSTANCE );

            //definition
            mapping.put( DefinitionQueryParams.Key.DEFINITION_CLASS,    new OvalEnumerationListHandler( ClassEnumeration.class ) );
            mapping.put( DefinitionQueryParams.Key.PLATFORM,            PatternListHandler.INSTANCE );
            mapping.put( DefinitionQueryParams.Key.PRODUCT,             PatternListHandler.INSTANCE );
            mapping.put( DefinitionQueryParams.Key.REF_SOURCE,          HasAnyOfHandler.INSTANCE );
            mapping.put( DefinitionQueryParams.Key.REF_ID,              PatternListHandler.INSTANCE );
            mapping.put( DefinitionQueryParams.Key.CVE,                 PatternListHandler.INSTANCE );

            //overrides:
            mapping.put( DefinitionsElementQueryParams.Key.FAMILY,      new OvalEnumerationListHandler( FamilyEnumeration.class ) );

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



    /**
     * oval-sc:oval_system_characteristics
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



        protected static Map<String, Handler> _createHandlers()
        {
            Map<String, Handler>  mapping = CommonBuilder._createHandlers();
            //common
//            mapping.put( CommonQueryParams.Key.SEARCH_TERMS,            SearchTermsHandler2.INSTANCE );
            //sc
            mapping.put( OvalSystemCharacteristicsQueryParams.Key.HOST,         PatternListHandler.INSTANCE );
            mapping.put( OvalSystemCharacteristicsQueryParams.Key.OS,           PatternListHandler.INSTANCE );
            mapping.put( OvalSystemCharacteristicsQueryParams.Key.OS_VERSION,   FilterHandler.INSTANCE );
//            mapping.put( OvalSystemCharacteristicsQueryParams.Key.OS_VERSION,   FilterHandler2.INSTANCE );
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
            Handler  definition_true_handler = new Handler()
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


            Map<String, Handler>  mapping = OvalSystemCharacteristicsBuilder._createHandlers();
            mapping.put( OvalResultsQueryParams.Key.DEFINITION_TRUE,    definition_true_handler );
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

