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
public class DefaultDirectivesType
    extends DirectivesType
{

    public static final Boolean DEFAULT_INCLUDE_SOURCE_DEFINITIONS =
        Boolean.TRUE;

    private Boolean  include_source_definitions;
    //{optional, default='true'}



    /**
     * Constructor.
     */
    public DefaultDirectivesType()
    {
    }


    /**
     * Constructor.
     */
    public DefaultDirectivesType(
                    final boolean includeSourceDefinitions,
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

        setIncludeSourceDefinitions( includeSourceDefinitions );
    }



    /**
     */
    public void setIncludeSourceDefinitions(
                    final Boolean include_source_definitions
                    )
    {
        this.include_source_definitions = include_source_definitions;
    }


    public Boolean isIncludeSourceDefinitions()
    {
        return this.include_source_definitions;
    }


    protected Boolean _includeSourceDefinitions()
    {
        return (this.include_source_definitions == null
                        ? DEFAULT_INCLUDE_SOURCE_DEFINITIONS
                        : this.include_source_definitions);
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = super.hashCode();

        result = prime * result + (_includeSourceDefinitions() ? 0 : 1);

        return result;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof DefaultDirectivesType)) {
            return false;
        }


        if (super.equals( obj )) {
            DefaultDirectivesType  other = (DefaultDirectivesType)obj;
            if (isIncludeSourceDefinitions() == other.isIncludeSourceDefinitions()) {
                return true;
            }
        }

        return false;
    }

}
// DefaultDirectives
