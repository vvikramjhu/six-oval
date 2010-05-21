package jp.go.aist.six.test.oval.process;

import org.testng.Reporter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ResourceBundle;





/**
 * @author  Akihito Nakamura, AIST
 * @version $Id: OvalProcessTestBase.java 373 2010-03-15 02:04:22Z akihito $
 */
public abstract class OvalProcessTestBase
{

    private String  _osType;
    private String  _linuxDistribution;
    private ResourceBundle  _ovaldiResourceBundle;
    private ResourceBundle  _ovalServiceResourceBundle;



    /**
     */
    public OvalProcessTestBase()
    {
    }



    /**
     * @testng.before-class alwaysRun="true"
     */
    public void setUp()
    throws Exception
    {
        Reporter.log( "######## set up ########", true );

        final String  osName = System.getProperty( "os.name" );
        final String  osVersion = System.getProperty( "os.version" );
        Reporter.log( "# OS=" + osName + ", " + osVersion, true );

        _osType = null;
        if (osName.startsWith( "Linux" )) {
            _osType = "linux";
        } else if (osName.startsWith( "Windows" )) {
            _osType = "windows";
        } else {
            _osType = "unknown";
        }
        if (_osType.equals( "linux" )) {
            _osType = _osType + "-" + _findLinuxDistributionName();
        }

        Reporter.log( "# OS type=" + _osType, true );
        _ovaldiResourceBundle = ResourceBundle.getBundle( "ovaldi_" + _osType );
        Reporter.log( "# ovaldi resource bundle keys="
                        + _ovaldiResourceBundle.keySet(), true );

        _ovalServiceResourceBundle = ResourceBundle.getBundle( "oval_service" );
        Reporter.log( "# oval service resource bundle keys="
                        + _ovalServiceResourceBundle.keySet(), true );
    }



    /**
     * Searches the runtime Linux distribution name.
     */
    private String _findLinuxDistributionName()
    {
        File  file = new File( "/etc/issue" );
        String  distribution = "unknown";

        BufferedReader  reader = null;
        if (file.exists()) {
            try {
                reader = new BufferedReader( new FileReader( file ) );
                String  line = reader.readLine();
                if (line.startsWith( "CentOS" )) {
                    distribution = "centos";
                } else if (line.startsWith( "Debian" )) {
                    distribution = "debian";
                }
            } catch (Exception ex) {
                Reporter.log( "# finding Linux distribution name failed: " + ex, true );
            } finally {
                try {
                    reader.close();
                } catch (Exception ex) {
                    //ignorable
                }
            }
        }

        Reporter.log( "# Linux distribution=" + distribution, true );

        return distribution;
    }



    /**
     * Returns a string for the specified key from the resource bundle.
     */
    public String getResourceString(
                    final String key
                    )
    {
        return _ovaldiResourceBundle.getString( key );
    }



    public String getOvaldiExecutable()
    {
        return getResourceString( "ovaldi.executable" );
    }



    public String getOvaldiResourceDir()
    {
        return getResourceString( "ovaldi.resource_dir" );
    }



    /**
     * Returns a sample OVAL definitions file path
     * depends on the runtime environment.
     *
     * @return
     *  the file path.
     */
    public String getSampleOvalDefinitions()
    {
        return _getFilePath( "test/xml/sample_oval-definitions_", ".xml");
    }



    /**
     */
    private String _getFilePath(
                    final String prefix,
                    final String postfix
                    )
    {
        StringBuilder  s = new StringBuilder( prefix );
        s.append( _osType );
        if (_osType.equals( "linux" )) {
            s.append( "_" ).append( _linuxDistribution );
        }
        s.append( postfix );

        return s.toString();
    }



    public String getOvalwsResultsPostURL()
    {
        return _ovalServiceResourceBundle.getString( "ovalws.oval_results.post.url" );
    }

}
// OvalProcessTestBase

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

