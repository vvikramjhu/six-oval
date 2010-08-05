/*
 *  @ProductName@
 *  Copyright (C) @CopyrightYear@
 *    National Institute of Advanced Industrial Science and Technology (AIST)
 *    Registration Number: @AISTRegistrationNumber@
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

import java.io.Serializable;
import java.util.HashMap;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id: Result.java 739 2010-05-07 08:11:01Z akihito $
 */
public final class Result
    implements Serializable
{

    private static final String  _TRUE_            = "true";
    private static final String  _FALSE_           = "false";
    private static final String  _UNKNOWN_         = "unknown";
    private static final String  _ERROR_           = "error";
    private static final String  _NOT_EVALUATED_   = "not evaluated";
    private static final String  _NOT_APPLICABLE_  = "not applicable";


    public static final Result  TRUE           = new Result( _TRUE_ );
    public static final Result  FALSE          = new Result( _FALSE_ );
    public static final Result  UNKNOWN        = new Result( _UNKNOWN_ );
    public static final Result  ERROR          = new Result( _ERROR_ );
    public static final Result  NOT_EVALUATED  = new Result( _NOT_EVALUATED_ );
    public static final Result  NOT_APPLICABLE = new Result( _NOT_APPLICABLE_ );



    private static HashMap<String, Result> _INIT_()
    {
        HashMap<String, Result>  map = new HashMap<String, Result>();
        map.put( _TRUE_,           TRUE );
        map.put( _FALSE_,          FALSE );
        map.put( _UNKNOWN_,        UNKNOWN  );
        map.put( _ERROR_,          ERROR );
        map.put( _NOT_EVALUATED_,  NOT_EVALUATED );
        map.put( _NOT_APPLICABLE_, NOT_APPLICABLE );
        return map;
    }

    private static final HashMap<String, Result>  _INSTANCES_ = _INIT_();




    /**
     */
    public static Result valueOf(
                    final String name
                    )
    {
        Result  result = null;
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
    private Result(
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
// Result
