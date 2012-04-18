package jp.go.aist.six.oval.core.repository.mongodb;

import jp.go.aist.six.oval.model.definitions.DefinitionsElementAssoc;
import jp.go.aist.six.oval.model.definitions.TestType;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Key;
import com.google.code.morphia.dao.DAO;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class TestDAO
    extends DefinitionsElementDAO<TestType>
{

    /**
     */
    public TestDAO(
                    final Datastore ds
                    )
    {
        super( TestType.class, ds );
    }



    //**************************************************************
    //  DAO
    //**************************************************************

    @Override
    public Key<TestType> save(
                    final TestType tst
                    )
    {
        DAO<DefinitionsElementAssoc, String>  assoc_dao = _getForwardingDAO( DefinitionsElementAssoc.class );
        DefinitionsElementAssoc  assoc = new DefinitionsElementAssoc( tst );
        assoc_dao.save( assoc );

        return super.save( tst );
    }

}
//

