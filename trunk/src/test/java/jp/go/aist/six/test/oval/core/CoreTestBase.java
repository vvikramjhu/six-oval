package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.core.service.StandardOvalService;
import jp.go.aist.six.oval.core.store.OvalStore;
import jp.go.aist.six.oval.core.xml.OvalXml;
import jp.go.aist.six.oval.model.system.NetworkInterface;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id: OvalServiceTestBase.java 778 2010-05-11 06:26:16Z akihito $
 */
public abstract class CoreTestBase
{

    private StandardOvalService  _service = null;



    /**
     */
    public CoreTestBase()
    {
    }



    /**
     */
    @BeforeClass( alwaysRun=true )
    public void setUp()
    throws Exception
    {
        _service = new StandardOvalService();
    }


    protected OvalXml _getXml()
    throws Exception
    {
        return _service.getXml();
    }


    protected OvalStore _getStore()
    throws Exception
    {
        return _service.getStore();
    }



    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //
    //  System Characteristics
    //
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    //==============================================================
    //  system_info
    //==============================================================

    @DataProvider( name="oval-sc-system_info" )
    public Object[][] ovalScSystemInfoData()
    {
        return new Object[][] {
                        {
                            "oval-sc:system_info",
                            "test/data/sc/oval-sc.system_info.1-windows.xml",
                            "Microsoft Windows XP Professional Service Pack 3",
                            "5.1.2600",
                            "INTEL32",
                            "x60",
                            new NetworkInterface[] {
                                            new NetworkInterface(
                                                            "VMware Virtual Ethernet Adapter for VMnet1",
                                                            "192.168.158.1",
                                                            "00-50-56-C0-00-01"
                                                            ),
                                            new NetworkInterface(
                                                            "VMware Virtual Ethernet Adapter for VMnet8",
                                                            "192.168.1.1",
                                                            "00-50-56-C0-00-08"
                                                            )
                            }
                        }
        };

    }

}
// OvalServiceTestBase

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

