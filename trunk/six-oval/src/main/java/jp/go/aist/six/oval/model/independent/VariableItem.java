/**
 * SIX OVAL - http://code.google.com/p/six-oval/
 * Copyright (C) 2010
 *   National Institute of Advanced Industrial Science and Technology (AIST)
 *   Registration Number: H22PRO-1124
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jp.go.aist.six.oval.model.independent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import jp.go.aist.six.oval.model.ComponentType;
import jp.go.aist.six.oval.model.Family;
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

//        _oval_platform_type = OvalPlatformType.independent;
//        _oval_component_type = OvalComponentType.variable;
        _oval_family = Family.INDEPENDENT;
        _oval_component = ComponentType.VARIABLE;
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
        return var_ref;
    }



    /**
     */
    public void setValue(
                    final Collection<? extends EntityItemAnySimpleType> values
                    )
    {
        value.clear();
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
        return value;
    }


    public Iterator<EntityItemAnySimpleType> iterateValue()
    {
        return value.iterator();
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
