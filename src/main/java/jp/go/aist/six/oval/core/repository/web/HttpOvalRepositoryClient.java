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

package jp.go.aist.six.oval.core.repository.web;

import java.util.List;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.model.definitions.DefinitionsElement;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import jp.go.aist.six.oval.repository.OvalRepository;
import jp.go.aist.six.oval.repository.QueryParams;
import jp.go.aist.six.oval.repository.QueryResults;



/**
 * An implementation of OvalRepository using MongoDB.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class HttpOvalRepositoryClient
    implements OvalRepository
{

//    /**
//     * Logger.
//     */
//    private static final Logger  _LOG_ =
//        LoggerFactory.getLogger( MongoOvalDefinitionResultRepository.class );



    /**
     * Constructor.
     */
    public HttpOvalRepositoryClient()
    {
    }



    //*********************************************************************
    //  implements OvalDefinitionRepository
    //*********************************************************************

    //=====================================================================
    //  Definition
    //=====================================================================

    @Override
    public DefinitionType findDefinitionById( final String oval_id )
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public List<DefinitionType> findDefinition()
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public List<DefinitionType> findDefinition( final QueryParams params )
    {
        throw new UnsupportedOperationException();
    }


    @Override
    public QueryResults<DefinitionType> findDefinitionByQuery( final QueryParams params )
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public List<String> findDefinitionId( final QueryParams params )
    {
        throw new UnsupportedOperationException();
    }




    @Override
    public long countDefinition()
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public long countDefinition( final QueryParams params )
    {
        throw new UnsupportedOperationException();
    }





    //=====================================================================
    // definitions element (Definition, Test, Object, State, Variable)
    //=====================================================================

    @Override
    public DefinitionsElement findElementById( final String oval_id )
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public List<DefinitionsElement> findElement( final QueryParams params )
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public long countElement( final QueryParams params )
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public String saveElement( final DefinitionsElement element )
    {
        throw new UnsupportedOperationException();
    }



    //=====================================================================
    // OvalDefinitions
    //=====================================================================

    @Override
    public OvalDefinitions findOvalDefinitionsById( final String id )
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public String saveOvalDefinitions( final OvalDefinitions oval_defs )
    {
        throw new UnsupportedOperationException();
    }



    //*********************************************************************
    //  implements OvalResultRepository
    //*********************************************************************

    @Override
    public OvalResults findOvalResultsById( final String id )
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public List<OvalResults> findOvalResults()
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public List<OvalResults> findOvalResults( final QueryParams params )
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public List<String> findOvalResultsId()
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public List<String> findOvalResultsId( final QueryParams params )
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public long countOvalResults()
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public String saveOvalResults( final OvalResults oval_results )
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public OvalSystemCharacteristics findOvalSystemCharacteristicsById( final String id )
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public List<OvalSystemCharacteristics> findOvalSystemCharacteristics( final QueryParams params )
    {
        throw new UnsupportedOperationException();
    }



    @Override
    public String saveOvalSystemCharacteristics( final OvalSystemCharacteristics oval_sc )
    {
        throw new UnsupportedOperationException();
    }

}
//
