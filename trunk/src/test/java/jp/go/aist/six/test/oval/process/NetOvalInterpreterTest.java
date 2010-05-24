package jp.go.aist.six.test.oval.process;

import jp.go.aist.six.oval.process.NetOvalInterpreter;
import jp.go.aist.six.oval.process.OvalProcessStatus;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;





/**
 * @author  Akihito Nakamura, AIST
 * @version $Id: NetOvalInterpreterTest.java 524 2010-04-07 06:11:11Z akihito $
 */
public class NetOvalInterpreterTest
extends OvalProcessTestBase
{

    /**
     */
    public NetOvalInterpreterTest()
    {
    }



    /**
     */
    public void run()
        throws Exception
    {
    }



    public String getSampleNetOvalDefinitions()
    {
        return getResourceString( "sample.oval_definitions.url" );
    }




    /**
     * Sample Ovaldi command lines.
     */
    @DataProvider( name="ovaldi-command" )
    public Object[][] ovaldiCommandProvider()
    {
        return new Object[][] {
                        // input definitions
                        { new String[] {
                                        getOvaldiExecutable(),
                                        "-a", getOvaldiResourceDir(),
                                        "-o", getSampleNetOvalDefinitions(),
                                        "-s",
                                        "-m"
                                        }
                        }
//                        ,
//                        { new String[] {
//                                        getOvaldiExecutable(),
//                                        "-a", getOvaldiResourceDir(),
//                                        "-o", getSampleNetOvalDefinitions(),
//                                        "-s",
//                                        "-m",
//                                        "-post", getOvalwsResultsPostURL()
//                                        }
//                        }
        };
    }



    /**
     */
    @org.testng.annotations.Test( groups={"oval.interpriter"},
                    dataProvider="ovaldi-command",
                    alwaysRun=true
                    )
    public void execute(
                    final String[] cmdarray
                    )
    throws Exception
    {
        Reporter.log( "\n// OVAL ovaldi command //", true );

        NetOvalInterpreter  proc = new NetOvalInterpreter( cmdarray );
        OvalProcessStatus  status = proc.execute();
        Assert.assertNotNull( status );


        Reporter.log( "  @ status=" + status, true );
//        Reporter.log( "  @ error=" + status.isError(), true );
//        Reporter.log( "  @ error message=" + status.getErrorMessage(), true );
//        Reporter.log( "  @ exeit value=" + status.getAttribute( NetOvaldiProcessor.ATTR_OVALDI_EXIT_VALUE ), true );
//        Reporter.log( "  @ log message=" + status.getAttribute( NetOvaldiProcessor.ATTR_OVALDI_LOG ), true );
    }

}
// NetOvalInterpreterTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

