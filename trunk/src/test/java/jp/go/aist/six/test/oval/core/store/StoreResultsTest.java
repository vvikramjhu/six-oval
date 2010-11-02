package jp.go.aist.six.test.oval.core.store;

import jp.go.aist.six.oval.model.results.OvalResults;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class StoreResultsTest
    extends OvalStoreTest
{

    /**
     */
    public StoreResultsTest()
    {
    }



    //==============================================================
    //  oval_results
    //==============================================================

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

