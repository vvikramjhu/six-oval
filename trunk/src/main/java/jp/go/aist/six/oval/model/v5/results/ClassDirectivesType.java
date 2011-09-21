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

package jp.go.aist.six.oval.model.v5.results;

import jp.go.aist.six.oval.model.common.ClassEnumeration;
import com.google.code.morphia.annotations.Property;



/**
 * The ClassDirectives presents a set of flags that describe
 * what information has been included in the results document
 * for a specific OVAL Definition class.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class ClassDirectivesType
    extends DirectivesType
{

    @Property( "class" )
    private ClassEnumeration  definition_class;
    //{required}



    /**
     * Constructor.
     */
    public ClassDirectivesType()
    {
    }


    /**
     * Constructor.
     */
    public ClassDirectivesType(
                    final ClassEnumeration definitionClass,
                    final DirectiveType definitionTrue,
                    final DirectiveType definitionFalse,
                    final DirectiveType definitionUnknown,
                    final DirectiveType definitionError,
                    final DirectiveType definitionNotEvaluated,
                    final DirectiveType definitionNotApplicable
                    )
    {
        super(
                        definitionTrue,
                        definitionFalse,
                        definitionUnknown,
                        definitionError,
                        definitionNotEvaluated,
                        definitionNotApplicable
        );

        setDefinitionClass( definitionClass );
    }



    /**
     */
    public void setDefinitionClass(
                    final ClassEnumeration definition_class
                    )
    {
        this.definition_class = definition_class;
    }


    public ClassEnumeration getDefinitionClass()
    {
        return this.definition_class;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = super.hashCode();

        ClassEnumeration  definitionClass = getDefinitionClass();
        result = prime * result + ((definitionClass == null) ? 0 : definitionClass.hashCode());

        return result;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof ClassDirectivesType)) {
            return false;
        }


        if (super.equals( obj )) {
            ClassDirectivesType  other = (ClassDirectivesType)obj;
            if (getDefinitionClass() == other.getDefinitionClass()) {
                return true;
            }
        }

        return false;
    }

}
// ClassDirectivesType
