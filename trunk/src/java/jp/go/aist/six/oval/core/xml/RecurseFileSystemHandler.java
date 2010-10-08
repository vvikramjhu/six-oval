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

import jp.go.aist.six.oval.model.windows.RecurseFileSystem;
import org.exolab.castor.mapping.GeneralizedFieldHandler;



public class RecurseFileSystemHandler
    extends GeneralizedFieldHandler
{

    public RecurseFileSystemHandler()
    {
        super();
    }


    @Override
    public Object convertUponGet( Object value )
    {
        if (value == null) return null;
        RecurseFileSystem  type = (RecurseFileSystem)value;
        return type.getName();
    }



    @Override
    public Object convertUponSet( Object value )
    {
        return RecurseFileSystem.valueOf( (String)value );
    }



    @Override
    public Class<RecurseFileSystem> getFieldType()
    {
        return RecurseFileSystem.class;
    }


    public Object newInstance( Object parent )
        throws IllegalStateException
    {
        //-- Since it's marked as a string...just return null,
        //-- it's not needed.
        return null;
    }

}
// RecurseFileSystemHandler
