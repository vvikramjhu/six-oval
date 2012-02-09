package jp.go.aist.six.test.oval.core.interpreter;

import jp.go.aist.six.oval.core.interpreter.NetworkingOvaldiProxy;
import jp.go.aist.six.oval.core.interpreter.OvaldiOption;
import jp.go.aist.six.oval.core.interpreter.OvaldiProxy;
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

    private static final String  _OVALDI_DIR_ = "C:\\app\\ovaldi-5.10.1.1-x64";

    private static final String  _OVALDI_EXECUTABLE_ = _OVALDI_DIR_ + "\\ovaldi.exe";
    private static final String  _OVALDI_XML_ = _OVALDI_DIR_ + "\\xml";




    /**
     */
    protected void _executeOvalInterpreter(
                    final OvalInterpreter ovaldi,
                    final Options options
                    )
    throws Exception
    {
        Reporter.log( "* options: " + options, true );
        ovaldi.setOptions( options );
        int  exitValue = ovaldi.execute();
        Reporter.log( "@ exit value: " + exitValue, true );
    }




    @DataProvider( name="oval.interpreter.options" )
    public Object[][] provideOvalInterpreterOptions()
    {
        //minimum options
        Options  options1 = new Options();
        options1.set( OvaldiOption.NO_VERIFY )
//                .set( OvaldiOption.OVAL_XML_DIR, _OVALDI_XML_ )
                .set( OvaldiOption.OVAL_DEFINITIONS,
                                "test/resources/OvalTestContent/5.10/windows/ind-def_family_test.xml" );

        return new Object[][] {
                        {
                            _OVALDI_EXECUTABLE_,
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

        OvaldiProxy  ovaldi = new OvaldiProxy();
        Reporter.log( "* executable: " + executable, true );
        if (executable != null) {
            ovaldi.setExecutable( executable );
        }

        _executeOvalInterpreter( ovaldi, options );
//        Reporter.log( "* options: " + options, true );
//        ovaldi.setOptions( options );
//        int  exitValue = ovaldi.execute();
//        Reporter.log( "@ exit value: " + exitValue, true );
    }




    /**
     */
    @DataProvider( name="oval.interpreter.options.networking" )
    public Object[][] provideNetOvalInterpreterOptions()
    {

        // minimum local test
        Options  options1 = new Options();
        options1.set( OvaldiOption.NO_VERIFY )
//                .set( OvaldiOption.OVAL_XML_DIR, _OVALDI_XML_ )
                .set( OvaldiOption.OVAL_DEFINITIONS,
                                "test/resources/OvalTestContent/5.10/windows/ind-def_family_test.xml" );

        Options  options_net1 = new Options();
        options_net1.set( OvaldiOption.NO_VERIFY )
                .set( OvaldiOption.OVAL_XML_DIR, _OVALDI_XML_ )
                .set( OvaldiOption.OVAL_DEFINITIONS,
                                "http://oval.mitre.org/repository/data/DownloadDefinition?id=oval%3aorg.mitre.oval%3adef%3a12541&type=view" )
                                // inventory, Windows 7 is installed
                .set( OvaldiOption.OVAL_RESULTS,
                                "oval-12451_results.xml" )
                .set( OvaldiOption.OVAL_TRANSFORMED_RESULTS,
                                "oval-12451_results.html" )
                                ;

//        Options  options1 = new Options();
//        options1.set( OvaldiOption.NO_VERIFY )
//                .set( OvaldiOption.OVAL_XML_DIR, _OVALDI_XML_ )
//                .set( OvaldiOption.OVAL_DEFINITIONS,
//                                "http://oval.mitre.org/repository/data/DownloadDefinition?id=oval%3aorg.mitre.oval%3adef%3a2545&type=view"
////                                "test/resources/data/oval5/oval5.9_def12313-5_v_windows_CVE-2011-0031.xml"
//                                )
//                                ;

        Options  options_net2 = new Options();
        options_net2.set( OvaldiOption.NO_VERIFY )
                .set( OvaldiOption.OVAL_XML_DIR, _OVALDI_XML_ )
                .set( OvaldiOption.OVAL_DEFINITIONS,
                                "test/resources/OvalTestContent/5.10/windows/ind-def_family_test.xml" )
                .set( OvaldiOption.OVAL_RESULTS,
                                "http://localhost:8080/oval_rep/r/oval_results" )
                                ;

        return new Object[][] {
                        {
                            _OVALDI_EXECUTABLE_,
                            options1
                        }
                        ,
                        {
                            _OVALDI_EXECUTABLE_,
                            options_net1
                        }
//                        ,
//                        {
//                            _OVALDI_EXECUTABLE_,
//                            options_net2
//                        }
        };

    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={ "oval.interpreter.networking" },
                    dataProvider="oval.interpreter.options.networking",
                    dependsOnGroups={ "oval.interpreter" },
                    alwaysRun=true
                    )
    public void testNetworkingOvaldiProxy(
                    final String executable,
                    final Options options
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );

        NetworkingOvaldiProxy  ovaldi = new NetworkingOvaldiProxy();
        Reporter.log( "* executable: " + executable, true );
        if (executable != null) {
            ovaldi.setExecutable( executable );
        }

        _executeOvalInterpreter( ovaldi, options );
    }

}
//OvalInterpreterTest
