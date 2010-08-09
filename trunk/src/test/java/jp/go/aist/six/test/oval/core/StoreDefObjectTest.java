package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.model.EntityType;
import jp.go.aist.six.oval.model.definitions.SystemObject;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class StoreDefObjectTest
    extends CoreTestBase
{

    //==============================================================
    //  object
    //==============================================================

    @DataProvider( name="oval-def-object" )
    public Object[][] ovalDefObjectProvider()
    {
        return new Object[][] {
                        {
                            EntityType.INDEPENDENT_FAMILY,
                            "test/data/definition/sample_oval-object-family.xml",
                            "oval:org.mitre.oval:obj:99",
                            1,
                            "This is the default family object. Only one family object should exist."
                        }
                        ,

                        {
                            EntityType.INDEPENDENT_TEXTFILECONTENT,
                            "test/data/definition/sample_oval-object-textfilecontent.xml",
                            "oval:org.mitre.oval:obj:7326",
                            1,
                            null
                        }
                        ,

                        {
                            EntityType.LINUX_DPKGINFO,
                            "test/data/definition/sample_oval-object-dpkginfo.xml",
                            "oval:org.mitre.oval:obj:10648",
                            1,
                            "apache2 package information"
                        }
                        ,

                        {
                            EntityType.LINUX_RPMINFO,
                            "test/data/definition/sample_oval-object-rpminfo.xml",
                            "oval:com.redhat.rhsa:obj:20100061001",
                            301,
                            null
                        }
                        ,

                        {
                            EntityType.UNIX_UNAME,
                            "test/data/definition/sample_oval-object-uname.xml",
                            "oval:org.mitre.oval:obj:2759",
                            1,
                            "The single uname object."
                        }
                        ,

                        {
                            EntityType.WINDOWS_FILE,
                            "test/data/definition/sample_oval-object-file.xml",
                            "oval:org.mitre.oval:obj:222",
                            1,
                            "The path to the mshtml.dll file in the system root"
                        }
                        ,

                        {
                            EntityType.WINDOWS_METABASE,
                            "test/data/definition/sample_oval-object-metabase.xml",
                            "oval:org.mitre.oval:obj:556",
                            2,
                            null
                        }
                        ,

                        {
                            EntityType.WINDOWS_REGISTRY,
                            "test/data/definition/sample_oval-object-registry.xml",
                            "oval:org.mitre.oval:obj:717",
                            1,
                            "This registry key holds the service pack installed on the host if one is present."
                        }
        };
    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={"oval.service", "oval-def.object"},
                    dataProvider="oval-def-object",
                    dependsOnGroups="test",
                    alwaysRun=true
                    )
    public void testDefObject(
                    final EntityType type,
                    final String filepath,
                    final String id,
                    final int version,
                    final String comment
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL - Store //", true );
        Reporter.log( "  * object type: " + type, true );

        SystemObject  obj = _unmarshalFile( filepath, SystemObject.class );

        Assert.assertEquals( obj.getOvalID(), id );
        Assert.assertEquals( obj.getOvalVersion(), version );
        Assert.assertEquals( obj.getObjectType(), type );
        Assert.assertEquals( obj.getComment(), comment );

        _syncOvalEntity( SystemObject.class, obj );

//        Collection<SystemObject>  all = _getStore().getAll( SystemObject.class );
//        Reporter.log( "  @ all object: #objects=" + all.size(), true );
//        for (SystemObject  o : all) {
//            Reporter.log( "  @ object: " + o, true );
//        }
    }

}
// OvalStoreTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

