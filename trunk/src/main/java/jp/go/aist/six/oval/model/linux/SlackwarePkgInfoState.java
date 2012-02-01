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

package jp.go.aist.six.oval.model.linux;

import jp.go.aist.six.oval.model.OvalComponentType;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.definitions.StateType;



/**
 * The slackwarepkginfo state defines the different information 
 * that can be used to evaluate the specified package.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class SlackwarePkgInfoState
    extends StateType
{

    //{0..1}
    private EntityStateStringType  name;
    private EntityStateStringType  version;
    private EntityStateStringType  architecture;
    private EntityStateStringType  revision;

    
    
    /**
     * Constructor.
     */
    public SlackwarePkgInfoState()
    {
        this( null, 0 );
    }


    public SlackwarePkgInfoState(
                    final String id,
                    final int version
                    )
    {
        super( id, version );

        _oval_platform_type = OvalPlatformType.linux;
        _oval_component_type = OvalComponentType.slackwarepkginfo;
    }



    /**
     */
    public void setName(
                    final EntityStateStringType name
                    )
    {
        this.name = name;
    }


    public EntityStateStringType getName()
    {
        return this.name;
    }



    /**
     */
    public void setArchitecture(
                    final EntityStateStringType architecture
                    )
    {
        this.architecture = architecture;
    }


    public EntityStateStringType getArchitecture()
    {
        return this.architecture;
    }



    /**
     */
    public void setVersion(
                    final EntityStateStringType version
                    )
    {
        this.version = version;
    }


    public EntityStateStringType getVersion()
    {
        return this.version;
    }



    /**
     */
    public void setRevision(
                    final EntityStateStringType revision
                    )
    {
        this.revision = revision;
    }


    public EntityStateStringType getRevision()
    {
        return this.revision;
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
        if (!(obj instanceof SlackwarePkgInfoState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "slackwarepkginfo_state[" + super.toString()
                        + ", name="         + getName()
                        + ", architecture=" + getArchitecture()
                        + ", version="      + getVersion()
                        + ", revision="     + getRevision()
                        + "]";
    }

}
//SlackwarePkgInfoState
