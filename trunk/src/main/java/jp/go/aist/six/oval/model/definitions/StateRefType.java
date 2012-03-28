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

import jp.go.aist.six.oval.model.ElementRef;



/**
 * A State reference to be used by OVAL States.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class StateRefType
    extends ElementRef
//    implements Dependent<TestType>
{

    private String  state_ref;
    //{required}



    /**
     * Constructor.
     */
    public StateRefType()
    {
    }


    /**
     * Constructor.
     */
    public StateRefType(
                    final String state_ref
                    )
    {
        setStateRef( state_ref );
    }



    /**
     */
    public void setStateRef(
                    final String state_ref
                    )
    {
        this.state_ref = state_ref;
    }


    public String getStateRef()
    {
        return this.state_ref;
    }



    //**************************************************************
    //  OvalEntityRef
    //**************************************************************

    @Override
    protected void _setRef(
                    final String id
                    )
    {
        setStateRef( id );
    }


    @Override
    protected String _getRef()
    {
        return getStateRef();
    }



//    //**************************************************************
//    //  Dependent
//    //**************************************************************
//
//    private TestType  _master;
//
//
//
//    @Override
//    public void setMasterObject(
//                    final TestType master
//                    )
//    {
//        _master = master;
//    }
//
//
//    @Override
//    public TestType getMasterObject()
//    {
//        return _master;
//    }



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
        if (!(obj instanceof StateRefType)) {
            return false;
        }

        return super.equals( obj );
    }

}
// StateRefType
