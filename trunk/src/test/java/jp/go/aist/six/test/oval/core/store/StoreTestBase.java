package jp.go.aist.six.test.oval.core.store;

import jp.go.aist.six.test.oval.core.CoreTestBase;
import jp.go.aist.six.test.oval.core.Validators;
import jp.go.aist.six.util.orm.Persistable;
import org.testng.Assert;
import org.testng.Reporter;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class StoreTestBase
    extends CoreTestBase
{

    /**
     */
    public StoreTestBase()
    {
    }



    /**
     */
    protected <K, T extends Persistable<K>> void _testStoreSync(
                    final Class<T> type,
                    final String filepath,
                    final String xpath,
                    final T expected
                    )
    throws Exception
    {
        Reporter.log( "\n////////////////////////////////////////////////////////////////", true );
        Reporter.log( "  * object type: " + type, true );

        T  actual = _readObjectFromXmlFile( type, filepath, xpath, expected );
        Assert.assertNotNull( actual );

        Reporter.log( "sync..." , true );
        long  time = System.currentTimeMillis();
        T  persistent = _getStore().sync( type, actual );
        Reporter.log( "...sync done: " + (System.currentTimeMillis() - time) + "(ms)", true );

        K  pid = persistent.getPersistentID();
        Reporter.log( "  @ pid=" + pid, true );

        Reporter.log( "get...", true );
        Reporter.log( "  - pid=" + pid, true );
        time = System.currentTimeMillis();
        T  persistent2 = _getStore().get( type, pid );
        Reporter.log( "...get done: " + (System.currentTimeMillis() - time) + "(ms)", true );

        Reporter.log( "  @ get: object=" + persistent2, true );
        Reporter.log( "validating...", true );
        Validators.validator( type ).equals( persistent2, expected );
        Reporter.log( "...validation OK", true );
    }

}
// StoreTestBase

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

