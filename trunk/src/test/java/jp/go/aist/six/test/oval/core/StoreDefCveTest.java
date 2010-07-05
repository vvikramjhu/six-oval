package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.model.definition.Cve;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class StoreDefCveTest
    extends CoreTestBase
{

    @DataProvider( name="oval-def-cve" )
    public Object[][] ovalDefCveProvider()
    {
        return new Object[][] {
                        {
                            new Cve( "CVE-2011-0001" )
                        }
                        ,
                        {
                            new Cve( "CVE-2011-0002" )
                        }
        };
    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={"oval.core.store", "oval-def.cve"},
                    dataProvider="oval-def-cve",
                    alwaysRun=true
                    )
    public void testDefCve(
                    final Cve cve
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL Store //", true );
        Reporter.log( "  * target type: oval-def:cve", true );

        _syncNameEntity( Cve.class, cve );
    }

}
// StoreDefCveTest

