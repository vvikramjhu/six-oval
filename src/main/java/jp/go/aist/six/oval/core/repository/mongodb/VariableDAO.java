package jp.go.aist.six.oval.core.repository.mongodb;

import jp.go.aist.six.oval.model.definitions.VariableType;
import com.google.code.morphia.Datastore;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class VariableDAO
    extends OvalEntityDAO<VariableType>
//    extends BasicDAO<VariableType, String>
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

