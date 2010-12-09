package jp.go.aist.six.test.oval.process.debian;

import org.testng.annotations.DataProvider;




/**
 * Debian OVAL Test base class.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: DsaParserTest.java 469 2010-03-27 07:17:33Z akihito $
 */
public abstract class DebianOvalTestBase
{

    /**
     */
    public DebianOvalTestBase()
    {
    }



    public static final String  SAMPLE_DSA_FILEPATH
    = "test/data/debian_security_advisory/dsa-1974.en.html";

    public static final String  SAMPLE_DSA_URL
    = "http://www.debian.org/security/2010/dsa-1974.en.html";



    /**
     * Sample DSA HTML locations.
     */
    @DataProvider( name="oval-generator-input-output" )
    public Object[][] ovalGeneratorInputOutputProvider()
    {
        return new Object[][] {
//                        {
//                            "http://www.debian.org/security/2010/dsa-1974.en.html",
//                            null
//                        },
//                        {
//                            SAMPLE_DSA_FILEPATH,
//                            "definitions-1974.xml"
//                        }
                        {
                            SAMPLE_DSA_FILEPATH,
                            null
                        }
        };
    }



    /**
     * Sample DSA HTML file.
     */
    @DataProvider( name="dsa-html-filepath" )
    public Object[][] dsaHtmlFilepathProvider()
    {
        return new Object[][] {
                        {
                            SAMPLE_DSA_FILEPATH
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
                            SAMPLE_DSA_URL
                        }
        };
    }

}
// DebianOvalTestBase

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

