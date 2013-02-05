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
package jp.go.aist.six.oval.core.repository.mongodb;

import java.util.Set;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.converters.DefaultConverters;
import com.google.code.morphia.converters.TypeConverter;



public class MorphiaFactory
{

    @SuppressWarnings( "rawtypes" )
    public static Morphia create(
                    final Set<Class> classesToMap
                    )
    {
        return create( classesToMap, null );
    }



	@SuppressWarnings( "rawtypes" )
    public static Morphia create(
	                final Set<Class> classesToMap,
	                final Set<Class<? extends TypeConverter>> converters
	                )
	{
        Morphia  morphia = new Morphia( classesToMap );

        if (converters != null  &&  converters.size() > 0) {
            DefaultConverters  defaultConverters = morphia.getMapper().getConverters();
            for (Class<? extends TypeConverter>  converter : converters) {
                defaultConverters.addConverter( converter );
            }
        }

        return morphia;
	}

}
// MorphiaFactory
