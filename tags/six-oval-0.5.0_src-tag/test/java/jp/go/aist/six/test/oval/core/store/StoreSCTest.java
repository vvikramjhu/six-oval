package jp.go.aist.six.test.oval.core.store;

import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import jp.go.aist.six.test.oval.core.OvalSample;
import org.testng.annotations.DataProvider;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class StoreSCTest
    extends StoreTestBase
{

    /**
     */
    public StoreSCTest()
    {
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
                            OvalSample.OVAL_SC_8500
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
        // DEBUG
//        Reporter.log( "  * expected object: " + expected, true );
//        if (expected != null) {
//            SystemData  systemData = expected.getSystemData();
//            if (systemData != null  &&  systemData.size() > 0) {
//                for (Item  item : systemData) {
//                    Reporter.log( "  * item: " + item, true );
//                }
//            }
//        }

        _testStoreSync( type, filepath, xpath, expected );
    }

}
// StoreSCTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

