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

import jp.go.aist.six.oval.model.OvalObject;



/**
 * The AccesstokenBehaviors defines a number of behaviors
 * that allow a more detailed definition of the accesstoken object
 * being specified.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class AccesstokenBehaviors
    implements OvalObject
{

    public static final Boolean  DEFAULT_INCLUDE_GROUP =Boolean.TRUE;

    private Boolean  include_group;
    //{optional, default='true'}


    public static final Boolean  DEFAULT_RESOLVE_GROUP =Boolean.TRUE;

    private Boolean  resolve_group;
    //{optional, default='true'}



    /**
     * Constructor.
     */
    public AccesstokenBehaviors()
    {
    }



    /**
     */
    public void setIncludeGroup(
                    final Boolean include_group
                    )
    {
        this.include_group = include_group;
    }


    public Boolean getIncludeGroup()
    {
        return include_group;
    }


    protected static final Boolean _includeGroup(
                    final AccesstokenBehaviors behaviors
                    )
    {
        Boolean  include_group = behaviors.getIncludeGroup();
        return (include_group == null ? DEFAULT_INCLUDE_GROUP : include_group);
    }



    /**
     */
    public void setResolveGroup(
                    final Boolean resolve_group
                    )
    {
        this.resolve_group = resolve_group;
    }


    public Boolean getResolveGroup()
    {
        return resolve_group;
    }


    protected static final Boolean _resolveGroup(
                    final AccesstokenBehaviors behaviors
                    )
    {
        Boolean  scope = behaviors.getResolveGroup();
        return (scope == null ? DEFAULT_RESOLVE_GROUP : scope);
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = super.hashCode();

        result = prime * result + _includeGroup( this ).hashCode();
        result = prime * result + _resolveGroup( this ).hashCode();

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

        if (!(obj instanceof AccesstokenBehaviors)) {
            return false;
        }

        if (super.equals( obj )) {
            AccesstokenBehaviors  other = (AccesstokenBehaviors)obj;
            if (_includeGroup( this ) == _includeGroup( other )) {
                if (_resolveGroup( this ) == _resolveGroup( other )) {
                    return true;
                }
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return super.toString()
                        + ", include_group=" + getIncludeGroup()
                        + ", resolve_group=" + getResolveGroup()
                        ;
    }

}
//AccesstokenBehaviors
