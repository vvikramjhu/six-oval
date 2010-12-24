package jp.go.aist.six.test.oval.core.store;

import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.definitions.State;
import jp.go.aist.six.oval.model.definitions.SystemObject;
import jp.go.aist.six.oval.model.definitions.Test;
import jp.go.aist.six.oval.model.definitions.Variable;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import jp.go.aist.six.test.oval.core.CoreTestBase;
import jp.go.aist.six.util.persist.Persistable;
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



    /**
     */
    protected <K, T extends Persistable<K>>
    K _testStoreSync(
                    final Class<T> type,
                    final String filepath,
                    final String xpath,
                    final T expected
                    )
    throws Exception
    {
        Reporter.log( "\n////////////////////////////////////////////////////////////////", true );
        Reporter.log( "  * object type: " + type, true );

        final T  actual = _unmarshalWithValidation( type, filepath, xpath, expected );
        Assert.assertNotNull( actual );

        Reporter.log( "sync..." , true );
        long  time = System.currentTimeMillis();
        T  p_object = _getStore().sync( type, actual );
        K  p_id = p_object.getPersistentID();
        Reporter.log( "...sync done: " + (System.currentTimeMillis() - time) + "(ms)", true );
        Reporter.log( "  @ pid=" + p_id, true );

        Reporter.log( "load...", true );
        Reporter.log( "  - pid=" + p_id, true );
        time = System.currentTimeMillis();
        p_object = _getStore().load( type, p_id );
        Reporter.log( "...load done: " + (System.currentTimeMillis() - time) + "(ms)", true );
        Reporter.log( "  @ object=" + p_object, true );
        Reporter.log( "  @ object type=" + p_object.getClass().getName(), true );

//        Reporter.log( "validating...", true );
//        Validators.validator( type ).equals( p_object, expected );
//        Reporter.log( "...validation OK", true );

//        Reporter.log( "sync..." , true );
//        time = System.currentTimeMillis();
//        T  p_object2 = _getStore().sync( type, p_object ); //object got in another tx
//        Reporter.log( "...sync done: " + (System.currentTimeMillis() - time) + "(ms)", true );
//        p_id = p_object2.getPersistentID();
//        Reporter.log( "  @ object=" + p_object2, true );

        return p_id;
    }



    //==============================================================
    //  oval_definitions
    //==============================================================

    @org.testng.annotations.Test(
                    groups={"oval.core.store", "definitions.oval_definitions"},
                    dataProvider="definitions.oval_definitions",
                    alwaysRun=true
                    )
    public void testDefinitionsOvalDefinitions(
                    final Class<OvalDefinitions> type,
                    final String filepath,
                    final String xpath,
                    final OvalDefinitions expected
                    )
    throws Exception
    {
        _testStoreSync( type, filepath, xpath, expected );
    }


    @org.testng.annotations.Test(
                    groups={"oval.core.store.get"},
                    dataProvider="definitions.oval_definitions",
                    alwaysRun=true
                    )
    public void testStoreGetOvalDefinitions(
                    )
    throws Exception
    {
        Class<OvalDefinitions>  type = OvalDefinitions.class;
        Reporter.log( "\n////////////////////////////////////////////////////////////////", true );
        Reporter.log( "  * object type: " + type, true );
        OvalDefinitions  persistent = _getStore().load( type, "aaad34e4-2835-4c6e-9397-15deb3ae8bcc" );
        Reporter.log( "  @ get: object=" + persistent, true );
    }



    //==============================================================
    //  definition
    //==============================================================

    @org.testng.annotations.Test(
                    groups={"oval.core.store", "definitions.definition"},
                    dataProvider="definitions.definition",
                    alwaysRun=true
                    )
    public <T extends Definition> void testDefinitionsDefinition(
                    final Class<T> type,
                    final String filepath,
                    final String xpath,
                    final T expected
                    )
    throws Exception
    {
        _testStoreSync( type, filepath, xpath, expected );
    }



    //==============================================================
    //  test
    //==============================================================

    @org.testng.annotations.Test(
                    groups={"oval.core.store", "definitions.test"},
                    dataProvider="definitions.test",
                    alwaysRun=true
                    )
    public <T extends Test> void testStoreDefinitionsTest(
                    final Class<Test> type,
                    final String sourceFilepath,
                    final String xpath,
                    final T expected
                    )
    throws Exception
    {
        String  p_id = _testStoreSync( type, sourceFilepath, xpath, expected );

        Test  p_test = _getStore().load( type, p_id );

        // update
        p_test.setComment( "modified comment" );
        Reporter.log( "update..." , true );
        long  time = System.currentTimeMillis();
//        _getStore().sync( type, p_test );
        _getStore().update( type, p_test );
        p_id = p_test.getPersistentID();
        Reporter.log( "...update done: " + (System.currentTimeMillis() - time) + "(ms)", true );
        Reporter.log( "  @ pid=" + p_id, true );

        Reporter.log( "load...", true );
        Reporter.log( "  - pid=" + p_id, true );
        time = System.currentTimeMillis();
        Test  p_object = _getStore().load( type, p_id );
        Reporter.log( "...load done: " + (System.currentTimeMillis() - time) + "(ms)", true );
        Reporter.log( "  @ object=" + p_object, true );
        Reporter.log( "  @ entity type=" + p_object.getEntityType(), true );
        Reporter.log( "  @ object type=" + p_object.getClass().getName(), true );
    }



    //==============================================================
    //  object
    //==============================================================

    @org.testng.annotations.Test(
                    groups={"oval.core.store", "definitions.object"},
                    dataProvider="definitions.object",
                    alwaysRun=true
                    )
    public <T extends SystemObject> void testDefinitionsObject(
                    final Class<T> type,
                    final String sourceFilepath,
                    final String xpath,
                    final T expected
                    )
    throws Exception
    {
        _testStoreSync( type, sourceFilepath, xpath, expected );
    }



    //==============================================================
    //  state
    //==============================================================

    @org.testng.annotations.Test(
                    groups={"oval.core.store", "definitions.state"},
                    dataProvider="definitions.state",
                    alwaysRun=true
                    )
    public <T extends State> void testDefinitionsState(
                    final Class<T> type,
                    final String sourceFilepath,
                    final String xpath,
                    final T expected
                    )
    throws Exception
    {
        _testStoreSync( type, sourceFilepath, xpath, expected );
    }



    //==============================================================
    //  variable
    //==============================================================

    @org.testng.annotations.Test(
                    groups={"oval.core.store", "definitions.variable"},
                    dataProvider="definitions.variable",
                    alwaysRun=true
                    )
    public <T extends Variable> void testDefinitionsVariable(
                    final Class<T> type,
                    final String sourceFilepath,
                    final String xpath,
                    final T expected
                    )
    throws Exception
    {
        _testStoreSync( type, sourceFilepath, xpath, expected );
    }



    //==============================================================
    //  oval_system_characteristics
    //==============================================================

    @org.testng.annotations.Test(
                    groups={"oval.core.store", "sc.oval_sc"},
                    dataProvider="sc.oval_sc",
                    alwaysRun=true
                    )
    public void testSCOvalSC(
                    final Class<OvalSystemCharacteristics> type,
                    final String filepath,
                    final String xpath,
                    final OvalSystemCharacteristics expected
                    )
    throws Exception
    {
        _testStoreSync( type, filepath, xpath, expected );
    }



    //==============================================================
    //  oval_results
    //==============================================================

    @org.testng.annotations.Test(
                    groups={"oval.core.store", "results.oval_results"},
                    dataProvider="results.oval_results",
                    alwaysRun=true
                    )
    public void testResultsOvalResults(
                    final Class<OvalResults> type,
                    final String filepath,
                    final String xpath,
                    final OvalResults expected
                    )
    throws Exception
    {
        _testStoreSync( type, filepath, xpath, expected );
    }

}
// OvalStoreTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

