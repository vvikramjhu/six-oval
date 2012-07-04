/*
 *  @product.title@
 *  Copyright (C) @product.copyright-year@
 *    @product.vendor@
 *    Registration Number: @product.registration-number@
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
    public List<String> findOvalResultsId()
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
    public List<String> findOvalResultsId(
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
    public OvalSystemCharacteristics findOvalSystemCharacteristicsById(
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
    public List<OvalSystemCharacteristics> findOvalSystemCharacteristics(
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
    public String saveOvalSystemCharacteristics(
                    OvalSystemCharacteristics oval_sc
                    )
    throws OvalRepositoryException;

}
//
