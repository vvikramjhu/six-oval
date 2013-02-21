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
package jp.go.aist.six.oval.model.definitions;

import jp.go.aist.six.oval.model.common.CheckEnumeration;
import jp.go.aist.six.oval.model.common.DatatypeEnumeration;
import jp.go.aist.six.oval.model.common.OperationEnumeration;



/**
 * The EntityStateBase type is an abstract type that extends
 * the EntityBase and is used by the entities within an OVAL State.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class EntityStateSimpleBaseType
    extends EntitySimpleBaseType
{

    public static final CheckEnumeration  DEFAULT_ENTITY_CHECK =
        CheckEnumeration.ALL;

    private CheckEnumeration  entity_check;
    //{optional, default="all"}



    /**
     * Constructor.
     */
    public EntityStateSimpleBaseType()
    {
    }


    public EntityStateSimpleBaseType(
                    final String content
                    )
    {
        super( content );
    }


    public EntityStateSimpleBaseType(
                    final DatatypeEnumeration datatype,
                    final OperationEnumeration operation,
                    final Boolean mask,
                    final String var_ref,
                    final CheckEnumeration var_check,
                    final String content
                    )
    {
        super( datatype, operation, mask, var_ref, var_check, content );
    }


    public EntityStateSimpleBaseType(
                    final String datatype,
                    final String operation,
                    final Boolean mask,
                    final String var_ref,
                    final String var_check,
                    final String content
                    )
    {
        super( datatype, operation, mask, var_ref, var_check, content );
    }



    /**
     */
    public void setEntityCheck(
                    final CheckEnumeration entity_check
                    )
    {
        this.entity_check = entity_check;
    }


    public CheckEnumeration getEntityCheck()
    {
        return entity_check;
    }


    public static CheckEnumeration entityCheck(
                    final EntityStateSimpleBaseType obj
                    )
    {
        if (obj == null) {
            throw new IllegalArgumentException( "null EntityStateSimpleBaseType" );
        }

        CheckEnumeration  entity_check = obj.getEntityCheck();
        return (entity_check == null ? DEFAULT_ENTITY_CHECK : entity_check);
    }




    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = super.hashCode();

        result = prime * result + entityCheck( this ).hashCode();

        return result;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof EntityStateSimpleBaseType)) {
            return false;
        }

        if (super.equals( obj )) {
            EntityStateSimpleBaseType  other = (EntityStateSimpleBaseType)obj;
            if (entityCheck( this ) == entityCheck( other )) {
                return true;
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return super.toString()
                        + ", entity_check=" + getEntityCheck()
                        ;
    }

}
// EntityStateSimpleBaseType
