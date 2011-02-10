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

package jp.go.aist.six.oval.interpreter;

import jp.go.aist.six.oval.OvalException;



/**
 * An exceptional condition that occurred during the OVAL interpreter execution.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalInterpreterException
    extends OvalException
{

    /**
     * Constructs an OvalInterpreterException with no detail message.
     */
    public OvalInterpreterException()
    {
        super();
    }



    /**
     * Constructs an OvalInterpreterException with the specified detail message.
     *
     * @param  message
     *   the detail message.
     */
    public OvalInterpreterException(
                    final String message
                    )
    {
        super( message );
    }



    /**
     * Constructs an OvalInterpreterException with the specified cause.
     *
     * @param   cause
     *  the cause.
     */
    public OvalInterpreterException(
                    final Throwable cause
                    )
    {
        super( cause );
    }



    /**
     * Constructs an OvalInterpreterException with the specified
     * detail message and cause.
     *
     * @param   message
     *  the detail message.
     * @param   cause
     *  the cause.
     */
    public OvalInterpreterException(
                    final String message,
                    final Throwable cause
                    )
    {
        super( message, cause );
    }

}
// OvalInterpreterException

