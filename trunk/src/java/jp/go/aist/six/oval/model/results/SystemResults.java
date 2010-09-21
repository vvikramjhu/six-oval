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

import jp.go.aist.six.oval.model.Container;
import java.util.Collection;
import java.util.Iterator;



/**
 * A collection of System instances.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class SystemResults
    extends Container<SystemResult> //{1..*}
{

    /**
     * Constructor.
     */
    public SystemResults()
    {
    }


    /**
     * Constructor.
     */
    public SystemResults(
                    final Collection<? extends SystemResult> results
                    )
    {
        super( results );
    }


    /**
     * Constructor.
     */
    public SystemResults(
                    final SystemResult[] results
                    )
    {
        super( results );
    }



    public void setResult(
                    final Collection<? extends SystemResult> results
                    )
    {
        _setElement( results );
    }


    public boolean addResult(
                    final SystemResult result
                    )
    {
        return add( result );
    }


    public Collection<SystemResult> getResult()
    {
        return _getElement();
    }


    public Iterator<SystemResult> iterateResult()
    {
        return iterator();
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "results["
                        + super.toString()
                        + "]";
    }

}
// SystemResults
