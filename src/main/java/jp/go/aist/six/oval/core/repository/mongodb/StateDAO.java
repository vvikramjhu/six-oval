package jp.go.aist.six.oval.core.repository.mongodb;

import jp.go.aist.six.oval.model.definitions.StateType;
import com.google.code.morphia.Datastore;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class StateDAO
    extends DefinitionsElementDAO<StateType>
//    extends OvalEntityDAO<StateType>
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

