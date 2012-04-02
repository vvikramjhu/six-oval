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

    public static enum Component
    {
        // independent //
        environmentvariable,    //@deprecated
        environmentvariable58,
        family,
        filehash,               //@deprecated
        filehash58,
        ldap,
        sql,                    //@deprecated
        textfilecontent,        //@deprecated
        textfilecontent54,
        unknown,
        variable,
        xmlfilecontent,


        // linux //
        dpkginfo,
        inetlisteningservers,
        partition,
        rpminfo,
        rpmverify,
        selinuxboolean,
        selinuxsecuritycontext,
        slackwarepkginfo,


        // unix //
        file,
        inetd,
        network_interface,  //"interface"
        password,
        process,
        process58,
        runlevel,
        shadow,
        uname,
        xinetd,

        // windows //
        accesstoken,
        activedirectory,
        auditeventpolicy,
        auditeventpolicysubcategories,
        // file,
        fileauditedpermissions,
        fileauditedpermissions53,
        fileeffectiverights,
        fileeffectiverights53,
        group,
        group_sid,
        // network_interface, //"interface"
        lockoutpolicy,
        metabase,
        passwordpolicy,
        port,
        printereffectiverights,
        // process,
        // process58,
        registry,
        regkeyauditedpermissions,
        regkeyauditedpermissions53,
        regkeyeffectiverights,
        regkeyeffectiverights53,
        serviceeffectiverights,
        sharedresource,
        sid,
        sid_sid,
        uac,
        user,
        user_sid,
        user_sid55,
        volume,
        wmi,
        wmi57,
        wuaupdatesearcher;
    }


    public static final Component[]  INDEPENDENT_COMPONENTS = new Component[] {
        Component.environmentvariable,    //@deprecated
        Component.environmentvariable58,
        Component.family,
        Component.filehash,               //@deprecated
        Component.filehash58,
        Component.ldap,
        Component.sql,                    //@deprecated
        Component.textfilecontent,        //@deprecated
        Component.textfilecontent54,
        Component.unknown,
        Component.variable,
        Component.xmlfilecontent
    };


    public static final Component[]  LINUX_COMPONENTS = new Component[] {
        Component.dpkginfo,
        Component.inetlisteningservers,
        Component.partition,
        Component.rpminfo,
        Component.rpmverify,
        Component.selinuxboolean,
        Component.selinuxsecuritycontext,
        Component.slackwarepkginfo,
    };


    public static final Component[]  UNIX_COMPONENTS = new Component[] {
        Component.file,
        Component.inetd,
        Component.network_interface,  //"interface"
        Component.password,
        Component.process,
        Component.process58,
        Component.runlevel,
        Component.shadow,
        Component.uname,
        Component.xinetd
    };


    public static final Component[]  WINDOWS_COMPONENTS = new Component[] {
        Component.accesstoken,
        Component.activedirectory,
        Component.auditeventpolicy,
        Component.auditeventpolicysubcategories,
        Component.file,
        Component.fileauditedpermissions,
        Component.fileauditedpermissions53,
        Component.fileeffectiverights,
        Component.fileeffectiverights53,
        Component.group,
        Component.group_sid,
        Component.network_interface, //"interface"
        Component.lockoutpolicy,
        Component.metabase,
        Component.passwordpolicy,
        Component.port,
        Component.printereffectiverights,
        Component.process,
        Component.process58,
        Component.registry,
        Component.regkeyauditedpermissions,
        Component.regkeyauditedpermissions53,
        Component.regkeyeffectiverights,
        Component.regkeyeffectiverights53,
        Component.serviceeffectiverights,
        Component.sharedresource,
        Component.sid,
        Component.sid_sid,
        Component.uac,
        Component.user,
        Component.user_sid,
        Component.user_sid55,
        Component.volume,
        Component.wmi,
        Component.wmi57,
        Component.wuaupdatesearcher
    };


//    /**
//     * A specific component.
//     *
//     * @author	Akihito Nakamura, AIST
//     * @version $Id$
//     */
//    public static interface Component
//    {
//        public String  getName();
//
////        public Family getFamily();
//    }


