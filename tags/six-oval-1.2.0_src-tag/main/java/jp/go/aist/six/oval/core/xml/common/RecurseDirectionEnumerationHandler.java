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

package jp.go.aist.six.oval.core.xml.common;

import jp.go.aist.six.oval.model.common.RecurseDirectionEnumeration;
import org.exolab.castor.mapping.GeneralizedFieldHandler;


public class RecurseDirectionEnumerationHandler
    extends GeneralizedFieldHandler
{

    public RecurseDirectionEnumerationHandler()
    {
        super();
    }



    @Override
    public Object convertUponGet(
                    final Object value
                    )
    {
        if (value == null) {
            return null;
        }
        RecurseDirectionEnumeration  e = RecurseDirectionEnumeration.class.cast( value );
        return e.value();
    }



    @Override
    public Object convertUponSet(
                    final Object value
                    )
    {
        if (value == null) {
            return null;
        }
        return RecurseDirectionEnumeration.fromValue( value.toString() );
    }



    @Override
    public Class<RecurseDirectionEnumeration> getFieldType()
    {
        return RecurseDirectionEnumeration.class;
    }


//    public Object newInstance(
//                    final Object parent
//                    )
//    throws IllegalStateException
//    {
//        //-- Since it's marked as a string...just return null,
//        //-- it's not needed.
//        return null;
//    }

}
// RecurseDirectionEnumerationHandler