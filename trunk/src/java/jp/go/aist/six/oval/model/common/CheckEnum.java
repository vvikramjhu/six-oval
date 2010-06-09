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
public enum CheckEnum
{

             ALL( "all" ),
    AT_LEAST_ONE( "at least one" ),
      NONE_EXIST( "none exist" ),
    NONE_SATISFY( "none satisfy" ),
        ONLY_ONE( "only one" );



    /**
     * An instance factory method.
     */
    public static CheckEnum fromValue(
                    final String value
                    )
    {
        for (CheckEnum  c : CheckEnum.values()) {
          if (c._value.equals( value )) {
              return c;
          }
      }

      throw new IllegalArgumentException( value );
    }




    private final String  _value;


    /**
     * Constructor.
     */
    CheckEnum(
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
// CheckEnum
