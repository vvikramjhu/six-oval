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
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public final class OvalPlatformType
{

//    public static final String  DEF  = "oval-def";
//    public static final String  SC   = "oval-sc";
//    public static final String  RES  = "oval-res";

    public static final String  INDEPENDENT = "independent";
    public static final String  LINUX       = "linux";
    public static final String  UNIX        = "unix";
    public static final String  WINDOWS     = "windows";


    public static final String  INDEPENDENT_FAMILY              = "family";
    public static final String  INDEPENDENT_TEXTFILECONTENT     = "textfilecontent";
    public static final String  INDEPENDENT_TEXTFILECONTENT54   = "textfilecontent54";
    public static final String  INDEPENDENT_UNKNOWN             = "unknown";
    public static final String  LINUX_DPKGINFO                  = "dpkginfo";
    public static final String  LINUX_RPMINFO                   = "rpminfo";
    public static final String  LINUX_RPMVERIFY                 = "rpmverify";
    public static final String  UNIX_UNAME                      = "uname";
    public static final String  WINDOWS_FILE                    = "file";
    public static final String  WINDOWS_METABASE                = "metabase";
    public static final String  WINDOWS_REGISTRY                = "registry";
    public static final String  WINDOWS_WMI                     = "wmi";
    public static final String  WINDOWS_WMI57                   = "wmi57";

}
// OvalNamespace

