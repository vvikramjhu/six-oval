package jp.go.aist.six.oval.core.repository.mongodb;

import jp.go.aist.six.oval.model.v5.definitions.StateType;
import com.google.code.morphia.Datastore;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class StateDAO
    extends OvalEntityDAO<StateType>
//    extends BasicDAO<StateType, String>
{

    /**
     */
    public StateDAO(
                    final Datastore ds
                    )
    {
        super( StateType.class, ds );
    }

}
// StateDAO

