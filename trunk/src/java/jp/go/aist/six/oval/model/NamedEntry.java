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

package jp.go.aist.six.oval.model;

import jp.go.aist.six.util.castor.CastorPersistable;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class NamedEntry<K>
    extends CastorPersistable<K>
    implements Comparable<NamedEntry<K>>, OvalObject<K>
{

    private String  _name;



    /**
     * Constructor.
     */
    public NamedEntry()
    {
    }


    /**
     * Constructor.
     */
    public NamedEntry(
                    final String name
                    )
    {
        setName( name );
    }



    public void setName(
                    final String name
                    )
    {
        _name = name;
    }


    public String getName()
    {
        return _name;
    }



    //**************************************************************
    //  Comparable
    //**************************************************************

    public int compareTo(
                    final NamedEntry<K> o
                    )
    {
        return String.CASE_INSENSITIVE_ORDER.compare( getName(), o.getName() );
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        String  name = getName();
        if (name != null) {
            name = name.toLowerCase();
        }
        result = prime * result + ((name == null) ? 0 : name.hashCode());

        return result;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (this == obj) {
            return true;
        }

        if (! NamedEntry.class.isInstance( obj )) {
            return false;
        }

        boolean  result = false;
        try {
            @SuppressWarnings( "unchecked" )
            NamedEntry<K>  other = (NamedEntry<K>)obj;
            String  otherName = other.getName();
            String   thisName =  this.getName();
            if (thisName == otherName
                            ||  (thisName != null
                                            &&  thisName.equalsIgnoreCase( otherName ))) {
                result = true;
            }
        } catch (ClassCastException ex) {
            result = false;
        }

        return result;
    }



    @Override
    public String toString()
    {
        return getName();
    }

}
// NamedEntry
