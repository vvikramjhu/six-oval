package jp.go.aist.six.test.oval.model;

import jp.go.aist.six.oval.model.ComponentType;
import jp.go.aist.six.oval.model.Family;
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
                    groups={ "MODEL.oval" },
                    alwaysRun=true
                    )
    public void testComponent()
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////", true );
        Reporter.log( "*** target class: " + ComponentType.class.getName(), true );

        Reporter.log( "* listing all the names and values...", true );
        for (ComponentType  c : ComponentType.values()) {
            Reporter.log( "name=: " + c.name() + ", value=" + c.value(), true );
        }
        Reporter.log( "* #enum constants: " + ComponentType.values().length, true );
    }



    /**
     */
    @org.testng.annotations.Test(
                    groups={ "MODEL.oval" },
                    alwaysRun=true
                    )
    public void testFamily()
    throws Exception
    {
        Reporter.log( "\n//////////////////////////////////////////////////////////", true );
        Reporter.log( "*** target class: " + Family.class.getName(), true );

        Reporter.log( "* listing all the names and values...", true );
        for (Family  f : Family.values()) {
            Reporter.log( "name=: " + f.name() + ", value=" + f.value(), true );
        }
        Reporter.log( "* #enum constants: " + Family.values().length, true );
    }

}
//