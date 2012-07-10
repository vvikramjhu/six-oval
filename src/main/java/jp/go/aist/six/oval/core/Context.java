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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 * Application Context using Spring Framework.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class Context
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ = LoggerFactory.getLogger( Context.class );



    private String  _configLocation;
    private ApplicationContext  _context;

    private List<String>  _propertyBeans;
    private Properties  _properties;



    /**
     * Constructor.
     */
    protected Context()
    {
    }


    protected Context(
                    final String config_location,
                    final String[] property_beans
                    )
    {
        _configLocation = config_location;

        if (property_beans == null) {
            _propertyBeans = Collections.emptyList();
        } else {
            _propertyBeans = Arrays.asList( property_beans );
        }
    }



    /**
     * @throws  ContextConfigurationException
     */
    protected ApplicationContext _getContext()
    {
        try {
            _context = new ClassPathXmlApplicationContext( _configLocation );
                       //throws BeansException/runtime
        } catch (BeansException ex) {
            throw new OvalConfigurationException( ex );
        }

        return _context;
    }




    ///////////////////////////////////////////////////////////////////////
    //  properties
    ///////////////////////////////////////////////////////////////////////

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

        value = _getProperties().getProperty( key );

        return value;
    }



    /**
     */
    private Properties _getProperties()
    {
        if (_properties == null) {
            _properties = new Properties();
            for (String  bean : _propertyBeans) {
                Properties  props = null;
                try {
                    props = getBean( bean, Properties.class );
                } catch (Exception ex) {
                    _LOG_.warn( "load properties", ex );
                }

                if (props != null) {
                    for (String  key : props.stringPropertyNames()) {
                        _properties.setProperty( key, props.getProperty( key ) );
                    }
                }
            }
        }

        return _properties;
    }



    ///////////////////////////////////////////////////////////////////////
    //  BeanFactory
    ///////////////////////////////////////////////////////////////////////

    //NOTE: We DON'T use non-type-safe bean factory.
// public Object getBean(
//                 final String name
//                 )
// {
//     return _getSpringContext().getBean( name );
// }


    /**
     * @throws  ContextConfigurationException
     */
    public <T> T getBean(
                    final Class<T> requiredType
                    )
    {
        T  bean = null;
        try {
            bean = _getContext().getBean( requiredType );
        } catch (BeansException ex) {
            _LOG_.warn( "No such bean: type=" + requiredType );
            throw new OvalConfigurationException( ex );
        }

        return bean;
    }


    /**
     * @throws  ContextConfigurationException
     */
    public <T> T getBean(
                    final String name,
                    final Class<T> requiredType
                    )
    {
        T  bean = null;
        try {
            bean = _getContext().getBean( name, requiredType );
        } catch (BeansException ex) {
            _LOG_.warn( "No such bean: name=" + name + ", type=" + requiredType );
            throw new OvalConfigurationException( ex );
        }

        return bean;
    }



    /**
     * Tests if this context contains a bean with the given name.
     *
     * @return
     *  true if a bean with the given name is defined, false otherwise.
     * @throws  ContextConfigurationException
     */
    public boolean containsBean(
                    final String name
                    )
    {
        return _getContext().containsBean( name );
    }

}
//

