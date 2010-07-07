package jp.go.aist.six.test.oval.core;

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

}
// StoreResultsOvalResultsTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

