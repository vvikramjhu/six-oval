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

import jp.go.aist.six.oval.model.Component;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.definitions.StateType;



/**
 * The auditeventpolicy state specifies the different system activities
 * that can be audited.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class AuditEventPolicyState
    extends StateType
{

    private EntityStateAuditType  account_logon;
    //{0..1}

    private EntityStateAuditType  account_management;
    //{0..1}

    private EntityStateAuditType  detailed_tracking;
    //{0..1}

    private EntityStateAuditType  directory_service_access;
    //{0..1}

    private EntityStateAuditType  logon;
    //{0..1}

    private EntityStateAuditType  object_access;
    //{0..1}

    private EntityStateAuditType  policy_change;
    //{0..1}

    private EntityStateAuditType  privilege_use;
    //{0..1}

    private EntityStateAuditType  system;
    //{0..1}



//    private final EntityPropertyMap<RegistryProperty>  _properties =
//        RegistryProperty.createPropertyMap();



    /**
     * Constructor.
     */
    public AuditEventPolicyState()
    {
        this( null, 0 );
    }


    public AuditEventPolicyState(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public AuditEventPolicyState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

//        _oval_platform_type = OvalPlatformType.windows;
//        _oval_component_type = OvalComponentType.auditeventpolicy;
        _oval_family = Family.WINDOWS;
        _oval_component = Component.AUDITEVENTPOLICY;
    }



    /**
     */
    public void setAccountLogon(
                    final EntityStateAuditType account_logon
                    )
    {
        this.account_logon = account_logon;
    }


    public EntityStateAuditType getAccountLogon()
    {
        return account_logon;
    }



    /**
     */
    public void setAccountManagement(
                    final EntityStateAuditType account_management
                    )
    {
        this.account_management = account_management;
    }


    public EntityStateAuditType getAccountManagement()
    {
        return account_management;
    }



    /**
     */
    public void setDetailedTracking(
                    final EntityStateAuditType detailed_tracking
                    )
    {
        this.detailed_tracking = detailed_tracking;
    }


    public EntityStateAuditType getDetailedTracking()
    {
        return detailed_tracking;
    }



    /**
     */
    public void setDirectoryServiceAccess(
                    final EntityStateAuditType directory_service_access
                    )
    {
        this.directory_service_access = directory_service_access;
    }


    public EntityStateAuditType getDirectoryServiceAccess()
    {
        return directory_service_access;
    }



    /**
     */
    public void setLogon(
                    final EntityStateAuditType logon
                    )
    {
        this.logon = logon;
    }


    public EntityStateAuditType getLogon()
    {
        return logon;
    }



    /**
     */
    public void setObjectAccess(
                    final EntityStateAuditType object_access
                    )
    {
        this.object_access = object_access;
    }


    public EntityStateAuditType getObjectAccess()
    {
        return object_access;
    }



    /**
     */
    public void setPolicyChange(
                    final EntityStateAuditType policy_change
                    )
    {
        this.policy_change = policy_change;
    }


    public EntityStateAuditType getPolicyChange()
    {
        return policy_change;
    }



    /**
     */
    public void setPrivilegeUse(
                    final EntityStateAuditType privilege_use
                    )
    {
        this.privilege_use = privilege_use;
    }


    public EntityStateAuditType getPrivilegeUse()
    {
        return privilege_use;
    }



    /**
     */
    public void setSystem(
                    final EntityStateAuditType system
                    )
    {
        this.system = system;
    }


    public EntityStateAuditType getSystem()
    {
        return system;
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
        if (!(obj instanceof AuditEventPolicyState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "auditeventpolicy_state[" + super.toString()
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
//AuditEventPolicyState
