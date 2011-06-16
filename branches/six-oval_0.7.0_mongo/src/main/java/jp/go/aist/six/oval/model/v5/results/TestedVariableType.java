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

package jp.go.aist.six.oval.model.v5.results;




/**
 * The TestedVariable holds the value to a variable
 * used during the evaluation of a test.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class TestedVariableType
//    extends AbstractOvalObject
//    implements Dependent<TestType>
{

    private String  content;
    //{simpleContent, base=xsd:anySimpleType}


    private String  variable_id;
    //{required, type="oval:VariableIDPattern"}



    /**
     * Constructor.
     */
    public TestedVariableType()
    {
    }


    public TestedVariableType(
                    final String variable_id,
                    final String content
                    )
    {
        setVariableID( variable_id );
        setContent( content );
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
        return this.content;
    }



    /**
     */
    public void setVariableID(
                    final String variable_id
                    )
    {
        this.variable_id = variable_id;
    }


    public String getVariableID()
    {
        return this.variable_id;
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
        final int  prime = 37;
        int  result = 17;

        String  content = getContent();
        result = prime * result + ((content == null) ? 0 : content.hashCode());

        String  variable_id = getVariableID();
        result = prime * result + ((variable_id == null) ? 0 : variable_id.hashCode());

        return result;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof TestedVariableType)) {
            return false;
        }

        TestedVariableType  other = (TestedVariableType)obj;
        String  other_content = other.getContent();
        String   this_content =  this.getContent();
        if (this_content == other_content
                        ||  (this_content != null  &&  this_content.equals( other_content ))) {
            String  other_variable_id = other.getVariableID();
            String   this_variable_id =  this.getVariableID();
            if (this_variable_id == other_variable_id
                            ||  (this_variable_id != null  &&  this_variable_id.equals( other_variable_id ))) {
                return true;
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "tested_variable[variable_id=" + getVariableID()
                        + ", content=" + getContent()
                        + "]";
    }

}
// TestedVariableType
