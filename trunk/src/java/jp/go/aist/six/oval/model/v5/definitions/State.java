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

package jp.go.aist.six.oval.model.v5.definitions;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import jp.go.aist.six.oval.model.PlatformEntityType;
import jp.go.aist.six.oval.model.definitions.EntityBase;
import jp.go.aist.six.oval.model.v5.CommentedOvalEntity;
import jp.go.aist.six.oval.model.v5.common.OperatorEnumeration;



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

    private NotesType  _notes;
    //{0..1}


    public static final OperatorEnumeration  DEFAULT_OPERATOR = OperatorEnumeration.AND;
    private OperatorEnumeration  _operator;
    //{optional, default="AND"}



    /**
     * Constructor.
     */
    public State()
    {
    }


    public State(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


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
    public void setNotes(
                    final NotesType notes
                    )
    {
        _notes = notes;
    }


    public NotesType getNotes()
    {
        return _notes;
    }



    /**
     */
    public State operator(
                  final OperatorEnumeration operator
                  )
    {
        setOperator( operator );
        return this;
    }


    public void setOperator(
                    final OperatorEnumeration operator
                    )
    {
        _operator = operator;
    }


    public OperatorEnumeration getOperator()
    {
        return _operator;
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



    private static List<EntityBase>  _EMPTY_LIST_ =
        Collections.emptyList();


    /**
     */
    public Iterator<EntityBase> iterateProperties()
    {
        return _EMPTY_LIST_.iterator();
    }



//    private EnumMap<? extends Enum<?>, EntityStateBase>  _properties;
//    private Class<?>  _propertyKeyType;
//
//    protected <K extends Enum<K>>
//    void _initStateProperties(
//                    final Class<K> keyType
//                    )
//    {
//        _properties = new EnumMap<K, EntityStateBase>( keyType );
//        _propertyKeyType = keyType;
//    }
//
//
//
//    protected <K extends Enum<K>, T extends EntityStateBase>
//    T _getStateProperty(
//                    final K key,
//                    final Class<T> type
//                    )
//    {
//        EntityStateBase  p = _properties.get( key );
//        return type.cast( p );
//    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

}
// StateType
