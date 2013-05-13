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
package jp.go.aist.six.oval.model.aix;

import java.util.ArrayList;
import java.util.Collection;
import jp.go.aist.six.oval.model.ComponentType;
import jp.go.aist.six.oval.model.ElementRef;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.definitions.StateType;



/**
 * The interim_fix_state defines the different information associated
 * with a specific interim fix installed on the system.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class InterimFixState
    extends StateType
{

    //{0..1}
    private EntityStateStringType           vuid;
    private EntityStateStringType           level;

    //renamed from "abstract" to "description" because "abstract" is Java reserved word.
    private EntityStateStringType           description;

    private EntityStateInterimFixStateType  state;



    /**
     * Constructor.
     */
    public InterimFixState()
    {
        this( null, 0 );
    }


    public InterimFixState(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public InterimFixState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

        _oval_family = Family.AIX;
        _oval_component = ComponentType.INTERIM_FIX;
    }




    /**
     */
    public void setVuid(
                    final EntityStateStringType vuid
                    )
    {
        this.vuid = vuid;
    }


    public EntityStateStringType getVuid()
    {
        return vuid;
    }



    /**
     */
    public void setLevel(
                    final EntityStateStringType level
                    )
    {
        this.level = level;
    }


    public EntityStateStringType getLevel()
    {
        return level;
    }



    /**
     */
    public void setAbstract(
                    final EntityStateStringType description
                    )
    {
        this.description = description;
    }


    public EntityStateStringType getAbstract()
    {
        return description;
    }



    /**
     */
    public void setState(
                    final EntityStateInterimFixStateType state
                    )
    {
        this.state = state;
    }


    public EntityStateInterimFixStateType getState()
    {
        return state;
    }



    //*********************************************************************
    //  DefinitionsElement
    //*********************************************************************

    @Override
    public Collection<ElementRef> ovalGetElementRef()
    {
        Collection<ElementRef>  ref_list = new ArrayList<ElementRef>();
        ref_list.add( getVuid() );
        ref_list.add( getLevel() );
        ref_list.add( getAbstract() );
        ref_list.add( getState() );

        return ref_list;
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
        if (!(obj instanceof InterimFixState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "interim_fix_state[" + super.toString()
                        + ", vuid="     + getVuid()
                        + ", level="    + getLevel()
                        + ", abstract=" + getAbstract()
                        + ", state="    + getState()
             + "]";
    }

}
//
