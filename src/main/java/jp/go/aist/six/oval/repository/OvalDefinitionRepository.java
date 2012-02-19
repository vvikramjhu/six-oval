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
import jp.go.aist.six.oval.model.OvalEntity;
import jp.go.aist.six.oval.model.definitions.DefinitionType;



/**
 * A prescription of the OVAL Definition repository basic operations.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public interface OvalDefinitionRepository
{

    /**
     * Returns the OVAL Definition of the specified OVAL-ID.
     * If no such Definition exists, this method returns null.
     *
     * @param   oval_id
     *  the OVAL-ID.
     */
    public DefinitionType findDefinitionById(
                    String oval_id
                    )
    throws OvalRepositoryException;



    /**
     * Returns all the Definitions.
     *
     * @return
     *  all the Definitions in the repository.
     */
    public List<DefinitionType> findDefinition()
    throws OvalRepositoryException;



    /**
     * Searches for the OVAL Definitions that match the specified query parameters.
     *
     * @param   params
     *  the query parameters.
     * @return
     *  the Definitions.
     */
    public List<DefinitionType> findDefinition(
                    QueryParams params
                    )
    throws OvalRepositoryException;



    /**
     * Returns The number of OVAL Definitions in the repository.
     *
     * @return
     *  the number of Definitions in the repository.
     */
    public long countDefinition()
    throws OvalRepositoryException;



    /**
     * Returns the OVAL entity of the specified OVAL-ID.
     * If no such entity exists, this method returns null.
     *
     * @param   oval_id
     *  the OVAL-ID.
     */
    public OvalEntity findEntityById(
                    String oval_id
                    )
    throws OvalRepositoryException;



//    /**
//     * Returns all the entities.
//     *
//     * @return
//     *  all the entities in the repository.
//     */
//    public List<OvalEntity> findEntity()
//    throws OvalRepositoryException;
//
//
//
//    /**
//     * Searches for the OVAL entity that match the specified query parameters.
//     *
//     * @param   params
//     *  the query parameters.
//     * @return
//     *  the entities.
//     */
//    public List<OvalEntity> findEntity(
//                    QueryParams params
//                    )
//    throws OvalRepositoryException;
//
//
//
//
//    /**
//     * Searches for the OVAL entities that match the specified query parameters.
//     *
//     * @param   params
//     *  the query parameters.
//     * @param   ordering
//     *  the ordering of the result object.
//     * @param   limit
//     *  the number of objects and offset of the first object.
//     * @return
//     *  the entities.
//     */
//    public List<OvalEntity> findEntity(
//                    QueryParams params,
//                    List<? extends Order> ordering,
//                    Limit limit
//                    )
//    throws OvalRepositoryException;

}

