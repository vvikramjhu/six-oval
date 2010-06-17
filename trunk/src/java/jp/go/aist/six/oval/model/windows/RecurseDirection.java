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

package jp.go.aist.six.oval.model.windows;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public enum RecurseDirection
{

    NONE( "none" ),
    UP( "up" ),
    DOWN( "down" );



    /**
     * An instance factory method.
     */
    public static RecurseDirection fromValue(
                    final String value
                    )
    {
        for (RecurseDirection  e : RecurseDirection.values()) {
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
    RecurseDirection(
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
// RecurseDirection
