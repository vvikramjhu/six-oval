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

package jp.go.aist.six.oval.core.xml;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.exolab.castor.mapping.GeneralizedFieldHandler;


public class StringXmlHandler
    extends GeneralizedFieldHandler
{

    /**
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( StringXmlHandler.class );



    public StringXmlHandler()
    {
        super();
    }



    @Override
    public Object convertUponGet(
                    final Object value
                    )
    {
        if (_LOG.isDebugEnabled()) {
            _LOG.debug( value );
        }

        return (value == null ? null : value.toString());
    }



    @Override
    public Object convertUponSet(
                    final Object value
                    )
    {
        if (_LOG.isDebugEnabled()) {
            _LOG.debug( value );
        }

        return (value == null ? null : value.toString());
    }



    @Override
    public Class<String> getFieldType()
    {
        return String.class;
    }


//    public Object newInstance(
//                    final Object parent
//                    )
//    throws IllegalStateException
//    {
//        //-- Since it's marked as a string...just return null,
//        //-- it's not needed.
//        return null;
//    }

}
// StringXmlHandler
