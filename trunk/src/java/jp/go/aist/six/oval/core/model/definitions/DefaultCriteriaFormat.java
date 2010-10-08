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

package jp.go.aist.six.oval.core.model.definitions;

import jp.go.aist.six.oval.model.common.Operator;
import jp.go.aist.six.oval.model.definitions.Criteria;
import jp.go.aist.six.oval.model.definitions.CriteriaElement;
import jp.go.aist.six.oval.model.definitions.Criterion;
import jp.go.aist.six.oval.model.definitions.ExtendDefinition;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class DefaultCriteriaFormat
    implements CriteriaFormat
{

    protected void _append(
                    final StringBuilder s,
                    final Criteria criteria
                    )
    {
        final String  comment = criteria.getComment();
        final boolean  commented = (comment != null  &&  comment.length() > 0);
        if (commented) {
            s.append( "{" ).append( comment ).append( "}" );
        }

        s.append( "(" );
        boolean  first = true;
        Operator  op = criteria.getOperator();
        final String  operator = (op == null ? "" : op.toString());
        for (CriteriaElement  e : criteria.getElements()) {
            if (first) {
                first = false;
            } else {
                s.append( " " ).append( operator ).append( " " );
            }

            _append( s, e );
        }
        s.append( ")" );
    }



    protected void _append(
                    final StringBuilder s,
                    final CriteriaElement element
                    )
    {
        if (element instanceof Criterion) {
            _append( s, Criterion.class.cast( element ) );
        } else if (element instanceof ExtendDefinition) {
            _append( s, ExtendDefinition.class.cast( element ) );
        } else {
            throw new IllegalArgumentException( "unknown criteria element: " + element );
        }
    }



    protected void _append(
                    final StringBuilder s,
                    final Criterion criterion
                    )
    {
        s.append( "{" );
        if (criterion.isNegate()) {
            s.append( "[NOT " );
        } else {
            s.append( "[" );
        }
        s.append( criterion.getTestRef() ).append( "] " );

        s.append( criterion.getComment() );
        s.append( "}" );
    }



    protected void _append(
                    final StringBuilder s,
                    final ExtendDefinition ext
                    )
    {
        s.append( "{" );
        if (ext.isNegate()) {
            s.append( "[NOT " );
        } else {
            s.append( "[" );
        }
        s.append( ext.getDefinitionRef() ).append( "] " );

        s.append( ext.getComment() );
        s.append( "}" );
    }



    //**************************************************************
    //  CriteriaFormat
    //**************************************************************

    public String format(
                    final Criteria criteria
                    )
    {
        StringBuilder  s = new StringBuilder();
        _append( s, criteria );

        return s.toString();
    }

}
// DefaultCriteriaFormatter
