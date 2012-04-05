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

package jp.go.aist.six.oval.model.windows;

import jp.go.aist.six.oval.model.common.AbstractBehaviors;
import jp.go.aist.six.oval.model.common.WindowsViewEnumeration;



/**
 * The RegistryBehaviors type defines a number of behaviors
 * that allow a more detailed definition of the registry object being specified.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class RegistryBehaviors
    extends AbstractBehaviors
{

    /**
     * The default windowsView: "64_bit".
     */
    public static final WindowsViewEnumeration  DEFAULT_WINDOWS_VIEW=
        WindowsViewEnumeration.WINDOWS_64_BIT;

    private WindowsViewEnumeration  windows_view;
    //{optional, default="64_bit"}




    /**
     * Constructor.
     */
    public RegistryBehaviors()
    {
    }



    /**
     */
    public void setWindowsView(
                    final WindowsViewEnumeration windows_view
                    )
    {
        this.windows_view = windows_view;
    }


    public WindowsViewEnumeration getWindowsView()
    {
        return windows_view;
    }


    protected final WindowsViewEnumeration _windowsView()
    {
        WindowsViewEnumeration  windows_view = getWindowsView();
        return (windows_view == null ? DEFAULT_WINDOWS_VIEW: windows_view);
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof RegistryBehaviors)) {
            return false;
        }

        return super.equals( obj );
    }

    @Override
    public String toString()
    {
        return super.toString()
                        + ", windows_view=" + getWindowsView()
                        ;
    }

}
//RegistryBehaviors
