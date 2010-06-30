package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.model.ComponentType;
import jp.go.aist.six.oval.model.OvalEntity;
import jp.go.aist.six.oval.model.common.Generator;
import jp.go.aist.six.oval.model.definition.Definitions;
import jp.go.aist.six.oval.model.definition.OvalDefinitions;
import jp.go.aist.six.oval.model.definition.State;
import jp.go.aist.six.oval.model.definition.SystemObject;
import jp.go.aist.six.oval.model.system.OvalSystemCharacteristics;
import jp.go.aist.six.oval.model.system.SystemInfo;
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
        Object[][]  data = ovalDefObjectProvider();
        for (int  i = 0; i < data.length; i++) {
            testObject(
                        (ComponentType)data[i][0],
                        (String)data[i][1],
                        (String)data[i][2],
                        (Integer)data[i][3],
                        (String)data[i][4]
                        );
        }
    }


    /**
     */
    private <T extends OvalEntity> void _syncOvalEntity(
                    final Class<T> type,
                    final T e
                    )
    throws Exception
    {
        Reporter.log( "getting object...", true );
        T  p_eq = _getStore().get( type, e.getPersistentID() );
        Reporter.log( "...get done", true );
        Reporter.log( "  @ persistent object: " + p_eq, true );

        Reporter.log( "finding equaivalent...", true );
        p_eq = _getStore().findEquivalent( type, e );
        Reporter.log( "...find equivalent done", true );
        Reporter.log( "  @ equivalent: " + p_eq, true );

        Reporter.log( "syncing object...", true );
        T  p = _getStore().sync( type, e );
        Reporter.log( "...sync done", true );
        String  pid = p.getPersistentID();
        Reporter.log( "  @ synced: pid=" + pid, true );

        Reporter.log( "getting object...", true );

//        @SuppressWarnings( "unchecked" )
//        T  p2 = (T)_getStore().get( p.getClass(), pid );
        T  p2 = _getStore().get( type, pid );
        Reporter.log( "...get done", true );
        Reporter.log( "  @ get: object=" + p2, true );
        Assert.assertEquals( p2.getOvalID(), e.getOvalID() );
        Assert.assertEquals( p2.getOvalVersion(), e.getOvalVersion() );
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
                    final ComponentType type,
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
        Assert.assertEquals( obj.getSystemObjectType(), type );
        Assert.assertEquals( obj.getComment(), comment );

        _syncOvalEntity( SystemObject.class, obj );

        Collection<SystemObject>  all = _getStore().getAll( SystemObject.class );
        Reporter.log( "  @ all object: #objects=" + all.size(), true );
        for (SystemObject  o : all) {
            Reporter.log( "  @ object: " + o, true );
        }
    }



    //==============================================================
    //  state
    //==============================================================

    @org.testng.annotations.Test(
                    groups={"oval.service", "oval-def:state"},
                    dataProvider="oval-def-state",
                    dependsOnGroups="object",
                    alwaysRun=true
                    )
    public void testState(
                    final ComponentType type,
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
        Assert.assertEquals( obj.getStateType(), type );

        _syncOvalEntity( State.class, obj );
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




}
// OvalStoreTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

