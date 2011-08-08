package jp.go.aist.six.oval.core.datastore.mongodb;

import jp.go.aist.six.oval.model.v5.OvalEntity;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Key;
import com.google.code.morphia.dao.BasicDAO;
import com.google.code.morphia.query.Query;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalEntityDAO<T extends OvalEntity>
    extends BasicDAO<T, String>
{

    /**
     */
    public OvalEntityDAO(
                    final Class<T> type,
                    final Datastore ds
                    )
    {
        super( type, ds );
    }



    /**
     */
    protected Key<T> _findUniqueKey(
                    final T object
                    )
    {
        Query<T>  query = createQuery();

        query.filter( "oval_id",      object.getOvalID() );
        query.filter( "oval_version", object.getOvalVersion() );

        Key<T>  id = find( query ).getKey();

        return id;
    }



    //**************************************************************
    //  DAO
    //**************************************************************

    @Override
    public Key<T> save(
                    final T object
                    )
    {
        Key<T>  key = _findUniqueKey( object );
        if (key == null) {
            key = super.save( object );
        } else {
            object.setPersistentID( String.valueOf( key.getId() ) );
        }

        return key;
    }


}
// OvalEntityDAO

