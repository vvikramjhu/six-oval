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
    }

}
// OvalStoreTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

