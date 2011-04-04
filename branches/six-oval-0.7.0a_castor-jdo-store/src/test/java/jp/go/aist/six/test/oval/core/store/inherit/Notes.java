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

package jp.go.aist.six.test.oval.core.store.inherit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;



/**
 * The Notes is a container for one or more note child elements.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: Notes.java 1033 2010-11-30 09:34:49Z nakamura5akihito $
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class Notes
    extends AbstractOvalObject
{

    private Collection<String>  _note = new ArrayList<String>();
    //{1..*}



    /**
     * Constructor.
     */
    public Notes()
    {
    }


    /**
     * Constructor.
     */
    public Notes(
                    final Collection<String> notes
                    )
    {
        setNote( notes );
    }


    /**
     * Constructor.
     */
    public Notes(
                    final String[] notes
                    )
    {
        setNote( Arrays.asList( notes ) );
    }



    public void setNote(
                    final Collection<String> notes
                    )
    {
        if (_note != notes) {
            _note.clear();
            if (notes != null  &&  notes.size() > 0) {
                _note.addAll( notes );
            }
        }
    }


    public boolean addNote(
                    final String note
                    )
    {
        return _note.add( note );
    }


    public Collection<String> getNote()
    {
        return _note;
    }


    public Iterator<String> iterateNote()
    {
        return _note.iterator();
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return String.valueOf( getNote() );
    }

}
// Notes
