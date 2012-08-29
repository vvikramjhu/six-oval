/*
 *  @product.title@
 *  Copyright (C) @product.copyright-year@
 *    @product.vendor@
 *    Registration Number: @product.registration-number@
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.go.aist.six.oval.model;



/**
 * A OVAL component type.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public enum ComponentType
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
    SQL57,                          // independent

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
    public static ComponentType fromValue(
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
    ComponentType()
    {
        value = name().toLowerCase();
    }


    ComponentType(
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

    public static final ComponentType[]  INDEPENDENT = new ComponentType[] {
        ComponentType.ENVIRONMENTVARIABLE,
        ComponentType.ENVIRONMENTVARIABLE58,
        ComponentType.FAMILY,
        ComponentType.FILEHASH,
        ComponentType.FILEHASH58,
        ComponentType.LDAP,
        ComponentType.SQL,
        ComponentType.SQL57,
        ComponentType.TEXTFILECONTENT,
        ComponentType.TEXTFILECONTENT54,
        ComponentType.UNKNOWN,
        ComponentType.VARIABLE,
        ComponentType.XMLFILECONTENT
    };


    public static final ComponentType[]  LINUX = new ComponentType[] {
        ComponentType.DPKGINFO,
        ComponentType.INETLISTENINGSERVERS,
        ComponentType.PARTITION,
        ComponentType.RPMINFO,
        ComponentType.RPMVERIFY,
        ComponentType.SELINUXBOOLEAN,
        ComponentType.SELINUXSECURITYCONTEXT,
        ComponentType.SLACKWAREPKGINFO,
    };


    public static final ComponentType[]  UNIX = new ComponentType[] {
        ComponentType.FILE,
        ComponentType.INETD,
        ComponentType.INTERFACE,
        ComponentType.PASSWORD,
        ComponentType.PROCESS,
        ComponentType.PROCESS58,
        ComponentType.RUNLEVEL,
        ComponentType.SHADOW,
        ComponentType.UNAME,
        ComponentType.XINETD
    };


    public static final ComponentType[]  WINDOWS = new ComponentType[] {
        ComponentType.ACCESSTOKEN,
        ComponentType.ACTIVEDIRECTORY,
        ComponentType.AUDITEVENTPOLICY,
        ComponentType.AUDITEVENTPOLICYSUBCATEGORIES,
        ComponentType.FILE,
        ComponentType.FILEAUDITEDPERMISSIONS,
        ComponentType.FILEAUDITEDPERMISSIONS53,
        ComponentType.FILEEFFECTIVERIGHTS,
        ComponentType.FILEEFFECTIVERIGHTS53,
        ComponentType.GROUP,
        ComponentType.GROUP_SID,
        ComponentType.INTERFACE,
        ComponentType.LOCKOUTPOLICY,
        ComponentType.METABASE,
        ComponentType.PASSWORDPOLICY,
        ComponentType.PORT,
        ComponentType.PRINTEREFFECTIVERIGHTS,
        ComponentType.PROCESS,
        ComponentType.PROCESS58,
        ComponentType.REGISTRY,
        ComponentType.REGKEYAUDITEDPERMISSIONS,
        ComponentType.REGKEYAUDITEDPERMISSIONS53,
        ComponentType.REGKEYEFFECTIVERIGHTS,
        ComponentType.REGKEYEFFECTIVERIGHTS53,
        ComponentType.SERVICEEFFECTIVERIGHTS,
        ComponentType.SHAREDRESOURCE,
        ComponentType.SID,
        ComponentType.SID_SID,
        ComponentType.UAC,
        ComponentType.USER,
        ComponentType.USER_SID,
        ComponentType.USER_SID55,
        ComponentType.VOLUME,
        ComponentType.WMI,
        ComponentType.WMI57,
        ComponentType.WUAUPDATESEARCHER
    };

}
//
