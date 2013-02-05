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
