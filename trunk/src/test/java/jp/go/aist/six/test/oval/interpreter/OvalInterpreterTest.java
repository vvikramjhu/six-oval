package jp.go.aist.six.test.oval.interpreter;

import jp.go.aist.six.oval.interpreter.Option;
import jp.go.aist.six.oval.interpreter.Options;
import jp.go.aist.six.oval.interpreter.OvalInterpreter;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;



/**
 * OvalInterpreter
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalInterpreterTest
{


    @DataProvider( name="oval.interpreter.options" )
    public Object[][] provideOvalInterpreterOptions()
    {
        Options  options1 = new Options();
        options1.set( Option.NO_VERIFY )
                .set( Option.OVAL_XML_DIR, "C:\\app\\ovaldi-5.9.2-x64\\xml" )
                .set( Option.OVAL_DEFINITIONS,
                                "test/resources/data/oval5/oval5.9_def12313-5_v_windows_CVE-2011-0031.xml" );

        return new Object[][] {
                        {
                            "C:\\app\\ovaldi-5.9.2-x64\\ovaldi.exe",
                            options1
                        }
        };

    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={ "oval.interpreter" },
                    dataProvider="oval.interpreter.options",
                    alwaysRun=true
                    )
    public void testOvalInterpreter(
                    final String executable,
                    final Options options
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );

        Reporter.log( "* executable: " + executable, true );
        Reporter.log( "* options: " + options, true );

        OvalInterpreter  ovaldi = new OvalInterpreter();
        if (executable != null) {
            ovaldi.setExecutable( executable );
        }
        ovaldi.setOptions( options );

        int  exitValue = ovaldi.execute();
        Reporter.log( "@ exit value: " + exitValue, true );
    }

}
// OvalInterpreterTest