package jp.go.aist.six.oval.core.repository.mongodb;

import jp.go.aist.six.oval.model.definitions.ElementReferencingMap;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.dao.BasicDAO;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class ElementAssocDAO
    extends BasicDAO<ElementReferencingMap, String>
{

    /**
     */
    public ElementAssocDAO(
                    final Datastore ds
                    )
    {
        super( ElementReferencingMap.class, ds );
    }

}
//

