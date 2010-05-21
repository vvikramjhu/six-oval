package jp.go.aist.six.test.oval.process.debian;

import jp.go.aist.six.oval.model.definition.OvalDefinitions;
import jp.go.aist.six.oval.process.debian.builder.DebianOvalBuilder;
import jp.go.aist.six.oval.process.debian.dsa.Dsa;
import jp.go.aist.six.oval.process.debian.dsa.DsaParser;
import jp.go.aist.six.oval.service.Oval;
import org.testng.Assert;
import org.testng.Reporter;
import java.io.File;
import java.io.FileInputStream;





/**
 * @author  Akihito Nakamura, AIST
 * @version $Id: DebianOvalBuilderTest.java 419 2010-03-18 09:53:12Z akihito $
 */
public class DebianOvalBuilderTest
{

    /**
     */
    public DebianOvalBuilderTest()
    {
    }



    /**
     */
    public void run()
        throws Exception
    {
    }



    /**
     * @testng.before-class alwaysRun="true"
     */
    public void setUp()
    throws Exception
    {
    }



    /**
     * Sample DSA HTML file.
     *
     * @testng.data-provider name="dsa-html-filepath"
     */
    public
    Object[][] dsaHtmlFilepathProvider()
    {
        return new Object[][] {
                        {
                            "test/data/dsa-1974.en.html"
                        }
        };
    }



    /**
     * @testng.test groups="oval.debian builder"
     *              dataProvider="dsa-html-filepath"
     *              alwaysRun="true"
     */
    public void createOvalDefinitions(
                    final String dsaFilepath
                    )
    throws Exception
    {
        Reporter.log( "\n// OVAL Debian builder //", true );

        File  file = new File( dsaFilepath );
        String  filepath = file.getAbsolutePath();

        Reporter.log( "*** parsing DSA HTML...: file=" + filepath, true );
        DsaParser  parser = new DsaParser();
        Dsa  dsa = parser.parse( new FileInputStream( file ) );
        Assert.assertNotNull( dsa );
        Reporter.log( "@@@ DSA=" + dsa, true );

        DebianOvalBuilder  builder = new DebianOvalBuilder();
        OvalDefinitions  oval = builder.createOvalDefinitions( dsa );
        Assert.assertNotNull( oval );
        Reporter.log( "@@@ OvalDefinitions=" + oval, true );

        String  xml = Oval.getXml().marshalToString( oval );
        Reporter.log( "@@@ oval_definitions XML: ", true );
        Reporter.log( xml, true );
    }

}
// DebianOvalBuilderTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

