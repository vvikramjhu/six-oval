package jp.go.aist.six.test.oval.core.store;

import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.definitions.State;
import jp.go.aist.six.oval.model.definitions.SystemObject;
import jp.go.aist.six.oval.model.definitions.Test;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class StoreDefinitionsTest
    extends StoreTestBase
{

    /**
     */
    public StoreDefinitionsTest()
    {
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

}
// DefinitionsTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

