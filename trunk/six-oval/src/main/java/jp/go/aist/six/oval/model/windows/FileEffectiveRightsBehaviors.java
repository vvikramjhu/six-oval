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



/**
 * The FileEffectiveRightsBehaviors defines a number of behaviors
 * that allow a more detailed definition of the fileeffectiverights object being specified.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 * @deprecated Deprecated as of version 5.3:
 *             Replaced by the FileEffectiveRightsBehaviors53 and
 *             will be removed in version 6.0 of the language.
 */
@Deprecated
public class FileEffectiveRightsBehaviors
    extends FileBehaviors
{

    public static final Boolean  DEFAULT_INCLUDE_GROUP = Boolean.TRUE;

    private Boolean  include_group;
    //{optional, default='true'}


    public static final Boolean  DEFAULT_RESOLVE_GROUP = Boolean.FALSE;

    private Boolean  resolve_group;
    //{optional, default='false'}



    /**
     * Constructor.
     */
    public FileEffectiveRightsBehaviors()
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


    protected final boolean _includeGroup()
    {
        Boolean  include_group = getIncludeGroup();
        return (include_group == null
        		? DEFAULT_INCLUDE_GROUP.booleanValue()
        				: include_group.booleanValue());
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


    protected final boolean _resolveGroup()
    {
        Boolean  resolve_group = getResolveGroup();
        return (resolve_group == null ? DEFAULT_RESOLVE_GROUP.booleanValue() : resolve_group.booleanValue());
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        result = prime * result + (_includeGroup() ? 0 : 1);
        result = prime * result + (_resolveGroup()  ? 0 : 1);

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

        if (!(obj instanceof FileEffectiveRightsBehaviors)) {
            return false;
        }

        if (super.equals( obj )) {
            FileEffectiveRightsBehaviors  other = (FileEffectiveRightsBehaviors)obj;
            if (this._includeGroup() == other._includeGroup()) {
                if (this._resolveGroup() == other._resolveGroup()) {
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
//FileEffectiveRightsBehaviors