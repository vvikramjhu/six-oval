package jp.go.aist.six.test.oval.core.xml;

import jp.go.aist.six.oval.model.results.Content;
import jp.go.aist.six.oval.model.results.Directive;
import jp.go.aist.six.oval.model.results.Directives;
import jp.go.aist.six.test.oval.core.CoreTestBase;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import java.io.OutputStream;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalXmlTest
    extends CoreTestBase
{

    /**
     */
    public OvalXmlTest()
    {
    }



    /**
     */
    protected void _marshal(
                    final Object object,
                    final OutputStream out
                    )
    throws Exception
    {
        Reporter.log( "marshalling...", true );
        _getXml().marshal( object, out );
        Reporter.log( "...marshalling done", true );
    }




    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    //
    //  Results
    //
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

    //==============================================================
    //  directives
    //==============================================================

    public static final Directives OVAL_RESULTS_DIRECTIVES_01 =
        new Directives(
                        new Directive( true, Content.FULL ),
                        new Directive( true, Content.FULL ),
                        new Directive( true, Content.FULL ),
                        new Directive( true, Content.FULL ),
                        new Directive( true, Content.FULL ),
                        new Directive( true, Content.FULL )
                        );


    @DataProvider( name="oval-results_directives" )
    public Object[][] provideOvalResultsDirectives()
    {
        return new Object[][] {
                        {
                            Directives.class,
                            "/oval_results/directives",
                            "test/data/results/directives_01.xml",
                            OVAL_RESULTS_DIRECTIVES_01
                        }
        };

    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={"oval.core.xml", "oval-results.directives"},
                    dataProvider="oval-results_directives",
                    alwaysRun=true
                    )
    public void testOvalResultsDirectives(
                    final Class<?> type,
                    final String testedXPath,
                    final String filepath,
                    final Directives expected
                    )
    throws Exception
    {
        Reporter.log( "\n// TEST: OVAL XML //", true );
        Reporter.log( "  * tested XPath: " + testedXPath, true );
        Reporter.log( "  * tested XML file: " + filepath, true );

        Object  actual = _unmarshalFile( filepath, type );

        Reporter.log( "validating...", true );
        Assert.assertEquals( actual, expected );
        Reporter.log( "...validation OK", true );

        _marshal( actual, System.out );
    }

}
// OvalXmlTest

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

