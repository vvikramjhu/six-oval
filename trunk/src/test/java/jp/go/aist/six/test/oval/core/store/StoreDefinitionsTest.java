package jp.go.aist.six.test.oval.core.store;

import jp.go.aist.six.oval.model.OvalEntity;
import jp.go.aist.six.oval.model.common.Check;
import jp.go.aist.six.oval.model.common.Existence;
import jp.go.aist.six.oval.model.common.Operator;
import jp.go.aist.six.oval.model.definitions.Test;
import jp.go.aist.six.oval.model.linux.RpmInfoTest;
import jp.go.aist.six.oval.model.windows.FileTest;
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
            Assert.assertEquals( actual, expected );
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
        Assert.assertEquals( persistent2, object );
    }



    //==============================================================
    //  test
    //==============================================================

    /**
     */
    @DataProvider( name="definitions.test" )
    public Object[][] provideDefinitionsTest()
    {
        return new Object[][] {
//                        // independent : family test
//                        {
//                            "test/data/definition/sample_oval-test-family.xml",
//                            "oval:org.mitre.oval:tst:99",
//                            1,
//                            "the installed operating system is part of the Microsoft Windows family",
//                            Existence.AT_LEAST_ONE_EXISTS,
//                            Check.ONLY_ONE,
//                            EntityType.INDEPENDENT_FAMILY,
//                            "oval:org.mitre.oval:obj:99",
//                            "oval:org.mitre.oval:ste:99"
//                        },
//
//                        // independent : textfilecontent test
//                        {
//                            "test/data/definition/sample_oval-test-textfilecontent.xml",
//                            "oval:org.mitre.oval:tst:11150",
//                            1,
//                            "Debian GNU/Linux 5.0 is installed",
//                            Existence.AT_LEAST_ONE_EXISTS,
//                            Check.ALL,
//                            EntityType.INDEPENDENT_TEXTFILECONTENT,
//                            "oval:org.mitre.oval:obj:7326",
//                            "oval:org.mitre.oval:ste:5739"
//                        },
//
//                        // independent : unknown test
//                        {
//                            "test/data/definition/sample_oval-test-unknown.xml",
//                            "oval:org.mitre.oval:tst:2531",
//                            1,
//                            "Word 97 is installed",
//                            Existence.AT_LEAST_ONE_EXISTS,
//                            Check.ALL,
//                            EntityType.INDEPENDENT_UNKNOWN,
//                            null,
//                            null
//                        },
//
//                        // unix : uname test
//                        {
//                            "test/data/definition/sample_oval-test-uname.xml",
//                            "oval:org.mitre.oval:tst:11195",
//                            1,
//                            "Installed architecture is mips",
//                            Existence.AT_LEAST_ONE_EXISTS,
//                            Check.ALL,
//                            EntityType.UNIX_UNAME,
//                            "oval:org.mitre.oval:obj:2759",
//                            "oval:org.mitre.oval:ste:5601"
//                        },
//
//                        // windows : Registry test
//                        {
//                            "test/data/definition/sample_oval-test-registry.xml",
//                            "oval:org.mitre.oval:tst:3019",
//                            2,
//                            "Win2K/XP/2003/Vista/2008 service pack 2 is installed",
//                            Existence.AT_LEAST_ONE_EXISTS,
//                            Check.AT_LEAST_ONE,
//                            EntityType.WINDOWS_REGISTRY,
//                            "oval:org.mitre.oval:obj:717",
//                            "oval:org.mitre.oval:ste:2827"
//                        },
//
//                        // windows : Metabase test
//                        {
//                            "test/data/definition/sample_oval-test-metabase.xml",
//                            "oval:org.mitre.oval:tst:709",
//                            2,
//                            "Negotiate is enabled",
//                            Existence.AT_LEAST_ONE_EXISTS,
//                            Check.AT_LEAST_ONE,
//                            EntityType.WINDOWS_METABASE,
//                            "oval:org.mitre.oval:obj:556",
//                            null
//                        },
//
//                        // windows : File test
//                        {
//                            "test/data/definition/sample_oval-test-file.xml",
//                            "oval:org.mitre.oval:tst:2339",
//                            1,
//                            "the version of mshtml.dll is less than 6.0.2900.2873",
//                            Existence.AT_LEAST_ONE_EXISTS,
//                            Check.AT_LEAST_ONE,
//                            EntityType.WINDOWS_FILE,
//                            "oval:org.mitre.oval:obj:222",
//                            "oval:org.mitre.oval:ste:2190"
//                        },
//

                        // windows : File test, 2 states
                        {
                            Test.class,
                            "test/data/definitions/test_file_oval-tst-10629-1.xml",
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

                        // linux : RpmInfo test
                        {
                            Test.class,
                            "test/data/definitions/test_rpminfo_rhsa-tst-20100061002-301.xml",
                            "oval_definitions/tests/linux:rpminfo_test",
                            new RpmInfoTest( "oval:com.redhat.rhsa:tst:20100061002",
                                            301,
                                            "gzip is earlier than 0:1.3.5-11.el5_4.1",
                                            Check.AT_LEAST_ONE )
                                .object( "oval:com.redhat.rhsa:obj:20100061002" )
                                .state( "oval:com.redhat.rhsa:ste:20100061004" )
                        }
//                        {
//                            "test/data/definition/sample_oval-test-rpminfo.xml",
//                            "oval:com.redhat.rhsa:tst:20100061002",
//                            301,
//                            "gzip is earlier than 0:1.3.5-11.el5_4.1",
//                            Test.DEFAULT_CHECK_EXISTENCE,
//                            Check.AT_LEAST_ONE,
//                            EntityType.LINUX_RPMINFO,
//                            "oval:com.redhat.rhsa:obj:20100061002",
//                            "oval:com.redhat.rhsa:ste:20100061004"
//                        },
//
//                        // linux : DpkgInfo test
//                        {
//                            "test/data/definition/sample_oval-test-dpkginfo.xml",
//                            "oval:org.mitre.oval:tst:19402",
//                            1,
//                            "apache2-src is earlier than 2.2.9-10+lenny6",
//                            Existence.AT_LEAST_ONE_EXISTS,
//                            Check.ALL,
//                            EntityType.LINUX_DPKGINFO,
//                            "oval:org.mitre.oval:obj:10286",
//                            "oval:org.mitre.oval:ste:6372"
//                        }
        };
    }

    //==============================================================
    //  Test
    //==============================================================

    /**
     */
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
        Reporter.log( "\n////////////////////////////////", true );
        Reporter.log( "  * object type: " + type, true );

        T  object = _readObjectFromXmlFile( type, filepath, xpath, expected );
        Assert.assertNotNull( object );

        _syncOvalEntity( type, object );
    }

}
// DefinitionsTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

