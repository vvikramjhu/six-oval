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

package jp.go.aist.six.oval.model.unix;

import jp.go.aist.six.oval.model.sc.EntityItemStringType;



/**
 * The EntityItemInterfaceType restricts a string value
 * to a specific set of values.
 * These values describe the different interface types which are defined in 'if_arp.h'.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class EntityItemInterfaceType
    extends EntityItemStringType
{

    /**
     * Constructor.
     */
    public EntityItemInterfaceType()
    {
    }


    public EntityItemInterfaceType(
                    final String content
                    )
    {
        super( content );
    }



    //**************************************************************
    //  EntityItemBase
    //**************************************************************

    @Override
    public void setContent(
                    final String content
                    )
    {
        if (content != null) {
            // validation
            InterfaceEnumeration.fromValue( content );
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

        if (!(obj instanceof EntityItemInterfaceType)) {
            return false;
        }

        return super.equals( obj );
    }

}
//EntityItemInterfaceType
