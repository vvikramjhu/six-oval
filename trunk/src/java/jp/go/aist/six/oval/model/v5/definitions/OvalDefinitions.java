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

import jp.go.aist.six.oval.model.v5.OvalDocument;
import jp.go.aist.six.oval.model.v5.common.GeneratorType;



/**
 * An OVAL Definition Document.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class OvalDefinitions
    extends OvalDocument
{

    private GeneratorType  _generator;
    //{1..1}


    private DefinitionsType  _definitions;
    //{0..1}


    private TestsType  _tests;
    //{0..1}


    private SystemObjectsType  _objects;
    //{0..1}


    private StatesType  _states;
    //{0..1}


    private VariablesType  _variables;
    //{0..1}


    private String  _definitionsDigest;



    /**
     * Constructor.
     */
    public OvalDefinitions()
    {
    }


//    /**
//     * Constructor.
//     */
//    public OvalDefinitions(
//                    final GeneratorType generator
//                    )
//    {
//        setGenerator( generator );
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
    public void setDefinitions(
                    final DefinitionsType definitions
                    )
    {
        _definitions = definitions;
    }


    public DefinitionsType getDefinitions()
    {
        return _definitions;
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
        _tests = tests;
    }


    public TestsType getTests()
    {
        return _tests;
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
        _objects = objects;
    }


    public SystemObjectsType getObjects()
    {
        return _objects;
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
        _states = states;
    }


    public StatesType getStates()
    {
        return _states;
    }


    public OvalDefinitions state(
                    final State state
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
        _variables = variables;
    }


    public VariablesType getVariables()
    {
        return _variables;
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
        _definitionsDigest = digest;
    }


    public String getDefinitionsDigest()
    {
        return _definitionsDigest;

//        if (_definitionsDigest != null) {
//            return _definitionsDigest;
//        }
//
//        if (_definitions == null) {
//            return null;
//        } else {
//            _definitionsDigest = _definitions.getDigest();
//            return _definitionsDigest;
//        }
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
