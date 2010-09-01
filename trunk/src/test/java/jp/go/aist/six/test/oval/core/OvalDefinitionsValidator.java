package jp.go.aist.six.test.oval.core;

import jp.go.aist.six.oval.model.OvalElement;




/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class OvalElementValidator
    extends Validator
{

    /**
     * Constructor.
     */
    public OvalElementValidator()
    {
    }



    public void equals(
                    final OvalElement actual,
                    final OvalElement expected
                    )
    {
        super.equals( actual, expected );
    }

}
// OvalElementValidator

