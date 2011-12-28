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
import jp.go.aist.six.oval.model.sc.ItemType;



/**
 * The auditeventpolicy item enumerates the different types of events
 * the system should audit.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class AuditEventPolicyItem
    extends ItemType
{

    private EntityItemAuditType  account_logon;
    //{0..1}

    private EntityItemAuditType  account_management;
    //{0..1}

    private EntityItemAuditType  detailed_tracking;
    //{0..1}

    private EntityItemAuditType  directory_service_access;
    //{0..1}

    private EntityItemAuditType  logon;
    //{0..1}

    private EntityItemAuditType  object_access;
    //{0..1}

    private EntityItemAuditType  policy_change;
    //{0..1}

    private EntityItemAuditType  privilege_use;
    //{0..1}

    private EntityItemAuditType  system;
    //{0..1}



    /**
     * Constructor.
     */
    public AuditEventPolicyItem()
    {
        this( 0 );
    }


    public AuditEventPolicyItem(
                    final int id
                    )
    {
        super( id );

        _oval_platform_type = OvalPlatformType.windows;
        _oval_component_type = OvalComponentType.auditeventpolicy;
    }



    /**
     */
    public void setAccountLogon(
                    final EntityItemAuditType account_logon
                    )
    {
        this.account_logon = account_logon;
    }


    public EntityItemAuditType getAccountLogon()
    {
        return this.account_logon;
    }



    /**
     */
    public void setAccountManagement(
                    final EntityItemAuditType account_management
                    )
    {
        this.account_management = account_management;
    }


    public EntityItemAuditType getAccountManagement()
    {
        return this.account_management;
    }



    /**
     */
    public void setDetailedTracking(
                    final EntityItemAuditType detailed_tracking
                    )
    {
        this.detailed_tracking = detailed_tracking;
    }


    public EntityItemAuditType getDetailedTracking()
    {
        return this.detailed_tracking;
    }



    /**
     */
    public void setDirectoryServiceAccess(
                    final EntityItemAuditType directory_service_access
                    )
    {
        this.directory_service_access = directory_service_access;
    }


    public EntityItemAuditType getDirectoryServiceAccess()
    {
        return this.directory_service_access;
    }



    /**
     */
    public void setLogon(
                    final EntityItemAuditType logon
                    )
    {
        this.logon = logon;
    }


    public EntityItemAuditType getLogon()
    {
        return this.logon;
    }



    /**
     */
    public void setObjectAccess(
                    final EntityItemAuditType object_access
                    )
    {
        this.object_access = object_access;
    }


    public EntityItemAuditType getObjectAccess()
    {
        return this.object_access;
    }



    /**
     */
    public void setPolicyChange(
                    final EntityItemAuditType policy_change
                    )
    {
        this.policy_change = policy_change;
    }


    public EntityItemAuditType getPolicyChange()
    {
        return this.policy_change;
    }



    /**
     */
    public void setPrivilegeUse(
                    final EntityItemAuditType privilege_use
                    )
    {
        this.privilege_use = privilege_use;
    }


    public EntityItemAuditType getPrivilegeUse()
    {
        return this.privilege_use;
    }



    /**
     */
    public void setSystem(
                    final EntityItemAuditType system
                    )
    {
        this.system = system;
    }


    public EntityItemAuditType getSystem()
    {
        return this.system;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "auditeventpolicy_item[" + super.toString()
            + ", account_logon="            + getAccountLogon()
            + ", access_management="        + getAccountManagement()
            + ", detailed_tracking="        + getDetailedTracking()
            + ", directory_service_access=" + getDirectoryServiceAccess()
            + ", logon="                    + getLogon()
            + ", object_access="            + getObjectAccess()
            + ", policy_change="            + getPolicyChange()
            + ", privilege_use="            + getPrivilegeUse()
            + ", system="                   + getSystem()
             + "]";
    }

}
//AuditEventPolicyItem
