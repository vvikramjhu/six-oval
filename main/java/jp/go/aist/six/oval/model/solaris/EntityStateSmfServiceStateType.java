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

import jp.go.aist.six.oval.model.definitions.EntityStateStringType;



/**
 * The EntityStateSmfServiceStateType complex type defines the different values
 * that are valid for the service_state entity of a smf_state.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class EntityStateSmfServiceStateType
extends EntityStateStringType
{

    /**
     * Constructor.
     */
    public EntityStateSmfServiceStateType()
    {
    }



    // **************************************************************
    // EntitySimpleBaseType
    // **************************************************************

    @Override
    public void setContent(
                    final String content
                    )
    {
        if (content != null) {
            SmfServiceStateEnumeration.fromValue( content );
        }

        super.setContent( content );
    }



    // **************************************************************
    // java.lang.Object
    // **************************************************************

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }



    @Override
    public boolean equals( final Object obj )
    {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof EntityStateSmfServiceStateType)) {
            return false;
        }

        return super.equals( obj );
    }

}
//
