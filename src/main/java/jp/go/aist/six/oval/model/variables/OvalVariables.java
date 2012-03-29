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

package jp.go.aist.six.oval.model.variables;

import jp.go.aist.six.oval.model.common.AbstractDocument;
import jp.go.aist.six.oval.model.common.GeneratorType;
import com.google.code.morphia.annotations.Entity;



/**
 * The OvalVariables is an OVAL Variable Document.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
@Entity( "oval.v.oval_variables" )
public class OvalVariables
    extends AbstractDocument
{

//    private GeneratorType  generator = new GeneratorType();
//    //{1..1}


    private VariablesType  variables;
    //{0..1}



    /**
     * Constructor.
     */
    public OvalVariables()
    {
    }


    public OvalVariables(
                    final GeneratorType generator
                    )
    {
        super( generator );
    }



    /**
     */
    public void setVariables(
                    final VariablesType variables
                    )
    {
        this.variables = variables;
    }


    public VariablesType getVariables()
    {
        return this.variables;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "oval_variables[generator=" + getGenerator()
                        + ", variables=" + getVariables()
                        + "]";
    }

}
//OvalVariables
