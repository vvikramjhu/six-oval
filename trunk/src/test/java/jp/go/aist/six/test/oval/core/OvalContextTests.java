package jp.go.aist.six.test.oval.core;

import java.util.Properties;
import jp.go.aist.six.oval.core.DeprecatedOvalContext;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalContextTests
{

    /**
     */
    public OvalContextTests()
    {
    }



    /**
     */
    @BeforeClass( alwaysRun=true )
    public void setUp()
    throws Exception
    {
    }



    ///////////////////////////////////////////////////////////////////////
    //  support methods
    ///////////////////////////////////////////////////////////////////////


    ///////////////////////////////////////////////////////////////////////
    //  test data
    ///////////////////////////////////////////////////////////////////////

    /**
     * Configuration property name.
     *
     *   String  Property
     */
    @DataProvider( name="DATA.oval.core.context.property" )
    public Object[][] provideOvalContextPropertyName()
    {
        return new Object[][] {
                        {
                            "six.oval.repository.datastore.engine"
                        }
        };

    }



    ///////////////////////////////////////////////////////////////////////
    //  test methods
    ///////////////////////////////////////////////////////////////////////

    /**
     */
    @org.testng.annotations.Test(
                    groups={
                                    "PACKAGE.oval.core",
                                    "CONTROL.context.property"
                                    }
                    ,dataProvider="DATA.oval.core.context.property"
                    ,alwaysRun=true
                    )
    public void testOvalContextProperty(
                    final String prop_key
                    )
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////", true );

        Reporter.log( "  * property key: " + prop_key, true );
        String  prop_value = DeprecatedOvalContext.getProperty( prop_key );
        Reporter.log( "  * property value: " + prop_value, true );
    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={
                                    "PACKAGE.oval.core",
                                    "CONTROL.context.property"
                                    }
                    ,alwaysRun=true
                    )
    public void testOvalContextProperties()
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////", true );

        Reporter.log( "default properties:::", true );
        Properties  props = DeprecatedOvalContext.getBean( "six-oval-default-properties", Properties.class );
        for (String  key : props.stringPropertyNames()) {
            String  value = props.getProperty( key );
            Reporter.log( "  * property: key=" + key + ", value=" + value, true );
        }

        Reporter.log( "user properties:::", true );
        props = DeprecatedOvalContext.getBean( "six-oval-properties", Properties.class );
        for (String  key : props.stringPropertyNames()) {
            String  value = props.getProperty( key );
            Reporter.log( "  * property: key=" + key + ", value=" + value, true );
        }
    }




}
//
