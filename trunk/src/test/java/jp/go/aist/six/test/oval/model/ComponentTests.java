package jp.go.aist.six.test.oval.model;

import jp.go.aist.six.oval.model.Component;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;



/**
 * Tests: oval.model.Component.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class ComponentTests
{

    //**************************************************************
    // Arrangement
    //**************************************************************

    /**
     */
    @BeforeClass( alwaysRun=true )
	public void setUp()
    throws Exception
	{
	}



    //**************************************************************
    // Test Methods
    //**************************************************************

    /**
     */
    @org.testng.annotations.Test(
                    groups={ "oval.model" },
                    alwaysRun=true
                    )
    public void testComponent()
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////", true );
        Reporter.log( "*** target class: oval.model.Component", true );

        Reporter.log( "* listing all the names and values...", true );
        for (Component  c : Component.values()) {
            Reporter.log( "name=: " + c.name() + ", value=" + c.value(), true );
        }
    }

}
//
