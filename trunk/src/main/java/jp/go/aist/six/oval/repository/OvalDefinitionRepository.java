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
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.model.definitions.DefinitionsElement;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;



/**
 * A prescription of the OVAL Definition repository basic operations.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public interface OvalDefinitionRepository
{

    //==============================================================
    // Definition
    //==============================================================

    /**
     * Returns the Definition of the specified OVAL-ID.
     * If no such Definition exists, this method returns null.
     *
     * @param   oval_id
     *  the OVAL-ID of the Definition.
     * @return
     *  the found Definition, or null if such Definition does not exist.
     */
    public DefinitionType findDefinitionById(
                    String oval_id
                    )
    throws OvalRepositoryException;



    /**
     * Returns all the Definitions in the repository.
     *
     * @return
     *  all the Definitions.
     */
    public List<DefinitionType> findDefinition()
    throws OvalRepositoryException;



    /**
     * Searches for the Definitions that match the specified query parameters.
     *
     * @param   params
     *  the query parameters.
     * @return
     *  the found Definitions.
     */
    public List<DefinitionType> findDefinition(
                    QueryParams params
                    )
    throws OvalRepositoryException;



    /**
     * Searches for the Definition IDs that match the specified query parameters.
     *
     * @param   params
     *  the query parameters.
     * @return
     *  the found Definition IDs.
     */
    public List<String> findDefinitionId(
                    final QueryParams params
                    )
    throws OvalRepositoryException;



    /**
     * Returns the number of Definitions in the repository.
     *
     * @return
     *  the number of Definitions.
     */
    public long countDefinition()
    throws OvalRepositoryException;



    /**
     * Returns the number of Definitions that match the specified query parameters.
     *
     * @param   params
     *  the query parameters.
     * @return
     *  the number of Definitions.
     */
    public long countDefinition(
                    QueryParams params
                    )
    throws OvalRepositoryException;



//    /**
//     * Saves the Definition, either inserting or updating the existing one.
//     *
//     * @param   def
//     *  the Definition to save.
//     * @return
//     *  the ID of the Definition.
//     */
//    public String saveDefinition(
//                    final DefinitionType def
//                    )
//    throws OvalRepositoryException;



    //==============================================================
    // definitions element (Definition, Test, Object, State, Variable)
    //==============================================================

    /**
     * Returns the element of the specified OVAL-ID.
     * If no such element exists, this method returns null.
     *
     * @param   oval_id
     *  the OVAL-ID.
     * @return
     *  the found entity, or null if such entity does not exist.
     */
    public DefinitionsElement findElementById(
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



    /**
     * Searches for the elements that match the specified query parameters.
     *
     * @param   params
     *  the query parameters.
     * @return
     *  the found entities.
     */
    public List<DefinitionsElement> findElement(
                    QueryParams params
                    )
    throws OvalRepositoryException;



    /**
     * Returns the number of elements that match the specified query parameters.
     *
     * @param   params
     *  the query parameters.
     * @return
     *  the number of entities.
     */
    public long countElement(
                    QueryParams params
                    )
    throws OvalRepositoryException;



    /**
     * Saves the entity, either inserting or updating the existing one.
     *
     * @param   element
     *  the entity to save.
     * @return
     *  the ID of the entity.
     */
    public String saveElement(
                    DefinitionsElement element
                    )
    throws OvalRepositoryException;



//    /**
//     * Saves the entities which are contained in the specified OVAL Definitions document.
//     *
//     * @param   oval_defs
//     *  the OVAL Definitions document.
//     * @return
//     *  the IDs of the entities.
//     */
//    public List<String> saveEntities(
//                    OvalDefinitions oval_defs
//                    )
//    throws OvalRepositoryException;



//    /**
//     * Updates the existing entity.
//     *
//     * @param   entity
//     *  the entity to update.
//     * @return
//     *  the ID of the entity.
//     */
//    public String updateEntity(
//                    OvalEntity entity
//                    )
//    throws OvalRepositoryException;



    //==============================================================
    // OvalDefinitions
    //==============================================================

    /**
     * Returns the OVAL Definition Document of the specified ID.
     * If no such object exists, this method returns null.
     *
     * @param   id
     *  the ID.
     * @return
     *  the found OVAL Definition Document, or null if such object does not exist.
     */
    public OvalDefinitions findOvalDefinitionsById(
                    String id
                    )
    throws OvalRepositoryException;



    /**
     * Saves the OVAL Definition Document object and the entities
     * which are contained in that document.
     *
     * @param   oval_defs
     *  the OVAL Definition Document object.
     * @return
     *  the ID of the object.
     */
    public String saveOvalDefinitions(
                    OvalDefinitions oval_defs
                    )
    throws OvalRepositoryException;

}
//
