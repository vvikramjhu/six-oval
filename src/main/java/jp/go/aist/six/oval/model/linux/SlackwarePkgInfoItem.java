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

import jp.go.aist.six.oval.model.Component;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.sc.EntityItemStringType;
import jp.go.aist.six.oval.model.sc.ItemType;



/**
 * This item describes info related to Slackware packages.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class SlackwarePkgInfoItem
    extends ItemType
{

    //{0..1}
    private EntityItemStringType  name;
    private EntityItemStringType  version;
    private EntityItemStringType  architecture;
    private EntityItemStringType  revision;



    /**
     * Constructor.
     */
    public SlackwarePkgInfoItem()
    {
        this( 0 );
    }


    public SlackwarePkgInfoItem(
                    final int id
                    )
    {
        super( id );

//        _oval_platform_type = OvalPlatformType.linux;
//        _oval_component_type = OvalComponentType.slackwarepkginfo;
        _oval_family = Family.LINUX;
        _oval_component = Component.SLACKWAREPKGINFO;
    }



    /**
     */
    public void setName(
                    final EntityItemStringType name
                    )
    {
        this.name = name;
    }


    public EntityItemStringType getName()
    {
        return name;
    }



    /**
     */
    public void setArchitecture(
                    final EntityItemStringType architecture
                    )
    {
        this.architecture = architecture;
    }


    public EntityItemStringType getArchitecture()
    {
        return architecture;
    }



    /**
     */
    public void setVersion(
                    final EntityItemStringType version
                    )
    {
        this.version = version;
    }


    public EntityItemStringType getVersion()
    {
        return version;
    }



    /**
     */
    public void setRevision(
                    final EntityItemStringType revision
                    )
    {
        this.revision = revision;
    }


    public EntityItemStringType getRevision()
    {
        return revision;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "slackwarepkginfo_item[" + super.toString()
                        + ", name="         + getName()
                        + ", architecture=" + getArchitecture()
                        + ", version="      + getVersion()
                        + ", revision="     + getRevision()
             + "]";
    }

}
//SlackwarePkgInfoItem
