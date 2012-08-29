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
import jp.go.aist.six.oval.core.model.EntityUtil;
import jp.go.aist.six.oval.model.ComponentType;
import jp.go.aist.six.oval.model.Element;
import jp.go.aist.six.oval.model.ElementContainer;
import jp.go.aist.six.oval.model.ElementType;
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
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
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
public abstract class OvalCoreTestBase
{

//    private OvalContext  _context = null;

    private XmlMapper  _xmlMapper = null;



    /**
     */
    public OvalCoreTestBase()
    {
    }



    /**
     */
    @BeforeClass( alwaysRun=true )
    public void setUp()
    throws Exception
    {
    }


    protected XmlMapper _getXmlMapper()
    throws Exception
    {
        if (_xmlMapper == null) {
            _xmlMapper = OvalContext.getInstance().getXmlMapper();
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


    /**
     */
    protected String _marshalToString(
                    final Object object
                    )
    throws Exception
    {
        Reporter.log( ">>> marshalling...", true );
        long  time = System.currentTimeMillis();
        String  xml = _getXmlMapper().marshalToString( object );
        Reporter.log( "<<< ...marshalling done: " + (System.currentTimeMillis() - time) + "(ms)", true );

        return xml;
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
                    Reporter.log( "  @ definition: " + def.getOvalId(), true );
                }
            }

            TestsType tsts = oval_defs.getTests();
            if (tsts != null) {
                for (TestType  tst : tsts.getTest()) {
                    Reporter.log( "  @ test: " + tst.getOvalId(), true );
                }
            }

            SystemObjectsType  objs = oval_defs.getObjects();
            if (objs != null) {
                for (SystemObjectType  obj : objs.getObject()) {
                    Reporter.log( "  @ object: " + obj.getOvalId(), true );
                }
            }

            StatesType          stes = oval_defs.getStates();
            if (stes != null) {
                for (StateType  ste : stes.getState()) {
                    Reporter.log( "  @ state: " + ste.getOvalId(), true );
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
                Element  e = i.next();
                Reporter.log( "  @ : " + e.getOvalId(), true );
                if (DefinitionsElement.class.isInstance( e )) {
                    DefinitionsElement  de = DefinitionsElement.class.cast( e );
                    _print( de );
                }
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
                Reporter.log( "  @ : " + e.getOvalId(), true );
            }
            Reporter.log( "  #elements: " + container.size(), true );
        }
    }



    protected void _print(
                    final DefinitionsElement element
                    )
    throws Exception
    {
        Collection<String>  ref_ids = EntityUtil.getElementRefId( element );
//        Reporter.log( "    ID: " + element.getOvalID(), true );
        Reporter.log( "    ref IDs: " + ref_ids.toString(), true );
    }



    ////////////////////////////////////////////////////////////////
    //  test data
    ////////////////////////////////////////////////////////////////

    /**
     * OVAL Definitions XML documents.
     *
     * Test method params:
     *   OvalContentCategory    category,
     *   String                 schema_version,
     *   Class<T>               object_type,
     *   Family                 family,
     *   String                 dirpath,
     *   String                 xml_filepath
     *   T                      expected_object
     */
    @DataProvider( name="DATA.oval.def.oval_definitions" )
    public Object[][] provideOvalDefOvalDefinitions()
    {
        return new Object[][] {
// OVAL test content //
                        // linux //
                        {
                            OvalContentCategory.OVAL_TEST_CONTENT,
                            "5.9",
                            OvalDefinitions.class,
                            Family.LINUX,
                            "test/resources/oval_test-content/oval-5.9/def/linux",
                            null,
                            null
                        }
                        ,
                        // Windows //
                        {
                            OvalContentCategory.OVAL_TEST_CONTENT,
                            "5.9",
                            OvalDefinitions.class,
                            Family.WINDOWS,
                            "test/resources/oval_test-content/oval-5.9/def/windows",
                            null,
                            null
                        }
//mitre repository//
                        ,
                        // linux //
                        {
                            OvalContentCategory.MITRE_REPOSITORY,
                            "5.10.1",
                            OvalDefinitions.class,
                            Family.LINUX,
                            "test/resources/mitre_repository/oval-5.10/def/linux",
                            null,
                            null
                        }
                        ,
                        // windows //
                        {
                            OvalContentCategory.MITRE_REPOSITORY,
                            "5.10.1",
                            OvalDefinitions.class,
                            Family.WINDOWS,
                            "test/resources/mitre_repository/oval-5.10/def/windows",
                            null,
                            null
                        }
        };

    }



    /**
     * Definition.
     *
     *   OvalContentCategory        category,
     *   String                     schema_version,
     *   Class<T>                   object_type,
     *   DefinitionsElement.Type    type,
     *   ClassEnumeration           definition_class,
     *   Family                     family,
     *   String                     oval_id,
     *   T                          expected_object
     */
    @DataProvider( name="DATA.oval.def.definition" )
    public Object[][] provideOvalDefDefinition()
    {
        return new Object[][] {
                        /* Windows */
                        {
                            OvalContentCategory.OVAL_TEST_CONTENT,
                            "5.9",
                            DefinitionType.class,
                            ElementType.DEFINITION,
                            ClassEnumeration.MISCELLANEOUS,
                            null,
                            "oval:org.mitre.oval.test:def:140",
                            null
                        }
                        ,
                        {
                            OvalContentCategory.OVAL_TEST_CONTENT,
                            "5.9",
                            DefinitionType.class,
                            ElementType.DEFINITION,
                            ClassEnumeration.MISCELLANEOUS,
                            null,
                            "oval:org.mitre.oval.test:def:16",
                            null
                        }
//                        ,
//
//                        /* linux */
//                        {
//                            OvalContentCategory.OVAL_TEST_CONTENT,
//                            "5.10",
//                            DefinitionType.class,
//                            DefinitionsElement.Type.DEFINITION,
//                            ClassEnumeration.MISCELLANEOUS,
//                            null,
//                            "oval:org.mitre.oval.test:def:683",
//                            null
//                        }
        };

    }



