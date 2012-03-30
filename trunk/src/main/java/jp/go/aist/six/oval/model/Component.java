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
 * An enumeration of OVAL component types.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public enum Component
    implements OvalEnumeration
{

    // independent //
    environmentvariable,            //@deprecated
    environmentvariable58,
    family,
    filehash,                       //@deprecated
    filehash58,
    ldap,
    sql, // @deprecated
    textfilecontent, // @deprecated
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
    INTERFACE, // "interface"
//    network_interface( "interface" ), // "interface"
    password,
    process,
    process58,
    runlevel,
    shadow,
    uname,
    xinetd,

    // windows //
    accesstoken,                    //windows
    activedirectory,                //windows
    auditeventpolicy,               //windows
    auditeventpolicysubcategories,  //windows
    // file,                        //windows
    fileauditedpermissions,         //windows
    fileauditedpermissions53,       //windows
    fileeffectiverights,            //windows
    fileeffectiverights53,          //windows
    group,                          //windows
    group_sid,                      //windows
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



    ////////////////////////////////////////////////////////////////

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

}
//
