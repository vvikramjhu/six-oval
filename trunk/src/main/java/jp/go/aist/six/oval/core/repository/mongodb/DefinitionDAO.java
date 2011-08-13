package jp.go.aist.six.oval.core.repository.mongodb;

import jp.go.aist.six.oval.model.v5.definitions.DefinitionType;
import com.google.code.morphia.Datastore;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class DefinitionDAO
    extends OvalEntityDAO<DefinitionType>
//extends BasicDAO<DefinitionType, String>
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

