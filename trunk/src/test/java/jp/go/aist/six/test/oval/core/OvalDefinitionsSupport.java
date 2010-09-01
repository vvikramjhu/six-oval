package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.model.definitions.State;
import org.testng.Assert;




public class OvalDefinitionsSupport
{

    /**
     */
    public static class StateValidator
    extends Validator.OvalEntityValidator
    {

        public void equals(
                        final State actual,
                        final State expected
                        )
        {
            super.equals( actual, expected );
            Assert.assertEquals( actual.getOperator(), expected.getOperator() );
        }

    }
    // StateValidator

}
// OvalDefinitionsValidator

