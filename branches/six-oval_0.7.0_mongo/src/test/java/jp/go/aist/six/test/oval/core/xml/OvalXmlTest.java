package jp.go.aist.six.test.oval.core.xml;

import jp.go.aist.six.oval.model.v5.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.v5.results.OvalResults;
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
//                    final String xpath,
                    final T expected,
                    final String resultFilepath
                    )
    throws Exception
    {
        T  actual = _unmarshalWithValidation( type, sourceFilepath, /* xpath, */ expected );
        _marshal( actual, resultFilepath );
        _unmarshalWithValidation( type, resultFilepath, /* xpath, */ expected );
    }



    //**************************************************************
    //  OVAL definitions
    //**************************************************************

    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "oval.definitions.oval_definitions"},
                    dataProvider="oval.definitions.xml",
                    alwaysRun=true
                    )
    public void testDefinitionsOvalDefinitions(
                    final Class<OvalDefinitions> type,
                    final String sourceFilepath,
//                  final String xpath,
                    final OvalDefinitions expected,
                    final String resultFilepath
                    )
    throws Exception
    {
        Reporter.log( "\n////////////////////////////////////////////", true );
        _testXml( type, sourceFilepath, /* xpath, */ expected, resultFilepath );
    }



    //**************************************************************
    //  OVAL results
    //**************************************************************

    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "oval.results.oval_results"},
                    dataProvider="oval.results.xml",
                    alwaysRun=true
                    )
    public void testResutlsOvalResults(
                    final Class<OvalResults> type,
                    final String sourceFilepath,
                    final OvalResults expected,
                    final String resultFilepath
                    )
    throws Exception
    {
        Reporter.log( "\n////////////////////////////////////////////", true );
        _testXml( type, sourceFilepath, expected, resultFilepath );
    }

}
// OvalXmlTest