    /**
     * definitions element.
     *
     *   OvalContentCategory        category,
     *   String                     schema_version,
     *   Class<T>                   object_type,
     *   DefinitionsElement.Type    type,
     *   Family                     family,
     *   Component                  component,
     *   String                     oval_id,
     *   T                          expected_object
     */
    @DataProvider( name="DATA.oval.def.element" )
    public Object[][] provideOvalDefElement()
    {
        return new Object[][] {
                        /* Windows */
                        {
                            OvalContentCategory.OVAL_TEST_CONTENT,
                            "5.9",
                            TestType.class,
                            ElementType.TEST,
                            Family.WINDOWS,
                            ComponentType.FILE,
                            "oval:org.mitre.oval.test:tst:1303",
                            null
                        }
                        ,
                        {
                            OvalContentCategory.OVAL_TEST_CONTENT,
                            "5.9",
                            SystemObjectType.class,
                            ElementType.OBJECT,
                            Family.WINDOWS,
                            ComponentType.FILE,
                            "oval:org.mitre.oval.test:obj:1060",
                            null
                        }
                        ,
                        {
                            OvalContentCategory.OVAL_TEST_CONTENT,
                            "5.9",
                            StateType.class,
                            ElementType.STATE,
                            Family.WINDOWS,
                            ComponentType.FILE,
                            "oval:org.mitre.oval.test:ste:1161",
                            null
                        }
                        ,

                        /* linux */
                        {
                            OvalContentCategory.OVAL_TEST_CONTENT,
                            "5.9",
                            TestType.class,
                            ElementType.TEST,
                            Family.LINUX,
                            ComponentType.DPKGINFO,
                            "oval:org.mitre.oval.test:tst:709",
                            null
                        }
                        ,
                        {
                            OvalContentCategory.OVAL_TEST_CONTENT,
                            "5.9",
                            SystemObjectType.class,
                            ElementType.OBJECT,
                            Family.LINUX,
                            ComponentType.DPKGINFO,
                            "oval:org.mitre.oval.test:obj:102",
                            null
                        }
                        ,
                        {
                            OvalContentCategory.OVAL_TEST_CONTENT,
                            "5.9",
                            StateType.class,
                            ElementType.STATE,
                            Family.LINUX,
                            ComponentType.DPKGINFO,
                            "oval:org.mitre.oval.test:ste:787",
                            null
                        }
        };

    }



    /**
     * OVAL System Characteristics documents.
     *
     * Test method params:
     *   OvalContentCategory    category,
     *   String                 schema_version,
     *   Class<T>               object_type,
     *   Family                 family,
     *   String                 dirpath,
     *   String                 xml_filepath
     *   T                      expected_object
     */
    @DataProvider( name="DATA.oval.sc.oval_system_characteristics" )
    public Object[][] provideOvalScOvalSystemCharacteristics()
    {
        return new Object[][] {
                        {
                            OvalContentCategory.OVAL_TEST_CONTENT,
                            "5.10.1",
                            OvalSystemCharacteristics.class,
                            Family.WINDOWS,
                            "test/resources/oval_test-content/oval-5.10/sc/windows",
                            null,
                            null
                        }
                        ,
                        {
                            OvalContentCategory.MITRE_REPOSITORY,
                            "5.10.1",
                            OvalSystemCharacteristics.class,
                            Family.WINDOWS,
                            "test/resources/mitre_repository/oval-5.10/sc/windows",
                            null,
                            null
                        }
                        ,
                        {
                            OvalContentCategory.MITRE_REPOSITORY,
                            "5.9",
                            OvalSystemCharacteristics.class,
                            Family.LINUX,
                            "test/resources/mitre_repository/oval-5.9/sc/linux",
                            null,
                            null
                        }
        };

    }



    /**
     * OVAL Results documents.
     *
     * Test method params:
     *   OvalContentCategory    category,
     *   String                 schema_version,
     *   Class<T>               object_type,
     *   Family                 family,
     *   String                 dirpath,
     *   String                 filename
     *   T                      expected_object
     */
    @DataProvider( name="DATA.oval.res.oval_results" )
    public Object[][] provideOvalResOvalResults()
    {
        return new Object[][] {
                        {
                            OvalContentCategory.OVAL_TEST_CONTENT,
                            "5.10.1",
                            OvalResults.class,
                            Family.WINDOWS,
                            "test/resources/oval_test-content/oval-5.10/res/windows",
                            null,
                            null
                        }
                        ,
                        {
                            OvalContentCategory.MITRE_REPOSITORY,
                            "5.10.1",
                            OvalResults.class,
                            Family.WINDOWS,
                            "test/resources/mitre_repository/oval-5.10/res/windows",
                            null,
                            null
                        }
                        ,
                        {
                            OvalContentCategory.MITRE_REPOSITORY,
                            "5.9",
                            OvalResults.class,
                            Family.LINUX,
                            "test/resources/mitre_repository/oval-5.9/res/linux",
                            null,
                            null
                        }
                        ,
                        {
                            OvalContentCategory.REDHAT_ERRATA_SYSTEM,
                            "5.7",
                            OvalResults.class,
                            Family.LINUX,
                            "test/resources/redhat_errata_system/oval-5.7/res/linux",
                            null,
                            null
                        }
        };

    }

}
//
