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

package jp.go.aist.six.oval.model.results;

import jp.go.aist.six.oval.model.Oval5Object;




/**
 * An abstract base class for the criteria-related types.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class CriteriaResultElement
    implements Oval5Object
{

    public static final Boolean  DEFAULT_NEGATE = Boolean.FALSE;

    private Boolean  negate;
    //{xsd:boolean, optional, default="false"}


    private ResultEnumeration  result;
    //{required}



    /**
     * Constructor.
     */
    public CriteriaResultElement()
    {
    }


    public CriteriaResultElement(
                    final ResultEnumeration result
                    )
    {
        setResult( result );
    }


//    public CriteriaResultElement(
//                    final ResultEnumeration result,
//                    final boolean negate
//                    )
//    {
//        setResult( result );
//        setNegate( negate );
//    }



    /**
     */
    public void setNegate(
                    final Boolean negate
                    )
    {
        this.negate = negate;
    }


    public Boolean isNegate()
    {
        return this.negate;
    }



    /**
     */
    public void setResult(
                    final ResultEnumeration result
                    )
    {
        this.result = result;
    }


    public ResultEnumeration getResult()
    {
        return this.result;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "negate=" + isNegate()
                        + ", result=" + getResult()
                        ;
    }

}
// CriteriaResultElement
