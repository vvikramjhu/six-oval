/*
 *  @ProductName@
 *  Copyright (C) @CopyrightYear@
 *    National Institute of Advanced Industrial Science and Technology (AIST)
 *    Registration Number: @AISTRegistrationNumber@
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

package jp.go.aist.six.oval.process;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;




/**
 * A status of an execution of the OvalProcessor.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalProcessStatus
{

    private boolean  _error = false;
    private String  _errorMessage;
    private Exception  _errorCause;

    private Map<String,Object>  _attributes = new HashMap<String,Object>();



    /**
     * Constructor.
     */
    public OvalProcessStatus()
    {
    }


    /**
     * Constructor.
     */
    public OvalProcessStatus(
                    final Exception cause
                    )
    {
        buildError( cause );
    }



    /**
     */
    public synchronized void reset()
    {
        setError( false );
        setErrorCause( null );
        _attributes.clear();
    }



    /**
     */
    public final void setError(
                    final boolean error
                    )
    {
        _error = error;
    }


    public final boolean isError()
    {
        return _error;
    }



    /**
     */
    public final void setErrorMessage(
                    final String message
                    )
    {
        _errorMessage = message;
    }


    public final String getErrorMessage()
    {
        return _errorMessage;
    }



    /**
     */
    public final void setErrorCause(
                    final Exception exception
                    )
    {
        _errorCause = exception;
    }


    public final Exception getErrorCause()
    {
        return _errorCause;
    }



    public void buildError(
                    final Exception cause
                    )
    {
        setError( true );
        setErrorCause( cause );
        setErrorMessage( cause.getMessage() );
    }



    /**
     */
    public final void mergeAttributes(
                    final OvalProcessStatus status
                    )
    {
        if (status != null) {
            for (String  name : status.getAttributeNames()) {
                setAttribute( name, status.getAttribute( name ) );
            }
        }
    }


    public final void setAttribute(
                    final String name,
                    final Object value
                    )
    {
        _attributes.put( name, value );
    }


    /**
     */
    public final Object getAttribute(
                    final String name
                    )
    {
        return _attributes.get( name );
    }


    public final Set<String> getAttributeNames()
    {
        return _attributes.keySet();
    }



    //==============================================================
    //  java.lang.Object
    //==============================================================

    @Override
    public
    String toString()
    {
        StringBuffer  s = new StringBuffer( "OvalProcessStatus[" );
        s.append( "error=" ).append( isError() );
        s.append( ", error message=" ).append( getErrorMessage() );
        s.append( ", attributes=" ).append( _attributes );
        s.append( "]" );

        return s.toString();
    }

}
// OvalProcessStatus

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

