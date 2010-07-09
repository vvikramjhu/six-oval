package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.model.ObjectType;
import jp.go.aist.six.oval.model.definition.State;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class StoreDefStateTest
    extends CoreTestBase
{

    //==============================================================
    //  state
    //==============================================================

    @DataProvider( name="oval-def-state" )
    public Object[][] ovalDefStateProvider()
    {
        return new Object[][] {
//                        {
//                            ComponentType.INDEPENDENT_FAMILY,
//                            "test/data/definition/sample_oval-state-family.xml",
//                            "oval:org.mitre.oval:ste:99",
//                            2
//                        }
//                        ,
//                        {
//                            ComponentType.INDEPENDENT_TEXTFILECONTENT,
//                            "test/data/definition/sample_oval-state-textfilecontent.xml",
//                            "oval:org.mitre.oval:ste:5132",
//                            1
//                        }
//                        ,
                        {
                            ObjectType.WINDOWS_FILE,
                            "test/data/definition/sample_oval-state-file.xml",
                            "oval:org.mitre.oval:ste:2190",
                            1
                        }
//                        ,
//                        {
//                            ComponentType.WINDOWS_METABASE,
//                            "test/data/definition/sample_oval-state-metabase.xml",
//                            "oval:org.mitre.oval:ste:537",
//                            1
//                        }
//                        ,
//                        {
//                            ComponentType.WINDOWS_REGISTRY,
//                            "test/data/definition/sample_oval-state-registry.xml",
//                            "oval:org.mitre.oval:ste:1205",
//                            1
//                        }
//                        ,
//                        {
//                            ComponentType.LINUX_DPKGINFO,
//                            "test/data/definition/sample_oval-state-dpkginfo.xml",
//                            "oval:org.mitre.oval:ste:5797",
//                            1
//                        }
//                        ,
//                        {
//                            ComponentType.LINUX_RPMINFO,
//                            "test/data/definition/sample_oval-state-rpminfo-evr.xml",
//                            "oval:com.redhat.rhsa:ste:20100061004",
//                            301
//                        }
//                        ,
//                        {
//                            ComponentType.LINUX_RPMINFO,
//                            "test/data/definition/sample_oval-state-rpminfo-version.xml",
//                            "oval:com.redhat.rhsa:ste:20100061003",
//                            301
//                        }
//                        ,
//                        {
//                            ComponentType.LINUX_RPMINFO,
//                            "test/data/definition/sample_oval-state-rpminfo-signature_keyid.xml",
//                            "oval:com.redhat.rhsa:ste:20100061002",
//                            301
//                        }
        };
    }



    @org.testng.annotations.Test(
                    groups={"oval.service", "oval-def.state"},
                    dataProvider="oval-def-state",
                    dependsOnGroups="object",
                    alwaysRun=true
                    )
    public void testDefState(
                    final ObjectType type,
                    final String filepath,
                    final String id,
                    final int version
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL Store //", true );
        Reporter.log( "  * object type: " + type, true );

        State  obj = _unmarshalFile( filepath, State.class );

        Assert.assertEquals( obj.getOvalID(), id );
        Assert.assertEquals( obj.getOvalVersion(), version );
        Assert.assertEquals( obj.getObjectType(), type );

        _syncOvalEntity( State.class, obj );
    }

}
// StoreDefStateTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

