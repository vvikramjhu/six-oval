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

package jp.go.aist.six.oval.model.windows;

import jp.go.aist.six.oval.model.OvalEnumeration;



/**
 * The types of a shared resource state.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public enum SharedResourceTypeEnumeration
    implements OvalEnumeration
{

    STYPE_DISKTREE                  ( "STYPE_DISKTREE" ),
    STYPE_DISKTREE_SPECIAL          ( "STYPE_DISKTREE_SPECIAL" ),
    STYPE_DISKTREE_TEMPORARY        ( "STYPE_DISKTREE_TEMPORARY" ),
    STYPE_DISKTREE_SPECIAL_TEMPORARY( "STYPE_DISKTREE_SPECIAL_TEMPORARY" ),
    STYPE_PRINTQ                    ( "STYPE_PRINTQ" ),
    STYPE_PRINTQ_SPECIAL            ( "STYPE_PRINTQ_SPECIAL" ),
    STYPE_PRINTQ_TEMPORARY          ( "STYPE_PRINTQ_TEMPORARY" ),
    STYPE_PRINTQ_SPECIAL_TEMPORARY  ( "STYPE_PRINTQ_SPECIAL_TEMPORARY" ),
    STYPE_DEVICE                    ( "STYPE_DEVICE" ),
    STYPE_DEVICE_SPECIAL            ( "STYPE_DEVICE_SPECIAL" ),
    STYPE_DEVICE_TEMPORARY          ( "STYPE_DEVICE_TEMPORARY" ),
    STYPE_DEVICE_SPECIAL_TEMPORARY  ( "STYPE_DEVICE_SPECIAL_TEMPORARY" ),
    STYPE_IPC                       ( "STYPE_IPC" ),
    STYPE_IPC_SPECIAL               ( "STYPE_IPC_SPECIAL" ),
    STYPE_IPC_TEMPORARY             ( "STYPE_IPC_TEMPORARY" ),
    STYPE_IPC_SPECIAL_TEMPORARY     ( "STYPE_IPC_SPECIAL_TEMPORARY" ),
    STYPE_SPECIAL                   ( "STYPE_SPECIAL" ), 
    STYPE_TEMPORARY                 ( "STYPE_TEMPORARY" ), 
    NONE                            ( "" );



    /**
     * A factory method.
     */
    public static SharedResourceTypeEnumeration fromValue(
                    final String value
                    )
    {
        for (SharedResourceTypeEnumeration  e : SharedResourceTypeEnumeration.values()) {
            if (e.value.equals( value )) {
                return e;
            }
        }

        throw new IllegalArgumentException( value );
    }



    private String  value = null;



    /**
     * Constructor.
     */
    SharedResourceTypeEnumeration(
                    final String value
                    )
    {
        this.value = value;
    }



    @Override
    public String value()
    {
        return this.value;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return this.value;
    }

}
// SharedResourceTypeEnumeration
