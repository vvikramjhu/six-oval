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





/**
 * A OVAL component type.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public enum Component
    implements OvalEnumeration
{
    // independent, linux, unix, windows

    ACCESSTOKEN,                    // windows
    ACTIVEDIRECTORY,                // windows
    AUDITEVENTPOLICY,               // windows
    AUDITEVENTPOLICYSUBCATEGORIES,  // windows

    DPKGINFO,                       // linux
    ENVIRONMENTVARIABLE,            // independent @deprecated
    ENVIRONMENTVARIABLE58,          // independent

    FAMILY,                         // independent
    FILE,                           // unix, windows
    FILEAUDITEDPERMISSIONS,         // windows
    FILEAUDITEDPERMISSIONS53,       // windows
    FILEEFFECTIVERIGHTS,            // windows
    FILEEFFECTIVERIGHTS53,          // windows
    FILEHASH,                       // independent @deprecated
    FILEHASH58,                     // independent

    GROUP,                          // windows
    GROUP_SID,                      // windows

    INETD,                          // unix
    INETLISTENINGSERVERS,           // linux
    INTERFACE,                      // unix, windows

    LDAP,                           // independent
    LOCKOUTPOLICY,                  // windows

    METABASE,                       // windows

    PARTITION,                      // linux
    PASSWORD,                       // unix
    PASSWORDPOLICY,                 // windows
    PROCESS,                        // unix, windows
    PROCESS58,                      // unix, windows
    PORT,                           // windows
    PRINTEREFFECTIVERIGHTS,         // windows

    REGISTRY,                       // windows
    REGKEYAUDITEDPERMISSIONS,       // windows
    REGKEYAUDITEDPERMISSIONS53,     // windows
    REGKEYEFFECTIVERIGHTS,          // windows
    REGKEYEFFECTIVERIGHTS53,        // windows
    RPMINFO,                        // linux
    RPMVERIFY,                      // linux
    RUNLEVEL,                       // unix

    SELINUXBOOLEAN,                 // linux
    SELINUXSECURITYCONTEXT,         // linux
    SERVICEEFFECTIVERIGHTS,         // windows
    SHADOW,                         // unix
    SHAREDRESOURCE,                 // windows
    SID,                            // windows
    SID_SID,                        // windows
    SLACKWAREPKGINFO,               // linux
    SQL,                            // independent @deprecated

    TEXTFILECONTENT,                // independent @deprecated
    TEXTFILECONTENT54,              // independent

    UAC,                            // windows
    UNAME,                          // unix
    UNKNOWN,                        // independent
    USER,                           // windows
    USER_SID,                       // windows
    USER_SID55,                     // windows

    VARIABLE,                       // independent
    VOLUME,                         // windows

    WMI,                            // windows
    WMI57,                          // windows
    WUAUPDATESEARCHER,              // windows

    XINETD,                         // unix
    XMLFILECONTENT;                 // independent



    ////////////////////////////////////////////////////////////////

    /**
     * A factory method.
     */
    public static Component fromValue(
                    final String value
                    )
    {
        return valueOf( value.toUpperCase() );
//        for (Component  e : Component.values()) {
//            if (e.value.equals( value )) {
//                return e;
//            }
//        }
//
//        throw new IllegalArgumentException( value );
    }



    private String  value = null;


    /**
     * Constructor.
     */
    Component()
    {
        value = name().toLowerCase();
    }


    Component(
                    final String value
                    )
    {
        this.value = value;
    }



    @Override
    public String value()
    {
        return value;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return value;
    }



    ////////////////////////////////////////////////////////////////
    // grouped by the OS family, i.e. OVAL namespace
    ////////////////////////////////////////////////////////////////

    public static final Component[]  INDEPENDENT = new Component[] {
        Component.ENVIRONMENTVARIABLE,
        Component.ENVIRONMENTVARIABLE58,
        Component.FAMILY,
        Component.FILEHASH,
        Component.FILEHASH58,
        Component.LDAP,
        Component.SQL,
        Component.TEXTFILECONTENT,
        Component.TEXTFILECONTENT54,
        Component.UNKNOWN,
        Component.VARIABLE,
        Component.XMLFILECONTENT
    };


    public static final Component[]  LINUX = new Component[] {
        Component.DPKGINFO,
        Component.INETLISTENINGSERVERS,
        Component.PARTITION,
        Component.RPMINFO,
        Component.RPMVERIFY,
        Component.SELINUXBOOLEAN,
        Component.SELINUXSECURITYCONTEXT,
        Component.SLACKWAREPKGINFO,
    };


    public static final Component[]  UNIX = new Component[] {
        Component.FILE,
        Component.INETD,
        Component.INTERFACE,
        Component.PASSWORD,
        Component.PROCESS,
        Component.PROCESS58,
        Component.RUNLEVEL,
        Component.SHADOW,
        Component.UNAME,
        Component.XINETD
    };


    public static final Component[]  WINDOWS = new Component[] {
        Component.ACCESSTOKEN,
        Component.ACTIVEDIRECTORY,
        Component.AUDITEVENTPOLICY,
        Component.AUDITEVENTPOLICYSUBCATEGORIES,
        Component.FILE,
        Component.FILEAUDITEDPERMISSIONS,
        Component.FILEAUDITEDPERMISSIONS53,
        Component.FILEEFFECTIVERIGHTS,
        Component.FILEEFFECTIVERIGHTS53,
        Component.GROUP,
        Component.GROUP_SID,
        Component.INTERFACE,
        Component.LOCKOUTPOLICY,
        Component.METABASE,
        Component.PASSWORDPOLICY,
        Component.PORT,
        Component.PRINTEREFFECTIVERIGHTS,
        Component.PROCESS,
        Component.PROCESS58,
        Component.REGISTRY,
        Component.REGKEYAUDITEDPERMISSIONS,
        Component.REGKEYAUDITEDPERMISSIONS53,
        Component.REGKEYEFFECTIVERIGHTS,
        Component.REGKEYEFFECTIVERIGHTS53,
        Component.SERVICEEFFECTIVERIGHTS,
        Component.SHAREDRESOURCE,
        Component.SID,
        Component.SID_SID,
        Component.UAC,
        Component.USER,
        Component.USER_SID,
        Component.USER_SID55,
        Component.VOLUME,
        Component.WMI,
        Component.WMI57,
        Component.WUAUPDATESEARCHER
    };

}
//
