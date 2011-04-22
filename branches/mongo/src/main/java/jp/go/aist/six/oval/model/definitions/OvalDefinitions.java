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

package jp.go.aist.six.oval.model.definitions;

import jp.go.aist.six.oval.model.OvalDocument;
import jp.go.aist.six.oval.model.common.Generator;



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

    private Generator  _generator;
    //{1..1}

    private Definitions  _definitions;
    //{0..1}

    private Tests _tests;
    //{0..1}

    private SystemObjects  _objects;
    //{0..1}

    private States  _states;
    //{0..1}

    private Variables  _variables;
    //{0..1}

    private String  _definitionsDigest;



    /**
     * Constructor.
     */
    public OvalDefinitions()
    {
    }


    /**
     * Constructor.
     */
    public OvalDefinitions(
                    final Generator generator
                    )
    {
        setGenerator( generator );
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
    public void setDefinitions(
                    final Definitions definitions
                    )
    {
        _definitions = definitions;
    }


    public Definitions getDefinitions()
    {
        return _definitions;
    }


    public OvalDefinitions definition(
                    final Definition definition
                    )
    {
        Definitions  defs = getDefinitions();
        if (defs == null) {
            defs = new Definitions();
            setDefinitions( defs );
        }
        defs.addDefinition( definition );

        return this;
    }



    /**
     */
    public void setTests(
                    final Tests tests
                    )
    {
        _tests = tests;
    }


    public Tests getTests()
    {
        return _tests;
    }


    public OvalDefinitions test(
                    final Test test
                    )
    {
        Tests  tests = getTests();
        if (tests == null) {
            tests = new Tests();
            setTests( tests );
        }
        tests.addTest( test );

        return this;
    }



    /**
     */
    public void setObjects(
                    final SystemObjects objects
                    )
    {
        _objects = objects;
    }


    public SystemObjects getObjects()
    {
        return _objects;
    }


    public OvalDefinitions object(
                    final SystemObject object
                    )
    {
        SystemObjects  objects = getObjects();
        if (objects == null) {
            objects = new SystemObjects();
            setObjects( objects );
        }
        objects.addObject( object );

        return this;
    }



    /**
     */
    public void setStates(
                    final States states
                    )
    {
        _states = states;
    }


    public States getStates()
    {
        return _states;
    }


    public OvalDefinitions state(
                    final State state
                    )
    {
        States  states = getStates();
        if (states == null) {
            states = new States();
            setStates( states );
        }
        states.addState( state );

        return this;
    }



    /**
     */
    public void setVariables(
                    final Variables variables
                    )
    {
        _variables = variables;
    }


    public Variables getVariables()
    {
        return _variables;
    }


    public OvalDefinitions variable(
                    final Variable variable
                    )
    {
        Variables  variables = getVariables();
        if (variables == null) {
            variables = new Variables();
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


    /**
     */
    public String getDefinitionsDigest()
    {
        if (_definitionsDigest != null) {
            return _definitionsDigest;
        }

        if (_definitions == null) {
            return null;
        } else {
            _definitionsDigest = _definitions.getDigest();
            return _definitionsDigest;
        }
    }



    public Definition getDefinition(
                    final String id
                    )
    {
        Definitions  definitions = getDefinitions();
        return (definitions == null ? null : definitions.find( id ));
    }



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

    @Override
    public String getSchemaLocation()
    {
        return DEFINITIONS_SCHEMA_LOCATION;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        Definitions  definitions = getDefinitions();
        Tests  tests = getTests();
        SystemObjects  objects = getObjects();
        States  states = getStates();
        Variables  variables = getVariables();

        return "oval_definitions[generator=" + getGenerator()
                        + ", #definitions="
                        + (definitions == null ? 0 : definitions.size())
                        + ", #tests="
                        + (tests == null ? 0 : tests.getTest().size())
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
