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

import java.util.Collection;
import java.util.Collections;
import jp.go.aist.six.oval.model.ElementRef;
import jp.go.aist.six.oval.model.ElementType;
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
@Entity( "oval.def.object" )
public class SystemObjectType
    extends DefinitionsComponent
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

//        _oval_entity_type = OvalEntityType.object;
//        _definitions_element_type = DefinitionsElement.Type.object;
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
        return notes;
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



    //*********************************************************************
    //  Element
    //*********************************************************************

    @Override
    public final ElementType ovalGetType()
    {
        return ElementType.OBJECT;
    }



    //*********************************************************************
    //  DefinitionsElement
    //*********************************************************************

//    @Override
//    public final Type ovalGetElementType()
//    {
//        return DefinitionsElement.Type.OBJECT;
//    }



    @Override
    public Collection<ElementRef> ovalGetElementRef()
    {
        return Collections.emptyList();
//        Collection<ElementRef>  ref_list = new ArrayList<ElementRef>();
//        return ref_list;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

}
// SystemObjectType
