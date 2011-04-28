package jp.go.aist.six.oval.core.store.mongo;

import jp.go.aist.six.oval.model.v5.definitions.DefinitionType;
import org.bson.types.ObjectId;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.dao.BasicDAO;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class DefinitionDAO
    extends BasicDAO<DefinitionType, ObjectId>
{

    /**
     */
    public DefinitionDAO(
                    final Datastore ds
                    )
    {
        super( DefinitionType.class, ds );
    }

}
// DefinitionDAO

