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

package jp.go.aist.six.oval.model.windows;

import jp.go.aist.six.oval.model.OvalEnumeration;



/**
 * The different values that are valid for the current_state entity of a service.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public enum ServiceCurrentStateEnumeration
    implements OvalEnumeration
{

    SERVICE_CONTINUE_PENDING,
    SERVICE_PAUSE_PENDING,
    SERVICE_PAUSED,
    SERVICE_RUNNING,
    SERVICE_START_PENDING,
    SERVICE_STOP_PENDING,
    SERVICE_STOPPED,
    NONE( "" );



    /**
     * A factory method.
     */
    public static ServiceCurrentStateEnumeration fromValue(
                    final String value
                    )
    {
        for (ServiceCurrentStateEnumeration  e : ServiceCurrentStateEnumeration.values()) {
            if (e.value.equals( value )) {
                return e;
            }
        }

        throw new IllegalArgumentException( value );
    }



    private String  value = null;



    /**
     * Constructor.
     */
    ServiceCurrentStateEnumeration()
    {
        value = name();
    }


    ServiceCurrentStateEnumeration(
                    final String value
                    )
    {
        this.value = value;
    }



    @Override
    public String value()
    {
        return value;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return value;
    }

}
//
