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

package jp.go.aist.six.oval.model.v5.definitions;

import jp.go.aist.six.oval.model.OvalDocument;
import jp.go.aist.six.oval.model.v5.common.GeneratorType;
import com.google.code.morphia.annotations.Entity;



/**
 * An OVAL Definition Document.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
@Entity( "oval.d.oval_definitions" )
public class OvalDefinitions
    extends OvalDocument
{

//    private GeneratorType  generator = new GeneratorType();
//    //{1..1}


    private DefinitionsType  definitions;
    //{0..1}


    private TestsType  tests;
    //{0..1}


    private SystemObjectsType  objects;
    //{0..1}


    private StatesType  states;
    //{0..1}


    private VariablesType  variables;
    //{0..1}


    private String  definitions_digest;



    /**
     * Constructor.
     */
    public OvalDefinitions()
    {
    }


    public OvalDefinitions(
                    final GeneratorType generator
                    )
    {
        super( generator );
//        setGenerator( generator );
    }



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



//    /**
//     */
//    public void setDefinitions(
//                    final Collection<? extends DefinitionType> definitionList
//                    )
//    {
//        if (this.definitions != definitionList) {
//            this.definitions.clear();
//            if (definitionList != null  &&  definitionList.size() > 0) {
//                this.definitions.addAll( definitionList );
//            }
//        }
//    }
//
//
//    public Collection<DefinitionType> getDefinitions()
//    {
//        return this.definitions;
//    }
//
//
//    public Iterator<DefinitionType> iterateDefinitions()
//    {
//        return this.definitions.iterator();
//    }

    /**
     */
    public void setDefinitions(
                    final DefinitionsType definitions
                    )
    {
        this.definitions = definitions;
    }


    public DefinitionsType getDefinitions()
    {
        return this.definitions;
    }


    public OvalDefinitions definition(
                    final DefinitionType definition
                    )
    {
        DefinitionsType  defs = getDefinitions();
        if (defs == null) {
            defs = new DefinitionsType();
            setDefinitions( defs );
        }
        defs.addDefinition( definition );

        return this;
    }



    /**
     */
    public void setTests(
                    final TestsType tests
                    )
    {
        this.tests = tests;
    }


    public TestsType getTests()
    {
        return this.tests;
    }


    public OvalDefinitions test(
                    final TestType test
                    )
    {
        TestsType  tests = getTests();
        if (tests == null) {
            tests = new TestsType();
            setTests( tests );
        }
        tests.addTest( test );

        return this;
    }



    /**
     */
    public void setObjects(
                    final SystemObjectsType objects
                    )
    {
        this.objects = objects;
    }


    public SystemObjectsType getObjects()
    {
        return this.objects;
    }


    public OvalDefinitions object(
                    final SystemObjectType object
                    )
    {
        SystemObjectsType  objects = getObjects();
        if (objects == null) {
            objects = new SystemObjectsType();
            setObjects( objects );
        }
        objects.addObject( object );

        return this;
    }



    /**
     */
    public void setStates(
                    final StatesType states
                    )
    {
        this.states = states;
    }


    public StatesType getStates()
    {
        return this.states;
    }


    public OvalDefinitions state(
                    final StateType state
                    )
    {
        StatesType  states = getStates();
        if (states == null) {
            states = new StatesType();
            setStates( states );
        }
        states.addState( state );

        return this;
    }



    /**
     */
    public void setVariables(
                    final VariablesType variables
                    )
    {
        this.variables = variables;
    }


    public VariablesType getVariables()
    {
        return this.variables;
    }


    public OvalDefinitions variable(
                    final VariableType variable
                    )
    {
        VariablesType  variables = getVariables();
        if (variables == null) {
            variables = new VariablesType();
            setVariables( variables );
        }
        variables.addVariable( variable );

        return this;
    }



    /**
     */
    public void setDefinitionsDigest(
                    final String digest
                    )
    {
        // Do nothing!!! - the value is computed and cached in OvalElementContainer.
//        this._definitions_digest = digest;
    }


    public String getDefinitionsDigest()
    {
        //Morphia
        this.definitions_digest =
            (this.definitions == null ? null : this.definitions.getDigest());

        return this.definitions_digest;
    }



//    public Definition getDefinition(
//                    final String id
//                    )
//    {
//        Definitions  definitions = getDefinitions();
//        return (definitions == null ? null : definitions.find( id ));
//    }



//    public Test getTest(
//                    final String id
//                    )
//    {
//        Tests  tests = getTests();
//        return (tests == null ? null : tests.find( id ));
//    }
//
//
//
//    public SystemObject getObject(
//                    final String id
//                    )
//    {
//        SystemObjects  objects = getObjects();
//        return (objects == null ? null : objects.find( id ));
//    }
//
//
//
//    public State getState(
//                    final String id
//                    )
//    {
//        States  states = getStates();
//        return (states == null ? null : states.find( id ));
//    }



    //**************************************************************
    //  OvalDocument
    //**************************************************************

//    @Override
//    public String getSchemaLocation()
//    {
//        return DEFINITIONS_SCHEMA_LOCATION;
//    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        DefinitionsType  definitions = getDefinitions();
        TestsType  tests = getTests();
        SystemObjectsType  objects = getObjects();
        StatesType  states = getStates();
        VariablesType  variables = getVariables();

        return "oval_definitions[generator=" + getGenerator()
                        + ", #definitions="
                        + (definitions == null ? 0 : definitions.size())
//                        + ", definitions=" + String.valueOf( definitions )
                        + ", #tests="
                        + (tests == null ? 0 : tests.getTest().size())
//                        + ", tests=" + String.valueOf( tests )
                        + ", #objects="
                        + (objects == null ? 0 : objects.size())
                        + ", #states="
                        + (states == null ? 0 : states.size())
                        + ", #variables="
                        + (variables == null ? 0 : variables.size())
                        + "]";
    }

}
// OvalDefinitions
