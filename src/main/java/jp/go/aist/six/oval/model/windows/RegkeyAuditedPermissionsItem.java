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
import jp.go.aist.six.oval.model.sc.EntityItemStringType;
import jp.go.aist.six.oval.model.sc.ItemType;
import jp.go.aist.six.oval.model.sc.StatusEnumeration;



/**
 * This item stores the audited access rights of a registry key 
 * that a system access control list (SACL) structure grants to a specified trustee.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class RegkeyAuditedPermissionsItem
    extends ItemType
{

    //{0..1}
    private EntityItemRegistryHiveType  hive;
    private EntityItemStringType        key;
    //{nillable="true"}
    private EntityItemStringType        trustee_sid;
    private EntityItemAuditType         standard_delete;
    private EntityItemAuditType         standard_read_control;
    private EntityItemAuditType         standard_write_dac;
    private EntityItemAuditType         standard_write_owner;
    private EntityItemAuditType         standard_syncronize;
    private EntityItemAuditType         access_system_security;
    private EntityItemAuditType         generic_read;
    private EntityItemAuditType         generic_write;
    private EntityItemAuditType         generic_execute;
    private EntityItemAuditType         generic_all;
    private EntityItemAuditType         key_query_value;
    private EntityItemAuditType         key_set_value;
    private EntityItemAuditType         key_create_sub_key;
    private EntityItemAuditType         key_enumerate_sub_keys;
    private EntityItemAuditType         key_notify;
    private EntityItemAuditType         key_create_link;
    private EntityItemAuditType         key_wow64_64key;
    private EntityItemAuditType         key_wow64_32key;
    private EntityItemAuditType         key_wow64_res;

    private EntityItemWindowsViewType   windows_view;
    //{0..1}



    /**
     * Constructor.
     */
    public RegkeyAuditedPermissionsItem()
    {
        this( 0 );
    }


    public RegkeyAuditedPermissionsItem(
                    final int id
                    )
    {
        this( id, null );
    }


    public RegkeyAuditedPermissionsItem(
                    final int id,
                    final StatusEnumeration status
                    )
    {
        super( id, status );
        
        _oval_platform_type = OvalPlatformType.windows;
        _oval_component_type = OvalComponentType.regkeyauditedpermissions;
    }



    /**
     */
    public void setHive(
                    final EntityItemRegistryHiveType hive
                    )
    {
        this.hive = hive;
    }


    public EntityItemRegistryHiveType getHive()
    {
        return this.hive;
    }



    /**
     */
    public void setKey(
                    final EntityItemStringType key
                    )
    {
        this.key = key;
    }


    public EntityItemStringType getKey()
    {
        return this.key;
    }



    /**
     */
    public void setTrusteeSid(
                    final EntityItemStringType trustee_sid
                    )
    {
        this.trustee_sid = trustee_sid;
    }


    public EntityItemStringType getTrusteeSid()
    {
        return this.trustee_sid;
    }



    /**
     */
    public void setStandardDelete(
                    final EntityItemAuditType standard_delete
                    )
    {
        this.standard_delete = standard_delete;
    }


    public EntityItemAuditType getStandardDelete()
    {
        return this.standard_delete;
    }



    /**
     */
    public void setStandardReadControl(
                    final EntityItemAuditType standard_read_control
                    )
    {
        this.standard_read_control = standard_read_control;
    }


    public EntityItemAuditType getStandardReadControl()
    {
        return this.standard_read_control;
    }



    /**
     */
    public void setStandardWriteDac(
                    final EntityItemAuditType standard_write_dac
                    )
    {
        this.standard_write_dac = standard_write_dac;
    }


    public EntityItemAuditType getStandardWriteDac()
    {
        return this.standard_write_dac;
    }



    /**
     */
    public void setStandardWriteOwner(
                    final EntityItemAuditType standard_write_owner
                    )
    {
        this.standard_write_owner = standard_write_owner;
    }


    public EntityItemAuditType getStandardWriteOwner()
    {
        return this.standard_write_owner;
    }



    /**
     */
    public void setStandardSyncronize(
                    final EntityItemAuditType standard_syncronize
                    )
    {
        this.standard_syncronize = standard_syncronize;
    }


    public EntityItemAuditType getStandardSyncronize()
    {
        return this.standard_syncronize;
    }



    /**
     */
    public void setAccessSystemSecurity(
                    final EntityItemAuditType access_system_security
                    )
    {
        this.access_system_security = access_system_security;
    }


    public EntityItemAuditType getAccessSystemSecurity()
    {
        return this.access_system_security;
    }



    /**
     */
    public void setGenericRead(
                    final EntityItemAuditType generic_read
                    )
    {
        this.generic_read = generic_read;
    }


    public EntityItemAuditType getGenericRead()
    {
        return this.generic_read;
    }



    /**
     */
    public void setGenericWrite(
                    final EntityItemAuditType generic_write
                    )
    {
        this.generic_write = generic_write;
    }


    public EntityItemAuditType getGenericWrite()
    {
        return this.generic_write;
    }



    /**
     */
    public void setGenericExecute(
                    final EntityItemAuditType generic_execute
                    )
    {
        this.generic_execute = generic_execute;
    }


    public EntityItemAuditType getGenericExecute()
    {
        return this.generic_execute;
    }



    /**
     */
    public void setGenericAll(
                    final EntityItemAuditType generic_all
                    )
    {
        this.generic_all = generic_all;
    }


    public EntityItemAuditType getGenericAll()
    {
        return this.generic_all;
    }



    /**
     */
    public void setKeyQueryValue(
                    final EntityItemAuditType key_query_value
                    )
    {
        this.key_query_value = key_query_value;
    }


    public EntityItemAuditType getKeyQueryValue()
    {
        return this.key_query_value;
    }



    /**
     */
    public void setKeySetValue(
                    final EntityItemAuditType key_set_value
                    )
    {
        this.key_set_value = key_set_value;
    }


    public EntityItemAuditType getKeySetValue()
    {
        return this.key_set_value;
    }



    /**
     */
    public void setKeyCreateSubKey(
                    final EntityItemAuditType key_create_sub_key
                    )
    {
        this.key_create_sub_key = key_create_sub_key;
    }


    public EntityItemAuditType getKeyCreateSubKey()
    {
        return this.key_create_sub_key;
    }



    /**
     */
    public void setKeyEnumerateSubKeys(
                    final EntityItemAuditType key_enumerate_sub_keys
                    )
    {
        this.key_enumerate_sub_keys = key_enumerate_sub_keys;
    }


    public EntityItemAuditType getKeyEnumerateSubKeys()
    {
        return this.key_enumerate_sub_keys;
    }



    /**
     */
    public void setKeyNotify(
                    final EntityItemAuditType key_notify
                    )
    {
        this.key_notify = key_notify;
    }


    public EntityItemAuditType getKeyNotify()
    {
        return this.key_notify;
    }



    /**
     */
    public void setKeyCreateLink(
                    final EntityItemAuditType key_create_link
                    )
    {
        this.key_create_link = key_create_link;
    }


    public EntityItemAuditType getKeyCreateLink()
    {
        return this.key_create_link;
    }



    /**
     */
    public void setKeyWow6464key(
                    final EntityItemAuditType key_wow64_64key
                    )
    {
        this.key_wow64_64key = key_wow64_64key;
    }


    public EntityItemAuditType getKeyWow6464key()
    {
        return this.key_wow64_64key;
    }



    /**
     */
    public void setKeyWow6432key(
                    final EntityItemAuditType key_wow64_32key
                    )
    {
        this.key_wow64_32key = key_wow64_32key;
    }


    public EntityItemAuditType getKeyWow6432key()
    {
        return this.key_wow64_32key;
    }



    /**
     */
    public void setKeyWow64Res(
                    final EntityItemAuditType key_wow64_res
                    )
    {
        this.key_wow64_res = key_wow64_res;
    }


    public EntityItemAuditType getKeyWow64Res()
    {
        return this.key_wow64_res;
    }



    /**
     */
    public void setWindowsView(
                    final EntityItemWindowsViewType windows_view
                    )
    {
        this.windows_view = windows_view;
    }


    public EntityItemWindowsViewType getWindowsView()
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
        if (!(obj instanceof RegkeyAuditedPermissionsItem)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "fileauditedpermissions_item[" + super.toString()
                        + ", hive="                + getHive()
                        + ", key="                    + getKey()
                        + ", trustee_sid="             + getTrusteeSid()
                        + ", standard_delete="         + getStandardDelete()
                        + ", standard_read_control="   + getStandardReadControl()
                        + ", standard_write_dac="      + getStandardWriteDac()
                        + ", standard_write_owner="    + getStandardWriteOwner()
                        + ", standard_syncronize="     + getStandardSyncronize()
                        + ", access_system_security="  + getAccessSystemSecurity()
                        + ", generic_read="            + getGenericRead()
                        + ", generic_write="           + getGenericWrite()
                        + ", generic_execute="         + getGenericExecute()
                        + ", generic_all="             + getGenericAll()
                        + ", key_query_value="         + getKeyQueryValue()
                        + ", key_set_value="           + getKeySetValue()
                        + ", key_create_sub_key="      + getKeyCreateSubKey()
                        + ", key_enumerate_sub_keys="  + getKeyEnumerateSubKeys()
                        + ", key_notify="              + getKeyNotify()
                        + ", key_create_link="         + getKeyCreateLink()
                        + ", key_wow64_64key="         + getKeyWow6464key()
                        + ", key_wow64_32key="         + getKeyWow6432key()
                        + ", key_wow64_res="           + getKeyWow64Res()
                        + ", windows_view="            + getWindowsView()
             + "]";
    }
}
//RegkeyAuditedPermissionsItem
