package jp.go.aist.six.test.oval.core.store;

import jp.go.aist.six.oval.model.common.DefinitionClass;
import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.util.persist.Persistable;
import jp.go.aist.six.util.search.Binding;
import jp.go.aist.six.util.search.LikeBinding;
import jp.go.aist.six.util.search.RelationalBinding;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import java.util.Collection;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalStoreQueryTest
    extends OvalStoreTest
{

    /**
     */
    public OvalStoreQueryTest()
    {
    }



    /**
     */
    protected <K, T extends Persistable<K>> void _testStoreQuery(
                    final Class<T> type,
                    final Binding filter
                    )
    throws Exception
    {
        Reporter.log( "\n////////////////////////////////////////////////////////////////", true );
        Reporter.log( "  * object type: " + type, true );
        Reporter.log( "  * filter: " + filter, true );

        Reporter.log( "count..." , true );
        long  time = System.currentTimeMillis();
        int  count = _getStore().count( type, filter );
        Reporter.log( "...count done: "
                        + (System.currentTimeMillis() - time) + "(ms)", true );
        Reporter.log( "results: #objects=" + count, true );

        Reporter.log( "findIdentity..." , true );
        time = System.currentTimeMillis();
        Collection<K>  pids = _getStore().findIdentity( type, filter );
        Reporter.log( "...findIdentity done: "
                        + (System.currentTimeMillis() - time) + "(ms)", true );
        Reporter.log( "results: #ids=" + pids.size(), true );
        Reporter.log( "        @ ids=" + pids, true );

        Reporter.log( "find..." , true );
        time = System.currentTimeMillis();
        Collection<T>  pobjects = _getStore().find( type, filter );
        Reporter.log( "...find done: "
                        + (System.currentTimeMillis() - time) + "(ms)", true );
        Reporter.log( "results: #objects=" + pobjects.size(), true );
        for (T  pobject : pobjects) {
            K  pid = pobject.getPersistentID();
            Reporter.log( "  @ pid=" + pid, true );
        }
    }



    //==============================================================
    //  definition
    //==============================================================

    @DataProvider( name="query.definitions.definition" )
    public Object[][] provideDefinitionsDefinitionQuery()
    {
        RelationalBinding  classFilter =
            RelationalBinding.notEqualBinding(
                            "definitionClass",
                            DefinitionClass.VULNERABILITY
            );

        LikeBinding  titleFilter =
            new LikeBinding(
                            "metadata.title",
                            "%5.1%"
            );

        RelationalBinding  referenceFilter =
            RelationalBinding.equalBinding(
                            "metadata.reference.refID",
                            "CVE-2009-4019"
            );


        return new Object[][] {
                        {
                            Definition.class,
                            classFilter
                        }
                        ,
                        {
                            Definition.class,
                            titleFilter
                        }
                        ,
                        {
                            Definition.class,
                            referenceFilter
                        }
        };
    }



    @org.testng.annotations.Test(
                    groups={"oval.core.store", "query.definitions.definition"},
                    dataProvider="query.definitions.definition",
                    alwaysRun=true
                    )
    public <K, T extends Persistable<K>> void testDefinitionsDefinitionQuery(
                    final Class<T> type,
                    final Binding  filter
                    )
    throws Exception
    {
        _testStoreQuery( type, filter );
    }

}
// OvalStoreQueryTest

