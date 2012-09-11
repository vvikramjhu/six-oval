/*
 *  @product.title@
 *  Copyright (C) @product.copyright-year@
 *    @product.vendor@
 *    Registration Number: @product.registration-number@
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.go.aist.six.oval.model.windows;

import jp.go.aist.six.oval.model.ComponentType;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.sc.EntityItemRecordType;
import jp.go.aist.six.oval.model.sc.EntityItemStringType;
import jp.go.aist.six.oval.model.sc.EntityItemVersionType;
import jp.go.aist.six.oval.model.sc.ItemType;



/**
 * The cmdlet_item represents a PowerShell cmdlet, the parameters supplied to it,
 * and the value it returned.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class CmdletItem
    extends ItemType
{

    private EntityItemStringType      module_name;
    private EntityItemGUIDType        module_id;
    private EntityItemVersionType     module_version;
    private EntityItemCmdletVerbType  verb;
    private EntityItemStringType      noun;
    private EntityItemRecordType      parameters;
    private EntityItemRecordType      select;
    private EntityItemRecordType      value;



    /**
     * Constructor.
     */
    public CmdletItem()
    {
        this( 0 );
    }


    public CmdletItem(
                    final int id
                    )
    {
        super( id );

        _oval_family = Family.WINDOWS;
        _oval_component = ComponentType.CMDLET;
    }



    /**
     */
    public void setModuleName(
                    final EntityItemStringType module_name
                    )
    {
        this.module_name = module_name;
    }


    public EntityItemStringType getModuleName()
    {
        return module_name;
    }



    /**
     */
    public void setModuleId(
                    final EntityItemGUIDType module_id
                    )
    {
        this.module_id = module_id;
    }


    public EntityItemGUIDType getModuleId()
    {
        return module_id;
    }



    /**
     */
    public void setModuleVersion(
                    final EntityItemVersionType module_version
                    )
    {
        this.module_version = module_version;
    }


    public EntityItemVersionType getModuleVersion()
    {
        return module_version;
    }



    /**
     */
    public void setVerb(
                    final EntityItemCmdletVerbType verb
                    )
    {
        this.verb = verb;
    }


    public EntityItemCmdletVerbType getVerb()
    {
        return verb;
    }



    /**
     */
    public void setNoun(
                    final EntityItemStringType noun
                    )
    {
        this.noun = noun;
    }


    public EntityItemStringType getNoun()
    {
        return noun;
    }



    /**
     */
    public void setParameters(
                    final EntityItemRecordType parameters
                    )
    {
        this.parameters = parameters;
    }


    public EntityItemRecordType getParameters()
    {
        return parameters;
    }



    /**
     */
    public void setSelect(
                    final EntityItemRecordType select
                    )
    {
        this.select = select;
    }


    public EntityItemRecordType getSelect()
    {
        return select;
    }



    /**
     */
    public void setValue(
                    final EntityItemRecordType value
                    )
    {
        this.value = value;
    }


    public EntityItemRecordType getValue()
    {
        return value;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "cmdlet_item[" + super.toString()
                        + ", module_name="      + getModuleName()
                        + ", module_id="        + getModuleId()
                        + ", module_version="   + getModuleVersion()
                        + ", verb="             + getVerb()
                        + ", noun="             + getNoun()
                        + ", parameters="       + getParameters()
                        + ", select="           + getSelect()
                        + ", value="            + getValue()
             + "]";
    }

}
//
