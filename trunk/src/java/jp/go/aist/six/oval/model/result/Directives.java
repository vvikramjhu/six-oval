/*
 *  @ProductName@
 *  Copyright (C) @CopyrightYear@
 *    National Institute of Advanced Industrial Science and Technology (AIST)
 *    Registration Number: @AISTRegistrationNumber@
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

package jp.go.aist.six.oval.model.result;

import jp.go.aist.six.util.orm.AbstractPersistable;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class Directives
    extends AbstractPersistable
{

    private Directive  _definitionTrue;
    //{1..1}

    private Directive  _definitionFalse;
    //{1..1}

    private Directive  _definitionUnknown;
    //{1..1}

    private Directive  _definitionError;
    //{1..1}

    private Directive  _definitionNotEvaluated;
    //{1..1}

    private Directive  _definitionNotApplicable;
    //{1..1}



    /**
     * Constructor.
     */
    public Directives()
    {
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
        setDefinitionTrue( definitionTrue );
        setDefinitionFalse( definitionFalse );
        setDefinitionUnknown( definitionUnknown );
        setDefinitionError( definitionError );
        setDefinitionNotEvaluated( definitionNotEvaluated );
        setDefinitionNotApplicable( definitionNotApplicable );
    }



    /**
     */
    public Directive getDefinitionTrue()
    {
        return _definitionTrue;
    }


    /**
     */
    public void setDefinitionTrue(
                    final Directive definitionTrue
                    )
    {
        _definitionTrue = definitionTrue;
    }



    /**
     */
    public Directive getDefinitionFalse()
    {
        return _definitionFalse;
    }


    /**
     */
    public void setDefinitionFalse(
                    final Directive definitionFalse
                    )
    {
        _definitionFalse = definitionFalse;
    }



    /**
     */
    public Directive getDefinitionUnknown()
    {
        return _definitionUnknown;
    }


    /**
     */
    public void setDefinitionUnknown(
                    final Directive definitionUnknown
                    )
    {
        _definitionUnknown = definitionUnknown;
    }



    /**
     */
    public Directive getDefinitionError()
    {
        return _definitionError;
    }


    /**
     */
    public void setDefinitionError(
                    final Directive definitionError
                    )
    {
        _definitionError = definitionError;
    }



    /**
     */
    public Directive getDefinitionNotEvaluated()
    {
        return _definitionNotEvaluated;
    }


    /**
     */
    public void setDefinitionNotEvaluated(
                    final Directive definitionNotEvaluated
                    )
    {
        _definitionNotEvaluated = definitionNotEvaluated;
    }



    /**
     */
    public Directive getDefinitionNotApplicable()
    {
        return _definitionNotApplicable;
    }


    /**
     */
    public void setDefinitionNotApplicable(
                    final Directive definitionNotApplicable
                    )
    {
        _definitionNotApplicable = definitionNotApplicable;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "Directives[definition_true=" + getDefinitionTrue()
                        + ", definition_false=" + getDefinitionFalse()
                        + ", definition_unknown=" + getDefinitionUnknown()
                        + ", definition_error=" + getDefinitionError()
                        + ", definition_not_evaluated=" + getDefinitionNotEvaluated()
                        + ", definition_not_applicable=" + getDefinitionNotApplicable()
                        + "]";
    }

}
// Directives
