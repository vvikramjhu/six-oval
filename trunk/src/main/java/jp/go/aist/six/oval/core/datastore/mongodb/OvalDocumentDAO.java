package jp.go.aist.six.oval.core.datastore.mongodb;

import jp.go.aist.six.oval.model.v5.OvalDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Key;
import com.google.code.morphia.query.Query;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class OvalDocumentDAO<T extends OvalDocument>
    extends BaseDAO<T, String>
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ =
        LoggerFactory.getLogger( OvalDocumentDAO.class );



    /**
     */
    public OvalDocumentDAO(
                    final Class<T> type,
                    final Datastore ds
                    )
    {
        super( type, ds );
    }




    /**
     */
    protected abstract Query<T> _createUniqueQuery(
                    T oval_document
                    );
//    {
//        Query<T>  q = createQuery();
//    }


    protected Key<T> _findUniqueKey(
                    final T oval_document
                    )
    {
        Query<T>  q = _createUniqueQuery( oval_document );

        _LOG_.debug( "find unique: query=" + q );
        Key<T>  id = find( q ).getKey();
        _LOG_.debug( "find unique: id=" + id );

        return id;
    }



    //**************************************************************
    //  DAO
    //**************************************************************

    @Override
    public Key<T> save(
                    final T oval_document
                    )
    {
        Key<T>  key = _findUniqueKey( oval_document );
        if (key == null) {
            key = super.save( oval_document );
        } else {
            oval_document.setPersistentID( String.valueOf( key.getId() ) );
        }

//        //compute the digest!!!
//        oval_definitions.getDefinitionsDigest();

        return key;

    }

}
// OvalDefinitionsDAO

