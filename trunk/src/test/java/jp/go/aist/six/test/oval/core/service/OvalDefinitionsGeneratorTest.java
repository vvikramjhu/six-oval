package jp.go.aist.six.test.oval.core.service;

import jp.go.aist.six.oval.core.service.OvalDefinitionsGenerator;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.test.oval.core.CoreTestBase;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import java.util.Arrays;
import java.util.Collection;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalDefinitionsGeneratorTest
    extends CoreTestBase
{


    /**
     */
    public OvalDefinitionsGeneratorTest()
    {
    }



    @DataProvider( name="definitions.definitionIDs" )
    public Object[][] provideOvalDefinitionsDefinition()
    {
        return new Object[][] {
//                        {
//                            new String[] {
//                                            "oval:org.mitre.oval:def:666"
//                            }
//                        }
//                        ,
//                        {
//                            new String[] {
//                                            "oval:org.mitre.oval:def:666",
//                                            "oval:org.mitre.oval:def:305"
//                            }
//                        }
//                        ,
                        {
                            new String[] {
                                            "oval:org.mitre.oval:def:8050"
                            }
                        }
        };
    }



    @org.testng.annotations.Test(
                    groups={"oval.core.service", "OvalDefinitionsGenerator"},
                    dataProvider="definitions.definitionIDs",
                    alwaysRun=true
                    )
    public void testDefinitionsOvalDefinitions(
                    final String[] definitionIDs
                    )
    throws Exception
    {
        Collection<String>  defIDs = Arrays.asList( definitionIDs );
        OvalDefinitionsGenerator  generator = new OvalDefinitionsGenerator();

        Reporter.log( "generating OvalDefinitions...", true );
        OvalDefinitions  ovalDefs = generator.generateIncludingDefinitions( defIDs );
        Reporter.log( "...generation done: " + ovalDefs, true );

        long  timestamp = System.currentTimeMillis();
        String  filename = "generated_" + String.valueOf( timestamp ) + ".xml";
        _marshal( ovalDefs, filename );
    }

}
// OvalDefinitionsGeneratorTest

