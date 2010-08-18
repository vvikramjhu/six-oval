package jp.go.aist.six.test.oval.core.service.restlet;

import jp.go.aist.six.oval.process.OvalDocument;
import jp.go.aist.six.test.oval.core.CoreTestBase;
import jp.go.aist.six.util.net.RestletHttp;
import org.restlet.data.Form;
import org.restlet.data.Reference;
import org.restlet.data.Response;
import org.restlet.data.Status;
import org.restlet.resource.Representation;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.StringWriter;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalRestClientTest
    extends CoreTestBase
{


    /**
     */
    @BeforeClass( alwaysRun=true )
    public void setUp()
    throws Exception
    {
        super.setUp();
    }



    //==============================================================
    //  results
    //==============================================================

    @DataProvider( name="oval_results" )
    private Object[][] _ovalResultsProvider()
    {
        return new Object[][] {
                      // Windows @Mitre, CVE-2010-0176
                      {
                          "http://localhost:8080/six-oval-0.5.0/results",
                          "test/data/results/oval-results_CVE-2010-0176_mitre7222.xml"
                      }
//                      ,
//
//                      // Red Hat patch, CVE-2010-0176, RHSA 20100332
//                      {
//                          "test/data/results/oval-results_CVE-2010-0176_rhsa20100332.xml"
//                      }
//                      ,
//
//                      // Debian @Mitre, CVE-2010-0176, DSA-2027
//                      {
//                          "test/data/results/oval-results_CVE-2010-0176_mitre7432_DSA-2027.xml",
//                      }
//                      ,

//                    // Red Hat patch, CVE-2010-0176, RHSA 20100333
//                    {
//                        "test/data/result/com.redhat.rhsa-20100332_CVE-2010-0176_results.xml",
//                    }
//                    ,
//

//                        // windows vulnerability, IE6, CVE-2006-1189
//                        {
//                            "test/data/result/oval-2010-06-15.05.04.34_results.xml",
//                        }
//                        ,
//
//                        // Debian patch, CVE-2010-0176
//                        {
//                            "test/data/result/oval-2010-07-27.04.27.53_DSA-2027_results.xml",
//                        }
//                        ,

//                        // windows vulnerability
//                        {
//                            "test/data/result/oval-2010-06-15.05.04.34_results.xml",
//                        }
//                        ,

//                        // windows inventory
//                        {
//                            "test/data/result/sample_oval-results_inventory_windows-xp.xml",
//                        }
//                        ,

        };

    }


    /**
     */
    @org.testng.annotations.Test(
                    groups={"oval.service.core.restlet", "oval_results"},
                    dataProvider="oval_results",
                    alwaysRun=true
                    )
    public void testPostOvalResults(
                    final String ovalWsUrl,
                    final String filepath
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL - OvalRestClient //", true );

        StringWriter  writer = new StringWriter();
        OvalDocument.read( writer, new File( filepath ) );

        String  xmlString = writer.toString();

        Reporter.log( "HTTP POST OVAL Results...", true );
        Reporter.log( "  - URL=" + ovalWsUrl, true );
        RestletHttp  http = new RestletHttp();
        Form  form = new Form();
        form.add( "oval_results", xmlString );
        Representation  rep = form.getWebRepresentation();
        Response  response = http.post( ovalWsUrl, rep );
        Reporter.log( "...HTTP POST OVAL Results done.", true );

        Status  http_status = response.getStatus();
        Reporter.log( "  - status=" + http_status, true );

        Reference  createdLocation = response.getEntity().getIdentifier();
        if (createdLocation != null) {
            Reporter.log( "  - created location=" + createdLocation, true );
        }
    }

}
// OvalRestClientTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

