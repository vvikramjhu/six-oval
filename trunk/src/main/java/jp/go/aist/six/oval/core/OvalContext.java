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

package jp.go.aist.six.oval.core;

import java.util.ListResourceBundle;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import jp.go.aist.six.oval.repository.OvalDatastore;
import jp.go.aist.six.util.xml.XmlMapper;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalContext
{

    private static class EmptyResourceBundle
    extends ListResourceBundle
    {
        @Override
        protected Object[][] getContents()
        {
            return new Object[0][0];
        }
    }
    //



//    public static final OvalContext  INSTANCE = new OvalContext();



    /**
     * Constructor.
     */
    protected OvalContext()
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

    /**
     * The base name of the resource bundle.
     */
    private static final String _RESOURCE_BUNDLE_NAME_ = "jp/go/aist/six/oval/core/six-oval_defaults";

//    private static final String _RESOURCE_BUNDLE_NAME_ = "six-oval";


    /**
     */
    private static ResourceBundle  _RESOURCE_BUNDLE_;



    /**
     */
    private static ResourceBundle _getResourceBundle()
    {
        if (_RESOURCE_BUNDLE_ == null) {
            try {
                _RESOURCE_BUNDLE_ = ResourceBundle.getBundle( _RESOURCE_BUNDLE_NAME_ );
            } catch (MissingResourceException ex) {
                //negligible
                _RESOURCE_BUNDLE_ = new EmptyResourceBundle();
            }
        }

        return _RESOURCE_BUNDLE_;
    }



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

        try {
            value = _getResourceBundle().getString( key );
        } catch (MissingResourceException ex) {
            //negligible
            value = null;
        }

        return value;
    }




    ///////////////////////////////////////////////////////////////////////
    //  repository context
    ///////////////////////////////////////////////////////////////////////

    private static final String _REPOSITORY_CONTEXT_DEF_
        = "jp/go/aist/six/oval/core/six-oval_context_repository.xml";


    private static ApplicationContext  _REPOSITORY_CONTEXT_;


    private static OvalDatastore  _DATASTORE_;




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
    public static OvalDatastore getDatastore()
    {
        if (_DATASTORE_ == null) {
            try {
                _DATASTORE_ = _getRepositoryContext().getBean( "oval-datastore", OvalDatastore.class );
            } catch (Exception ex) {
                throw new OvalConfigurationException( ex );
            }
        }

        return _DATASTORE_;
    }



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
                _XML_MAPPER_ = _getXmlContext().getBean( "oval-XmlMapper", XmlMapper.class );
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
//            xml_transformer = _getXmlContext().getBean( "oval-XmlTransformer", XmlTransformer.class );
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


    public static <T> T getBean(
                    final Class<T> requiredType
                    )
    {
        return _getWholeContext().getBean( requiredType );
    }


    public static <T> T getBean(
                    final String name,
                    final Class<T> requiredType
                    )
    {
        return _getWholeContext().getBean( name, requiredType );
    }


}
//

