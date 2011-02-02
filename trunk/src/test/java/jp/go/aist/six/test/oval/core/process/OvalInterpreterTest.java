package jp.go.aist.six.test.oval.core.process;

import jp.go.aist.six.oval.process.OvalInterpreter;
import jp.go.aist.six.test.oval.core.CoreTestBase;
import org.testng.Reporter;



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



    @org.testng.annotations.Test(
                    groups={"oval.core.process"},
                    alwaysRun=true
                    )
    public void testExecute()
    throws Exception
    {
        OvalInterpreter  interpreter = new OvalInterpreter();

        Reporter.log( "executing OvalInterpreter...", true );
        interpreter.execute();
        Reporter.log( "...execution done", true );
    }

}
// OvalInterpreterTest

