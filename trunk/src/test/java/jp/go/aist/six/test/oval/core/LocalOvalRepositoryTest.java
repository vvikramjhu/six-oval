package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.core.service.LocalOvalRepository;
import jp.go.aist.six.oval.model.definition.OvalDefinitions;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
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



    @DataProvider( name="oval_definitions" )
    private Object[][] _ovalDefinitionsProvider()
    {
        return new Object[][] {
                        {
                            "test/data/definition/20100511_oval-vulnerability_microsoft.windows.xp.xml",
                        }
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
                    final String filepath
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL - OvalRepository //", true );

        OvalDefinitions  ovalDefs = _unmarshalFile( filepath, OvalDefinitions.class );

        Reporter.log( "creating OvalDefinitions...", true );
        String  pid = _repository.createOvalDefinitions( ovalDefs );
        Reporter.log( "...find done: PID=" + pid, true );

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

