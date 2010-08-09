package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.core.service.LocalOvalRepository;
import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.Definitions;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.model.sc.CollectedSystemObject;
import jp.go.aist.six.oval.model.sc.Item;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import java.util.Arrays;
import java.util.Collection;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class LocalOvalRepositoryTest
    extends CoreTestBase
{

    private LocalOvalRepository  _repository;





    /**
     */
    @BeforeClass( alwaysRun=true )
    public void setUp()
    throws Exception
    {
        super.setUp();
        _repository = new LocalOvalRepository();
    }



    //==============================================================
    //  results
    //==============================================================

    @DataProvider( name="oval_results" )
    private Object[][] _ovalResultsProvider()
    {
        return new Object[][] {
                        // windows vulnerability, IE6, CVE-2006-1189
                        {
                            "test/data/result/oval-2010-06-15.05.04.34_results.xml",
                        }
//                        ,
//
//                        // windows vulnerability, CVE-2010-0176
//                        {
//                            "test/data/result/oval-2010-07-15.03.55.24_CVE-2010-0176_results.xml",
//                        }
//                        ,
//
//                        // Red Hat patch, CVE-2010-0176, RHSA 20100332
//                        {
//                            "test/data/result/com.redhat.rhsa-20100332_CVE-2010-0176_results.xml",
//                        }
//                        ,
//
//                        // Red Hat patch, CVE-2010-0176, RHSA 20100333
//                        {
//                            "test/data/result/com.redhat.rhsa-20100332_CVE-2010-0176_results.xml",
//                        }
//                        ,
//
//                        // Debian patch, CVE-2010-0176
//                        {
//                            "test/data/result/oval-2010-07-27.04.27.53_DSA-2027_results.xml",
//                        }
//                        ,

//                        // windows vulnerability
//                        {
//                            "test/data/result/oval-2010-06-15.05.04.34_results.xml",
//                        }
//                        ,

//                        // windows inventory
//                        {
//                            "test/data/result/sample_oval-results_inventory_windows-xp.xml",
//                        }
//                        ,

        };

    }


    /**
     */
    @org.testng.annotations.Test(
                    groups={"oval.service.repository", "oval_results"},
                    dataProvider="oval_results",
                    alwaysRun=true
                    )
    public void testCreateOvalResults(
                    final String filepath
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL - OvalRepository //", true );

        OvalResults  ovalResults = _unmarshalFile( filepath, OvalResults.class );

        Reporter.log( "creating OvalResults...", true );
        String  pid = _repository.createOvalResults( ovalResults );
        Reporter.log( "...create done: PID=" + pid, true );

        String  sc_pid = ovalResults.getResults().iterator().next().getOvalSystemCharacteristics().getPersistentID();
//        _getItem( sc_pid );

        Reporter.log( "getting OvalSC: PID=" + sc_pid, true );
        OvalSystemCharacteristics  sc = _repository.getOvalSystemCharacteristics( sc_pid );
        Reporter.log( "...get done: PID=" + sc.getPersistentID(), true );
        Reporter.log( "  @ OvalSC: " + sc, true );
        Reporter.log( "  collected_objects: ", true );
        for (CollectedSystemObject  object : sc.getCollectedObjects()) {
            Reporter.log( "  @ object: " + object, true );
        }
        Reporter.log( "  items: ", true );
        for (Item  item : sc.getSystemData().getItem()) {
            Reporter.log( "  @ item: " + item, true );
        }

        Reporter.log( "getting OvalResults: PID=" + pid, true );
        ovalResults = _repository.getOvalResults( pid );
        Reporter.log( "...get done: PID=" + ovalResults.getPersistentID(), true );
    }



    private void _getItem(
                    final String scPID
                    )
    throws Exception
    {
        Reporter.log( "  items: ", true );
        Collection<Item>  items = _repository.getItem( scPID );
        for (Item  item : items) {
            Reporter.log( "  @ item: " + item, true );
        }
    }


    //==============================================================
    //  oval-definitions
    //==============================================================

    @DataProvider( name="oval_definitions" )
    private Object[][] _ovalDefinitionsProvider()
    {
        return new Object[][] {
                        // windows vulnerability, oval:org.mitre.oval:def:8500, CVE-2009-4019
                        {
                            "test/data/definitions/oval-definitions_CVE-2009-4019_MySQL.xml",
                            new String[] {
                                            "oval:org.mitre.oval:def:8500",
                                            "oval:org.mitre.oval:def:8297",
                                            "oval:org.mitre.oval:def:8282"
                            }
                        }
                        ,

                        // Windows @Mitre, CVE-2010-0176
                        {
                            "test/data/definitions/oval-definitions_CVE-2010-0176_mitre7222.xml",
                            new String[] {
                                            "oval:org.mitre.oval:def:7222",
                                            "oval:org.mitre.oval:def:6562",
                                            "oval:org.mitre.oval:def:6504",
                                            "oval:org.mitre.oval:def:6372"
                            }
                        }
                        ,

                        // Red Hat, CVE-2010-0176
                        {
                            "test/data/definitions/oval-definitions_CVE-2010-0176_rhsa20100333.xml",
                            new String[] {
                                            "oval:com.redhat.rhsa:def:20100333"
                            }
                        }

//                        // windows vulnerability
//                        {
//                            "test/data/definition/oval-2010-06-15.05.04.34.xml",
//                        }
//                        ,

//                        // windows vulnerability
//                        {
//                            "test/data/definition/20100714_oval-vulnerability_microsoft.windows.xp.xml",
//                        }
//                        ,

//                        // Red Hat patch
//                        {
//                            "test/data/definition/20100713_com.redhat.rhsa-all.xml",
//                        }
                        //Note:
                        // contains "cve" elements without CVE names.
                        // "oval:com.redhat.rhsa:def:20070993", line# 58399
                        // "oval:com.redhat.rhsa:def:20071041", line# 59705
                        // "oval:com.redhat.rhsa:def:20080132", line# 65682
                        //
        };

    }


    /**
     */
    @org.testng.annotations.Test(
                    groups={"oval.service.repository", "oval_definitions"},
                    dataProvider="oval_definitions",
                    alwaysRun=true
                    )
    public void testCreateOvalDefinitions(
                    final String filepath,
                    final String[] defIDs
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL - OvalRepository //", true );

        Reporter.log( "unmarshalling XML...", true );
        OvalDefinitions  ovalDefs = _unmarshalFile( filepath, OvalDefinitions.class );
        Reporter.log( "...unmarshal OK", true );

        Collection<String>  defIDCollection = Arrays.asList( defIDs );
        _validateOvalDefinitions( ovalDefs, defIDCollection );

        Reporter.log( "checking Criteria...", true );
        for (Definition  def : ovalDefs.getDefinitions()) {

        }

        Reporter.log( "creating OvalDefinitions...", true );
        String  pid = _repository.createOvalDefinitions( ovalDefs );
        Reporter.log( "...create OvalDefinitions OK", true );
        Reporter.log( "  @ OvalalDefinitions.PID=" + pid, true );

        Reporter.log( "getting OvalDefinitions...", true );
        OvalDefinitions  ovalDefsP = _repository.getOvalDefinitions( pid );
        Reporter.log( "...getting OvalDefinitions OK", true );
        Reporter.log( "  @ OvalDefinitions=" + ovalDefsP, true );
//        _validateOvalDefinitions( ovalDefsP, defIDCollection );

        for (Definition  def : ovalDefs.getDefinitions()) {
            String  defPID = def.getPersistentID();
            Reporter.log( "getting Definition...: PID=" + defPID, true );
            Definition  defP = _repository.getDefinition( defPID );
            Reporter.log( "  @ Definition=" + defP, true );
            Reporter.log( "    - related CVE: " + defP.getRelatedCve(), true );
        }
    }



    private void _validateOvalDefinitions(
                    final OvalDefinitions ovalDefs,
                    final Collection<String> defIDs
                    )
    {
        Reporter.log( "validating...", true );
        Definitions  defs = ovalDefs.getDefinitions();
        Assert.assertEquals( defs.size(), defIDs.size() );
        for (Definition  def : defs) {
            Assert.assertTrue( defIDs.contains( def.getOvalID() ) );
        }
        Reporter.log( "...validation OK", true );
    }



    // CVE //

    @DataProvider( name="cve-name" )
    public Object[][] ovalCveNameProvider()
    {
        return new Object[][] {
                        { "CVE-2010-0001" }
                        ,

                        { "CVE-2006-1189" }
                        ,

                        { "CVE-2100-0001" }
        };
    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={"oval.service.repository", "cve"},
                    dataProvider="cve-name",
                    alwaysRun=true
                    )
    public void testFindDefinitionIDByCve(
                    final String cve
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL - RepositoryService //", true );

        Reporter.log( "finding Definition ID by CVE...: " + cve, true );
        Collection<String>  defIDs = _repository.findDefinitionIDByCve( cve );
        Reporter.log( "...find done", true );

        if (defIDs.size() == 0) {
            Reporter.log( "  @ no Definition found", true );
        } else {
            for (String  defID : defIDs) {
                Reporter.log( "  @ Definition ID: " + defID, true );
            }
        }
    }

}
// OvalStoreTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

