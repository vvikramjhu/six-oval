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

import jp.go.aist.six.oval.model.definitions.EntityMap;



/**
 * The Windows WMI properties.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class Wmi
{

    public enum Entity
    {
    NAMESPACE,  //EntityStateString
    WQL,        //EntityStateInt
    RESULT;     //EntityStateAnySimple/Wmi, EntityStateRecord/Wmi57
    }


    /**
     */
    public static EntityMap<Wmi.Entity> createEntityMap()
    {
        return (new EntityMap<Wmi.Entity>());
    }

}
//
