/*
 *  @product.title@
 *  Copyright (C) @product.copyright-year@
 *    @product.vendor@
 *    Registration Number: @product.registration-number@
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package jp.go.aist.six.oval.model.windows;

import java.util.ArrayList;
import java.util.Collection;
import jp.go.aist.six.oval.model.Component;
import jp.go.aist.six.oval.model.ElementRef;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.definitions.EntityStateBoolType;
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.definitions.StateType;



/**
 * The user_sid55 state enumerates the different groups (identified by SID)
 * that a Windows user might belong to.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class UserSid55State
    extends StateType
{

    //{0..1}
    private EntityStateStringType       user_sid;
    private EntityStateBoolType         enabled;
    private EntityStateStringType       group_sid;



    /**
     * Constructor.
     */
    public UserSid55State()
    {
        this( null, 0 );
    }


    public UserSid55State(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public UserSid55State(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

//        _oval_platform_type = OvalPlatformType.windows;
//        _oval_component_type = OvalComponentType.user_sid55;
        _oval_family = Family.WINDOWS;
        _oval_component = Component.USER_SID55;
    }



    /**
     */
    public void setUserSid(
                    final EntityStateStringType user_sid
                    )
    {
        this.user_sid = user_sid;
    }


    public EntityStateStringType getUserSid()
    {
        return user_sid;
    }



    /**
     */
    public void setEnabled(
                    final EntityStateBoolType enabled
                    )
    {
        this.enabled = enabled;
    }


    public EntityStateBoolType getEnabled()
    {
        return enabled;
    }



    /**
     */
    public void setGroupSid(
                    final EntityStateStringType group_sid
                    )
    {
        this.group_sid = group_sid;
    }


    public EntityStateStringType getGroupSid()
    {
        return group_sid;
    }



    //*********************************************************************
    //  DefinitionsElement
    //*********************************************************************

    @Override
    public Collection<ElementRef> ovalGetElementRef()
    {
        Collection<ElementRef>  ref_list = new ArrayList<ElementRef>();

        ref_list.add( getUserSid() );
        ref_list.add( getEnabled() );
        ref_list.add( getGroupSid() );

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
        if (!(obj instanceof UserSid55State)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "user_sid55_state[" + super.toString()
                        + ", user_sid="     + getUserSid()
                        + ", enabled="      + getEnabled()
                        + ", group_sid="    + getGroupSid()
             + "]";
    }

}
//UserSid55State
