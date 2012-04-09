package jp.go.aist.six.test.oval.core.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.repository.QueryResults;
import jp.go.aist.six.test.oval.core.TestBase;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;



/**
 * Tests: XML mapping of oval.repository.QueryResults.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class QueryResultsTests
    extends TestBase
{

    /**
     */
    public QueryResultsTests()
    {
    }



    /**
     */
    protected <T> void _testXml(
                    final Class<T> object_type,
                    final String input_filepath,
                    final T expected_object,
                    final String output_filepath
                    )
    throws Exception
    {
        T  actual = null;
        try {
            actual = _unmarshalObject( object_type, input_filepath, expected_object );
            if (actual instanceof OvalDefinitions) {
                OvalDefinitions  oval_defs = OvalDefinitions.class.cast( actual );
                for (DefinitionType  def : oval_defs.getDefinitions().getDefinition()) {
                    Reporter.log( "  @ definition: id=" + def.getOvalID(), true );
                    Reporter.log( "                title=" + def.getMetadata().getTitle(), true );
                }
            }
        } catch (Exception ex) {
            Reporter.log( "  !!! Unsupported XML element(s) found.", true );
            throw ex;
        }

        if (actual != null) {
            _marshalObject( actual, output_filepath );
            _unmarshalObject( object_type, output_filepath, expected_object );
        }
    }





    //**************************************************************
    //  Test Data
    //**************************************************************

    /**
     * Provides OVAL test content.
     *  Class<T>            object_type,
     *  String[]            xml_filepath
     */
    @DataProvider( name="oval.repository.QueryResults" )
    public Object[][] provideOvalQueryResultsDef()
    {

        return new Object[][] {
                      /* Windows */
                        {
                            jp.go.aist.six.oval.model.definitions.OvalDefinitions.class,
                            new String[] {
                                "test/resources/OvalTestContent/5.10/windows/ind-def_family_test.xml"
                            }
                        }
        };
    }





    //**************************************************************
    // test methods
    //**************************************************************

    /**
     */
    @org.testng.annotations.Test(
                    groups={ "oval.repository.QueryResults.def" },
                    dataProvider="oval.repository.QueryResults",
                    alwaysRun=true
                    )
    public void testQueryResultsXmlMapping(
                    final Class<OvalDefinitions>  object_type,
                    final String[]  xml_filepaths
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////",
                        true );
        Reporter.log( "* object type: " + object_type, true );
        Reporter.log( "* XML file path: " + Arrays.toString( xml_filepaths ), true );

//        QueryResults<DefinitionType>  def_results = new QueryResults<DefinitionType>();

        // unmarshalling all the XML files
        Collection<OvalDefinitions>  oval_defs = new ArrayList<OvalDefinitions>();
        for (String  xml_filepath : xml_filepaths) {
            File  xml_file = new File( xml_filepath );
            OvalDefinitions  xml_object = _unmarshalObject( object_type, xml_file.getCanonicalPath(), null );
            oval_defs.add( xml_object );

        }
        Assert.assertEquals( xml_filepaths.length, oval_defs.size() );


        // oval_definitions results
        QueryResults<OvalDefinitions>  oval_defs_results =
                        new QueryResults<OvalDefinitions>( (long)oval_defs.size(), 0L, (long)oval_defs.size() );

        Reporter.log( "* query results: " + oval_defs_results, true );
        File  output_xml_file = File.createTempFile( "query_results_oval_defs", ".xml" );
        _marshalObject( oval_defs_results, output_xml_file.getCanonicalPath() );
    }

}
//
