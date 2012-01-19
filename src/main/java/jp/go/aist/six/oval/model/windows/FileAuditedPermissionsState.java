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

package jp.go.aist.six.oval.model.windows;

import jp.go.aist.six.oval.model.OvalComponentType;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.definitions.StateType;



/**
 * The fileauditedpermissions53_state defines the different audit permissions 
 * that can be associated with a given fileauditedpermissions53_object. 
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 * @deprecated Deprecated as of version 5.3:
 *             Replaced by the fileauditedpermissions53 state and
 *             will be removed in version 6.0 of the language.
 */
public class FileAuditedPermissionsState
    extends StateType
{

    //{0..1}
    private EntityStateStringType   path;
    private EntityStateStringType   filename;
    private EntityStateStringType   trustee_name;
    private EntityStateAuditType    standard_delete;
    private EntityStateAuditType    standard_read_control;
    private EntityStateAuditType    standard_write_doc;
    private EntityStateAuditType    standard_write_owner;
    private EntityStateAuditType    standard_syncronize;
    private EntityStateAuditType    access_system_security;
    private EntityStateAuditType    generic_read;
    private EntityStateAuditType    generic_write;
    private EntityStateAuditType    generic_execute;
    private EntityStateAuditType    generic_all;
    private EntityStateAuditType    file_read_data;
    private EntityStateAuditType    file_write_data;
    private EntityStateAuditType    file_append_data;
    private EntityStateAuditType    file_read_ea;
    private EntityStateAuditType    file_write_ea;
    private EntityStateAuditType    file_execute;
    private EntityStateAuditType    file_delete_child;
    private EntityStateAuditType    file_read_attributes;
    private EntityStateAuditType    file_write_attributes;

    private EntityStateWindowsViewType  windows_view;
    //{0..1}



    /**
     * Constructor.
     */
    public FileAuditedPermissionsState()
    {
        this( null, 0 );
    }


    public FileAuditedPermissionsState(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public FileAuditedPermissionsState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

        _oval_platform_type = OvalPlatformType.windows;
        _oval_component_type = OvalComponentType.fileauditedpermissions;
    }



    /**
     */
    public void setPath(
                    final EntityStateStringType path
                    )
    {
        this.path = path;
    }


    public EntityStateStringType getPath()
    {
        return this.path;
    }



    /**
     */
    public void setFilename(
                    final EntityStateStringType filename
                    )
    {
        this.filename = filename;
    }


    public EntityStateStringType getFilename()
    {
        return this.filename;
    }



    /**
     */
    public void setTrusteeName(
                    final EntityStateStringType trustee_name
                    )
    {
        this.trustee_name = trustee_name;
    }


    public EntityStateStringType getTrusteeName()
    {
        return this.trustee_name;
    }



    /**
     */
    public void setStandardDelete(
                    final EntityStateAuditType standard_delete
                    )
    {
        this.standard_delete = standard_delete;
    }


    public EntityStateAuditType getStandardDelete()
    {
        return this.standard_delete;
    }



    /**
     */
    public void setStandardReadControl(
                    final EntityStateAuditType standard_read_control
                    )
    {
        this.standard_read_control = standard_read_control;
    }


    public EntityStateAuditType getStandardReadControl()
    {
        return this.standard_read_control;
    }



    /**
     */
    public void setStandardWriteDoc(
                    final EntityStateAuditType standard_write_doc
                    )
    {
        this.standard_write_doc = standard_write_doc;
    }


    public EntityStateAuditType getStandardWriteDoc()
    {
        return this.standard_write_doc;
    }



    /**
     */
    public void setStandardWriteOwner(
                    final EntityStateAuditType standard_write_owner
                    )
    {
        this.standard_write_owner = standard_write_owner;
    }


    public EntityStateAuditType getStandardWriteOwner()
    {
        return this.standard_write_owner;
    }



    /**
     */
    public void setStandardSyncronize(
                    final EntityStateAuditType standard_syncronize
                    )
    {
        this.standard_syncronize = standard_syncronize;
    }


    public EntityStateAuditType getStandardSyncronize()
    {
        return this.standard_syncronize;
    }



    /**
     */
    public void setAccessSystemSecurity(
                    final EntityStateAuditType access_system_security
                    )
    {
        this.access_system_security = access_system_security;
    }


    public EntityStateAuditType getAccessSystemSecurity()
    {
        return this.access_system_security;
    }



    /**
     */
    public void setGenericRead(
                    final EntityStateAuditType generic_read
                    )
    {
        this.generic_read = generic_read;
    }


    public EntityStateAuditType getGenericRead()
    {
        return this.generic_read;
    }



    /**
     */
    public void setGenericWrite(
                    final EntityStateAuditType generic_write
                    )
    {
        this.generic_write = generic_write;
    }


    public EntityStateAuditType getGenericWrite()
    {
        return this.generic_write;
    }



    /**
     */
    public void setGenericExecute(
                    final EntityStateAuditType generic_execute
                    )
    {
        this.generic_execute = generic_execute;
    }


    public EntityStateAuditType getGenericExecute()
    {
        return this.generic_execute;
    }



    /**
     */
    public void setGenericAll(
                    final EntityStateAuditType generic_all
                    )
    {
        this.generic_all = generic_all;
    }


    public EntityStateAuditType getGenericAll()
    {
        return this.generic_all;
    }



    /**
     */
    public void setFileReadData(
                    final EntityStateAuditType file_read_data
                    )
    {
        this.file_read_data = file_read_data;
    }


    public EntityStateAuditType getFileReadData()
    {
        return this.file_read_data;
    }



    /**
     */
    public void setFileWriteData(
                    final EntityStateAuditType file_write_data
                    )
    {
        this.file_write_data = file_write_data;
    }


    public EntityStateAuditType getFileWriteData()
    {
        return this.file_write_data;
    }



    /**
     */
    public void setFileAppendData(
                    final EntityStateAuditType file_append_data
                    )
    {
        this.file_append_data = file_append_data;
    }


    public EntityStateAuditType getFileAppendData()
    {
        return this.file_append_data;
    }



    /**
     */
    public void setFileReadEa(
                    final EntityStateAuditType file_read_ea
                    )
    {
        this.file_read_ea = file_read_ea;
    }


    public EntityStateAuditType getFileReadEa()
    {
        return this.file_read_ea;
    }



    /**
     */
    public void setFileWriteEa(
                    final EntityStateAuditType file_write_ea
                    )
    {
        this.file_write_ea = file_write_ea;
    }


    public EntityStateAuditType getFileWriteEa()
    {
        return this.file_write_ea;
    }



    /**
     */
    public void setFileExecute(
                    final EntityStateAuditType file_execute
                    )
    {
        this.file_execute = file_execute;
    }


    public EntityStateAuditType getFileExecute()
    {
        return this.file_execute;
    }



    /**
     */
    public void setFileDeleteChild(
                    final EntityStateAuditType file_delete_child
                    )
    {
        this.file_delete_child = file_delete_child;
    }


    public EntityStateAuditType getFileDeleteChild()
    {
        return this.file_delete_child;
    }



    /**
     */
    public void setFileReadAttributes(
                    final EntityStateAuditType file_read_attributes
                    )
    {
        this.file_read_attributes = file_read_attributes;
    }


    public EntityStateAuditType getFileReadAttributes()
    {
        return this.file_read_attributes;
    }



    /**
     */
    public void setFileWriteAttributes(
                    final EntityStateAuditType file_write_attributes
                    )
    {
        this.file_write_attributes = file_write_attributes;
    }


    public EntityStateAuditType getFileWriteAttributes()
    {
        return this.file_write_attributes;
    }



    /**
     */
    public void setWindowsView(
                    final EntityStateWindowsViewType windows_view
                    )
    {
        this.windows_view = windows_view;
    }


    public EntityStateWindowsViewType getWindowsView()
    {
        return this.windows_view;
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
        if (!(obj instanceof FileAuditedPermissionsState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "fileauditedpermissions_state[" + super.toString()
             + ", path="                    + getPath()
             + ", filename="                + getFilename()
             + ", trustee_name="            + getTrusteeName()
             + ", standard_delete="         + getStandardDelete()
             + ", standard_read_control="   + getStandardReadControl()
             + ", standard_write_doc="      + getStandardWriteDoc()
             + ", standard_write_owner="    + getStandardWriteOwner()
             + ", standard_syncronize="     + getStandardSyncronize()
             + ", access_system_security="  + getAccessSystemSecurity()
             + ", generic_read="            + getGenericRead()
             + ", generic_write="           + getGenericWrite()
             + ", generic_execute="         + getGenericExecute()
             + ", generic_all="             + getGenericAll()
             + ", file_read_data="          + getFileReadData()
             + ", file_write_data="         + getFileWriteData()
             + ", file_append_data="        + getFileAppendData()
             + ", file_read_ea="            + getFileReadEa()
             + ", file_write_ea="           + getFileWriteEa()
             + ", file_execute="            + getFileExecute()
             + ", file_delete_child="       + getFileDeleteChild()
             + ", file_read_attributes="    + getFileReadAttributes()
             + ", file_write_attributes="   + getFileWriteAttributes()
             + ", windows_view="            + getWindowsView()
             + "]";
    }
}
//FileAuditedPermissionsState
