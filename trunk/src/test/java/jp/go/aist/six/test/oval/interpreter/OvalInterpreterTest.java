package jp.go.aist.six.test.oval.interpreter;

import jp.go.aist.six.oval.core.interpreter.OvaldiOption;
import jp.go.aist.six.oval.core.interpreter.OvaldiProxy;
import jp.go.aist.six.oval.interpreter.Options;
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
        //minimum options
        Options  options1 = new Options();
        options1.set( OvaldiOption.NO_VERIFY )
//                .set( OvaldiOption.OVAL_XML_DIR, "C:\\app\\ovaldi-5.10.1.1-x64\\xml" )
                .set( OvaldiOption.OVAL_DEFINITIONS,
                                "test/resources/OvalTestContent/5.10/windows/ind-def_family_test.xml" );

        return new Object[][] {
                        {
                            "C:\\app\\ovaldi-5.10.1.1-x64\\ovaldi.exe",
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
    public void testOvaldiProxy(
                    final String executable,
                    final Options options
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );

        Reporter.log( "* executable: " + executable, true );
        Reporter.log( "* options: " + options, true );

        OvaldiProxy  ovaldi = new OvaldiProxy();
        if (executable != null) {
            ovaldi.setExecutable( executable );
        }
        ovaldi.setOptions( options );

        int  exitValue = ovaldi.execute();
        Reporter.log( "@ exit value: " + exitValue, true );
    }

}
//OvalInterpreterTest
