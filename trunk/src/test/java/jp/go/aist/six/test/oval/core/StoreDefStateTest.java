package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.model.ComponentType;
import jp.go.aist.six.oval.model.definition.State;
import org.testng.Assert;
import org.testng.Reporter;



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

//        Reporter.log( "syncing object...", true );
//        State  p = _getStore().sync( State.class, obj );
//        Reporter.log( "...sync done", true );
//        String  pid = p.getPersistentID();
//        Reporter.log( "  @ synced: pid=" + pid, true );
//
//
//        Reporter.log( "finding object by ID...", true );
//        RelationalBinding  idFilter = RelationalBinding.equalBinding( "persistentID", pid );
//        List<State>  entities = _getStore().find( State.class, idFilter );
//        Reporter.log( "...find done", true );
//        State  p3 = entities.get( 0 );
//        Reporter.log( "  @ find by ID: object=" + p3, true );
//        Assert.assertEquals( p3.getOvalID(), p3.getOvalID() );
//        Assert.assertEquals( p3.getOvalVersion(), p3.getOvalVersion() );
//
//
//        Reporter.log( "getting object...", true );
//        State  p2 = _getStore().get( State.class, pid );
//        Reporter.log( "...get done", true );
//        Reporter.log( "  @ get: object=" + p2, true );
//        Assert.assertEquals( p2.getOvalID(), p2.getOvalID() );
//        Assert.assertEquals( p2.getOvalVersion(), p2.getOvalVersion() );

    }

}
// OvalStoreTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

