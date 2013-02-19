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

package jp.go.aist.six.oval.model.solaris;

import jp.go.aist.six.oval.model.OvalEnumeration;



/**
 * Defines the different values that are valid for the service_state entity of a smf_state.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public enum SmfServiceStateEnumeration
    implements OvalEnumeration
{

    DEGRADED,
    DISABLED,
    MAINTENANCE,
    LEGACY_RUN( "LEGACY-RUN" ),
    OFFLINE,
    ONLINE,
    UNINITIALIZED,
    NONE ( "" );



    /**
     * A factory method.
     */
    public static SmfServiceStateEnumeration fromValue(
                    final String value
                    )
    {
        for (SmfServiceStateEnumeration  e : SmfServiceStateEnumeration.values()) {
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
    SmfServiceStateEnumeration()
    {
        value = name();
    }


    SmfServiceStateEnumeration(
                    final String value
                    )
    {
        this.value = value;
    }



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
