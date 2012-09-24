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

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import jp.go.aist.six.oval.model.ElementContainer;
import com.google.code.morphia.annotations.Reference;



/**
 * A container for one or more Variable instances.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class VariablesType
    extends ElementContainer<VariableType>  //{1..*}
{

    @Reference
    private final Set<VariableType>  variable = new HashSet<VariableType>();



    /**
     * Constructor.
     */
    public VariablesType()
    {
    }


    public VariablesType(
                    final Collection<? extends VariableType> variable_list
                    )
    {
//        super( variables );

//        variable.addAll( variable_list );
        _copy( variable, variable_list );
    }


    public VariablesType(
                    final VariableType[] variable_list
                    )
    {
//        super( variables );

        this( Arrays.asList( variable_list ) );
    }



    /**
     */
    public void setVariable(
                    final Collection<? extends VariableType> variable_list
                    )
    {
        reset( variable_list );
//        _setElement( variable_list );
    }


    public void setVariable(
                    final VariableType[] variable_list
                    )
    {
        reset( variable_list );
    }


    public Collection<VariableType> getVariable()
    {
        return _getCollection();
    }


//    public boolean addVariable(
//                    final VariableType variable
//                    )
//    {
//        return add( variable );
//    }
//
//
//    public Iterator<VariableType> iterateVariable()
//    {
//        return iterator();
//    }



    //**************************************************************
    //  Container
    //**************************************************************

    @Override
    protected Collection<VariableType> _getCollection()
    {
        return variable;
    }

}
//
