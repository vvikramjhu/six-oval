package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.core.model.ComponentType;
import jp.go.aist.six.oval.model.OvalEntity;
import jp.go.aist.six.oval.model.common.Generator;
import jp.go.aist.six.oval.model.definition.Definitions;
import jp.go.aist.six.oval.model.definition.OvalDefinitions;
import jp.go.aist.six.oval.model.definition.State;
import org.testng.Assert;
import org.testng.Reporter;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalStoreTest
    extends CoreTestBase
{

    /**
     */
    public OvalStoreTest()
    {
    }


    private <T extends OvalEntity> void _syncOvalEntity(
                    final Class<T> type,
                    final T e
                    )
    throws Exception
    {
        Reporter.log( "syncing object...", true );
        T  p = _getStore().sync( type, e );
        Reporter.log( "...sync done", true );
        String  pid = p.getPersistentID();
        Reporter.log( "  @ synced: pid=" + pid, true );

        Reporter.log( "getting object...", true );
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
    //  state
    //==============================================================

    @org.testng.annotations.Test( groups={"oval.service", "oval-def:state"},
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



}
// OvalStoreTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

