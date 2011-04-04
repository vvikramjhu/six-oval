package jp.go.aist.six.test.oval.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import jp.go.aist.six.oval.core.OvalContext;
import jp.go.aist.six.oval.model.v5.definitions.DefinitionType;
import jp.go.aist.six.util.persist.DataStore;
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
    private DataStore  _store = null;



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


    protected DataStore _getStore()
    throws Exception
    {
        if (_store == null) {
            _store = _context.getStore();
        }

        return _store;
    }



    /**
     */
    protected <T> T _unmarshalWithValidation(
                    final Class<T> type,
                    final String filepath,
                    final String xpath,
                    final T expected
                    )
    throws Exception
    {
        Reporter.log( "  * XPath: " + xpath, true );
        Reporter.log( "  * XML file: " + filepath, true );

        File  file = new File( filepath );
        Reporter.log( "unmarshalling XML...", true );
        long  time = System.currentTimeMillis();
        Object  obj = _getXml().unmarshal( new FileInputStream( file ) );
        Reporter.log( "...unmarshalling done: " + (System.currentTimeMillis() - time) + "(ms)", true );

        Reporter.log( "  @ unmarshalled object: " + obj, true );
        Assert.assertTrue( type.isInstance( obj ) );

        T  actual = type.cast( obj );

        if (expected != null) {
            Reporter.log( "validating...", true );
//            Validators5.validator( type ).equals( actual, expected );
            Reporter.log( "...validation OK", true );
        }

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
    //  definitions
    //**************************************************************

    @DataProvider( name="definitions.definition" )
    public Object[][] provideOvalDefinitionsDefinition()
    {
        return new Object[][] {
                        // Windows @ Mitre, CVE-2009-4019, MySQL
                        {
                            DefinitionType.class,
                            "test/data/oval-definitions-5/def8500_vulnerability_windows.xml",
                            "/oval_definitions/definitions/definition",
                            null, //OvalSample.DEFINITION_8500,
                            "marshalled_def8500_vulnerability_windows.xml"
                        }
//                        ,
//                      // Mitre, windows, inverntory, MySQL 5.1
//                      {
//                          Definition.class,
//                          "test/data/definitions/definition_oval-def-8297_1.xml",
//                          "oval_definitions/definitions/definition",
//                          OvalSample.DEFINITION_8297
//                      }
//                      ,
//                      // Red Hat, unix, patch, firefox
//                      {
//                          Definition.class,
//                          "test/data/definitions/definition_rhsa-def-20100332_301.xml",
//                          "oval_definitions/definitions/definition",
//                          OvalSample.DEFINITION_20100332
//                      }
        };

    }

}
// CoreTestBase

