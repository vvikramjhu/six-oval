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

import jp.go.aist.six.oval.model.AbstractOvalObject;
import java.util.EnumMap;
import java.util.Map;



/**
 * The Directives presents a set of flags
 * that describe what information has been included in the results document.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class Directives
    extends AbstractOvalObject
{

    protected static enum ResultType
    {
        TRUE,
        FALSE,
        UNKNOWN,
        ERROR,
        NOT_EVALUATED,
        NOT_APPLICABLE;
    }

    private Map<ResultType, Directive>  _directives =
        new EnumMap<ResultType, Directive>( ResultType.class );
    //{1..1}



    /**
     * Constructor.
     */
    public Directives()
    {
        this(
                        new Directive(),
                        new Directive(),
                        new Directive(),
                        new Directive(),
                        new Directive(),
                        new Directive()
                        );
    }


    /**
     * Constructor.
     */
    public Directives(
                    final Directive definitionTrue,
                    final Directive definitionFalse,
                    final Directive definitionUnknown,
                    final Directive definitionError,
                    final Directive definitionNotEvaluated,
                    final Directive definitionNotApplicable
                    )
    {
        setDefinitionTrue(          definitionTrue );
        setDefinitionFalse(         definitionFalse );
        setDefinitionUnknown(       definitionUnknown );
        setDefinitionError(         definitionError );
        setDefinitionNotEvaluated(  definitionNotEvaluated );
        setDefinitionNotApplicable( definitionNotApplicable );
    }



    /**
     */
    public Directive getDefinitionTrue()
    {
        return _directives.get( ResultType.TRUE );
    }


    public void setDefinitionTrue(
                    final Directive directive
                    )
    {
        _directives.put( ResultType.TRUE, directive );
    }



    /**
     */
    public Directive getDefinitionFalse()
    {
        return _directives.get( ResultType.FALSE );
    }


    public void setDefinitionFalse(
                    final Directive directive
                    )
    {
        _directives.put( ResultType.FALSE, directive );
    }



    /**
     */
    public Directive getDefinitionUnknown()
    {
        return _directives.get( ResultType.UNKNOWN );
    }


    public void setDefinitionUnknown(
                    final Directive directive
                    )
    {
        _directives.put( ResultType.UNKNOWN, directive );
    }



    /**
     */
    public Directive getDefinitionError()
    {
        return _directives.get( ResultType.ERROR );
    }


    public void setDefinitionError(
                    final Directive directive
                    )
    {
        _directives.put( ResultType.ERROR, directive );
    }



    /**
     */
    public Directive getDefinitionNotEvaluated()
    {
        return _directives.get( ResultType.NOT_EVALUATED );
    }


    public void setDefinitionNotEvaluated(
                    final Directive directive
                    )
    {
        _directives.put( ResultType.NOT_EVALUATED, directive );
    }



    /**
     */
    public Directive getDefinitionNotApplicable()
    {
        return _directives.get( ResultType.NOT_APPLICABLE );
    }


    public void setDefinitionNotApplicable(
                    final Directive directive
                    )
    {
        _directives.put( ResultType.NOT_APPLICABLE, directive );
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        Directive  defTrue = getDefinitionTrue();
        result = prime * result + ((defTrue == null) ? 0 : defTrue.hashCode());

        Directive  defFalse= getDefinitionFalse();
        result = prime * result + ((defFalse == null) ? 0 : defFalse.hashCode());

        Directive  defUnknown = getDefinitionUnknown();
        result = prime * result + ((defUnknown == null) ? 0 : defUnknown.hashCode());

        Directive  defError = getDefinitionError();
        result = prime * result + ((defError == null) ? 0 : defError.hashCode());

        Directive  defNotEvaluated = getDefinitionNotEvaluated();
        result = prime * result + ((defNotEvaluated == null) ? 0 : defNotEvaluated.hashCode());

        Directive  defNotApplicable = getDefinitionNotApplicable();
        result = prime * result + ((defNotApplicable == null) ? 0 : defNotApplicable.hashCode());

        return result;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Directives)) {
            return false;
        }

        Directives  other = (Directives)obj;
        Directive  other_false = other.getDefinitionFalse();
        Directive   this_false =  this.getDefinitionFalse();
        if (this_false == other_false
                        ||  (this_false != null  &&  this_false.equals( other_false ))) {
            Directive  other_unknown = other.getDefinitionUnknown();
            Directive   this_unknown =  this.getDefinitionUnknown();
            if (this_unknown == other_unknown
                            ||  (this_unknown != null  &&  this_unknown.equals( other_unknown ))) {
                Directive  other_error = other.getDefinitionError();
                Directive   this_error =  this.getDefinitionError();
                if (this_error == other_error
                                ||  (this_error != null  &&  this_error.equals( other_error ))) {
                    Directive  other_not_eval = other.getDefinitionNotEvaluated();
                    Directive   this_not_eval =  this.getDefinitionNotEvaluated();
                    if (this_not_eval == other_not_eval
                                    ||  (this_not_eval != null  &&  this_not_eval.equals( other_not_eval ))) {
                        Directive  other_not_app = other.getDefinitionNotApplicable();
                        Directive   this_not_app =  this.getDefinitionNotApplicable();
                        if (this_not_app == other_not_app
                                        ||  (this_not_app != null  &&  this_not_app.equals( other_not_app ))) {
                            Directive  other_true = other.getDefinitionTrue();
                            Directive   this_true =  this.getDefinitionTrue();
                            if (this_true == other_true
                                            ||  (this_true != null  &&  this_true.equals( other_true ))) {
                                return true;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "definition_true="             + getDefinitionTrue()
             + ", definition_false="          + getDefinitionFalse()
             + ", definition_unknown="        + getDefinitionUnknown()
             + ", definition_error="          + getDefinitionError()
             + ", definition_not_evaluated="  + getDefinitionNotEvaluated()
             + ", definition_not_applicable=" + getDefinitionNotApplicable();
    }

}
// Directives
