package jp.go.aist.six.oval.repository;

import java.util.List;
import jp.go.aist.six.oval.model.OvalObject;
import jp.go.aist.six.util.persist.Persistable;



/**
 * A prescription for the low-level repository operations
 * of the OVAL Domain Model objects.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public interface OvalDatastore
{

    /**
     * @throws  OvalRepositoryException
     *  when an exceptional condition occurred during the OVAL repository processing.
     */
    public <K, T extends Persistable<K> & OvalObject>
    T findById( Class<T> type, K id );



    /**
     * @throws  OvalRepositoryException
     *  when an exceptional condition occurred during the OVAL repository processing.
     */
    public <K, T extends Persistable<K> & OvalObject>
    List<T> find( Class<T> type );



    /**
     * @throws  OvalRepositoryException
     *  when an exceptional condition occurred during the OVAL repository processing.
     */
    public <K, T extends Persistable<K> & OvalObject>
    List<T> find( Class<T> type, QueryParams params );



    /**
     * @throws  OvalRepositoryException
     *  when an exceptional condition occurred during the OVAL repository processing.
     */
    public <K, T extends Persistable<K> & OvalObject>
    List<K> findId( Class<T> type );



    /**
     * @throws  OvalRepositoryException
     *  when an exceptional condition occurred during the OVAL repository processing.
     */
    public <K, T extends Persistable<K> & OvalObject>
    List<K> findId( Class<T> type, QueryParams params );



    /**
     * @throws  OvalRepositoryException
     *  when an exceptional condition occurred during the OVAL repository processing.
     */
    public <K, T extends Persistable<K> & OvalObject>
    long count( Class<T> type );



    /**
     * @throws  OvalRepositoryException
     *  when an exceptional condition occurred during the OVAL repository processing.
     */
    public <K, T extends Persistable<K> & OvalObject>
    long count( Class<T> type, QueryParams params );



    /**
     * @throws  OvalRepositoryException
     *  when an exceptional condition occurred during the OVAL repository processing.
     */
    public <K, T extends Persistable<K> & OvalObject>
    K save( Class<T> type, T object );



    /**
     * @throws  OvalRepositoryException
     *  when an exceptional condition occurred during the OVAL repository processing.
     */
    public <K, T extends Persistable<K> & OvalObject>
    void deleteById( Class<T> type, K id );



    /**
     * @throws  OvalRepositoryException
     *  when an exceptional condition occurred during the OVAL repository processing.
     */
    public <K, T extends Persistable<K> & OvalObject>
    void delete( Class<T> type );

}
//
