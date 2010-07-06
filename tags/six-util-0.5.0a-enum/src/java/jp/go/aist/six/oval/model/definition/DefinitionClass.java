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

package jp.go.aist.six.oval.model.definition;



/**
 * The DefinitionClass defines the different classes of definitions.
 * Each class defines a certain intent regarding how an OVAL Definition
 * is written and what that definition is describing.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public enum DefinitionClass
{

    /**
     * A compliance definition describes the state of a machine
     * as it complies with a specific policy.
     */
    COMPLIANCE( "compliance" ),

    /**
     * An inventory definition describes whether a specific piece of software
     * is installed on the system.
     */
    INVENTORY( "inventory" ),

    /**
     * The 'miscellaneous' class is used to identify definitions
     * that do not fall into any of the other defined classes.
     */
    MISCELLANEOUS( "miscellaneous" ),

    /**
     * A patch definition details the machine state of
     * whether a patch executable should be installed.
     */
    PATCH( "patch" ),

    /**
     * A vulnerability definition describes the conditions
     * under which a machine is vulnerable.
     */
    VULNERABILITY( "vulnerability" );



    /**
     * An instance factory method.
     */
    public static DefinitionClass fromValue(
                    final String value
                    )
    {
        for (DefinitionClass  e : DefinitionClass.values()) {
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
    DefinitionClass(
                    final String value
                    )
    {
        this._value = value;
    }



    /**
     */
    public String value()
    {
        return this._value;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return this._value;
    }

}
// DefinitionClass
