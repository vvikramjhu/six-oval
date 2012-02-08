package jp.go.aist.six.test.oval.core.interpreter;

import jp.go.aist.six.oval.core.interpreter.NetworkingOvaldiProxy;
import jp.go.aist.six.oval.core.interpreter.OvaldiOption;
import jp.go.aist.six.oval.interpreter.Options;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;



/**
 * NetOvalInterpreter
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class NetOvalInterpreterTest
{


    @DataProvider( name="oval.interpreter.options" )
    public Object[][] provideNetOvalInterpreterOptions()
    {
        Options  options1 = new Options();
        options1.set( OvaldiOption.NO_VERIFY )
                .set( OvaldiOption.OVAL_XML_DIR, "C:\\app\\ovaldi-5.9.2-x64\\xml" )
                .set( OvaldiOption.OVAL_DEFINITIONS,
                                "http://oval.mitre.org/repository/data/DownloadDefinition?id=oval%3aorg.mitre.oval%3adef%3a2545&type=view"
//                                "test/resources/data/oval5/oval5.9_def12313-5_v_windows_CVE-2011-0031.xml"
                                )
                                ;

        Options  options2 = new Options();
        options2.set( OvaldiOption.NO_VERIFY )
                .set( OvaldiOption.OVAL_XML_DIR, "C:\\app\\ovaldi-5.9.2-x64\\xml" )
                .set( OvaldiOption.OVAL_DEFINITIONS,
                                "test/resources/data/oval5/oval5.9_def12313-5_v_windows_CVE-2011-0031.xml"
                                )
                .set( OvaldiOption.OVAL_RESULTS,
                                "http://localhost:8080/oval_rep/r/oval_results"
                                )
                                ;

        return new Object[][] {
                        {
                            "C:\\app\\ovaldi-5.9.2-x64\\ovaldi.exe",
//                            options1,
                            options2
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
    public void testNetOvalInterpreter(
                    final String executable,
                    final Options options
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );

        Reporter.log( "* executable: " + executable, true );
        Reporter.log( "* options: " + options, true );

        NetworkingOvaldiProxy  ovaldi = new NetworkingOvaldiProxy();
        if (executable != null) {
            ovaldi.setExecutable( executable );
        }
        ovaldi.setOptions( options );

        int  exitValue = ovaldi.execute();
        Reporter.log( "@ exit value: " + exitValue, true );
    }

}
// NetOvalInterpreterTest
