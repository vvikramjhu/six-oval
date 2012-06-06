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

package jp.go.aist.six.oval.model;




/**
 * The OVAL element type enumeration.
 * The types are definition, test, object, state, and variable.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public enum ElementType
    implements OvalEnumeration
{

    DEFINITION ( "definition" ),
    TEST       ( "test"       ),
    OBJECT     ( "object"     ),
    STATE      ( "state"      ),
    VARIABLE   ( "variable"   );



    ///////////////////////////////////////////////////////////////////////

    /**
     * A factory method.
     */
    public static ElementType fromValue(
                    final String value
                    )
    {
        for (ElementType  e : ElementType.values()) {
            if (e.value.equals( value )) {
                return e;
            }
        }

        throw new IllegalArgumentException( value );
    }



    private String  value;


    /**
     * Constructor.
     */
    ElementType(
                    final String type
                    )
    {
        value = type;
    }



    //*********************************************************************
    //  OvalEnumeration
    //*********************************************************************

    @Override
    public String value()
    {
        return value;
    }



    //*********************************************************************
    //  java.lang.Object
    //*********************************************************************

    @Override
    public String toString()
    {
        return value;
    }

}
//
