package jp.go.aist.six.oval.core.interpreter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import java.io.IOException;
import jp.go.aist.six.oval.interpreter.Options;
import org.junit.Before;
import org.junit.Test;


public class OvaldiProxyTest
{

    @Before
    public void setUp()
    {
    }


    @Test
    public void testExecuteWithDefaultOptionsForLocalExecution()
                    throws IOException
    {
        Options  options = new Options();
        options.set( OvaldiOption.NO_VERIFY )
               .set( OvaldiOption.OVAL_XML_DIR,
                        "C:\\app\\ovaldi-5.10.1.4-x64\\xml" )
               .set( OvaldiOption.OVAL_DEFINITIONS,
                        "src/test/resources/data/oval5/mitre/oval-5.10-12541-3_i_Windows7.xml" );

        OvaldiProxy  ovaldi = new OvaldiProxy( options );
        int  exitValue = ovaldi.execute();
        assertThat( "normal termination", exitValue, is( 0 ) );
    }

}
