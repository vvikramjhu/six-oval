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

package jp.go.aist.six.oval.model.windows;

import jp.go.aist.six.oval.model.PlatformEntityType;
import jp.go.aist.six.oval.model.sc.EntityItemAnySimple;
import jp.go.aist.six.oval.model.sc.EntityItemString;
import jp.go.aist.six.oval.model.sc.Item;
import java.util.ArrayList;
import java.util.Collection;



/**
 * The wmi item outlines information to be checked through Microsoft's WMI interface.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 * @deprecated Deprecated as of version 5.7:
 *             Replaced by the wmi57 item and
 *             will be removed in a future version of the language.
 */
public class WmiItem
    extends Item
{

    private EntityItemString  _namespace;
    //{0..1}

    private EntityItemString  _wql;
    //{0..1}

    private Collection<EntityItemAnySimple>  _result = new ArrayList<EntityItemAnySimple>();
    //{0..*}



    /**
     * Constructor.
     */
    public WmiItem()
    {
    }


    /**
     * Constructor.
     */
    public WmiItem(
                    final int id
                    )
    {
        super( id );
    }



    /**
     */
    public void setNamespace(
                    final EntityItemString namespace
                    )
    {
        _namespace = namespace;
    }


    public EntityItemString getNamespace()
    {
        return _namespace;
    }



    /**
     */
    public void setWql(
                    final EntityItemString wql
                    )
    {
        _wql = wql;
    }


    public EntityItemString getWql()
    {
        return _wql;
    }



    /**
     */
    public void setResult(
                    final Collection<? extends EntityItemAnySimple> results
                    )
    {
        if (results != _result ) {
            _result.clear();
            if (results != null  &&  results.size() > 0) {
                _result.addAll( results );
            }
        }
    }


    public Collection<EntityItemAnySimple> getResult()
    {
        return _result;
    }



    //**************************************************************
    //  Item
    //**************************************************************

    @Override
    public PlatformEntityType getEntityType()
    {
        return PlatformEntityType.WINDOWS_WMI;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "wmi_item[" + super.toString()
                        + ", namespace=" + getNamespace()
                        + ", wql=" + getWql()
                        + ", result=" + getResult()
                        + "]";
    }

}
// WmiItem
