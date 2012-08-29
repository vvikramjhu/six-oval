/*
 *  @product.title@
 *  Copyright (C) @product.copyright-year@
 *    @product.vendor@
 *    Registration Number: @product.registration-number@
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.go.aist.six.oval.model.variables;

import java.util.ArrayList;
import java.util.Arrays;
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
                    final String comment,
                    final Collection<String> value_list
                    )
    {
        setId( id );
        setDatatype( datatype );
        setComment( comment );
        setValue( value_list );
    }


    public VariableType(
                    final String id,
                    final DatatypeEnumeration datatype,
                    final String comment,
                    final String[] value_list
                    )
    {
        setId( id );
        setDatatype( datatype );
        setComment( comment );
        setValue( value_list );
    }



    /**
     */
    public void setId(
                    final String id
                    )
    {
        this.id = id;
    }


    public String getId()
    {
        return id;
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
        return datatype;
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
        return comment;
    }



    /**
     */
    public void setValue(
                    final Collection<String> value_list
                    )
    {
        if (value_list != value) {
            value.clear();
            if (value_list != null  &&  value_list.size() > 0) {
                value.addAll( value_list );
            }
        }
    }


    public void setValue(
                    final String[] value_list
                    )
    {
        setValue( Arrays.asList( value_list ) );
    }


    public Collection<String> getValue()
    {
        return value;
    }


    public Iterator<String> iterateValue()
    {
        return value.iterator();
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "[id=" + getId()
                        + ", datatype=" + getDatatype()
                        + ", comment=" + getComment()
                        + ", valeu=" + getValue()
                        ;
    }

}
//
