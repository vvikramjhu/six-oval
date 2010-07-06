package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.model.common.Generator;
import jp.go.aist.six.oval.model.definition.Definition;
import jp.go.aist.six.oval.model.definition.Definitions;
import jp.go.aist.six.oval.model.definition.OvalDefinitions;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import java.util.Date;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class StoreDefOvalDefinitionsTest
    extends CoreTestBase
{

    //==============================================================
    //  oval_definitions
    //==============================================================

    @DataProvider( name="oval-def-oval_definitions" )
    public Object[][] ovalDefOvalDefinitionsProvider()
    {
//        SimpleDateFormat  format = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss.SSSZ" );
        Date  timestamp = null;
        try {
//            timestamp = format.parse( "2010-06-15T05:04:34.164-0400" );
            timestamp = (new org.exolab.castor.types.DateTime( "2010-06-15T05:04:34.164-04:00" )).toDate();
        } catch (Exception ex) {
            Reporter.log( "ERROR: timestamp parse: " + ex.getMessage(), true );
        }

        return new Object[][] {
//                        {
//                            "oval-def:oval_definitions",
//                            "test/data/definition/oval-def-oval_definitions.0.xml",
//                            new Generator(
//                                            "5.7",
//                                            timestamp,
//                                            "The OVAL Repository",
//                                            null
//                                            ),
//                            new Definitions(
//                                            new Definition[] {
//                                                            DEFINITION_1020_2
//                                            }
//                                            )
//                        }
//                        ,
                        {
                            "oval-def:oval_definitions",
                            "test/data/definition/oval-2010-06-15.05.04.34.xml",
                            new Generator(
                                            "5.7",
                                            timestamp,
                                            "The OVAL Repository",
                                            null
                                            ),
                            new Definitions(
                                            new Definition[] {
                                                            DEFINITION_1020_2
                                            }
                                            )
                        }
        };

    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={"oval.core.store", "oval-def.oval_definitions"},
                    dataProvider="oval-def-oval_definitions",
                    alwaysRun=true
                    )
    public void testOvalDefinitions(
                    final String testTarget,
                    final String filepath,
                    final Generator generator,
                    final Definitions definitions
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL Store //", true );
        Reporter.log( "  * target type: " + testTarget, true );

        OvalDefinitions  ovalDefs = _unmarshalFile( filepath, OvalDefinitions.class );

        Reporter.log( "validating...", true );
        _validate( ovalDefs.getGenerator(), generator );
        _validate( ovalDefs.getDefinitions(), definitions );
        Reporter.log( "...validation OK", true );

        Reporter.log( "syncing...", true );
        OvalDefinitions  p_ovalDefs = _getStore().sync( OvalDefinitions.class, ovalDefs );
        String  pid = p_ovalDefs.getPersistentID();
        Reporter.log( "...syncing done: pid=" + pid, true );
    }

}
// StoreDefOvalDefinitionsTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

