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

package jp.go.aist.six.oval.model.linux;

import java.io.Serializable;
import java.util.HashMap;



/**
 * The set of possible outcomes of checking an attribute of a file
 * included in an RPM against the actual value of that attribute
 * in the RPM database.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public final class RpmVerifyResult
    implements Serializable
{

    private static final String  _PASS_           = "pass";
    private static final String  _FAIL_           = "fail";
    private static final String  _NOT_PERFORMED_  = "not performed";


    public static final RpmVerifyResult  PASS           = new RpmVerifyResult( _PASS_ );
    public static final RpmVerifyResult  FAIL           = new RpmVerifyResult( _FAIL_ );
    public static final RpmVerifyResult  NOT_PERFORMED  = new RpmVerifyResult( _NOT_PERFORMED_ );



    private static HashMap<String, RpmVerifyResult> _INIT_()
    {
        HashMap<String, RpmVerifyResult>  map = new HashMap<String, RpmVerifyResult>();
        map.put( _PASS_,           PASS          );
        map.put( _FAIL_,           FAIL          );
        map.put( _NOT_PERFORMED_,  NOT_PERFORMED );
        return map;
    }

    private static final HashMap<String, RpmVerifyResult>  _INSTANCES_ = _INIT_();




    /**
     */
    public static RpmVerifyResult valueOf(
                    final String name
                    )
    {
        RpmVerifyResult  flag = null;
        if (name != null) {
            flag = _INSTANCES_.get( name );
        }

        if (flag == null) {
            throw new IllegalArgumentException( "invalid RPM verify result: " + name );
        }

        return flag;
    }




    private String  _name = null;



    /**
     * Constructor.
     */
    private RpmVerifyResult(
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
// RpmVerifyResult
