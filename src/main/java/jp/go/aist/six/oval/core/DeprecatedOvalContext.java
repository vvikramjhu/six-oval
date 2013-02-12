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

package jp.go.aist.six.oval.core;

import java.util.Properties;
import jp.go.aist.six.oval.repository.OvalDatabase;
import jp.go.aist.six.util.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
@Deprecated
public class DeprecatedOvalContext
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ = LoggerFactory.getLogger( DeprecatedOvalContext.class );



//    public static final OvalContext  INSTANCE = new OvalContext();



    /**
     * Constructor.
     */
    protected DeprecatedOvalContext()
    {
//        _initResourceBundle();
    }



//    /**
//     */
//    private void _initResourceBundle()
////    throws MissingResourceException
//    {
//        try {
//            _RESOURCE_BUNDLE_ = ResourceBundle.getBundle( _RESOURCE_BUNDLE_NAME_ );
//        } catch (MissingResourceException ex) {
//            //negligible
//            _RESOURCE_BUNDLE_ = new EmptyResourceBundle();
//        }
//    }



    ///////////////////////////////////////////////////////////////////////
    //  properties
    ///////////////////////////////////////////////////////////////////////

    private static final String _DEFAULT_PROPS_NAME_ = "six-oval-default-properties";
    private static final String _PROPS_NAME_ = "six-oval-properties";

    private static Properties  _PROPERTIES_;


    /**
     */
    public static String getProperty(
                    final String key
                    )
    {
        String  value = System.getProperty( key );
        if (value != null) {
            return value;
        }

        value = _getProperties().getProperty( key );

        return value;
    }



    /**
     * @throws  OvalConfigurationException
     */
    private static Properties _getProperties()
    {
        if (_PROPERTIES_ == null) {
            _LOG_.debug( "loading default properties" );
            Properties  default_props = getBean( _DEFAULT_PROPS_NAME_, Properties.class );
            _LOG_.debug( "default properties: " + default_props.toString() );

            _LOG_.debug( "loading properties" );
            Properties  props = null;
            try {
                props = getBean( _PROPS_NAME_, Properties.class );
            } catch (Exception ex) {
                // neglisible
                props = null;
            }
            _LOG_.debug( "properties: " + String.valueOf( props ) );

            if (props == null) {
                _PROPERTIES_ = default_props;
            } else {
                _PROPERTIES_ = new Properties( default_props );
                for (String  key : props.stringPropertyNames()) {
                    _PROPERTIES_.setProperty( key, props.getProperty( key ) );
                }
            }
        }

        return _PROPERTIES_;
    }





//    /**
//     * The base name of the resource bundle.
//     */
//    private static final String _RESOURCE_BUNDLE_NAME_ = "jp/go/aist/six/oval/core/six-oval_defaults";
//
//
//    /**
//     */
//    private static ResourceBundle  _RESOURCE_BUNDLE_;
//
//
//
//    private static class EmptyResourceBundle
//    extends ListResourceBundle
//    {
//        @Override
//        protected Object[][] getContents()
//        {
//            return new Object[0][0];
//        }
//    }
//    //
//
//
//
//    /**
//     */
//    private static ResourceBundle _getResourceBundle()
//    {
//        if (_RESOURCE_BUNDLE_ == null) {
//            try {
//                _RESOURCE_BUNDLE_ = ResourceBundle.getBundle( _RESOURCE_BUNDLE_NAME_ );
//            } catch (MissingResourceException ex) {
//                //negligible
//                _RESOURCE_BUNDLE_ = new EmptyResourceBundle();
//            }
//        }
//
//        return _RESOURCE_BUNDLE_;
//    }
//
//
//
//    /**
//     */
//    public static String getProperty2(
//                    final String key
//                    )
//    {
//        String  value = System.getProperty( key );
//        if (value != null) {
//            return value;
//        }
//
//        try {
//            value = _getResourceBundle().getString( key );
//        } catch (MissingResourceException ex) {
//            //negligible
//            value = null;
//        }
//
//        return value;
//    }




    ///////////////////////////////////////////////////////////////////////
    //  repository context
    ///////////////////////////////////////////////////////////////////////

    private static final String _REPOSITORY_CONTEXT_DEF_
        = "jp/go/aist/six/oval/core/six-oval_context_repository.xml";


    private static ApplicationContext  _REPOSITORY_CONTEXT_;


    private static OvalDatabase  _DATASTORE_;




    private static ApplicationContext _getRepositoryContext()
    {
        if (_REPOSITORY_CONTEXT_ == null) {
            try {
                _REPOSITORY_CONTEXT_ = new ClassPathXmlApplicationContext( _REPOSITORY_CONTEXT_DEF_ );
                                       //throws BeansException/runtime
            } catch (BeansException ex) {
                throw new OvalConfigurationException( ex );
            }
        }

        return _REPOSITORY_CONTEXT_;
    }



    /**
     * Returns an OvalDatastore instance.
     *
     * @throws  OvalConfigurationException
     *  when it is NOT possible to create OvalDatastore instance.
     */
    public static OvalDatabase getDatabase()
    {
        if (_DATASTORE_ == null) {
            try {
                _DATASTORE_ = _getRepositoryContext().getBean( "oval-database", OvalDatabase.class );
            } catch (Exception ex) {
                throw new OvalConfigurationException( ex );
            }
        }

        return _DATASTORE_;
    }


