package jp.go.aist.six.oval.core.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import jp.go.aist.six.oval.core.OvalContext;
import jp.go.aist.six.oval.core.TestUtil;
import jp.go.aist.six.util.xml.XmlMapper;
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
public class OvalXmlMapperTest
{

    @RunWith( Theories.class )
    public static class MitreOvalRepositoryContent
    {


        @DataPoints
        public static String[]  FILE_PATHES = new String[] {

//        "src/test/resources/data/oval5/mitre/20130213_microsoft.windows.7.xml"
//        "src/test/resources/data/oval5/mitre/oval-5.10_12191-5_i_Microsoft-Publisher-2010.xml"

        /* Apple Mac OS */
//        "src/test/resources/data/oval5/mitre/oval-5.10_v_apple.mac.os.x_20130217.xml"


        "src/test/resources/data/oval5/mitre/oval-5.10-12541-3_i_Windows7.xml"
//
//        /* RedHat */
//        "src/test/resources/data/oval5/redhat/rhsa-2013.xml",
//        "src/test/resources/data/oval5/redhat/rhsa-2013_sc.xml",
//        "src/test/resources/data/oval5/redhat/rhsa-2013_results.xml"
        };


        private XmlMapper  _xml_mapper = null;
        private File  _tmp_dir = null;



        /**
         */
        @Before
        public void setUp()
                        throws Exception
        {
            _xml_mapper = OvalContext.getInstance().getXmlMapper();

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
     * Xml marshal/unmarshal tests using the OVAL test content.
     *
     * @see http://oval.mitre.org/repository/about/testcontent.html
     */
    @RunWith( Theories.class )
    public static class OvalTestContent
    {

        public static final String  TOP_DIR = "src/test/resources/data/oval5/ovaltc-5.10.1.3";


        @DataPoints
        public static String[]  SUB_DIRS = new String[] {
            "linux",
            "macos",
            "solaris",
            "windows",
            "support/var"
        };


        private XmlMapper  _xml_mapper = null;
        private File  _tmp_dir = null;



        @Before
        public void setUp()
                        throws Exception
        {
            _xml_mapper = OvalContext.getInstance().getXmlMapper();

            String  tmp_dirpath = System.getProperty( "java.io.tmpdir" );
            _tmp_dir = new File( tmp_dirpath, "six-oval/test-content" );
            _tmp_dir.mkdirs();
        }


        @Theory
        public void testUnmarshal(
                        final String dir_path
                        )
        throws Exception
        {
            File  tmp_dir = new File( _tmp_dir, dir_path );
            tmp_dir.mkdirs();

            File  dir = new File( TOP_DIR, dir_path );
            File[]  in_xml_files = TestUtil.listXmlFiles( dir );
            for (File  in_xml_file : in_xml_files) {
                System.out.println( "OVAL Document: " + in_xml_file );
                /* (1) unmarshal */
                Object  obj = _xml_mapper.unmarshal( new FileInputStream( in_xml_file ) );

                /* (2) marshal */
                File  out_xml_file = new File( tmp_dir, "unmarshalled_" + in_xml_file.getName() );
                _xml_mapper.marshal( obj, new FileWriter( out_xml_file ) );

                /* (3) unmarshal */
                obj = _xml_mapper.unmarshal( new FileInputStream( out_xml_file ) );
            }
        }

    }
    //OvalTestContent


}
//OvalXmlMapperTest
