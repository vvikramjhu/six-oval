package jp.go.aist.six.oval.core.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import jp.go.aist.six.oval.core.SixOvalContext;
import jp.go.aist.six.oval.core.TestUtil;
import jp.go.aist.six.oval.xml.OvalXmlMapper;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;



/**
 * Tests: OvalXmlMapper.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
@RunWith( Enclosed.class )
public class OvalTransformXmlMapperTest
{

    @RunWith( Theories.class )
    public static class MitreOvalRepositoryContent
    {


        @DataPoints
        public static String[]  FILE_PATHES = new String[] {
            // netsap2013
//            "src/test/resources/data/netsap2013/20130313_com.redhat.rhsa-all.xml"
//          "src/test/resources/data/netsap2013/20130313_mitre_vuln_windows.xml"
//            "src/test/resources/data/netsap2013/20130313_mitre_vuln_unix.xml"

//        "src/test/resources/data/oval5/mitre/20130213_microsoft.windows.7.xml"
//        "src/test/resources/data/oval5/mitre/oval-5.10_12191-5_i_Microsoft-Publisher-2010.xml"

        /* Apple Mac OS */
//        "src/test/resources/data/oval5/mitre/oval-5.10_v_apple.mac.os.x_20130217.xml"

//current test!!!
            "src/test/resources/data/oval5/mitre/oval-5.10-12541-3_i_Windows7.xml"

//
//        /* RedHat */
//        "src/test/resources/data/oval5/redhat/rhsa-2013.xml",
//        "src/test/resources/data/oval5/redhat/rhsa-2013_sc.xml",
//        "src/test/resources/data/oval5/redhat/rhsa-2013_results.xml"
        };


        private OvalXmlMapper  _xml_mapper = null;
        private File  _tmp_dir = null;



        /**
         */
        @Before
        public void setUp()
                        throws Exception
        {
            _xml_mapper = SixOvalContext.basic().getXmlMapper();

            String  tmp_dirpath = System.getProperty( "java.io.tmpdir" );
            _tmp_dir = new File( tmp_dirpath, "six-oval" );
            _tmp_dir.mkdirs();
        }



        @Theory
        public void testUnmarshal(
                        final String filepath
                        )
        throws Exception
        {
            File  in_file = new File( filepath );
//           long  time = System.currentTimeMillis();
            Object  obj = _xml_mapper.unmarshal( new FileInputStream( in_file ) );

            File  out_file = new File( _tmp_dir, "unmarshalled_" + in_file.getName() );
            _xml_mapper.marshal( obj, new FileWriter( out_file ) );

            obj = _xml_mapper.unmarshal( new FileInputStream( out_file ) );
        }

    }
    //MitreOvalRepositoryContent



    /**
     * XML test: OVAL test content.
     *
     * @see http://oval.mitre.org/repository/about/testcontent.html
     */
    @RunWith( Theories.class )
    public static class OvalTestContent
    {

        public static final String  TOP_DIR = "src/test/resources/data/oval5/ovaltc-5.10.1.3";


        @DataPoints
        public static String[]  SUB_DIRS = new String[] {
            "definitions",
            "independent",
            "linux",
            "macos",
            "solaris",
            "unix",
            "windows",
            "support/var"
        };


        private OvalXmlMapper  _xml_mapper = null;
        private File  _tmp_dir = null;



        @Before
        public void setUp()
                        throws Exception
        {
            _xml_mapper = SixOvalContext.basic().getXmlMapper();

            String  tmp_dir_path = System.getProperty( "java.io.tmpdir" );
            _tmp_dir = new File( tmp_dir_path, "six-oval/ovaltc-5.10.1.3" );
            _tmp_dir.mkdirs();
        }


        @Theory
        public void testUnmarshal(
                        final String dir_path
                        )
        throws Exception
        {
            File  output_dir = new File( _tmp_dir, dir_path );
            output_dir.mkdirs();

            File  input_dir = new File( TOP_DIR, dir_path );
            File[]  input_xml_files = TestUtil.listXmlFiles( input_dir );
            for (File  input_xml_file : input_xml_files) {
                System.out.println( "OVAL Document: " + input_xml_file );
                /* (1) unmarshal */
                Object  obj = _xml_mapper.unmarshal( new FileInputStream( input_xml_file ) );

                /* (2) marshal */
                File  output_xml_file = new File( output_dir, "unmarshalled_" + input_xml_file.getName() );
                _xml_mapper.marshal( obj, new FileWriter( output_xml_file ) );

                /* (3) unmarshal */
                obj = _xml_mapper.unmarshal( new FileInputStream( output_xml_file ) );
            }
        }

    }
    //OvalTestContent


}
//
