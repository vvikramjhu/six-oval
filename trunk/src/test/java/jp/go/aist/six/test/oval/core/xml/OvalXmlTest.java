package jp.go.aist.six.test.oval.core.xml;

import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.definitions.State;
import jp.go.aist.six.oval.model.definitions.SystemObject;
import jp.go.aist.six.oval.model.definitions.Test;
import jp.go.aist.six.oval.model.definitions.Variable;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.model.sc.Item;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import jp.go.aist.six.oval.model.sc.SystemInfo;
import jp.go.aist.six.test.oval.core.CoreTestBase;
import org.testng.Reporter;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalXmlTest
    extends CoreTestBase
{

    /**
     */
    public OvalXmlTest()
    {
    }



    /**
     */
    protected <T> void _testXml(
                    final Class<T> type,
                    final String sourceFilepath,
                    final String xpath,
                    final T expected,
                    final String resultFilepath
                    )
    throws Exception
    {
        T  actual = _unmarshalWithValidation( type, sourceFilepath, xpath, expected );
        _marshal( actual, resultFilepath );
        _unmarshalWithValidation( type, resultFilepath, xpath, expected );
    }



    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //
    //  Definitions
    //
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "definitions.definition"},
                    dataProvider="definitions.definition",
                    alwaysRun=true
                    )
    public void testDefinitionsDefinition(
                    final Class<Definition> type,
                    final String sourceFilepath,
                    final String xpath,
                    final Definition expected,
                    final String resultFilepath
                    )
    throws Exception
    {
        Reporter.log( "\n////////////////////////////////////////////", true );
        _testXml( type, sourceFilepath, xpath, expected, resultFilepath );
    }



    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "definitions.test"},
                    dataProvider="definitions.test",
                    alwaysRun=true
                    )
    public void testDefinitionsTest(
                    final Class<Test> type,
                    final String sourceFilepath,
                    final String xpath,
                    final Test expected,
                    final String resultFilepath
                    )
    throws Exception
    {
        Reporter.log( "\n////////////////////////////////////////////", true );
        _testXml( type, sourceFilepath, xpath, expected, resultFilepath );
    }



    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "definitions.object"},
                    dataProvider="definitions.object",
                    alwaysRun=true
                    )
    public void testDefinitionsObject(
                    final Class<SystemObject> type,
                    final String sourceFilepath,
                    final String xpath,
                    final SystemObject expected,
                    final String resultFilepath
                    )
    throws Exception
    {
        Reporter.log( "\n////////////////////////////////////////////", true );
        _testXml( type, sourceFilepath, xpath, expected, resultFilepath );
    }



    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "definitions.state"},
                    dataProvider="definitions.state",
                    alwaysRun=true
                    )
    public void testDefinitionsState(
                    final Class<State> type,
                    final String sourceFilepath,
                    final String xpath,
                    final State expected,
                    final String resultFilepath
                    )
    throws Exception
    {
        Reporter.log( "\n////////////////////////////////////////////", true );
        _testXml( type, sourceFilepath, xpath, expected, resultFilepath );
    }



    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "definitions.variable"},
                    dataProvider="definitions.variable",
                    alwaysRun=true
                    )
    public void testDefinitionsVariable(
                    final Class<Variable> type,
                    final String sourceFilepath,
                    final String xpath,
                    final Variable expected,
                    final String resultFilepath
                    )
    throws Exception
    {
        Reporter.log( "\n////////////////////////////////////////////", true );
        _testXml( type, sourceFilepath, xpath, expected, resultFilepath );
    }



    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "definitions.oval_definitions"},
                    dataProvider="definitions.oval_definitions",
                    alwaysRun=true
                    )
    public void testDefinitionsOvalDefinitions(
                    final Class<OvalDefinitions> type,
                    final String sourceFilepath,
                    final String xpath,
                    final OvalDefinitions expected,
                    final String resultFilepath
                    )
    throws Exception
    {
        Reporter.log( "\n////////////////////////////////////////////", true );
        _testXml( type, sourceFilepath, xpath, expected, resultFilepath );
    }



    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //
    //  SC
    //
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "sc.system_info"},
                    dataProvider="sc.system_info",
                    alwaysRun=true
                    )
    public void testSCSystemInfo(
                    final Class<SystemInfo> type,
                    final String sourceFilepath,
                    final String xpath,
                    final SystemInfo expected,
                    final String resultFilepath
                    )
    throws Exception
    {
        Reporter.log( "\n////////////////////////////////////////////", true );
        _testXml( type, sourceFilepath, xpath, expected, resultFilepath );
    }



    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "sc.item"},
                    dataProvider="sc.item",
                    alwaysRun=true
                    )
    public void testSCItem(
                    final Class<Item> type,
                    final String sourceFilepath,
                    final String xpath,
                    final Item expected,
                    final String resultFilepath
                    )
    throws Exception
    {
        Reporter.log( "\n////////////////////////////////////////////", true );
        _testXml( type, sourceFilepath, xpath, expected, resultFilepath );
    }



    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "sc.oval_sc"},
                    dataProvider="sc.oval_sc",
                    alwaysRun=true
                    )
    public void testSCOvalSC(
                    final Class<OvalSystemCharacteristics> type,
                    final String sourceFilepath,
                    final String xpath,
                    final OvalSystemCharacteristics expected,
                    final String resultFilepath
                    )
    throws Exception
    {
        Reporter.log( "\n////////////////////////////////////////////", true );
        _testXml( type, sourceFilepath, xpath, expected, resultFilepath );
    }




    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //
    //  Results
    //
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "results.oval_results"},
                    dataProvider="results.oval_results",
                    alwaysRun=true
                    )
    public void testOvalResultsOvalResults(
                    final Class<OvalResults> type,
                    final String sourceFilepath,
                    final String xpath,
                    final OvalResults expected,
                    final String resultFilepath
                    )
    throws Exception
    {
        _testXml( type, sourceFilepath, xpath, expected, resultFilepath );
    }

}
// OvalXmlTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

