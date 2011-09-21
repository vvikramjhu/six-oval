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

package jp.go.aist.six.oval.model.v5.definitions;

import jp.go.aist.six.oval.model.OvalEntityRefType;



/**
 * An Object reference to be used by OVAL Tests.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class SystemObjectRefType
    extends OvalEntityRefType
//    implements Dependent<TestType>
{

    private String  object_ref;
    //{required}



    /**
     * Constructor.
     */
    public SystemObjectRefType()
    {
    }


    /**
     * Constructor.
     */
    public SystemObjectRefType(
                    final String object_ref
                    )
    {
        setObjectRef( object_ref );
    }



    /**
     */
    public void setObjectRef(
                    final String object_ref
                    )
    {
        this.object_ref = object_ref;
    }


    public String getObjectRef()
    {
        return this.object_ref;
    }



    //**************************************************************
    //  OvalEntityRef
    //**************************************************************

    @Override
    protected void _setRef(
                    final String id
                    )
    {
        setObjectRef( id );
    }


    @Override
    protected String _getRef()
    {
        return getObjectRef();
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
        if (!(obj instanceof SystemObjectRefType)) {
            return false;
        }

        return super.equals( obj );
    }

}
// SystemObjectRefType
