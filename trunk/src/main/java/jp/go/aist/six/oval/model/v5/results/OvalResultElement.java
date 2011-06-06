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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import jp.go.aist.six.oval.model.v5.OvalElement;
import jp.go.aist.six.oval.model.v5.common.MessageType;



/**
 * An abstract base class for types which represent test results.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class OvalResultElement
    extends OvalElement
//    extends OvalAnalysisElement
{

    private final Collection<MessageType>  message = new ArrayList<MessageType>();
    //{0..*}


    public static final Integer  DEFAULT_VARIABLE_INSTANCE = 1;

    private Integer  variable_instance;
    //{xsd:nonNegativeInteger, optional, default="1"}


    private ResultEnumeration  result;
    //{required}



    /**
     * Constructor.
     */
    public OvalResultElement()
    {
    }


    public OvalResultElement(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    public OvalResultElement(
                    final String id,
                    final int version,
                    final ResultEnumeration result
                    )
    {
        this( id, version );
        setResult( result );
    }



    /**
     */
    public void setMessage(
                    final Collection<? extends MessageType> messageList
                    )
    {
        if (this.message != messageList) {
            this.message.clear();
            if (messageList != null  &&  messageList.size() > 0) {
                this.message.addAll( messageList );
            }
        }
    }


    public Collection<MessageType> getMessage()
    {
        return this.message;
    }


    public Iterator<MessageType> iterateMessage()
    {
        return this.message.iterator();
    }



    /**
     */
    public void setVariableInstance(
                    final Integer variable_instance
                    )
    {
        if (variable_instance != null  &&  variable_instance < 0) {
            throw new IllegalArgumentException(
                            "negative variable instance: " + variable_instance );
        }

        this.variable_instance = variable_instance;
    }


    public Integer getVariableInstance()
    {
        return this.variable_instance;
    }



    /**
     */
    public void setResult(
                    final ResultEnumeration result
                    )
    {
        this.result= result;
    }


    public ResultEnumeration getResult()
    {
        return this.result;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  hash = super.hashCode();

        Integer  variableInstance = getVariableInstance();
        hash = prime * hash + ((variableInstance == null) ? 0 : variableInstance.hashCode());

        ResultEnumeration  result = getResult();
        hash = prime * hash + ((result == null) ? 0 : result.hashCode());

        return hash;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof OvalResultElement)) {
            return false;
        }

        if (super.equals( obj )) {
            OvalResultElement  other = (OvalResultElement)obj;
            if (getResult() == other.getResult()) {
                final Integer   this_varins = getVariableInstance();
                final Integer  other_varins = other.getVariableInstance();
                if (this_varins == other_varins
                                ||  (this_varins != null  &&  this_varins.equals( other_varins ))) {
                    return true;
                }
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return super.toString()
                        + ", result=" + getResult()
                        + ", variable_instance=" + getVariableInstance();
    }

}
// OvalResultElement
