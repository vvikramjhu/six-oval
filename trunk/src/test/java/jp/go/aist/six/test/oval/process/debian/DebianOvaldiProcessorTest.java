package jp.go.aist.six.test.oval.process.debian;

import jp.go.aist.six.oval.process.OvalProcessStatus;
import jp.go.aist.six.oval.process.debian.DebianOvaldiProcessor;
import jp.go.aist.six.test.oval.process.OvalProcessTestBase;
import org.testng.Assert;
import org.testng.Reporter;





/**
 * @author  Akihito Nakamura, AIST
 * @version $Id: DebianOvaldiProcessorTest.java 477 2010-03-27 09:15:05Z akihito $
 */
public class DebianOvaldiProcessorTest
extends OvalProcessTestBase
{

    /**
     */
    public DebianOvaldiProcessorTest()
    {
    }



    /**
     */
    public void run()
        throws Exception
    {
    }



    public static final String[]  SAMPLE_DSA =
        new String[] {
        "http://www.debian.org/security/2010/dsa-1974.en.html",
        "http://www.debian.org/security/2010/dsa-2001.en.html"
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
                        { new String[] {
                                        getOvaldiExecutable(),
                                        "-dsa", SAMPLE_DSA[0],
                                        "-s",
                                        "-m"
                                        }
                        },
                        { new String[] {
                                        getOvaldiExecutable(),
                                        "-dsa", SAMPLE_DSA[1],
                                        "-m",
                                        "-s",
                                        "-post", getOvalwsResultsPostURL()
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
        Reporter.log( "\n// OVAL Debian ovaldi processor: execute //", true );

        DebianOvaldiProcessor  processor = new DebianOvaldiProcessor( cmdarray );
        OvalProcessStatus  status = processor.execute();
        Assert.assertNotNull( status );

        Reporter.log( "  @ status=" + status, true );
    }

}
// DebianOvaldiProcessorTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

