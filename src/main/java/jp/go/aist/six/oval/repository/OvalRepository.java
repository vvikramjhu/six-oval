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
import jp.go.aist.six.oval.model.v5.definitions.DefinitionType;
import jp.go.aist.six.util.persist.Persistable;
import jp.go.aist.six.util.search.Binding;
import jp.go.aist.six.util.search.Limit;
import jp.go.aist.six.util.search.Order;



/**
 * A pre-description of the OVAL repository operations.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public interface OvalRepository
{

    /**
     */
    public <K, T extends OvalObject & Persistable<K>>
    T get(
                    Class<T> type,
                    K id
                    )
    throws OvalRepositoryException;



    /**
     */
    public <K, T extends OvalObject & Persistable<K>>
    K create(
                    Class<T> type,
                    T object
                    )
    throws OvalRepositoryException;



    /**
     * Updates the object, or inserts it to the data store if it does NOT exist.
     */
    public <K, T extends OvalObject & Persistable<K>>
    T save(
                    Class<T> type,
                    T object
                    )
    throws OvalRepositoryException;



    /**
     */
    public <K, T extends OvalObject & Persistable<K>>
    QueryResult<T> find(
                    Class<T> type
                    )
    throws OvalRepositoryException;


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


    public <K, T extends OvalObject & Persistable<K>>
    QueryResult<T> find(
                    Class<T> type,
                    Binding filter,
                    List<? extends Order> ordering,
                    Limit limit
                    )
    throws OvalRepositoryException;



    /**
     */
    public <K, T extends OvalObject & Persistable<K>>
    QueryResult<K> findIDs(
                    Class<T> type
                    )
    throws OvalRepositoryException;



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


    public <K, T extends OvalObject & Persistable<K>>
    QueryResult<K> findIDs(
                    Class<T> type,
                    Binding filter,
                    List<? extends Order> ordering,
                    Limit limit
                    )
    throws OvalRepositoryException;



    /**
     */
    public <K, T extends OvalObject & Persistable<K>>
    long count(
                    Class<T> type
                    )
    throws OvalRepositoryException;


    public <K, T extends OvalObject & Persistable<K>>
    long count(
                    Class<T> type,
                    Binding filter
                    )
    throws OvalRepositoryException;



    //==============================================================
    // oval-def:definition
    //==============================================================

    /**
     */
    public DefinitionType getDefinition(
                    String oval_id,
                    int oval_version
                    )
    throws OvalRepositoryException;



    public DefinitionType getDefinition(
                    String oval_id
                    )
    throws OvalRepositoryException;

}
// OvalRepository