//    /**
//     * The components defined in the "independent" namespace.
//     *
//     * @author	Akihito Nakamura, AIST
//     * @version $Id$
//     */
//    public static enum IndependentComponent
//    implements Component
//    {
//        environmentvariable,    //@deprecated
//        environmentvariable58,
//        family,
//        filehash,               //@deprecated
//        filehash58,
//        ldap,
//        sql,                    //@deprecated
//        textfilecontent,        //@deprecated
//        textfilecontent54,
//        unknown,
//        variable,
//        xmlfilecontent;
//
//        @Override
//        public String getName()
//        {
//            return this.name();
//        }
//    }
//
//
//
//    /**
//     * The components defined in the "linux" namespace.
//     *
//     * @author  Akihito Nakamura, AIST
//     * @version $Id$
//     */
//    public static enum LinuxComponent
//    implements Component
//    {
//        dpkginfo,
//        inetlisteningservers,
//        partition,
//        rpminfo,
//        rpmverify,
//        selinuxboolean,
//        selinuxsecuritycontext,
//        slackwarepkginfo;
//
//        @Override
//        public String getName()
//        {
//            return this.name();
//        }
//    }
//
//
//
//    /**
//     * The components defined in the "unix" namespace.
//     *
//     * @author  Akihito Nakamura, AIST
//     * @version $Id$
//     */
//    public static enum UnixComponent
//    implements Component
//    {
//        file,
//        inetd,
//        network_interface,  //"interface"
//        password,
//        process,
//        process58,
//        runlevel,
//        shadow,
//        uname,
//        xinetd;
//
//        @Override
//        public String getName()
//        {
//            return this.name();
//        }
//    }
//
//
//
//    /**
//     * The components defined in the "windows" namespace.
//     *
//     * @author  Akihito Nakamura, AIST
//     * @version $Id$
//     */
//    public static enum WindowsComponent
//    implements Component
//    {
//        accesstoken,
//        activedirectory,
//        auditeventpolicy,
//        auditeventpolicysubcategories,
//        file,
//        fileauditedpermissions,
//        fileauditedpermissions53,
//        fileeffectiverights,
//        fileeffectiverights53,
//        group,
//        group_sid,
//        network_interface,  //"interface"
//        lockoutpolicy,
//        metabase,
//        passwordpolicy,
//        port,
//        printereffectiverights,
//        process,
//        process58,
//        registry,
//        regkeyauditedpermissions,
//        regkeyauditedpermissions53,
//        regkeyeffectiverights,
//        regkeyeffectiverights53,
//        serviceeffectiverights,
//        sharedresource,
//        sid,
//        sid_sid,
//        uac,
//        user,
//        user_sid,
//        user_sid55,
//        volume,
//        wmi,
//        wmi57,
//        wuaupdatesearcher;
//
//        @Override
//        public String getName()
//        {
//            return this.name();
//        }
//    }



//    /**
//     * The sub-types of the OVAL variable.
//     *
//     * @author  Akihito Nakamura, AIST
//     * @version $Id$
//     */
//    public static enum VariableComponent
//    implements Component
//    {
//        constant,
//        local,
//        external;
//
//        @Override
//        public String getName()
//        {
//            return this.name();
//        }
//    }



    /**
     * An operating system family defined in as the OVAL component namespace.
     *
     * @author	Akihito Nakamura, AIST
     * @version $Id$
     */
    public static enum Family
    {
//      aix,
//      apache,
//      catos,
//      esx,
//      freebsd,
//      hpux,
//      ios,
        independent(     new Component[] {
                        Component.environmentvariable,    //@deprecated
                        Component.environmentvariable58,
                        Component.family,
                        Component.filehash,               //@deprecated
                        Component.filehash58,
                        Component.ldap,
                        Component.sql,                    //@deprecated
                        Component.textfilecontent,        //@deprecated
                        Component.textfilecontent54,
                        Component.unknown,
                        Component.variable,
                        Component.xmlfilecontent
                    }),
        linux(                 new Component[] {
                        Component.dpkginfo,
                        Component.inetlisteningservers,
                        Component.partition,
                        Component.rpminfo,
                        Component.rpmverify,
                        Component.selinuxboolean,
                        Component.selinuxsecuritycontext,
                        Component.slackwarepkginfo,
                    }),
//        independent(     IndependentComponent.values() ),
//        linux(                 LinuxComponent.values() ),
//        macos,
//        pixos,
//        sharepoint,
//        solaris,
        unix(                   new Component[] {
                        Component.file,
                        Component.inetd,
                        Component.network_interface,  //"interface"
                        Component.password,
                        Component.process,
                        Component.process58,
                        Component.runlevel,
                        Component.shadow,
                        Component.uname,
                        Component.xinetd
                    }),
        windows(             new Component[] {
                        Component.accesstoken,
                        Component.activedirectory,
                        Component.auditeventpolicy,
                        Component.auditeventpolicysubcategories,
                        Component.file,
                        Component.fileauditedpermissions,
                        Component.fileauditedpermissions53,
                        Component.fileeffectiverights,
                        Component.fileeffectiverights53,
                        Component.group,
                        Component.group_sid,
                        Component.network_interface, //"interface"
                        Component.lockoutpolicy,
                        Component.metabase,
                        Component.passwordpolicy,
                        Component.port,
                        Component.printereffectiverights,
                        Component.process,
                        Component.process58,
                        Component.registry,
                        Component.regkeyauditedpermissions,
                        Component.regkeyauditedpermissions53,
                        Component.regkeyeffectiverights,
                        Component.regkeyeffectiverights53,
                        Component.serviceeffectiverights,
                        Component.sharedresource,
                        Component.sid,
                        Component.sid_sid,
                        Component.uac,
                        Component.user,
                        Component.user_sid,
                        Component.user_sid55,
                        Component.volume,
                        Component.wmi,
                        Component.wmi57,
                        Component.wuaupdatesearcher
                    });


        private final Collection<Component>  _components;


        /**
         * Constructor.
         */
        Family(
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

    public static final Family  INDEPENDENT  = Family.independent;
    public static final Family  LINUX        = Family.linux;
    public static final Family  UNIX         = Family.unix;
    public static final Family  WINDOWS      = Family.windows;


    private static final Collection<Family>  _FAMILIES_ =
                    Collections.unmodifiableCollection( Arrays.asList( Family.values() ) );


    protected Oval()
    {
    }



    /**
     * Returns the version of the OVAL schema.
     *
     * @return
     *  the version.
     */
    public static String getSchemaVersion()
    {
        return SCHEMA_VERSION;
    }


    /**
     * Returns the families.
     *
     * @return
     *  an immutable collection of the families.
     */
    public static Collection<Family> getFamilies()
    {
        return _FAMILIES_;
    }

}
//Oval
