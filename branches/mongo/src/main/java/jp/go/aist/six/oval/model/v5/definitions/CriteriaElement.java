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

import jp.go.aist.six.util.persist.Dependent;



/**
 * An abstract base class for Criteria, Criterion, and ExtendDefinition.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class CriteriaElement
//    extends AbstractOvalObject
    implements Dependent<DefinitionType>
{

    public static final Boolean  DEFAULT_NEGATE = Boolean.FALSE;
    private Boolean  negate;
    //{optional, xsd:boolean, default="false"}

    private String  comment;
    //{optional}



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
                    final Boolean negate
                    )
    {
        this.negate = negate;
    }


    public Boolean getNegate()
    {
        return this.negate;
    }



    /**
     */
    public void setComment(
                    final String comment
                    )
    {
        this.comment = comment;
    }


    public String getComment()
    {
        return this.comment;
    }



    //**************************************************************
    //  Dependent
    //**************************************************************

    private DefinitionType  _master;



    @Override
    public void setMasterObject(
                    final DefinitionType master
                    )
    {
        _master = master;
    }


    @Override
    public DefinitionType getMasterObject()
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

        Boolean  negate = getNegate();
        if (negate == null) {
            negate = DEFAULT_NEGATE;
        }
        result = prime * result + (negate ? 0 : 1);

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
        Boolean  otherNegate = other.getNegate();
        if (otherNegate == null) {
            otherNegate = DEFAULT_NEGATE;
        }
        Boolean  thisNegate = this.getNegate();
        if (thisNegate == null) {
            thisNegate = DEFAULT_NEGATE;
        }
        if (thisNegate.booleanValue() == otherNegate.booleanValue()) {
            return true;
        }

        return false;
    }

}
// CriteriaElement
