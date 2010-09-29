package jp.go.aist.six.test.oval.core.store;

import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.test.oval.core.OvalSample;
import org.testng.annotations.DataProvider;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class StoreResultsTest
    extends StoreTestBase
{

    /**
     */
    public StoreResultsTest()
    {
    }



    //==============================================================
    //  oval_results
    //==============================================================

    @DataProvider( name="results.oval_results" )
    public Object[][] provideResultsOvalResults()
    {
        return new Object[][] {
                        // Mitre, CVE-2009-4019, MySQL
                        {
                            OvalResults.class,
                            "test/data/results/oval-results_CVE-2009-4019_MySQL.xml",
                            "/oval_results",
                            OvalSample.OVAL_RESULTS_8500
                        }
        };
    }


    @org.testng.annotations.Test(
                    groups={"oval.core.store", "results.oval_results"},
                    dataProvider="results.oval_results",
                    alwaysRun=true
                    )
    public void testResultsOvalResults(
                    final Class<OvalResults> type,
                    final String filepath,
                    final String xpath,
                    final OvalResults expected
                    )
    throws Exception
    {
        _testStoreSync( type, filepath, xpath, expected );
    }

}
// StoreResultsTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

