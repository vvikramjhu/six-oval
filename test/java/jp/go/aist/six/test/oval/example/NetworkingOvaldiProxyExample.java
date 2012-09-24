package jp.go.aist.six.test.oval.example;

import jp.go.aist.six.oval.core.interpreter.NetworkingOvaldiProxy;
import jp.go.aist.six.oval.core.interpreter.OvaldiOption;
import jp.go.aist.six.oval.interpreter.Options;



public class NetworkingOvaldiProxyExample
{

    public static void main( final String[] args )
    throws Exception
    {
//        String[]  ovaldi_args = new String[] {
//                        "-a", "C:\\app\\ovaldi-5.10.1.2-x64\\xml",
//                        "-m"
//        };

        Options  options = new Options();
        options.set( OvaldiOption.NO_VERIFY )
               .set( OvaldiOption.OVAL_XML_DIR, "C:\\app\\ovaldi-5.10.1.2-x64\\xml" )
               .set( OvaldiOption.OVAL_DEFINITIONS, "http://oval.mitre.org/repository/data/DownloadDefinition?id=oval%3aorg.mitre.oval%3adef%3a12541" );
//               .set( OvaldiOption.OVAL_RESULTS, "http://localhost:8080/six-oval/repository/oval_results" );

        NetworkingOvaldiProxy  ovaldi = new NetworkingOvaldiProxy( options );
        int  exit_value = ovaldi.execute();
        System.out.println( "ovaldi exit value: " + exit_value );
    }

}
//
