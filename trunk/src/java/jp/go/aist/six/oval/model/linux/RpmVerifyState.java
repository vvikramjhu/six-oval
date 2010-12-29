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

import jp.go.aist.six.oval.model.PlatformEntityType;
import jp.go.aist.six.oval.model.definitions.EntityStateBase;
import jp.go.aist.six.oval.model.definitions.EntityStateBool;
import jp.go.aist.six.oval.model.definitions.EntityStateString;
import jp.go.aist.six.oval.model.definitions.State;
import java.util.EnumMap;
import java.util.Map;



/**
 * The rpmverify state defines the different information
 * that can be used to evaluate the specified rpm.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class RpmVerifyState
    extends State
{

    protected static enum Property
    {
        NAME,
        FILEPATH,
        SIZE_DIFFERS,
        MODE_DIFFERS,
        MD5_DIFFERS,
        DEVICE_DIFFERS,
        LINK_MISMATCH,
        OWNERSHIP_DIFFERS,
        GROUP_DIFFERS,
        MTIME_DIFFERS,
        CAPABILITIES_DIFFERS,
        CONFIGURATION_FILE,
        DOCUMENTATION_FILE,
        GHOST_FILE,
        LICENSE_FILE,
        README_FILE;
    }

    private Map<Property, EntityStateBase>  _properties =
        new EnumMap<Property, EntityStateBase>( Property.class );
    //{0..1}



    /**
     * Constructor.
     */
    public RpmVerifyState()
    {
    }


    /**
     * Constructor.
     */
    public RpmVerifyState(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }



    /**
     */
    public void setName(
                    final EntityStateString name
                    )
    {
        _properties.put( Property.NAME, name );
    }


    public EntityStateString getName()
    {
        return (EntityStateString)_properties.get( Property.NAME );
    }



    /**
     */
    public void setFilepath(
                    final EntityStateString filepath
                    )
    {
        _properties.put( Property.FILEPATH, filepath );
    }


    public EntityStateString getFilepath()
    {
        return (EntityStateString)_properties.get( Property.FILEPATH );
    }



    /**
     */
    public void setSizeDiffers(
                    final EntityStateRpmVerifyResult sizeDiffers
                    )
    {
        _properties.put( Property.SIZE_DIFFERS, sizeDiffers );
    }


    public EntityStateRpmVerifyResult getSizeDiffers()
    {
        return (EntityStateRpmVerifyResult)_properties.get( Property.SIZE_DIFFERS );
    }



    /**
     */
    public void setModeDiffers(
                    final EntityStateRpmVerifyResult modeDiffers
                    )
    {
        _properties.put( Property.MODE_DIFFERS, modeDiffers );
    }


    public EntityStateRpmVerifyResult getModeDiffers()
    {
        return (EntityStateRpmVerifyResult)_properties.get( Property.MODE_DIFFERS );
    }



    /**
     */
    public void setMd5Differs(
                    final EntityStateRpmVerifyResult md5Differs
                    )
    {
        _properties.put( Property.MD5_DIFFERS, md5Differs );
    }


    public EntityStateRpmVerifyResult getMd5Differs()
    {
        return (EntityStateRpmVerifyResult)_properties.get( Property.MD5_DIFFERS );
    }



    /**
     */
    public void setDeviceDiffers(
                    final EntityStateRpmVerifyResult deviceDiffers
                    )
    {
        _properties.put( Property.DEVICE_DIFFERS, deviceDiffers );
    }


    public EntityStateRpmVerifyResult getDeviceDiffers()
    {
        return (EntityStateRpmVerifyResult)_properties.get( Property.DEVICE_DIFFERS );
    }



    /**
     */
    public void setLinkMismatch(
                    final EntityStateRpmVerifyResult linkMismatch
                    )
    {
        _properties.put( Property.LINK_MISMATCH, linkMismatch );
    }


    public EntityStateRpmVerifyResult getLinkMismatch()
    {
        return (EntityStateRpmVerifyResult)_properties.get( Property.LINK_MISMATCH );
    }



    /**
     */
    public void setOwnershipDiffers(
                    final EntityStateRpmVerifyResult ownershipDiffers
                    )
    {
        _properties.put( Property.OWNERSHIP_DIFFERS, ownershipDiffers );
    }


    public EntityStateRpmVerifyResult getOwnershipDiffers()
    {
        return (EntityStateRpmVerifyResult)_properties.get( Property.OWNERSHIP_DIFFERS );
    }



    /**
     */
    public void setGroupDiffers(
                    final EntityStateRpmVerifyResult groupDiffers
                    )
    {
        _properties.put( Property.GROUP_DIFFERS, groupDiffers );
    }


    public EntityStateRpmVerifyResult getGroupDiffers()
    {
        return (EntityStateRpmVerifyResult)_properties.get( Property.GROUP_DIFFERS );
    }



    /**
     */
    public void setMtimeDiffers(
                    final EntityStateRpmVerifyResult mtimeDiffers
                    )
    {
        _properties.put( Property.MTIME_DIFFERS, mtimeDiffers );
    }


    public EntityStateRpmVerifyResult getMtimeDiffers()
    {
        return (EntityStateRpmVerifyResult)_properties.get( Property.MTIME_DIFFERS );
    }



    /**
     */
    public void setCapabilitiesDiffers(
                    final EntityStateRpmVerifyResult capabilitiesDiffers
                    )
    {
        _properties.put( Property.CAPABILITIES_DIFFERS, capabilitiesDiffers );
    }


    public EntityStateRpmVerifyResult getCapabilitiesDiffers()
    {
        return (EntityStateRpmVerifyResult)_properties.get( Property.CAPABILITIES_DIFFERS );
    }



    /**
     */
    public void setConfigurationFile(
                    final EntityStateBool configurationFile
                    )
    {
        _properties.put( Property.CONFIGURATION_FILE, configurationFile );
    }


    public EntityStateBool getConfigurationFile()
    {
        return (EntityStateBool)_properties.get( Property.CONFIGURATION_FILE );
    }



    /**
     */
    public void setDocumentationFile(
                    final EntityStateBool documentationFile
                    )
    {
        _properties.put( Property.DOCUMENTATION_FILE, documentationFile );
    }


    public EntityStateBool getDocumentationFile()
    {
        return (EntityStateBool)_properties.get( Property.DOCUMENTATION_FILE );
    }



    /**
     */
    public void setGhostFile(
                    final EntityStateBool ghostFile
                    )
    {
        _properties.put( Property.GHOST_FILE, ghostFile );
    }


    public EntityStateBool getGhostFile()
    {
        return (EntityStateBool)_properties.get( Property.GHOST_FILE );
    }



    /**
     */
    public void setLicenseFile(
                    final EntityStateBool licenseFile
                    )
    {
        _properties.put( Property.LICENSE_FILE, licenseFile );
    }


    public EntityStateBool getLicenseFile()
    {
        return (EntityStateBool)_properties.get( Property.LICENSE_FILE );
    }



    /**
     */
    public void setReadmeFile(
                    final EntityStateBool readmeFile
                    )
    {
        _properties.put( Property.README_FILE, readmeFile );
    }


    public EntityStateBool getReadmeFile()
    {
        return (EntityStateBool)_properties.get( Property.README_FILE );
    }



    //**************************************************************
    //  State
    //**************************************************************

    @Override
    public PlatformEntityType getEntityType()
    {
        return PlatformEntityType.LINUX_RPMVERIFY;
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
        if (!(obj instanceof RpmVerifyState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "rpmverify_state[" + super.toString()
                        + ", " + String.valueOf( _properties )
                        + "]";
    }

}
// RpmVerifyState
