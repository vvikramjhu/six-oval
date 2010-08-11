package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.model.EntityType;
import jp.go.aist.six.oval.model.common.Generator;
import jp.go.aist.six.oval.model.definitions.Definitions;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.definitions.SystemObject;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import jp.go.aist.six.oval.model.sc.SystemInfo;
import org.testng.Assert;
import org.testng.Reporter;
import java.util.Collection;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalStoreTest
    extends CoreTestBase
{

    public static void main( final String[] args )
    throws Exception
    {
        OvalStoreTest  test = new OvalStoreTest();
        test.setUp();
        test.testAll();
    }



    /**
     */
    public OvalStoreTest()
    {
    }



    public void testAll()
    throws Exception
    {
//        Object[][]  data = ovalDefObjectProvider();
//        for (int  i = 0; i < data.length; i++) {
//            testObject(
//                        (ComponentType)data[i][0],
//                        (String)data[i][1],
//                        (String)data[i][2],
//                        (Integer)data[i][3],
//                        (String)data[i][4]
//                        );
//        }
    }


    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //
    //  System Characteristics
    //
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    //==============================================================
    //  oval_system_characteristics
    //==============================================================

    /**
     */
    @org.testng.annotations.Test(
                    groups={"oval.core.store", "oval-sc:oval_system_characteristics"},
                    dataProvider="oval-sc-oval_system_characteristics",
                    alwaysRun=true
                    )
    public void processOvalSystemCharacteristics(
                    final String testTarget,
                    final String filepath,
                    final Generator generator,
                    final SystemInfo  systemInfo
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL XML //", true );
        Reporter.log( "  * target type: " + testTarget, true );

        OvalSystemCharacteristics  sc = _unmarshalFile( filepath, OvalSystemCharacteristics.class );

        Reporter.log( "validating...", true );
        _validate( sc.getGenerator(), generator );
        _validate( sc.getSystemInfo(), systemInfo);
        Reporter.log( "...validation OK", true );

        _getStore().sync( OvalSystemCharacteristics.class, sc );
    }





    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //
    //  Definitions
    //
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    //==============================================================
    //  object
    //==============================================================

    /**
     */
    @org.testng.annotations.Test(
                    groups={"oval.service", "oval-def:object"},
                    dataProvider="oval-def-object",
                    dependsOnGroups="test",
                    alwaysRun=true
                    )
    public void testObject(
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
        Assert.assertEquals( obj.getEntityType(), type );
        Assert.assertEquals( obj.getComment(), comment );

        _syncOvalEntity( SystemObject.class, obj );

        Collection<SystemObject>  all = _getStore().getAll( SystemObject.class );
        Reporter.log( "  @ all object: #objects=" + all.size(), true );
        for (SystemObject  o : all) {
            Reporter.log( "  @ object: " + o, true );
        }
    }



    //==============================================================
    //  oval_definitions
    //==============================================================

    /**
     */
    @org.testng.annotations.Test(
                    groups={"oval.core.store", "oval-def:oval_definitions"},
                    dataProvider="oval-def-oval_definitions",
                    alwaysRun=true
                    )
    public void testOvalDefinitions(
                    final String testTarget,
                    final String filepath,
                    final Generator generator,
                    final Definitions definitions
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL Store //", true );
        Reporter.log( "  * target type: " + testTarget, true );

        OvalDefinitions  ovalDefs = _unmarshalFile( filepath, OvalDefinitions.class );

        Reporter.log( "validating...", true );
        _validate( ovalDefs.getGenerator(), generator );
        _validate( ovalDefs.getDefinitions(), definitions );
        Reporter.log( "...validation OK", true );

        _getStore().sync( OvalDefinitions.class, ovalDefs );
    }


}
// OvalStoreTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

