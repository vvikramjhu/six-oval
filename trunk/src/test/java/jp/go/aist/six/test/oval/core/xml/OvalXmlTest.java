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
                    final String sourceFilepath,
                    final Object expected,
                    final String resultFilepath
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL XML //", true );
        Reporter.log( "  * tested XPath: " + testedXPath, true );
        Reporter.log( "  * tested XML file: " + sourceFilepath, true );

        Object  actual = _unmarshalFile( sourceFilepath, type );

        if (expected != null) {
            Reporter.log( "validating...", true );
            Assert.assertEquals( actual, expected );
            Reporter.log( "...validation OK", true );
        }

        OutputStream  output = null;
        if (resultFilepath == null) {
            output = System.out;
        } else {
            Reporter.log( "  * marshalled XML file: " + resultFilepath, true );
            output = new FileOutputStream( new File( resultFilepath ) );
        }
        _marshal( actual, output );
    }




    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //
    //  Definitions
    //
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    //==============================================================
    //  oval_definitions
    //==============================================================

    @DataProvider( name="definitions.oval_definitions" )
    public Object[][] provideOvalDefinitionsOvalDefinitions()
    {
        return new Object[][] {
//                        // Windows @ Mitre, CVE-2009-4019
//                        {
//                            OvalDefinitions.class,
//                            "/oval_definitions",
//                            "test/data/definitions/oval-definitions_CVE-2009-4019_MySQL.xml",
//                            null,
//                            "marshalled_oval-definitions_CVE-2009-4019_MySQL.xml"
//                        }
//                        ,
//
////                      // Red Hat, CVE-2010-0176, RHSA 20100332
//                        {
//                            OvalDefinitions.class,
//                            "/oval_definitions",
//                            "test/data/definitions/oval-definitions_CVE-2010-0176_rhsa20100332.xml",
//                            null,
//                            "marshalled_oval-definitions_CVE-2010-0176_rhsa20100332.xml"
//                        }
//                        ,
//
////                      // Debian @Mitre, CVE-2010-0176, DSA-2027
//                        {
//                            OvalDefinitions.class,
//                            "/oval_definitions",
//                            "test/data/definitions/oval-definitions_CVE-2010-0176_mitre7432_DSA-2027.xml",
//                            null,
//                            "marshalled_oval-definitions_CVE-2010-0176_mitre7432_DSA-2027.xml"
//                        }
//                        ,
//
//                        // Windows XP @ Mitre, all vulnerability, 2010-08-27
//                        {
//                            OvalDefinitions.class,
//                            "/oval_definitions",
//                            "test/data/definitions/20100827_vulnerability_microsoft.windows.xp.xml",
//                            null,
//                            "marshalled_20100827_vulnerability_microsoft.windows.xp.xml"
//                        }
//                        ,
//
//                        // Windows 7 @ Mitre, all vulnerability, 2010-08-27
//                        {
//                            OvalDefinitions.class,
//                            "/oval_definitions",
//                            "test/data/definitions/20100827_vulnerability_microsoft.windows.7.xml",
//                            null,
//                            "marshalled_20100827_vulnerability_microsoft.windows.7.xml"
//                        }
//                        ,

                        // Windows Server 2008 @ Mitre, all vulnerability, 2010-08-27
                        {
                            OvalDefinitions.class,
                            "/oval_definitions",
                            "test/data/definitions/20100827_vulnerability_microsoft.windows.server.2008.xml",
                            null,
                            "marshalled_20100827_vulnerability_microsoft.windows.server.2008.xml"
                        }
        };

    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "definitions.oval_definitions"},
                    dataProvider="definitions.oval_definitions",
                    alwaysRun=true
                    )
    public void testOvalDefinitionsOvalDefinitions(
                    final Class<?> type,
                    final String testedXPath,
                    final String filepath,
                    final OvalDefinitions expected,
                    final String resultFilepath
                    )
    throws Exception
    {
        _processXml( type, testedXPath, filepath, expected, resultFilepath );
    }



    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //
    //  Results
    //
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    //==============================================================
    //  oval_results
    //==============================================================

    @DataProvider( name="results.oval_results" )
    public Object[][] provideOvalResultsOvalResults()
    {
        return new Object[][] {
                      // Windows @Mitre, CVE-2010-0176
                      {
                          OvalResults.class,
                          "/oval_results",
                          "test/data/results/oval-results_CVE-2010-0176_mitre7222.xml",
                          null,
                          "marshalled_oval-results_CVE-2010-0176_mitre7222.xml"
                      }
                      ,

                      // Red Hat patch, CVE-2010-0176, RHSA 20100332
                      {
                          OvalResults.class,
                          "/oval_results",
                          "test/data/results/oval-results_CVE-2010-0176_rhsa20100332.xml",
                          null,
                          "marshalled_oval-results_CVE-2010-0176_rhsa20100332.xml"
                      }
                      ,

                      // Debian @Mitre, CVE-2010-0176, DSA-2027
                      {
                          OvalResults.class,
                          "/oval_results",
                          "test/data/results/oval-results_CVE-2010-0176_mitre7432_DSA-2027.xml",
                          null,
                          "marshalled_oval-results_CVE-2010-0176_mitre7432_DSA-2027.xml"
                      }
////                      ,

        };

    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "results.oval_results"},
                    dataProvider="results.oval_results",
                    alwaysRun=true
                    )
    public void testOvalResultsOvalResults(
                    final Class<?> type,
                    final String testedXPath,
                    final String sourceFilepath,
                    final Object expected,
                    final String resultFilepath
                    )
    throws Exception
    {
        _processXml( type, testedXPath, sourceFilepath, expected, resultFilepath );
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


    @DataProvider( name="results.directives" )
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
                    groups={"oval.core.xml", "results.directives"},
                    dataProvider="results.directives",
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

