package jp.go.aist.six.test.oval.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import jp.go.aist.six.oval.core.OvalContext;
import jp.go.aist.six.oval.model.Component;
import jp.go.aist.six.oval.model.Element;
import jp.go.aist.six.oval.model.ElementContainer;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.common.ClassEnumeration;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.model.definitions.DefinitionsElement;
import jp.go.aist.six.oval.model.definitions.DefinitionsType;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.definitions.StateType;
import jp.go.aist.six.oval.model.definitions.StatesType;
import jp.go.aist.six.oval.model.definitions.SystemObjectType;
import jp.go.aist.six.oval.model.definitions.SystemObjectsType;
import jp.go.aist.six.oval.model.definitions.TestType;
import jp.go.aist.six.oval.model.definitions.TestsType;
import jp.go.aist.six.util.persist.Persistable;
import jp.go.aist.six.util.xml.XmlMapper;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class OvalCoreTests
{

    private OvalContext  _context = null;

    private XmlMapper  _xmlMapper = null;



    /**
     */
    public OvalCoreTests()
    {
    }



    /**
     */
    @BeforeClass( alwaysRun=true )
    public void setUp()
    throws Exception
    {
        _context = OvalContext.INSTANCE;
    }


    protected OvalContext _getContext()
    throws Exception
    {
        return _context;
    }


    protected XmlMapper _getXmlMapper()
    throws Exception
    {
        if (_xmlMapper == null) {
            _xmlMapper = _context.getXmlMapper();
        }

        return _xmlMapper;
    }



    ////////////////////////////////////////////////////////////////
    //  support methods
    ////////////////////////////////////////////////////////////////

    /**
     * Creates a file list from directory path and/or file path.
     */
    protected File[] _toXmlFileList(
                    final String    dirpath,
                    final String    xml_filepath
                    )
    throws Exception
    {
        Reporter.log( ">>> list XML files..." + dirpath, true );
        Reporter.log( "  * dir: " + dirpath, true );
        Reporter.log( "  * filepath: " + xml_filepath, true );

        File[]  list = null;
        if (dirpath == null) {
            list = new File[] { new File( xml_filepath ) };

        } else {
            File  dir = new File( dirpath );

            if (xml_filepath == null) {
                FilenameFilter  filter = new XmlFilenameFilter();
                list = dir.listFiles( filter );
            } else {
                list = new File[] { new File( dir, xml_filepath ) };
            }
        }
        Reporter.log( "<<< ...list XML files" + dirpath, true );
        Reporter.log( "  * files: " + Arrays.toString( list ), true );

        return list;
    }



    /**
     */
    protected <T> T _unmarshalFromFile(
                    final Class<T> type,
                    final String filepath,
//                    final String xpath,
                    final T expected
                    )
    throws Exception
    {
        Reporter.log( ">>> unmarshalling XML...", true );
        Reporter.log( "  * object type: " + type, true );
        Reporter.log( "  * XML file: " + filepath, true );

        File  file = new File( filepath );
        long  time = System.currentTimeMillis();
        Object  obj = _getXmlMapper().unmarshal( new FileInputStream( file ) );
        Reporter.log( "<<< ...unmarshalling done: " + (System.currentTimeMillis() - time) + "(ms)", true );

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
    protected void _marshalToFile(
                    final Object object,
                    final String filepath
                    )
    throws Exception
    {
        OutputStream  output = null;
        if (filepath == null) {
            output = System.out;
        } else {
            Reporter.log( "  * XML file: " + filepath, true );
            output = new FileOutputStream( new File( filepath ) );
        }

        Reporter.log( ">>> marshalling...", true );
        long  time = System.currentTimeMillis();
        _getXmlMapper().marshal( object, output );
        Reporter.log( "<<< ...marshalling done: " + (System.currentTimeMillis() - time) + "(ms)", true );
    }



    protected <K, T extends Persistable<K>>
    void _printObject(
                    final Class<T>  object_type,
                    final T         object
                    )
    throws Exception
    {
        Reporter.log( ">>> dump object...", true );
        Reporter.log( "  * object type: " + object_type, true );

        if (OvalDefinitions.class.isAssignableFrom( object_type )) {
            OvalDefinitions  oval_defs = OvalDefinitions.class.cast( object );
            Reporter.log( "  @ object: " + oval_defs, true );
            DefinitionsType  defs = oval_defs.getDefinitions();
            if (defs != null) {
                for (DefinitionType  def : defs.getDefinition()) {
                    Reporter.log( "  @ definition: " + def.getOvalID(), true );
                }
            }

            TestsType tsts = oval_defs.getTests();
            if (tsts != null) {
                for (TestType  tst : tsts.getTest()) {
                    Reporter.log( "  @ test: " + tst.getOvalID(), true );
                }
            }

            SystemObjectsType  objs = oval_defs.getObjects();
            if (objs != null) {
                for (SystemObjectType  obj : objs.getObject()) {
                    Reporter.log( "  @ object: " + obj.getOvalID(), true );
                }
            }

            StatesType          stes = oval_defs.getStates();
            if (stes != null) {
                for (StateType  ste : stes.getState()) {
                    Reporter.log( "  @ state: " + ste.getOvalID(), true );
                }
            }
        }
    }


    protected <T extends Element>
    void _printOvalIds(
                    final ElementContainer<T> container
                    )
    throws Exception
    {
        if (container == null) {
            Reporter.log( "  #elements: 0", true );
        } else {
            Iterator<T>  i = container.iterator();
            while (i.hasNext()) {
                Reporter.log( "  @ : " + i.next().getOvalID(), true );
            }
            Reporter.log( "  #elements: " + container.size(), true );
        }
    }


    protected <T extends Element>
    void _printOvalIds(
                    final Collection<T> container
                    )
    throws Exception
    {
        if (container == null) {
            Reporter.log( "  #elements: 0", true );
        } else {
            for (Element  e : container) {
                Reporter.log( "  @ : " + e.getOvalID(), true );
            }
            Reporter.log( "  #elements: " + container.size(), true );
        }
    }



    ////////////////////////////////////////////////////////////////
    //  test data
    ////////////////////////////////////////////////////////////////

    //**************************************************************
    //  OVAL Test Content
    //**************************************************************

    /**
     * OVAL Definitions documents contained in the OVAL Test Content.
     *
     *  Class<T>    object_type,
     *  String      schema_version,
     *  Family      family,
     *  String      dirpath,
     *  String      filename
     *  T           expected_object
     */
    @DataProvider( name="oval.test_content.def" )
    public Object[][] provideOvalTestContentDef()
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
                        ,

                        /* linux */
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            "5.10",
                            Family.LINUX,
                            "test/resources/OvalTestContent/5.10/linux",
                            null,
                            null
                        }
        };

    }



    /**
     * Definitions contained in the OVAL Test Content.
     *
     *  Class<T>                object_type,
     *  String                  schema_version,
     *  DefinitionsElement.Type type,
     *  ClassEnumeration        definition_class,
     *  String                  oval_id,
     *  T                       expected_object
     */
    @DataProvider( name="oval.test_content.def.definition" )
    public Object[][] provideOvalTestContentDefDefinition()
    {
        return new Object[][] {
                        /* Windows */
                        {
                            jp.go.aist.six.oval.model.definitions.DefinitionType.class,
                            "5.10",
                            DefinitionsElement.Type.DEFINITION,
                            ClassEnumeration.MISCELLANEOUS,
                            "oval:org.mitre.oval.test:def:140",
                            null
                        }
                        ,

                        /* linux */
                        {
                            jp.go.aist.six.oval.model.definitions.DefinitionType.class,
                            "5.10",
                            DefinitionsElement.Type.DEFINITION,
                            ClassEnumeration.MISCELLANEOUS,
                            "oval:org.mitre.oval.test:def:683",
                            null
                        }
        };

    }



    /**
     * Definition elements contained in the OVAL Test Content.
     *
     *  Class<T>                object_type,
     *  String                  schema_version,
     *  DefinitionsElement.Type type,
     *  Family                  family,
     *  Component               component,
     *  String                  oval_id,
     *  T                       expected_object
     */
    @DataProvider( name="oval.test_content.def.element" )
    public Object[][] provideOvalTestContentDefElement()
    {
        return new Object[][] {
                        /* Windows */
                        {
                            jp.go.aist.six.oval.model.definitions.TestType.class,
                            "5.10",
                            DefinitionsElement.Type.TEST,
                            Family.WINDOWS,
                            Component.FILE,
                            "oval:org.mitre.oval.test:tst:1303",
                            null
                        }
                        ,

                        /* linux */
                        {
                            jp.go.aist.six.oval.model.definitions.TestType.class,
                            "5.10",
                            DefinitionsElement.Type.TEST,
                            Family.LINUX,
                            Component.DPKGINFO,
                            "oval:org.mitre.oval.test:tst:709",
                            null
                        }
        };

    }



    /**
     *  Class<T>    object_type,
     *  String      schema_version,
     *  Family      family,
     *  String      dirpath,
     *  String      filename
     *  T           expected_object
     */
    @DataProvider( name="oval.test_content.sc" )
    public Object[][] provideOvalTestContentSc()
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
     *  Class<T>    object_type,
     *  String      schema_version,
     *  Family      family,
     *  String      dirpath,
     *  String      filename
     *  T           expected_object
     */
    @DataProvider( name="oval.test_content.res" )
    public Object[][] provideOvalTestContentRes()
    {
        return new Object[][] {
                        /* Windows */
                        {
                            jp.go.aist.six.oval.model.results.OvalResults.class,
                            "5.10",
                            Family.WINDOWS,
                            "test/resources/OvalTestContent/5.10/win-res",
                            null,
                            null
                        }
                        ,

                        /* Linux */
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
//OvalCoreTests