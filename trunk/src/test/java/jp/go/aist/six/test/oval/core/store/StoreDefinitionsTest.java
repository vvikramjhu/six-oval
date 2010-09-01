package jp.go.aist.six.test.oval.core.store;

import jp.go.aist.six.oval.model.OvalEntity;
import jp.go.aist.six.oval.model.common.Check;
import jp.go.aist.six.oval.model.common.Datatype;
import jp.go.aist.six.oval.model.common.Existence;
import jp.go.aist.six.oval.model.common.Family;
import jp.go.aist.six.oval.model.common.Operation;
import jp.go.aist.six.oval.model.common.Operator;
import jp.go.aist.six.oval.model.definitions.EntityObjectString;
import jp.go.aist.six.oval.model.definitions.EntityStateAnySimple;
import jp.go.aist.six.oval.model.definitions.EntityStateString;
import jp.go.aist.six.oval.model.definitions.State;
import jp.go.aist.six.oval.model.definitions.SystemObject;
import jp.go.aist.six.oval.model.definitions.Test;
import jp.go.aist.six.oval.model.independent.EntityStateFamily;
import jp.go.aist.six.oval.model.independent.FamilyObject;
import jp.go.aist.six.oval.model.independent.FamilyState;
import jp.go.aist.six.oval.model.independent.FamilyTest;
import jp.go.aist.six.oval.model.independent.TextFileContentObject;
import jp.go.aist.six.oval.model.independent.TextFileContentState;
import jp.go.aist.six.oval.model.independent.TextFileContentTest;
import jp.go.aist.six.oval.model.independent.UnknownTest;
import jp.go.aist.six.oval.model.linux.DpkgInfoObject;
import jp.go.aist.six.oval.model.linux.DpkgInfoState;
import jp.go.aist.six.oval.model.linux.DpkgInfoTest;
import jp.go.aist.six.oval.model.linux.RpmInfoObject;
import jp.go.aist.six.oval.model.linux.RpmInfoState;
import jp.go.aist.six.oval.model.linux.RpmInfoTest;
import jp.go.aist.six.oval.model.unix.UnameObject;
import jp.go.aist.six.oval.model.unix.UnameTest;
import jp.go.aist.six.oval.model.windows.FileObject;
import jp.go.aist.six.oval.model.windows.FileState;
import jp.go.aist.six.oval.model.windows.FileTest;
import jp.go.aist.six.oval.model.windows.MetabaseState;
import jp.go.aist.six.oval.model.windows.MetabaseTest;
import jp.go.aist.six.oval.model.windows.RegistryState;
import jp.go.aist.six.oval.model.windows.RegistryTest;
import jp.go.aist.six.test.oval.core.CoreTestBase;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class StoreDefinitionsTest
    extends CoreTestBase
{

    /**
     */
    public StoreDefinitionsTest()
    {
    }



    private <T extends OvalEntity> void _testOvalEntity(
                    final Class<T> type,
                    final String filepath,
                    final String xpath,
                    final T expected
                    )
    throws Exception
    {
        Reporter.log( "\n////////////////////////////////////////////////////////////////", true );
        Reporter.log( "  * object type: " + type, true );

        T  object = _readObjectFromXmlFile( type, filepath, xpath, expected );
        Assert.assertNotNull( object );

        _syncOvalEntity( type, object );
    }



    /**
     */
    private <T> T _readObjectFromXmlFile(
                    final Class<T> type,
                    final String filepath,
                    final String xpath,
                    final T expected
                    )
    throws Exception
    {
        Reporter.log( "  * XPath: " + xpath, true );
        Reporter.log( "  * XML file: " + filepath, true );

        T  actual = _unmarshalFromFile( filepath, type );

        if (expected != null) {
            Reporter.log( "validating...", true );
            _assertEquals( actual, expected );
            Reporter.log( "...validation OK", true );
        }

        return actual;
    }



    /**
     */
    protected <T extends OvalEntity> void _syncOvalEntity(
                    final Class<T> type,
                    final T object
                    )
    throws Exception
    {
        Reporter.log( "sync OvalEntity: " + object.getOvalID(), true );
        T  persistent = _getStore().sync( type, object );
        Reporter.log( "...sync done", true );

        String  pid = persistent.getPersistentID();
        Reporter.log( "  @ pid=" + pid, true );

        Reporter.log( "get object...", true );
        Reporter.log( "  - pid=" + pid, true );
        T  persistent2 = _getStore().get( type, pid );
        Reporter.log( "...get done", true );

        Reporter.log( "  @ get: object=" + persistent2, true );
        _assertEquals( persistent2, object );
    }



    //==============================================================
    //  test
    //==============================================================

    @DataProvider( name="definitions.test" )
    public Object[][] provideDefinitionsTest()
    {
        return new Object[][] {
                        // independent : family
                        {
                            Test.class,
                            "test/data/definitions/test-family_oval-tst-99_1.xml",
                            "oval_definitions/tests/independent:family_test",
                            new FamilyTest( "oval:org.mitre.oval:tst:99",
                                            1,
                                            "the installed operating system is part of the Microsoft Windows family",
                                            Check.ONLY_ONE )
                                .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
                                .object( "oval:org.mitre.oval:obj:99" )
                                .state( "oval:org.mitre.oval:ste:99" )
                        }
                        ,
                        // independent : textfilecontent
                        {
                            Test.class,
                            "test/data/definitions/test-textfilecontent_oval-tst-11150_1.xml",
                            "oval_definitions/tests/independent:textfilecontent_test",
                            new TextFileContentTest( "oval:org.mitre.oval:tst:11150",
                                            1,
                                            "Debian GNU/Linux 5.0 is installed",
                                            Check.ALL )
                                .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
                                .object( "oval:org.mitre.oval:obj:7326" )
                                .state( "oval:org.mitre.oval:ste:5739" )
                        }
                        ,
                        // independent : unknown
                        {
                            Test.class,
                            "test/data/definitions/test-unknown_oval-tst-2531_1.xml",
                            "oval_definitions/tests/independent:unknown_test",
                            new UnknownTest( "oval:org.mitre.oval:tst:2531",
                                            1,
                                            "Word 97 is installed",
                                            Check.ALL )
                        }
                        ,
                        // linux : DpkgInfo
                        {
                            Test.class,
                            "test/data/definitions/test-dpkginfo_oval-tst-19402_1.xml",
                            "oval_definitions/tests/linux:dpkginfo_test",
                            new DpkgInfoTest( "oval:org.mitre.oval:tst:19402",
                                            1,
                                            "apache2-src is earlier than 2.2.9-10+lenny6",
                                            Check.ALL )
                                .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
                                .object( "oval:org.mitre.oval:obj:10286" )
                                .state( "oval:org.mitre.oval:ste:6372" )
                        }
                        ,
                        // linux : RpmInfo
                        {
                            Test.class,
                            "test/data/definitions/test-rpminfo_rhsa-tst-20100061002_301.xml",
                            "oval_definitions/tests/linux:rpminfo_test",
                            new RpmInfoTest( "oval:com.redhat.rhsa:tst:20100061002",
                                            301,
                                            "gzip is earlier than 0:1.3.5-11.el5_4.1",
                                            Check.AT_LEAST_ONE )
                                .object( "oval:com.redhat.rhsa:obj:20100061002" )
                                .state( "oval:com.redhat.rhsa:ste:20100061004" )
                        }
                        ,
                        // unix : uname
                        {
                            Test.class,
                            "test/data/definitions/test-uname_oval-tst-11195_1.xml",
                            "oval_definitions/tests/unix:uname_test",
                            new UnameTest( "oval:org.mitre.oval:tst:11195",
                                            1,
                                            "Installed architecture is mips",
                                            Check.ALL )
                                .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
                                .object( "oval:org.mitre.oval:obj:2759" )
                                .state( "oval:org.mitre.oval:ste:5601" )
                        }
                        ,
                        // windows : File
                        {
                            Test.class,
                            "test/data/definitions/test-file_oval-tst-2339_1.xml",
                            "oval_definitions/tests/windows:file_test",
                            new FileTest( "oval:org.mitre.oval:tst:2339",
                                            1,
                                            "the version of mshtml.dll is less than 6.0.2900.2873",
                                            Check.AT_LEAST_ONE )
                                .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
                                .object( "oval:org.mitre.oval:obj:222" )
                                .state( "oval:org.mitre.oval:ste:2190" )
                        }
                        ,
                        // windows : File 2
                        {
                            Test.class,
                            "test/data/definitions/test-file_oval-tst-10629_1.xml",
                            "oval_definitions/tests/windows:file_test",
                            new FileTest( "oval:org.mitre.oval:tst:10629",
                                            1,
                                            "Opera.exe version 9.x to 10.0.x",
                                            Check.ALL )
                                .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
                                .stateOperator( Operator.OR )
                                .object( "oval:org.mitre.oval:obj:6638" )
                                .state( "oval:org.mitre.oval:ste:4847" )
                                .state( "oval:org.mitre.oval:ste:5298" )
                        }
                        ,
                        // windows : Metabase test
                        {
                            Test.class,
                            "test/data/definitions/test-metabase_oval-tst-709_2.xml",
                            "oval_definitions/tests/windows:metabase_test",
                            new MetabaseTest( "oval:org.mitre.oval:tst:709",
                                            2,
                                            "Negotiate is enabled",
                                            Check.AT_LEAST_ONE )
                                .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
                                .object( "oval:org.mitre.oval:obj:556" )
                        }
                        ,
                        // windows : Registry test
                        {
                            Test.class,
                            "test/data/definitions/test-registry_oval-tst-3019_2.xml",
                            "oval_definitions/tests/windows:registry_test",
                            new RegistryTest( "oval:org.mitre.oval:tst:3019",
                                            2,
                                            "Win2K/XP/2003/Vista/2008 service pack 2 is installed",
                                            Check.AT_LEAST_ONE )
                                .checkExistence( Existence.AT_LEAST_ONE_EXISTS )
                                .object( "oval:org.mitre.oval:obj:717" )
                                .state( "oval:org.mitre.oval:ste:2827" )
                        }
        };
    }



    @org.testng.annotations.Test(
                    groups={"oval.core.store", "definitions.test"},
                    dataProvider="definitions.test",
                    alwaysRun=true
                    )
    public <T extends Test> void testDefinitionsTest(
                    final Class<T> type,
                    final String filepath,
                    final String xpath,
                    final T expected
                    )
    throws Exception
    {
        _testOvalEntity( type, filepath, xpath, expected );
    }



    //==============================================================
    //  state
    //==============================================================

    @DataProvider( name="definitions.state" )
    public Object[][] provideDefinitionsState()
    {
        EntityStateFamily  stateFamily = new EntityStateFamily( Family.WINDOWS );
        stateFamily.setOperation( Operation.CASE_INSENSITIVE_EQUALS );

        EntityStateAnySimple  subexpression = new EntityStateAnySimple( "\\brw\\b" );
        subexpression.setOperation( Operation.PATTERN_MATCH );

        EntityStateString  fileVersion = new EntityStateString( "6.0.2900.2873" );
        fileVersion.setDatatype( Datatype.VERSION );
        fileVersion.setOperation( Operation.LESS_THAN );

        EntityStateAnySimple  metabaseData = new EntityStateAnySimple( "^http:*,PERMANENT,*" );
        metabaseData.setOperation( Operation.PATTERN_MATCH );

        EntityStateAnySimple  registryValue = new EntityStateAnySimple( "1" );
        registryValue.setOperation( Operation.EQUALS );
        registryValue.setDatatype( Datatype.INT );

        EntityStateString  dpkginfoEvr = new EntityStateString( "0:2.2.6-02-1+lenny2+b2" );
        dpkginfoEvr.setDatatype( Datatype.EVR_STRING );
        dpkginfoEvr.setOperation( Operation.LESS_THAN );

        EntityStateString  rpminfoEvr = new EntityStateString( "0:1.3.5-11.el5_4.1" );
        rpminfoEvr.setDatatype( Datatype.EVR_STRING );
        rpminfoEvr.setOperation( Operation.LESS_THAN );

        EntityStateString  rpminfoVersion = new EntityStateString( "^5[^[:digit:]]" );
        rpminfoVersion.setOperation( Operation.PATTERN_MATCH );

        EntityStateString  rpminfoSignatureKeyID = new EntityStateString( "5326810137017186" );
        rpminfoSignatureKeyID.setOperation( Operation.EQUALS );

        return new Object[][] {
                        // independent : family
                        {
                            State.class,
                            "test/data/definitions/state-family_oval-ste-99_2.xml",
                            "oval_definitions/states/independent:family_state",
                            new FamilyState( "oval:org.mitre.oval:ste:99",
                                            2 )
                                .family( stateFamily )
                                .comment( "the installed operating system is part of the Microsoft Windows family")
                        }
                        ,
                        // independent : textfilecontent
                        {
                            State.class,
                            "test/data/definitions/state-textfilecontent_oval-ste-5132_1.xml",
                            "oval_definitions/states/independent:textfilecontent_state",
                            new TextFileContentState( "oval:org.mitre.oval:ste:5132",
                                            1 )
                                .subExpression( subexpression )
                        }
                        ,
                        // windows : file
                        {
                            State.class,
                            "test/data/definitions/state-file_oval-ste-2190_1.xml",
                            "oval_definitions/states/windows:file_state",
                            new FileState( "oval:org.mitre.oval:ste:2190",
                                            1 )
                                .version( fileVersion )
                        }
                        ,
                        // windows : metabase
                        {
                            State.class,
                            "test/data/definitions/state-metabase_oval-ste-537_1.xml",
                            "oval_definitions/states/windows:metabase_state",
                            new MetabaseState( "oval:org.mitre.oval:ste:537",
                                            1 )
                                .data( metabaseData )
                        }
                        ,
                        // windows : registry
                        {
                            State.class,
                            "test/data/definitions/state-registry_oval-ste-1205_1.xml",
                            "oval_definitions/states/windows:registry_state",
                            new RegistryState( "oval:org.mitre.oval:ste:1205",
                                            1 )
                                .value( registryValue )
                        }
                        ,
                        // linux : dpkginfo
                        {
                            State.class,
                            "test/data/definitions/state-dpkginfo_oval-ste-5797_1.xml",
                            "oval_definitions/states/linux:dpkginfo_state",
                            new DpkgInfoState( "oval:org.mitre.oval:ste:5797",
                                            1 )
                                .evr( dpkginfoEvr )
                        }
                        ,
                        // linux : rpminfo/evr
                        {
                            State.class,
                            "test/data/definitions/state-rpminfo_rhsa-ste-20100061004_301.xml",
                            "oval_definitions/states/linux:rpminfo_state",
                            new RpmInfoState( "oval:com.redhat.rhsa:ste:20100061004",
                                            301 )
                                .evr( rpminfoEvr )
                        }
                        ,
                        // linux : rpminfo/version
                        {
                            State.class,
                            "test/data/definitions/state-rpminfo_rhsa-ste-20100061003_301.xml",
                            "oval_definitions/states/linux:rpminfo_state",
                            new RpmInfoState( "oval:com.redhat.rhsa:ste:20100061003",
                                            301 )
                                .version( rpminfoVersion )
                        }
                        ,
                        // linux : rpminfo/signature_keyid
                        {
                            State.class,
                            "test/data/definitions/state-rpminfo_rhsa-ste-20100061002_301.xml",
                            "oval_definitions/states/linux:rpminfo_state",
                            new RpmInfoState( "oval:com.redhat.rhsa:ste:20100061002",
                                            301 )
                                .signatureKeyID( rpminfoSignatureKeyID )
                        }
        };

    }



    @org.testng.annotations.Test(
                    groups={"oval.core.store", "definitions.state"},
                    dataProvider="definitions.state",
                    alwaysRun=true
                    )
    public <T extends State> void testDefinitionsState(
                    final Class<T> type,
                    final String filepath,
                    final String xpath,
                    final T expected
                    )
    throws Exception
    {
        _testOvalEntity( type, filepath, xpath, expected );
    }



    //==============================================================
    //  object
    //==============================================================

    @DataProvider( name="definitions.object" )
    public Object[][] provideDefinitionsObject()
    {
        EntityObjectString  textfilecontentLine = new EntityObjectString( "\\d\\.\\d" );
        textfilecontentLine.setOperation( Operation.PATTERN_MATCH );

        EntityObjectString  filePath = new EntityObjectString();
        filePath.setVarRef( "oval:org.mitre.oval:var:200" );
        filePath.setVarCheck( Check.ALL );

        return new Object[][] {
                        // independent : family
                        {
                            SystemObject.class,
                            "test/data/definitions/object-family_oval-obj-99_1.xml",
                            "oval_definitions/objects/independent:family_object",
                            new FamilyObject( "oval:org.mitre.oval:obj:99",
                                            1,
                                            "This is the default family object. Only one family object should exist."
                                            )
                        }
                        ,
                        // independent : textfilecontent
                        {
                            SystemObject.class,
                            "test/data/definitions/object-textfilecontent_oval-obj-7326_1.xml",
                            "oval_definitions/objects/independent:textfilecontent_object",
                            new TextFileContentObject( "oval:org.mitre.oval:obj:7326",
                                            1
                                            )
                                .path( new EntityObjectString( "/etc" ) )
                                .filename( new EntityObjectString( "debian_version" ) )
                                .line( textfilecontentLine )
                        }
                        ,
                        // linux : dpkginfo
                        {
                            SystemObject.class,
                            "test/data/definitions/object-dpkginfo_oval-obj-10648_1.xml",
                            "oval_definitions/objects/linux:dpkginfo_object",
                            new DpkgInfoObject( "oval:org.mitre.oval:obj:10648",
                                            1,
                                            "apache2 package information"
                                            )
                                .name( new EntityObjectString( "apache2" ) )
                        }
                        ,
                        // linux : rpminfo
                        {
                            SystemObject.class,
                            "test/data/definitions/object-rpminfo_rhsa-obj-20100061001_301.xml",
                            "oval_definitions/objects/linux:rpminfo_object",
                            new RpmInfoObject( "oval:com.redhat.rhsa:obj:20100061001",
                                            301
                                            )
                                .name( new EntityObjectString( "redhat-release" ) )
                        }
                        ,
                        // unux : uname
                        {
                            SystemObject.class,
                            "test/data/definitions/object-uname_oval-obj-2759_1.xml",
                            "oval_definitions/objects/unix:uname_object",
                            new UnameObject( "oval:org.mitre.oval:obj:2759",
                                            1,
                                            "The single uname object."
                                            )
                        }
                        ,
//                        // windows : file
                        {
                            SystemObject.class,
                            "test/data/definitions/object-file_oval-obj-222_1.xml",
                            "oval_definitions/objects/windows:file_object",
                            new FileObject( "oval:org.mitre.oval:obj:222",
                                            1,
                                            "The path to the mshtml.dll file in the system root"
                                            )
                                .path( filePath )
                                .filename( new EntityObjectString( "mshtml.dll" ) )


                        }
//                        {
//                            "test/data/definition/sample_oval-object-file.xml",
//                            "oval:org.mitre.oval:obj:222",
//                            1,
//                            "The path to the mshtml.dll file in the system root"
//                        },
//
//                        // windows : metabase
//                        {
//                            "test/data/definition/sample_oval-object-metabase.xml",
//                            "oval:org.mitre.oval:obj:556",
//                            2,
//                            null
//                        },
//
//                        // windows : registry
//                        {
//                            "test/data/definition/sample_oval-object-registry.xml",
//                            "oval:org.mitre.oval:obj:717",
//                            1,
//                            "This registry key holds the service pack installed on the host if one is present."
//                        }
        };
    }



    @org.testng.annotations.Test(
                    groups={"oval.core.store", "definitions.object"},
                    dataProvider="definitions.object",
                    alwaysRun=true
                    )
    public <T extends SystemObject> void testDefinitionsObject(
                    final Class<T> type,
                    final String filepath,
                    final String xpath,
                    final T expected
                    )
    throws Exception
    {
        _testOvalEntity( type, filepath, xpath, expected );
    }

}
// DefinitionsTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

