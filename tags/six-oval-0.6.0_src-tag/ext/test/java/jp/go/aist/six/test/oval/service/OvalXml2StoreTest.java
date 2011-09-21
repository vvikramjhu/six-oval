package jp.go.aist.six.test.oval.service;

import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.DefinitionClass;
import jp.go.aist.six.oval.model.results.DefinitionResult;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.model.results.Result;
import jp.go.aist.six.oval.model.results.SystemResult;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import jp.go.aist.six.util.search.RelationalBinding;
import jp.go.aist.six.util.search.SearchCriteria;
import org.testng.Assert;
import org.testng.Reporter;
import java.io.File;
import java.io.FileInputStream;
import java.util.Collection;
import java.util.List;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id: OvalXml2StoreTest.java 763 2010-05-10 08:30:29Z akihito $
 */
public class OvalXml2StoreTest
extends OvalServiceTestBase
{

    /**
     */
    public OvalXml2StoreTest()
    {
    }



    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //
    //  OVAL Results
    //
    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    //==============================================================
    //  oval_results
    //==============================================================

    /**
     */
    @org.testng.annotations.Test( groups={"oval.result", "search.DefinitionResult"},
                    dataProvider="oval-definition-result-result",
//                    dependsOnGroups= {"oval_results"},
                    alwaysRun=true
                    )
    public void findDefinitionResult(
                    final Result result
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL - store //", true );
        Reporter.log( "* object type: oval-res:definition", true );

        Reporter.log( "* target result: " + result, true );
        Reporter.log( "*** finding DefinitionResult...", true );

        Collection<DefinitionResult>  results = _store.find(
                        DefinitionResult.class,
                        RelationalBinding.equalBinding( "result", result ),
                        null, null );
        Reporter.log( "@@@ #results: " + results.size(), true );
        for (DefinitionResult  r : results) {
            Reporter.log( "@@@ result: " + r, true );
        }
    }



    /**
     */
    @org.testng.annotations.Test( groups={"oval.result", "search.system"},
                    dataProvider="oval-system-result-criteria",
//                    dependsOnGroups= {"oval_results"},
                    alwaysRun=true
                    )
    public void searchSystemResult(
                    final SearchCriteria criteria
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL - store //", true );
        Reporter.log( "* object type: oval-res:system", true );

        Reporter.log( "* search criteria: " + criteria, true );
        Reporter.log( "*** searching system result...", true );
        List<?>  results = _store.search( SystemResult.class, criteria );
        Reporter.log( "@@@ #results: " + results.size(), true );
        if (results.size() > 0) {
            Reporter.log( "@@@ result[0]: " + results.get( 0 ), true );
        }
    }



    /**
     */
    @org.testng.annotations.Test( groups={"oval.result", "oval_results"},
                    dataProvider="oval-result-results",
                    dependsOnGroups= {"oval-def"},
                    alwaysRun=true
                    )
    public void processResultResults(
                    final String filepath
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL - XML and store //", true );
        Reporter.log( "  * object type: oval-res:oval_results", true );

        File  file = new File( filepath );
        Reporter.log( "  * unmarshalling XML...", true );
        Object  obj = _xml.unmarshal( new FileInputStream( file ) );
        Reporter.log( "  @ unmarshalled object: " + obj, true );

        Assert.assertNotNull( obj );
        Assert.assertTrue( obj instanceof OvalResults );

        OvalResults  results = OvalResults.class.cast( obj );

        Reporter.log( "  * marshalling XML...", true );
        String  xml = _xml.marshalToString( results );
        Reporter.log( "  @ marshalled XML (1024): " + xml.substring( 0, 1024 ), true );

        Reporter.log( "  * creating object...", true );
        String  pid = _store.create( OvalResults.class, results );
        Reporter.log( "  @ created: pid=" + pid, true );

        Reporter.log( "  * finding object...: pid=" + pid, true );
        OvalResults  p_results = _store.get( OvalResults.class, pid );
        Reporter.log( "  @ found: " + p_results, true );
    }



    //==============================================================
    //  oval-res : definition
    //==============================================================

    /**
     */
    @org.testng.annotations.Test( groups={"oval.service", "oval-res"},
                    dataProvider="oval-result-definition",
                    dependsOnGroups= {"oval-def"},
                    alwaysRun=true
                    )
    public void processResultDefinition(
                    final String filepath,
                    final String id,
                    final int version,
                    final Result result
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL - XML and store //", true );
        Reporter.log( "  * object type: oval-res:definition", true );

        File  file = new File( filepath );
        Reporter.log( "  * unmarshalling XML...", true );
        Object  obj = _xml.unmarshal( new FileInputStream( file ) );
        Reporter.log( "  @ unmarshalled object: " + obj, true );

        Assert.assertNotNull( obj );
        Assert.assertTrue( obj instanceof DefinitionResult );

        DefinitionResult  def = DefinitionResult.class.cast( obj );
        Assert.assertEquals( id, def.getOvalID() );
        Assert.assertEquals( version, def.getOvalVersion() );
        Assert.assertEquals( result, def.getResult() );

        Reporter.log( "  * marshalling XML...", true );
        String  xml = _xml.marshalToString( def );
        Reporter.log( "  @ marshalled XML: " + xml, true );

//        Reporter.log( "  * syncing object...", true );
//        Definition  p_def = _store.sync( def );
//        Reporter.log( "  @ synced: pid=" + p_def.getPersistentID(), true );
    }



    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //
    //  OVAL System Characteristics
    //
    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    //==============================================================
    //  oval_system_characteristics
    //==============================================================

    /**
     */
    @org.testng.annotations.Test( groups={"oval.system", "sc"},
                    dataProvider="oval-system-sc",
                    alwaysRun=true
                    )
    public void processSystemSC(
                    final String filepath
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL - XML and store //", true );
        Reporter.log( "  * object type: oval-sc:oval_system_characteristics", true );

        File  file = new File( filepath );
        Reporter.log( "  * unmarshalling XML...", true );
        Object  obj = _xml.unmarshal( new FileInputStream( file ) );
        Reporter.log( "  @ unmarshalled object: " + obj, true );

        Assert.assertNotNull( obj );
        Assert.assertTrue( obj instanceof OvalSystemCharacteristics );

        OvalSystemCharacteristics  sc = OvalSystemCharacteristics.class.cast( obj );

        Reporter.log( "  * marshalling XML...", true );
        String  xml = _xml.marshalToString( sc );
        Reporter.log( "  @ marshalled XML (1024): " + xml.substring( 0, 1024 ), true );

        Reporter.log( "  * creating object...", true );
        String  pid = _store.create( OvalSystemCharacteristics.class, sc );
        Reporter.log( "  @ created: pid=" + pid, true );

        Reporter.log( "  * finding object...: pid=" + pid, true );
        OvalSystemCharacteristics  p_sc = _store.get( OvalSystemCharacteristics.class, pid );
        Reporter.log( "  @ found: " + p_sc, true );
    }



    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //
    //  OVAL Definition
    //
    // %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    //==============================================================
    //  definition
    //==============================================================

    /**
     */
    @org.testng.annotations.Test( groups={"oval.definition", "definition"},
                    dataProvider="oval-definition",
                    dependsOnGroups="object",
                    alwaysRun=true
                    )
    public void processDefinition(
                    final String filepath,
                    final String id,
                    final int version,
                    final DefinitionClass clazz
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL - unmarshalling XML and syncing with store //", true );
        Reporter.log( "  * object type: oval-def:definition", true );

        File  file = new File( filepath );
        Reporter.log( "  * unmarshalling XML...", true );
        Object  obj = _xml.unmarshal( new FileInputStream( file ) );
        Reporter.log( "  @ unmarshalled object: " + obj, true );

        Assert.assertNotNull( obj );
        Assert.assertTrue( obj instanceof Definition );

        Definition  def = Definition.class.cast( obj );
        Assert.assertEquals( id, def.getOvalID() );
        Assert.assertEquals( version, def.getOvalVersion() );
        Assert.assertEquals( clazz, def.getDefinitionClass() );

        Reporter.log( "  * marshalling XML...", true );
        String  xml = _xml.marshalToString( def );
        Reporter.log( "  @ marshalled XML: " + xml, true );

        Reporter.log( "  * syncing object...", true );
        Definition  p_def = _store.sync( Definition.class, def );
        Reporter.log( "  @ synced: pid=" + p_def.getPersistentID(), true );
    }

}
// OvalXml2StoreTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */
