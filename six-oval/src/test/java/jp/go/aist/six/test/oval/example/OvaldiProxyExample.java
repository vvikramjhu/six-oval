package jp.go.aist.six.test.oval.example;

import jp.go.aist.six.oval.core.interpreter.OvaldiOption;
import jp.go.aist.six.oval.core.interpreter.OvaldiProxy;
import jp.go.aist.six.oval.interpreter.Options;



public class OvaldiProxyExample
{

    public static void main( final String[] args )
    throws Exception
    {
//        String[]  ovaldi_args = new String[] {
//                        "-a", "C:\\app\\ovaldi-5.10.1.2-x64\\xml",
//                        "-m"
//        };

        Options  options = new Options();
        options.set( OvaldiOption.NO_VERIFY ).set( OvaldiOption.OVAL_XML_DIR, "C:\\app\\ovaldi-5.10.1.2-x64\\xml" );

        OvaldiProxy  ovaldi = new OvaldiProxy( options );
        int  exit_value = ovaldi.execute();
        System.out.println( "ovaldi exit value: " + exit_value );
    }

}
//
