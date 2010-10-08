package jp.go.aist.six.test.oval.process.debian;

import jp.go.aist.six.oval.process.OvalProcessStatus;
import jp.go.aist.six.oval.process.debian.DebianOvalGenerator;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;





/**
 * @author  Akihito Nakamura, AIST
 * @version $Id: DebianOvalGeneratorTest.java 521 2010-04-07 01:20:21Z akihito $
 */
public class DebianOvalGeneratorTest
extends DebianOvalTestBase
{

    /**
     */
    public DebianOvalGeneratorTest()
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
     */
    @org.testng.annotations.Test( groups={"oval.debian", "dsa"},
                    dataProvider="oval-generator-input-output",
                    alwaysRun=true
                    )
    public void execute(
                    final String inputDsaLocation,
                    final String outputOvalLocation
                    )
    throws Exception
    {
        Reporter.log( "\n// OVAL Debian definitions generator //", true );

        Reporter.log( "*** generating Debian OVAL definitions...: source="
                        + inputDsaLocation, true );
        DebianOvalGenerator  generator =
            new DebianOvalGenerator( inputDsaLocation );
        if (outputOvalLocation != null) {
            generator.setOutputDefinitionLocation( outputOvalLocation );
        }
        OvalProcessStatus  status = generator.execute();

        Reporter.log( "@@@ status: " + status, true );
        Assert.assertTrue( !status.isError() );
    }

}
// DebianOvalGeneratorTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

