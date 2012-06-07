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
 * This item stores the effective rights of a service that
 * a discretionary access control list (DACL) structure grants to a specified trustee.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class ServiceEffectiveRightsItem
    extends ItemType
{

    //{0..1}
    private EntityItemStringType        service_name;
    //{nillable="false"}
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
    private EntityItemBoolType         service_query_conf;
    private EntityItemBoolType         service_change_conf;
    private EntityItemBoolType         service_query_stat;
    private EntityItemBoolType         service_enum_dependents;
    private EntityItemBoolType         service_start;
    private EntityItemBoolType         service_stop;
    private EntityItemBoolType         service_pause;
    private EntityItemBoolType         service_interrogate;
    private EntityItemBoolType         service_user_defined;



    /**
     * Constructor.
     */
    public ServiceEffectiveRightsItem()
    {
        this( 0 );
    }


    public ServiceEffectiveRightsItem(
                    final int id
                    )
    {
        this( id, null );
    }


    public ServiceEffectiveRightsItem(
                    final int id,
                    final StatusEnumeration status
                    )
    {
        super( id, status );

//        _oval_platform_type = OvalPlatformType.windows;
//        _oval_component_type = OvalComponentType.serviceeffectiverights;
        _oval_family = Family.WINDOWS;
        _oval_component = ComponentType.SERVICEEFFECTIVERIGHTS;
    }



    /**
     */
    public void setServiceName(
                    final EntityItemStringType service_name
                    )
    {
        this.service_name = service_name;
    }


    public EntityItemStringType getServiceName()
    {
        return service_name;
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
    public void setServiceQueryConf(
                    final EntityItemBoolType service_query_conf
                    )
    {
        this.service_query_conf = service_query_conf;
    }


    public EntityItemBoolType getServiceQueryConf()
    {
        return service_query_conf;
    }



    /**
     */
    public void setServiceChangeConf(
                    final EntityItemBoolType service_change_conf
                    )
    {
        this.service_change_conf = service_change_conf;
    }


    public EntityItemBoolType getServiceChangeConf()
    {
        return service_change_conf;
    }



    /**
     */
    public void setServiceQueryStat(
                    final EntityItemBoolType service_query_stat
                    )
    {
        this.service_query_stat = service_query_stat;
    }


    public EntityItemBoolType getServiceQueryStat()
    {
        return service_query_stat;
    }



    /**
     */
    public void setServiceEnumDependents(
                    final EntityItemBoolType service_enum_dependents
                    )
    {
        this.service_enum_dependents = service_enum_dependents;
    }


    public EntityItemBoolType getServiceEnumDependents()
    {
        return service_enum_dependents;
    }



    /**
     */
    public void setServiceStart(
                    final EntityItemBoolType service_start
                    )
    {
        this.service_start = service_start;
    }


    public EntityItemBoolType getServiceStart()
    {
        return service_start;
    }



    /**
     */
    public void setServiceStop(
                    final EntityItemBoolType service_stop
                    )
    {
        this.service_stop = service_stop;
    }


    public EntityItemBoolType getServiceStop()
    {
        return service_stop;
    }



    /**
     */
    public void setServicePause(
                    final EntityItemBoolType service_pause
                    )
    {
        this.service_pause = service_pause;
    }


    public EntityItemBoolType getServicePause()
    {
        return service_pause;
    }



    /**
     */
    public void setServiceInterrogate(
                    final EntityItemBoolType service_interrogate
                    )
    {
        this.service_interrogate = service_interrogate;
    }


    public EntityItemBoolType getServiceInterrogate()
    {
        return service_interrogate;
    }



    /**
     */
    public void setServiceUserDefined(
                    final EntityItemBoolType service_user_defined
                    )
    {
        this.service_user_defined = service_user_defined;
    }


    public EntityItemBoolType getServiceUserDefined()
    {
        return service_user_defined;
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
        if (!(obj instanceof ServiceEffectiveRightsItem)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "serviceeffectiverights_item[" + super.toString()
                        + ", key="                    + getServiceName()
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
                        + ", service_query_conf="      + getServiceQueryConf()
                        + ", service_change_conf="     + getServiceChangeConf()
                        + ", service_query_stat="      + getServiceQueryStat()
                        + ", service_enum_dependents=" + getServiceEnumDependents()
                        + ", service_start="           + getServiceStart()
                        + ", service_stop="            + getServiceStop()
                        + ", service_pause="           + getServicePause()
                        + ", service_interrogate="     + getServiceInterrogate()
                        + ", service_user_defined="    + getServiceUserDefined()
             + "]";
    }
}
//ServiceEffectiveRightsItem
