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

package jp.go.aist.six.oval.model.definition;

import jp.go.aist.six.oval.core.model.ComponentType;
import jp.go.aist.six.oval.model.CommentedOvalEntity;
import jp.go.aist.six.oval.model.common.Check;
import jp.go.aist.six.oval.model.common.Existence;


/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id: Test.java 696 2010-04-26 10:22:00Z akihito $
 */
public abstract class Test
    extends CommentedOvalEntity //, Noted
{

    public static final Existence  DEFAULT_CHECK_EXISTENCE = Existence.AT_LEAST_ONE_EXISTS;

    private Existence  _checkExistence = DEFAULT_CHECK_EXISTENCE;
    //{optional, default="at_least_one_exists"}

    private Check  _check;
    //{required}



    /**
     * Constructor.
     */
    public Test()
    {
    }


    /**
     * Constructor.
     */
    public Test(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    /**
     * Constructor.
     */
    public Test(
                    final String id,
                    final int version,
                    final Check check
                    )
    {
        super( id, version );
        setCheck( check );
    }




    public void setCheck(
                    final Check check
                    )
    {
        _check = check;
    }


    public Check getCheck()
    {
        return _check;
    }



    public void setCheckExistence(
                    final Existence existence
                    )
    {
        _checkExistence = existence;
    }


    public Existence getCheckExistence()
    {
        return _checkExistence;
    }



    public void setTestType(
                    final ComponentType type
                    )
    {
    }


    public abstract ComponentType getTestType();




    //**************************************************************
    //  Noted
    //**************************************************************

//    public void setNotes( final Notes notes )
//    {
//        _notes = notes;
//    }
//
//
//    public Notes getNotes()
//    {
//        return _notes;
//    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        return super.hashCode();
    }



    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof Test)) {
            return false;
        }

        return super.equals( obj );
    }



    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return super.toString()
                        + ", check_existence=" + getCheckExistence()
                        + ", check=" + getCheck();
//                        + ", notes=" + getNotes();
    }

}
// Test
