package jp.go.aist.six.oval.core.datastore.mongodb;

import jp.go.aist.six.oval.model.v5.definitions.SystemObjectType;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.dao.BasicDAO;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class SystemObjectDAO
    extends BasicDAO<SystemObjectType, String>
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

