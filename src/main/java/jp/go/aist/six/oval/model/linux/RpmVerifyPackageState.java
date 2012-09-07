/*
 *  @product.title@
 *  Copyright (C) @product.copyright-year@
 *    @product.vendor@
 *    Registration Number: @product.registration-number@
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

import java.util.ArrayList;
import java.util.Collection;
import jp.go.aist.six.oval.model.ComponentType;
import jp.go.aist.six.oval.model.ElementRef;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.definitions.EntityStateAnySimpleType;
import jp.go.aist.six.oval.model.definitions.EntityStateBoolType;
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.definitions.StateType;



/**
 * The rpmverifyfile_state defines the different information that can be used to determine
 * if a set of files within a set of RPMs passed verification.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class RpmVerifyFileState
    extends StateType
{

    //{0..1}
    private EntityStateStringType           name;
    private EntityStateAnySimpleType        epoch;
    private EntityStateAnySimpleType        version;
    private EntityStateAnySimpleType        release;
    private EntityStateStringType           arch;
    private EntityStateStringType           filepath;
    private EntityStateStringType           extended_name;

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
    public RpmVerifyFileState()
    {
        this( null, 0 );
    }


    public RpmVerifyFileState(
                    final String id,
                    final int version
                    )
    {
        super( id, version );

        _oval_family = Family.LINUX;
        _oval_component = ComponentType.RPMVERIFYFILE;
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
        return name;
    }



    /**
     */
    public void setEpoch(
                    final EntityStateAnySimpleType epoch
                    )
    {
        this.epoch = epoch;
    }


    public EntityStateAnySimpleType getEpoch()
    {
        return epoch;
    }



    /**
     */
    public void setVersion(
                    final EntityStateAnySimpleType version
                    )
    {
        this.version = version;
    }


    public EntityStateAnySimpleType getVersion()
    {
        return version;
    }



    /**
     */
    public void setRelease(
                    final EntityStateAnySimpleType release
                    )
    {
        this.release = release;
    }


    public EntityStateAnySimpleType getRelease()
    {
        return release;
    }



    /**
     */
    public void setArch(
                    final EntityStateStringType arch
                    )
    {
        this.arch = arch;
    }


    public EntityStateStringType getArch()
    {
        return arch;
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
        return filepath;
    }



    /**
     */
    public void setExtendedName(
                    final EntityStateStringType extended_name
                    )
    {
        this.extended_name = extended_name;
    }


    public EntityStateStringType getExtendedName()
    {
        return extended_name;
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
        return size_differs;
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
        return mode_differs;
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
        return md5_differs;
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
        return device_differs;
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
        return link_mismatch;
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
        return ownership_differs;
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
        return group_differs;
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
        return mtime_differs;
    }



    /**
     */
    public void setCapabilitiesDiffers(
                    final EntityStateRpmVerifyResultType capabilities_differ
                    )
    {
        this.capabilities_differ = capabilities_differ;
    }


    public EntityStateRpmVerifyResultType getCapabilitiesDiffers()
    {
        return capabilities_differ;
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
        return configuration_file;
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
        return documentation_file;
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
        return ghost_file;
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
        return license_file;
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
        return readme_file;
    }



    //*********************************************************************
    //  DefinitionsElement
    //*********************************************************************

    @Override
    public Collection<ElementRef> ovalGetElementRef()
    {
        Collection<ElementRef>  ref_list = new ArrayList<ElementRef>();
        ref_list.add( getName() );
        ref_list.add( getEpoch() );
        ref_list.add( getVersion() );
        ref_list.add( getRelease() );
        ref_list.add( getArch() );
        ref_list.add( getFilepath() );
        ref_list.add( getExtendedName() );

        ref_list.add( getSizeDiffers() );
        ref_list.add( getModeDiffers() );
        ref_list.add( getMd5Differs() );
        ref_list.add( getDeviceDiffers() );
        ref_list.add( getLinkMismatch() );
        ref_list.add( getOwnershipDiffers() );
        ref_list.add( getGroupDiffers() );
        ref_list.add( getMtimeDiffers() );
        ref_list.add( getCapabilitiesDiffers() );

        ref_list.add( getConfigurationFile() );
        ref_list.add( getDocumentationFile() );
        ref_list.add( getGhostFile() );
        ref_list.add( getLicenseFile() );
        ref_list.add( getReadmeFile() );

        return ref_list;
    }



    // **************************************************************
    // java.lang.Object
    // **************************************************************

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
        if (!(obj instanceof RpmVerifyFileState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "rpmverifyfile_state[" + super.toString()
                        + ", name="                 + getName()
                        + ", epoch="                + getEpoch()
                        + ", version="              + getVersion()
                        + ", release="              + getRelease()
                        + ", arch="                 + getArch()
                        + ", filepath="             + getFilepath()
                        + ", extended_name="        + getExtendedName()
                        + ", size_differs="         + getSizeDiffers()
                        + ", mode_differs="         + getModeDiffers()
                        + ", md5_differs="          + getMd5Differs()
                        + ", device_differs="       + getDeviceDiffers()
                        + ", link_mismatch="        + getLinkMismatch()
                        + ", ownership_differs="    + getOwnershipDiffers()
                        + ", group_differs="        + getGroupDiffers()
                        + ", mtime_differs="        + getMtimeDiffers()
                        + ", capabilities_differ="  + getCapabilitiesDiffers()
                        + ", configuration_file="   + getConfigurationFile()
                        + ", documentation_file="   + getDocumentationFile()
                        + ", ghost_file="           + getGhostFile()
                        + ", license_file="         + getLicenseFile()
                        + ", readme_file="          + getReadmeFile()

                        + "]";
    }

}
//
