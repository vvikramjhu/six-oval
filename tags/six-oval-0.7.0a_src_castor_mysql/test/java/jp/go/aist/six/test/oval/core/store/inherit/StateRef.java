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

package jp.go.aist.six.test.oval.core.store.inherit;

import jp.go.aist.six.util.persist.Dependent;



/**
 * A State reference to be used by OVAL States.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: StateRef.java 1037 2010-12-01 07:02:52Z nakamura5akihito $
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class StateRef
    extends OvalEntityReference
    implements Dependent<Test>
{

    /**
     * Constructor.
     */
    public StateRef()
    {
    }


    /**
     * Constructor.
     */
    public StateRef(
                    final String stateID
                    )
    {
        super( stateID );
    }



    /**
     */
    public void setStateRef(
                    final String stateID
                    )
    {
        setOvalID( stateID );
    }


    public String getStateRef()
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
        if (!(obj instanceof StateRef)) {
            return false;
        }

        return super.equals( obj );
    }

}
// StateRef
