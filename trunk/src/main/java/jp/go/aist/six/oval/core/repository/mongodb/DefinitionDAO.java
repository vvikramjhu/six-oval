package jp.go.aist.six.oval.core.repository.mongodb;

import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.model.definitions.DefinitionsElementAssoc;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Key;
import com.google.code.morphia.dao.DAO;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class DefinitionDAO
    extends DefinitionsElementDAO<DefinitionType>
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



    //**************************************************************
    //  DAO
    //**************************************************************

    @Override
    public Key<DefinitionType> save(
                    final DefinitionType def
                    )
    {
        DAO<DefinitionsElementAssoc, String>  assoc_dao = _getForwardingDAO( DefinitionsElementAssoc.class );
        DefinitionsElementAssoc  assoc = new DefinitionsElementAssoc( def );
        assoc_dao.save( assoc );

        return super.save( def );
    }

}
//DefinitionDAO

