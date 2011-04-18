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

import jp.go.aist.six.oval.model.AbstractOvalObject;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import jp.go.aist.six.util.persist.Dependent;
import java.util.UUID;



/**
 * The SystemResult holds the evaluation results of the definitions and tests,
 * as well as a copy of the OVAL System Characteristics
 * used to perform the evaluation.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class SystemResult
    extends AbstractOvalObject
    implements Dependent<OvalResults>
{

    private DefinitionResults  _definitions = new DefinitionResults();
    //{0..1}


    private TestResults  _tests = new TestResults();
    //{0..1}


    private OvalSystemCharacteristics  _ovalSC;
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
    public SystemResult()
    {
    }


    /**
     * constructor.
     */
    public SystemResult(
                    final OvalSystemCharacteristics sc
                    )
    {
        setOvalSystemCharacteristics( sc );
    }


    /**
     * constructor.
     */
    public SystemResult(
                    final OvalSystemCharacteristics sc,
                    final DefinitionResults definitions,
                    final TestResults tests
                    )
    {
        setOvalSystemCharacteristics( sc );
        setDefinitions( definitions );
        setTests( tests );
    }



    /**
     * constructor.
     */
    public SystemResult(
                    final OvalSystemCharacteristics sc,
                    final DefinitionResult[] definitions,
                    final TestResult[] tests
                    )
    {
        setOvalSystemCharacteristics( sc );
        setDefinitions( new DefinitionResults( definitions ) );
        setTests( new TestResults( tests ) );
    }



    /**
     */
    public void setDefinitions(
                    final DefinitionResults definitions
                    )
    {
        _definitions = definitions;
    }


    public DefinitionResults getDefinitions()
    {
        return _definitions;
    }


    public SystemResult definition(
                    final DefinitionResult definition
                    )
    {
        DefinitionResults  defs = getDefinitions();
        if (defs == null) {
            defs = new DefinitionResults();
            setDefinitions( defs );
        }
        defs.addDefinition( definition );

        return this;
    }



    /**
     */
    public void setTests(
                    final TestResults tests
                    )
    {
        _tests = tests;
    }


    public TestResults getTests()
    {
        return _tests;
    }


    public SystemResult test(
                    final TestResult test
                    )
    {
        TestResults  tests = getTests();
        if (tests == null) {
            tests = new TestResults();
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
        _ovalSC = sc;
    }


    public OvalSystemCharacteristics getOvalSystemCharacteristics()
    {
        return _ovalSC;
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



    //**************************************************************
    //  Dependent
    //**************************************************************

    private OvalResults  _master;


    public void setMasterObject(
                    final OvalResults master
                    )
    {
        _master = master;
    }


    public OvalResults getMasterObject()
    {
        return _master;
    }



    //**************************************************************
    //  Persistable
    //**************************************************************

    @Override
    public synchronized String getPersistentID()
    {
        String  pid = super.getPersistentID();
        if (pid == null) {
            pid = UUID.randomUUID().toString();
            setPersistentID( pid );
        }

        return pid;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        DefinitionResults  defs = getDefinitions();
        TestResults  tests = getTests();

        return "system[oval_system_characteristics=" + getOvalSystemCharacteristics()
                        + ", #definitions=" + (defs == null ? 0 : defs.size())
//                        + ", tests=" + tests
                        + ", #tests=" + (tests == null ? 0 : tests.size())
                        + "]";
    }

}
// SystemResult
