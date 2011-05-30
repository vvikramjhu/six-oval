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

package jp.go.aist.six.oval.model.v5.sc;

import jp.go.aist.six.oval.model.v5.AbstractOvalObject;
import jp.go.aist.six.util.persist.Dependent;



/**
 * The variableValue holds the value to a variable
 * used during the collection of an object.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class VariableValueType
    extends AbstractOvalObject
    implements Dependent<SystemObjectType>
{

    private String  _variableID;
    //{required}


    private String  _content;
    //{xsd:anysimpleType}



    /**
     * Constructor.
     */
    public VariableValueType()
    {
    }


    public VariableValueType(
                    final String variableID,
                    final String value
                    )
    {
        setVariableID( variableID );
        setContent( value );
    }



    /**
     */
    public void setVariableID(
                    final String id
                    )
    {
        _variableID = id;
    }


    public String getVariableID()
    {
        return _variableID;
    }



    /**
     */
    public void setContent(
                    final String content
                    )
    {
        _content = content;
    }


    public String getContent()
    {
        return _content;
    }



    //**************************************************************
    //  Dependent
    //**************************************************************

    private SystemObjectType  _master;



    @Override
    public void setMasterObject(
                    final SystemObjectType master
                    )
    {
        _master = master;
    }


    @Override
    public SystemObjectType getMasterObject()
    {
        return _master;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "[variable_id=" + getVariableID()
                        + ", " + getContent()
                        + "]";
    }

}
// VariableValueType
