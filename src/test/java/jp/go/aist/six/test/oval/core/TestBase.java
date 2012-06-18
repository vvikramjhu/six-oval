package jp.go.aist.six.test.oval.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import jp.go.aist.six.oval.core.OvalContext;
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
public abstract class TestBase
{

//    private OvalContext  _context = null;

    private XmlMapper  _xmlMapper = null;
//    private DataStore  _store = null;



    /**
     */
    public TestBase()
    {
    }



    /**
     */
    @BeforeClass( alwaysRun=true )
    public void setUp()
    throws Exception
    {
//        _context = OvalContext.INSTANCE;
        _xmlMapper = OvalContext.getXmlMapper();
    }


//    protected OvalContext _getContext()
//    throws Exception
//    {
//        return _context;
//    }


    protected XmlMapper _getXmlMapper()
    throws Exception
    {
        return _xmlMapper;
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
    protected <T> T _unmarshalObject(
                    final Class<T>  object_type,
                    final String    xml_filepath,
                    final T         expected_object
                    )
    throws Exception
    {
        return _unmarshalObject( object_type, xml_filepath, expected_object, true );
    }



    protected <T> T _unmarshalObject(
                    final Class<T>  object_type,
                    final String    xml_filepath,
                    final T         expected_object,
                    final boolean   need_log
                    )
    throws Exception
    {
        if (need_log) {
            Reporter.log( "unmarshalling XML...", true );
            Reporter.log( "  * object type: " + object_type, true );
            Reporter.log( "  * XML file: " + xml_filepath, true );
        }

        File  file = new File( xml_filepath );
        long  time = System.currentTimeMillis();
        Object  obj = _getXmlMapper().unmarshal( new FileInputStream( file ) );
        if (need_log) {
            Reporter.log( "...unmarshalling done: " + (System.currentTimeMillis() - time) + "(ms)", true );
            Reporter.log( "  @ unmarshalled object: " + obj, true );
        }

        Assert.assertTrue( object_type.isInstance( obj ) );

        T  actual = object_type.cast( obj );

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
    protected void _marshalObject(
                    final Object object,
                    final String filepath
                    )
    throws Exception
    {
        Reporter.log( "marshalling...", true );
        OutputStream  output = null;
        if (filepath == null) {
            output = System.out;
        } else {
            Reporter.log( "  * XML file: " + filepath, true );
            output = new FileOutputStream( new File( filepath ) );
        }

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
    @DataProvider( name="oval.test_content.sc" )
    public Object[][] provideOvalTestContentOvalSc()
    {
        return new Object[][] {
                        {
                            jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics.class,
                            "5.10",
                            Family.WINDOWS,
                            "test/resources/OvalTestContent/5.10/win-sc",
                            null,
                            null
                        }
        };
    }



    /**
     * Provides OVAL test content.
     *  Class<T>            object_type,
     *  String              oval_schema_version,
     *  OvalPlatformType    platform,
     *  String              dirpath,
     *  String              filename
     *  T                   expectedObject
     */
    @DataProvider( name="oval.test_content.def" )
    public Object[][] provideOvalTestContentOvalDefinitions()
    {
        return new Object[][] {
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            "5.10",
//                            OvalPlatformType.windows,
//                            "test/resources/OvalTestContent/5.10",
//                            "20120301_v_microsoft.windows.7.xml",
//                            null
//                        }
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            "5.10",
                            Family.UNIX,
                            "test/resources/OvalTestContent/5.10",
                            "oval_def-7222_CVE-2010-0176.xml",
                            null
                        }
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            "5.10.1",
//                            OvalPlatformType.unix,
//                            "test/resources/OvalTestContent/5.10.1",
//                            "oval_def-8987-1_i.xml",
//                            null
//                        }
//                        ,
//                        /* Windows */
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            "5.10",
//                            Family.WINDOWS,
//                            "test/resources/OvalTestContent/5.10/windows",
//                            null,
//                            null
//                        }
//                        ,
//                        {
//                            jp.go.aist.six.oval.model.results.OvalResults.class,
//                            "5.10",
//                            OvalPlatformType.windows,
//                            "test/resources/OvalTestContent/5.10/win-res",
//                            null,
//                            null
//                        }
//                        ,
//                        /* linux */
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            "5.10",
//                            Family.LINUX,
//                            "test/resources/OvalTestContent/5.10/linux",
//                            null,
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



    /**
     * Provides OVAL test content.
     *  Class<T>            object_type,
     *  String              oval_schema_version,
     *  Family              family,
     *  String              dirpath,
     *  String              filename
     *  T                   expectedObject
     */
    @DataProvider( name="oval.test_content.res" )
    public Object[][] provideOvalTestContentOvalResutls()
    {
        return new Object[][] {
//                        /* Windows */
//                        {
//                            jp.go.aist.six.oval.model.results.OvalResults.class,
//                            "5.10",
//                            Family.WINDOWS,
//                            "test/resources/OvalTestContent/5.10/win-res",
//                            null,
//                            null
//                        }
//                        ,

                        /* Linux / Debian */
                        {
                            jp.go.aist.six.oval.model.results.OvalResults.class,
                            "5.9",
                            Family.LINUX,
                            "test/resources/OvalTestContent/5.10/linux-res",
                            null,
                            null
                        }
        };

    }


}
//
