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

import jp.go.aist.six.oval.model.OvalEnumeration;



/**
 * The Family enumeration type is a listing of families
 * that OVAL supports at this time.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public enum FamilyEnumeration
    implements OvalEnumeration
{

    CATOS                 ( "catos" ),
    IOS                   ( "ios" ),
    MACOS                 ( "macos" ),
    PIXOS                 ( "pixos" ),
    UNDEFINED             ( "undefined" ),
    UNIX                  ( "unix" ),
    VMWARE_INFRASTRUCTURE ( "vmware_infrastructure" ),
    WINDOWS               ( "windows" ),
    EMPTY                 ( "" );



    /**
     * A factory method.
     */
    public static FamilyEnumeration fromValue(
                    final String value
                    )
    {
        for (FamilyEnumeration  e : FamilyEnumeration.values()) {
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
    FamilyEnumeration(
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
// FamilyEnumeration
