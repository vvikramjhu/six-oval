package jp.go.aist.six.test.oval.core;

import java.io.File;
import jp.go.aist.six.oval.core.repository.mongodb.MongoOvalDatastore;
import jp.go.aist.six.oval.model.Component;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.definitions.DefinitionsElement;
import jp.go.aist.six.oval.model.definitions.StateType;
import jp.go.aist.six.oval.model.definitions.SystemObjectType;
import jp.go.aist.six.oval.model.definitions.TestType;
import jp.go.aist.six.oval.repository.DefinitionQueryParams;
import jp.go.aist.six.oval.repository.DefinitionsElementQueryParams;
import jp.go.aist.six.util.persist.Persistable;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class MongoTests
    extends OvalCoreTests
{

    private MongoOvalDatastore  _datastore;



    /**
     */
    @Override
    @BeforeClass( alwaysRun=true )
	public void setUp()
    throws Exception
	{
        super.setUp();

        _datastore = _getContext().getBean( MongoOvalDatastore.class );
	}


    protected MongoOvalDatastore _getDatastore()
    throws Exception
    {
        return _datastore;
    }



    ////////////////////////////////////////////////////////////////
    //  support methods
    ////////////////////////////////////////////////////////////////

    /**
     */
    protected <K, T extends Persistable<K>>
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


    private <K, T extends Persistable<K>>
    void _saveToDatastore(
                    final Class<T>  object_type,
                    final T         object,
                    final boolean   to_load
                    )
    throws Exception
    {
        _saveToDatastore( object_type, object, to_load, true );
    }


    protected <K, T extends Persistable<K>>
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
     *  DefinitionsElement.Type   type,
     *  QueryParams               params
     */
    @DataProvider( name="data:oval.repository.query_params.def.element" )
    public Object[][] provideRepositoryQueryParamsOvalDefElement()
    {
        // common: order, count
        DefinitionsElementQueryParams  params01 = new DefinitionsElementQueryParams();
        params01.setOrder( "id" );
        params01.setCount( "3" );
        params01.setType( DefinitionsElement.Type.TEST.value() );

        // common: order, count, startIndex
        DefinitionsElementQueryParams  params02 = new DefinitionsElementQueryParams();
        params02.setOrder( "id" );
        params02.setCount( "2" );
        params02.setStartIndex( "4" );
        params02.setType( DefinitionsElement.Type.TEST.value() );

        // common: order, count, startIndex
        DefinitionsElementQueryParams  params03 = new DefinitionsElementQueryParams();
        params03.setOrder( "-id" );
        params03.setCount( "5" );
        params03.setType( DefinitionsElement.Type.TEST.value() );

        // common: searchTerms, order
        DefinitionsElementQueryParams  params04 = new DefinitionsElementQueryParams();
        params04.setOrder( "id" );
        params04.setSearchTerms( "iexplore.exe" );
        params04.setType( DefinitionsElement.Type.OBJECT.value() );

        // common: searchTerms, order
        DefinitionsElementQueryParams  params05 = new DefinitionsElementQueryParams();
        params05.setOrder( "-id" );
        params05.setSearchTerms( "regular expression" );
        params05.setType( DefinitionsElement.Type.STATE.value() );

        // element: version
        DefinitionsElementQueryParams  params11 = new DefinitionsElementQueryParams();
        params11.setVersion( "3" );
        params11.setType( DefinitionsElement.Type.TEST.value() );

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
        params21.setComponent( Component.DPKGINFO.value() );

        // definition: family
        DefinitionsElementQueryParams  params22 = new DefinitionsElementQueryParams();
        params22.setFamily( "unix" );

        return new Object[][] {
                        {
                            TestType.class,
                            DefinitionsElement.Type.TEST,
                            params01
                        }
                        ,
                        {
                            TestType.class,
                            DefinitionsElement.Type.TEST,
                            params02
                        }
                        ,
                        {
                            TestType.class,
                            DefinitionsElement.Type.TEST,
                            params03
                        }
                        ,
                        {
                            SystemObjectType.class,
                            DefinitionsElement.Type.OBJECT,
                            params04
                        }
                        ,
                        {
                            StateType.class,
                            DefinitionsElement.Type.STATE,
                            params05
                        }
                        ,
                        {
                            TestType.class,
                            DefinitionsElement.Type.TEST,
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
     *  DefinitionsElement.Type   type,
     *  QueryParams               params
     */
    @DataProvider( name="data:oval.repository.query_params.def.definition" )
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
//                            DefinitionsElement.Type.DEFINITION,
//                            params1
//                        }
//                        ,
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            DefinitionsElement.Type.DEFINITION,
//                            params2
//                        }
//                        ,
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            DefinitionsElement.Type.DEFINITION,
//                            params3
//                        }
//                        ,
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            DefinitionsElement.Type.DEFINITION,
//                            params4
//                        }
//                        ,
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            DefinitionsElement.Type.DEFINITION,
//                            params5
//                        }
//                        ,
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            DefinitionsElement.Type.DEFINITION,
//                            params11
//                        }
//                        ,
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            DefinitionsElement.Type.DEFINITION,
//                            params12
//                        }
//                        ,
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            DefinitionsElement.Type.DEFINITION,
//                            params13
//                        }
//                        ,
//                        {
//                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
//                            DefinitionsElement.Type.DEFINITION,
//                            params14
//                        }
//                        ,
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            DefinitionsElement.Type.DEFINITION,
                            params21
                        }
                        ,
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            DefinitionsElement.Type.DEFINITION,
                            params22
                        }
                        ,
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            DefinitionsElement.Type.DEFINITION,
                            params23
                        }
                        ,
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            DefinitionsElement.Type.DEFINITION,
                            params24
                        }
                        ,
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            DefinitionsElement.Type.DEFINITION,
                            params25
                        }
                        ,
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            DefinitionsElement.Type.DEFINITION,
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
                                    "java:oval.core.repository.mongodb",
                                    "data:oval.def",
                                    "control:datastore.save"
                                    },
                    dataProvider="data:oval.def.oval_definitions",
                    alwaysRun=true
                    )
    public <K, T extends Persistable<K>>
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
                                    "java:oval.core.repository.mongodb",
                                    "data:oval.sc",
                                    "control:datastore.save"
                                    },
                    dataProvider="data:oval.sc.oval_system_characteristics",
                    alwaysRun=true
                    )
    public <K, T extends Persistable<K>>
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
                                    "java:oval.core.repository.mongodb",
                                    "data:oval.res",
                                    "control:datastore.save"
                                    },
                    dataProvider="data:oval.res.oval_results",
                    alwaysRun=true
                    )
    public <K, T extends Persistable<K>>
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
