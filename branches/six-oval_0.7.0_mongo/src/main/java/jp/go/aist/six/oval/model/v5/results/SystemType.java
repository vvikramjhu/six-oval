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

import jp.go.aist.six.oval.model.v5.sc.OvalSystemCharacteristics;
import com.google.code.morphia.annotations.Reference;



/**
 * The SystemResult holds the evaluation results of the definitions and tests,
 * as well as a copy of the OVAL System Characteristics
 * used to perform the evaluation.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class SystemType
//    extends AbstractOvalObject
//    implements Dependent<OvalResults>
{

    private DefinitionsType  definitions;
    //{0..1}


    private TestsType  tests;
    //{0..1}


    @Reference
    private OvalSystemCharacteristics  oval_system_characteristics;
    //{1..1}


    //TODO:
    // Since the xsd:key "definitionInstanceKey" is composed of
    // @definition_id, @version, and @variable_instance,
    // DefinitionResults may contain multiple elements
    // whose @definition_id is the same.
    // So, digest must be computed from @definition_id set.
    private String  _definitionsDigest;



    /**
     * constructor.
     */
    public SystemType()
    {
    }


//    public SystemType(
//                    final OvalSystemCharacteristics sc
//                    )
//    {
//        setOvalSystemCharacteristics( sc );
//    }
//
//
//    public SystemType(
//                    final OvalSystemCharacteristics sc,
//                    final DefinitionResults definitions,
//                    final TestResults tests
//                    )
//    {
//        setOvalSystemCharacteristics( sc );
//        setDefinitions( definitions );
//        setTests( tests );
//    }
//
//
//    public SystemType(
//                    final OvalSystemCharacteristics sc,
//                    final DefinitionResult[] definitions,
//                    final TestResult[] tests
//                    )
//    {
//        setOvalSystemCharacteristics( sc );
//        setDefinitions( new DefinitionResults( definitions ) );
//        setTests( new TestResults( tests ) );
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


    public SystemType definition(
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


    public SystemType test(
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
    public void setOvalSystemCharacteristics(
                    final OvalSystemCharacteristics sc
                    )
    {
        this.oval_system_characteristics = sc;
    }


    public OvalSystemCharacteristics getOvalSystemCharacteristics()
    {
        return this.oval_system_characteristics;
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
//        if (_definitionsDigest == null) {
//            DefinitionResults  definitions = getDefinitions();
//            _definitionsDigest = (definitions == null ? null : definitions.getDigest());
//        }

        return _definitionsDigest;
    }



//    //**************************************************************
//    //  Dependent
//    //**************************************************************
//
//    private OvalResults  _master;
//
//
//    @Override
//    public void setMasterObject(
//                    final OvalResults master
//                    )
//    {
//        _master = master;
//    }
//
//
//    @Override
//    public OvalResults getMasterObject()
//    {
//        return _master;
//    }



//    //**************************************************************
//    //  Persistable
//    //**************************************************************
//
//    @Override
//    public synchronized String getPersistentID()
//    {
//        String  pid = super.getPersistentID();
//        if (pid == null) {
//            pid = UUID.randomUUID().toString();
//            setPersistentID( pid );
//        }
//
//        return pid;
//    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        DefinitionsType  defs = getDefinitions();
        TestsType  tests = getTests();

        return "[#definitions=" + (defs == null ? 0 : defs.size())
                        + ", #definitions=" + (defs == null ? 0 : defs.size())
                        + ", #tests=" + (tests == null ? 0 : tests.size())
                        + ", oval_system_characteristics=" + getOvalSystemCharacteristics()
                        + "]";
//                        + ", tests=" + tests
//                        + "]";
    }

}
// SystemType