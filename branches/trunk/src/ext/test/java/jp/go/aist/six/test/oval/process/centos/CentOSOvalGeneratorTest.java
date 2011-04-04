package jp.go.aist.six.test.oval.process.centos;

import jp.go.aist.six.oval.process.OvalProcessStatus;
import jp.go.aist.six.oval.process.centos.CentOSOvalGenerator;
import org.testng.Assert;
import org.testng.Reporter;
import java.io.File;





/**
 * @author  Akihito Nakamura, AIST
 * @version $Id: CentOSOvalGeneratorTest.java 517 2010-04-06 10:03:59Z akihito $
 */
public class CentOSOvalGeneratorTest
{

    /**
     */
    public CentOSOvalGeneratorTest()
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



    /**
     * Sample Red Hat EL OVAL definitions.
     *
     * @testng.data-provider name="oval-definitions-source"
     */
    public Object[][] ovalDefinitionsSourceProvider()
    {
        File  file2003 = new File( "test/data/redhat/com.redhat.rhsa-2003.xml" );
        File  file2004 = new File( "test/data/redhat/com.redhat.rhsa-2004.xml" );
        File  file2005 = new File( "test/data/redhat/com.redhat.rhsa-2005.xml" );
        File  file2006 = new File( "test/data/redhat/com.redhat.rhsa-2006.xml" );
        File  file2007 = new File( "test/data/redhat/com.redhat.rhsa-2007.xml" );
        File  file2008 = new File( "test/data/redhat/com.redhat.rhsa-2008.xml" );
        File  file2009 = new File( "test/data/redhat/com.redhat.rhsa-2009.xml" );
        File  file2010 = new File( "test/data/redhat/com.redhat.rhsa-2010.xml" );
        File  fileAll  = new File( "test/data/redhat/com.redhat.rhsa-all.xml" );

        return new Object[][] {
                        { file2003.getAbsolutePath() },
                        { file2004.getAbsolutePath() },
                        { file2005.getAbsolutePath() },
                        { file2006.getAbsolutePath() },
                        { file2007.getAbsolutePath() },
                        { file2008.getAbsolutePath() },
                        { file2009.getAbsolutePath() },
                        { file2010.getAbsolutePath() },
                        { fileAll.getAbsolutePath() }
        };
    }

//    public Object[][] ovalDefinitionsSourceProvider()
//    {
//        File  file1 = new File( "test/data/sample_oval-definitions_linux-redhat.xml" );
//
//        return new Object[][] {
//                        { "https://rhn.redhat.com/rhn/oval?errata=9522" },
//                        { file1.getAbsolutePath() },
//                        { file2.getAbsolutePath() }
//        };
//    }



    /**
     * @testng.test groups="oval.interpriter"
     *              dataProvider="oval-definitions-source"
     *              alwaysRun="true"
     */
    public void execute(
                    final String sourceDefLocation
                    )
    throws Exception
    {
        Reporter.log( "\n// OVAL definitions generator for CentOS //", true );
        Reporter.log( "*** source RHEL OVAL definitions: " + sourceDefLocation, true );

        CentOSOvalGenerator  generator = new CentOSOvalGenerator( sourceDefLocation );
        File  definitionsFile = File.createTempFile( "oval-d_CentOS_", ".xml" );
        String  outputLocation = definitionsFile.getAbsolutePath();
        Reporter.log( "*** generating CentOS OVAL definitions ...: file="
                        + outputLocation, true );
        generator.setOutputDefinitionLocation( outputLocation );
        OvalProcessStatus  status = generator.execute();

        Reporter.log( "@@@ status: " + status, true );
        Assert.assertTrue( !status.isError() );
        Assert.assertTrue( definitionsFile.exists() );
    }

}
// CentOSOvalGeneratorTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

