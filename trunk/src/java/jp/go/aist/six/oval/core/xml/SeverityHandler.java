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

import jp.go.aist.six.oval.model.linux.Severity;
import org.exolab.castor.mapping.GeneralizedFieldHandler;


public class SeverityHandler
    extends GeneralizedFieldHandler
{

    public SeverityHandler()
    {
        super();
    }



    @Override
    public Object convertUponGet( Object value )
    {
        if (value == null) return null;
        Severity  type = (Severity)value;
        return type.getName();
    }



    @Override
    public Object convertUponSet( Object value )
    {
        return Severity.valueOf( (String)value );
    }



    @Override
    public Class<Severity> getFieldType()
    {
        return Severity.class;
    }


    public Object newInstance( Object parent )
        throws IllegalStateException
    {
        //-- Since it's marked as a string...just return null,
        //-- it's not needed.
        return null;
    }

}
// SeverityHandler
