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
 * The Existence enumeration type defines acceptable existence values,
 * which are used to determine a result based on the existence
 * of individual components.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public enum ExistenceEnumeration
    implements OvalEnumeration
{

    ALL_EXIST            ( "all_exist" ),
    ANY_EXIST            ( "any_exist" ),
    AT_LEAST_ONE_EXISTS  ( "at_least_one_exists" ),
    NONE_EXIST           ( "none_exist" ),
    ONLY_ONE_EXISTS      ( "only_one_exists" );



    /**
     * A factory method.
     */
    public static ExistenceEnumeration fromValue(
                    final String value
                    )
    {
        for (ExistenceEnumeration  e : ExistenceEnumeration.values()) {
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
    ExistenceEnumeration(
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
// ExistenceEnumeration
