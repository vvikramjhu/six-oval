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

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import jp.go.aist.six.oval.model.Container;



/**
 * The Notes is a container for one or more note child elements.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class NotesType
    extends Container<Note> //{1..*}
{

    private final Set<Note>  note = new HashSet<Note>();



    /**
     * Constructor.
     */
    public NotesType()
    {
    }


    public NotesType(
                    final Collection<String> notes
                    )
    {
        for (String  s : notes) {
            addNote( new Note( s ) );
        }
    }


    public NotesType(
                    final String[] notes
                    )
    {
        this( Arrays.asList( notes ) );
    }



    /**
     */
    public void setNote(
                    final Collection<? extends Note> note_list
                    )
    {
        _setElement( note_list );
    }


    public boolean addNote(
                    final Note note
                    )
    {
        return _addElement( note );
    }


    public Collection<Note> getNote()
    {
        return _getElement();
    }


    public Iterator<Note> iterateNote()
    {
        return iterator();
    }



    //**************************************************************
    //  Container
    //**************************************************************

    @Override
    protected Collection<Note> _getElement()
    {
        return note;
    }

}
// NotesType
