package jp.go.aist.six.oval.core.repository;

import java.io.File;
import java.io.FileInputStream;
import jp.go.aist.six.oval.core.OvalTestBase;
import jp.go.aist.six.oval.core.SixOvalContext;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;



/**
 */
@RunWith( Enclosed.class )
public class OvalRepositoryImplTest
{

    /**
     * Repository test: OVAL test content.
     *
     * @see http://oval.mitre.org/repository/about/testcontent.html
     */
    @RunWith( Theories.class )
    public static class OvalTestContent
    extends OvalTestBase
    {

        public static final String  INPUT_ROOTDIR_PATH = "src/test/resources/data/oval5/ovaltc-5.10.1.3";


        @DataPoints
        public static String[]  INPUT_SUBDIR_PATHS = new String[] {
            "independent"
//            "independent",
//            "linux",
//            "macos",
//            "solaris",
//            "unix",
//            "windows",
        };



        public OvalTestContent()
        {
            super( SixOvalContext.repository() );
        }



        @Theory
        public void testSaveDefinition(
                        final String input_subdir_path
                        )
        throws Exception
        {
            File[]  input_xml_files = _listXmlFiles( INPUT_ROOTDIR_PATH, input_subdir_path );
            for (File  input_xml_file : input_xml_files) {
                System.out.println( "OVAL Document: filepath=" + input_xml_file );
                /* (1) unmarshal */
                Object  obj = _getXmlMapper().unmarshal( new FileInputStream( input_xml_file ) );
                if (OvalDefinitions.class.isInstance( obj )) {
                    OvalDefinitions  oval_defs = OvalDefinitions.class.cast( obj );
                    _getRepository().saveOvalDefinitions( oval_defs );
                }

            }
        }

    }
    //OvalTestContent

}
//
