package jp.go.aist.six.test.oval.core.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
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
                                "test/resources/OvalTestContent/5.10/windows/ind-def_family_test.xml",
                                "test/resources/OvalTestContent/5.10/windows/win-def_file_test.xml"
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
                    groups={ "oval.repository.QueryResults", "xmlns:oval-def.oval_definitions" },
                    dataProvider="oval.repository.QueryResults",
                    alwaysRun=true
                    )
    public void testOvalDefinitionsQueryResultsXmlMapping(
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

        // (1) unmarshal all the XML files
        Collection<OvalDefinitions>  oval_defs = new ArrayList<OvalDefinitions>();
        for (String  xml_filepath : xml_filepaths) {
            File  xml_file = new File( xml_filepath );
            OvalDefinitions  xml_object = _unmarshalObject( object_type, xml_file.getCanonicalPath(), null );
            oval_defs.add( xml_object );

        }
        Assert.assertEquals( xml_filepaths.length, oval_defs.size() );

        // (2) build QueryResults
        QueryResults<OvalDefinitions>  oval_defs_results =
                        new QueryResults<OvalDefinitions>( oval_defs );
//                        new QueryResults<OvalDefinitions>(
//                                        oval_defs.size(), 0, oval_defs.size(), oval_defs );
        Reporter.log( "* query results: " + oval_defs_results, true );

        // (3) marshal the QueryResults to an XML file
        File  output_xml_file = File.createTempFile( "query_results_oval_defs", ".xml" );
        String  output_xml_filepath = output_xml_file.getCanonicalPath();
        _marshalObject( oval_defs_results, output_xml_filepath );

        // (4) validate the marshalled XML file by unmarshalling
        @SuppressWarnings( "unchecked" )
        QueryResults<OvalDefinitions>  oval_defs_results2 =
                        _unmarshalObject( QueryResults.class, output_xml_filepath, null );
        Reporter.log( "* query results (unmarshalled): " + oval_defs_results2, true );

        for (OvalDefinitions  oval_defs2 : oval_defs_results2.getResults()) {
            Reporter.log( "*   element (unmarshalled): " + oval_defs2, true );
        }
    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={ "oval.repository.QueryResults", "xmlns:oval-def.definition" },
//                                    groups={ "oval.repository.QueryResults", "oval.def.definition" },
                    dataProvider="oval.repository.QueryResults",
                    alwaysRun=true
                    )
    public void testDefinitionQueryResultsXmlMapping(
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

        // (1) unmarshal all the XML files
        Collection<OvalDefinitions>  oval_defs_set = new ArrayList<OvalDefinitions>();
        Collection<DefinitionType>  def_set = new HashSet<DefinitionType>();
        for (String  xml_filepath : xml_filepaths) {
            File  xml_file = new File( xml_filepath );
            OvalDefinitions  oval_defs = _unmarshalObject( object_type, xml_file.getCanonicalPath(), null );
            oval_defs_set.add( oval_defs );
            def_set.addAll( oval_defs.getDefinitions().getDefinition() );
        }
        Assert.assertEquals( xml_filepaths.length, oval_defs_set.size() );

        // (2) build QueryResults
        QueryResults<DefinitionType>  def_results =
                        new QueryResults<DefinitionType>(
                                        (long)def_set.size(), 0L, (long)def_set.size(), def_set );
        Reporter.log( "* query results: " + def_results, true );

        // (3) marshal the QueryResults to an XML file
        File  output_xml_file = File.createTempFile( "query_results_def", ".xml" );
        String  output_xml_filepath = output_xml_file.getCanonicalPath();
        _marshalObject( def_results, output_xml_filepath );

        // (4) validate the marshalled XML file by unmarshalling
        @SuppressWarnings( "unchecked" )
        QueryResults<DefinitionType>  def_results2 =
                        _unmarshalObject( QueryResults.class, output_xml_filepath, null );
        Reporter.log( "* query results (unmarshalled): " + def_results2, true );

        for (DefinitionType  def2 : def_results2.getResults()) {
            Reporter.log( "*   element (unmarshalled): " + def2, true );
        }
    }
}
//
