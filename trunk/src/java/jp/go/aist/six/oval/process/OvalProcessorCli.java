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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;




/**
 * A command line interface for OvalProcessor.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: OvalProcessorCli.java 529 2010-04-07 07:22:59Z akihito $
 */
public abstract class OvalProcessorCli<T extends OvalProcessor>
{

    /**
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( OvalProcessorCli.class );



    private Class<? extends T>  _processorType;



    /**
     * Constructor.
     */
    public OvalProcessorCli()
    {
    }


    /**
     * Constructor.
     */
    public OvalProcessorCli(
                    final Class<? extends T> processorType
                    )
    {
        _processorType = processorType;
    }



    /**
     */
    protected abstract void _configure(
                    final T processor,
                    final String[] options
                    );



    /**
     */
    private T _createProcessor()
    throws InstantiationException, IllegalAccessException
    {
        if (_LOG.isTraceEnabled()) {
            _LOG.trace( "instantiating OvalProcessor: " + _processorType );
        }

        T  processor = _processorType.newInstance();

        return processor;
    }



    /**
     */
    protected void _printMessage(
                    final String message
                    )
    {
        System.out.println( message );
    }


    /**
     */
    protected void _printErrorMessage(
                    final String message
                    )
    {
        System.err.println( message );
    }




    /**
     */
    protected void _printStartupMessage()
    {
        _printMessage( "--------------------------------------------------" );
        _printMessage( "SIX OVAL, Copyright (C) 2010 AIST" );
        _printMessage( "This is free software licensed under the GPLv3." );
        _printMessage( "--------------------------------------------------" );
    }



    /**
     */
    protected void _printClosingMessage(
                    final OvalProcessStatus status
                    )
    {
        if (status.isError()) {
            _printMessage( "process failed: " + status.getErrorMessage() );
            Exception  cause = status.getErrorCause();
            if (cause != null) {
                _printMessage( "  * cause: " + cause );
            }
        } else {
            _printMessage( "process finished successfully: " );
        }

        for (String  attr : status.getAttributeNames()) {
            _printMessage( "  * " + attr + ": " + status.getAttribute( attr ) );
        }
    }



    /**
     */
    public void execute(
                    final String[] options
                    )
    {
        _printStartupMessage();

        OvalProcessStatus  status = null;
        try {
            T  processor = _createProcessor();
            _printMessage( "configure OVAL processor ..." );
            _configure( processor, options );
            status = processor.execute();
        } catch (Exception ex) {
            status = (new OvalProcessStatus( ex ));
        }

        _printClosingMessage( status );

        System.exit( (status.isError() ? 1 : 0) );
    }

}
// OvalProcessorCli

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

