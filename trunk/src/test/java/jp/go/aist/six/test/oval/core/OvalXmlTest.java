package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.model.system.NetworkInterface;
import jp.go.aist.six.oval.model.system.SystemInfo;
import org.testng.Assert;
import org.testng.Reporter;
import java.io.File;
import java.io.FileInputStream;
import java.util.Collection;



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
                    final String osName,
                    final String osVersion,
                    final String architecture,
                    final String primaryHostName,
                    final NetworkInterface[] netifs
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL XML //", true );
        Reporter.log( "  * target type: " + testTarget, true );

        File  file = new File( filepath );
        Reporter.log( "unmarshalling XML...", true );
        Object  obj = _getXml().unmarshal( new FileInputStream( file ) );
        Reporter.log( "...unmarshalling done", true );
        Reporter.log( "  @ unmarshalled object: " + obj, true );

        Reporter.log( "validating...", true );
        Assert.assertNotNull( obj );
        Assert.assertTrue( obj instanceof SystemInfo);

        SystemInfo  state = SystemInfo.class.cast( obj );
        Assert.assertEquals( osName, state.getOsName() );
        Assert.assertEquals( osVersion, state.getOsVersion() );
        Assert.assertEquals( architecture, state.getArchitecture() );
        Assert.assertEquals( primaryHostName, state.getPrimaryHostName() );
        if (netifs != null) {
            Collection<NetworkInterface>  interfaces = state.getInterfaces().getElements();
            Assert.assertEquals( netifs.length, interfaces.size() );
            for (NetworkInterface  ni : netifs) {
                Assert.assertTrue( interfaces.contains( ni ) );
            }
        }
        Reporter.log( "...validation OK", true );
    }

}
// OvalXmlTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

