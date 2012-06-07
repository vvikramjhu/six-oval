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

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;



/**
 * An operating system family.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public enum Family
    implements OvalEnumeration
{

//      aix,
//      apache,
//      catos,
//      esx,
//      freebsd,
//      hpux,
//      ios,
    INDEPENDENT(     ComponentType.INDEPENDENT ),
    LINUX(           ComponentType.LINUX       ),
//        macos,
//        pixos,
//        sharepoint,
//        solaris,
    UNIX(            ComponentType.UNIX        ),
    WINDOWS(         ComponentType.WINDOWS     );



    ////////////////////////////////////////////////////////////////

    /**
     * A factory method.
     */
    public static Family fromValue(
                    final String value
                    )
    {
        for (Family  e : Family.values()) {
            if (e.value.equals( value )) {
                return e;
            }
        }

        throw new IllegalArgumentException( value );
    }



    private String  value = null;
    private final Collection<ComponentType>  _components;


    /**
     * Constructor.
     */
    Family(
                    final ComponentType[] components
                    )
    {
        value = name().toLowerCase();
        _components = Collections.unmodifiableCollection( Arrays.asList( components ) );
    }



    /**
     */
    public Collection<ComponentType> getComponents()
    {
        return _components;
    }



    @Override
    public String value()
    {
        return value;
    }

}
//Family
