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

package jp.go.aist.six.oval.model.sc;

import jp.go.aist.six.oval.model.ElementRef;
import jp.go.aist.six.oval.model.ElementType;
import jp.go.aist.six.oval.model.OvalObject;




/**
 * The variableValue holds the value to a variable
 * used during the collection of an object.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class VariableValueType
    implements ElementRef, OvalObject
//    implements Dependent<SystemObjectType>
{

    private String  variable_id;
    //{required, oval:VariableIDPattern}


    private String  content;
    //{xsd:anySimpleType}



    /**
     * Constructor.
     */
    public VariableValueType()
    {
    }


    public VariableValueType(
                    final String variable_id,
                    final String content
                    )
    {
        setVariableId( variable_id );
        setContent( content );
    }



    /**
     */
    public void setVariableId(
                    final String id
                    )
    {
        variable_id = id;
    }


    public String getVariableId()
    {
        return variable_id;
    }



    /**
     */
    public void setContent(
                    final String content
                    )
    {
        this.content = content;
    }


    public String getContent()
    {
        return content;
    }



    //*********************************************************************
    //  ElementRef
    //*********************************************************************

    @Override
    public String ovalGetRefId()
    {
        return getVariableId();
    }



    @Override
    public ElementType ovalGetRefType()
    {
        return ElementType.VARIABLE;
    }



//    //**************************************************************
//    //  Dependent
//    //**************************************************************
//
//    private SystemObjectType  _master;
//
//
//
//    @Override
//    public void setMasterObject(
//                    final SystemObjectType master
//                    )
//    {
//        _master = master;
//    }
//
//
//    @Override
//    public SystemObjectType getMasterObject()
//    {
//        return _master;
//    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "[variable_id=" + getVariableId()
                        + ", " + getContent()
                        + "]";
    }

}
// VariableValueType
