package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.core.service.LocalOvalRepository;
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
        _repository = new LocalOvalRepository();
    }



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
                    groups={"oval.service"},
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

