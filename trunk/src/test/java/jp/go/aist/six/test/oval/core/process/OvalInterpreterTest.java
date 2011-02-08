package jp.go.aist.six.test.oval.core.process;

import jp.go.aist.six.oval.core.process.OvalInterpreter;
import jp.go.aist.six.test.oval.core.CoreTestBase;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalInterpreterTest
    extends CoreTestBase
{


    /**
     */
    public OvalInterpreterTest()
    {
    }



    @DataProvider( name="oval.core.process.OvalInterpreter.ovalDefinitions" )
    public Object[][] provideOvalDefinitions()
    {
        return new Object[][] {
//                        {
//                            null    //DEFAULT
//                        }
//                        ,
//                        {
//                            "definitions.xml"
//                        }
//                        ,
                        {
                            "oval-platform.xml",
                            "ova-platform-results.xml"
                        }
//                        ,
//                        {
//                            "http://six3.hpcc.jp/oval-platform.xml",
//                            "oval-results.xml"
//                        }
//                        ,
//                        {
//                            "http://six3.hpcc.jp/oval-platform.xml",
//                            "http://localhost:8080/oval/rest/results"
//                        }
//                        ,
//                        {
//                            "http://oval.mitre.org/rep-data/org.mitre.oval/p/platform/microsoft.windows.xp.xml"
//                        }
        };

    }



    @org.testng.annotations.Test(
                    groups={"oval.core.process.OvalInterpreter"},
                    dataProvider="oval.core.process.OvalInterpreter.ovalDefinitions",
                    alwaysRun=true
                    )
    public void testExecute(
                    final String ovalDefinitions,
                    final String ovalResults
                    )
    throws Exception
    {
        OvalInterpreter  interpreter = new OvalInterpreter();

        if (ovalDefinitions != null) {
            interpreter.setOvalDefinitions( ovalDefinitions );
        }

        if (ovalResults != null) {
            interpreter.setOvalResults( ovalResults );
        }

        Reporter.log( "executing OvalInterpreter...", true );
        interpreter.execute();
        Reporter.log( "...execution done", true );
    }

}
// OvalInterpreterTest

