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

package jp.go.aist.six.oval.model.result;

import jp.go.aist.six.oval.model.system.OvalSystemCharacteristics;
import jp.go.aist.six.util.castor.AbstractPersistable;
import jp.go.aist.six.util.orm.Dependent;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id: SystemResult.java 758 2010-05-10 06:28:46Z akihito $
 */
public class SystemResult
    extends AbstractPersistable
    implements Dependent<OvalResults>
{

    private DefinitionResults  _definitions;
    //{0..1}


    private TestResults  _tests;
    //{0..1}


    private OvalSystemCharacteristics  _ovalSystemCharacteristics;
    //{1..1}


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
     */
    public void setDefinitions(
                    final DefinitionResults definitions
                    )
    {
        _definitions = definitions;
    }


    /**
     */
    public DefinitionResults getDefinitions()
    {
        return _definitions;
    }



//    public void setDefinitionResults(
//                    final Collection<DefinitionResult> results
//                    )
//    {
//        _definitions.clear();
//        if (results == null  ||  results.size() == 0) {
//            return;
//        }
//
//        for (DefinitionResult  result : results) {
//            addDefinitionResult( result );
//        }
//    }
//
//
//    public boolean addDefinitionResult(
//                    final DefinitionResult result
//                    )
//    {
//        if (result == null) {
//            return false;
//        }
//
//        return _definitions.add( result );
//    }
//
//
//    public Collection<DefinitionResult> getDefinitionResults()
//    {
//        return _definitions;
//    }



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
        DefinitionResults  definitions = getDefinitions();
        _definitionsDigest = (definitions == null ? null : definitions.getDigest());

        return _definitionsDigest;
    }



    public void setOvalSystemCharacteristics(
                    final OvalSystemCharacteristics sc
                    )
    {
        _ovalSystemCharacteristics = sc;
    }


    public OvalSystemCharacteristics getOvalSystemCharacteristics()
    {
        return _ovalSystemCharacteristics;
    }



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
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        DefinitionResults  defs = getDefinitions();
        TestResults  tests = getTests();

        return "SystemResult[oval_system_characteristics=" + getOvalSystemCharacteristics()
                        + ", #definitions=" + (defs == null ? 0 : defs.size())
                        + ", #tests=" + (tests == null ? 0 : tests.size())
                        + "]";
    }

}
// SystemResult
