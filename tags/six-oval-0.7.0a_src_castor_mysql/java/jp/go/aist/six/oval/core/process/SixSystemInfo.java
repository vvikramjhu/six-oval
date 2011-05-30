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

package jp.go.aist.six.oval.core.process;

import jp.go.aist.six.oval.model.common.Family;
import jp.go.aist.six.oval.model.definitions.Platform;
import jp.go.aist.six.oval.model.sc.SystemInfo;



/**
 * The system information of the local node.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class SixSystemInfo
{

    private SystemInfo _systemInfo;


    private Family  _family;
    private Platform  _platform;



    /**
     * Constructor.
     */
    public SixSystemInfo()
    {
    }


    /**
     * Constructor.
     */
    public SixSystemInfo(
                    final Family family,
                    final Platform platform,
                    final SystemInfo system
                    )
    {
        setFamily( family );
        setPlatform( platform );
        setSystemInfo( system );
    }



    /**
     */
    public void setSystemInfo(
                    final SystemInfo systemInfo
                    )
    {
        _systemInfo = systemInfo;
    }


    public SystemInfo getSystemInfo()
    {
        return _systemInfo;
    }



    /**
     */
    public void setFamily(
                    final Family family
                    )
    {
        _family = family;
    }


    public Family getFamily()
    {
        return _family;
    }



    /**
     */
    public void setPlatform(
                    final Platform platform
                    )
    {
        _platform = platform;
    }


    public Platform getPlatform()
    {
        return _platform;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "[family=" + getFamily()
                        + ", platform=" + getPlatform()
                        + ", system_info=" + getSystemInfo()
                        + "]";
    }

}
// SixSystemInfo
