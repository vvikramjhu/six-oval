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

import jp.go.aist.six.oval.model.v5.common.DefinitionClassEnumeration;
import org.exolab.castor.mapping.GeneralizedFieldHandler;


public class DefinitionClassEnumerationHandler
    extends GeneralizedFieldHandler
{

    public DefinitionClassEnumerationHandler()
    {
        super();
    }


    @Override
    public Object convertUponGet(
                    final Object value
                    )
    {
        if (value == null) return null;
        DefinitionClassEnumeration  type = (DefinitionClassEnumeration)value;
        return type.value();
    }



    @Override
    public Object convertUponSet(
                    final Object value
                    )
    {
        return DefinitionClassEnumeration.fromValue( (String)value );
    }



    @Override
    public Class<?> getFieldType()
    {
        return DefinitionClassEnumeration.class;
    }


    @Override
    public Object newInstance(
                    final Object parent
                    )
        throws IllegalStateException
    {
        //-- Since it's marked as a string...just return null,
        //-- it's not needed.
        return null;
    }

}
// DefinitionClassEnumerationHandler
