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

package jp.go.aist.six.oval.core.service;

import java.util.MissingResourceException;
import java.util.ResourceBundle;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalConfig
{

    /**
     * The base name of the resource bundle.
     */
    private static final String _RESOURCE_BUNDLE_ = "six-oval";



    /**
     * Sole instance.
     */
    private static final OvalConfig  _INSTANCE_ = new OvalConfig();



    /**
     */
    public static String getProperty(
                    final String key
                    )
    {
        return _INSTANCE_._getProperty( key );
    }



    /**
     */
    private ResourceBundle  _resourceBundle;
    private boolean  _resourceBundleAlreadyRead = false;



    /**
     * Constructor.
     */
    private OvalConfig()
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

}
// OvalConfig

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

