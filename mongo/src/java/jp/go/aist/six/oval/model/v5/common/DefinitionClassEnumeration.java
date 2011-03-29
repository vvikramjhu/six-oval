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

package jp.go.aist.six.oval.model.v5.common;





/**
 * The DefinitionClass enumeration type defines
 * the different classes of OVAL Definitions.
 * The name "class" in the OVAL Schema is renamed
 * because the name has the special meaning in Java.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public enum DefinitionClassEnumeration
{

    COMPLIANCE(     "compliance"     ),
    INVENTORY(      "inventory"      ),
    MISCELLANEOUS(  "miscellaneous"  ),
    PATCH(          "patch"          ),
    VULNERABILITY(  "vulnerability"  );


//    private static final String  _COMPLIANCE_     = "compliance";
//    private static final String  _INVENTORY_      = "inventory";
//    private static final String  _MISCELLANEOUS_  = "miscellaneous";
//    private static final String  _PATCH_          = "patch";
//    private static final String  _VULNERABILITY_  = "vulnerability";
//
//
//    public static final DefinitionClassEnumeration  COMPLIANCE     = new DefinitionClassEnumeration( _COMPLIANCE_ );
//    public static final DefinitionClassEnumeration  INVENTORY      = new DefinitionClassEnumeration( _INVENTORY_ );
//    public static final DefinitionClassEnumeration  MISCELLANEOUS  = new DefinitionClassEnumeration( _MISCELLANEOUS_ );
//    public static final DefinitionClassEnumeration  PATCH          = new DefinitionClassEnumeration( _PATCH_ );
//    public static final DefinitionClassEnumeration  VULNERABILITY  = new DefinitionClassEnumeration( _VULNERABILITY_ );



//    private static HashMap<String, DefinitionClassEnumeration> _INIT_()
//    {
//        HashMap<String, DefinitionClassEnumeration>  map = new HashMap<String, DefinitionClassEnumeration>();
//        map.put( _COMPLIANCE_,     COMPLIANCE     );
//        map.put( _INVENTORY_,      INVENTORY      );
//        map.put( _MISCELLANEOUS_,  MISCELLANEOUS  );
//        map.put( _PATCH_,          PATCH          );
//        map.put( _VULNERABILITY_,  VULNERABILITY  );
//        return map;
//    }


    /**
     */
    public static DefinitionClassEnumeration fromValue(
                    final String value
                    )
    {
        for (DefinitionClassEnumeration  e: DefinitionClassEnumeration.values()) {
            if (e._value.equals( value )) {
                return e;
            }
        }
        throw new IllegalArgumentException( value );
    }



    private final String  _value;



    /**
     * Constructor.
     */
    private DefinitionClassEnumeration(
                    final String value
                    )
    {
        _value = value;
    }



    /**
     */
    public String value()
    {
        return _value;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return _value;
    }

}
// DefinitionClassEnumeration
