/*
 *  @ProductName@
 *  Copyright (C) @CopyrightYear@
 *    National Institute of Advanced Industrial Science and Technology (AIST)
 *    Registration Number: @AISTRegistrationNumber@
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

package jp.go.aist.six.oval.core.store;

import jp.go.aist.six.oval.model.definition.Definition;
import jp.go.aist.six.oval.model.definition.OvalDefinitions;
import jp.go.aist.six.oval.model.definition.State;
import jp.go.aist.six.oval.model.definition.SystemObject;
import jp.go.aist.six.oval.model.definition.Test;
import jp.go.aist.six.oval.model.result.DefinitionResult;
import jp.go.aist.six.oval.model.result.OvalResults;
import jp.go.aist.six.oval.model.result.Result;
import jp.go.aist.six.oval.model.result.SystemResult;
import jp.go.aist.six.oval.model.system.OvalSystemCharacteristics;
import jp.go.aist.six.oval.service.OvalStore;
import jp.go.aist.six.util.castor.CastorDataStore;
import jp.go.aist.six.util.search.InBinding;
import jp.go.aist.six.util.search.RelationalBinding;
import jp.go.aist.six.util.search.SearchCriteria;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



/**
 * An OVAL data store implementation.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: OvalStoreImpl.java 754 2010-05-10 05:26:45Z akihito $
 */
public class OvalStoreImpl
extends CastorDataStore
implements OvalStore
{

//    /**
//     * Logger.
//     */
//    private static Log  _LOG = LogFactory.getLog( OvalStoreImpl.class );



    /**
     * Constructor.
     */
    public OvalStoreImpl()
    {
    }




    //**************************************************************
    // OvalStore
    //**************************************************************

    //==============================================================
    //  OvalResults
    //==============================================================

    public OvalResults findResults(
                    final String pid
                    )
    {
        return find( OvalResults.class, pid );
    }



    public String createOvalResults(
                    final OvalResults results
                    )
    {
        return create( OvalResults.class, results );
    }



    public List<SystemResult> searchSystemResult(
                    final SearchCriteria criteria
                    )
    {
        return search( SystemResult.class, criteria );
    }



    public Collection<SystemResult> findSyetemByDefinitionResult(
                    final String defID,
                    final Result result
                    )
    {
//        throw new UnsupportedOperationException();

        Collection<DefinitionResult>  defs = findDefinitionResult( result );

        if (defs.size() > 0) {
            InBinding  binding = new InBinding( );
            binding.setProperty( "persistentID" );
            for (DefinitionResult  r : defs) {
                binding.addValue( r.getMasterPersistentID() );
            }
            return search( SystemResult.class, new SearchCriteria( binding ) );
        }

        return (new ArrayList<SystemResult>());
    }



    public Collection<DefinitionResult> findDefinitionResult(
                    final Result result
                    )
    {
        SearchCriteria  criteria = new SearchCriteria(
                        RelationalBinding.equalBinding( "result", result ));
        return search( DefinitionResult.class, criteria );
    }


    //==============================================================
    //  OvalSystemCharacteristics
    //==============================================================

    public OvalSystemCharacteristics findSystemCharacteristics(
                    final String pid
                    )
    {
        return find( OvalSystemCharacteristics.class, pid );
    }



    public String createSystemCharacteristics(
                    final OvalSystemCharacteristics sc
                    )
    {
        return create( OvalSystemCharacteristics.class, sc );
    }



    //==============================================================
    //  OvalDefinitions
    //==============================================================

    public String createOvalDefinitions(
                    final OvalDefinitions defs
                    )
    {
        return create( OvalDefinitions.class, defs );
    }



    public Definition findDefinition(
                    final String id
                    )
    {
        SearchCriteria  criteria = new SearchCriteria( RelationalBinding.equalBinding( "ovalID", id ));
        List<Definition>  list = search( Definition.class, criteria );

        Definition  result = null;
        if (list.size() == 0) {
            result = null;
        } else if (list.size() == 1) {
            result = list.get( 0 );
        } else {
            for (Definition  def : list) {
                if (result == null) {
                    result = def;
                } else if (result.getOvalVersion() < def.getOvalVersion()) {
                    result = def;
                }
            }
        }

        return result;
    }



    public Definition syncDefinition(
                    final Definition def
                    )
    {
        return sync( Definition.class, def );
    }



    public Test syncTest(
                    final Test test
                    )
    {
        return sync( Test.class, test );
    }



    public SystemObject syncObject(
                    final SystemObject object
                    )
    {
        return sync( SystemObject.class, object );
    }



    public State syncState(
                    final State state
                    )
    {
        return sync( State.class, state );
    }



    public List<Definition> searchDefinition(
                    final SearchCriteria criteria
                    )
    {
        return search( Definition.class, criteria );
    }

}
// OvalStoreImpl
