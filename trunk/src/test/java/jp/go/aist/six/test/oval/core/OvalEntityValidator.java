package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.model.OvalEntity;
import org.testng.Assert;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class OvalEntityValidator
    extends OvalElementValidator
{

    /**
     * Constructor.
     */
    public OvalEntityValidator()
    {
    }



    public void equals(
                    final OvalEntity actual,
                    final OvalEntity expected
                    )
    {
        super.equals( actual, expected );
        Assert.assertEquals( actual.isDeprecated(), expected.isDeprecated() );
    }

}
// OvalEntityValidator

