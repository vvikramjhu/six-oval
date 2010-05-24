package jp.go.aist.six.test.oval.process.debian;

import jp.go.aist.six.oval.process.debian.dsa.Dsa;
import jp.go.aist.six.oval.process.debian.dsa.DsaParser;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;




/**
 * DsaParser tests.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: DsaParserTest.java 469 2010-03-27 07:17:33Z akihito $
 */
public class DsaParserTest
{

    /**
     */
    public DsaParserTest()
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
     * Sample DSA HTML file.
     */
    @DataProvider( name="dsa-html-filepath" )
    public Object[][] dsaHtmlFilepathProvider()
    {
        return new Object[][] {
                        {
                            "test/data/debian_security_advisory/dsa-1974.en.html"
                        }
        };
    }



    /**
     * Sample DSA HTML URL.
     */
    @DataProvider( name="dsa-html-url" )
    public Object[][] dsaHtmlUrlProvider()
    {
        return new Object[][] {
                        {
                            "http://www.debian.org/security/2010/dsa-1974.en.html"
                        }
        };
    }



    /**
     */
    @org.testng.annotations.Test( groups={"oval.debian", "dsa"},
                    dataProvider="dsa-html-filepath",
                    alwaysRun=true
                    )
    public void parseFile(
                    final String dsaFilepath
                    )
    throws Exception
    {
        Reporter.log( "\n// OVAL DSA parser //", true );
        Reporter.log( "*** parsing DSA HTML...: file=" + dsaFilepath, true );

        File  file = new File( dsaFilepath );
        String  filepath = file.getAbsolutePath();
        Reporter.log( "* absolute path=" + filepath, true );

        _parseDsaHtml( new FileInputStream( file ) );
    }



    /**
     */
    @org.testng.annotations.Test( groups={"oval.debian", "dsa"},
                    dataProvider="dsa-html-url",
                    alwaysRun=true
                    )
    public void parseUrl(
                    final String dsaUrl
                    )
    throws Exception
    {
        Reporter.log( "\n// OVAL DSA parser //", true );
        Reporter.log( "*** parsing DSA HTML...: URL=" + dsaUrl, true );

        URL  url = new URL( dsaUrl );
        _parseDsaHtml( url.openStream() );
    }



    private void _parseDsaHtml(
                    final InputStream stream
                    )
    throws Exception
    {
        DsaParser  parser = new DsaParser();
        Dsa  dsa = parser.parse( stream );
        Assert.assertNotNull( dsa );

        Reporter.log( "@ DSA=" + dsa, true );
//        Assert.assertEquals( dsa.getTitle(), "DSA-1974-1 gzip -- several vulnerabilities" );
    }

}
// DsaParserTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

