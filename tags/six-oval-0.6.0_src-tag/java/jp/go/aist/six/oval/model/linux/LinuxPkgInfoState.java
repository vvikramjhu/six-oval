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

package jp.go.aist.six.oval.model.linux;

import jp.go.aist.six.oval.model.definitions.EntityStateAnySimple;
import jp.go.aist.six.oval.model.definitions.EntityStateString;
import jp.go.aist.six.oval.model.definitions.State;




/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class LinuxPkgInfoState
    extends State
{

    private EntityStateString  _name;
    //{0..1}

    private EntityStateString  _arch;
    //{0..1}

    private EntityStateAnySimple  _version;
    //{0..1}



    /**
     * Constructor.
     */
    public LinuxPkgInfoState()
    {
    }


    /**
     * Constructor.
     */
    public LinuxPkgInfoState(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }




    public void setName(
                    final EntityStateString name
                    )
    {
        _name = name;
    }


    public EntityStateString getName()
    {
        return _name;
    }



    public void setArch(
                    final EntityStateString arch
                    )
    {
        _arch = arch;
    }


    public EntityStateString getArch()
    {
        return _arch;
    }



    public void setVersion(
                    final EntityStateAnySimple version
                    )
    {
        _version = version;
    }


    public EntityStateAnySimple getVersion()
    {
        return _version;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return super.toString()
                        + ", arch=" + getArch()
                        + ", name=" + getName()
                        + ", version=" + getVersion();
    }

}
// LinuxPkgInfoState