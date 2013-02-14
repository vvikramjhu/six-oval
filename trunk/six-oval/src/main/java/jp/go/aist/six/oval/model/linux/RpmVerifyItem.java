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
package jp.go.aist.six.oval.model.linux;

import jp.go.aist.six.oval.model.ComponentType;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.sc.EntityItemBoolType;
import jp.go.aist.six.oval.model.sc.EntityItemStringType;
import jp.go.aist.six.oval.model.sc.ItemType;
import jp.go.aist.six.oval.model.sc.StatusEnumeration;



/**
 * This item stores rpm verification results
 * similar to what is produced by the rpm -V command.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 * @deprecated Deprecated as of version 5.10:
 *             Replaced by the rpmverifyfile item and rpmverifypackage item
 *             and will be removed in version 6.0 of the language.
 */
@Deprecated
public class RpmVerifyItem
    extends ItemType
{

    //{0..1}
    private EntityItemStringType           name;
    private EntityItemStringType           filepath;
    private EntityItemRpmVerifyResultType  size_differs;
    private EntityItemRpmVerifyResultType  mode_differs;
    private EntityItemRpmVerifyResultType  md5_differs;
    private EntityItemRpmVerifyResultType  device_differs;
    private EntityItemRpmVerifyResultType  link_mismatch;
    private EntityItemRpmVerifyResultType  ownership_differs;
    private EntityItemRpmVerifyResultType  group_differs;
    private EntityItemRpmVerifyResultType  mtime_differs;
    private EntityItemRpmVerifyResultType  capabilities_differ;
    private EntityItemBoolType             configuration_file;
    private EntityItemBoolType             documentation_file;
    private EntityItemBoolType             ghost_file;
    private EntityItemBoolType             license_file;
    private EntityItemBoolType             readme_file;



    /**
     * Constructor.
     */
    public RpmVerifyItem()
    {
        this( 0 );
    }


    public RpmVerifyItem(
                    final int id
                    )
    {
        this( id, null );
    }


    public RpmVerifyItem(
                    final int id,
                    final StatusEnumeration status
                    )
    {
        super( id, status );

//        _oval_platform_type = OvalPlatformType.linux;
//        _oval_component_type = OvalComponentType.rpmverify;
        _oval_family = Family.LINUX;
        _oval_component = ComponentType.RPMVERIFY;
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
    public void setFilepath(
                    final EntityItemStringType filepath
                    )
    {
        this.filepath = filepath;
    }


    public EntityItemStringType getFilepath()
    {
        return filepath;
    }



    /**
     */
    public void setSizeDiffers(
                    final EntityItemRpmVerifyResultType size_differs
                    )
    {
        this.size_differs = size_differs;
    }


    public EntityItemRpmVerifyResultType getSizeDiffers()
    {
        return size_differs;
    }



    /**
     */
    public void setModeDiffers(
                    final EntityItemRpmVerifyResultType mode_differs
                    )
    {
        this.mode_differs = mode_differs;
    }


    public EntityItemRpmVerifyResultType getModeDiffers()
    {
        return mode_differs;
    }



    /**
     */
    public void setMd5Differs(
                    final EntityItemRpmVerifyResultType md5_differs
                    )
    {
        this.md5_differs = md5_differs;
    }


    public EntityItemRpmVerifyResultType getMd5Differs()
    {
        return md5_differs;
    }



    /**
     */
    public void setDeviceDiffers(
                    final EntityItemRpmVerifyResultType device_differs
                    )
    {
        this.device_differs = device_differs;
    }


    public EntityItemRpmVerifyResultType getDeviceDiffers()
    {
        return device_differs;
    }



    /**
     */
    public void setLinkMismatch(
                    final EntityItemRpmVerifyResultType link_mismatch
                    )
    {
        this.link_mismatch = link_mismatch;
    }


    public EntityItemRpmVerifyResultType getLinkMismatch()
    {
        return link_mismatch;
    }



    /**
     */
    public void setOwnershipDiffers(
                    final EntityItemRpmVerifyResultType ownership_differs
                    )
    {
        this.ownership_differs = ownership_differs;
    }


    public EntityItemRpmVerifyResultType getOwnershipDiffers()
    {
        return ownership_differs;
    }



    /**
     */
    public void setGroupDiffers(
                    final EntityItemRpmVerifyResultType group_differs
                    )
    {
        this.group_differs = group_differs;
    }


    public EntityItemRpmVerifyResultType getGroupDiffers()
    {
        return group_differs;
    }



    /**
     */
    public void setMtimeDiffers(
                    final EntityItemRpmVerifyResultType mtime_differs
                    )
    {
        this.mtime_differs = mtime_differs;
    }


    public EntityItemRpmVerifyResultType getMtimeDiffers()
    {
        return mtime_differs;
    }



    /**
     */
    public void setCapabilitiesDiffer(
                    final EntityItemRpmVerifyResultType capabilities_differ
                    )
    {
        this.capabilities_differ = capabilities_differ;
    }


    public EntityItemRpmVerifyResultType getCapabilitiesDiffer()
    {
        return capabilities_differ;
    }



    /**
     */
    public void setConfigurationFile(
                    final EntityItemBoolType configuration_file
                    )
    {
        this.configuration_file = configuration_file;
    }


    public EntityItemBoolType getConfigurationFile()
    {
        return configuration_file;
    }



    /**
     */
    public void setDocumentationFile(
                    final EntityItemBoolType documentation_file
                    )
    {
        this.documentation_file = documentation_file;
    }


    public EntityItemBoolType getDocumentationFile()
    {
        return documentation_file;
    }



    /**
     */
    public void setGhostFile(
                    final EntityItemBoolType ghost_file
                    )
    {
        this.ghost_file = ghost_file;
    }


    public EntityItemBoolType getGhostFile()
    {
        return ghost_file;
    }



    /**
     */
    public void setLicenseFile(
                    final EntityItemBoolType license_file
                    )
    {
        this.license_file = license_file;
    }


    public EntityItemBoolType getLicenseFile()
    {
        return license_file;
    }



    /**
     */
    public void setReadmeFile(
                    final EntityItemBoolType readme_file
                    )
    {
        this.readme_file = readme_file;
    }


    public EntityItemBoolType getReadmeFile()
    {
        return readme_file;
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
        if (!(obj instanceof RpmVerifyItem)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "rpmverify_item[" + super.toString()
                        + ", name="                 + getName()
                        + ", filepath="             + getFilepath()
                        + ", size_differs="         + getSizeDiffers()
                        + ", mode_differs="         + getModeDiffers()
                        + ", md5_differs="          + getMd5Differs()
                        + ", device_differs="       + getDeviceDiffers()
                        + ", link_mismatch="        + getLinkMismatch()
                        + ", ownership_differs="    + getOwnershipDiffers()
                        + ", group_differs="        + getGroupDiffers()
                        + ", mtime_differs="        + getMtimeDiffers()
                        + ", capabilities_differ="  + getCapabilitiesDiffer()
                        + ", configuration_file="   + getConfigurationFile()
                        + ", documentation_file="   + getDocumentationFile()
                        + ", ghost_file="           + getGhostFile()
                        + ", license_file="         + getLicenseFile()
                        + ", readme_file="          + getReadmeFile()
             + "]";
    }
}
//RpmVerifyItem