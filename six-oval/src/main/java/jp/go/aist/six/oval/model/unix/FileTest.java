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
package jp.go.aist.six.oval.model.unix;

import jp.go.aist.six.oval.model.ComponentType;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.common.CheckEnumeration;
import jp.go.aist.six.oval.model.definitions.TestType;



/**
 * The file test is used to check metadata associated with UNIX files,
 * of the sort returned by either an ls command, stat command or stat() system call.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class FileTest
    extends TestType
{

    /**
     * Constructor.
     */
    public FileTest()
    {
        this( null, 0 );
    }


    public FileTest(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null, null );
    }


    public FileTest(
                    final String id,
                    final int version,
                    final String comment,
                    final CheckEnumeration check
                    )
    {
        super( id, version, comment, check );

//        _oval_platform_type = OvalPlatformType.unix;
//        _oval_component_type = OvalComponentType.file;
        _oval_family = Family.UNIX;
        _oval_component = ComponentType.FILE;
    }


//    public FileTest(
//                    final String id,
//                    final int version,
//                    final String comment,
//                    final CheckEnumeration check,
//                    final SystemObjectRefType object,
//                    final StateRefType[] stateList
//                    )
//    {
//        super( id, version, comment, check, object, stateList );
//    }



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
        if (!(obj instanceof FileTest)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "file_test[" + super.toString() + "]";
    }

}
//FileTest
