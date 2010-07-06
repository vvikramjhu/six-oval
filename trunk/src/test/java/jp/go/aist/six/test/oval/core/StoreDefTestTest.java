package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.model.ComponentType;
import jp.go.aist.six.oval.model.common.Check;
import jp.go.aist.six.oval.model.common.Existence;
import jp.go.aist.six.oval.model.definition.Test;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class StoreDefTestTest
    extends CoreTestBase
{

    //==============================================================
    //  test
    //==============================================================

    @DataProvider( name="oval-def-test" )
    public Object[][] ovalDefTestProvider()
    {
        return new Object[][] {
                        // independent : family test
                        {
                            ComponentType.INDEPENDENT_FAMILY,
                            "test/data/definition/sample_oval-test-family.xml",
                            "oval:org.mitre.oval:tst:99",
                            1,
                            "the installed operating system is part of the Microsoft Windows family",
                            Existence.AT_LEAST_ONE_EXISTS,
                            Check.ONLY_ONE,
                            "oval:org.mitre.oval:obj:99",
                            "oval:org.mitre.oval:ste:99"
                        }
                        ,

                        // independent : textfilecontent test
                        {
                            ComponentType.INDEPENDENT_TEXTFILECONTENT,
                            "test/data/definition/sample_oval-test-textfilecontent.xml",
                            "oval:org.mitre.oval:tst:11150",
                            1,
                            "Debian GNU/Linux 5.0 is installed",
                            Existence.AT_LEAST_ONE_EXISTS,
                            Check.ALL,
                            "oval:org.mitre.oval:obj:7326",
                            "oval:org.mitre.oval:ste:5739"
                        }
                        ,

                        // independent : unknown test
                        {
                            ComponentType.INDEPENDENT_UNKNOWN,
                            "test/data/definition/sample_oval-test-unknown.xml",
                            "oval:org.mitre.oval:tst:2531",
                            1,
                            "Word 97 is installed",
                            Existence.AT_LEAST_ONE_EXISTS,
                            Check.ALL,
                            null,
                            null
                        }
                        ,

                        // unix : uname test
                        {
                            ComponentType.UNIX_UNAME,
                            "test/data/definition/sample_oval-test-uname.xml",
                            "oval:org.mitre.oval:tst:11195",
                            1,
                            "Installed architecture is mips",
                            Existence.AT_LEAST_ONE_EXISTS,
                            Check.ALL,
                            "oval:org.mitre.oval:obj:2759",
                            "oval:org.mitre.oval:ste:5601"
                        }
                        ,

                        // windows : Registry test
                        {
                            ComponentType.WINDOWS_REGISTRY,
                            "test/data/definition/sample_oval-test-registry.xml",
                            "oval:org.mitre.oval:tst:3019",
                            2,
                            "Win2K/XP/2003/Vista/2008 service pack 2 is installed",
                            Existence.AT_LEAST_ONE_EXISTS,
                            Check.AT_LEAST_ONE,
                            "oval:org.mitre.oval:obj:717",
                            "oval:org.mitre.oval:ste:2827"
                        }
                        ,

                        // windows : Metabase test
                        {
                            ComponentType.WINDOWS_METABASE,
                            "test/data/definition/sample_oval-test-metabase.xml",
                            "oval:org.mitre.oval:tst:709",
                            2,
                            "Negotiate is enabled",
                            Existence.AT_LEAST_ONE_EXISTS,
                            Check.AT_LEAST_ONE,
                            "oval:org.mitre.oval:obj:556",
                            null
                        }
                        ,

                        // windows : File test
                        {
                            ComponentType.WINDOWS_FILE,
                            "test/data/definition/sample_oval-test-file.xml",
                            "oval:org.mitre.oval:tst:2339",
                            1,
                            "the version of mshtml.dll is less than 6.0.2900.2873",
                            Existence.AT_LEAST_ONE_EXISTS,
                            Check.AT_LEAST_ONE,
                            "oval:org.mitre.oval:obj:222",
                            "oval:org.mitre.oval:ste:2190"
                        }
                        ,

                        // linux : RpmInfo test
                        {
                            ComponentType.LINUX_RPMINFO,
                            "test/data/definition/sample_oval-test-rpminfo.xml",
                            "oval:com.redhat.rhsa:tst:20100061002",
                            301,
                            "gzip is earlier than 0:1.3.5-11.el5_4.1",
                            Test.DEFAULT_CHECK_EXISTENCE,
                            Check.AT_LEAST_ONE,
                            "oval:com.redhat.rhsa:obj:20100061002",
                            "oval:com.redhat.rhsa:ste:20100061004"
                        }
                        ,

                        // linux : DpkgInfo test
                        {
                            ComponentType.LINUX_DPKGINFO,
                            "test/data/definition/sample_oval-test-dpkginfo.xml",
                            "oval:org.mitre.oval:tst:19402",
                            1,
                            "apache2-src is earlier than 2.2.9-10+lenny6",
                            Existence.AT_LEAST_ONE_EXISTS,
                            Check.ALL,
                            "oval:org.mitre.oval:obj:10286",
                            "oval:org.mitre.oval:ste:6372"
                        }
        };
    }



    @org.testng.annotations.Test(
                    groups={"oval.service", "oval-def.test"},
                    dataProvider="oval-def-test",
                    alwaysRun=true
                    )
    public void testDefTest(
                    final ComponentType type,
                    final String filepath,
                    final String id,
                    final int version,
                    final String comment,
                    final Existence existence,
                    final Check check,
                    final String objectID,
                    final String stateID
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL Store //", true );
        Reporter.log( "  * object type: " + type, true );

        Test  obj = _unmarshalFile( filepath, Test.class );
        Reporter.log( "  * unmarshalled object: hash=" + obj.hashCode(), true );

        Assert.assertEquals( obj.getOvalID(), id );
        Assert.assertEquals( obj.getOvalVersion(), version );
        Assert.assertEquals( obj.getTestType(), type );

        _syncOvalEntity( Test.class, obj );
    }

}
// StoreDefTestTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

