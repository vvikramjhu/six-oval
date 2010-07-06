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

package jp.go.aist.six.oval.process.debian.dsa;




/**
 * An exceptional condition that occurred during the DSA processing.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: DsaException.java 434 2010-03-23 05:01:24Z akihito $
 */
public class DsaException
    extends Exception
{

    /**
     * Constructs an DsaException with no detail message.
     */
    public DsaException()
    {
        super();
    }



    /**
     * Constructs an DsaException with the specified detail message.
     *
     * @param  message
     *   the detail message.
     */
    public DsaException(
                    final String message
                    )
    {
        super( message );
    }



    /**
     * Constructs an DsaException with the specified cause.
     *
     * @param   cause
     *  the cause.
     */
    public DsaException(
                    final Throwable cause
                    )
    {
        super( cause );
    }



    /**
     * Constructs an DsaException with the specified
     * detail message and cause.
     *
     * @param   message
     *  the detail message.
     * @param   cause
     *  the cause.
     */
    public DsaException(
                    final String message,
                    final Throwable cause
                    )
    {
        super( message, cause );
    }

}
// DsaException

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

