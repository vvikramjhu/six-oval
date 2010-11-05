package jp.go.aist.six.test.oval.core.store;

import jp.go.aist.six.oval.model.common.DefinitionClass;
import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.util.orm.Persistable;
import jp.go.aist.six.util.search.Binding;
import jp.go.aist.six.util.search.LikeBinding;
import jp.go.aist.six.util.search.RelationalBinding;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import java.util.List;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class StoreQueryTest
    extends OvalStoreTest
{

    /**
     */
    public StoreQueryTest()
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

        Reporter.log( "find..." , true );
        long  time = System.currentTimeMillis();
        List<T>  persistents = _getStore().find( type, filter );
        Reporter.log( "...find done: " + (System.currentTimeMillis() - time) + "(ms)", true );

        Reporter.log( "results: #objects=" + persistents.size(), true );
        for (T  persistent : persistents) {
            K  pid = persistent.getPersistentID();
            Reporter.log( "  @ pid=" + pid, true );
            Reporter.log( "  @ object=" + persistent, true );
        }
    }



    //==============================================================
    //  definition
    //==============================================================

    @DataProvider( name="query.definitions.definition" )
    public Object[][] provideDefinitionsDefinitionQuery()
    {
        RelationalBinding  classFilter =
            RelationalBinding.equalBinding(
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
// StoreQueryTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

