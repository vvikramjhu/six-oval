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

package jp.go.aist.six.oval.model.common;

import jp.go.aist.six.oval.OvalException;



/**
 * An exceptional condition to indicate that a string could not parsed as an OVAL-ID.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalIdSyntaxException
    extends OvalException
{

    /**
     * Constructs an OvalIdSyntaxException with no detail message.
     */
    public OvalIdSyntaxException()
    {
        super();
    }



    /**
     * Constructs an OvalIdSyntaxException with the specified detail message.
     *
     * @param  message
     *   the detail message.
     */
    public OvalIdSyntaxException(
                    final String message
                    )
    {
        super( message );
    }



    /**
     * Constructs an OvalIdSyntaxException with the specified cause.
     *
     * @param   cause
     *  the cause.
     */
    public OvalIdSyntaxException(
                    final Throwable cause
                    )
    {
        super( cause );
    }



    /**
     * Constructs an OvalIdSyntaxException with the specified
     * detail message and cause.
     *
     * @param   message
     *  the detail message.
     * @param   cause
     *  the cause.
     */
    public OvalIdSyntaxException(
                    final String message,
                    final Throwable cause
                    )
    {
        super( message, cause );
    }

}
//

