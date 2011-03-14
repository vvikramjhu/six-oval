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

package jp.go.aist.six.oval.model.v5.results;

import jp.go.aist.six.oval.model.v5.OvalDocument;
import jp.go.aist.six.oval.model.v5.common.GeneratorType;



/**
 * The OvalResults represents an OVAL Results Document.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class OvalResults
    extends OvalDocument
{

    private GeneratorType  _generator = new GeneratorType();
    //{1..1}

    private DefaultDirectivesType  _directives = new DefaultDirectivesType();
    //{1..1}

//    private Collection<ClassDirectives>  _classDirectives = new ArrayList<ClassDirectives>();
//    //{0..5}
//
//    private OvalDefinitions  _ovalDefinitions;
//    //{0..1}

    private ResultsType  _results;
    //{1..1}



    /**
     * Constructor.
     */
    public OvalResults()
    {
    }


//    public OvalResults(
//                    final Generator generator,
//                    final DefaultDirectives directives,
//                    final SystemResults results
//                    )
//    {
//        setGenerator( generator );
//        setDirectives( directives );
//        setResults( results );
//    }
//
//
//    public OvalResults(
//                    final Generator generator,
//                    final DefaultDirectives directives,
//                    final SystemResult[] results
//                    )
//    {
//        setGenerator( generator );
//        setDirectives( directives );
//        setResults( new SystemResults( results ) );
//    }




    /**
     */
    public void setGenerator(
                    final GeneratorType generator
                    )
    {
        _generator = generator;
    }


    public GeneratorType getGenerator()
    {
        return _generator;
    }



    /**
     */
    public void setDirectives(
                    final DefaultDirectivesType directives
                    )
    {
        _directives = directives;
    }


    public DefaultDirectivesType getDirectives()
    {
        return _directives;
    }



//    public void setClassDirectives(
//                    final Collection<? extends ClassDirectives> classDirectives
//                    )
//    {
//        if (classDirectives != _classDirectives) {
//            _classDirectives.clear();
//            if (classDirectives != null  &&  classDirectives.size() > 0) {
//                _classDirectives.addAll( classDirectives );
//            }
//        }
//    }
//
//
//    public boolean addClassDirectives(
//                    final ClassDirectives classDirectives
//                    )
//    {
//        return _classDirectives.add( classDirectives );
//    }
//
//
//    public Collection<ClassDirectives> getClassDirectives()
//    {
//        return _classDirectives;
//    }
//
//
//    public Iterator<ClassDirectives> iterateClassDirectives()
//    {
//        return _classDirectives.iterator();
//    }
//
//
//
//    /**
//     */
//    public void setOvalDefinitions(
//                    final OvalDefinitions definitions
//                    )
//    {
//        _ovalDefinitions = definitions;
//    }
//
//
//    public OvalResults ovalDefinitions(
//                    final OvalDefinitions definitions
//                    )
//    {
//        setOvalDefinitions( definitions );
//        return this;
//    }
//
//
//    public OvalDefinitions getOvalDefinitions()
//    {
//        return _ovalDefinitions;
//    }



    /**
     */
    public void setResults(
                    final ResultsType results
                    )
    {
        _results = results;
    }


    public ResultsType getResults()
    {
        return _results;
    }


    public OvalResults result(
                    final SystemType system
                    )
    {
        ResultsType  results = getResults();
        if (results == null) {
            results = new ResultsType();
            setResults( results );
        }
        results.addSystem( system );

        return this;
    }



    //**************************************************************
    //  OvalDocument
    //**************************************************************

//    @Override
//    public String getSchemaLocation()
//    {
//        return RESULTS_SCHEMA_LOCATION;
//    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "oval_results[generator=" + getGenerator()
//                        + ", directives=" + getDirectives()
//                        + ", class_directives=" + getClassDirectives()
                        + ", results=" + getResults()
                        + "]";
    }

}
// OvalResults
