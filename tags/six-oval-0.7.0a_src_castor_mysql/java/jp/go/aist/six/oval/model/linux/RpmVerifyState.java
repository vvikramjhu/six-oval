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
import jp.go.aist.six.oval.model.definitions.EntityBase;
import jp.go.aist.six.oval.model.definitions.EntityPropertyMap;
import jp.go.aist.six.oval.model.definitions.EntityStateBool;
import jp.go.aist.six.oval.model.definitions.EntityStateString;
import jp.go.aist.six.oval.model.definitions.State;
import java.util.Iterator;



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

    private EntityPropertyMap<RpmVerifyProperty>  _properties =
        RpmVerifyProperty.createPropertyMap();



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
        _properties.setProperty( RpmVerifyProperty.NAME, name );
    }


    public EntityStateString getName()
    {
        return _properties.getProperty(
                        RpmVerifyProperty.NAME, EntityStateString.class );
    }



    /**
     */
    public void setFilepath(
                    final EntityStateString filepath
                    )
    {
        _properties.setProperty( RpmVerifyProperty.FILEPATH, filepath );
    }


    public EntityStateString getFilepath()
    {
        return _properties.getProperty(
                        RpmVerifyProperty.FILEPATH, EntityStateString.class );
    }



    /**
     */
    public void setSizeDiffers(
                    final EntityStateRpmVerifyResult sizeDiffers
                    )
    {
        _properties.setProperty( RpmVerifyProperty.SIZE_DIFFERS, sizeDiffers );
    }


    public EntityStateRpmVerifyResult getSizeDiffers()
    {
        return _properties.getProperty(
                        RpmVerifyProperty.SIZE_DIFFERS, EntityStateRpmVerifyResult.class );
    }



    /**
     */
    public void setModeDiffers(
                    final EntityStateRpmVerifyResult modeDiffers
                    )
    {
        _properties.setProperty( RpmVerifyProperty.MODE_DIFFERS, modeDiffers );
    }


    public EntityStateRpmVerifyResult getModeDiffers()
    {
        return _properties.getProperty(
                        RpmVerifyProperty.MODE_DIFFERS, EntityStateRpmVerifyResult.class );
    }



    /**
     */
    public void setMd5Differs(
                    final EntityStateRpmVerifyResult md5Differs
                    )
    {
        _properties.setProperty( RpmVerifyProperty.MD5_DIFFERS, md5Differs );
    }


    public EntityStateRpmVerifyResult getMd5Differs()
    {
        return _properties.getProperty(
                        RpmVerifyProperty.MD5_DIFFERS, EntityStateRpmVerifyResult.class );
    }



    /**
     */
    public void setDeviceDiffers(
                    final EntityStateRpmVerifyResult deviceDiffers
                    )
    {
        _properties.setProperty( RpmVerifyProperty.DEVICE_DIFFERS, deviceDiffers );
    }


    public EntityStateRpmVerifyResult getDeviceDiffers()
    {
        return _properties.getProperty(
                        RpmVerifyProperty.DEVICE_DIFFERS, EntityStateRpmVerifyResult.class );
    }



    /**
     */
    public void setLinkMismatch(
                    final EntityStateRpmVerifyResult linkMismatch
                    )
    {
        _properties.setProperty( RpmVerifyProperty.LINK_MISMATCH, linkMismatch );
    }


    public EntityStateRpmVerifyResult getLinkMismatch()
    {
        return _properties.getProperty(
                        RpmVerifyProperty.LINK_MISMATCH, EntityStateRpmVerifyResult.class );
    }



    /**
     */
    public void setOwnershipDiffers(
                    final EntityStateRpmVerifyResult ownershipDiffers
                    )
    {
        _properties.setProperty( RpmVerifyProperty.OWNERSHIP_DIFFERS, ownershipDiffers );
    }


    public EntityStateRpmVerifyResult getOwnershipDiffers()
    {
        return _properties.getProperty(
                        RpmVerifyProperty.OWNERSHIP_DIFFERS, EntityStateRpmVerifyResult.class );
    }



    /**
     */
    public void setGroupDiffers(
                    final EntityStateRpmVerifyResult groupDiffers
                    )
    {
        _properties.setProperty( RpmVerifyProperty.GROUP_DIFFERS, groupDiffers );
    }


    public EntityStateRpmVerifyResult getGroupDiffers()
    {
        return _properties.getProperty(
                        RpmVerifyProperty.GROUP_DIFFERS, EntityStateRpmVerifyResult.class );
    }



    /**
     */
    public void setMtimeDiffers(
                    final EntityStateRpmVerifyResult mtimeDiffers
                    )
    {
        _properties.setProperty( RpmVerifyProperty.MTIME_DIFFERS, mtimeDiffers );
    }


    public EntityStateRpmVerifyResult getMtimeDiffers()
    {
        return _properties.getProperty(
                        RpmVerifyProperty.MTIME_DIFFERS, EntityStateRpmVerifyResult.class );
    }



    /**
     */
    public void setCapabilitiesDiffers(
                    final EntityStateRpmVerifyResult capabilitiesDiffers
                    )
    {
        _properties.setProperty( RpmVerifyProperty.CAPABILITIES_DIFFERS, capabilitiesDiffers );
    }


    public EntityStateRpmVerifyResult getCapabilitiesDiffers()
    {
        return _properties.getProperty(
                        RpmVerifyProperty.CAPABILITIES_DIFFERS, EntityStateRpmVerifyResult.class );
    }



    /**
     */
    public void setConfigurationFile(
                    final EntityStateBool configurationFile
                    )
    {
        _properties.setProperty( RpmVerifyProperty.CONFIGURATION_FILE, configurationFile );
    }


    public EntityStateBool getConfigurationFile()
    {
        return _properties.getProperty(
                        RpmVerifyProperty.CONFIGURATION_FILE, EntityStateBool.class );
    }



    /**
     */
    public void setDocumentationFile(
                    final EntityStateBool documentationFile
                    )
    {
        _properties.setProperty( RpmVerifyProperty.DOCUMENTATION_FILE, documentationFile );
    }


    public EntityStateBool getDocumentationFile()
    {
        return _properties.getProperty(
                        RpmVerifyProperty.DOCUMENTATION_FILE, EntityStateBool.class );
    }



    /**
     */
    public void setGhostFile(
                    final EntityStateBool ghostFile
                    )
    {
        _properties.setProperty( RpmVerifyProperty.GHOST_FILE, ghostFile );
    }


    public EntityStateBool getGhostFile()
    {
        return _properties.getProperty(
                        RpmVerifyProperty.GHOST_FILE, EntityStateBool.class );
    }



    /**
     */
    public void setLicenseFile(
                    final EntityStateBool licenseFile
                    )
    {
        _properties.setProperty( RpmVerifyProperty.LICENSE_FILE, licenseFile );
    }


    public EntityStateBool getLicenseFile()
    {
        return _properties.getProperty(
                        RpmVerifyProperty.LICENSE_FILE, EntityStateBool.class );
    }



    /**
     */
    public void setReadmeFile(
                    final EntityStateBool readmeFile
                    )
    {
        _properties.setProperty( RpmVerifyProperty.README_FILE, readmeFile );
    }


    public EntityStateBool getReadmeFile()
    {
        return _properties.getProperty(
                        RpmVerifyProperty.README_FILE, EntityStateBool.class );
    }



    //**************************************************************
    //  State
    //**************************************************************

    @Override
    public PlatformEntityType getEntityType()
    {
        return PlatformEntityType.LINUX_RPMVERIFY;
    }



    //**************************************************************
    //  State
    //**************************************************************

    @Override
    public Iterator<EntityBase> iterateProperties()
    {
        return _properties.iterateProperties();
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
