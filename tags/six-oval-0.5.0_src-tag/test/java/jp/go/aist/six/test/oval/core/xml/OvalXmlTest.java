package jp.go.aist.six.test.oval.core.xml;

import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.results.Content;
import jp.go.aist.six.oval.model.results.Directive;
import jp.go.aist.six.oval.model.results.Directives;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.test.oval.core.CoreTestBase;
import org.testng.annotations.DataProvider;



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
    protected <T> void _testXml(
                    final Class<T> type,
                    final String sourceFilepath,
                    final String xpath,
                    final T expected,
                    final String resultFilepath
                    )
    throws Exception
    {
        T  actual = _readObjectFromXmlFile( type, sourceFilepath, xpath, expected );
        _writeObjectToXmlFile( actual, resultFilepath );
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
//                        // Windows XP @ Mitre, all the vulnerabilities
//                        {
//                            OvalDefinitions.class,
//                            "test/data/definitions/20100827_vulnerability_microsoft.windows.xp.xml",
//                            "/oval_definitions",
//                            null,
//                            "marshalled_20100827_vulnerability_microsoft.windows.xp.xml"
//                        }
//                        ,
                        // Windows @ Mitre, CVE-2009-4019
                        {
                            OvalDefinitions.class,
                            "test/data/definitions/oval-definitions_CVE-2009-4019_MySQL.xml",
                            "/oval_definitions",
                            null,
                            "marshalled_oval-definitions_CVE-2009-4019_MySQL.xml"
                        }
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
//
//                        // Windows Server 2008 @ Mitre, all vulnerability, 2010-08-27
//                        {
//                            OvalDefinitions.class,
//                            "/oval_definitions",
//                            "test/data/definitions/20100827_vulnerability_microsoft.windows.server.2008.xml",
//                            null,
//                            "marshalled_20100827_vulnerability_microsoft.windows.server.2008.xml"
//                        }
//                        ,
//
//                        // Debian 5.0 @ Mitre, all patches, 2010-08-30
//                        {
//                            OvalDefinitions.class,
//                            "/oval_definitions",
//                            "test/data/definitions/20100830_patch_debian.gnu.linux.5.0.xml",
//                            null,
//                            "marshalled_20100830_patch_debian.gnu.linux.5.0.xml"
//                        }
//                        ,
//
//                        // Red Hat Enterprise Linux 5.0 @ Mitre, all vulnerabilities, 2010-08-30
//                        {
//                            OvalDefinitions.class,
//                            "/oval_definitions",
//                            "test/data/definitions/20100830_vulnerability_red.hat.enterprise.linux.5.xml",
//                            null,
//                            "marshalled_20100830_vulnerability_red.hat.enterprise.linux.5.xml"
//                        }
//                        ,
//
//                        // Red Hat Enterprise Linux @ Red Hat, all , 2010-08-26
//                        {
//                            OvalDefinitions.class,
//                            "/oval_definitions",
//                            "test/data/definitions/20100826_com.redhat.rhsa-all.xml",
//                            null,
//                            "marshalled_20100826_com.redhat.rhsa-all.xml"
//                        }
        };

    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "definitions.oval_definitions"},
                    dataProvider="definitions.oval_definitions",
                    alwaysRun=true
                    )
    public void testDefinitionsOvalDefinitions(
                    final Class<OvalDefinitions> type,
                    final String sourceFilepath,
                    final String xpath,
                    final OvalDefinitions expected,
                    final String resultFilepath
                    )
    throws Exception
    {
        _testXml( type, sourceFilepath, xpath, expected, resultFilepath );
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
                          "test/data/results/oval-results_CVE-2010-0176_mitre7222.xml",
                          "/oval_results",
                          null,
                          "marshalled_oval-results_CVE-2010-0176_mitre7222.xml"
                      }
                      ,

                      // Red Hat patch, CVE-2010-0176, RHSA 20100332
                      {
                          OvalResults.class,
                          "test/data/results/oval-results_CVE-2010-0176_rhsa20100332.xml",
                          "/oval_results",
                          null,
                          "marshalled_oval-results_CVE-2010-0176_rhsa20100332.xml"
                      }
                      ,

                      // Debian @Mitre, CVE-2010-0176, DSA-2027
                      {
                          OvalResults.class,
                          "test/data/results/oval-results_CVE-2010-0176_mitre7432_DSA-2027.xml",
                          "/oval_results",
                          null,
                          "marshalled_oval-results_CVE-2010-0176_mitre7432_DSA-2027.xml"
                      }
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
                    final Class<OvalResults> type,
                    final String sourceFilepath,
                    final String xpath,
                    final OvalResults expected,
                    final String resultFilepath
                    )
    throws Exception
    {
        _testXml( type, sourceFilepath, xpath, expected, resultFilepath );
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
                            "test/data/results/directives_01.xml",
                            "/oval_results/directives",
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
                    final Class<Directives> type,
                    final String filepath,
                    final String xpath,
                    final Directives expected
                    )
    throws Exception
    {
        Directives  actual =
            _readObjectFromXmlFile( type, filepath, xpath, expected );

        _writeObjectToXmlFile( actual, null );
    }

}
// OvalXmlTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */
