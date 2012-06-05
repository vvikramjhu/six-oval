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

package jp.go.aist.six.oval.model.definitions;

import java.util.Collection;
import java.util.Collections;
import jp.go.aist.six.oval.model.ElementRef;
import jp.go.aist.six.oval.model.OvalEnumeration;
import jp.go.aist.six.oval.model.common.DatatypeEnumeration;
import com.google.code.morphia.annotations.Entity;



/**
 * The OVAL Variable describes different sources
 * for obtaining a value(s) for the variable.
 * There are currently three types of variables;
 * local, external, and constant.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
@Entity( "oval.def.variable" )
public class VariableType
    extends DefinitionsComponent
{

    public enum Type
    implements OvalEnumeration
    {
        CONSTANT,
        LOCAL,
        EXTERNAL;


        /**
         * A factory method.
         */
        public static Type fromValue(
                        final String value
                        )
        {
//            return valueOf( value.toUpperCase() );

            for (Type  e : Type.values()) {
                if (e.value.equals( value )) {
                    return e;
                }
            }

            throw new IllegalArgumentException( value );
        }



        private String  value = null;



        /**
         * Constructor.
         */
        Type()
        {
            value = name().toLowerCase();
        }



        @Override
        public String value()
        {
            return value;
        }



        @Override
        public String toString()
        {
            return value;
        }
    }
    //Type



    ////////////////////////////////////////////////////////////////

    private DatatypeEnumeration  datatype;
    //{required}



    /**
     * Constructor.
     */
    public VariableType()
    {
        this( null, 0 );
    }


    public VariableType(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public VariableType(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        this( id, version, comment, null );
    }


    public VariableType(
                    final String id,
                    final int version,
                    final String comment,
                    final DatatypeEnumeration datatype
                    )
    {
        super( id, version, comment );
        setDatatype( datatype );

//        _oval_entity_type = OvalEntityType.variable;
//        _definitions_element_type = DefinitionsElement.Type.variable;
    }



    /**
     */
    public void setDatatype(
                    final DatatypeEnumeration datatype
                    )
    {
        this.datatype = datatype;
    }


    public DatatypeEnumeration getDatatype()
    {
        return datatype;
    }



    //*********************************************************************
    //  SIX extension
    //*********************************************************************

    @Override
    public final DefinitionsElement.Type ovalGetElementType()
    {
        return DefinitionsElement.Type.VARIABLE;
    }


    @Override
    public Collection<ElementRef> ovalGetElementRef()
    {
        return Collections.emptyList();
//        Collection<ElementRef>  ref_list = new ArrayList<ElementRef>();
//        return ref_list;
    }



    public VariableType.Type ovalGetVariableType()
    {
        throw new UnsupportedOperationException(
                        "concrete VariableType must return its type.");

//        return Type.LOCAL;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return super.toString()
                        + ", datatype=" + getDatatype();
    }

}
// VariableType
