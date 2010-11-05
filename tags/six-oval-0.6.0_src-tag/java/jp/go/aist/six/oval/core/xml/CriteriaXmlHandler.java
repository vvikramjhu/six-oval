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

package jp.go.aist.six.oval.core.xml;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.exolab.castor.mapping.GeneralizedFieldHandler;


public class CriteriaXmlHandler
    extends GeneralizedFieldHandler
{

    /**
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( CriteriaXmlHandler.class );



    public CriteriaXmlHandler()
    {
        super();
    }


    @Override
    public Object convertUponGet( Object value )
    {
        if (_LOG.isTraceEnabled()) {
            _LOG.trace( "value: " + value );
        }
        return (value == null) ? null : value.toString();
    }



    @Override
    public Object convertUponSet( Object value )
    {
        if (_LOG.isTraceEnabled()) {
            _LOG.trace( "value: " + value );
        }
        return (value == null) ? null : value.toString();
    }



    @Override
    public Class<String> getFieldType()
    {
        return String.class;
    }

}
// CriteriaXmlHandler
