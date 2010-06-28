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

package jp.go.aist.six.oval.model.definition;

import jp.go.aist.six.oval.model.CommentedOvalEntity;
import jp.go.aist.six.oval.model.ComponentType;



/**
 * An OVAL Object describes a set of items to look for on a system.
 * The class name "SystemObject" is used because the name "Object"
 * has the special meaning in Java.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class SystemObject
    extends CommentedOvalEntity
{

    /**
     * Constructor.
     */
    public SystemObject()
    {
    }


    /**
     * Constructor.
     */
    public SystemObject(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }



    public void setSystemObjectType(
                    final ComponentType type
                    )
    {
    }


    public abstract ComponentType getSystemObjectType();



    // We found NO object with specific notes.

//    /**
//     * @param notes the notes to set
//     */
//    public void setNotes( final Notes notes )
//    {
//        _notes = notes;
//    }
//
//
//    /**
//     * @return the notes
//     */
//    public Notes getNotes()
//    {
//        return _notes;
//    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof SystemObject)) {
            return false;
        }

        return super.equals( obj );
    }

}
// SystemObject
