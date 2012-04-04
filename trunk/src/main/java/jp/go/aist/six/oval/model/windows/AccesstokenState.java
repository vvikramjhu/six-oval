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
import jp.go.aist.six.oval.model.definitions.EntityStateBoolType;
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.definitions.StateType;



/**
 * The accesstoken state defines the different information
 * that can be used to evaluate the specified access tokens.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class AccesstokenState
    extends StateType
{

    //{0..1}
    private EntityStateStringType   security_principle;
    private EntityStateBoolType     seassignprimarytokenprivilege;
    private EntityStateBoolType     sechangenotifyprivilege;
    private EntityStateBoolType     secreateglobalprivilege;
    private EntityStateBoolType     secreatepagefileprivilege;
    private EntityStateBoolType     secreatepermanentprivilege;
    private EntityStateBoolType     secreatesymboliclinkprivilege;
    private EntityStateBoolType     secreatetokenprivilege;
    private EntityStateBoolType     sedebugprivilege;
    private EntityStateBoolType     seenabledelegationprivilege;
    private EntityStateBoolType     seimpersonateprivilege;
    private EntityStateBoolType     seincreasebasepriorityprivilege;
    private EntityStateBoolType     seincreasequotaprivilege;
    private EntityStateBoolType     seincreaseworkingsetprivilege;
    private EntityStateBoolType     seloaddriverprivilege;
    private EntityStateBoolType     selockmemoryprivilege;
    private EntityStateBoolType     semachineaccountprivilege;
    private EntityStateBoolType     semanagevolumeprivilege;
    private EntityStateBoolType     seprofilesingleprocessprivilege;
    private EntityStateBoolType     serelabelprivilege;
    private EntityStateBoolType     seremoteshutdownprivilege;
    private EntityStateBoolType     serestoreprivilege;
    private EntityStateBoolType     sesecurityprivilege;
    private EntityStateBoolType     seshutdownprivilege;
    private EntityStateBoolType     sesyncagentprivilege;
    private EntityStateBoolType     sesystemenvironmentprivilege;
    private EntityStateBoolType     sesystemprofileprivilege;
    private EntityStateBoolType    sesystemtimeprivilege;
    private EntityStateBoolType    setakeownershipprivilege;
    private EntityStateBoolType    setcbprivilege;
    private EntityStateBoolType    setimezoneprivilege;
    private EntityStateBoolType    seundockprivilege;
    private EntityStateBoolType    seunsolicitedinputprivilege;
    private EntityStateBoolType    sebatchlogonright;
    private EntityStateBoolType    seinteractivelogonright;
    private EntityStateBoolType    senetworklogonright;
    private EntityStateBoolType    seremoteinteractivelogonright;
    private EntityStateBoolType    seservicelogonright;
    private EntityStateBoolType    sedenybatchLogonright;
    private EntityStateBoolType    sedenyinteractivelogonright;
    private EntityStateBoolType    sedenynetworklogonright;
    private EntityStateBoolType    sedenyremoteInteractivelogonright;
    private EntityStateBoolType    sedenyservicelogonright;
    private EntityStateBoolType    setrustedcredmanaccessnameright;



    /**
     * Constructor.
     */
    public AccesstokenState()
    {
        this( null, 0 );
    }


    public AccesstokenState(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public AccesstokenState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

//        _oval_platform_type = OvalPlatformType.windows;
//        _oval_component_type = OvalComponentType.accesstoken;
        _oval_family = Family.WINDOWS;
        _oval_component = Component.ACCESSTOKEN;
    }



    /**
     */
    public void setSecurityPrinciple(
                    final EntityStateStringType security_principle
                    )
    {
        this.security_principle = security_principle;
    }


    public EntityStateStringType getSecurityPrinciple()
    {
        return security_principle;
    }



    /**
     */
    public void setSeassignprimarytokenprivilege(
                    final EntityStateBoolType seassignprimarytokenprivilege
                    )
    {
        this.seassignprimarytokenprivilege = seassignprimarytokenprivilege;
    }


    public EntityStateBoolType getSeassignprimarytokenprivilege()
    {
        return seassignprimarytokenprivilege;
    }



    /**
     */
    public void setSechangenotifyprivilege(
                    final EntityStateBoolType sechangenotifyprivilege
                    )
    {
        this.sechangenotifyprivilege = sechangenotifyprivilege;
    }


    public EntityStateBoolType getSechangenotifyprivilege()
    {
        return sechangenotifyprivilege;
    }



    /**
     */
    public void setSecreateglobalprivilege(
                    final EntityStateBoolType secreateglobalprivilege
                    )
    {
        this.secreateglobalprivilege = secreateglobalprivilege;
    }


    public EntityStateBoolType getSecreateglobalprivilege()
    {
        return secreateglobalprivilege;
    }



    /**
     */
    public void setSecreatepagefileprivilege(
                    final EntityStateBoolType secreatepagefileprivilege
                    )
    {
        this.secreatepagefileprivilege = secreatepagefileprivilege;
    }


    public EntityStateBoolType getSecreatepagefileprivilege()
    {
        return secreatepagefileprivilege;
    }



    /**
     */
    public void setSecreatepermanentprivilege(
                    final EntityStateBoolType secreatepermanentprivilege
                    )
    {
        this.secreatepermanentprivilege = secreatepermanentprivilege;
    }


    public EntityStateBoolType getSecreatepermanentprivilege()
    {
        return secreatepermanentprivilege;
    }



    /**
     */
    public void setSecreatesymboliclinkprivilege(
                    final EntityStateBoolType secreatesymboliclinkprivilege
                    )
    {
        this.secreatesymboliclinkprivilege = secreatesymboliclinkprivilege;
    }


    public EntityStateBoolType getSecreatesymboliclinkprivilege()
    {
        return secreatesymboliclinkprivilege;
    }



    /**
     */
    public void setSecreatetokenprivilege(
                    final EntityStateBoolType secreatetokenprivilege
                    )
    {
        this.secreatetokenprivilege = secreatetokenprivilege;
    }


    public EntityStateBoolType getSecreatetokenprivilege()
    {
        return secreatetokenprivilege;
    }



    /**
     */
    public void setSedebugprivilege(
                    final EntityStateBoolType sedebugprivilege
                    )
    {
        this.sedebugprivilege = sedebugprivilege;
    }


    public EntityStateBoolType getSedebugprivilege()
    {
        return sedebugprivilege;
    }



    /**
     */
    public void setSeenabledelegationprivilege(
                    final EntityStateBoolType seenabledelegationprivilege
                    )
    {
        this.seenabledelegationprivilege = seenabledelegationprivilege;
    }


    public EntityStateBoolType getSeenabledelegationprivilege()
    {
        return seenabledelegationprivilege;
    }



    /**
     */
    public void setSeimpersonateprivilege(
                    final EntityStateBoolType seimpersonateprivilege
                    )
    {
        this.seimpersonateprivilege = seimpersonateprivilege;
    }


    public EntityStateBoolType getSeimpersonateprivilege()
    {
        return seimpersonateprivilege;
    }



    /**
     */
    public void setSeincreasebasepriorityprivilege(
                    final EntityStateBoolType seincreasebasepriorityprivilege
                    )
    {
        this.seincreasebasepriorityprivilege = seincreasebasepriorityprivilege;
    }


    public EntityStateBoolType getSeincreasebasepriorityprivilege()
    {
        return seincreasebasepriorityprivilege;
    }



    /**
     */
    public void setSeincreasequotaprivilege(
                    final EntityStateBoolType seincreasequotaprivilege
                    )
    {
        this.seincreasequotaprivilege = seincreasequotaprivilege;
    }


    public EntityStateBoolType getSeincreasequotaprivilege()
    {
        return seincreasequotaprivilege;
    }



    /**
     */
    public void setSeincreaseworkingsetprivilege(
                    final EntityStateBoolType seincreaseworkingsetprivilege
                    )
    {
        this.seincreaseworkingsetprivilege = seincreaseworkingsetprivilege;
    }


    public EntityStateBoolType getSeincreaseworkingsetprivilege()    {
        return seincreaseworkingsetprivilege;
    }



    /**
     */
    public void setSeloaddriverprivilege(
                    final EntityStateBoolType seloaddriverprivilege
                    )
    {
        this.seloaddriverprivilege = seloaddriverprivilege;
    }


    public EntityStateBoolType getSeloaddriverprivilege()    {
        return seloaddriverprivilege;
    }



    /**
     */
    public void setSelockmemoryprivilege(
                    final EntityStateBoolType selockmemoryprivilege
                    )
    {
        this.selockmemoryprivilege = selockmemoryprivilege;
    }


    public EntityStateBoolType getSelockmemoryprivilege()    {
        return selockmemoryprivilege;
    }



    /**
     */
    public void setSemachineaccountprivilege(
                    final EntityStateBoolType semachineaccountprivilege
                    )
    {
        this.semachineaccountprivilege = semachineaccountprivilege;
    }


    public EntityStateBoolType getSemachineaccountprivilege()    {
        return semachineaccountprivilege;
    }



    /**
     */
    public void setSemanagevolumeprivilege(
                    final EntityStateBoolType semanagevolumeprivilege
                    )
    {
        this.semanagevolumeprivilege = semanagevolumeprivilege;
    }


    public EntityStateBoolType getSemanagevolumeprivilege()    {
        return semanagevolumeprivilege;
    }



    /**
     */
    public void setSeprofilesingleprocessprivilege(
                    final EntityStateBoolType seprofilesingleprocessprivilege
                    )
    {
        this.seprofilesingleprocessprivilege = seprofilesingleprocessprivilege;
    }


    public EntityStateBoolType getSeprofilesingleprocessprivilege()    {
        return seprofilesingleprocessprivilege;
    }



    /**
     */
    public void setSerelabelprivilege(
                    final EntityStateBoolType serelabelprivilege
                    )
    {
        this.serelabelprivilege = serelabelprivilege;
    }


    public EntityStateBoolType getSerelabelprivilege()    {
        return serelabelprivilege;
    }



    /**
     */
    public void setSeremoteshutdownprivilege(
                    final EntityStateBoolType seremoteshutdownprivilege
                    )
    {
        this.seremoteshutdownprivilege = seremoteshutdownprivilege;
    }


    public EntityStateBoolType getSeremoteshutdownprivilege()    {
        return seremoteshutdownprivilege;
    }



    /**
     */
    public void setSerestoreprivilege(
                    final EntityStateBoolType serestoreprivilege
                    )
    {
        this.serestoreprivilege = serestoreprivilege;
    }


    public EntityStateBoolType getSerestoreprivilege()    {
        return serestoreprivilege;
    }



    /**
     */
    public void setSesecurityprivilege(
                    final EntityStateBoolType sesecurityprivilege
                    )
    {
        this.sesecurityprivilege = sesecurityprivilege;
    }


    public EntityStateBoolType getSesecurityprivilege()    {
        return sesecurityprivilege;
    }



    /**
     */
    public void setSeshutdownprivilege(
                    final EntityStateBoolType seshutdownprivilege
                    )
    {
        this.seshutdownprivilege = seshutdownprivilege;
    }


    public EntityStateBoolType getSeshutdownprivilege()    {
        return seshutdownprivilege;
    }



    /**
     */
    public void setSesyncagentprivilege(
                    final EntityStateBoolType sesyncagentprivilege
                    )
    {
        this.sesyncagentprivilege = sesyncagentprivilege;
    }


    public EntityStateBoolType getSesyncagentprivilege()    {
        return sesyncagentprivilege;
    }



    /**
     */
    public void setSesystemenvironmentprivilege(
                    final EntityStateBoolType sesystemenvironmentprivilege
                    )
    {
        this.sesystemenvironmentprivilege = sesystemenvironmentprivilege;
    }


    public EntityStateBoolType getSesystemenvironmentprivilege()    {
        return sesystemenvironmentprivilege;
    }



    /**
     */
    public void setSesystemprofileprivilege(
                    final EntityStateBoolType sesystemprofileprivilege
                    )
    {
        this.sesystemprofileprivilege = sesystemprofileprivilege;
    }


    public EntityStateBoolType getSesystemprofileprivilege()    {
        return sesystemprofileprivilege;
    }



    /**
     */
    public void setSesystemtimeprivilege(
                    final EntityStateBoolType sesystemtimeprivilege
                    )
    {
        this.sesystemtimeprivilege = sesystemtimeprivilege;
    }


    public EntityStateBoolType getSesystemtimeprivilege()    {
        return sesystemtimeprivilege;
    }



    /**
     */
    public void setSetakeownershipprivilege(
                    final EntityStateBoolType setakeownershipprivilege
                    )
    {
        this.setakeownershipprivilege = setakeownershipprivilege;
    }


    public EntityStateBoolType getSetakeownershipprivilege()    {
        return setakeownershipprivilege;
    }



    /**
     */
    public void setSetcbprivilege(
                    final EntityStateBoolType setcbprivilege
                    )
    {
        this.setcbprivilege = setcbprivilege;
    }


    public EntityStateBoolType getSetcbprivilege()    {
        return setcbprivilege;
    }



    /**
     */
    public void setSetimezoneprivilege(
                    final EntityStateBoolType setimezoneprivilege
                    )
    {
        this.setimezoneprivilege = setimezoneprivilege;
    }


    public EntityStateBoolType getSetimezoneprivilege()    {
        return setimezoneprivilege;
    }



    /**
     */
    public void setSeundockprivilege(
                    final EntityStateBoolType seundockprivilege
                    )
    {
        this.seundockprivilege = seundockprivilege;
    }


    public EntityStateBoolType getSeundockprivilege()    {
        return seundockprivilege;
    }



    /**
     */
    public void setSeunsolicitedinputprivilege(
                    final EntityStateBoolType seunsolicitedinputprivilege
                    )
    {
        this.seunsolicitedinputprivilege = seunsolicitedinputprivilege;
    }


    public EntityStateBoolType getSeunsolicitedinputprivilege()    {
        return seunsolicitedinputprivilege;
    }



    /**
     */
    public void setSebatchlogonright(
                    final EntityStateBoolType sebatchlogonright
                    )
    {
        this.sebatchlogonright = sebatchlogonright;
    }


    public EntityStateBoolType getSebatchlogonright()    {
        return sebatchlogonright;
    }



    /**
     */
    public void setSeinteractivelogonright(
                    final EntityStateBoolType seinteractivelogonright
                    )
    {
        this.seinteractivelogonright = seinteractivelogonright;
    }


    public EntityStateBoolType getSeinteractivelogonright()    {
        return seinteractivelogonright;
    }



    /**
     */
    public void setSenetworklogonright(
                    final EntityStateBoolType senetworklogonright
                    )
    {
        this.senetworklogonright = senetworklogonright;
    }


    public EntityStateBoolType getSenetworklogonright()    {
        return senetworklogonright;
    }



    /**
     */
    public void setSeremoteinteractivelogonright(
                    final EntityStateBoolType seremoteinteractivelogonright
                    )
    {
        this.seremoteinteractivelogonright = seremoteinteractivelogonright;
    }


    public EntityStateBoolType getSeremoteinteractivelogonright()    {
        return seremoteinteractivelogonright;
    }



    /**
     */
    public void setSeservicelogonright(
                    final EntityStateBoolType seservicelogonright
                    )
    {
        this.seservicelogonright = seservicelogonright;
    }


    public EntityStateBoolType getSeservicelogonright()    {
        return seservicelogonright;
    }



    /**
     */
    public void setSedenybatchLogonright(
                    final EntityStateBoolType sedenybatchLogonright
                    )
    {
        this.sedenybatchLogonright = sedenybatchLogonright;
    }


    public EntityStateBoolType getSedenybatchLogonright()    {
        return sedenybatchLogonright;
    }



    /**
     */
    public void setSedenyinteractivelogonright(
                    final EntityStateBoolType sedenyinteractivelogonright
                    )
    {
        this.sedenyinteractivelogonright = sedenyinteractivelogonright;
    }


    public EntityStateBoolType getSedenyinteractivelogonright()    {
        return sedenyinteractivelogonright;
    }



    /**
     */
    public void setSedenynetworklogonright(
                    final EntityStateBoolType sedenynetworklogonright
                    )
    {
        this.sedenynetworklogonright = sedenynetworklogonright;
    }


    public EntityStateBoolType getSedenynetworklogonright()    {
        return sedenynetworklogonright;
    }



    /**
     */
    public void setSedenyremoteInteractivelogonright(
                    final EntityStateBoolType sedenyremoteInteractivelogonright
                    )
    {
        this.sedenyremoteInteractivelogonright = sedenyremoteInteractivelogonright;
    }


    public EntityStateBoolType getSedenyremoteInteractivelogonright()    {
        return sedenyremoteInteractivelogonright;
    }



    /**
     */
    public void setSedenyservicelogonright(
                    final EntityStateBoolType sedenyservicelogonright
                    )
    {
        this.sedenyservicelogonright = sedenyservicelogonright;
    }


    public EntityStateBoolType getSedenyservicelogonright()    {
        return sedenyservicelogonright;
    }



    /**
     */
    public void setSetrustedcredmanaccessnameright(
                    final EntityStateBoolType setrustedcredmanaccessnameright
                    )
    {
        this.setrustedcredmanaccessnameright = setrustedcredmanaccessnameright;
    }


    public EntityStateBoolType getSetrustedcredmanaccessnameright()    {
        return setrustedcredmanaccessnameright;
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
        if (!(obj instanceof AccesstokenState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "file_state[" + super.toString()
             + ", security_principle="  + getSecurityPrinciple()
             + ", seassignprimarytokenprivilege" + getSeassignprimarytokenprivilege()
             + ", sechangenotifyprivilege" + getSechangenotifyprivilege()
             + ", secreateglobalprivilege" + getSecreateglobalprivilege()
             + ", secreatepagefileprivilege" + getSecreatepagefileprivilege()
             + ", secreatepermanentprivilege" + getSecreatepermanentprivilege()
             + ", secreatesymboliclinkprivilege" + getSecreatesymboliclinkprivilege()
             + ", secreatetokenprivilege" + getSecreatetokenprivilege()
             + ", sedebugprivilege" + getSedebugprivilege()
             + ", seenabledelegationprivilege" + getSeenabledelegationprivilege()
             + ", seimpersonateprivilege" + getSeimpersonateprivilege()
             + ", seincreasebasepriorityprivilege" + getSeincreasebasepriorityprivilege()
             + ", seincreasequotaprivilege" + getSeincreasequotaprivilege()
             + ", seincreaseworkingsetprivilege" + getSeincreaseworkingsetprivilege()
             + ", seloaddriverprivilege" + getSeloaddriverprivilege()
             + ", selockmemoryprivilege" + getSelockmemoryprivilege()
             + ", semachineaccountprivilege" + getSemachineaccountprivilege()
             + ", semanagevolumeprivilege" + getSemanagevolumeprivilege()
             + ", seprofilesingleprocessprivilege" + getSeprofilesingleprocessprivilege()
             + ", serelabelprivilege" + getSerelabelprivilege()
             + ", seremoteshutdownprivilege" + getSeremoteshutdownprivilege()
             + ", serestoreprivilege" + getSerestoreprivilege()
             + ", sesecurityprivilege" + getSesecurityprivilege()
             + ", seshutdownprivilege" + getSeshutdownprivilege()
             + ", sesyncagentprivilege" + getSesyncagentprivilege()
             + ", sesystemenvironmentprivilege" + getSesystemenvironmentprivilege()
             + ", sesystemprofileprivilege" + getSesystemprofileprivilege()
             + ", sesystemtimeprivilege" + getSesystemtimeprivilege()
             + ", setakeownershipprivilege" + getSetakeownershipprivilege()
             + ", setcbprivilege" + getSetcbprivilege()
             + ", setimezoneprivilege" + getSetimezoneprivilege()
             + ", seundockprivilege" + getSeundockprivilege()
             + ", seunsolicitedinputprivilege" + getSeunsolicitedinputprivilege()
             + ", sebatchlogonright" + getSebatchlogonright()
             + ", seinteractivelogonright" + getSeinteractivelogonright()
             + ", senetworklogonright" + getSenetworklogonright()
             + ", seremoteinteractivelogonright" + getSeremoteinteractivelogonright()
             + ", seservicelogonright" + getSeservicelogonright()
             + ", sedenybatchLogonright" + getSedenybatchLogonright()
             + ", sedenyinteractivelogonright" + getSedenyinteractivelogonright()
             + ", sedenynetworklogonright" + getSedenynetworklogonright()
             + ", sedenyremoteInteractivelogonright" + getSedenyremoteInteractivelogonright()
             + ", sedenyservicelogonright" + getSedenyservicelogonright()
             + ", setrustedcredmanaccessnameright" + getSetrustedcredmanaccessnameright()
             + "]";
    }

}
//AccesstokenState
