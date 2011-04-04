package jp.go.aist.six.test.oval.core.xml;

import jp.go.aist.six.oval.model.v5.definitions.DefinitionType;
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
                    final Class<DefinitionType> type,
                    final String sourceFilepath,
                    final String xpath,
                    final DefinitionType expected,
                    final String resultFilepath
                    )
    throws Exception
    {
        Reporter.log( "\n////////////////////////////////////////////", true );
        _testXml( type, sourceFilepath, xpath, expected, resultFilepath );
    }

}
// OvalXmlTest

