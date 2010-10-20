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

package jp.go.aist.six.oval.model.results;

import jp.go.aist.six.oval.model.common.DefinitionClass;



/**
 * The ClassDirectivesType presents a set of flags that describe
 * what information has been included in the results document
 * for a specific OVAL Definition class.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class ClassDirectives
    extends Directives
{

    private DefinitionClass  _definitionClass;
    //{required}



    /**
     * Constructor.
     */
    public ClassDirectives()
    {
    }


    /**
     * Constructor.
     */
    public ClassDirectives(
                    final DefinitionClass definitionClass,
                    final Directive definitionTrue,
                    final Directive definitionFalse,
                    final Directive definitionUnknown,
                    final Directive definitionError,
                    final Directive definitionNotEvaluated,
                    final Directive definitionNotApplicable
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
                    final DefinitionClass definitionClass
                    )
    {
        _definitionClass = definitionClass;
    }


    public DefinitionClass getDefinitionClass()
    {
        return _definitionClass;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = super.hashCode();

        DefinitionClass  definitionClass = getDefinitionClass();
        result = prime * result + ((definitionClass == null) ? 0 : definitionClass.hashCode());

        return result;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof ClassDirectives)) {
            return false;
        }


        if (super.equals( obj )) {
            ClassDirectives  other = (ClassDirectives)obj;
            if (getDefinitionClass() == other.getDefinitionClass()) {
                return true;
            }
        }

        return false;
    }

}
// ClassDirectives
