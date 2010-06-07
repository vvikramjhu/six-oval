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

package jp.go.aist.six.oval.core.service;

import jp.go.aist.six.oval.core.store.OvalStoreImpl;
import jp.go.aist.six.oval.core.xml.OvalXmlImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.MissingResourceException;
import java.util.ResourceBundle;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id: Oval.java 500 2010-04-02 06:28:19Z akihito $
 */
public class StandardOvalService
{

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
    private OvalStoreImpl  _store;


    /**
     * The XML processor sole instance.
     */
    private OvalXmlImpl  _xml;




    /**
     * Constructor.
     */
    private StandardOvalService()
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
    private OvalStoreImpl _getStore()
    throws Exception
    {
        if (_store == null) {
            _store = (OvalStoreImpl)_getContext().getBean( "ovalStore" );
        }

        return _store;
    }


    /**
     */
    private OvalXmlImpl _getXml()
    throws Exception
    {
        if (_xml == null) {
            _xml = (OvalXmlImpl)_getContext().getBean( "ovalXml" );
        }

        return _xml;
    }



    /**
     */
    public String getProperty(
                    final String key
                    )
    {
        return _getProperty( key );
    }


    /**
     */
    public OvalStoreImpl getStore()
    throws Exception
    {
        return _getStore();
    }


    /**
     */
    public OvalXmlImpl getXml()
    throws Exception
    {
        return _getXml();
    }

}
// StandardOvalService

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

