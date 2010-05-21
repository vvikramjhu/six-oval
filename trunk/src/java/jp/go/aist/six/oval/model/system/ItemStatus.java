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

package jp.go.aist.six.oval.model.system;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: ItemStatus.java 738 2010-05-07 07:10:20Z akihito $
 */
public final class ItemStatus
    implements Serializable
{

    private static final String  _ERROR_           = "error";
    private static final String  _EXISTS_          = "exists";
    private static final String  _DOES_NOT_EXIST_  = "does not exist";
    private static final String  _NOT_COLLECTED_   = "not collected";


    public static final ItemStatus  ERROR          = new ItemStatus( _ERROR_ );
    public static final ItemStatus  EXISTS         = new ItemStatus( _EXISTS_ );
    public static final ItemStatus  DOES_NOT_EXIST = new ItemStatus( _DOES_NOT_EXIST_ );
    public static final ItemStatus  NOT_COLLECTED  = new ItemStatus( _NOT_COLLECTED_ );


    private static HashMap<String, ItemStatus> _INIT_()
    {
        HashMap<String, ItemStatus>  map = new HashMap<String, ItemStatus>();
        map.put( _ERROR_,           ERROR          );
        map.put( _EXISTS_,          EXISTS         );
        map.put( _DOES_NOT_EXIST_,  DOES_NOT_EXIST );
        map.put( _NOT_COLLECTED_,   NOT_COLLECTED  );
        return map;
    }

    private static final HashMap<String, ItemStatus>  _INSTANCES_ = _INIT_();




    /**
     */
    public static ItemStatus valueOf(
                    final String name
                    )
    {
        ItemStatus  status = null;
        if (name != null) {
            status = _INSTANCES_.get( name );
        }

        if (status == null) {
            throw new IllegalArgumentException( "invalid item status: " + name );
        }

        return status;
    }



    private String  _name = null;



    /**
     */
    private ItemStatus(
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
// ItemStatus

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

