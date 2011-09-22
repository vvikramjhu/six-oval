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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import jp.go.aist.six.oval.model.OvalObject;




/**
 * The Set enables complex objects to be described.
 * It is a recursive element in that each set element can contain
 * additional set elements as children.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class Set
    implements OvalObject
{
    /*
     * <choice>
     *   <sequence>
     *     <element ref="set" 1..2 />
     *   </sequence>
     *   <sequence>
     *     <element name="object_reference" 1..2 />
     *     <element ref="filter" 0..* />
     *   </sequence>
     * </choice>
     */

    private final Collection<Set>  set = new ArrayList<Set>( 2 );
    //{1..2}


    private final Collection<String>  object_reference = new ArrayList<String>( 2 );
    //{1..2}


    private final Collection<Filter>  filter = new ArrayList<Filter>();
    //{0..*}


    public static final SetOperatorEnumeration  DEFAULT_SET_OPERATOR =
        SetOperatorEnumeration.UNION;

    private SetOperatorEnumeration  set_operator;
    //{optional, default='UNION'}



    /**
     * Constructor.
     */
    public Set()
    {
    }




    /**
     */
    public void setSet(
                    final Collection<? extends Set> filters
                    )
    {
        if (this.set != filters) {
            int  size = (filters == null ? 0 : filters.size());
            if (filters != null  &&  size > 2) {
                throw new IllegalArgumentException(
                                "invalid number of child 'set' (maxOccurs=2): "
                                + size );
            }

            this.filter.clear();
            if (size > 0) {
                this.set.addAll( filters );
            }
        }
    }


    public boolean addSet(
                    final Set set
                    )
    {
        if (set == null) {
            return false;
        }

        if (this.set.size() >= 2) {
            throw new IllegalStateException(
                            "no more child 'set' can't be added (maxOccurs=2)");
        }

        return this.set.add( set );
    }


    public Collection<Set> getSet()
    {
        return this.set;
    }


    public Iterator<Set> iterateSet()
    {
        return this.set.iterator();
    }



    /**
     */
    public void setObjectReference(
                    final Collection<String> object_references
                    )
    {
        if (this.object_reference != object_references) {
            int  size = (object_references == null ? 0 : object_references.size());
            if (object_references != null  &&  size > 2) {
                throw new IllegalArgumentException(
                                "invalid number of child 'object_reference' (maxOccurs=2): "
                                + size );
            }

            this.object_reference.clear();
            if (size > 0) {
                this.object_reference.addAll( object_references );
            }
        }
    }


    public boolean addObjectReference(
                    final String object_reference
                    )
    {
        if (object_reference == null) {
            return false;
        }

        if (this.object_reference.size() >= 2) {
            throw new IllegalStateException(
                            "no more child 'object_reference' can't be added (maxOccurs=2)");
        }

        return this.object_reference.add( object_reference );
    }


    public Collection<String> getObjectReference()
    {
        return this.object_reference;
    }


    public Iterator<String> iterateObjectReference()
    {
        return this.object_reference.iterator();
    }



    /**
     */
    public void setFilter(
                    final Collection<? extends Filter> filterSeq
                    )
    {
        if (this.filter != filterSeq) {
            this.filter.clear();
            if (filterSeq != null  &&  filterSeq.size() > 0) {
                this.filter.addAll( filterSeq );
            }
        }
    }


    public boolean addFilter(
                    final Filter filter
                    )
    {
        if (filter == null) {
            return false;
        }

        return this.filter.add( filter );
    }


    public Collection<Filter> getFilter()
    {
        return this.filter;
    }


    public Iterator<Filter> iterateFilter()
    {
        return this.filter.iterator();
    }



    /**
     */
    public void setSetOperator(
                    final SetOperatorEnumeration action
                    )
    {
        this.set_operator = action;
    }


    public SetOperatorEnumeration getSetOperator()
    {
        return this.set_operator;
    }


    protected SetOperatorEnumeration _setOperator()
    {
        SetOperatorEnumeration  set_operator = getSetOperator();
        return (set_operator == null ? DEFAULT_SET_OPERATOR : set_operator);
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        SetOperatorEnumeration  set_operator = _setOperator();
        result = prime * result + ((set_operator == null) ? 0 : set_operator.hashCode());

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

        if (!(obj instanceof Set)) {
            return false;
        }

        Set  other = (Set)obj;
        if (this._setOperator() == other._setOperator()) {
            return true;
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "set[set=" + getSet()
             + ", object_reference=" + getObjectReference()
             + ", filter=" + getFilter()
             + ", set_operator=" + getSetOperator()
             + "]";
    }

}
//Set
