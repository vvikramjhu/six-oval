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

import jp.go.aist.six.oval.model.ComponentType;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.sc.EntityItemBoolType;
import jp.go.aist.six.oval.model.sc.EntityItemStringType;
import jp.go.aist.six.oval.model.sc.ItemType;
import jp.go.aist.six.oval.model.sc.StatusEnumeration;



/**
 * This item stores the effective rights of a registry key
 * that a discretionary access control list (DACL) structure grants to a specified trustee.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class RegkeyEffectiveRightsItem
    extends ItemType
{

    //{0..1}
    private EntityItemRegistryHiveType  hive;
    private EntityItemStringType        key;
    //{nillable="true"}
    private EntityItemStringType        trustee_sid;
    private EntityItemBoolType         standard_delete;
    private EntityItemBoolType         standard_read_control;
    private EntityItemBoolType         standard_write_dac;
    private EntityItemBoolType         standard_write_owner;
    private EntityItemBoolType         standard_syncronize;
    private EntityItemBoolType         access_system_security;
    private EntityItemBoolType         generic_read;
    private EntityItemBoolType         generic_write;
    private EntityItemBoolType         generic_execute;
    private EntityItemBoolType         generic_all;
    private EntityItemBoolType         key_query_value;
    private EntityItemBoolType         key_set_value;
    private EntityItemBoolType         key_create_sub_key;
    private EntityItemBoolType         key_enumerate_sub_keys;
    private EntityItemBoolType         key_notify;
    private EntityItemBoolType         key_create_link;
    private EntityItemBoolType         key_wow64_64key;
    private EntityItemBoolType         key_wow64_32key;
    private EntityItemBoolType         key_wow64_res;

    private EntityItemWindowsViewType   windows_view;
    //{0..1}



    /**
     * Constructor.
     */
    public RegkeyEffectiveRightsItem()
    {
        this( 0 );
    }


    public RegkeyEffectiveRightsItem(
                    final int id
                    )
    {
        this( id, null );
    }


    public RegkeyEffectiveRightsItem(
                    final int id,
                    final StatusEnumeration status
                    )
    {
        super( id, status );

//        _oval_platform_type = OvalPlatformType.windows;
//        _oval_component_type = OvalComponentType.regkeyeffectiverights;
        _oval_family = Family.WINDOWS;
        _oval_component = ComponentType.REGKEYEFFECTIVERIGHTS;
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
        return hive;
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
        return key;
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
        return trustee_sid;
    }



    /**
     */
    public void setStandardDelete(
                    final EntityItemBoolType standard_delete
                    )
    {
        this.standard_delete = standard_delete;
    }


    public EntityItemBoolType getStandardDelete()
    {
        return standard_delete;
    }



    /**
     */
    public void setStandardReadControl(
                    final EntityItemBoolType standard_read_control
                    )
    {
        this.standard_read_control = standard_read_control;
    }


    public EntityItemBoolType getStandardReadControl()
    {
        return standard_read_control;
    }



    /**
     */
    public void setStandardWriteDac(
                    final EntityItemBoolType standard_write_dac
                    )
    {
        this.standard_write_dac = standard_write_dac;
    }


    public EntityItemBoolType getStandardWriteDac()
    {
        return standard_write_dac;
    }



    /**
     */
    public void setStandardWriteOwner(
                    final EntityItemBoolType standard_write_owner
                    )
    {
        this.standard_write_owner = standard_write_owner;
    }


    public EntityItemBoolType getStandardWriteOwner()
    {
        return standard_write_owner;
    }



    /**
     */
    public void setStandardSyncronize(
                    final EntityItemBoolType standard_syncronize
                    )
    {
        this.standard_syncronize = standard_syncronize;
    }


    public EntityItemBoolType getStandardSyncronize()
    {
        return standard_syncronize;
    }



    /**
     */
    public void setAccessSystemSecurity(
                    final EntityItemBoolType access_system_security
                    )
    {
        this.access_system_security = access_system_security;
    }


    public EntityItemBoolType getAccessSystemSecurity()
    {
        return access_system_security;
    }



    /**
     */
    public void setGenericRead(
                    final EntityItemBoolType generic_read
                    )
    {
        this.generic_read = generic_read;
    }


    public EntityItemBoolType getGenericRead()
    {
        return generic_read;
    }



    /**
     */
    public void setGenericWrite(
                    final EntityItemBoolType generic_write
                    )
    {
        this.generic_write = generic_write;
    }


    public EntityItemBoolType getGenericWrite()
    {
        return generic_write;
    }



    /**
     */
    public void setGenericExecute(
                    final EntityItemBoolType generic_execute
                    )
    {
        this.generic_execute = generic_execute;
    }


    public EntityItemBoolType getGenericExecute()
    {
        return generic_execute;
    }



    /**
     */
    public void setGenericAll(
                    final EntityItemBoolType generic_all
                    )
    {
        this.generic_all = generic_all;
    }


    public EntityItemBoolType getGenericAll()
    {
        return generic_all;
    }



    /**
     */
    public void setKeyQueryValue(
                    final EntityItemBoolType key_query_value
                    )
    {
        this.key_query_value = key_query_value;
    }


    public EntityItemBoolType getKeyQueryValue()
    {
        return key_query_value;
    }



    /**
     */
    public void setKeySetValue(
                    final EntityItemBoolType key_set_value
                    )
    {
        this.key_set_value = key_set_value;
    }


    public EntityItemBoolType getKeySetValue()
    {
        return key_set_value;
    }



    /**
     */
    public void setKeyCreateSubKey(
                    final EntityItemBoolType key_create_sub_key
                    )
    {
        this.key_create_sub_key = key_create_sub_key;
    }


    public EntityItemBoolType getKeyCreateSubKey()
    {
        return key_create_sub_key;
    }



    /**
     */
    public void setKeyEnumerateSubKeys(
                    final EntityItemBoolType key_enumerate_sub_keys
                    )
    {
        this.key_enumerate_sub_keys = key_enumerate_sub_keys;
    }


    public EntityItemBoolType getKeyEnumerateSubKeys()
    {
        return key_enumerate_sub_keys;
    }



    /**
     */
    public void setKeyNotify(
                    final EntityItemBoolType key_notify
                    )
    {
        this.key_notify = key_notify;
    }


    public EntityItemBoolType getKeyNotify()
    {
        return key_notify;
    }



    /**
     */
    public void setKeyCreateLink(
                    final EntityItemBoolType key_create_link
                    )
    {
        this.key_create_link = key_create_link;
    }


    public EntityItemBoolType getKeyCreateLink()
    {
        return key_create_link;
    }



    /**
     */
    public void setKeyWow6464key(
                    final EntityItemBoolType key_wow64_64key
                    )
    {
        this.key_wow64_64key = key_wow64_64key;
    }


    public EntityItemBoolType getKeyWow6464key()
    {
        return key_wow64_64key;
    }



    /**
     */
    public void setKeyWow6432key(
                    final EntityItemBoolType key_wow64_32key
                    )
    {
        this.key_wow64_32key = key_wow64_32key;
    }


    public EntityItemBoolType getKeyWow6432key()
    {
        return key_wow64_32key;
    }



    /**
     */
    public void setKeyWow64Res(
                    final EntityItemBoolType key_wow64_res
                    )
    {
        this.key_wow64_res = key_wow64_res;
    }


    public EntityItemBoolType getKeyWow64Res()
    {
        return key_wow64_res;
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
        return windows_view;
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
        if (!(obj instanceof RegkeyEffectiveRightsItem)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "regkeyeffectiverights_item[" + super.toString()
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
//RegkeyEffectiveRightsItem
