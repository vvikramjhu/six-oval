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



/**
 * The DefaultDirectives presents the default set of flags
 * that describe what information has been included in the results document.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class DefaultDirectives
    extends Directives
{

    public static final boolean DEFAULT_INCLUDE_SOURCE_DEFINITIONS = true;
    private boolean  _includeSourceDefinitions = DEFAULT_INCLUDE_SOURCE_DEFINITIONS;
    //{optional, default='true'}



    /**
     * Constructor.
     */
    public DefaultDirectives()
    {
    }


    /**
     * Constructor.
     */
    public DefaultDirectives(
                    final boolean includeSourceDefinitions,
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

        setIncludeSourceDefinitions( includeSourceDefinitions );
    }



    /**
     */
    public void setIncludeSourceDefinitions(
                    final boolean includeSourceDefinitions
                    )
    {
        _includeSourceDefinitions = includeSourceDefinitions;
    }


    public boolean isIncludeSourceDefinitions()
    {
        return _includeSourceDefinitions;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = super.hashCode();

        result = prime * result + (isIncludeSourceDefinitions() ? 0 : 1);

        return result;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof DefaultDirectives)) {
            return false;
        }


        if (super.equals( obj )) {
            DefaultDirectives  other = (DefaultDirectives)obj;
            if (isIncludeSourceDefinitions() == other.isIncludeSourceDefinitions()) {
                return true;
            }
        }

        return false;
    }

}
// DefaultDirectives
