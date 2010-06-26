package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.model.common.Generator;
import jp.go.aist.six.oval.model.result.DefinitionResult;
import jp.go.aist.six.oval.model.result.Directives;
import jp.go.aist.six.oval.model.result.OvalResults;
import jp.go.aist.six.oval.model.result.SystemResult;
import jp.go.aist.six.oval.model.system.CollectedSystemObjects;
import jp.go.aist.six.oval.model.system.Item;
import jp.go.aist.six.oval.model.system.OvalSystemCharacteristics;
import jp.go.aist.six.oval.model.system.SystemData;
import jp.go.aist.six.oval.model.system.SystemInfo;
import org.testng.Reporter;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id: OvalXmlTest.java 764 2010-05-10 08:47:46Z akihito $
 */
public class OvalXmlTest
    extends CoreTestBase
{

    /**
     */
    public OvalXmlTest()
    {
    }



    //==============================================================
    //  oval_system_characteristics
    //==============================================================

    /**
     */
    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "oval-sc:oval_system_characteristics"},
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
    }



    //==============================================================
    //  system_info
    //==============================================================

    /**
     */
    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "oval-sc:system_info"},
                    dataProvider="oval-sc-system_info",
                    alwaysRun=true
                    )
    public void processSystemInfo(
                    final String testTarget,
                    final String filepath,
                    final SystemInfo systemInfo
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL XML //", true );
        Reporter.log( "  * target type: " + testTarget, true );

        SystemInfo  a_systemInfo = _unmarshalFile( filepath, SystemInfo.class );

        Reporter.log( "validating...", true );
        _validate( a_systemInfo, systemInfo);
        Reporter.log( "...validation OK", true );
    }



    //==============================================================
    //  collected_objects
    //==============================================================

    /**
     */
    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "oval-sc:collected_objects"},
                    dataProvider="oval-sc-collected_objects",
                    alwaysRun=true
                    )
    public void processCollectedObjects(
                    final String testTarget,
                    final String filepath,
                    final CollectedSystemObjects expected
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL XML //", true );
        Reporter.log( "  * target type: " + testTarget, true );

        CollectedSystemObjects  actual = _unmarshalFile( filepath, CollectedSystemObjects.class );

        Reporter.log( "validating...", true );
        _validate( actual, expected );
        Reporter.log( "...validation OK", true );
    }



    //==============================================================
    //  system_data
    //==============================================================

    /**
     */
    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "oval-sc:system_data"},
                    dataProvider="oval-sc-system_data",
                    alwaysRun=true
                    )
    public void processSystemData(
                    final String testTarget,
                    final String filepath,
                    final SystemData systemData
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL XML //", true );
        Reporter.log( "  * target type: " + testTarget, true );

        SystemData  a_systemData = _unmarshalFile( filepath, SystemData.class );

        Reporter.log( "validating...", true );
        _validate( a_systemData, systemData );
        Reporter.log( "...validation OK", true );
    }



    //==============================================================
    //  item
    //==============================================================

    /**
     */
    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "oval-sc:item"},
                    dataProvider="oval-sc-item",
                    alwaysRun=true
                    )
    public void processItem(
                    final String testTarget,
                    final String filepath,
                    final Item expectedObject
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL XML //", true );
        Reporter.log( "  * target type: " + testTarget, true );

        Item  actualObject = _unmarshalFile( filepath, Item.class );

        Reporter.log( "validating...", true );
        _validate( actualObject, expectedObject );
        Reporter.log( "...validation OK", true );
    }



    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //
    //  Results
    //
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    //==============================================================
    //  directives
    //==============================================================

    /**
     */
    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "oval-results:directives"},
                    dataProvider="oval-results-directives",
                    alwaysRun=true
                    )
    public void processDirectives(
                    final String testTarget,
                    final String filepath,
                    final Directives expected
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL XML //", true );
        Reporter.log( "  * target type: " + testTarget, true );

        Directives  actual = _unmarshalFile( filepath, Directives.class );

        Reporter.log( "validating...", true );
        _validate( actual, expected );
        Reporter.log( "...validation OK", true );
    }



    //==============================================================
    //  system
    //==============================================================

    /**
     */
    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "oval-results:system"},
                    dataProvider="oval-results-system",
                    alwaysRun=true
                    )
    public void processSystem(
                    final String testTarget,
                    final String filepath,
                    final SystemResult expected
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL XML //", true );
        Reporter.log( "  * target type: " + testTarget, true );

        SystemResult  actual = _unmarshalFile( filepath, SystemResult.class );

        Reporter.log( "validating...", true );
        _validate( actual, expected );
        Reporter.log( "...validation OK", true );
    }



    //==============================================================
    //  oval-res:definition
    //==============================================================

    /**
     */
    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "oval-results:definition"},
                    dataProvider="oval-results-definition",
                    alwaysRun=true
                    )
    public void processDefinitionResult(
                    final String testTarget,
                    final String filepath,
                    final DefinitionResult expected
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL XML //", true );
        Reporter.log( "  * target type: " + testTarget, true );

        DefinitionResult  actual = _unmarshalFile( filepath, DefinitionResult.class );

        Reporter.log( "validating...", true );
        _validate( actual, expected );
        Reporter.log( "...validation OK", true );
    }



    //==============================================================
    //  oval-res:oval_results
    //==============================================================

    /**
     */
    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "oval-results:oval_results"},
                    dataProvider="oval-results-oval_results",
                    alwaysRun=true
                    )
    public void processOvalResults(
                    final String testTarget,
                    final String filepath,
                    final Generator expectedGenerator,
                    final Directives expectedDirectives
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL XML //", true );
        Reporter.log( "  * target type: " + testTarget, true );

        OvalResults  actual = _unmarshalFile( filepath, OvalResults.class );

        Reporter.log( "validating...", true );
        _validate( actual.getGenerator(), expectedGenerator );
        _validate( actual.getDirectives(), expectedDirectives );
        Reporter.log( "...validation OK", true );
    }

}
// OvalXmlTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

