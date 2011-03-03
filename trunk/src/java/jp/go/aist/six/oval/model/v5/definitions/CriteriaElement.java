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

import jp.go.aist.six.oval.model.AbstractOvalObject;
import jp.go.aist.six.util.persist.Dependent;



/**
 * An abstract base class for Criteria, Criterion, and ExtendDefinition.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class CriteriaElement
    extends AbstractOvalObject
    implements Dependent<Definition>
{

    public static final boolean  DEFAULT_NEGATE = false;
    private boolean  _negate = DEFAULT_NEGATE;
    //{xsd:boolean, optional, default="false"}

    private String  _comment;
    //{xsd:string, optional}



    /**
     * Constructor.
     */
    public CriteriaElement()
    {
    }


    /**
     * Constructor.
     */
    public CriteriaElement(
                    final String comment
                    )
    {
        setComment( comment );
    }



    /**
     */
    public void setNegate(
                    final boolean negate
                    )
    {
        _negate = negate;
    }


    public boolean isNegate()
    {
        return _negate;
    }



    /**
     */
    public void setComment(
                    final String comment
                    )
    {
        _comment = comment;
    }


    public String getComment()
    {
        return _comment;
    }



    //**************************************************************
    //  Dependent
    //**************************************************************

    private Definition  _master;



    public void setMasterObject(
                    final Definition master
                    )
    {
        _master = master;
    }


    public Definition getMasterObject()
    {
        return _master;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        result = prime * result + (isNegate() ? 0 : 1);

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

        if (!(obj instanceof CriteriaElement)) {
            return false;
        }

        CriteriaElement  other = (CriteriaElement)obj;
        if (this.isNegate() == other.isNegate()) {
            return true;
        }

        return false;
    }

}
// CriteriaElement
