package jp.go.aist.six.test.oval.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import jp.go.aist.six.oval.core.OvalContext;
import jp.go.aist.six.util.xml.XmlMapper;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class CoreTestBase
{

    private OvalContext  _context = null;

    private XmlMapper  _xml = null;
//    private DataStore  _store = null;



    /**
     */
    public CoreTestBase()
    {
    }



    /**
     */
    @BeforeClass( alwaysRun=true )
    public void setUp()
    throws Exception
    {
        _context = new OvalContext();
    }


    protected OvalContext _getContext()
    throws Exception
    {
        return _context;
    }


    protected XmlMapper _getXml()
    throws Exception
    {
        if (_xml == null) {
            _xml = _context.getXml();
        }

        return _xml;
    }


//    protected DataStore _getStore()
//    throws Exception
//    {
//        if (_store == null) {
//            _store = _context.getStore();
//        }
//
//        return _store;
//    }



    /**
     */
    protected <T> T _unmarshalWithValidation(
                    final Class<T> type,
                    final String filepath,
//                    final String xpath,
                    final T expected
                    )
    throws Exception
    {
        Reporter.log( "  * type: " + type, true );
        Reporter.log( "  * XML file: " + filepath, true );

        File  file = new File( filepath );
        Reporter.log( "unmarshalling XML...", true );
        long  time = System.currentTimeMillis();
        Object  obj = _getXml().unmarshal( new FileInputStream( file ) );
        Reporter.log( "...unmarshalling done: " + (System.currentTimeMillis() - time) + "(ms)", true );

        Reporter.log( "  @ unmarshalled object: " + obj, true );
        Assert.assertTrue( type.isInstance( obj ) );

        T  actual = type.cast( obj );

        /* validation */
//        if (expected != null) {
//            Reporter.log( "validating...", true );
//            Validators5.validator( type ).equals( actual, expected );
//            Reporter.log( "...validation OK", true );
//        }

        return actual;
    }



    /**
     */
    protected void _marshal(
                    final Object object,
                    final String filepath
                    )
    throws Exception
    {
        OutputStream  output = null;
        if (filepath == null) {
            output = System.out;
        } else {
            Reporter.log( "  * result XML file: " + filepath, true );
            output = new FileOutputStream( new File( filepath ) );
        }

        Reporter.log( "marshalling...", true );
        long  time = System.currentTimeMillis();
        _getXml().marshal( object, output );
        Reporter.log( "...marshalling done: " + (System.currentTimeMillis() - time) + "(ms)", true );
    }






    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //
    //  Test Suites
    //
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    //**************************************************************
    //  OVAL definitions
    //**************************************************************

    @DataProvider( name="oval.definitions.xml" )
    public Object[][] provideOvalDefinitionsXml()
    {
        return new Object[][] {
//                        // obj:222, windows, file
//                        {
//                            jp.go.aist.six.oval.model.v5.windows.FileObject.class,
//                            "test/resources/data/oval-definitions-5/obj222_windows_file_oval5.9.xml",
//                            null,
//                            "marshalled_obj222_windows_file_oval5.9.xml"
//                        }
//                      ,

                        // def:7432, Debian, patch, DSA-2027
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            "test/resources/data/oval-definitions-5/oval-5.9_def7432_patch_debian.xml",
                            null,
                            "marshalled_oval-5.9_def7432_patch_debian.xml"
                        }
//                        ,
//
//                        // def:7222, windows, vulnerability, CVE-2010-0176
//                        {
//                            jp.go.aist.six.oval.model.v5.definitions.OvalDefinitions.class,
//                            "test/resources/data/oval-definitions-5/oval_vulnerability_windows_def7222_definitions-5.xml",
//                            null,
//                            "marshalled_oval_vulnerability_windows_def7222_definitions-5.xml"
//                        }
//                        ,
//
//                        // def:*, windows server 2008, vulnerability
//                        {
//                            jp.go.aist.six.oval.model.v5.definitions.OvalDefinitions.class,
//                            "test/resources/data/oval-definitions-5/oval_vulnerability_windows.server.2008_definitions-5.9.xml",
//                            null,
//                            "marshalled_oval_vulnerability_windows.server.2008_definitions-5.9.xml"
//                        }
//                        ,
//
//                        // def:*, Windows 7, vulnerability
//                        {
//                            jp.go.aist.six.oval.model.v5.definitions.OvalDefinitions.class,
//                            "test/resources/data/oval-definitions-5/oval_vulnerability_windows.7_definitions-5.9.xml",
//                            null,
//                            "marshalled_oval_vulnerability_windows.7_definitions-5.9.xml"
//                        }
//                        ,
//
//                        // def:*, Windows XP, vulnerability
//                        {
//                            jp.go.aist.six.oval.model.v5.definitions.OvalDefinitions.class,
//                            "test/resources/data/oval-definitions-5/oval_vulnerability_windows.xp_definitions-5.9.xml",
//                            null,
//                            "marshalled_oval_vulnerability_windows.xp_definitions-5.9.xml"
//                        }
//                        ,
//
//                        // def:*, Debian, patch
//                        {
//                            jp.go.aist.six.oval.model.v5.definitions.OvalDefinitions.class,
//                            "test/resources/data/oval-definitions-5/20110308_oval-patch_debian.gnu.linux.5.0.xml",
//                            null,
//                            "marshalled_20110308_oval-patch_debian.gnu.linux.5.0.xml"
//                        }
//                        ,
//
//                        // Red Hat Enterprise Linux @ Red Hat, all , 2010-08-26
//                        {
//                            jp.go.aist.six.oval.model.v5.definitions.OvalDefinitions.class,
//                            "test/resources/data/oval-definitions-5/20110308_oval-vulnerability_red.hat.enterprise.linux.5.xml",
//                            null,
//                            "marshalled_20110308_oval-vulnerability_red.hat.enterprise.linux.5.xml"
//                        }



                        // family-basis //

//                        // Windows, inventory
//                        {
//                            jp.go.aist.six.oval.model.v5.definitions.OvalDefinitions.class,
//                            "test/data/oval-definitions-5/20110320_oval-definitions_inventory_windows.xml",
//                            "/oval_definitions",
//                            null,
//                            "marshalled_20110320_oval-definitions_inventory_windows.xml"
//                        }
//                        ,
//                        // Debian patch
//                        {
//                            jp.go.aist.six.oval.model.v5.definitions.OvalDefinitions.class,
//                            "test/data/oval-definitions-5/20110308_oval-patch_debian.gnu.linux.5.0.xml",
//                            "/oval_definitions",
//                            null,
//                            "marshalled_20110308_oval-patch_debian.gnu.linux.5.0.xml"
//                        }
//                        ,
//                        // Red Hat EL 5, vulnerability
//                        {
//                            jp.go.aist.six.oval.model.v5.definitions.OvalDefinitions.class,
//                            "test/data/oval-definitions-5/20110308_oval-vulnerability_red.hat.enterprise.linux.5.xml",
//                            "/oval_definitions",
//                            null,
//                            "marshalled_20110308_oval-vulnerability_red.hat.enterprise.linux.5.xml"
//                        }
//                        ,
//
//                      // windows, vulnerability, def:6113, definition/@deprecated
//                      {
//                          jp.go.aist.six.oval.model.v5.definitions.OvalDefinitions.class,
//                          "test/resources/data/oval-definitions-5/oval_vulnerability_windows_def6113_deprecated_definitions-5.9.xml",
//                          "/oval_definitions",
//                          null,
//                          "marshalled_oval_vulnerability_windows_def6113_deprecated_definitions-5.9.xml"
//                      }
//                      ,
//                      // windows, vulnerability, def:11757, textfilecontent54_object/behaviors/@multiline
//                      {
//                          jp.go.aist.six.oval.model.v5.definitions.OvalDefinitions.class,
//                          "test/data/oval-definitions-5/oval_vulnerability_windows_def11757_definitions-5.9.xml",
//                          "/oval_definitions",
//                          null,
//                          "marshalled_oval_vulnerability_windows_def11757_definitions-5.9.xml"
//                      }
//                        // windows, vulnerability, def:7120, CVE-2010-0820
//                        {
//                            jp.go.aist.six.oval.model.v5.definitions.OvalDefinitions.class,
//                            "test/resources/data/oval-definitions-5/oval_vulnerability_windows_def7120_definitions-5.xml",
//                            "/oval_definitions",
//                            null,
//                            "marshalled_oval_vulnerability_windows_def7120_definitions-5.xml"
//                        }
//                      ,
//                        ,
//                        // debian, patch, def:7432, CVE-2010-0176, DSA-2027
//                        {
//                            jp.go.aist.six.oval.model.v5.definitions.OvalDefinitions.class,
//                            "test/data/oval-definitions-5/oval_patch_debian_def7432_definitions-5.xml",
//                            "/oval_definitions",
//                            null,
//                            "marshalled_oval_patch_debian_def7432_definitions-5.xml"
//                        }
//                        ,
//                        // windows, CVE-2003-0353, def:962, deprecated
//                        {
//                            jp.go.aist.six.oval.model.v5.definitions.OvalDefinitions.class,
//                            "test/data/oval-definitions-5/oval-definitions_CVE-2003-0353_def962_deprecated.xml",
//                            "/oval_definitions",
//                            null,
//                            "marshalled_oval-definitions_CVE-2003-0353_def962_deprecated.xml"
//                        }
//                        ,
//                        // windows, CVE-2004-1153, def:2919, notes
//                        {
//                            jp.go.aist.six.oval.model.v5.definitions.OvalDefinitions.class,
//                            "test/data/oval-definitions-5/oval-definitions_CVE-2004-1153_def2919_notes.xml",
//                            "/oval_definitions",
//                            null,
//                            "marshalled_oval-definitions_CVE-2004-1153_def2919_notes.xml"
//                        }
//                        ,
//                        // windows, CVE-2004-0380, def:990, negate
//                        {
//                            jp.go.aist.six.oval.model.v5.definitions.OvalDefinitions.class,
//                            "test/data/oval-definitions-5/oval-definitions_CVE-2004-0380_def990_negate.xml",
//                            "/oval_definitions",
//                            null,
//                            "marshalled_oval-definitions_CVE-2004-0380_def990_negate.xml"
//                        }
//                        // Windows XP, CVE-2010-0035, PowerPoint
//                        {
//                            OvalDefinitions.class,
//                            "test/data/definitions/oval-definitions-5.8_windows-xp_8050.xml",
//                            "/oval_definitions",
//                            DefinitionsSample.OVAL_DEFINITIONS_8050,
//                            "marshalled_oval-definitions-5.8_windows-xp_8050.xml"
//                        }
//                        ,
//                        // Red Hat, CVE-2010-0176, RHSA 20100332
//                        {
//                            OvalDefinitions.class,
//                            "test/data/definitions/oval-definitions_rhsa-20100332_CVE-2010-0176.xml",
//                            "/oval_definitions",
//                            null,
//                            "marshalled_oval-definitions_rhsa-20100332_CVE-2010-0176.xml"
//                        }
//                      ,
//                        // Debian @Mitre, CVE-2010-0176, DSA-2027
//                        {
//                            OvalDefinitions.class,
//                            "test/data/definitions/oval-definitions_oval-7432_CVE-2010-0176_DSA-2027.xml",
//                            "/oval_definitions",
//                            null,
//                            "marshalled_oval-definitions_oval-7432_CVE-2010-0176_DSA-2027.xml"
//                        }
//                      ,
//                        // Windows @ Mitre, CVE-2009-4019, MySQL
//                        {
//                            OvalDefinitions.class,
//                            "test/data/definitions/oval-definitions_oval-8500_CVE-2009-4019_MySQL.xml",
//                            "/oval_definitions",
//                            null,
//                            "marshalled_oval-definitions_oval-8500_CVE-2009-4019_MySQL.xml"
//                        }
//                        ,
//                        // Debian 5.0 @ Mitre, all patches, 2010-10-12
//                        {
//                            OvalDefinitions.class,
//                            "test/data/definitions/20101012_patch_debian.gnu.linux.5.0.xml",
//                            "/oval_definitions",
//                            null,
//                            "marshalled_20101012_patch_debian.gnu.linux.5.0.xml"
//                        }
//                        ,
//                        // Debian 5.0 @ Mitre, all patches, 2010-10-12
//                        {
//                            OvalDefinitions.class,
//                            "test/data/definitions/20101012_inventory_debian.gnu.linux.5.0.xml",
//                            "/oval_definitions",
//                            null,
//                            "marshalled_20101012_inventory_debian.gnu.linux.5.0.xml"
//                        }
//                      ,
//                        // Windows Server 2008 @ Mitre, all the vulnerabilities
//                        {
//                            OvalDefinitions.class,
//                            "test/data/definitions/20101012_vulnerability_microsoft.windows.server.2008.xml",
//                            "/oval_definitions",
//                            null,
//                            "marshalled_20101012_vulnerability_microsoft.windows.server.2008.xml"
//                        }
//                        ,
//                        // Windows Server 2008 @ Mitre, all the vulnerabilities
//                        {
//                            OvalDefinitions.class,
//                            "test/data/definitions/20101012_inventory_microsoft.windows.server.2008.xml",
//                            "/oval_definitions",
//                            null,
//                            "marshalled_20101012_inventory_microsoft.windows.server.2008.xml"
//                        }
//                        ,

//                        // Windows XP @ Mitre, all the vulnerabilities
//                        {
//                            OvalDefinitions.class,
//                            "test/data/definitions/20110209_oval-vulnerability_microsoft.windows.xp.xml",
//                            "/oval_definitions",
//                            null,
//                            "marshalled_20101012_vulnerability_microsoft.windows.xp.xml"
//                        }

//                        ,
//                        // Windows XP @ Mitre, inventory
//                        {
//                            OvalDefinitions.class,
//                            "test/data/definitions/20101012_inventory_microsoft.windows.xp.xml",
//                            "/oval_definitions",
//                            null,
//                            "marshalled_20101012_inventory_microsoft.windows.xp.xml"
//                        }
//                      ,
//
//
//
//                        // Red Hat Enterprise Linux 5.0 @ Mitre, all vulnerabilities, 2010-08-30
//                        {
//                            OvalDefinitions.class,
//                            "test/data/definitions/20100830_vulnerability_red.hat.enterprise.linux.5.xml",
//                            "/oval_definitions",
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




    //**************************************************************
    //  OVAL system characteristics
    //**************************************************************



    //**************************************************************
    //  OVAL results
    //**************************************************************

    @DataProvider( name="oval.results.xml" )
    public Object[][] provideOvalResultsXml()
    {
        return new Object[][] {
//                        // def:7120, Windows XP, vulnerability
//                        // wmi, file, registry, family
//                        {
//                            jp.go.aist.six.oval.model.v5.results.OvalResults.class,
//                            "test/resources/data/oval-results-5/oval_windows_vulnerability_def7120_results5.9.xml",
//                            null,
//                            "marshalled_oval_windows_vulnerability_def7120_results5.9.xml"
//                        }
//                        ,

                        // def:7432, Debian, patch
                        // textfilecontent54, dpkginfo, uname
                        {
                            jp.go.aist.six.oval.model.v5.results.OvalResults.class,
                            "test/resources/data/oval-results-5/oval-5.9_def7432_patch_debian_results.xml",
                            null,
                            "marshalled_oval-5.9_def7432_patch_debian_results.xml"
                        }
//                        ,
//
//                        // def:7222, Windows XP, vulnerability
//                        {
//                            jp.go.aist.six.oval.model.v5.results.OvalResults.class,
//                            "test/resources/data/oval-results-5/oval-results_CVE-2010-0176_def7222_v5.9.xml",
//                            null,
//                            "marshalled_oval-results_CVE-2010-0176_def7222_v5.9.xml"
//                        }
        };
    }

}
// CoreTestBase
