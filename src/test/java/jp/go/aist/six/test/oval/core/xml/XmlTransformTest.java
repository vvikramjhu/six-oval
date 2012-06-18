package jp.go.aist.six.test.oval.core.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import jp.go.aist.six.oval.core.OvalContext;
import jp.go.aist.six.util.xml.XmlTransformer;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class XmlTransformTest
{

    private XmlTransformer  _transformer;



    /**
     */
    public XmlTransformTest()
    {
    }



    /**
     */
    @BeforeClass( alwaysRun=true )
    public void setUp()
    throws Exception
    {
        OvalContext  context = new OvalContext();
        _transformer = context.getBean( "oval-XmlTransformer", XmlTransformer.class );
    }



    ///////////////////////////////////////////////////////////////////////
    // test data
    ///////////////////////////////////////////////////////////////////////

    @DataProvider( name="oval.definitions.xml.transform" )
    public Object[][] provideOvalResultsXml()
    {
        return new Object[][] {
                        {
                            "test/resources/OvalTestContent/5.10/linux/unix-def_file_test.xml",
                            "transformed_unix-def_file_test.xml"
                        }
                        ,
                        {
                            "test/resources/OvalTestContent/5.10/linux/unix-def_interface_test.xml",
                            "transformed_unix-def_interface_test.xml"
                        }
                        ,
                        {
                            "test/resources/OvalTestContent/5.10/linux/unix-def_process_test.xml",
                            "transformed_unix-def_process_test.xml"
                        }
                        ,
                        {
                            "test/resources/OvalTestContent/5.10/linux/unix-def_process58_test.xml",
                            "transformed_unix-def_process58_test.xml"
                        }
                        ,
                        {
                            "test/resources/OvalTestContent/5.10/windows/win-def_file_test.xml",
                            "transformed_win-def_file_test.xml"
                        }
                        ,
                        {
                            "test/resources/OvalTestContent/5.10/windows/win-def_interface_test.xml",
                            "transformed_win-def_interface_test.xml"
                        }
                        ,
                        {
                            "test/resources/OvalTestContent/5.10/windows/win-def_process_test.xml",
                            "transformed_win-def_process_test.xml"
                        }
                        ,
                        {
                            "test/resources/OvalTestContent/5.10/windows/win-def_process58_test.xml",
                            "transformed_win-def_process58_test.xml"
                        }
        };
    }



    ///////////////////////////////////////////////////////////////////////
    // test methods
    ///////////////////////////////////////////////////////////////////////

    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "oval.definitions.oval_definitions"},
                    dataProvider="oval.definitions.xml.transform",
                    alwaysRun=true
                    )
    public void testTransform(
                    final String sourceFilepath,
                    final String resultFilepath
                    )
    throws Exception
    {
        Reporter.log( "\n////////////////////////////////////////////", true );

        _transformer.transform(
                        new FileInputStream( new File( sourceFilepath ) ),
                        new FileOutputStream( new File( resultFilepath ) ) );
    }

}
//
