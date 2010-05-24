package jp.go.aist.six.test.oval.process.debian;

import jp.go.aist.six.oval.process.OvalProcessStatus;
import jp.go.aist.six.oval.process.debian.DebianOvalGenerator;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;





/**
 * @author  Akihito Nakamura, AIST
 * @version $Id: DebianOvalGeneratorTest.java 521 2010-04-07 01:20:21Z akihito $
 */
public class DebianOvalGeneratorTest
{

    /**
     */
    public DebianOvalGeneratorTest()
    {
    }



    /**
     */
    public void run()
        throws Exception
    {
    }



    /**
     */
    @BeforeClass( alwaysRun=true )
    public void setUp()
    throws Exception
    {
    }



    /**
     * Sample DSA HTML locations.
     */
    @DataProvider( name="dsa-html-location" )
    public Object[][] dsaLocationProvider()
    {
        return new Object[][] {
//                        {
//                            "http://www.debian.org/security/2010/dsa-1974.en.html",
//                            null
//                        },
//                        {
//                            "test/data/dsa-1974.en.html",
//                            "definitions-1974.xml"
//                        }
                        {
                            "test/data/dsa-1974.en.html",
                            null
                        }
        };
    }



    /**
     */
    @org.testng.annotations.Test( groups={"oval.debian", "dsa"},
                    dataProvider="dsa-html-location",
                    alwaysRun=true
                    )
    public void execute(
                    final String dsaLocation,
                    final String outputLocation
                    )
    throws Exception
    {
        Reporter.log( "\n// OVAL Debian definitions generator //", true );

        Reporter.log( "*** generating Debian OVAL definitions...: source="
                        + dsaLocation, true );
        DebianOvalGenerator  generator =
            new DebianOvalGenerator( dsaLocation );
        if (outputLocation != null) {
            generator.setOutputDefinitionLocation( outputLocation );
        }
        OvalProcessStatus  status = generator.execute();

        Reporter.log( "@@@ status: " + status, true );
        Assert.assertTrue( !status.isError() );
    }

}
// DebianOvalGeneratorTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

