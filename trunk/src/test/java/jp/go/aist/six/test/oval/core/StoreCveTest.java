package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.model.definition.Cve;
import org.testng.Reporter;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class StoreCveTest
    extends CoreTestBase
{

    /**
     */
    @org.testng.annotations.Test(
                    groups={"oval.core.store", "oval-def:cve"},
                    dataProvider="oval-def-cve",
                    alwaysRun=true
                    )
    public void testOvalDefinitions(
                    final String testTarget,
                    final Cve cve
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL Store //", true );
        Reporter.log( "  * target type: " + testTarget, true );

        _syncNameEntity( Cve.class, cve );
    }

}
// StoreCveTest

