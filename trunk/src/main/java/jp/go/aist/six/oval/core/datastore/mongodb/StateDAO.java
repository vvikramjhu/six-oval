package jp.go.aist.six.oval.core.datastore.mongodb;

import jp.go.aist.six.oval.model.v5.definitions.StateType;
import org.bson.types.ObjectId;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.dao.BasicDAO;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class StateDAO
    extends BasicDAO<StateType, ObjectId>
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

