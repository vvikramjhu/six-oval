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

package jp.go.aist.six.oval.interpreter;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
import jp.go.aist.six.util.xml.XmlMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalInterpreterContext
{

    public static final OvalInterpreterContext  INSTANCE = new OvalInterpreterContext();



    /**
     * The base name of the resource bundle.
     */
    private static final String _RESOURCE_BUNDLE_ = "six-oval";



    /**
     * The Spring application context specification.
     */
    private static final String _SPRING_APP_CONTEXT_
        = "six-oval_spring-context.xml";



    /**
     */
    private ResourceBundle  _resourceBundle;



    /**
     * The Spring application context.
     */
    private ApplicationContext  _springContext;


//    /**
//     * The data store sole instance.
//     */
//    private DataStore  _store;


    /**
     * The XML mapper sole instance.
     */
    private XmlMapper  _xml;




    /**
     * Constructor.
     */
    public OvalInterpreterContext()
    {
        _initResourceBundle();
    }



    /**
     */
    private void _initResourceBundle()
//    throws MissingResourceException
    {
//        try {
            _resourceBundle = ResourceBundle.getBundle( _RESOURCE_BUNDLE_ );
//        } catch (MissingResourceException ex) {
//            //negligible
//        }
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
    private ApplicationContext _getContext()
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
        return _getContext().getBean( name );
    }


    public <T> T getBean(
                    final String name,
                    final Class<T> requiredType
                    )
    {
        return _getContext().getBean( name, requiredType );
    }

}
// OvalInterpreterContext

