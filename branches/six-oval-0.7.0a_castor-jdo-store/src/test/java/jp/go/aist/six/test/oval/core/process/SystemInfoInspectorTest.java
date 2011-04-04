package jp.go.aist.six.test.oval.core.process;

import jp.go.aist.six.oval.core.process.SixSystemInfo;
import jp.go.aist.six.oval.core.process.SystemInfoInspector;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class SystemInfoInspectorTest
{


    /**
     */
    public SystemInfoInspectorTest()
    {
    }



    @DataProvider( name="oval.core.process.SystemInfoInspector.ovalPlatformDefinitions" )
    public Object[][] provideOvalPlatformDefinitions()
    {
        return new Object[][] {
                        {
                            "oval-platform.xml"
                        }
        };

    }



    @org.testng.annotations.Test(
                    groups={"oval.core.process.SystemInfoInspector"},
                    dataProvider="oval.core.process.SystemInfoInspector.ovalPlatformDefinitions",
                    alwaysRun=true
                    )
    public void testExecute(
                    final String ovalDefinitions
                    )
    throws Exception
    {
        SystemInfoInspector  inspector = new SystemInfoInspector();
        inspector.setOvalPlatformDefinitions( ovalDefinitions );

        Reporter.log( "executing SystemInfoInspector...", true );
        SixSystemInfo  info = inspector.execute();
        Reporter.log( "...execution done", true );

        Reporter.log( "system info: " + info, true );
    }

}
// OvalInterpreterTest

