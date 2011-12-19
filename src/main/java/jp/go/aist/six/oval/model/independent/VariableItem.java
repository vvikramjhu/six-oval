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

package jp.go.aist.six.oval.model.independent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import jp.go.aist.six.oval.model.OvalComponentType;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.sc.EntityItemAnySimpleType;
import jp.go.aist.six.oval.model.sc.ItemType;



/**
 * This item stores information about OVAL Variables and their values.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class VariableItem
    extends ItemType
{

    private EntityItemVariableRefType  var_ref;
    //{0..1}

    private final Collection<EntityItemAnySimpleType>  value = new ArrayList<EntityItemAnySimpleType>();
    //{0..*}



    /**
     * Constructor.
     */
    public VariableItem()
    {
        this( 0 );
    }


    public VariableItem(
                    final int id
                    )
    {
        super( id );

        _oval_platform_type = OvalPlatformType.independent;
        _oval_component_type = OvalComponentType.variable;
    }



    /**
     */
    public void setVarRef(
                    final EntityItemVariableRefType var_ref
                    )
    {
        this.var_ref = var_ref;
    }


    public EntityItemVariableRefType getVarRef()
    {
        return this.var_ref;
    }



    /**
     */
    public void setValue(
                    final Collection<? extends EntityItemAnySimpleType> values
                    )
    {
        this.value.clear();
        if (values != null  &&  values.size() > 0) {
            for (EntityItemAnySimpleType  value : values) {
                addValue( value );
            }
        }
    }


    public boolean addValue(
                    final EntityItemAnySimpleType value
                    )
    {
        if (value == null) {
            throw new IllegalArgumentException( "empty value" );
        }

        return this.value.add( value );
    }


    public Collection<EntityItemAnySimpleType> getValue()
    {
        return this.value;
    }


    public Iterator<EntityItemAnySimpleType> iterateValue()
    {
        return this.value.iterator();
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof VariableItem)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "variable_item[" + super.toString()
                        + ", var_ref="       + getVarRef()
                        + ", value="        + getValue()
                        + "]";
    }

}
//VariableItem
