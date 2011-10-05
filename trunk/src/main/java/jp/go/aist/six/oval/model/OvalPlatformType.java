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
 * The OvalPlatformType enumeration is a listing of platforms
 * that OVAL supports at this time.
 * This list corresponds to the OVAL platform-dependent namespaces,
 * but not to the Family enumeration defined in the "common" schema.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public enum OvalPlatformType
{

    aix,
    apache,
    catos,      //Cisco
    esx,        //VMware
    freebsd,
    hpux,
    ios,
    independent,
    linux,
    macos,
    pixos,
    sharepoint,
    solaris,
    unix,
    windows;

}
// OvalPlatformType

