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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import jp.go.aist.six.oval.model.Component;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.sc.EntityItemAnySimpleType;
import jp.go.aist.six.oval.model.sc.EntityItemStringType;
import jp.go.aist.six.oval.model.sc.ItemType;



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
@Deprecated
public class WmiItem
    extends ItemType
{

    private EntityItemStringType  namespace;
    //{0..1}

    private EntityItemStringType  wql;
    //{0..1}

    private final Collection<EntityItemAnySimpleType>  result =
        new ArrayList<EntityItemAnySimpleType>();
    //{0..*}



    /**
     * Constructor.
     */
    public WmiItem()
    {
        this( 0 );
    }


    public WmiItem(
                    final int id
                    )
    {
        super( id );

//        _oval_platform_type = OvalPlatformType.windows;
//        _oval_component_type = OvalComponentType.wmi;
        _oval_family = Family.WINDOWS;
        _oval_component = Component.WMI;
    }



    /**
     */
    public void setNamespace(
                    final EntityItemStringType namespace
                    )
    {
        this.namespace = namespace;
    }


    public EntityItemStringType getNamespace()
    {
        return namespace;
    }



    /**
     */
    public void setWql(
                    final EntityItemStringType wql
                    )
    {
        this.wql = wql;
    }


    public EntityItemStringType getWql()
    {
        return wql;
    }



    /**
     */
    public void setResult(
                    final Collection<? extends EntityItemAnySimpleType> results
                    )
    {
        if (results != result ) {
            result.clear();
            if (results != null  &&  results.size() > 0) {
                result.addAll( results );
            }
        }
    }


    public Collection<EntityItemAnySimpleType> getResult()
    {
        return result;
    }


    public Iterator<EntityItemAnySimpleType> iterateResult()
    {
        return result.iterator();
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "wmi_item[" + super.toString()
             + ", namespace="   + getNamespace()
             + ", wql="         + getWql()
             + ", result="      + getResult()
             + "]";
    }

}
// WmiItem
