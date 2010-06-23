package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.model.common.Generator;
import jp.go.aist.six.oval.model.system.Item;
import jp.go.aist.six.oval.model.system.NetworkInterface;
import jp.go.aist.six.oval.model.system.OvalSystemCharacteristics;
import jp.go.aist.six.oval.model.system.SystemData;
import jp.go.aist.six.oval.model.system.SystemInfo;
import jp.go.aist.six.oval.model.windows.FileItem;
import jp.go.aist.six.oval.model.windows.RegistryItem;
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
                    final SystemData actual,
                    final SystemData expected
                    )
    {
        Assert.assertEquals( actual, expected );
    }



    //Item
    private void _validate(
                    final Item actual,
                    final Item expected
                    )
    {
        Reporter.log( " - ID", true );
        Assert.assertEquals( actual.getID(), expected.getID() );
        Reporter.log( " - status", true );
        Assert.assertEquals( actual.getStatus(), expected.getStatus() );

        if (expected instanceof RegistryItem) {
            _validate( RegistryItem.class.cast( actual ), RegistryItem.class.cast( expected ) );
        } else if (expected instanceof FileItem) {
            _validate( FileItem.class.cast( actual ), FileItem.class.cast( expected ) );
        }
    }


    //RegistryItem
    private void _validate(
                    final RegistryItem actual,
                    final RegistryItem expected
                    )
    {
        Reporter.log( " - hive", true );
        Assert.assertEquals( actual.getHive(), expected.getHive() );
        Reporter.log( " - key", true );
        Assert.assertEquals( actual.getKey(), expected.getKey() );
        Reporter.log( " - name", true );
        Assert.assertEquals( actual.getName(), expected.getName() );
        Reporter.log( " - type", true );
        Assert.assertEquals( actual.getType(), expected.getType() );
        Reporter.log( " - value", true );
        Assert.assertEquals( actual.getValue(), expected.getValue() );
    }


    //FileItem
    private void _validate(
                    final FileItem actual,
                    final FileItem expected
                    )
    {
        Reporter.log( " - filepath", true );
        Assert.assertEquals( actual.getFilepath(), expected.getFilepath() );
        Reporter.log( " - path", true );
        Assert.assertEquals( actual.getPath(), expected.getPath() );
        Reporter.log( " - filename", true );
        Assert.assertEquals( actual.getFilename(), expected.getFilename() );
        Reporter.log( " - owner", true );
        Assert.assertEquals( actual.getOwner(), expected.getOwner() );
        Reporter.log( " - size", true );
        Assert.assertEquals( actual.getSize(), expected.getSize() );
        Reporter.log( " - aTime", true );
        Assert.assertEquals( actual.getATime(), expected.getATime() );
        Reporter.log( " - cTime", true );
        Assert.assertEquals( actual.getCTime(), expected.getCTime() );
        Reporter.log( " - mTime", true );
        Assert.assertEquals( actual.getMTime(), expected.getMTime() );
        Reporter.log( " - msChecksum", true );
        Assert.assertEquals( actual.getMsChecksum(), expected.getMsChecksum() );
        Reporter.log( " - version", true );
        Assert.assertEquals( actual.getVersion(), expected.getVersion() );
        Reporter.log( " - type", true );
        Assert.assertEquals( actual.getType(), expected.getType() );
        Reporter.log( " - developmentClass", true );
        Assert.assertEquals( actual.getDevelopmentClass(), expected.getDevelopmentClass() );
        Reporter.log( " - company", true );
        Assert.assertEquals( actual.getCompany(), expected.getCompany() );
        Reporter.log( " - internalName", true );
        Assert.assertEquals( actual.getInternalName(), expected.getInternalName() );
        Reporter.log( " - language", true );
        Assert.assertEquals( actual.getLanguage(), expected.getLanguage() );
        Reporter.log( " - originalFilename", true );
        Assert.assertEquals( actual.getOriginalFilename(), expected.getOriginalFilename() );
        Reporter.log( " - productName", true );
        Assert.assertEquals( actual.getProductName(), expected.getProductName() );
        Reporter.log( " - productVersion", true );
        Assert.assertEquals( actual.getProductVersion(), expected.getProductVersion() );
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

}
// OvalXmlTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

