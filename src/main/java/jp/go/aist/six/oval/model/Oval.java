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
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class Oval
{

    /**
     * A specific component.
     *
     * @author	Akihito Nakamura, AIST
     * @version $Id$
     */
    public static interface Component
    {
        public String  getName();

//        public Family getFamily();
    }


    public static enum LinuxComponent
    implements Component
    {
        dpkginfo,
        rpminfo;

        @Override
        public String getName()
        {
            return this.name();
        }
    }


    public static enum WindowsComponent
    implements Component
    {
        file,
        registry;

        @Override
        public String getName()
        {
            return this.name();
        }
    }



    /**
     * An OVAL Component Namespace.
     *
     * @author	Akihito Nakamura, AIST
     * @version $Id$
     */
    public static enum Namespace
    {
//      aix,
//      apache,
//      catos,
//      esx,
//      freebsd,
//      hpux,
//      ios,
//      independent,
        linux(     LinuxComponent.values() ),
//        macos,
//        pixos,
//        sharepoint,
//        solaris,
//        unix,
        windows( WindowsComponent.values() );


        private final Collection<Component>  _components;


        Namespace(
                        final Component[] components
                        )
        {
            _components = Collections.unmodifiableCollection( Arrays.asList( components ) );
        }


        public String  getName()
        {
            return name();
        }


        public Collection<Component> getComponents()
        {
            return _components;
        }
    }



    public static final String  SCHEMA_VERSION = "5.10";

    public static final Namespace  LINUX   = Namespace.linux;
    public static final Namespace  WINDOWS = Namespace.windows;


    private static final Collection<Namespace>  _NAMESPACES_ =
                    Collections.unmodifiableCollection( Arrays.asList( Namespace.values() ) );


    protected Oval()
    {
    }


    public static String getSchemaVersion()
    {
        return SCHEMA_VERSION;
    }


    public static Collection<Namespace> getNamespaces()
    {
        return _NAMESPACES_;
    }

}
//OvalSpec

