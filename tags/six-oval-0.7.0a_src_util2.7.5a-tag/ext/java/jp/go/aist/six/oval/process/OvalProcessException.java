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




/**
 * An exceptional condition that occurred during the Oval processing.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalProcessException
    extends Exception
{

    /**
     * Constructs an OvalProcessException with no detail message.
     */
    public OvalProcessException()
    {
        super();
    }



    /**
     * Constructs an OvalProcessException with the specified detail message.
     *
     * @param  message
     *   the detail message.
     */
    public OvalProcessException(
                    final String message
                    )
    {
        super( message );
    }



    /**
     * Constructs an OvalProcessException with the specified cause.
     *
     * @param   cause
     *  the cause.
     */
    public OvalProcessException(
                    final Throwable cause
                    )
    {
        super( cause );
    }



    /**
     * Constructs an OvalProcessException with the specified
     * detail message and cause.
     *
     * @param   message
     *  the detail message.
     * @param   cause
     *  the cause.
     */
    public OvalProcessException(
                    final String message,
                    final Throwable cause
                    )
    {
        super( message, cause );
    }

}
// OvalProcessException

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */
