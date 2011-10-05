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




/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class NameEntity
    implements OvalObject, Comparable<NameEntity>
{

    private String  name;



    /**
     * Constructor.
     */
    public NameEntity()
    {
    }


    public NameEntity(
                    final String name
                    )
    {
        setName( name );
    }



    /**
     */
    public void setName(
                    final String name
                    )
    {
        this.name = name;
    }


    public String getName()
    {
        return this.name;
    }



    //**************************************************************
    //  Comparable
    //**************************************************************

    @Override
    public int compareTo(
                    final NameEntity o
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

        if (!(obj instanceof NameEntity)) {
            return false;
        }

        NameEntity  other = (NameEntity)obj;
        String  other_name = other.getName();
        String   this_name =  this.getName();
        if (this_name == other_name
                        ||  (this_name != null
                                        &&  this_name.equalsIgnoreCase( other_name ))) {
                return true;
        }

        return false;
    }



    @Override
    public String toString()
    {
        return getName();
    }

}
// NameEntity