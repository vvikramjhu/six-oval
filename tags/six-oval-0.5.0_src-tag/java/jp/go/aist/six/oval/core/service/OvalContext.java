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

import jp.go.aist.six.oval.core.store.OvalStore;
import jp.go.aist.six.oval.core.xml.OvalXml;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.MissingResourceException;
import java.util.ResourceBundle;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalContext
{

    public static final OvalContext  INSTANCE = new OvalContext();



    /**
     * The base name of the resource bundle.
     */
    private static final String _RESOURCE_BUNDLE_ = "six-oval";



    /**
     * The Spring application context specification.
     */
    private static final String _SPRING_APP_CONTEXT_
        = "six-oval_spring-app-context.xml";



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
    private OvalStore  _store;


    /**
     * The XML processor sole instance.
     */
    private OvalXml  _xml;




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
    {
        try {
            _resourceBundle = ResourceBundle.getBundle( _RESOURCE_BUNDLE_ );
        } catch (MissingResourceException ex) {
            //negligible
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
    public OvalStore getStore()
    throws Exception
    {
        if (_store == null) {
            _store = (OvalStore)_getContext().getBean( "ovalStore" );
        }

        return _store;
    }


    /**
     */
    public OvalXml getXml()
    throws Exception
    {
        if (_xml == null) {
            _xml = (OvalXml)_getContext().getBean( "ovalXml" );
        }

        return _xml;
    }

}
// StandardOvalService

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

