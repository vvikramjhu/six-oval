package jp.go.aist.six.test.oval.core;

import java.io.File;
import jp.go.aist.six.oval.core.OvalContext;
import jp.go.aist.six.oval.core.repository.mongodb.MongoOvalDatabase;
import jp.go.aist.six.oval.model.ComponentType;
import jp.go.aist.six.oval.model.ElementType;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.OvalObject;
import jp.go.aist.six.oval.model.definitions.StateType;
import jp.go.aist.six.oval.model.definitions.SystemObjectType;
import jp.go.aist.six.oval.model.definitions.TestType;
import jp.go.aist.six.oval.repository.DefinitionQueryParams;
import jp.go.aist.six.oval.repository.DefinitionsElementQueryParams;
import jp.go.aist.six.oval.repository.OvalDatabase;
import jp.go.aist.six.util.persist.Persistable;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.mapping.MappedClass;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class MongoTests
    extends OvalCoreTestBase
{

    private OvalDatabase  _database;



    /**
     */
    @Override
    @BeforeClass( alwaysRun=true )
	public void setUp()
    throws Exception
	{
        super.setUp();

        _database = OvalContext.getServerInstance().getBean( MongoOvalDatabase.class );

        Morphia  morphia = OvalContext.getServerInstance().getBean( "morphia", Morphia.class );
        for (MappedClass  clazz : morphia.getMapper().getMappedClasses()) {
            Reporter.log( "% Morphia mapped MongoDB collection: " + clazz.getCollectionName(), true );
        }
	}


    protected OvalDatabase _getDatastore()
    throws Exception
    {
        return _database;
    }



    ////////////////////////////////////////////////////////////////
    //  support methods
    ////////////////////////////////////////////////////////////////

    /**
     */
    protected <K, T extends Persistable<K> & OvalObject>
    void _unmarshalFromFileAndSaveToDatastore(
                    final Class<T>  object_type,
                    final String    schema_version,
                    final Family    family,
                    final String    dirpath,
                    final String    xml_filepath,
                    final T         expected_object
                    )
    throws Exception
    {
        Reporter.log( "* object type: "     + object_type, true );
        Reporter.log( "* schema version: "  + schema_version, true );
        Reporter.log( "* family: "          + family, true );
        Reporter.log( "* dir path: "        + dirpath, true );
        Reporter.log( "* XML file path: "   + xml_filepath, true );

        File[]  files = _toXmlFileList( dirpath, xml_filepath );
        for (File  file : files) {
            Reporter.log( "  * file= " + file, true );
            T  object = _unmarshalFromFile( object_type, file.getCanonicalPath(), expected_object );
            _saveToDatastore( object_type, object, true );
        }
    }


    private <K, T extends Persistable<K> & OvalObject>
    void _saveToDatastore(
                    final Class<T>  object_type,
                    final T         object,
                    final boolean   to_load
                    )
    throws Exception
    {
        _saveToDatastore( object_type, object, to_load, true );
    }


    protected <K, T extends Persistable<K> & OvalObject>
    void _saveToDatastore(
                    final Class<T>  object_type,
                    final T         object,
                    final boolean   to_load,
                    final boolean   to_log
                    )
    throws Exception
    {
        if (to_log) {
            Reporter.log( ">>> save..." , true );
            Reporter.log( "  * object type: " + object_type, true );
            Reporter.log( "  * object: " + object, true );
        }

        K  pid = _getDatastore().save( object_type, object );
        if (to_log) {
            Reporter.log( "<<< ...object saved: PID=" + pid, true );
        }

        if (to_load) {
            if (to_log) {
                Reporter.log( ">>> find object by PID...", true );
                Reporter.log( "   * PID: " + pid, true );
            }
            T  p_object = _getDatastore().findById( object_type, pid );
            if (to_log) {
                Reporter.log( "<<< ...object found", true );
                Reporter.log( "  @ object: " + p_object, true );
                _printObject( object_type, p_object );
            }
        }
    }



    ////////////////////////////////////////////////////////////////
    //  test data
    ////////////////////////////////////////////////////////////////

    /**
     * definitions element.
     *
     *  Class<? extends DefinitionsElement>     object_type,
     *  ElementType   type,
     *  QueryParams               params
     */
    @DataProvider( name="DATA.oval.repository.query_params.def.element" )
    public Object[][] provideRepositoryQueryParamsOvalDefElement()
    {
        // common: order, count
        DefinitionsElementQueryParams  params01 = new DefinitionsElementQueryParams();
        params01.setOrder( "id" );
        params01.setCount( "3" );
        params01.setType( ElementType.TEST.value() );

        // common: order, count, startIndex
        DefinitionsElementQueryParams  params02 = new DefinitionsElementQueryParams();
        params02.setOrder( "id" );
        params02.setCount( "2" );
        params02.setStartIndex( "4" );
        params02.setType( ElementType.TEST.value() );

        // common: order, count, startIndex
        DefinitionsElementQueryParams  params03 = new DefinitionsElementQueryParams();
        params03.setOrder( "-id" );
        params03.setCount( "5" );
        params03.setType( ElementType.TEST.value() );

        // common: searchTerms, order
        DefinitionsElementQueryParams  params04 = new DefinitionsElementQueryParams();
        params04.setOrder( "id" );
        params04.setSearchTerms( "iexplore.exe" );
        params04.setType( ElementType.OBJECT.value() );

        // common: searchTerms, order
        DefinitionsElementQueryParams  params05 = new DefinitionsElementQueryParams();
        params05.setOrder( "-id" );
        params05.setSearchTerms( "regular expression" );
        params05.setType( ElementType.STATE.value() );

        // element: version
        DefinitionsElementQueryParams  params11 = new DefinitionsElementQueryParams();
        params11.setVersion( "3" );
        params11.setType( ElementType.TEST.value() );

        // element: id --- linux rpminfo
        DefinitionsElementQueryParams  params12 = new DefinitionsElementQueryParams();
        params12.setId( "oval:org.mitre.oval.test:ste:599" );

        // element: id
        DefinitionsElementQueryParams  params13 = new DefinitionsElementQueryParams();
        params13.setId( "oval:org.mitre.oval.test:def:889,oval:org.mitre.oval.test:ste:599,oval:org.mitre.oval.test:def:140" );

        // element: id --- NOT found
        DefinitionsElementQueryParams  params14 = new DefinitionsElementQueryParams();
        params14.setId( "oval:org.mitre.oval.test:obj:99999" );

        // element: component
        DefinitionsElementQueryParams  params21 = new DefinitionsElementQueryParams();
        params21.setComponent( ComponentType.DPKGINFO.value() );

        // definition: family
        DefinitionsElementQueryParams  params22 = new DefinitionsElementQueryParams();
        params22.setFamily( "unix" );

        return new Object[][] {
                        {
                            TestType.class,
                            ElementType.TEST,
                            params01
                        }
                        ,
                        {
                            TestType.class,
                            ElementType.TEST,
                            params02
                        }
                        ,
                        {
                            TestType.class,
                            ElementType.TEST,
                            params03
                        }
                        ,
                        {
                            SystemObjectType.class,
                            ElementType.OBJECT,
                            params04
                        }
                        ,
                        {
                            StateType.class,
                            ElementType.STATE,
                            params05
                        }
                        ,
                        {
                            TestType.class,
                            ElementType.TEST,
                            params11
                        }
                        ,
                        {
                            null,
                            null,
                            params12
                        }
                        ,
                        {
                            null,
                            null,
                            params13
                        }
                        ,
                        {
                            null,
                            null,
                            params14
                        }
                        ,
                        {
                            null,
                            null,
                            params21
                        }
                        ,
                        {
                            null,
                            null,
                            params22
                        }
        };
    }



    /**
     * Definition.
     *
     *  Class<DefinitionType>     object_type,
     *  ElementType   type,
     *  QueryParams               params
     */
    @DataProvider( name="DATA.oval.repository.query_params.def.definition" )
    public Object[][] provideRepositoryQueryParamsOvalDefDefinition()
    {
        // common: order, count
        DefinitionQueryParams  params1 = new DefinitionQueryParams();
        params1.setOrder( "id" );
        params1.setCount( "3" );

        // common: order, count, startIndex
        DefinitionQueryParams  params2 = new DefinitionQueryParams();
        params2.setOrder( "id" );
        params2.setCount( "2" );
        params2.setStartIndex( "4" );

        // common: order, count, startIndex
        DefinitionQueryParams  params3 = new DefinitionQueryParams();
        params3.setOrder( "-id" );
        params3.setCount( "5" );

        // common: searchTerms, order
        DefinitionQueryParams  params4 = new DefinitionQueryParams();
        params4.setOrder( "id" );
        params4.setSearchTerms( "linux-def:s" );

        // common: searchTerms, order
        DefinitionQueryParams  params5 = new DefinitionQueryParams();
        params5.setOrder( "-id" );
        params5.setSearchTerms( "negate" );

        // element: version
        DefinitionQueryParams  params11 = new DefinitionQueryParams();
        params11.setVersion( "7" );

        // element: id
        DefinitionQueryParams  params12 = new DefinitionQueryParams();
        params12.setId( "oval:org.mitre.oval.test:def:889" );

        // element: id
        DefinitionQueryParams  params13 = new DefinitionQueryParams();
        params13.setId( "oval:org.mitre.oval.test:def:889,oval:org.mitre.oval.test:def:121,oval:org.mitre.oval.test:def:140" );

        // element: id
        DefinitionQueryParams  params14 = new DefinitionQueryParams();
        params14.setId( "oval:org.mitre.oval.test:def:1000" );

        // definition: definitionClass
        DefinitionQueryParams  params21 = new DefinitionQueryParams();
        params21.setDefinitionClass( "compliance" );

        // definition: family
        DefinitionQueryParams  params22 = new DefinitionQueryParams();
        params22.setFamily( "unix" );

        // definition: platform
        DefinitionQueryParams  params23 = new DefinitionQueryParams();
        params23.setPlatform( "Microsoft Windows XP" );

        // definition: product
        DefinitionQueryParams  params24 = new DefinitionQueryParams();
        params24.setProduct( "Mozilla Firefox,Mozilla Thunderbird" );

        // definition: refId
        DefinitionQueryParams  params25 = new DefinitionQueryParams();
        params25.setRefId( "CVE-2010-0176" );

        // definition: refId
        DefinitionQueryParams  params26 = new DefinitionQueryParams();
        params26.setRefSource( "CPE" );

        return new Object[][] {
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            ElementType.DEFINITION,
//                            params1
//                        }
//                        ,
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            ElementType.DEFINITION,
//                            params2
//                        }
//                        ,
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            ElementType.DEFINITION,
//                            params3
//                        }
//                        ,
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            ElementType.DEFINITION,
//                            params4
//                        }
//                        ,
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            ElementType.DEFINITION,
//                            params5
//                        }
//                        ,
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            ElementType.DEFINITION,
//                            params11
//                        }
//                        ,
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            ElementType.DEFINITION,
//                            params12
//                        }
//                        ,
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            ElementType.DEFINITION,
//                            params13
//                        }
//                        ,
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            ElementType.DEFINITION,
//                            params14
//                        }
//                        ,
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            ElementType.DEFINITION,
                            params21
                        }
                        ,
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            ElementType.DEFINITION,
                            params22
                        }
                        ,
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            ElementType.DEFINITION,
                            params23
                        }
                        ,
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            ElementType.DEFINITION,
                            params24
                        }
                        ,
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            ElementType.DEFINITION,
                            params25
                        }
                        ,
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            ElementType.DEFINITION,
                            params26
                        }
        };
    }



    ////////////////////////////////////////////////////////////////
    //  test methods
    ////////////////////////////////////////////////////////////////

    /**
     */
    @org.testng.annotations.Test(
                    groups={
                                    "MODEL.oval.def",
                                    "PACKAGE.oval.core.repository.mongodb",
                                    "CONTROL.oval.core.repository.mongodb.datastore.save"
                                    },
                    dataProvider="DATA.oval.def.oval_definitions",
                    alwaysRun=true
                    )
    public <K, T extends Persistable<K> & OvalObject>
    void testSaveOvalDefOvalDefinitions(
                    final OvalContentCategory category,
                    final String    schema_version,
                    final Class<T>  object_type,
                    final Family    family,
                    final String    dirpath,
                    final String    xml_filepath,
                    final T         expected_object
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );
        _unmarshalFromFileAndSaveToDatastore( object_type, schema_version, family, dirpath, xml_filepath, expected_object );
    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={
                                    "MODEL.oval.sc",
                                    "PACKAGE.oval.core.repository.mongodb",
                                    "CONTROL.oval.core.repository.mongodb.datastore.save"
                                    },
                    dataProvider="DATA.oval.sc.oval_system_characteristics",
                    alwaysRun=true
                    )
    public <K, T extends Persistable<K> & OvalObject>
    void testSaveOvalScOvalSystemCharacteristics(
                    final OvalContentCategory category,
                    final String    schema_version,
                    final Class<T>  object_type,
                    final Family    family,
                    final String    dirpath,
                    final String    xml_filepath,
                    final T         expected_object
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );
        _unmarshalFromFileAndSaveToDatastore( object_type, schema_version, family, dirpath, xml_filepath, expected_object );
    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={
                                    "MODEL.oval.res",
                                    "PACKAGE.oval.core.repository.mongodb",
                                    "CONTROL.oval.core.repository.mongodb.datastore.save"
                                    },
                    dataProvider="DATA.oval.res.oval_results",
                    alwaysRun=true
                    )
    public <K, T extends Persistable<K> & OvalObject>
    void testSaveOvalResOvalResults(
                    final OvalContentCategory category,
                    final String    schema_version,
                    final Class<T>  object_type,
                    final Family    family,
                    final String    dirpath,
                    final String    xml_filepath,
                    final T         expected_object
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );
        _unmarshalFromFileAndSaveToDatastore( object_type, schema_version, family, dirpath, xml_filepath, expected_object );
    }

}
//
