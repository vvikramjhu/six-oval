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

package jp.go.aist.six.oval.model.common;





/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public enum Existence
{

    ALL_EXIST( "all_exist" ),
    ANY_EXIST( "any_exist" ),
    AT_LEAST_ONE_EXISTS( "at_least_one_exists" ),
    NONE_EXIST( "none_exist" ),
    ONLY_ONE_EXISTS( "only_one_exists" );



    /**
     * An instance factory method.
     */
    public static Existence fromValue(
                    final String value
                    )
    {
        for (Existence  e : Existence.values()) {
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
    Existence(
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
// Existence
