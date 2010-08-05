package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.model.common.Generator;
import jp.go.aist.six.oval.model.result.DefinitionResult;
import jp.go.aist.six.oval.model.result.Directives;
import jp.go.aist.six.oval.model.result.OvalResults;
import jp.go.aist.six.oval.model.result.SystemResults;
import jp.go.aist.six.oval.model.result.SystemResult;
import jp.go.aist.six.oval.model.result.TestResult;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class StoreResultsOvalResultsTest
    extends CoreTestBase
{

    @DataProvider( name="oval-results-oval_results" )
    public Object[][] ovalResultsOvalResultsProvider()
    {
        return new Object[][] {
                        {
                            "oval-results:oval_results",
                            "test/data/result/oval-results.oval_results.1.inventory.windows.xml",
                            RESULTS_GENERATOR_1,
                            DIRECTIVES_1
                        }
        };

    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={"oval.core.store", "oval-results.oval_results"},
                    dataProvider="oval-results-oval_results",
                    alwaysRun=true
                    )
    public void testOvalResults(
                    final String testTarget,
                    final String filepath,
                    final Generator generator,
                    final Directives directives
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL Store //", true );
        Reporter.log( "  * target type: " + testTarget, true );

        OvalResults  or = _unmarshalFile( filepath, OvalResults.class );

        Reporter.log( "validating...", true );
        _validate( or.getGenerator(), generator );
        _validate( or.getDirectives(), directives );
        Reporter.log( "...validation OK", true );

        Reporter.log( "view results...", true );
        SystemResults  results = or.getResults();
        if (results != null) {
            for (SystemResult  system : results.getSystem()) {
                OvalSystemCharacteristics  sc = system.getOvalSystemCharacteristics();
                Reporter.log( "  * OVAL SC: " + sc, true );
                for (TestResult  test : system.getTests().getTest()) {
                    Reporter.log( "  * test result: " + test, true );
                }
                for (DefinitionResult  def : system.getDefinitions().getDefinition()) {
                    Reporter.log( "  * definition result: " + def, true );
                }
            }
        }


        Reporter.log( "syncing...", true );
        OvalResults  p_or = _getStore().sync( OvalResults.class, or );
        String  pid = p_or.getPersistentID();
        Reporter.log( "...syncing done: pid=" + pid, true );
    }

}
// StoreResultsOvalResultsTest

