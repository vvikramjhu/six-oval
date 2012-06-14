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



    public static final OvalContext  INSTANCE = new OvalContext();



    /**
     * The base name of the resource bundle.
     */
    private static final String _RESOURCE_BUNDLE_NAME_ = "six-oval";



    /**
     * The Spring application context specification.
     */
    private static final String _SPRING_APP_CONTEXT_
        = "six-oval_context.xml";


    /**
     * The Spring application context specification: XML component.
     */
    private static final String _XML_CONTEXT_
        = "six-oval_context_xml.xml";


    /**
     * The Spring application context specification: XML component.
     */
    private static final String _REPOSITORY_CONTEXT_
        = "six-oval_context_repository.xml";



    /**
     * The Spring application context.
     */
    private ApplicationContext  _repositoryContext;



    /**
     */
    private ResourceBundle  _resourceBundle;



    /**
     * The Spring application context.
     */
    private ApplicationContext  _springContext;


    /**
     * The data store sole instance.
     */
    private OvalDatastore  _datastore;


    /**
     * The XML mapper sole instance.
     */
    private XmlMapper  _xmlMapper;




    /**
     * Constructor.
     */
    public OvalContext()
    {
        _initResourceBundle();
    }



    /**
     */
    private void _initResourceBundle()
//    throws MissingResourceException
    {
        try {
            _resourceBundle = ResourceBundle.getBundle( _RESOURCE_BUNDLE_NAME_ );
        } catch (MissingResourceException ex) {
            //negligible
            _resourceBundle = new EmptyResourceBundle();
        }
    }



    /**
     */
    public String getProperty(
                    final String key
                    )
    {
        String  value = System.getProperty( key );
        if (value != null) {
            return value;
        }

        if (_resourceBundle != null) {
            try {
                value = _resourceBundle.getString( key );
            } catch (MissingResourceException ex) {
                // if no such object is found.
                value = null;
            }
        }

        return value;
    }



    /**
     */
    private ApplicationContext _getSpringContext()
    {
        if (_springContext == null) {
            _springContext = new ClassPathXmlApplicationContext( _SPRING_APP_CONTEXT_ );
            //throws BeansException/runtime
        }

        return _springContext;
    }



    /**
     */
    public Object getBean(
                    final String name
                    )
    {
        return _getSpringContext().getBean( name );
    }


    public <T> T getBean(
                    final Class<T> requiredType
                    )
    {
        return _getSpringContext().getBean( requiredType );
    }


    public <T> T getBean(
                    final String name,
                    final Class<T> requiredType
                    )
    {
        return _getSpringContext().getBean( name, requiredType );
    }




    /**
     */
    private ApplicationContext _getRepositoryContext()
    {
        if (_repositoryContext == null) {
            _repositoryContext = new ClassPathXmlApplicationContext( _REPOSITORY_CONTEXT_ );
            //throws BeansException/runtime
        }

        return _repositoryContext;
    }



    /**
     * Returns an OvalDatastore instance.
     *
     * @throws  OvalConfigurationException
     *  when it is NOT possible to create OvalDatastore instance.
     */
    public OvalDatastore getDatastore()
    {
        if (_datastore == null) {
            try {
                _datastore = _getRepositoryContext().getBean( "oval-Datastore", OvalDatastore.class );
            } catch (Exception ex) {
                throw new OvalConfigurationException( ex );
            }
        }

        return _datastore;
    }

//    /**
//     */
//    public OvalRepository getRepository()
//    {
//        if (_repositoryContext == null) {
//            _repositoryContext = new ClassPathXmlApplicationContext( _REPOSITORY_CONTEXT_ );
//            //throws BeansException: Runtime
//        }
//
//        return _repositoryContext.getBean( OvalRepository.class );
//    }



    /**
     * Returns an XmlMapper instance which is dedicated to the OVAL Domain Model.
     *
     * @throws  OvalConfigurationException
     *  when it is NOT possible to create XmlMapper instance.
     */
    public XmlMapper getXmlMapper()
    {
        if (_xmlMapper == null) {
            try {
                ApplicationContext  xml_context = new ClassPathXmlApplicationContext( _XML_CONTEXT_ );
                                                  //throws BeansException/runtime
                _xmlMapper = xml_context.getBean( "oval-XmlMapper", XmlMapper.class );
            } catch (Exception ex) {
                throw new OvalConfigurationException( ex );
            }
        }

        return _xmlMapper;
    }

}
//

