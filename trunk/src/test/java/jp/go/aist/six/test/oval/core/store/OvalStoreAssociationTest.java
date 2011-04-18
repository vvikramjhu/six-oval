package jp.go.aist.six.test.oval.core.store;

import jp.go.aist.six.oval.core.store.OvalDefinitionsDefinitionAssociationEntry;
import jp.go.aist.six.test.oval.core.CoreTestBase;
import jp.go.aist.six.test.oval.core.Validators;
import jp.go.aist.six.util.persist.AssociationEntry;
import org.testng.Assert;
import org.testng.Reporter;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalStoreAssociationTest
    extends CoreTestBase
{

    /**
     */
    public OvalStoreAssociationTest()
    {
    }



    /**
     */
    protected <K, L, M, T extends AssociationEntry<K, L, M>>
    void _testStoreCreateIfNotExistAssoc(
                    final Class<T> type,
                    final T actual
                    )
    throws Exception
    {
        Reporter.log( "\n////////////////////////////////////////////////////////////////", true );
        Reporter.log( "  * type: " + type, true );
        Reporter.log( "  * object: " + actual, true );

        Assert.assertNotNull( actual );

        Reporter.log( "sync..." , true );
        long  time = System.currentTimeMillis();
        T  p_object = _getStore().sync( type, actual );
        K  pid = p_object.getPersistentID();
        Reporter.log( "...sync done: " + (System.currentTimeMillis() - time) + "(ms)", true );
        Reporter.log( "  @ pid=" + pid, true );

        Reporter.log( "load...", true );
        Reporter.log( "  - pid=" + pid, true );
        time = System.currentTimeMillis();
        T  persistent2 = _getStore().load( type, pid );
        Reporter.log( "...load done: " + (System.currentTimeMillis() - time) + "(ms)", true );
        Reporter.log( "  @ object=" + persistent2, true );

        Reporter.log( "sync..." , true );
        time = System.currentTimeMillis();
        T  persistent = _getStore().sync( type, persistent2 );
        Reporter.log( "...sync done: " + (System.currentTimeMillis() - time) + "(ms)", true );
        pid = persistent.getPersistentID();
        Reporter.log( "  @ pid=" + pid, true );

        Reporter.log( "validating...", true );
        Validators.validator( type ).equals( persistent2, actual );
        Reporter.log( "...validation OK", true );
    }



    //==============================================================
    //  oval_definitions - definition assoc.
    //==============================================================

    @org.testng.annotations.Test(
                    groups={"oval.core.store", "definitions.assoc__oval_definitions__definition"},
                    alwaysRun=true
                    )
    public void testDefinitionsOvalDefinitionsDefinitionAssociationEntry(
                    )
    throws Exception
    {
        OvalDefinitionsDefinitionAssociationEntry  assoc =
            new OvalDefinitionsDefinitionAssociationEntry(
                            "aaaaaaaa-bbbb-cccc-9999-888888888888",
                            "oval:org.mitre.oval:def:9999:1"
                            );
        _testStoreCreateIfNotExistAssoc( OvalDefinitionsDefinitionAssociationEntry.class, assoc );
    }

}
// OvalStoreAssociationTest

