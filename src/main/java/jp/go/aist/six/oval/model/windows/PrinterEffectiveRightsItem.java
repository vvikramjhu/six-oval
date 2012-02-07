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
import jp.go.aist.six.oval.model.sc.EntityItemBoolType;
import jp.go.aist.six.oval.model.sc.EntityItemStringType;
import jp.go.aist.six.oval.model.sc.ItemType;
import jp.go.aist.six.oval.model.sc.StatusEnumeration;



/**
 * This item stores the effective rights of a file 
 * that a discretionary access control list (DACL) structure 
 * grants to a specified trustee.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class PrinterEffectiveRightsItem
    extends ItemType
{

    //{0..1}
    private EntityItemStringType   printer_name;
    private EntityItemStringType   trustee_sid;
    private EntityItemBoolType    standard_delete;
    private EntityItemBoolType    standard_read_control;
    private EntityItemBoolType    standard_write_dac;
    private EntityItemBoolType    standard_write_owner;
    private EntityItemBoolType    standard_syncronize;
    private EntityItemBoolType    access_system_security;
    private EntityItemBoolType    generic_read;
    private EntityItemBoolType    generic_write;
    private EntityItemBoolType    generic_execute;
    private EntityItemBoolType    generic_all;
    private EntityItemBoolType    printer_access_administer;
    private EntityItemBoolType    printer_access_use;
    private EntityItemBoolType    job_access_administer;
    private EntityItemBoolType    job_access_read;



    /**
     * Constructor.
     */
    public PrinterEffectiveRightsItem()
    {
        this( 0 );
    }


    public PrinterEffectiveRightsItem(
                    final int id
                    )
    {
        this( id, null );
    }


    public PrinterEffectiveRightsItem(
                    final int id,
                    final StatusEnumeration status
                    )
    {
        super( id, status );
        
        _oval_platform_type = OvalPlatformType.windows;
        _oval_component_type = OvalComponentType.printereffectiverights;
    }



    /**
     */
    public void setPrinterName(
                    final EntityItemStringType printer_name
                    )
    {
        this.printer_name = printer_name;
    }


    public EntityItemStringType getPrinterName()
    {
        return this.printer_name;
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
                    final EntityItemBoolType standard_delete
                    )
    {
        this.standard_delete = standard_delete;
    }


    public EntityItemBoolType getStandardDelete()
    {
        return this.standard_delete;
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
        return this.standard_read_control;
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
        return this.standard_write_dac;
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
        return this.standard_write_owner;
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
        return this.standard_syncronize;
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
        return this.access_system_security;
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
        return this.generic_read;
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
        return this.generic_write;
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
        return this.generic_execute;
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
        return this.generic_all;
    }



    /**
     */
    public void setPrinterAccessAdminister(
                    final EntityItemBoolType printer_access_administer
                    )
    {
        this.printer_access_administer = printer_access_administer;
    }


    public EntityItemBoolType getPrinterAccessAdminister()
    {
        return this.printer_access_administer;
    }



    /**
     */
    public void setPrinterAccessUse(
                    final EntityItemBoolType printer_access_use
                    )
    {
        this.printer_access_use = printer_access_use;
    }


    public EntityItemBoolType getPrinterAccessUse()
    {
        return this.printer_access_use;
    }



    /**
     */
    public void setJobAccessAdminister(
                    final EntityItemBoolType job_access_administer
                    )
    {
        this.job_access_administer = job_access_administer;
    }


    public EntityItemBoolType getJobAccessAdminister()
    {
        return this.job_access_administer;
    }



    /**
     */
    public void setJobAccessRead(
                    final EntityItemBoolType job_access_read
                    )
    {
        this.job_access_read = job_access_read;
    }


    public EntityItemBoolType getJobAccessRead()
    {
        return this.job_access_read;
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
        if (!(obj instanceof PrinterEffectiveRightsItem)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "printereffectiverights_item[" + super.toString()
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
//PrinterEffectiveRightsItem