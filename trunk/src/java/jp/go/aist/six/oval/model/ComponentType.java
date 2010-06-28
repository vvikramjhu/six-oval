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

package jp.go.aist.six.oval.model;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: ComponentType.java 696 2010-04-26 10:22:00Z akihito $
 */
public enum ComponentType
{

    INDEPENDENT_FAMILY( "independent.family" ),
    INDEPENDENT_TEXTFILECONTENT( "independent.textfilecontent" ),
    INDEPENDENT_UNKNOWN( "independent.unknown" ),
    LINUX_DPKGINFO( "linux.dpkginfo" ),
    LINUX_RPMINFO( "linux.rpminfo" ),
    UNIX_UNAME( "unix.uname" ),
    WINDOWS_FILE( "windows.file" ),
    WINDOWS_METABASE( "windows.metabase" ),
    WINDOWS_REGISTRY( "windows.registry" );

    /**
     * An instance factory method.
     */
    public static ComponentType fromValue(
                    final String value
                    )
    {
        for (ComponentType  e : ComponentType.values()) {
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
    ComponentType(
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
// ComponentType

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

