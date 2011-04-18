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

package jp.go.aist.six.oval.model.definitions;

import jp.go.aist.six.oval.model.OvalEntityReference;
import jp.go.aist.six.util.persist.Dependent;



/**
 * An Object reference to be used by OVAL Tests.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class SystemObjectRef
    extends OvalEntityReference
    implements Dependent<Test>
{

    /**
     * Constructor.
     */
    public SystemObjectRef()
    {
    }


    /**
     * Constructor.
     */
    public SystemObjectRef(
                    final String objectID
                    )
    {
        super( objectID );
    }



    /**
     */
    public void setObjectRef(
                    final String objectID
                    )
    {
        setOvalID( objectID );
    }


    public String getObjectRef()
    {
        return getOvalID();
    }



    //**************************************************************
    //  Dependent
    //**************************************************************

    private Test  _master;



    public void setMasterObject(
                    final Test master
                    )
    {
        _master = master;
    }


    public Test getMasterObject()
    {
        return _master;
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
        if (!(obj instanceof SystemObjectRef)) {
            return false;
        }

        return super.equals( obj );
    }

}
// SystemObjectRef
