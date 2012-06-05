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

import java.util.ArrayList;
import java.util.Collection;
import jp.go.aist.six.oval.model.Component;
import jp.go.aist.six.oval.model.ElementRef;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.definitions.EntityStateBoolType;
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.definitions.StateType;



/**
 * The printer effective rights state defines the different rights
 * that can be associated with a given printer effective rights object.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class PrinterEffectiveRightsState
    extends StateType
{

    //{0..1}
    private EntityStateStringType   printer_name;
    private EntityStateStringType   trustee_sid;
    private EntityStateBoolType    standard_delete;
    private EntityStateBoolType    standard_read_control;
    private EntityStateBoolType    standard_write_dac;
    private EntityStateBoolType    standard_write_owner;
    private EntityStateBoolType    standard_syncronize;
    private EntityStateBoolType    access_system_security;
    private EntityStateBoolType    generic_read;
    private EntityStateBoolType    generic_write;
    private EntityStateBoolType    generic_execute;
    private EntityStateBoolType    generic_all;
    private EntityStateBoolType    printer_access_administer;
    private EntityStateBoolType    printer_access_use;
    private EntityStateBoolType    job_access_administer;
    private EntityStateBoolType    job_access_read;



    /**
     * Constructor.
     */
    public PrinterEffectiveRightsState()
    {
        this( null, 0 );
    }


    public PrinterEffectiveRightsState(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public PrinterEffectiveRightsState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

//        _oval_platform_type = OvalPlatformType.windows;
//        _oval_component_type = OvalComponentType.printereffectiverights;
        _oval_family = Family.WINDOWS;
        _oval_component = Component.PRINTEREFFECTIVERIGHTS;
    }



    /**
     */
    public void setPrinterName(
                    final EntityStateStringType printer_name
                    )
    {
        this.printer_name = printer_name;
    }


    public EntityStateStringType getPrinterName()
    {
        return printer_name;
    }



    /**
     */
    public void setTrusteeSid(
                    final EntityStateStringType trustee_sid
                    )
    {
        this.trustee_sid = trustee_sid;
    }


    public EntityStateStringType getTrusteeSid()
    {
        return trustee_sid;
    }



    /**
     */
    public void setStandardDelete(
                    final EntityStateBoolType standard_delete
                    )
    {
        this.standard_delete = standard_delete;
    }


    public EntityStateBoolType getStandardDelete()
    {
        return standard_delete;
    }



    /**
     */
    public void setStandardReadControl(
                    final EntityStateBoolType standard_read_control
                    )
    {
        this.standard_read_control = standard_read_control;
    }


    public EntityStateBoolType getStandardReadControl()
    {
        return standard_read_control;
    }



    /**
     */
    public void setStandardWriteDac(
                    final EntityStateBoolType standard_write_dac
                    )
    {
        this.standard_write_dac = standard_write_dac;
    }


    public EntityStateBoolType getStandardWriteDac()
    {
        return standard_write_dac;
    }



    /**
     */
    public void setStandardWriteOwner(
                    final EntityStateBoolType standard_write_owner
                    )
    {
        this.standard_write_owner = standard_write_owner;
    }


    public EntityStateBoolType getStandardWriteOwner()
    {
        return standard_write_owner;
    }



    /**
     */
    public void setStandardSyncronize(
                    final EntityStateBoolType standard_syncronize
                    )
    {
        this.standard_syncronize = standard_syncronize;
    }


    public EntityStateBoolType getStandardSyncronize()
    {
        return standard_syncronize;
    }



    /**
     */
    public void setAccessSystemSecurity(
                    final EntityStateBoolType access_system_security
                    )
    {
        this.access_system_security = access_system_security;
    }


    public EntityStateBoolType getAccessSystemSecurity()
    {
        return access_system_security;
    }



    /**
     */
    public void setGenericRead(
                    final EntityStateBoolType generic_read
                    )
    {
        this.generic_read = generic_read;
    }


    public EntityStateBoolType getGenericRead()
    {
        return generic_read;
    }



    /**
     */
    public void setGenericWrite(
                    final EntityStateBoolType generic_write
                    )
    {
        this.generic_write = generic_write;
    }


    public EntityStateBoolType getGenericWrite()
    {
        return generic_write;
    }



    /**
     */
    public void setGenericExecute(
                    final EntityStateBoolType generic_execute
                    )
    {
        this.generic_execute = generic_execute;
    }


    public EntityStateBoolType getGenericExecute()
    {
        return generic_execute;
    }



    /**
     */
    public void setGenericAll(
                    final EntityStateBoolType generic_all
                    )
    {
        this.generic_all = generic_all;
    }


    public EntityStateBoolType getGenericAll()
    {
        return generic_all;
    }



    /**
     */
    public void setPrinterAccessAdminister(
                    final EntityStateBoolType printer_access_administer
                    )
    {
        this.printer_access_administer = printer_access_administer;
    }


    public EntityStateBoolType getPrinterAccessAdminister()
    {
        return printer_access_administer;
    }



    /**
     */
    public void setPrinterAccessUse(
                    final EntityStateBoolType printer_access_use
                    )
    {
        this.printer_access_use = printer_access_use;
    }


    public EntityStateBoolType getPrinterAccessUse()
    {
        return printer_access_use;
    }



    /**
     */
    public void setJobAccessAdminister(
                    final EntityStateBoolType job_access_administer
                    )
    {
        this.job_access_administer = job_access_administer;
    }


    public EntityStateBoolType getJobAccessAdminister()
    {
        return job_access_administer;
    }



    /**
     */
    public void setJobAccessRead(
                    final EntityStateBoolType job_access_read
                    )
    {
        this.job_access_read = job_access_read;
    }


    public EntityStateBoolType getJobAccessRead()
    {
        return job_access_read;
    }



    //*********************************************************************
    //  DefinitionsElement
    //*********************************************************************

    @Override
    public Collection<ElementRef> ovalGetElementRef()
    {
        Collection<ElementRef>  ref_list = new ArrayList<ElementRef>();

        ref_list.add( getPrinterName() );
        ref_list.add( getTrusteeSid() );
        ref_list.add( getStandardDelete() );
        ref_list.add( getStandardReadControl() );
        ref_list.add( getStandardWriteDac() );
        ref_list.add( getStandardWriteOwner() );
        ref_list.add( getStandardSyncronize() );
        ref_list.add( getAccessSystemSecurity() );
        ref_list.add( getGenericRead() );
        ref_list.add( getGenericWrite() );
        ref_list.add( getGenericExecute() );
        ref_list.add( getGenericAll() );
        ref_list.add( getPrinterAccessAdminister() );
        ref_list.add( getPrinterAccessUse() );
        ref_list.add( getJobAccessAdminister() );
        ref_list.add( getJobAccessRead() );

        return ref_list;
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
        if (!(obj instanceof PrinterEffectiveRightsState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "printereffectiverights_state[" + super.toString()
             + ", printer_name="            + getPrinterName()
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
             + ", printer_access_administer=" + getPrinterAccessAdminister()
             + ", printer_access_use="      + getPrinterAccessUse()
             + ", job_access_administer="   + getJobAccessAdminister()
             + ", job_access_read="         + getJobAccessRead()
             + "]";
    }
}
//PrinterEffectiveRightsState
