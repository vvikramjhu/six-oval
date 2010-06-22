package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.model.common.Generator;
import jp.go.aist.six.oval.model.system.Item;
import jp.go.aist.six.oval.model.system.NetworkInterface;
import jp.go.aist.six.oval.model.system.OvalSystemCharacteristics;
import jp.go.aist.six.oval.model.system.SystemInfo;
import org.testng.Assert;
import org.testng.Reporter;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Set;



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



    private void _validate(
                    final Generator actual,
                    final Generator expected
                    )
    {
        Assert.assertEquals( actual.getSchemaVersion(), expected.getSchemaVersion() );
        Assert.assertEquals( actual.getTimestamp(), expected.getTimestamp() );
        Assert.assertEquals( actual.getProductName(), expected.getProductName() );
        Assert.assertEquals( actual.getProductVersion(), expected.getProductVersion() );
    }



    private void _validate(
                    final SystemInfo actual,
                    final SystemInfo expected
                    )
    {
        Assert.assertEquals( actual.getOsName(), expected.getOsName() );
        Assert.assertEquals( actual.getOsVersion(), expected.getOsVersion() );
        Assert.assertEquals( actual.getArchitecture(), expected.getArchitecture() );
        Assert.assertEquals( actual.getPrimaryHostName(), expected.getPrimaryHostName() );

        Set<NetworkInterface>  a_netifs = new HashSet<NetworkInterface>( actual.getInterfaces() );
        Set<NetworkInterface>  e_netifs = new HashSet<NetworkInterface>( expected.getInterfaces() );
        Assert.assertEquals( a_netifs, e_netifs );
    }



    private void _validate(
                    final Item actual,
                    final Item expected
                    )
    {
        Assert.assertEquals( actual.getID(), expected.getID() );
        Assert.assertEquals( actual.getStatus(), expected.getStatus() );
    }



    /**
     */
    protected <T> T _unmarshalFile(
                    final String filepath,
                    final Class<T> type
                    )
    throws Exception
    {
        File  file = new File( filepath );
        Reporter.log( "unmarshalling XML...", true );
        Object  obj = _getXml().unmarshal( new FileInputStream( file ) );
        Reporter.log( "...unmarshalling done", true );
        Reporter.log( "  @ unmarshalled object: " + obj, true );

        Assert.assertTrue( type.isInstance( obj ) );

        return type.cast( obj );
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

}
// OvalXmlTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

