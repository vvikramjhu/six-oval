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

import jp.go.aist.six.oval.model.OvalDocument;
import jp.go.aist.six.oval.model.common.Generator;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalResults
    extends OvalDocument
{

    private Generator  _generator = new Generator();
    //{1..1}

    private Directives  _directives = new Directives();
    //{1..1}

    private OvalDefinitions  _definitions;
    //{0..1}

    private SystemResults  _results = new SystemResults();
    //{1..1}



    /**
     * Constructor.
     */
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


    public Directives getDirectives()
    {
        return _directives;
    }



    /**
     */
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



    /**
     */
    public void setResults(
                    final SystemResults results
                    )
    {
        _results = results;
    }


    public SystemResults getResults()
    {
        return _results;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "OvalResults[generator=" + getGenerator()
                        + ", directives=" + getDirectives()
                        + ", results=" + getResults()
                        + "]";
    }

}
// OvalResults
