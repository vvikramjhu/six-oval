package jp.go.aist.six.test.oval.core.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import jp.go.aist.six.util.xml.XmlTransformer;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class XmlTransformTest
{

    private static final String  _XSLT_STYLESHEET_ =
        "/oval5.xsl";



    /**
     */
    public XmlTransformTest()
    {
    }



    //**************************************************************
    //
    //**************************************************************

    @DataProvider( name="oval.definitions.xml.transform" )
    public Object[][] provideOvalResultsXml()
    {
        return new Object[][] {
                        // OVAL5.9, def:12313-5, vulnerability, Windows
                        // file, family, registry
                        {
                            "test/resources/data/oval5/oval5.9_def12313-5_v_windows_CVE-2011-0031.xml",
                            "transformed_oval5.9_def12313-5_v_windows_CVE-2011-0031.xml"
                        }
        };
    }



    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "oval.definitions.oval_definitions"},
                    dataProvider="oval.definitions.xml.transform",
                    alwaysRun=true
                    )
    public void testTransform(
                    final String sourceFilepath,
                    final String resultFilepath
                    )
    throws Exception
    {
        Reporter.log( "\n////////////////////////////////////////////", true );

        URL  stylesheetLocation = getClass().getResource( _XSLT_STYLESHEET_ );
//        File  stylesheetLocation = new File( _XSLT_STYLESHEET_ );
        Reporter.log( "  @ XSLT stylesheet location: " + stylesheetLocation, true );
        XmlTransformer  transformer = new XmlTransformer( stylesheetLocation );

        transformer.transform(
                        new FileInputStream( new File( sourceFilepath ) ),
                        new FileOutputStream( new File( resultFilepath ) ) );
    }

}
// XmlTransformTest
