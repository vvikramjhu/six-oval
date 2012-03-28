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

import jp.go.aist.six.oval.model.OvalEntityType;
import jp.go.aist.six.oval.model.common.OperatorEnumeration;
import com.google.code.morphia.annotations.Entity;



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
@Entity( "oval.d.state" )
public class StateType
    extends DefinitionsComponent
{

    private NotesType  notes;
    //{0..1}


    public static final OperatorEnumeration  DEFAULT_OPERATOR =
        OperatorEnumeration.AND;

    private OperatorEnumeration  operator;
    //{optional, default="AND"}



    /**
     * Constructor.
     */
    public StateType()
    {
        this( null, 0 );
    }


    public StateType(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public StateType(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

        _oval_entity_type = OvalEntityType.state;
    }



    /**
     */
    public void setNotes(
                    final NotesType notes
                    )
    {
        this.notes = notes;
    }


    public NotesType getNotes()
    {
        return this.notes;
    }



    /**
     */
    public void setOperator(
                    final OperatorEnumeration operator
                    )
    {
        this.operator = operator;
    }


    public OperatorEnumeration getOperator()
    {
        return this.operator;
    }


    public StateType operator(
                    final OperatorEnumeration operator
                    )
    {
        setOperator( operator );
        return this;
    }


    public static final OperatorEnumeration operator(
                    final StateType state
                    )
    {
        if (state == null) {
            throw new IllegalArgumentException( "null StateType" );
        }

        OperatorEnumeration  operator = state.getOperator();
        if (operator == null) {
            operator = DEFAULT_OPERATOR;
        }

        return operator;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

}
// StateType
