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

import jp.go.aist.six.oval.model.OvalEntityType;
import jp.go.aist.six.oval.model.v5.CommentedOvalEntity;
import jp.go.aist.six.oval.model.v5.PlatformEntityType;
import com.google.code.morphia.annotations.Entity;



/**
 * An OVAL Object describes a set of items to look for on a system.
 * The name "object" in the OVAL Schema is renamed
 * because the name has the special meaning in Java.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
@Entity( "oval.d.object" )
public class SystemObjectType
    extends CommentedOvalEntity
{

    private NotesType  notes;
    //{0..1}



    /**
     * Constructor.
     */
    public SystemObjectType()
    {
        this( null, 0 );
    }


    public SystemObjectType(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public SystemObjectType(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

        oval_entity_type = OvalEntityType.object;
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



//    private static List<EntityAttributeGroup>  _EMPTY_LIST_ =
//        Collections.emptyList();
//

//    /**
//     */
//    public Iterator<EntityAttributeGroup> iterateProperties()
//    {
//        return _EMPTY_LIST_.iterator();
//    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

}
// SystemObjectType
