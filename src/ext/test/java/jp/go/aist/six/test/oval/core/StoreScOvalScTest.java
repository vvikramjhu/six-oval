package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.model.common.Generator;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import jp.go.aist.six.oval.model.sc.SystemInfo;
import jp.go.aist.six.util.IsoDate;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class StoreScOvalScTest
    extends CoreTestBase
{

    //==============================================================
    //  oval_system_characteristics
    //==============================================================

    @DataProvider( name="oval-sc-oval_system_characteristics" )
    public Object[][] ovalScOvalSystemCharacteristicsProvider()
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
                                            WINDWS_NETWORK_INTERFACES
                                            )
                        }
                        ,
                        {
                            "oval-sc:oval_system_characteristics",
                            "test/data/sc/oval-sc.oval_system_characteristics.2-windows.xml",
                            new Generator( "5.6", IsoDate.valueOf( "2010-05-12T20:27:08" ), "OVAL Definition Interpreter", "5.6 Build: 4" ),
                            new SystemInfo(
                                            "Microsoft Windows XP Professional Service Pack 3",
                                            "5.1.2600",
                                            "INTEL32",
                                            "x60",
                                            WINDWS_NETWORK_INTERFACES
                                            )
                        }
        };

    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={"oval.core.store", "oval-sc.oval_system_characteristics"},
                    dataProvider="oval-sc-oval_system_characteristics",
                    alwaysRun=true
                    )
    public void testOvalSystemCharacteristics(
                    final String testTarget,
                    final String filepath,
                    final Generator generator,
                    final SystemInfo systemInfo
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL Store //", true );
        Reporter.log( "  * target type: " + testTarget, true );

        OvalSystemCharacteristics  sc = _unmarshalFromFile( filepath, OvalSystemCharacteristics.class );

        Reporter.log( "validating...", true );
        _validate( sc.getGenerator(), generator );
//        _validate( ovalDefs.getDefinitions(), definitions );
        Reporter.log( "...validation OK", true );

        Reporter.log( "syncing...", true );
        OvalSystemCharacteristics  p_sc = _getStore().sync( OvalSystemCharacteristics.class, sc );
        String  pid = p_sc.getPersistentID();
        Reporter.log( "...syncing done: pid=" + pid, true );
    }
}
// StoreScOvalSc

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

