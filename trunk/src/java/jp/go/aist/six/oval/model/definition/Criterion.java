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




/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class Criterion
    extends CriteriaElement
{

    private String  _testRef;
    //{oval:TestIDPattern, required}



    /**
     * Constructor.
     */
    public Criterion()
    {
    }


    /**
     * Constructor.
     */
    public Criterion(
                    final String testID
                    )
    {
        setTestRef( testID );
    }



    public void setTestRef(
                    final String testID
                    )
    {
        _testRef = testID;
    }


    public String getTestRef()
    {
        return _testRef;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "Criterion[negate=" + isNegate()
                        + ", test_ref=" + getTestRef()
                        + ", comment=" + getComment()
                        + "]";
    }

}
// Criterion
