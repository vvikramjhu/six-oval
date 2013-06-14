package jp.go.aist.six.oval.core;

import java.util.ArrayList;
import java.util.List;
import jp.go.aist.six.oval.core.repository.OvalDocumentInstaller;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;



/**
 */
@RunWith( Enclosed.class )
public class OvalAnalyzer
{

    public static final String  _DATA_DIR_ = "src/test/resources/data/20130313";

    public static final String[]  _DATA_FILENAMES_ = new String[] {
        "20130313_mitre_vuln_macos.xml",
        "20130313_mitre_vuln_unix.xml",
        "20130313_mitre_vuln_windows.xml",

        //        "20130313_mitre_vuln.xml"

        "20130313_com.redhat.rhsa-all.xml"
    };



    /**
     * Setup:
     */
    public static class Setup
//    extends OvalTestBase
    {

        public Setup()
        {
//            super( SixOvalContext.repository() );
        }


        public static String[] dataFilepathList()
        {
            List<String>  filepath_list = new ArrayList<String>();
            for (String  filename : _DATA_FILENAMES_) {
                filepath_list.add( _DATA_DIR_ + "/" + filename );
            }

            return filepath_list.toArray( new String[0] );
        }


        @Test
        public void installData()
        throws Exception
        {
            OvalDocumentInstaller  installer = new OvalDocumentInstaller();
            installer.execute( dataFilepathList() );
        }

    }
    //


}
//
