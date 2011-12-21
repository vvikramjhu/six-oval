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
 * The PossibleRestrictionType outlines a range of possible expected value
 * of an external variable.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class PossibleRestrictionType
    implements OvalObject
{

    private final Collection<RestrictionType>  restriction = new ArrayList<RestrictionType>();
    //{1..*}

    private String  hint;
    //{required}



    /**
     * Constructor.
     */
    public PossibleRestrictionType()
    {
    }



    /**
     */
    public void setRestriction(
                    final Collection<? extends RestrictionType> restrictions
                    )
    {
        if (restrictions != this.restriction) {
            this.restriction.clear();
            if (restrictions != null  &&  restrictions.size() > 0) {
                for (RestrictionType  restriction : restrictions) {
                    addRestriction( restriction );
                }
//                this.restriction.addAll( restrictions );
            }
        }
    }


    public boolean addRestriction(
                    final RestrictionType restriction
                    )
    {
        if (restriction == null) {
            return false;
        }

        return this.restriction.add( restriction );
    }


    public Collection<RestrictionType> getRestriction()
    {
        return this.restriction;
    }


    public Iterator<RestrictionType> iterateRestriction()
    {
        return this.restriction.iterator();
    }



    /**
     */
    public void setHint(
                    final String hint
                    )
    {
        this.hint = hint;
    }


    public String getHint()
    {
        return this.hint;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "[restriction="  + getRestriction()
                        + ", hint=" + getHint()
                        + "]";
    }

}
//PossibleRestrictionType
