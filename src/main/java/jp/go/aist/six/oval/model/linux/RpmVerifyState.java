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
import jp.go.aist.six.oval.model.definitions.EntityStateBoolType;
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.definitions.StateType;



/**
 * The rpmverify state defines the different information 
 * that can be used to evaluate the specified rpm.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 * @deprecated Deprecated as of version 5.10:
 *             Replaced by the rpmverifyfile state and rpmverifypackage state
 *             and will be removed in version 6.0 of the language.
 */
public class RpmVerifyState
    extends StateType
{

    //{0..1}
    private EntityStateStringType           name;
    private EntityStateStringType           filepath;
    private EntityStateRpmVerifyResultType  size_differs;
    private EntityStateRpmVerifyResultType  mode_differs;
    private EntityStateRpmVerifyResultType  md5_differs;
    private EntityStateRpmVerifyResultType  device_differs;
    private EntityStateRpmVerifyResultType  link_mismatch;
    private EntityStateRpmVerifyResultType  ownership_differs;
    private EntityStateRpmVerifyResultType  group_differs;
    private EntityStateRpmVerifyResultType  mtime_differs;
    private EntityStateRpmVerifyResultType  capabilities_differ;
    private EntityStateBoolType             configuration_file;
    private EntityStateBoolType             documentation_file;
    private EntityStateBoolType             ghost_file;
    private EntityStateBoolType             license_file;
    private EntityStateBoolType             readme_file;



    /**
     * Constructor.
     */
    public RpmVerifyState()
    {
        this( null, 0 );
    }


    public RpmVerifyState(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public RpmVerifyState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

        _oval_platform_type = OvalPlatformType.linux;
        _oval_component_type = OvalComponentType.rpmverify;
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
    public void setFilepath(
                    final EntityStateStringType filepath
                    )
    {
        this.filepath = filepath;
    }


    public EntityStateStringType getFilepath()
    {
        return this.filepath;
    }



    /**
     */
    public void setSizeDiffers(
                    final EntityStateRpmVerifyResultType size_differs
                    )
    {
        this.size_differs = size_differs;
    }


    public EntityStateRpmVerifyResultType getSizeDiffers()
    {
        return this.size_differs;
    }



    /**
     */
    public void setModeDiffers(
                    final EntityStateRpmVerifyResultType mode_differs
                    )
    {
        this.mode_differs = mode_differs;
    }


    public EntityStateRpmVerifyResultType getModeDiffers()
    {
        return this.mode_differs;
    }



    /**
     */
    public void setMd5Differs(
                    final EntityStateRpmVerifyResultType md5_differs
                    )
    {
        this.md5_differs = md5_differs;
    }


    public EntityStateRpmVerifyResultType getMd5Differs()
    {
        return this.md5_differs;
    }



    /**
     */
    public void setDeviceDiffers(
                    final EntityStateRpmVerifyResultType device_differs
                    )
    {
        this.device_differs = device_differs;
    }


    public EntityStateRpmVerifyResultType getDeviceDiffers()
    {
        return this.device_differs;
    }



    /**
     */
    public void setLinkMismatch(
                    final EntityStateRpmVerifyResultType link_mismatch
                    )
    {
        this.link_mismatch = link_mismatch;
    }


    public EntityStateRpmVerifyResultType getLinkMismatch()
    {
        return this.link_mismatch;
    }



    /**
     */
    public void setOwnershipDiffers(
                    final EntityStateRpmVerifyResultType ownership_differs
                    )
    {
        this.ownership_differs = ownership_differs;
    }


    public EntityStateRpmVerifyResultType getOwnershipDiffers()
    {
        return this.ownership_differs;
    }



    /**
     */
    public void setGroupDiffers(
                    final EntityStateRpmVerifyResultType group_differs
                    )
    {
        this.group_differs = group_differs;
    }


    public EntityStateRpmVerifyResultType getGroupDiffers()
    {
        return this.group_differs;
    }



    /**
     */
    public void setMtimeDiffers(
                    final EntityStateRpmVerifyResultType mtime_differs
                    )
    {
        this.mtime_differs = mtime_differs;
    }


    public EntityStateRpmVerifyResultType getMtimeDiffers()
    {
        return this.mtime_differs;
    }



    /**
     */
    public void setCapabilitiesDiffer(
                    final EntityStateRpmVerifyResultType capabilities_differ
                    )
    {
        this.capabilities_differ = capabilities_differ;
    }


    public EntityStateRpmVerifyResultType getCapabilitiesDiffer()
    {
        return this.capabilities_differ;
    }



    /**
     */
    public void setConfigurationFile(
                    final EntityStateBoolType configuration_file
                    )
    {
        this.configuration_file = configuration_file;
    }


    public EntityStateBoolType getConfigurationFile()
    {
        return this.configuration_file;
    }



    /**
     */
    public void setDocumentationFile(
                    final EntityStateBoolType documentation_file
                    )
    {
        this.documentation_file = documentation_file;
    }


    public EntityStateBoolType getDocumentationFile()
    {
        return this.documentation_file;
    }



    /**
     */
    public void setGhostFile(
                    final EntityStateBoolType ghost_file
                    )
    {
        this.ghost_file = ghost_file;
    }


    public EntityStateBoolType getGhostFile()
    {
        return this.ghost_file;
    }



    /**
     */
    public void setLicenseFile(
                    final EntityStateBoolType license_file
                    )
    {
        this.license_file = license_file;
    }


    public EntityStateBoolType getLicenseFile()
    {
        return this.license_file;
    }



    /**
     */
    public void setReadmeFile(
                    final EntityStateBoolType readme_file
                    )
    {
        this.readme_file = readme_file;
    }


    public EntityStateBoolType getReadmeFile()
    {
        return this.readme_file;
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
        if (!(obj instanceof RpmVerifyState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "rpmverify_state[" + super.toString()
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
//RpmVerifyState
