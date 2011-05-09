package jp.go.aist.six.test.oval.core.datastore.mongodb;

import jp.go.aist.six.oval.model.v5.definitions.CriteriaType;
import org.bson.types.ObjectId;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.dao.BasicDAO;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class CriteriaDAO
extends BasicDAO<CriteriaType, ObjectId>
{

    /**
     */
    public CriteriaDAO(
                    final Datastore ds
                    )
    {
        super( CriteriaType.class, ds );
    }

}
// CriteriaDAO

