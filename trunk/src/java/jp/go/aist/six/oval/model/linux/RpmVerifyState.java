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
import java.util.Iterator;
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
        _setStateProperty( Property.NAME, name );
    }


    public EntityStateString getName()
    {
        return _getStateProperty( Property.NAME, EntityStateString.class );
    }



    /**
     */
    public void setFilepath(
                    final EntityStateString filepath
                    )
    {
        _setStateProperty( Property.FILEPATH, filepath );
    }


    public EntityStateString getFilepath()
    {
        return _getStateProperty( Property.FILEPATH, EntityStateString.class );
    }



    /**
     */
    public void setSizeDiffers(
                    final EntityStateRpmVerifyResult sizeDiffers
                    )
    {
        _setStateProperty( Property.SIZE_DIFFERS, sizeDiffers );
    }


    public EntityStateRpmVerifyResult getSizeDiffers()
    {
        return _getStateProperty( Property.SIZE_DIFFERS, EntityStateRpmVerifyResult.class );
    }



    /**
     */
    public void setModeDiffers(
                    final EntityStateRpmVerifyResult modeDiffers
                    )
    {
        _setStateProperty( Property.MODE_DIFFERS, modeDiffers );
    }


    public EntityStateRpmVerifyResult getModeDiffers()
    {
        return _getStateProperty( Property.MODE_DIFFERS, EntityStateRpmVerifyResult.class );
    }



    /**
     */
    public void setMd5Differs(
                    final EntityStateRpmVerifyResult md5Differs
                    )
    {
        _setStateProperty( Property.MD5_DIFFERS, md5Differs );
    }


    public EntityStateRpmVerifyResult getMd5Differs()
    {
        return _getStateProperty( Property.MD5_DIFFERS, EntityStateRpmVerifyResult.class );
    }



    /**
     */
    public void setDeviceDiffers(
                    final EntityStateRpmVerifyResult deviceDiffers
                    )
    {
        _setStateProperty( Property.DEVICE_DIFFERS, deviceDiffers );
    }


    public EntityStateRpmVerifyResult getDeviceDiffers()
    {
        return _getStateProperty( Property.DEVICE_DIFFERS, EntityStateRpmVerifyResult.class );
    }



    /**
     */
    public void setLinkMismatch(
                    final EntityStateRpmVerifyResult linkMismatch
                    )
    {
        _setStateProperty( Property.LINK_MISMATCH, linkMismatch );
    }


    public EntityStateRpmVerifyResult getLinkMismatch()
    {
        return _getStateProperty( Property.LINK_MISMATCH, EntityStateRpmVerifyResult.class );
    }



    /**
     */
    public void setOwnershipDiffers(
                    final EntityStateRpmVerifyResult ownershipDiffers
                    )
    {
        _setStateProperty( Property.OWNERSHIP_DIFFERS, ownershipDiffers );
    }


    public EntityStateRpmVerifyResult getOwnershipDiffers()
    {
        return _getStateProperty( Property.OWNERSHIP_DIFFERS, EntityStateRpmVerifyResult.class );
    }



    /**
     */
    public void setGroupDiffers(
                    final EntityStateRpmVerifyResult groupDiffers
                    )
    {
        _setStateProperty( Property.GROUP_DIFFERS, groupDiffers );
    }


    public EntityStateRpmVerifyResult getGroupDiffers()
    {
        return _getStateProperty( Property.GROUP_DIFFERS, EntityStateRpmVerifyResult.class );
    }



    /**
     */
    public void setMtimeDiffers(
                    final EntityStateRpmVerifyResult mtimeDiffers
                    )
    {
        _setStateProperty( Property.MTIME_DIFFERS, mtimeDiffers );
    }


    public EntityStateRpmVerifyResult getMtimeDiffers()
    {
        return _getStateProperty( Property.MTIME_DIFFERS, EntityStateRpmVerifyResult.class );
    }



    /**
     */
    public void setCapabilitiesDiffers(
                    final EntityStateRpmVerifyResult capabilitiesDiffers
                    )
    {
        _setStateProperty( Property.CAPABILITIES_DIFFERS, capabilitiesDiffers );
    }


    public EntityStateRpmVerifyResult getCapabilitiesDiffers()
    {
        return _getStateProperty( Property.CAPABILITIES_DIFFERS, EntityStateRpmVerifyResult.class );
    }



    /**
     */
    public void setConfigurationFile(
                    final EntityStateBool configurationFile
                    )
    {
        _setStateProperty( Property.CONFIGURATION_FILE, configurationFile );
    }


    public EntityStateBool getConfigurationFile()
    {
        return _getStateProperty( Property.CONFIGURATION_FILE, EntityStateBool.class );
    }



    /**
     */
    public void setDocumentationFile(
                    final EntityStateBool documentationFile
                    )
    {
        _setStateProperty( Property.DOCUMENTATION_FILE, documentationFile );
    }


    public EntityStateBool getDocumentationFile()
    {
        return _getStateProperty( Property.DOCUMENTATION_FILE, EntityStateBool.class );
    }



    /**
     */
    public void setGhostFile(
                    final EntityStateBool ghostFile
                    )
    {
        _setStateProperty( Property.GHOST_FILE, ghostFile );
    }


    public EntityStateBool getGhostFile()
    {
        return _getStateProperty( Property.GHOST_FILE, EntityStateBool.class );
    }



    /**
     */
    public void setLicenseFile(
                    final EntityStateBool licenseFile
                    )
    {
        _setStateProperty( Property.LICENSE_FILE, licenseFile );
    }


    public EntityStateBool getLicenseFile()
    {
        return _getStateProperty( Property.LICENSE_FILE, EntityStateBool.class );
    }



    /**
     */
    public void setReadmeFile(
                    final EntityStateBool readmeFile
                    )
    {
        _setStateProperty( Property.README_FILE, readmeFile );
    }


    public EntityStateBool getReadmeFile()
    {
        return _getStateProperty( Property.README_FILE, EntityStateBool.class );
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
    public Iterator<EntityStateBase> iterateProperties()
    {
        return _properties.values().iterator();
    }



    protected <T extends EntityStateBase> T _getStateProperty(
                    final Property key,
                    final Class<T> type
                    )
    {
        EntityStateBase  p = _properties.get( key );
        return type.cast( p );
    }



    protected void _setStateProperty(
                    final Property key,
                    final EntityStateBase value
                    )
    {
        _properties.put( key, value );
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
