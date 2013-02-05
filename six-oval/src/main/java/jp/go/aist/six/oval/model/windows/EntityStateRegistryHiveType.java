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
package jp.go.aist.six.oval.model.windows;

import jp.go.aist.six.oval.model.definitions.EntityStateStringType;



/**
 * The EntityStateRegistryHive restricts a string value to
 * a specific set of values:
 * HKEY_CLASSES_ROOT, HKEY_CURRENT_CONFIG, HKEY_CURRENT_USER,
 * HKEY_LOCAL_MACHINE, and HKEY_USERS.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class EntityStateRegistryHiveType
    extends EntityStateStringType
{

    /**
     * Constructor.
     */
    public EntityStateRegistryHiveType()
    {
    }


    public EntityStateRegistryHiveType(
                    final String content
                    )
    {
        super( content );
    }


//    public EntityStateRegistryHiveType(
//                    final String data,
//                    final OperationEnumeration operation
//                    )
//    {
//        this( data, FIXED_DATATYPE, operation );
//    }
//
//
//    public EntityStateRegistryHiveType(
//                    final String data,
//                    final DatatypeEnumeration datatype,
//                    final OperationEnumeration operation
//                    )
//    {
//        super( data, datatype, operation );
//    }
//
//
//    public EntityStateRegistryHiveType(
//                    final RegistryHiveEnumeration data
//                    )
//    {
//        this( data, DEFAULT_OPERATION );
//    }
//
//
//    public EntityStateRegistryHiveType(
//                    final RegistryHiveEnumeration data,
//                    final OperationEnumeration operation
//                    )
//    {
//        this( (data == null ? null : data.getName()), operation );
//    }



    //**************************************************************
    //  EntityBaseType
    //**************************************************************

    @Override
    public void setContent(
                    final String content
                    )
    {
        if (content != null) {
            //validation
            RegistryHiveEnumeration.fromValue( content );
        }

        super.setContent( content );
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof EntityStateRegistryHiveType)) {
            return false;
        }

        return super.equals( obj );
    }

}
// EntityStateRegistryHiveType
