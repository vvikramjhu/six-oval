package jp.go.aist.six.test.oval.core.store;

import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import jp.go.aist.six.test.oval.core.CoreTestBase;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalSCTest
    extends CoreTestBase
{

    /**
     */
    public OvalSCTest()
    {
    }



    /**
     */
    private void _testOvalSC(
                    final Class<OvalSystemCharacteristics> type,
                    final String filepath,
                    final String xpath,
                    final OvalSystemCharacteristics expected
                    )
    throws Exception
    {
        Reporter.log( "\n////////////////////////////////////////////////////////////////", true );
        Reporter.log( "  * object type: " + type, true );

        OvalSystemCharacteristics  object = _readObjectFromXmlFile( type, filepath, xpath, expected );
        Assert.assertNotNull( object );

        _syncOvalSC( object );
    }



    /**
     */
    protected void _syncOvalSC(
                    final OvalSystemCharacteristics object
                    )
    throws Exception
    {
        Reporter.log( "sync OvalSystemCharacteristics..." , true );
        long  time = System.currentTimeMillis();
        OvalSystemCharacteristics  persistent = _getStore().sync( OvalSystemCharacteristics.class, object );
        Reporter.log( "...sync done: " + (System.currentTimeMillis() - time) + "(ms)", true );

        String  pid = persistent.getPersistentID();
        Reporter.log( "  @ pid=" + pid, true );

        Reporter.log( "get object...", true );
        Reporter.log( "  - pid=" + pid, true );
        time = System.currentTimeMillis();
        OvalSystemCharacteristics  persistent2 = _getStore().get( OvalSystemCharacteristics.class, pid );
        Reporter.log( "...get done: " + (System.currentTimeMillis() - time) + "(ms)", true );

        Reporter.log( "  @ get: object=" + persistent2, true );
//        Reporter.log( "validating...", true );
//        Validators.validator( OvalResults.class ).equals( persistent2, object );
//        Reporter.log( "...validation OK", true );
    }




    //==============================================================
    //  oval_system_characteristics
    //==============================================================

    @DataProvider( name="sc.oval_system_characteristics" )
    public Object[][] provideSCOvalSC()
    {
        return new Object[][] {
                        // Mitre, CVE-2009-4019, MySQL
                        {
                            OvalSystemCharacteristics.class,
                            "test/data/sc/oval-sc_CVE-2009-4019_MySQL.xml",
                            "/oval_system_characteristics",
                            null
                        }
        };
    }


    @org.testng.annotations.Test(
                    groups={"oval.core.store", "sc.oval_system_characteristics"},
                    dataProvider="sc.oval_system_characteristics",
                    alwaysRun=true
                    )
    public void testSCOvalSC(
                    final Class<OvalSystemCharacteristics> type,
                    final String filepath,
                    final String xpath,
                    final OvalSystemCharacteristics expected
                    )
    throws Exception
    {
        _testOvalSC( type, filepath, xpath, expected );
    }

}
// StoreSCTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

