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

package jp.go.aist.six.oval.model.results;

import jp.go.aist.six.oval.model.OvalElement;
import jp.go.aist.six.oval.model.common.Message;
import java.util.ArrayList;
import java.util.Collection;



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

    private Collection<Message>  _message = new ArrayList<Message>();
    //{0..*}


    public static final int  DEFAULT_VARIABLE_INSTANCE = 1;
    private int  _variableInstance = DEFAULT_VARIABLE_INSTANCE;
    //{xsd:nonNegativeInteger, optional, default="1"}


    private Result  _result;
    //{required}



    /**
     * Constructor.
     */
    public OvalResultElement()
    {
    }


    /**
     * Constructor.
     */
    public OvalResultElement(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    /**
     * Constructor.
     */
    public OvalResultElement(
                    final String id,
                    final int version,
                    final Result result
                    )
    {
        this( id, version );
        setResult( result );
    }



    /**
     */
    public void setMessage(
                    final Collection<? extends Message> messages
                    )
    {
        _message.clear();
        if (messages != null  &&  messages != _message) {
            _message.addAll( messages );
        }
    }


    public boolean addMessage(
                    final Message item
                    )
    {
        return _message.add( item );
    }


    public Collection<Message> getMessage()
    {
        return _message;
    }



    /**
     */
    public void setVariableInstance(
                    final int variableInstance
                    )
    {
        if (variableInstance < 0) {
            throw new IllegalArgumentException(
                            "negative variable instance: " + variableInstance );
        }

        _variableInstance = variableInstance;
    }


    public int getVariableInstance()
    {
        return _variableInstance;
    }



    /**
     */
    public void setResult(
                    final Result result
                    )
    {
        _result= result;
    }


    public Result getResult()
    {
        return _result;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  hash = super.hashCode();

        hash = prime * hash + getVariableInstance();

        Result  result = getResult();
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
                if (getVariableInstance() == other.getVariableInstance()) {
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
