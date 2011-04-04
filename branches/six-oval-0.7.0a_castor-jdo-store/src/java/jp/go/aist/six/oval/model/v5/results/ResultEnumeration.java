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

import java.io.Serializable;
import java.util.HashMap;



/**
 * The Result enumeration defines the acceptable result values
 * for the DefinitionResult, CriteriaResult, CriterionResult,
 * ExtendDefinitionResult, TestResult, and TestedItem constructs.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public final class ResultEnumeration
    implements Serializable
{

    private static final String  _TRUE_            = "true";
    private static final String  _FALSE_           = "false";
    private static final String  _UNKNOWN_         = "unknown";
    private static final String  _ERROR_           = "error";
    private static final String  _NOT_EVALUATED_   = "not evaluated";
    private static final String  _NOT_APPLICABLE_  = "not applicable";


    public static final ResultEnumeration  TRUE           = new ResultEnumeration( _TRUE_ );
    public static final ResultEnumeration  FALSE          = new ResultEnumeration( _FALSE_ );
    public static final ResultEnumeration  UNKNOWN        = new ResultEnumeration( _UNKNOWN_ );
    public static final ResultEnumeration  ERROR          = new ResultEnumeration( _ERROR_ );
    public static final ResultEnumeration  NOT_EVALUATED  = new ResultEnumeration( _NOT_EVALUATED_ );
    public static final ResultEnumeration  NOT_APPLICABLE = new ResultEnumeration( _NOT_APPLICABLE_ );



    private static HashMap<String, ResultEnumeration> _INIT_()
    {
        HashMap<String, ResultEnumeration>  map = new HashMap<String, ResultEnumeration>();
        map.put( _TRUE_,           TRUE );
        map.put( _FALSE_,          FALSE );
        map.put( _UNKNOWN_,        UNKNOWN  );
        map.put( _ERROR_,          ERROR );
        map.put( _NOT_EVALUATED_,  NOT_EVALUATED );
        map.put( _NOT_APPLICABLE_, NOT_APPLICABLE );
        return map;
    }

    private static final HashMap<String, ResultEnumeration>  _INSTANCES_ = _INIT_();




    /**
     */
    public static ResultEnumeration valueOf(
                    final String name
                    )
    {
        ResultEnumeration  result = null;
        if (name != null) {
            result = _INSTANCES_.get( name );
        }

        if (result == null) {
            throw new IllegalArgumentException( "invalid result: " + name );
        }

        return result;
    }



    private String  _name = null;



    /**
     */
    private ResultEnumeration(
                    final String name
                    )
    {
        _name = name;
    }



    /**
     */
    public String getName()
    {
        return _name;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return getName();
    }

}
// ResultEnumeration
