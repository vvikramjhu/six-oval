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
package jp.go.aist.six.oval.model.esx;

import jp.go.aist.six.oval.model.OvalObject;



/**
 * The ViSdkManagedEntityBehaviors defines a number of behaviors
 * that allow a more detailed definition of the visdkmanagedobject_object being specified.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class ViSdkManagedEntityBehaviors
    implements OvalObject
{

    public static final ViSdkManagedEntityEnumeration  DEFAULT_MANAGED_ENTITY_TYPE
    = ViSdkManagedEntityEnumeration.VIRTUAL_MACHINE;

    private ViSdkManagedEntityEnumeration  managed_entity_type;
    //{optional, default='VirtualMachine'}



    /**
     * Constructor.
     */
    public ViSdkManagedEntityBehaviors()
    {
    }



    /**
     */
    public void setManagedEntityType(
                    final ViSdkManagedEntityEnumeration managed_entity_type
                    )
    {
        this.managed_entity_type = managed_entity_type;
    }


    public ViSdkManagedEntityEnumeration getManagedEntityType()
    {
        return managed_entity_type;
    }


    public static final ViSdkManagedEntityEnumeration managedEntityType(
                    final ViSdkManagedEntityBehaviors obj
                    )
    {
        ViSdkManagedEntityEnumeration  managed_entity_type = obj.getManagedEntityType();
        return (managed_entity_type == null ? DEFAULT_MANAGED_ENTITY_TYPE : managed_entity_type);
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        result = prime * result + managedEntityType( this ).hashCode();

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

        if (!(obj instanceof ViSdkManagedEntityBehaviors)) {
            return false;
        }

        if (super.equals( obj )) {
            ViSdkManagedEntityBehaviors  other = (ViSdkManagedEntityBehaviors)obj;
            if (managedEntityType( this ) == managedEntityType( other )) {
                return true;
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return super.toString()
                        + ", managed_entity_type=" + getManagedEntityType()
                        ;
    }

}
//
