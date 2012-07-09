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
     * @throws  OvalRepositoryException
     *  when an exceptional condition occurred during the OVAL repository processing.
     */
    public OvalResults findOvalResultsById( String id );



    /**
     * Returns all the OVAL Results.
     *
     * @return
     *  all the OVAL Results in the repository.
     * @throws  OvalRepositoryException
     *  when an exceptional condition occurred during the OVAL repository processing.
     */
    public QueryResults<OvalResults> findOvalResults();
//    public List<OvalResults> findOvalResults();



    /**
     * Searches for the OVAL Results that match the specified query parameters.
     *
     * @param   params
     *  the query parameters.
     * @return
     *  the OVAL Results.
     * @throws  OvalRepositoryException
     *  when an exceptional condition occurred during the OVAL repository processing.
     */
    public QueryResults<OvalResults> findOvalResults( QueryParams params );
//    public List<OvalResults> findOvalResults( QueryParams params );



    /**
     * Returns all the OVAL Results IDs.
     *
     * @return
     *  the IDs of all the OVAL Results in the repository.
     * @throws  OvalRepositoryException
     *  when an exceptional condition occurred during the OVAL repository processing.
     */
    public QueryResults<String> findOvalResultsId();
//    public List<String> findOvalResultsId();



    /**
     * Searches for the OVAL Results that match the specified query parameters
     * and returns their IDs.
     *
     * @param   params
     *  the query parameters.
     * @return
     *  the IDs of OVAL Results.
     * @throws  OvalRepositoryException
     *  when an exceptional condition occurred during the OVAL repository processing.
     */
    public QueryResults<String> findOvalResultsId( QueryParams params );
//    public List<String> findOvalResultsId( QueryParams params );



    /**
     * Returns The number of OVAL Definitions in the repository.
     *
     * @return
     *  the number of Definitions in the repository.
     * @throws  OvalRepositoryException
     *  when an exceptional condition occurred during the OVAL repository processing.
     */
    public long countOvalResults();



    /**
     * Saves the OVAL Results document.
     *
     * @param   oval_results
     *  the OVAL Results document.
     * @return
     *  the ID of the document.
     * @throws  OvalRepositoryException
     *  when an exceptional condition occurred during the OVAL repository processing.
     */
    public String saveOvalResults( OvalResults oval_results );



    /**
     * Returns the OVAL System Characteristics of the specified ID.
     * If no such object exists, this method returns null.
     *
     * @param   id
     *  the ID.
     * @return
     *  the OVAL System Characteristics object if exists, null otherwise.
     * @throws  OvalRepositoryException
     *  when an exceptional condition occurred during the OVAL repository processing.
     */
    public OvalSystemCharacteristics findOvalSystemCharacteristicsById( String id );



    /**
     * Searches for the OVAL System Characteristics that match the specified query parameters.
     *
     * @param   params
     *  the query parameters.
     * @return
     *  the OVAL System Characteristics objects.
     * @throws  OvalRepositoryException
     *  when an exceptional condition occurred during the OVAL repository processing.
     */
    public QueryResults<OvalSystemCharacteristics> findOvalSystemCharacteristics( QueryParams params );
//    public List<OvalSystemCharacteristics> findOvalSystemCharacteristics( QueryParams params );



    /**
     * Saves the OVAL System Characteristics document.
     *
     * @param   oval_sc
     *  the OVAL System Characteristics document.
     * @return
     *  the ID of the document.
     * @throws  OvalRepositoryException
     *  when an exceptional condition occurred during the OVAL repository processing.
     */
    public String saveOvalSystemCharacteristics( OvalSystemCharacteristics oval_sc );

}
//
