package jp.go.aist.six.test.oval.service;

import jp.go.aist.six.oval.model.definition.OvalDefinitions;
import jp.go.aist.six.oval.model.result.OvalResults;
import jp.go.aist.six.oval.model.system.OvalSystemCharacteristics;
import jp.go.aist.six.oval.service.Oval;
import org.testng.Assert;
import org.testng.Reporter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;





/**
 * @author  Akihito Nakamura, AIST
 * @version $Id: OvalStoreTest.java 752 2010-05-10 03:14:15Z akihito $
 */
public class OvalStoreTest
{

    /**
     */
    public OvalStoreTest()
    {
    }



    /**
     * @testng.before-class alwaysRun="true"
     */
    public void setUp()
        throws Exception
    {
    }



    /**
     */
    public void run()
        throws Exception
    {
    }



    //**************************************************************
    //  OVAL Results
    //**************************************************************

    /**
     * Sample OVAL Results.
     *
     * @testng.data-provider name="oval-results-filepath"
     */
    public
    Object[][] ovalResultsFilepathProvider()
    {
        return new Object[][] {
                        {
                            "Linux CentOS",
                            "test/data/sample_oval-results_linux-centos.xml"
                        },
                        {
                            "Windows",
                            "test/data/sample_oval-results_windows.xml"
                        }
        };
    }


    /**
     * @testng.test groups="oval.store results"
     *              dataProvider="oval-results-filepath"
     *              dependsOnGroups="SC definitions"
     *              alwaysRun="true"
     */
    public void createOvalResults(
                    final String platform,
                    final String filepath
                    )
    throws Exception
    {
        Reporter.log( "\n// OVAL store: create OVAL results //", true );
        Reporter.log( "### platform: " + platform, true );

        File  file = new File( filepath );
        Reporter.log( "*** unmarshalling XML...: file=" + file.getAbsolutePath(), true );
        Reader  reader = new InputStreamReader(
                            new FileInputStream( file ), Charset.forName( "UTF-8" ) );

        OvalResults  results = (OvalResults)Oval.getXml().unmarshal( reader );
        Assert.assertNotNull( results );

        OvalDefinitions  defs = results.getDefinitions();
        Assert.assertNotNull( defs );

        Reporter.log( "*** creating OvalResults object...", true );
        String  pid = Oval.getStore().createOvalResults( results );
        Reporter.log( "@@@ OvalResults: pid=" + pid, true );
    }



    //**************************************************************
    //  OVAL System Characteristics
    //**************************************************************

    /**
     * Sample OVAL System Characteristics.
     *
     * @testng.data-provider name="oval-sc-filepath"
     */
    public
    Object[][] ovalSCFilepathProvider()
    {
        return new Object[][] {
                        {
                            "Linux CentOS",
                            "test/data/sample_oval-sc_linux-centos.xml",
                        },
                        {
                            "Windows",
                            "test/data/sample_oval-sc_windows.xml"
                        }
        };
    }


    /**
     * @testng.test groups="oval.store SC"
     *              dataProvider="oval-sc-filepath"
     *              dependsOnGroups="definitions"
     *              alwaysRun="true"
     */
    public void createOvalSC(
                    final String platform,
                    final String filepath
                    )
    throws Exception
    {
        Reporter.log( "\n// OVAL store: create SC //", true );
        Reporter.log( "### platform=" + platform, true );

        File  file = new File( filepath );
        Reporter.log( "*** unmarshalling XML...: file=" + file.getAbsolutePath(), true );
        Reader  reader = new InputStreamReader(
                            new FileInputStream( file ), Charset.forName( "UTF-8" ) );

        Reporter.log( "*** unmarshalling XML...", true );
        OvalSystemCharacteristics  sc = (OvalSystemCharacteristics)Oval.getXml().unmarshal( reader );

        Reporter.log( "*** checking OvalSystemCharacteristics object to create...", true );
        Assert.assertNotNull( sc );
        Assert.assertNotNull( sc.getGenerator() );
        Assert.assertNotNull( sc.getSystemInfo() );

        Reporter.log( "  *** creating OvalSystemCharacteristics object...", true );
        Oval.getStore().createSystemCharacteristics( sc );

//        Reporter.log( "  checking created persistent OvalSystemCharacteristics...", true );
    }



    //**************************************************************
    //  OVAL definitions
    //**************************************************************

    /**
     * Sample OVAL Definitions.
     *
     * @testng.data-provider name="oval-definitions-filepath"
     */
    public
    Object[][] ovalDefinitionsFilepathProvider()
    {
        return new Object[][] {
                        {
                            "Linux CentOS",
                            "test/data/sample_oval-definitions_linux-centos.xml"
                        },
                        {
                            "Windows",
                            "test/data/sample_oval-definitions_windows.xml"
                        }
        };
    }


    /**
     * @testng.test groups="oval.store definitions"
     *              dataProvider="oval-definitions-filepath"
     *              dependsOnGroups="SmallDefinitions"
     *              alwaysRun="true"
     */
    public
    void createOvalDefinitions(
                    final String platform,
                    final String filepath
                    )
    throws Exception
    {
        Reporter.log( "\n// OVAL store: create Definitions //", true );
        Reporter.log( "  platform=" + platform, true );

        File  file = new File( filepath );
        Reporter.log( "*** unmarshalling XML...: file=" + file.getAbsolutePath(), true );
        Reader  reader = new InputStreamReader(
                            new FileInputStream( file ), Charset.forName( "UTF-8" ) );

        OvalDefinitions  defs = (OvalDefinitions)Oval.getXml().unmarshal( reader );

        Reporter.log( "  *** checking OvalDefinitins object to create...", true );
        Assert.assertNotNull( defs );
        Assert.assertNotNull( defs.getGenerator() );

        Reporter.log( "  *** creating OvalDefinitions object...", true );
        Oval.getStore().createOvalDefinitions( defs );

    }



    /**
     * Sample OvalDefinitions.
     *
     * @testng.data-provider name="oval-definitions"
     */
    public Object[][] ovalDefinitionsProvider()
    {
        return new Object[][] {
                        { OvalSamples.OVAL_DEFINITIONS_1 }
        };
    }



    /**
     * @testng.test groups="oval.store SmallDefinitions"
     *              dataProvider="oval-definitions"
     */
    public void createOvalDefinitions(
                    final OvalDefinitions defs
                    )
    throws Exception
    {
        Reporter.log( "\n// OvalStore: create OvalDefinitions //", true );
        Reporter.log( "   instance: " + defs, true );

        Reporter.log( "  *** creating OvalDefinitions...", true );
        Oval.getStore().createOvalDefinitions( defs );
    }

}
// OvalStoreTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

