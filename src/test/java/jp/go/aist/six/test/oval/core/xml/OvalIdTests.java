package jp.go.aist.six.test.oval.core.xml;

import java.util.ArrayList;
import java.util.Collection;
import jp.go.aist.six.oval.model.common.OvalId;
import jp.go.aist.six.oval.model.common.OvalIdContainer;
import jp.go.aist.six.test.oval.core.OvalCoreTestBase;
import jp.go.aist.six.util.persist.Persistable;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalIdTests
    extends OvalCoreTestBase
{


    ///////////////////////////////////////////////////////////////////////
    //  test data
    ///////////////////////////////////////////////////////////////////////

    @DataProvider( name="DATA.oval.common.OvalId" )
    public Object[][] provideOvalId()
    {
        return new Object[][] {
                        {
                            new String[] {
                                            "oval:org.mitre.oval.test:tst:1303",
                                            "oval:org.mitre.oval.test:obj:1060",
                                            "oval:org.mitre.oval.test:ste:1161",
                                            "oval:org.mitre.oval.test:tst:709",
                                            "oval:org.mitre.oval.test:obj:102",
                                            "oval:org.mitre.oval.test:ste:787"
                            }
                        }
        };

    }




    ///////////////////////////////////////////////////////////////////////
    //  test methods
    ///////////////////////////////////////////////////////////////////////

    /**
     */
    @org.testng.annotations.Test(
                    groups={
                                    "MODEL.oval.OvalId",
                                    "PACKAGE.oval.core.xml",
                                    "CONTROL.xml.unmarshal",
                                    "CONTROL.xml.marshal"
                                    }
                    ,dataProvider="DATA.oval.common.OvalId"
                    ,alwaysRun=true
                    )
    public <K, T extends Persistable<K>>
    void testOvalIdXmlMapping(
                    final String[] oval_id_list
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );

        Collection<OvalId>  oval_id_obj_list = new ArrayList<OvalId>();
        for (String  oval_id_str : oval_id_list) {
            Reporter.log( "  * OVAL ID (String): " + oval_id_str, true );
            OvalId  oval_id_obj = new OvalId( oval_id_str );
            Reporter.log( "  * OVAL ID (OvalId): " + oval_id_obj, true );
            oval_id_obj_list.add( oval_id_obj );

            Reporter.log( ">>> marshalling OvalId...", true );
            String  oval_id_xml = _marshalToString( oval_id_obj );
            Reporter.log( "<<< ...marshalling done", true );
            Reporter.log( "  @ OVAL ID (XML): " + oval_id_xml, true );
        }

        OvalIdContainer  container = new OvalIdContainer( oval_id_obj_list );
        Reporter.log( ">>> marshalling OvalIdContainer...", true );
        String  container_xml = _marshalToString( container );
        Reporter.log( "<<< ...marshalling done", true );
        Reporter.log( "  @ OVAL ID container (XML): " + container_xml, true );
    }

}
//
