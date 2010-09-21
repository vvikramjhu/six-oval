package jp.go.aist.six.test.oval.core.store;

import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.test.oval.core.CoreTestBase;
import jp.go.aist.six.test.oval.core.OvalSample;
import jp.go.aist.six.test.oval.core.Validators;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class StoreResultsTest
    extends CoreTestBase
{

    /**
     */
    public StoreResultsTest()
    {
    }



    /**
     */
    private void _testOvalResults(
                    final Class<OvalResults> type,
                    final String filepath,
                    final String xpath,
                    final OvalResults expected
                    )
    throws Exception
    {
        Reporter.log( "\n////////////////////////////////////////////////////////////////", true );
        Reporter.log( "  * object type: " + type, true );

        OvalResults  object = _readObjectFromXmlFile( type, filepath, xpath, expected );
        Assert.assertNotNull( object );

        _syncOvalResults( object );
    }



    /**
     */
    protected void _syncOvalResults(
                    final OvalResults object
                    )
    throws Exception
    {
        Reporter.log( "sync OvalResults..." , true );
        long  time = System.currentTimeMillis();
        OvalResults  persistent = _getStore().sync( OvalResults.class, object );
        Reporter.log( "...sync done: " + (System.currentTimeMillis() - time) + "(ms)", true );

        String  pid = persistent.getPersistentID();
        Reporter.log( "  @ pid=" + pid, true );

        Reporter.log( "get object...", true );
        Reporter.log( "  - pid=" + pid, true );
        time = System.currentTimeMillis();
        OvalResults  persistent2 = _getStore().get( OvalResults.class, pid );
        Reporter.log( "...get done: " + (System.currentTimeMillis() - time) + "(ms)", true );

        Reporter.log( "  @ get: object=" + persistent2, true );
        Reporter.log( "validating...", true );
        Validators.validator( OvalResults.class ).equals( persistent2, object );
        Reporter.log( "...validation OK", true );
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
        _testOvalResults( type, filepath, xpath, expected );
    }

}
// StoreResultsTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

