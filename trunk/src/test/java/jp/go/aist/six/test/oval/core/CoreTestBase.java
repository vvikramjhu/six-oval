package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.core.service.StandardOvalService;
import jp.go.aist.six.oval.core.store.OvalStore;
import jp.go.aist.six.oval.core.xml.OvalXml;
import jp.go.aist.six.oval.model.common.Generator;
import jp.go.aist.six.oval.model.system.EntityItemString;
import jp.go.aist.six.oval.model.system.NetworkInterface;
import jp.go.aist.six.oval.model.system.Status;
import jp.go.aist.six.oval.model.system.SystemInfo;
import jp.go.aist.six.oval.model.windows.EntityItemRegistryHive;
import jp.go.aist.six.oval.model.windows.RegistryHive;
import jp.go.aist.six.oval.model.windows.RegistryItem;
import jp.go.aist.six.util.IsoDate;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import java.util.Arrays;
import java.util.Collection;



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

    private static final Collection<NetworkInterface> _WINDWS_NETWORK_INTERFACES_
    = Arrays.asList( new NetworkInterface[] {
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
    } );



    //==============================================================
    //  oval_system_characteristics
    //==============================================================

    @DataProvider( name="oval-sc-oval_system_characteristics" )
    public Object[][] ovalScOvalSystemCharacteristicsData()
    {
        return new Object[][] {
                        {
                            "oval-sc:oval_system_characteristics",
                            "test/data/sc/oval-sc.oval_system_characteristics.1-windows-minimal.xml",
                            new Generator( "5.6", IsoDate.valueOf( "2010-05-12T20:27:08" ), "OVAL Definition Interpreter", "5.6 Build: 4" ),
                            new SystemInfo(
                                            "Microsoft Windows XP Professional Service Pack 3",
                                            "5.1.2600",
                                            "INTEL32",
                                            "x60",
                                            _WINDWS_NETWORK_INTERFACES_
                                            )
                        }
                        ,
                        {
                            "oval-sc:oval_system_characteristics",
                            "test/data/sc/oval-sc.ocal_system_characteristics.2-windows.xml",
                            new Generator( "5.6", IsoDate.valueOf( "2010-05-12T20:27:08" ), "OVAL Definition Interpreter", "5.6 Build: 4" ),
                            new SystemInfo(
                                            "Microsoft Windows XP Professional Service Pack 3",
                                            "5.1.2600",
                                            "INTEL32",
                                            "x60",
                                            _WINDWS_NETWORK_INTERFACES_
                                            )
                        }
        };

    }



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
                            new SystemInfo(
                                            "Microsoft Windows XP Professional Service Pack 3",
                                            "5.1.2600",
                                            "INTEL32",
                                            "x60",
                                            _WINDWS_NETWORK_INTERFACES_
                                            )
                        }
        };

    }



    //==============================================================
    //  item
    //==============================================================

    @DataProvider( name="oval-sc-item" )
    public Object[][] ovalScItemData()
    {
        return new Object[][] {
                        {
                            "oval-sc#windows:registry_item",
                            "test/data/sc/oval-sc.item.registry_item.1.xml",
                            new RegistryItem(
                                            83,
                                            Status.DOES_NOT_EXIST,
                                            new EntityItemRegistryHive( RegistryHive.HKEY_LOCAL_MACHINE.name() ),
                                            new EntityItemString(
                                                            "SOFTWARE\\Microsoft\\Updates\\Visual Studio\\7.0\\S895309",
                                                            EntityItemString.DEFAULT_DATATYPE,
                                                            Status.DOES_NOT_EXIST
                                                            ),
                                            null,
                                            null,
                                            null
                                            )
                        }
        };

    }
}
// OvalServiceTestBase

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

