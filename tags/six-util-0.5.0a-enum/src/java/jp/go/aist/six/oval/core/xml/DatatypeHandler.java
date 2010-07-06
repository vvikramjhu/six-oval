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

import jp.go.aist.six.oval.model.common.Datatype;
import org.exolab.castor.mapping.GeneralizedFieldHandler;


public class DatatypeHandler
    extends GeneralizedFieldHandler
{

    public DatatypeHandler()
    {
        super();
    }


    @Override
    public Object convertUponGet( Object value )
    {
        if (value == null) return null;
        Datatype  e = (Datatype)value;
        return e.value();
    }



    @Override
    public Object convertUponSet( Object value )
    {
        return Datatype.fromValue( (String)value );
    }



    @Override
    public Class<Datatype> getFieldType()
    {
        return Datatype.class;
    }


    public Object newInstance( Object parent )
        throws IllegalStateException
    {
        //-- Since it's marked as a string...just return null,
        //-- it's not needed.
        return null;
    }

}
// DatatypeHandler
