package jp.go.aist.six.oval.core.datastore.mongodb;

import jp.go.aist.six.oval.model.v5.definitions.DefinitionType;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.dao.BasicDAO;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class DefinitionDAO
    extends BasicDAO<DefinitionType, String>
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

