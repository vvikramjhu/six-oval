/**
 * SIX OVAL - http://code.google.com/p/six-oval/
 * Copyright (C) 2010
 *   National Institute of Advanced Industrial Science and Technology (AIST)
 *   Registration Number: H22PRO-1124
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
package jp.go.aist.six.oval.core.repository.mongodb.converters;

import jp.go.aist.six.oval.model.common.FamilyEnumeration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.stereotype.Component;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
@Component
@WritingConverter
public class FamilyEnumerationStringConverter
    implements Converter<FamilyEnumeration,String>
{

    //*********************************************************************
    //  Converter
    //*********************************************************************

    public String convert(
                    final FamilyEnumeration source
                    )
    {
        return source.value();
    }

}
//

