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

package jp.go.aist.six.oval.model.results;

import jp.go.aist.six.oval.model.OvalDocument;
import jp.go.aist.six.oval.model.common.Generator;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import java.util.ArrayList;
import java.util.Collection;



/**
 * The OvalResults represents an OVAL Results Document.
 *
 * <p>Properties:</p>
 * <ul>
 *   <li>generator (1..1)</li>
 *   <li>directives (0..1)</li>
 *   <li>oval_definitions (0..1)</li>
 *   <li>results (0..1)</li>
 *   <li>signature (0..1): currently NOT supported.</li>
 * </ul>
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class OvalResults
    extends OvalDocument
{

    private Generator  _generator = new Generator();
    //{1..1}

    private DefaultDirectives  _directives = new DefaultDirectives();
    //{1..1}

    private Collection<ClassDirectives>  _classDirectives = new ArrayList<ClassDirectives>();
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
     * Constructor.
     */
    public OvalResults(
                    final Generator generator,
                    final DefaultDirectives directives,
                    final SystemResults results
                    )
    {
        setGenerator( generator );
        setDirectives( directives );
        setResults( results );
    }


    /**
     * Constructor.
     */
    public OvalResults(
                    final Generator generator,
                    final DefaultDirectives directives,
                    final SystemResult[] results
                    )
    {
        setGenerator( generator );
        setDirectives( directives );
        setResults( new SystemResults( results ) );
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
                    final DefaultDirectives directives
                    )
    {
        _directives = directives;
    }


    public DefaultDirectives getDirectives()
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


    public OvalResults definitions(
                    final OvalDefinitions definitions
                    )
    {
        setDefinitions( definitions );
        return this;
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


    public OvalResults result(
                    final SystemResult result
                    )
    {
        SystemResults  results = getResults();
        if (results == null) {
            results = new SystemResults();
            setResults( results );
        }
        results.addSystem( result );

        return this;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "oval_results[generator=" + getGenerator()
                        + ", directives=" + getDirectives()
                        + ", results=" + getResults()
                        + "]";
    }

}
// OvalResults
