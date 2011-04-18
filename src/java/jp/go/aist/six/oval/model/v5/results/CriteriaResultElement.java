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

package jp.go.aist.six.oval.model.v5.results;

import jp.go.aist.six.oval.model.v5.AbstractOvalObject;



/**
 * An abstract base class for the criteria-related types.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class CriteriaResultElement
    extends AbstractOvalObject
{

    public static final Boolean  DEFAULT_NEGATE = Boolean.FALSE;
    private Boolean  _negate;
    //{xsd:boolean, optional, default="false"}

    private ResultEnumeration  _result;
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
        _negate = negate;
    }


    public Boolean isNegate()
    {
        return _negate;
    }



    /**
     */
    public void setResult(
                    final ResultEnumeration result
                    )
    {
        _result= result;
    }


    public ResultEnumeration getResult()
    {
        return _result;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "result=" + getResult()
                        + ", negate=" + isNegate();
    }

}
// CriteriaResultElement
