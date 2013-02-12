package jp.go.aist.six.oval.core.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
        "src/test/resources/data/oval5/mitre/oval-5.10-12541-3_i_Windows7.xml",

        /* RedHat */
        "src/test/resources/data/oval5/redhat/rhsa-2013.xml",
        "src/test/resources/data/oval5/redhat/rhsa-2013_sc.xml",
        "src/test/resources/data/oval5/redhat/rhsa-2013_results.xml"
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
    throws FileNotFoundException
    {
        File  file = new File( filepath );
//        long  time = System.currentTimeMillis();
        _xml_mapper.unmarshal( new FileInputStream( file ) );
    }


}
//OvalXmlMapperTest
