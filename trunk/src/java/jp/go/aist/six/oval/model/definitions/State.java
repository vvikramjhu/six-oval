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

package jp.go.aist.six.oval.model.definitions;

import jp.go.aist.six.oval.model.CommentedOvalEntity;
import jp.go.aist.six.oval.model.PlatformEntityType;
import jp.go.aist.six.oval.model.common.Operator;



/**
 * An OVAL State is a collection of one or more characteristics
 * pertaining to a specific object type.
 * The OVAL State is used by an OVAL Test to determine
 * if a set of items identified on a system meet
 * certain characteristics.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class State
//public abstract class State
    extends CommentedOvalEntity //, Noted
{

    public static final Operator  DEFAULT_OPERATOR = Operator.AND;
    private Operator  _operator;
    //{optional, default="AND"}



    /**
     * Constructor.
     */
    public State()
    {
    }


    /**
     * Constructor.
     */
    public State(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    /**
     * Constructor.
     */
    public State(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );
    }



    /**
     */
    public State operator(
                  final Operator operator
                  )
    {
        setOperator( operator );
        return this;
    }


    public void setOperator(
                    final Operator operator
                    )
    {
        _operator = operator;
    }


    public Operator getOperator()
    {
        return (_operator == null ? DEFAULT_OPERATOR : _operator);
    }



    /**
     */
    public void setEntityType(
                    final PlatformEntityType type
                    )
    {
    }


//    public abstract EntityType getEntityType();
    public PlatformEntityType getEntityType()
    {
        return PlatformEntityType.UNKNOWN;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

}
// State
