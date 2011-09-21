package jp.go.aist.six.oval.core.repository.mongodb;

import jp.go.aist.six.oval.model.definitions.TestType;
import com.google.code.morphia.Datastore;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class TestDAO
    extends OvalEntityDAO<TestType>
//    extends BasicDAO<TestType, String>
{

    /**
     */
    public TestDAO(
                    final Datastore ds
                    )
    {
        super( TestType.class, ds );
    }

}
// TestDAO

