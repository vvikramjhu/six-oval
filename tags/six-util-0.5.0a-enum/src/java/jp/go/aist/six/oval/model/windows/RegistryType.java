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
public enum RegistryType
{

    REG_BINARY( "reg_binary" ),
    REG_DWORD( "reg_dword" ),
    REG_EXPAND_SZ( "reg_expand_sz" ),
    REG_MULTI_SZ( "reg_multi_sz" ),
    REG_NONE( "reg_none" ),
    REG_QWORD( "reg_qword" ),
    REG_SZ( "reg_sz" );



    /**
     * An instance factory method.
     */
    public static RegistryType fromValue(
                    final String value
                    )
    {
        for (RegistryType  e : RegistryType.values()) {
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
    RegistryType(
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
// RegistryType
