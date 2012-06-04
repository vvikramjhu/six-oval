package jp.go.aist.six.oval.core.repository.mongodb;

import jp.go.aist.six.oval.model.definitions.SystemObjectType;
import com.google.code.morphia.Datastore;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class SystemObjectDAO
    extends DefinitionsElementDAO<SystemObjectType>
//    extends OvalEntityDAO<SystemObjectType>
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

