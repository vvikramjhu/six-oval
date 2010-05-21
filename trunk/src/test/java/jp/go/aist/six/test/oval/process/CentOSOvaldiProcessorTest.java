package jp.go.aist.six.test.oval.process;

import jp.go.aist.six.oval.process.OvalProcessStatus;
import jp.go.aist.six.oval.process.centos.CentOSOvaldiProcessor;
import org.testng.Assert;
import org.testng.Reporter;





/**
 * @author  Akihito Nakamura, AIST
 * @version $Id: CentOSOvaldiProcessorTest.java 378 2010-03-15 08:47:12Z akihito $
 */
public class CentOSOvaldiProcessorTest
extends OvalProcessTestBase
{

    /**
     */
    public CentOSOvaldiProcessorTest()
    {
    }



    /**
     */
    public void run()
        throws Exception
    {
    }



    public static final String[]  SAMPLE_REDHAT_OVAL_DEFINITIONS =
        new String[] {
        "test/xml/sample_oval-definitions_linux-redhat.xml",
        "https://rhn.redhat.com/rhn/oval?errata=9522"
    };



    /**
     * Sample Ovaldi command lines.
     *
     * @testng.data-provider name="ovaldi-command"
     */
    public
    Object[][] ovaldiCommandProvider()
    {
        return new Object[][] {
//                        { new String[] {
//                                        getOvaldiExecutable(),
//                                        "-a", getOvalResourceDir(),
//                                        "-rho", SAMPLE_REDHAT_OVAL_DEFINITIONS[0],
//                                        "-s",
//                                        "-m"
//                                        }
//                        },
//                        { new String[] {
//                                        "/usr/sbin/ovaldi",
//                                        "-a", "/usr/share/ovaldi",
//                                        "-rho", SAMPLE_REDHAT_OVAL_DEFINITIONS[1],
//                                        "-s",
//                                        "-m"
//                            }
//                        },
                        { new String[] {
                                        "/usr/sbin/ovaldi",
                                        "-a", "/usr/share/ovaldi",
                                        "-rho", SAMPLE_REDHAT_OVAL_DEFINITIONS[0],
                                        "-post", getOvalwsResultsPostURL(),
                                        "-s",
                                        "-m"
                            }
                        }
        };

    }



    /**
     * @testng.test groups="oval.interpriter"
     *              dataProvider="ovaldi-command"
     *              alwaysRun="true"
     */
    public void executeLinux(
                    final String[] cmdarray
                    )
    throws Exception
    {
        Reporter.log( "\n// OVAL CentOS ovaldi processor: execute //", true );

        CentOSOvaldiProcessor  processor = new CentOSOvaldiProcessor( cmdarray );
        OvalProcessStatus  status = processor.execute();
        Assert.assertNotNull( status );

        Reporter.log( "  @ status=" + status, true );
    }

}
// CentOSOvaldiProcessorTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

