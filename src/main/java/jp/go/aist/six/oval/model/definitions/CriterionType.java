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

import jp.go.aist.six.oval.model.ElementRef;
import jp.go.aist.six.oval.model.ElementType;



/**
 * The Criterion identifies a specific test
 * to be included in the definition's criteria.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class CriterionType
    extends CriteriaElement
    implements ElementRef
{

    private String  test_ref;
    //{required, oval:TestIDPattern}



    /**
     * Constructor.
     */
    public CriterionType()
    {
    }


    public CriterionType(
                    final String testID
                    )
    {
        this( testID, null );
    }


    public CriterionType(
                    final String testID,
                    final String comment
                    )
    {
        super( comment );
        setTestRef( testID );
    }



    /**
     */
    public void setTestRef(
                    final String testID
                    )
    {
        test_ref = testID;
    }


    public String getTestRef()
    {
        return test_ref;
    }



    //*********************************************************************
    //  ElementRef
    //*********************************************************************

    @Override
    public String ovalGetRefId()
    {
        return getTestRef();
    }



    @Override
    public ElementType ovalGetRefType()
    {
        return ElementType.TEST;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = super.hashCode();

        String  testRef = getTestRef();
        result = prime * result + ((testRef == null) ? 0 : testRef.hashCode());

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

        if (!(obj instanceof CriterionType)) {
            return false;
        }

        if (super.equals( obj )) {
            CriterionType  other = (CriterionType)obj;
            String  other_testRef = other.getTestRef();
            String   this_testRef =  this.getTestRef();
            if (this_testRef == other_testRef
                            ||  (this_testRef != null
                                            &&  this_testRef.equals( other_testRef ))) {
                return true;
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "criterion[negate=" + getNegate()
                        + ", test_ref=" + getTestRef()
                        + ", comment=" + getComment()
                        + "]";
    }

}
// CriterionType
