package jp.go.aist.six.test.oval.core.xml;

import java.io.File;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import jp.go.aist.six.test.oval.core.OvalContentCategory;
import jp.go.aist.six.test.oval.core.OvalCoreTestBase;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;



/**
 * Tests: OvalXmlMapper.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalXmlMapperTests
    extends OvalCoreTestBase
{

    /**
     */
    public OvalXmlMapperTests()
    {
    }



    private File  _tmp_dir = null;



    /**
     */
    @Override
    @BeforeClass( alwaysRun=true )
    public void setUp()
    throws Exception
    {
        super.setUp();

        String  tmp_dirpath = System.getProperty( "java.io.tmpdir" );
        _tmp_dir = new File( tmp_dirpath, "six-oval" );
        _tmp_dir.mkdirs();
    }



    /**
     */
    protected <T> void _testXml(
                    final Class<T>  object_type,
                    final File      src_xml_file,
                    final T         expected_object
                    )
    throws Exception
    {
        T  actual = null;
        try {
            actual = _unmarshalFromFile( object_type, src_xml_file.getCanonicalPath(), expected_object );
//            Reporter.log( "  * unmarshalled object: " + actual, true );
        } catch (Exception ex) {
            Reporter.log( "  !!! Unsupported XML element(s) found.", true );
            throw ex;
        }

        if (actual != null) {
            String  dst_xml_filepath = "unmarshalled_" + src_xml_file.getName();
            File  dst_xml_file = new File( _tmp_dir, dst_xml_filepath );
            dst_xml_filepath = dst_xml_file.getCanonicalPath();

            _marshalToFile( actual, dst_xml_filepath );
            _unmarshalFromFile( object_type, dst_xml_filepath, expected_object );
        }
    }




    ////////////////////////////////////////////////////////////////
    //  test methods
    ////////////////////////////////////////////////////////////////

    /**
     */
    @org.testng.annotations.Test(
                    groups={
                                    "MODEL.oval.def.oval_definitions",
                                    "PACKAGE.oval.core.xml",
                                    "CONTROL.xml.unmarshal",
                                    "CONTROL.xml.marshal"
                                    }
                    ,dataProvider="DATA.oval.def.oval_definitions"
                    ,alwaysRun=true
                    )
    public void testXmlMappingOvalDefinitions(
                    final OvalContentCategory       category,
                    final String                    schema_version,
                    final Class<OvalDefinitions>    object_type,
                    final Family                    family,
                    final String                    dirpath,
                    final String                    xml_filepath,
                    final OvalDefinitions           expected_object
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////", true );

        File[]  files = _toXmlFileList( dirpath, xml_filepath );
        for (File  file : files) {
            Reporter.log( "  * file= " + file, true );
            _testXml( object_type, file, expected_object );
        }
    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={
                                    "MODEL.oval.sc.oval_system_characteristics",
                                    "PACKAGE.oval.core.xml",
                                    "CONTROL.xml.unmarshal",
                                    "CONTROL.xml.marshal"
                                    }
                    ,dependsOnGroups={ "MODEL.oval.def.oval_definitions" }
                    ,dataProvider="DATA.oval.sc.oval_system_characteristics"
                    ,alwaysRun=true
                    )
    public void testXmlMappingOvalSystemCharacteristics(
                    final OvalContentCategory               category,
                    final String                            schema_version,
                    final Class<OvalSystemCharacteristics>  object_type,
                    final Family                            family,
                    final String                            dirpath,
                    final String                            xml_filepath,
                    final OvalSystemCharacteristics         expected_object
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////", true );

        File[]  files = _toXmlFileList( dirpath, xml_filepath );
        for (File  file : files) {
            Reporter.log( "  * file= " + file, true );
            _testXml( object_type, file, expected_object );
        }
    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={
                                    "MODEL.oval.res.oval_results",
                                    "PACKAGE.oval.core.xml",
                                    "CONTROL.xml.unmarshal",
                                    "CONTROL.xml.marshal"
                                    }
                    ,dependsOnGroups={ "MODEL.oval.sc.oval_system_characteristics" }
                    ,dataProvider="DATA.oval.res.oval_results"
                    ,alwaysRun=true
                    )
    public void testXmlMappingOvalResults(
                    final OvalContentCategory   category,
                    final String                schema_version,
                    final Class<OvalResults>    object_type,
                    final Family                family,
                    final String                dirpath,
                    final String                xml_filepath,
                    final OvalResults           expected_object
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////", true );

        File[]  files = _toXmlFileList( dirpath, xml_filepath );
        for (File  file : files) {
            Reporter.log( "  * file= " + file, true );
            _testXml( object_type, file, expected_object );
        }
    }

}
//OvalXmlMapperTests
