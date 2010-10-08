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

package jp.go.aist.six.oval.model.common;

import java.io.Serializable;
import java.util.HashMap;



/**
 * The Operation defines acceptable operations.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public final class Operation
    implements Serializable
{

    private static final String  _EQUALS_                      = "equals";
    private static final String  _NOT_EQUAL_                   = "not equal";
    private static final String  _CASE_INSENSITIVE_EQUALS_     = "case insensitive equals";
    private static final String  _CASE_INSENSITIVE_NOT_EQUAL_  = "case insensitive not equal";
    private static final String  _GREATER_THAN_                = "greater than";
    private static final String  _GREATER_THAN_OR_EQUAL_       = "greater than or equal";
    private static final String  _LESS_THAN_                   = "less than";
    private static final String  _LESS_THAN_OR_EQUAL_          = "less than or equal";
    private static final String  _BITWISE_AND_                 = "bitwise and";
    private static final String  _BITWISE_OR_                  = "bitwise or";
    private static final String  _PATTERN_MATCH_               = "pattern match";
    private static final String  _SUBSET_OF_                   = "subset of";
    private static final String  _SUPERSET_OF_                 = "superset of";


    public static final Operation  EQUALS                      = new Operation( _EQUALS_ );
    public static final Operation  NOT_EQUAL                   = new Operation( _NOT_EQUAL_ );
    public static final Operation  CASE_INSENSITIVE_EQUALS     = new Operation( _CASE_INSENSITIVE_EQUALS_ );
    public static final Operation  CASE_INSENSITIVE_NOT_EQUAL  = new Operation( _CASE_INSENSITIVE_NOT_EQUAL_ );
    public static final Operation  GREATER_THAN                = new Operation( _GREATER_THAN_ );
    public static final Operation  GREATER_THAN_OR_EQUAL       = new Operation( _GREATER_THAN_OR_EQUAL_ );
    public static final Operation  LESS_THAN                   = new Operation( _LESS_THAN_ );
    public static final Operation  LESS_THAN_OR_EQUAL          = new Operation( _LESS_THAN_OR_EQUAL_ );
    public static final Operation  BITWISE_AND                 = new Operation( _BITWISE_AND_ );
    public static final Operation  BITWISE_OR                  = new Operation( _BITWISE_OR_ );
    public static final Operation  PATTERN_MATCH               = new Operation( _PATTERN_MATCH_ );
    public static final Operation  SUBSET_OF                   = new Operation( _SUBSET_OF_ );
    public static final Operation  SUPERSET_OF                 = new Operation( _SUPERSET_OF_ );



    private static HashMap<String, Operation> _INIT_()
    {
        HashMap<String, Operation>  map = new HashMap<String, Operation>();
        map.put( _EQUALS_,                      EQUALS                     );
        map.put( _NOT_EQUAL_,                   NOT_EQUAL                  );
        map.put( _CASE_INSENSITIVE_EQUALS_,     CASE_INSENSITIVE_EQUALS    );
        map.put( _CASE_INSENSITIVE_NOT_EQUAL_,  CASE_INSENSITIVE_NOT_EQUAL );
        map.put( _GREATER_THAN_,                GREATER_THAN               );
        map.put( _GREATER_THAN_OR_EQUAL_,       GREATER_THAN_OR_EQUAL      );
        map.put( _LESS_THAN_,                   LESS_THAN                  );
        map.put( _LESS_THAN_OR_EQUAL_,          LESS_THAN_OR_EQUAL         );
        map.put( _BITWISE_AND_,                 BITWISE_AND                );
        map.put( _BITWISE_OR_,                  BITWISE_OR                 );
        map.put( _PATTERN_MATCH_,               PATTERN_MATCH              );
        map.put( _SUBSET_OF_,                   SUBSET_OF                  );
        map.put( _SUPERSET_OF_,                 SUPERSET_OF                );
        return map;
    }

    private static final HashMap<String, Operation>  _INSTANCES_ = _INIT_();




    /**
     */
    public static Operation valueOf(
                    final String name
                    )
    {
        Operation  flag = null;
        if (name != null) {
            flag = _INSTANCES_.get( name );
        }

        if (flag == null) {
            throw new IllegalArgumentException( "invalid operation: " + name );
        }

        return flag;
    }



    private String  _name = null;



    /**
     * Constrcutor.
     */
    private Operation(
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
// Operation
