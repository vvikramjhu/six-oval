package jp.go.aist.six.oval.core.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import java.io.File;
import java.io.FileInputStream;
import jp.go.aist.six.oval.core.OvalTestBase;
import jp.go.aist.six.oval.core.SixOvalContext;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.repository.OvalRepository;
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

    public static void saveOvalDefinitions(
                    final OvalRepository repository,
                    final OvalDefinitions oval_defs
                    )
    {
        repository.saveOvalDefinitions( oval_defs );
        for (DefinitionType def : oval_defs.getDefinitions().getDefinition()) {
            String  oval_id = def.getOvalId();
            DefinitionType  p_def = repository.findDefinitionById( oval_id );
            assertThat( p_def, is( notNullValue() ) );
        }
    }



    /**
     * Repository test: Mitre repository.
     *
     * @see http://oval.mitre.org/repository/
     */
    @RunWith( Theories.class )
    public static class MitreOvalRepositoryContent
    extends OvalTestBase
    {

        public static final String  INPUT_ROOTDIR_PATH = "src/test/resources/data/oval5/mitre";


        @DataPoints
        public static String[]  INPUT_SUBDIR_PATHS = new String[] {
            "aix",
            "esx",
            "linux",
            "macos"
//            "solaris"
//            "unix"
//            "windows"
        };



        public MitreOvalRepositoryContent()
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
                    saveOvalDefinitions( _getRepository(), oval_defs );
//                    _getRepository().saveOvalDefinitions( oval_defs );
                }

            }
        }

    }
    //OvalTestContent



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
            "definitions",
            "independent",
            "linux",
            "macos",
            "solaris",
            "unix",
            "windows"
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
                    saveOvalDefinitions( _getRepository(), oval_defs );
//                  _getRepository().saveOvalDefinitions( oval_defs );
                }

            }
        }

    }
    //OvalTestContent

}
//
