package jp.go.aist.six.oval.core.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import jp.go.aist.six.oval.core.OvalContext;
import jp.go.aist.six.util.xml.XmlMapper;
import org.junit.Before;
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
@RunWith( Theories.class )
public class OvalXmlMapperTest
{


    @DataPoints
    public static String[]  FILE_PATHES = new String[] {

        "src/test/resources/data/oval5/mitre/oval-5.10_12191-5_i_Microsoft-Publisher-2010.xml"

        /* Apple Mac OS */
//        "src/test/resources/data/oval5/mitre/oval-5.10_v_apple.mac.os.x_20130217.xml"


//        "src/test/resources/data/oval5/mitre/oval-5.10-12541-3_i_Windows7.xml",
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
//        long  time = System.currentTimeMillis();
        Object  obj = _xml_mapper.unmarshal( new FileInputStream( in_file ) );

        File  out_file = new File( _tmp_dir, "unmarshalled_" + in_file.getName() );
        _xml_mapper.marshal( obj, new FileWriter( out_file ) );

        obj = _xml_mapper.unmarshal( new FileInputStream( out_file ) );
    }


}
//OvalXmlMapperTest
