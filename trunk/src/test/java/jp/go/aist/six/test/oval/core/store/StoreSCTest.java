package jp.go.aist.six.test.oval.core.store;

import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;



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

    @org.testng.annotations.Test(
                    groups={"oval.core.store", "sc.oval_sc"},
                    dataProvider="sc.oval_sc",
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
        _testStoreSync( type, filepath, xpath, expected );
    }

}
// StoreSCTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

