package jp.go.aist.six.oval.core.repository.mongodb;

import jp.go.aist.six.oval.model.definitions.DefinitionsElementAssoc;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.dao.BasicDAO;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class DefinitionsElementAssocDAO
    extends BasicDAO<DefinitionsElementAssoc, String>
{

    /**
     */
    public DefinitionsElementAssocDAO(
                    final Datastore ds
                    )
    {
        super( DefinitionsElementAssoc.class, ds );
    }

}
//

