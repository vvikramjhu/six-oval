package jp.go.aist.six.test.oval.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import jp.go.aist.six.oval.core.DeprecatedOvalContext;
import jp.go.aist.six.oval.model.Family;
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

//    private OvalContext  _context = null;

    private XmlMapper  _xmlMapper = null;



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
//        _context = OvalContext.INSTANCE;
    }


//    protected OvalContext _getContext()
//    throws Exception
//    {
//        return _context;
//    }


    protected XmlMapper _getXmlMapper()
    throws Exception
    {
        if (_xmlMapper == null) {
            _xmlMapper = DeprecatedOvalContext.getXmlMapper();
        }

        return _xmlMapper;
    }



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
        Object  obj = _getXmlMapper().unmarshal( new FileInputStream( file ) );
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
        _getXmlMapper().marshal( object, output );
        Reporter.log( "...marshalling done: " + (System.currentTimeMillis() - time) + "(ms)", true );
    }






    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //
    //  Test Suites
    //
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    //**************************************************************
    //  OVAL Test Content
    //**************************************************************

    /**
     * Provides OVAL test content.
     *  Class<T>            object_type,
     *  String              oval_schema_version,
     *  OvalPlatformType    platform,
     *  String              dirpath,
     *  String              filename
     *  T                   expectedObject
     */
    @DataProvider( name="oval.test_content" )
    public Object[][] provideOvalTestContent()
    {
        return new Object[][] {
                        /* Windows */
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            "5.10",
                            Family.WINDOWS,
                            "test/resources/OvalTestContent/5.10/windows",
                            null,
                            null
                        }
//                        ,
//                        /* linux */
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            "5.10",
//                            OvalPlatformType.linux,
//                            "test/resources/OvalTestContent/5.10/linux",
//                        null,
//                            null
//                        }
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            "5.10",
//                            OvalPlatformType.windows,
//                            "test/resources/OvalTestContent/5.10/windows",
//                            "ind-def_family_test.xml"
//                            null
//                        }
        };

    }




    //**************************************************************
    //  OVAL definitions
    //**************************************************************

    @DataProvider( name="oval.definitions.xml" )
    public Object[][] provideOvalDefinitionsXml()
    {
        return new Object[][] {

                        // XSLT transformed
//                        // def:7222, windows, vulnerability, CVE-2010-0176
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            "transformed_oval5.9_def12313-5_v_windows_CVE-2011-0031.xml",
//                            null,
//                            "marshalled_oval5.9_def12313-5_v_windows_CVE-2011-0031.xml"
//                        }
//                        ,

//                        /*** inventory ***/
//
//                        // def, inventory, Debian 5.0, all
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            "test/resources/data/oval5/2011-09-26_i_debian.gnu.linux.5.0.xml",
//                            null,
//                            "marshalled_2011-09-26_i_debian.gnu.linux.5.0.xml"
//                        }
//                        ,
//
//                        // def, inventory, Debian 6.0, all
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            "test/resources/data/oval5/2011-09-26_i_debian.gnu.linux.6.0.xml",
//                            null,
//                            "marshalled_2011-09-26_i_debian.gnu.linux.6.0.xml"
//                        }
//                        ,
//
//                        // def, inventory, Windows 7, all
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            "test/resources/data/oval5/2011-09-26_i_microsoft.windows.7.xml",
//                            null,
//                            "marshalled_2011-09-26_i_microsoft.windows.7.xml"
//                        }
//                        ,
//
//                        // def, inventory, Windows Server 2008, all
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            "test/resources/data/oval5/2011-09-26_i_microsoft.windows.server.2008.xml",
//                            null,
//                            "marshalled_2011-09-26_i_microsoft.windows.server.2008.xml"
//                        }
//                        ,
//
//                        // def, inventory, Windows XP, all
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            "test/resources/data/oval5/2011-09-26_i_microsoft.windows.xp.xml",
//                            null,
//                            "marshalled_2011-09-26_i_microsoft.windows.xp.xml"
//                        }
//                        ,
//
//                        // def, inventory, Red Hat Enterprise Linux 5, all
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            "test/resources/data/oval5/2011-09-26_i_red.hat.enterprise.linux.5.xml",
//                            null,
//                            "marshalled_2011-09-26_i_red.hat.enterprise.linux.5.xml"
//                        }
//                        ,


//                        /*** patch ***/
//
//                        // def, patch, Debian 5.0, all
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            "test/resources/data/oval5/2011-09-26_p_debian.gnu.linux.5.0.xml",
//                            null,
//                            "marshalled_2011-09-26_p_debian.gnu.linux.5.0.xml"
//                        }
//                        ,


//                        /*** vulnerability ***/
//
//                      // def, vulnerability, Windows 7, all
//                      {
//                          jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                          "test/resources/data/oval5/2011-09-26_v_microsoft.windows.7.xml",
//                          null,
//                          "marshalled_2011-09-26_v_microsoft.windows.7.xml"
//                      }
//                      ,
//
//                      // def, vulnerability, Windows Server 2008, all
//                      {
//                          jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                          "test/resources/data/oval5/2011-09-26_v_microsoft.windows.server.2008.xml",
//                          null,
//                          "marshalled_2011-09-26_v_microsoft.windows.server.2008.xml"
//                      }
//                      ,
//
//                      // def, vulnerability, Windows XP, all
//                      {
//                          jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                          "test/resources/data/oval5/2011-09-26_v_microsoft.windows.xp.xml",
//                          null,
//                          "marshalled_2011-09-26_v_microsoft.windows.xp.xml"
//                      }
//                      ,
//
//                      // def, vulnerability, Red Hat Enterprise Linux 5, all
//                      {
//                          jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                          "test/resources/data/oval5/2011-09-26_v_red.hat.enterprise.linux.5.xml",
//                          null,
//                          "marshalled_2011-09-26_v_red.hat.enterprise.linux.5.xml"
//                      }

                        // def, vulnerability, Red Hat Enterprise Linux 4, all
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            "test/resources/data/oval5/oval5.10_def1073-3_v_rhel4_CVE-2005-2267.xml",
                            null,
                            "marshalled_oval5.10_def1073-3_v_rhel4_CVE-2005-2267.xml"
                        }


//                        /***  ***/
//
//                        // def:7222, windows, vulnerability, CVE-2010-0176
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            "test/resources/data/oval5/oval5.9_def7222-5_v_windows_CVE-2010-0176.xml",
//                            null,
//                            "marshalled_oval5.9_def7222-5_v_windows_CVE-2010-0176.xml"
//                        }
//                        ,
//
//                        // def:7222, windows, vulnerability, CVE-2010-0176
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            "test/resources/data/oval5/oval5.10_def7222-5_v_windows_CVE-2010-0176.xml",
//                            null,
//                            "marshalled_oval5.10_def7222-5_v_windows_CVE-2010-0176.xml"
//                        }
//                        ,
//
//                        // debian, patch, def:7432 / OVAL 5.7, CVE-2010-0176, DSA-2027
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            "test/resources/data/oval5/oval5.7_def7432-3_p_debian5_DSA-2027.xml",
//                            null,
//                            "marshalled_oval5.7_def7432-3_p_debian5_DSA2027.xml"
//                        }
//                        ,
//                        // debian, patch, def:7432 / OVAL 5.9, CVE-2010-0176, DSA-2027
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            "test/resources/data/oval5/oval5.9_def7432-3_p_debian5_DSA-2027.xml",
//                            null,
//                            "marshalled_oval5.9_def7432-3_p_debian5_DSA2027.xml"
//                        }
//                        ,


                        /** Red Hat Errata System **/

//                        // OVAL5.3, def:20100332-301, patch, Red Hat Enterprise Linux
//                        // rpminfo
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            "test/resources/data/oval5/oval5.3_def20100332-301_p_rhel5_RHSA-2010-0332_CVE-2010-0176.xml",
//                            null,
//                            "marshalled_oval5.3_def20100332-301_p_rhel5_RHSA-2010-0332_CVE-2010-0176.xml"
//                        }
//                        ,

//                        // OVAL5.3, RHSA-2003, patch, Red Hat Enterprise Linux
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            "test/resources/data/oval5/com.redhat.rhsa-2003.xml",
//                            null,
//                            "marshalled_com.redhat.rhsa-2003.xml"
//                        }
//                        ,
//                        // OVAL5.3, RHSA-2004, patch, Red Hat Enterprise Linux
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            "test/resources/data/oval5/com.redhat.rhsa-2004.xml",
//                            null,
//                            "marshalled_com.redhat.rhsa-2004.xml"
//                        }
//                        ,
//                        // OVAL5.3, RHSA-2005, patch, Red Hat Enterprise Linux
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            "test/resources/data/oval5/com.redhat.rhsa-2005.xml",
//                            null,
//                            "marshalled_com.redhat.rhsa-2005.xml"
//                        }
//                        ,
//                        // OVAL5.3, RHSA-2006, patch, Red Hat Enterprise Linux
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            "test/resources/data/oval5/com.redhat.rhsa-2006.xml",
//                            null,
//                            "marshalled_com.redhat.rhsa-2006.xml"
//                        }
//                        ,
//                        // OVAL5.3, RHSA-2007, patch, Red Hat Enterprise Linux
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            "test/resources/data/oval5/com.redhat.rhsa-2007.xml",
//                            null,
//                            "marshalled_com.redhat.rhsa-2007.xml"
//                        }
//                        ,
//                        // OVAL5.3, RHSA-2008, patch, Red Hat Enterprise Linux
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            "test/resources/data/oval5/com.redhat.rhsa-2008.xml",
//                            null,
//                            "marshalled_com.redhat.rhsa-2008.xml"
//                        }
//                        ,
//                        // OVAL5.3, RHSA-2009, patch, Red Hat Enterprise Linux
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            "test/resources/data/oval5/com.redhat.rhsa-2009.xml",
//                            null,
//                            "marshalled_com.redhat.rhsa-2009.xml"
//                        }
//                        ,
//                        // OVAL5.3, RHSA-2010, patch, Red Hat Enterprise Linux
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            "test/resources/data/oval5/com.redhat.rhsa-2010.xml",
//                            null,
//                            "marshalled_com.redhat.rhsa-2010.xml"
//                        }
//                        ,
//                        // OVAL5.3, RHSA-2011, patch, Red Hat Enterprise Linux
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            "test/resources/data/oval5/com.redhat.rhsa-2011.xml",
//                            null,
//                            "marshalled_com.redhat.rhsa-2011.xml"
//                        }


//                        // def, Windows 7, vulnerability, all
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            "test/resources/data/oval5/oval-5.10_v_windows.7.xml",
//                            null,
//                            "marshalled_oval-5.10_v_windows.7.xml"
//                        }
//                        ,
//
//                        // def, Windows 7, inventory, all
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            "test/resources/data/oval5/oval-5.10_i_windows.7.xml",
//                            null,
//                            "marshalled_oval-5.10_i_windows.7.xml"
//                        }
//                        ,
//                        // obj:222, windows, file
//                        {
//                            jp.go.aist.six.oval.model.v5.windows.FileObject.class,
//                            "test/resources/data/oval-definitions-5/obj222_windows_file_oval5.9.xml",
//                            null,
//                            "marshalled_obj222_windows_file_oval5.9.xml"
//                        }
//                      ,
//
//                        // def:7432, Debian, patch, DSA-2027
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            "test/resources/data/oval-definitions-5/oval-5.9_def7432_patch_debian.xml",
//                            null,
//                            "marshalled_oval-5.9_def7432_patch_debian.xml"
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
    public Object[][] provideOvalXml()
    {
        return new Object[][] {
                        // OVAL 5.7, def:7432-3, patch, Debian 5
                        // textfilecontent, dpkginfo, uname
                        {
                            jp.go.aist.six.oval.model.results.OvalResults.class,
                            "test/resources/data/oval5/oval5.7_def7432-3_p_debian5_DSA-2027_results.xml",
                            null,
                            "marshalled_oval5.7_def7432-3_p_debian5_DSA-2027_results.xml"
                        }
                        ,

                        // OVAL 5.9, def:7432-3, patch, Debian 5
                        // textfilecontent54, dpkginfo, uname
                        {
                            jp.go.aist.six.oval.model.results.OvalResults.class,
                            "test/resources/data/oval5/oval5.9_def7432-3_p_debian5_DSA-2027_results.xml",
                            null,
                            "marshalled_oval5.9_def7432-3_p_debian5_DSA-2027_results.xml"
                        }
                        ,

                        // OVAL5.9, def:7222-5, vulnerability, Windows
                        // registry
                        {
                            jp.go.aist.six.oval.model.results.OvalResults.class,
                            "test/resources/data/oval5/oval5.9_def7222-5_v_windows_CVE-2010-0176_results.xml",
                            null,
                            "marshalled_oval5.9_def7222-5_v_windows_CVE-2010-0176_results.xml"
                        }
                        ,

                        // OVAL5.10, def:7222-5, vulnerability, Windows
                        // registry
                        {
                            jp.go.aist.six.oval.model.results.OvalResults.class,
                            "test/resources/data/oval5/oval5.10_def7222-5_v_windows_CVE-2010-0176_results.xml",
                            null,
                            "marshalled_oval5.10_def7222-5_v_windows_CVE-2010-0176_results.xml"
                        }
                        ,

                        // OVAL5.9, def:12313-5, vulnerability, Windows
                        // file, family, registry
                        {
                            jp.go.aist.six.oval.model.results.OvalResults.class,
                            "test/resources/data/oval5/oval5.9_def12313-5_v_windows_CVE-2011-0031_results.xml",
                            null,
                            "marshalled_oval5.9_def12313-5_v_windows_CVE-2011-0031_results.xml"
                        }
                        ,

                        // OVAL5.3, def:20100332-301, patch, Red Hat Enterprise Linux
                        // rpminfo
                        {
                            jp.go.aist.six.oval.model.results.OvalResults.class,
                            "test/resources/data/oval5/oval5.3_def20100332-301_p_rhel5_RHSA-2010-0332_CVE-2010-0176_results.xml",
                            null,
                            "marshalled_oval5.3_def20100332-301_p_rhel5_RHSA-2010-0332_CVE-2010-0176_results.xml"
                        }
        };
    }

}
// CoreTestBase
