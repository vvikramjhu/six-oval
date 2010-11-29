package jp.go.aist.six.test.oval.core.rest;

import jp.go.aist.six.oval.core.rest.OvalRepositoryClient;
import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import jp.go.aist.six.test.oval.core.CoreTestBase;
import jp.go.aist.six.test.oval.core.Validators;
import org.testng.Assert;
import org.testng.Reporter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalRestTest
    extends CoreTestBase
{

    /**
     */
    public OvalRestTest()
    {
    }



    //==============================================================
    //  oval_definitions
    //==============================================================

    @org.testng.annotations.Test(
                    groups={"oval.core.rest", "definitions.definition"},
                    alwaysRun=true
                    )
    public void testDefinitionsFindDefinition()
    throws Exception
    {
        OvalRepositoryClient  client = _getContext().getBean( "ovalRepositoryRestClient", OvalRepositoryClient.class );

//        String  cveName = "CVE-2010-0030";
//        Reporter.log( "finding Definition... cve=" + cveName, true );
//        List<Definition>  list = client.findDefinitionByCve( cveName );

        Map<String, String>  params = new HashMap<String, String>();
//        params.put( "metadata.reference.refID", "CVE-2010-0030" );
        params.put( "metadata.reference.source", "CPE" );
        params.put( "metadata.title", "Microsoft PowerPoint 2002 is installed" );
        List<Definition>  list = client.findDefinition( params );

        Reporter.log( "#results=" + list.size(), true );
        for (Definition  def : list) {
            Reporter.log( def.toString(), true );
        }
    }



    //==============================================================
    //  oval_sc
    //==============================================================

    @org.testng.annotations.Test(
                    groups={"oval.core.rest", "sc.oval_sc"},
                    dataProvider="sc.oval_sc",
                    alwaysRun=true
                    )
    public void testResultsOvalSystemCharacteristics(
                    final Class<OvalSystemCharacteristics> type,
                    final String filepath,
                    final String xpath,
                    final OvalSystemCharacteristics expected
                    )
    throws Exception
    {
        OvalSystemCharacteristics  actual = _unmarshalWithValidation( type, filepath, xpath, expected );
        Assert.assertNotNull( actual );

        OvalRepositoryClient  client = _getContext().getBean( "ovalRepositoryRestClient", OvalRepositoryClient.class );
        String  pid = client.createOvalSystemCharacteristics( actual );

        OvalSystemCharacteristics  actual2 = client.getOvalSystemCharacteristics( pid );
        if (expected != null) {
            Reporter.log( "validating...", true );
            Validators.validator( type ).equals( actual2, expected );
            Reporter.log( "...validation OK", true );
        }
    }



    //==============================================================
    //  oval_results
    //==============================================================

    @org.testng.annotations.Test(
                    groups={"oval.core.rest", "results.oval_results"},
                    dataProvider="results.oval_results",
                    alwaysRun=true
                    )
    public void testResultsOvalResults(
                    final Class<OvalResults> type,
                    final String filepath,
                    final String xpath,
                    final OvalResults expected
                    )
    throws Exception
    {
        OvalResults  actual = _unmarshalWithValidation( type, filepath, xpath, expected );
        Assert.assertNotNull( actual );

        OvalRepositoryClient  client = _getContext().getBean( "ovalRepositoryRestClient", OvalRepositoryClient.class );
        String  pid = client.createOvalResults( actual );

        OvalResults  actual2 = client.getOvalResults( pid );
        if (expected != null) {
            Reporter.log( "validating...", true );
            Validators.validator( type ).equals( actual2, expected );
            Reporter.log( "...validation OK", true );
        }
    }

}
// OvalStoreTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

