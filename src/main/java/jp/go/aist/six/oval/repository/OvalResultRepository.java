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
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;



/**
 * A prescription of the OVAL result repository basic operations.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public interface OvalResultRepository
{

    /**
     * Returns the OVAL Results of the specified ID.
     * If no such object exists, this method returns null.
     *
     * @param   id
     *  the ID.
     * @return
     *  the OVAL Results object if exists, null otherwise.
     */
    public OvalResults findOvalResultsById(
                    String id
                    )
    throws OvalRepositoryException;



    /**
     * Returns all the OVAL Results.
     *
     * @return
     *  all the OVAL Results in the repository.
     */
    public List<OvalResults> findOvalResults()
    throws OvalRepositoryException;



    /**
     * Searches for the OVAL Results that match the specified query parameters.
     *
     * @param   params
     *  the query parameters.
     * @return
     *  the OVAL Results.
     */
    public List<OvalResults> findOvalResults(
                    QueryParams params
                    )
    throws OvalRepositoryException;



    /**
     * Returns all the OVAL Results IDs.
     *
     * @return
     *  the IDs of all the OVAL Results in the repository.
     */
    public List<String> findOvalResultsIds()
    throws OvalRepositoryException;



    /**
     * Searches for the OVAL Results that match the specified query parameters
     * and returns their IDs.
     *
     * @param   params
     *  the query parameters.
     * @return
     *  the IDs of OVAL Results.
     */
    public List<String> findOvalResultsIds(
                    QueryParams params
                    )
    throws OvalRepositoryException;



    /**
     * Returns The number of OVAL Definitions in the repository.
     *
     * @return
     *  the number of Definitions in the repository.
     */
    public long countOvalResults()
    throws OvalRepositoryException;



    /**
     * Saves the OVAL Results document.
     *
     * @param   oval_results
     *  the OVAL Results document.
     * @return
     *  the ID of the document.
     */
    public String saveOvalResults(
                    OvalResults oval_results
                    )
    throws OvalRepositoryException;



    /**
     * Returns the OVAL System Characteristics of the specified ID.
     * If no such object exists, this method returns null.
     *
     * @param   id
     *  the ID.
     * @return
     *  the OVAL System Characteristics object if exists, null otherwise.
     */
    public OvalSystemCharacteristics findOvalScById(
                    String id
                    )
    throws OvalRepositoryException;



    /**
     * Searches for the OVAL System Characteristics that match the specified query parameters.
     *
     * @param   params
     *  the query parameters.
     * @return
     *  the OVAL System Characteristics objects.
     */
    public List<OvalSystemCharacteristics> findOvalSc(
                    QueryParams params
                    )
    throws OvalRepositoryException;



    /**
     * Saves the OVAL System Characteristics document.
     *
     * @param   oval_sc
     *  the OVAL System Characteristics document.
     * @return
     *  the ID of the document.
     */
    public String saveOvalSc(
                    OvalSystemCharacteristics oval_sc
                    )
    throws OvalRepositoryException;

}
//
