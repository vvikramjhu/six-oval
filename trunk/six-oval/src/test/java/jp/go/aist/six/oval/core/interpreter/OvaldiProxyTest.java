package jp.go.aist.six.oval.core.interpreter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import jp.go.aist.six.oval.interpreter.Options;
import org.junit.Before;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;


@RunWith( Theories.class )
public class OvaldiProxyTest
{

    @DataPoints
    public static Options[]  OPTIONS = new Options[] {
        new Options()
        .set( OvaldiOption.NO_VERIFY )
//      .set( OvaldiOption.OVAL_XML_DIR, "C:\\app\\ovaldi-5.10.1.4-x64\\xml" )
        .set( OvaldiOption.OVAL_DEFINITIONS, "src/test/resources/data/oval5/mitre/oval-5.10-12541-3_i_Windows7.xml" ),

        /* for networking proxy */
//        new Options()
//        .set( OvaldiOption.NO_VERIFY )
//        .set( OvaldiOption.OVAL_DEFINITIONS,
//                        "http://oval.mitre.org/repository/data/DownloadDefinition?id=oval%3aorg.mitre.oval%3adef%3a12541&type=view" )
    };



    @Before
    public void setUp()
    {
    }


    @Theory
    public void testExecuteWithOptions(
                    final Options options
                    )
    {
        OvaldiProxy  ovaldi = new OvaldiProxy( options );
        int  exitValue = ovaldi.execute();
        assertThat( "normal termination", exitValue, is( 0 ) );
    }


/******
    @Test
    public void testExecuteWithDefaultOptionsForLocalExecution()
                    throws IOException
    {
        Options  options = new Options();
        options.set( OvaldiOption.NO_VERIFY )
//               .set( OvaldiOption.OVAL_XML_DIR,
//                        "C:\\app\\ovaldi-5.10.1.4-x64\\xml" )
               .set( OvaldiOption.OVAL_DEFINITIONS,
                        "src/test/resources/data/oval5/mitre/oval-5.10-12541-3_i_Windows7.xml" );

        OvaldiProxy  ovaldi = new OvaldiProxy( options );
        int  exitValue = ovaldi.execute();
        assertThat( "normal termination", exitValue, is( 0 ) );
    }
***/

}
