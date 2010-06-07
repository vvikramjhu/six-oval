/*
 *  @ProductName@
 *  Copyright (C) @CopyrightYear@
 *    National Institute of Advanced Industrial Science and Technology (AIST)
 *    Registration Number: @AISTRegistrationNumber@
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

package jp.go.aist.six.oval.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.MissingResourceException;
import java.util.ResourceBundle;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id: Oval.java 500 2010-04-02 06:28:19Z akihito $
 */
public class Oval
{

    /**
     * The sole instance.
     */
    private static Oval  _instance = new Oval();


    /**
     * The Spring application context specification.
     */
    private static final String _RESOURCE_BUNDLE_
        = "six-oval";


    /**
     * The Spring application context specification.
     */
    private static final String _SPRING_APP_CONTEXT_
        = "/six-oval_spring-app-context.xml";



    /**
     */
    private ResourceBundle  _resourceBundle;
    private boolean  _resourceBundleAlreadyRead = false;



    /**
     * The Spring application context.
     */
    private ApplicationContext  _springContext;


    /**
     * The data store sole instance.
     */
    private OvalStore  _store;


    /**
     * The XML processor sole instance.
     */
    private OvalXml  _xml;




    /**
     * Constructor.
     */
    private Oval()
    {
    }



    /**
     */
    private String _getProperty(
                    final String key
                    )
    {
        String  value = System.getProperty( key );
        if (value != null) {
            return value;
        }

        if (!_resourceBundleAlreadyRead) {
            _resourceBundleAlreadyRead = true;
            try {
                _resourceBundle = ResourceBundle.getBundle( _RESOURCE_BUNDLE_ );

            } catch (MissingResourceException ex) {
                //negligible
            }
        }

        if (_resourceBundle != null) {
            value = _resourceBundle.getString( key );
        }

        return value;
    }



    /**
     */
    private ApplicationContext _getContext()
    throws Exception
    {
        if (_springContext == null) {
            _springContext = new ClassPathXmlApplicationContext( _SPRING_APP_CONTEXT_ );
            //throws BeansException
        }

        return _springContext;
    }


    /**
     */
    private OvalStore _getStore()
    throws Exception
    {
        if (_store == null) {
            _store = (OvalStore)_getContext().getBean( "ovalStore" );
        }

        return _store;
    }


    /**
     */
    private OvalXml _getXml()
    throws Exception
    {
        if (_xml == null) {
            _xml = (OvalXml)_getContext().getBean( "ovalXml" );
        }

        return _xml;
    }



    ////////////////////////////////////////////////////////////////
    //  static utility methods
    ////////////////////////////////////////////////////////////////

    /**
     */
    public static String getProperty(
                    final String key
                    )
    {
        return _instance._getProperty( key );
    }


    /**
     */
    public static OvalStore getStore()
    throws Exception
    {
        return _instance._getStore();
    }


    /**
     */
    public static OvalXml getXml()
    throws Exception
    {
        return _instance._getXml();
    }

}
// Oval

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

