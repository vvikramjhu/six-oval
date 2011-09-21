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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import jp.go.aist.six.oval.model.OvalDocument;
import jp.go.aist.six.oval.model.common.GeneratorType;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import com.google.code.morphia.annotations.Entity;



/**
 * The OvalResults represents an OVAL Results Document.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
@Entity( "oval.r.oval_results" )
public class OvalResults
    extends OvalDocument
{

//    private GeneratorType  generator = new GeneratorType();
//    //{1..1}


    private DefaultDirectivesType  directives = new DefaultDirectivesType();
    //{1..1}


    private final Collection<ClassDirectivesType>  class_directives = new ArrayList<ClassDirectivesType>();
    //{0..5}


//    @Reference
    private OvalDefinitions  oval_definitions;
    //{0..1}


    private ResultsType  results;
    //{1..1}



    /**
     * Constructor.
     */
    public OvalResults()
    {
    }


    public OvalResults(
                    final GeneratorType generator
                    )
    {
        super( generator );
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




//    /**
//     */
//    public void setGenerator(
//                    final GeneratorType generator
//                    )
//    {
//        this.generator = generator;
//    }
//
//
//    public GeneratorType getGenerator()
//    {
//        return this.generator;
//    }



    /**
     */
    public void setDirectives(
                    final DefaultDirectivesType directives
                    )
    {
        this.directives = directives;
    }


    public DefaultDirectivesType getDirectives()
    {
        return this.directives;
    }



    public void setClassDirectives(
                    final Collection<? extends ClassDirectivesType> classDirectives
                    )
    {
        if (classDirectives != this.class_directives) {
            this.class_directives.clear();
            if (classDirectives != null  &&  classDirectives.size() > 0) {
                this.class_directives.addAll( classDirectives );
            }
        }
    }


    public boolean addClassDirectives(
                    final ClassDirectivesType classDirectives
                    )
    {
        return this.class_directives.add( classDirectives );
    }


    public Collection<ClassDirectivesType> getClassDirectives()
    {
        return this.class_directives;
    }


    public Iterator<ClassDirectivesType> iterateClassDirectives()
    {
        return this.class_directives.iterator();
    }



    /**
     */
    public void setOvalDefinitions(
                    final OvalDefinitions definitions
                    )
    {
        this.oval_definitions = definitions;
    }


    public OvalDefinitions getOvalDefinitions()
    {
        return this.oval_definitions;
    }


    public OvalResults ovalDefinitions(
                    final OvalDefinitions definitions
                    )
    {
        setOvalDefinitions( definitions );
        return this;
    }



    /**
     */
    public void setResults(
                    final ResultsType results
                    )
    {
        this.results = results;
    }


    public ResultsType getResults()
    {
        return this.results;
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
                        + ", directives=" + getDirectives()
                        + ", class_directives=" + getClassDirectives()
                        + ", oval_definitions=" + getOvalDefinitions()
                        + ", results=" + getResults()
                        + "]";
    }

}
// OvalResults
