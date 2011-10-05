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

package jp.go.aist.six.oval.model.variables;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import jp.go.aist.six.oval.model.OvalObject;
import jp.go.aist.six.oval.model.common.DatatypeEnumeration;



/**
 * Each Variable object contains the associated datatype and value
 * which will be substituted into the OVAL Definition
 * that is referencing this specific variable.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class VariableType
    implements OvalObject
{

    private String  id;
    //{required}


    private DatatypeEnumeration  datatype;
    //{required}


    private String  comment;
    //{required}


    private final Collection<String>  value = new ArrayList<String>();
    //{1..*}



    /**
     * Constructor.
     */
    public VariableType()
    {
    }


    public VariableType(
                    final String id,
                    final DatatypeEnumeration datatype,
                    final String comment
                    )
    {
        setDatatype( datatype );
    }



    /**
     */
    public void setID(
                    final String id
                    )
    {
        this.id = id;
    }


    public String getID()
    {
        return this.id;
    }



    /**
     */
    public void setDatatype(
                    final DatatypeEnumeration datatype
                    )
    {
        this.datatype = datatype;
    }


    public DatatypeEnumeration getDatatype()
    {
        return this.datatype;
    }



    /**
     */
    public void setComment(
                    final String comment
                    )
    {
        this.comment = comment;
    }


    public String getComment()
    {
        return this.comment;
    }



    /**
     */
    public void setValue(
                    final Collection<String> valueList
                    )
    {
        if (valueList != this.value) {
            this.value.clear();
            if (valueList != null  &&  valueList.size() > 0) {
                this.value.addAll( valueList );
            }
        }
    }


    public Collection<String> getValue()
    {
        return this.value;
    }


    public Iterator<String> iterateValue()
    {
        return this.value.iterator();
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "[id=" + getID()
                        + ", datatype=" + getDatatype()
                        + ", comment=" + getComment()
                        + ", valeu=" + getValue()
                        ;
    }

}
//VariableType
