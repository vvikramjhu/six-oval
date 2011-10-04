/*
 *  @product.title@
 *  Copyright (C) @product.copyright-year@
 *    @product.vendor@
 *    Registration Number: @product.registration-number@
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package jp.go.aist.six.oval.repository;

import java.util.List;
import jp.go.aist.six.oval.model.OvalObject;
import jp.go.aist.six.util.persist.Persistable;
import jp.go.aist.six.util.search.Binding;
import jp.go.aist.six.util.search.Limit;
import jp.go.aist.six.util.search.Order;



/**
 * A prescription of the OVAL repository basic operations.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public interface OvalRepository
{

    /**
     * Returns the object of the specified identifier.
     * If no such object exists, this method returns null.
     *
     * @param   type
     *  the type of the object.
     * @param   id
     *  the identifier of the object.
     */
    public <K, T extends OvalObject & Persistable<K>>
    T get(
                    Class<T> type,
                    K id
                    )
    throws OvalRepositoryException;



    /**
     * Creates a new object in the repository.
     * If an object which has the same identifier already exists in the repository,
     * an exception is thrown.
     *
     * @param   type
     *  the type of the object.
     * @param   object
     *  the object to create.
     * @return
     *  the identifier of the created object.
     */
    public <K, T extends OvalObject & Persistable<K>>
    K create(
                    Class<T> type,
                    T object
                    )
    throws OvalRepositoryException;



    /**
     * Updates the object, or inserts it to the repository if it does NOT exist.
     *
     * @param   type
     *  the type of the object.
     * @param   object
     *  the object to save.
     * @return
     *  the object.
     */
    public <K, T extends OvalObject & Persistable<K>>
    T save(
                    Class<T> type,
                    T object
                    )
    throws OvalRepositoryException;



    /**
     * Searches for the objects that are the specified type.
     *
     * @param   type
     *  the type of the object.
     * @return
     *  the objects.
     */
    public <K, T extends OvalObject & Persistable<K>>
    QueryResult<T> find(
                    Class<T> type
                    )
    throws OvalRepositoryException;



    /**
     * Searches for the objects that match the specified filter.
     *
     * @param   type
     *  the type of the object.
     * @param   filter
     *  the filter.
     * @return
     *  the objects.
     */
    public <K, T extends OvalObject & Persistable<K>>
    QueryResult<T> find(
                    Class<T> type,
                    Binding filter
                    )
    throws OvalRepositoryException;

//    public <K, T extends OvalObject & Persistable<K>>
//    QueryResult<T> find(
//                    Class<T> type,
//                    QueryParams params
//                    )
//    throws OvalRepositoryException;


    /**
     * Searches for the objects that match the specified filter.
     *
     * @param   type
     *  the type of the object.
     * @param   filter
     *  the filter.
     * @param   ordering
     *  the ordering of the result objects.
     * @param   limit
     *  the number of objects and offset of the first object.
     * @return
     *  the objects.
     */
    public <K, T extends OvalObject & Persistable<K>>
    QueryResult<T> find(
                    Class<T> type,
                    Binding filter,
                    List<? extends Order> ordering,
                    Limit limit
                    )
    throws OvalRepositoryException;



    /**
     * Returns the identifiers of all the objects that are the specified type.
     *
     * @param   type
     *  the type of the object.
     * @return
     *  the identifiers.
     */
    public <K, T extends OvalObject & Persistable<K>>
    QueryResult<K> findIDs(
                    Class<T> type
                    )
    throws OvalRepositoryException;



    /**
     * Searches for the objects that match the specified filter and
     * returns the identifiers of them.
     *
     * @param   type
     *  the type of the object.
     * @param   filter
     *  the filter.
     * @return
     *  the identifiers.
     */
    public <K, T extends OvalObject & Persistable<K>>
    QueryResult<K> findIDs(
                    Class<T> type,
                    Binding filter
                    )
    throws OvalRepositoryException;

//    public <K, T extends OvalObject & Persistable<K>>
//    Collection<K> findIDs(
//                    Class<T> type,
//                    QueryParams params
//                    )
//    throws OvalRepositoryException;


    /**
     * Searches for the objects that match the specified filter and
     * returns the identifiers of them.
     *
     * @param   type
     *  the type of the object.
     * @param   filter
     *  the filter.
     * @param   ordering
     *  the ordering of the result objects.
     * @param   limit
     *  the number of objects and offset of the first object.
     * @return
     *  the identifiers.
     */
    public <K, T extends OvalObject & Persistable<K>>
    QueryResult<K> findIDs(
                    Class<T> type,
                    Binding filter,
                    List<? extends Order> ordering,
                    Limit limit
                    )
    throws OvalRepositoryException;



    /**
     * Counts the number of all the objects that are the specified type.
     *
     * @param   type
     *  the type of the object.
     * @return
     *  the number of the objects.
     */
    public <K, T extends OvalObject & Persistable<K>>
    long count(
                    Class<T> type
                    )
    throws OvalRepositoryException;



    /**
     * Counts the number of the objects that match the specified filter.
     *
     * @param   type
     *  the type of the object.
     * @return
     *  the number of the objects.
     */
    public <K, T extends OvalObject & Persistable<K>>
    long count(
                    Class<T> type,
                    Binding filter
                    )
    throws OvalRepositoryException;



//    //==============================================================
//    // oval-def:definition
//    //==============================================================
//
//    /**
//     */
//    public DefinitionType getDefinition(
//                    String oval_id,
//                    int oval_version
//                    )
//    throws OvalRepositoryException;
//
//
//
//    public DefinitionType getDefinition(
//                    String oval_id
//                    )
//    throws OvalRepositoryException;

}
//OvalRepository

