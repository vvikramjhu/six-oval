package jp.go.aist.six.test.oval.core.xml;

import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.results.Content;
import jp.go.aist.six.oval.model.results.Directive;
import jp.go.aist.six.oval.model.results.Directives;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.test.oval.core.CoreTestBase;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalXmlTest
    extends CoreTestBase
{

    /**
     */
    public OvalXmlTest()
    {
    }



    /**
     */
    protected void _marshal(
                    final Object object,
                    final OutputStream out
                    )
    throws Exception
    {
        Reporter.log( "marshalling...", true );
        _getXml().marshal( object, out );
        Reporter.log( "...marshalling done", true );
    }



    /**
     */
    protected void _processXml(
                    final Class<?> type,
                    final String testedXPath,
                    final String filepath,
                    final Object expected
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL XML //", true );
        Reporter.log( "  * tested XPath: " + testedXPath, true );
        Reporter.log( "  * tested XML file: " + filepath, true );

        Object  actual = _unmarshalFile( filepath, type );

        if (expected != null) {
            Reporter.log( "validating...", true );
            Assert.assertEquals( actual, expected );
            Reporter.log( "...validation OK", true );
        }

        _marshal( actual, new FileOutputStream( new File( "foo.xml" ) ) );

//        _marshal( actual, System.out );
    }




    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //
    //  Definitions
    //
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    //==============================================================
    //  oval_definitions
    //==============================================================

    @DataProvider( name="oval-definitions_oval_definitions" )
    public Object[][] provideOvalDefinitionsOvalDefinitions()
    {
        return new Object[][] {
                        {
                            OvalDefinitions.class,
                            "/oval_definitions",
                            "test/data/definitions/oval-definitions_CVE-2009-4019_MySQL.xml",
                            null
                        }
        };

    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "oval-definitions.oval_definitions"},
                    dataProvider="oval-definitions_oval_definitions",
                    alwaysRun=true
                    )
    public void testOvalDefinitionsOvalDefinitions(
                    final Class<?> type,
                    final String testedXPath,
                    final String filepath,
                    final OvalDefinitions expected
                    )
    throws Exception
    {
        _processXml( type, testedXPath, filepath, expected );
    }



    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //
    //  Results
    //
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    //==============================================================
    //  oval_results
    //==============================================================

    @DataProvider( name="oval-results_oval_results" )
    public Object[][] provideOvalResultsOvalResults()
    {
        return new Object[][] {
                      // Windows @Mitre, CVE-2010-0176
                      {
                          OvalResults.class,
                          "/oval_results",
                          "test/data/results/oval-results_CVE-2010-0176_mitre7222.xml",
                          null
                      }
//                      ,
//
//                      // Red Hat patch, CVE-2010-0176, RHSA 20100332
//                      {
//                          OvalResults.class,
//                          "/oval_results",
//                          "test/data/results/oval-results_CVE-2010-0176_rhsa20100332.xml",
//                          null
//                      }
//                      ,
//
//                      // Debian @Mitre, CVE-2010-0176, DSA-2027
//                      {
//                          OvalResults.class,
//                          "/oval_results",
//                          "test/data/results/oval-results_CVE-2010-0176_mitre7432_DSA-2027.xml",
//                          null
//                      }
////                      ,

        };

    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "oval-results.oval_results"},
                    dataProvider="oval-results_oval_results",
                    alwaysRun=true
                    )
    public void testOvalResultsOvalResults(
                    final Class<?> type,
                    final String testedXPath,
                    final String filepath,
                    final Object expected
                    )
    throws Exception
    {
        _processXml( type, testedXPath, filepath, expected );
    }



    //==============================================================
    //  directives
    //==============================================================

    public static final Directives OVAL_RESULTS_DIRECTIVES_01 =
        new Directives(
                        new Directive( true, Content.FULL ),
                        new Directive( true, Content.FULL ),
                        new Directive( true, Content.FULL ),
                        new Directive( true, Content.FULL ),
                        new Directive( true, Content.FULL ),
                        new Directive( true, Content.FULL )
                        );


    @DataProvider( name="oval-results_directives" )
    public Object[][] provideOvalResultsDirectives()
    {
        return new Object[][] {
                        {
                            Directives.class,
                            "/oval_results/directives",
                            "test/data/results/directives_01.xml",
                            OVAL_RESULTS_DIRECTIVES_01
                        }
        };

    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "oval-results.directives"},
                    dataProvider="oval-results_directives",
                    alwaysRun=true
                    )
    public void testOvalResultsDirectives(
                    final Class<?> type,
                    final String testedXPath,
                    final String filepath,
                    final Directives expected
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL XML //", true );
        Reporter.log( "  * tested XPath: " + testedXPath, true );
        Reporter.log( "  * tested XML file: " + filepath, true );

        Object  actual = _unmarshalFile( filepath, type );

        if (expected != null) {
            Reporter.log( "validating...", true );
            Assert.assertEquals( actual, expected );
            Reporter.log( "...validation OK", true );
        }

        _marshal( actual, System.out );
    }

}
// OvalXmlTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

