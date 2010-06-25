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

package jp.go.aist.six.oval.model.result;

import jp.go.aist.six.oval.model.common.Generator;
import jp.go.aist.six.oval.model.definition.OvalDefinitions;
import jp.go.aist.six.util.orm.AbstractPersistable;
import java.util.ArrayList;
import java.util.Collection;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: OvalResults.java 757 2010-05-10 06:25:22Z akihito $
 */
public class OvalResults
    extends AbstractPersistable
{

    private Generator  _generator;
    //{1..1}

    private Directives  _directives;
    //{1..1}

    private OvalDefinitions  _definitions;
    //{0..1}

    // ./results
    //{1..1}
    private Collection<SystemResult>  _results = new ArrayList<SystemResult>();
    //{1..*}



    public OvalResults()
    {
    }



    /**
     */
    public void setGenerator(
                    final Generator generator
                    )
    {
        _generator = generator;
    }


    public Generator getGenerator()
    {
        return _generator;
    }



    /**
     */
    public void setDirectives(
                    final Directives directives
                    )
    {
        _directives = directives;
    }


    /**
     */
    public Directives getDirectives()
    {
        return _directives;
    }



    public void setDefinitions(
                    final OvalDefinitions definitions
                    )
    {
        _definitions = definitions;
    }


    public OvalDefinitions getDefinitions()
    {
        return _definitions;
    }



    public void setResults(
                    final Collection<SystemResult> results
                    )
    {
        if (results != _results) {
            _results.clear();
            if (results == null  ||  results.size() == 0) {
                return;
            }

            for (SystemResult  system : results) {
                addResult( system );
            }
        }
    }


    public boolean addResult(
                    final SystemResult result
                    )
    {
        if (result == null) {
            return false;
        }

//        System.out.println( "### setting the container OvalResults ###" );
//        system.setMasterObject( this );
        return _results.add( result );
    }


    public Collection<SystemResult> getResults()
    {
//        System.out.println( "### OvalResults.getSystems() ###" );
        return _results;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "OvalResults[generator=" + getGenerator()
                        + ", results=" + getResults()
                        + "]";
    }

}
// OvalResults
