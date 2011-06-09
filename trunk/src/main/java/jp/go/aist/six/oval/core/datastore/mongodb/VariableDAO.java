package jp.go.aist.six.oval.core.datastore.mongodb;

import jp.go.aist.six.oval.model.v5.definitions.VariableType;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.dao.BasicDAO;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class VariableDAO
    extends BasicDAO<VariableType, String>
{

    /**
     */
    public VariableDAO(
                    final Datastore ds
                    )
    {
        super( VariableType.class, ds );
    }

}
// VariableDAO

