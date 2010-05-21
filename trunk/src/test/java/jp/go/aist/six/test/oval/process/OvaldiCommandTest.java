package jp.go.aist.six.test.oval.process;

import jp.go.aist.six.oval.process.OvaldiCommand;
import org.testng.Assert;
import org.testng.Reporter;
import java.io.BufferedReader;
import java.io.InputStreamReader;





/**
 * @author  Akihito Nakamura, AIST
 * @version $Id: OvaldiCommandTest.java 373 2010-03-15 02:04:22Z akihito $
 */
public class OvaldiCommandTest
extends OvalProcessTestBase
{

    /**
     */
    public OvaldiCommandTest()
    {
    }



    /**
     */
    public void run()
        throws Exception
    {
    }



    /**
     * Sample Ovaldi command lines.
     *
     * @testng.data-provider name="ovaldi-command"
     */
    public
    Object[][] ovaldiCommandProvider()
    {
        return new Object[][] {
                        // input definitions
                        { new String[] {
                                        getOvaldiExecutable(),
                                        "-a", getOvaldiResourceDir(),
                                        "-o", getSampleOvalDefinitions(),
                                        "-s",
                                        "-m"
                                        }
                        },
                        // input definitions, output sc, output results
                        { new String[] {
                                        getOvaldiExecutable(),
                                        "-a", getOvaldiResourceDir(),
                                        "-o", getSampleOvalDefinitions(),
                                        "-s",
                                        "-m",
                                        "-d", "oval-sc.xml",
                                        "-r", "oval-r.xml"
                                        }
                        }
        };
    }



    /**
     * @testng.test groups="oval.interpriter"
     *              dataProvider="ovaldi-command"
     *              alwaysRun="true"
     */
    public
    void execute( final String[] cmdarray )
    throws Exception
    {
        Reporter.log( "\n// OVAL ovaldi command //", true );

        Reporter.log( "* creating OvaldiCommand instance ...", true );
        OvaldiCommand  ovaldi = new OvaldiCommand( cmdarray );
        Reporter.log( "* executing OvaldiCommand instance ...", true );
        Process  process = ovaldi.execute();
        Assert.assertNotNull( process );

        int  exitValue = 0;
        StringBuilder  log = new StringBuilder();
        String  lineSeparator = System.getProperty( "line.separator" );
        BufferedReader  reader = new BufferedReader(
                        new InputStreamReader( process.getInputStream() ) );
        try {
            String  line = null;
            while (true) {
                if (line != null) {
                    log.append( lineSeparator );
                }
                line = reader.readLine();
                              //throws IOException
                if (line == null) {
                    break;
                }
                log.append( line );
            }

        } catch (Exception ex) {
            Reporter.log( "@ reading process output failed: " + ex, true );
        } finally {
            try {
                exitValue = process.waitFor();
                                    //throws InterruptedException
                reader.close();
                       //throws IOException
            } catch (Exception ex) {
                Reporter.log( "@ process interrupted: " + ex, true );
            }
        }

        Reporter.log( "@ exeit value=" + exitValue, true );
        Reporter.log( "@ log=" + log.toString(), true );
    }

}
// OvaldiCommandTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