//
//    public static OvalRepository getHttpRepositoryClient()
//    {
//        OvalRepository  repository = null;
//        try {
//            repository = _getRepositoryContext().getBean( HttpOvalRepositoryClient.class );
//        } catch (Exception ex) {
//            throw new OvalConfigurationException( ex );
//        }
//
//        return repository;
//    }



    ///////////////////////////////////////////////////////////////////////
    //  XML context
    ///////////////////////////////////////////////////////////////////////

    /**
     * The Spring application context specification: XML component.
     */
    private static final String  _XML_CONTEXT_DEF_ = "jp/go/aist/six/oval/core/six-oval_context_xml.xml";

    private static ApplicationContext  _XML_CONTEXT_;


    /**
     * The XML mapper sole instance.
     */
    private static XmlMapper  _XML_MAPPER_;



    private static ApplicationContext _getXmlContext()
    {
        if (_XML_CONTEXT_ == null) {
            try {
                _XML_CONTEXT_ = new ClassPathXmlApplicationContext( _XML_CONTEXT_DEF_ );
                                //throws BeansException/runtime
            } catch (BeansException ex) {
                throw new OvalConfigurationException( ex );
            }
        }

        return _XML_CONTEXT_;
    }



    /**
     * Returns an XmlMapper instance which is dedicated to the OVAL Domain Model.
     *
     * @throws  OvalConfigurationException
     *  when it is NOT possible to create an XmlMapper instance.
     */
    public static XmlMapper getXmlMapper()
    {
        if (_XML_MAPPER_ == null) {
            try {
                _XML_MAPPER_ = _getXmlContext().getBean( "oval-xml-mapper", XmlMapper.class );
                                         //throws BeansException/runtime
            } catch (BeansException ex) {
                throw new OvalConfigurationException( ex );
            }
        }

        return _XML_MAPPER_;
    }



//    /**
//     * Returns an XmlTransformer instance.
//     *
//     * @throws  OvalConfigurationException
//     *  when it is NOT possible to create an XmlTransformer instance.
//     */
//    public static XmlTransformer getXmlTransformer()
//    {
//        XmlTransformer  xml_transformer = null;
//        try {
//            xml_transformer = _getXmlContext().getBean( "oval-xml-transformer", XmlTransformer.class );
//                                               //throws BeansException/runtime
//        } catch (BeansException ex) {
//            throw new OvalConfigurationException( ex );
//        }
//
//        return xml_transformer;
//    }



    ///////////////////////////////////////////////////////////////////////
    //  whole context
    ///////////////////////////////////////////////////////////////////////

    /**
     * The Spring application context specification.
     */
    private static final String _WHOLE_CONTEXT_DEF_
        = "jp/go/aist/six/oval/core/six-oval_context.xml";


    private static ApplicationContext  _WHOLE_CONTEXT_;



    /**
     * @throws  OvalConfigurationException
     */
    private static ApplicationContext _getWholeContext()
    {
        if (_WHOLE_CONTEXT_ == null) {
            try {
                _WHOLE_CONTEXT_ = new ClassPathXmlApplicationContext( _WHOLE_CONTEXT_DEF_ );
                                 // throws BeansException/runtime
            } catch (BeansException ex) {
                throw new OvalConfigurationException( ex );
            }
        }

        return _WHOLE_CONTEXT_;
    }


    //NOTE: We DON'T use non-type-safe bean factory.
// public Object getBean(
//                 final String name
//                 )
// {
//     return _getSpringContext().getBean( name );
// }


    /**
     * @throws  OvalConfigurationException
     */
    public static <T> T getBean(
                    final Class<T> requiredType
                    )
    {
        T  bean = null;
        try {
            bean = _getWholeContext().getBean( requiredType );
        } catch (BeansException ex) {
            _LOG_.warn( "No such bean: type=" + requiredType );
            throw new OvalConfigurationException( ex );
        }

        return bean;
    }


    /**
     * @throws  OvalConfigurationException
     */
    public static <T> T getBean(
                    final String name,
                    final Class<T> requiredType
                    )
    {
        T  bean = null;
        try {
            bean = _getWholeContext().getBean( name, requiredType );
        } catch (BeansException ex) {
            _LOG_.warn( "No such bean: name=" + name + ", type=" + requiredType );
            throw new OvalConfigurationException( ex );
        }

        return bean;
    }

}
//

