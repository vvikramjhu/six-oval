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

import jp.go.aist.six.oval.model.OvalAnalysisElement;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id: OvalResultElement.java 739 2010-05-07 08:11:01Z akihito $
 */
public abstract class OvalResultElement
    extends OvalAnalysisElement
{

    private Result  _result;
    //{required} // oval-res:DefinitionType



    /**
     * Constructor.
     */
    public OvalResultElement()
    {
    }


    /**
     * Constructor.
     */
    public OvalResultElement(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    /**
     * Constructor.
     */
    public OvalResultElement(
                    final String id,
                    final int version,
                    final Result result
                    )
    {
        this( id, version );
        setResult( result );
    }



    /**
     */
    public void setResult(
                    final Result result
                    )
    {
        _result= result;
    }


    public Result getResult()
    {
        return _result;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return super.toString()
                        + ", result=" + getResult();
    }

}
// OvalResultElement
