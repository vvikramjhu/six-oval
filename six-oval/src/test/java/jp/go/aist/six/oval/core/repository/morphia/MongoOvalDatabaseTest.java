package jp.go.aist.six.oval.core.repository.morphia;

import java.io.File;
import java.io.FileInputStream;
import jp.go.aist.six.oval.core.OvalContext;
import jp.go.aist.six.oval.core.TestUtil;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.variables.OvalVariables;
import jp.go.aist.six.oval.repository.OvalDatabase;
import jp.go.aist.six.util.xml.XmlMapper;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;



/**
 * Tests: MongoOvalDatabase.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
@RunWith( Enclosed.class )
public class MongoOvalDatabaseTest
{

    /**
     * Repository tests using the OVAL test content.
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


        private OvalDatabase  _database = null;
        private XmlMapper  _xml_mapper = null;



        @Before
        public void setUp()
        throws Exception
        {
            OvalContext  context = OvalContext.getServerInstance();
            _xml_mapper = context.getXmlMapper();
            _database = context.getBean( MongoOvalDatabase.class );
        }



        @Theory
        public void testSave(
                        final String dir_path
                        )
        throws Exception
        {
            File  dir = new File( TOP_DIR, dir_path );
            File[]  in_xml_files = TestUtil.listXmlFiles( dir );
            for (File  in_xml_file : in_xml_files) {
                System.out.println( "OVAL Document: " + in_xml_file );
                /* (1) unmarshal */
                Object  obj = _xml_mapper.unmarshal( new FileInputStream( in_xml_file ) );

                /* (2) save */
                if (obj instanceof OvalDefinitions) {
                    _database.save( OvalDefinitions.class, OvalDefinitions.class.cast( obj ) );
                } else if (obj instanceof OvalVariables) {
                    _database.save( OvalVariables.class, OvalVariables.class.cast( obj ) );
                }
            }
        }

    }
    //OvalTestContent


}
//
