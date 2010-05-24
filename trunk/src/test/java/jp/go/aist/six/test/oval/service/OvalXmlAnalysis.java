package jp.go.aist.six.test.oval.service;

import jp.go.aist.six.oval.model.definition.OvalDefinitions;
import jp.go.aist.six.oval.service.Oval;
import jp.go.aist.six.oval.service.OvalXml;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import java.io.File;
import java.io.FileInputStream;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id: OvalXmlAnalysis.java 728 2010-05-07 04:41:03Z akihito $
 */
public class OvalXmlAnalysis
{

    private OvalXml  _xmlMapper = null;



    /**
     */
    public OvalXmlAnalysis()
    {
    }



    /**
     */
    @BeforeClass( alwaysRun=true )
    public void setUp()
    throws Exception
    {
        _xmlMapper = Oval.getXml();
    }



    //**************************************************************
    //  definitions
    //**************************************************************

    /**
     */
    @DataProvider( name="oval-definition" )
    public Object[][] ovalDefinitionsProvider()
    {
        return new Object[][] {
                        { "test/data/oval-vulnerability.xml" },
                        { "test/data/oval-patch.xml" },
                        { "test/data/oval-inventory.xml" },
                        { "test/data/oval-compliance.xml" }
        };
    }



    /**
     * @testng.test groups="oval.xml definition"
     *              dataProvider="oval-definition"
     *              alwaysRun="true"
     */
    @org.testng.annotations.Test( groups={"oval.xml", "definition"},
                    dataProvider="oval-definition",
                    alwaysRun=true
                    )
    public void marshalDefinitionMetadataAffected(
                    final String filepath
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL - analyzing definitions XML //", true );

        File  file = new File( filepath );
        Reporter.log( "  * file path: " + file.getAbsolutePath(), true );
        Reporter.log( "  * unmarshalling XML...", true );
        Object  obj = _xmlMapper.unmarshal( new FileInputStream( file ) );

        Assert.assertNotNull( obj );
        Assert.assertTrue( obj instanceof OvalDefinitions );
        OvalDefinitions  defs = OvalDefinitions.class.cast( obj );
        Reporter.log( "  @ #definitions: " + defs.getDefinitions().size(), true );

        // metadata //
//        for (Definition  def : defs.getDefinitions().getElements()) {
            //NOTE: We found NO definition with multiple 'affected' elements.
//            Collection<Affected>  affectedList = def.getAffected();
//            if (affectedList.size() > 1) {
//                Reporter.log( "  @ #affected > 1: " + def.getOvalID(), true );
//            }
//        }

    }

}
// OvalXmlAnalysis

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

