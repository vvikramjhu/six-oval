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

package jp.go.aist.six.oval.model.definition;

import jp.go.aist.six.oval.model.common.Generator;
import jp.go.aist.six.util.orm.Persistable;



/**
 * The root of an OVAL Definition Document.
 * This bind together the major sections of a Definitions document;
 * generator, definitions, tests, objects, states, and variables.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: OvalDefinitions.java 648 2010-04-21 06:27:04Z akihito $
 */
public class OvalDefinitions
    implements Persistable
{

    private Generator  _generator;
    //{1..1}

    private Definitions  _definitions = new Definitions();
    //{0..1}

    private Tests _tests = new Tests();
    //{0..1}

    private SystemObjects  _objects = new SystemObjects();
    //{0..1}

    private States  _states = new States();
    //{0..1}

    private Variables  _variables = new Variables();
    //{0..1}

//    private transient Map<String, Definition>   _definitionMap;
//    private transient Map<String, Test>   _testMap;
//    private transient Map<String, SystemObject>   _objectMap;
//    private transient Map<String, State>   _stateMap;



//    private String  _definitionsDigest;



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



//    /**
//     * Creates OvalID-OvalEntity map from the given OvalEntity list.
//     */
//    private <T extends OvalEntity> Map<String, T> _asMap(
//                    final Collection<T> entities
//                    )
//    {
//        if (entities == null || entities.size() == 0) {
//            return Collections.emptyMap();
//        }
//
//        Map<String, T> map = new HashMap<String, T>();
//        for (T entity : entities) {
//            map.put( entity.getOvalID(), entity );
//        }
//
//        return map;
//    }



    /**
     */
    public void setDefinitionsDigest(
                    final String digest
                    )
    {
//        _definitionsDigest = digest;
    }


    /**
     */
    public String getDefinitionsDigest()
    {
        if (_definitions == null) {
            return null;
        } else {
            return _definitions.getDigest();
        }

//        if (_definitionsDigest == null) {
//            try {
//                _definitionsDigest = OvalDigest.DEFAULT_INSTANCE.compute( getDefinitions() );
//            } catch (Exception ex) {
//                // TODO:
//            }
//        }
//
//        return _definitionsDigest;
    }



    public Definition getDefinition(
                    final String id
                    )
    {
        return getDefinitions().findElement( id );

//        Definitions  defs = getDefinitions();
//        if (defs == null) {
//            return null;
//        }
//
//        if (_definitionMap == null) {
//            _definitionMap = _asMap( defs.getElements() );
//        }
//
//        return _definitionMap.get( id );
    }



    public Test getTest(
                    final String id
                    )
    {
        return getTests().findElement( id );

//        Tests  tests = getTests();
//        if (tests == null) {
//            return null;
//        }
//
//        if (_testMap == null) {
//            _testMap = _asMap( tests.getElements() );
//        }
//
//        return _testMap.get( id );
    }



    public SystemObject getObject(
                    final String id
                    )
    {
        return getObjects().findElement( id );

//        SystemObjects  objects = getObjects();
//        if (objects == null) {
//            return null;
//        }
//
//        if (_objectMap == null) {
//            _objectMap = _asMap( objects.getElements() );
//        }
//
//        return _objectMap.get( id );
    }



    public State getState(
                    final String id
                    )
    {
        return getStates().findElement( id );

//        States  states = getStates();
//        if (states == null) {
//            return null;
//        }
//
//        if (_stateMap == null) {
//            _stateMap = _asMap( states.getElements() );
//        }
//
//        return _stateMap.get( id );
    }



    //**************************************************************
    //  Persistable
    //**************************************************************

    /**
     * The persistent identifier.
     */
    private  String  _persistentID;


    public void setPersistentID(
                    final String id
                    )
    {
        _persistentID = id;
    }


    public String getPersistentID()
    {
        return _persistentID;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "OvalDefinitions[generator=" + getGenerator()
//                        + ", definitions =" + getDefinitions()
//                        + ", tests=" + getTests()
//                        + ", objects=" + getObjects()
//                        + ", states=" + getStates()
//                        + ", variables=" + getVariables()
                        + "]";
    }



//    public void setStates( Collection<State> states );
//    public boolean addState( State state );
//    public Collection<State> getStates();
//
//
//    public void setVariables( Collection<Variable> variables );
//    public boolean addVariable( Variable variable );
//    public Collection<Variable> getVariables();

}
// OvalDefinitions
