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



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class CriterionResult
    extends CriteriaResultLeafElement
{

    /**
     * Constructor.
     */
    public CriterionResult()
    {
    }


    /**
     * Constructor.
     */
    public CriterionResult(
                    final String testID,
                    final int version
                    )
    {
        super( testID, version );
    }


    /**
     * Constructor.
     */
    public CriterionResult(
                    final String id,
                    final int version,
                    final Result result
                    )
    {
        super( id, version, result );
    }



    public void setTestRef(
                    final String testID
                    )
    {
        _setEntityRef( testID );
    }


    public String getTestRef()
    {
        return _getEntityRef();
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "Criterion[test_ref=" + getTestRef()
                        + ", " + super.toString()
                        + "]";
    }

}
// CriterionResult
