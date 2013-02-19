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

package jp.go.aist.six.oval.model.definitions;

import jp.go.aist.six.oval.model.ElementRef;
import jp.go.aist.six.oval.model.ElementType;



/**
 * The VariableComponent type defines a specific value obtained by
 * looking at the value of another OVAL Variable.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class VariableComponentType
    extends ComponentGroup
    implements ElementRef
{

    private String  var_ref;
    //{required, oval:VariableIDPattern}



    /**
     * Constructor.
     */
    public VariableComponentType()
    {
    }



    /**
     */
    public void setVarRef(
                    final String var_ref
                    )
    {
        this.var_ref = var_ref;
    }


    public String getVarRef()
    {
        return var_ref;
    }



    //*********************************************************************
    //  ElementRef
    //*********************************************************************

    public String ovalGetRefId()
    {
        return getVarRef();
    }



    public ElementType ovalGetRefType()
    {
        return ElementType.VARIABLE;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "[var_ref=" + getVarRef()
             + "]";
    }

}
// VariableComponentType
