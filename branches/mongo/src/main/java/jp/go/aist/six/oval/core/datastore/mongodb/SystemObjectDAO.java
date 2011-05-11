package jp.go.aist.six.oval.core.datastore.mongodb;

import jp.go.aist.six.oval.model.v5.definitions.SystemObjectType;
import org.bson.types.ObjectId;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.dao.BasicDAO;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class SystemObjectDAO
    extends BasicDAO<SystemObjectType, ObjectId>
{

    /**
     */
    public SystemObjectDAO(
                    final Datastore ds
                    )
    {
        super( SystemObjectType.class, ds );
    }

}
// SystemObjectDAO

