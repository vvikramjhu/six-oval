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
import java.util.Iterator;



/**
 * The OvalResults represents an OVAL Results Document.
 *
 * <p>Properties:</p>
 * <ul>
 *   <li>generator (1..1)</li>
 *   <li>directives (1..1)</li>
 *   <li>class_directives (0..5)</li>
 *   <li>oval_definitions (0..1)</li>
 *   <li>results (1..1)</li>
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
    //{0..5}

    private OvalDefinitions  _ovalDefinitions;
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



    public void setClassDirectives(
                    final Collection<? extends ClassDirectives> classDirectives
                    )
    {
        if (classDirectives != _classDirectives) {
            _classDirectives.clear();
            if (classDirectives != null  &&  classDirectives.size() > 0) {
                _classDirectives.addAll( classDirectives );
            }
        }
    }


    public boolean addClassDirectives(
                    final ClassDirectives classDirectives
                    )
    {
        return _classDirectives.add( classDirectives );
    }


    public Collection<ClassDirectives> getClassDirectives()
    {
        return _classDirectives;
    }


    public Iterator<ClassDirectives> iterateClassDirectives()
    {
        return _classDirectives.iterator();
    }



    /**
     */
    public void setOvalDefinitions(
                    final OvalDefinitions definitions
                    )
    {
        _ovalDefinitions = definitions;
    }


    public OvalResults ovalDefinitions(
                    final OvalDefinitions definitions
                    )
    {
        setOvalDefinitions( definitions );
        return this;
    }


    public OvalDefinitions getOvalDefinitions()
    {
        return _ovalDefinitions;
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
                        + ", class_directives=" + getClassDirectives()
                        + ", results=" + getResults()
                        + "]";
    }

}
// OvalResults
