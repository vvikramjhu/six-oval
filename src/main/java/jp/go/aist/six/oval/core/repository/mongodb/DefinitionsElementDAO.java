package jp.go.aist.six.oval.core.repository.mongodb;

import jp.go.aist.six.oval.model.definitions.DefinitionsElement;
import com.google.code.morphia.Datastore;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class DefinitionsElementDAO<T extends DefinitionsElement>
    extends BaseDAO<T, String>
{

    /**
     */
    public DefinitionsElementDAO(
                    final Class<T> type,
                    final Datastore ds
                    )
    {
        super( type, ds );
    }



    //**************************************************************
    //  DAO
    //**************************************************************

}
//

