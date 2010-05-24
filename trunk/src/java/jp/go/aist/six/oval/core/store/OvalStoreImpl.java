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
import jp.go.aist.six.oval.model.result.OvalResults;
import jp.go.aist.six.oval.model.system.OvalSystemCharacteristics;
import jp.go.aist.six.oval.service.OvalStore;
import jp.go.aist.six.util.castor.CastorDataStoreService;
import jp.go.aist.six.util.search.RelationalBinding;
import jp.go.aist.six.util.search.SearchCriteria;
import java.util.List;



/**
 * An OVAL data store service implementation.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: OvalStoreImpl.java 754 2010-05-10 05:26:45Z akihito $
 */
public class OvalStoreImpl
extends CastorDataStoreService
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
        return _find( OvalResults.class, pid );
    }



    public String createOvalResults(
                    final OvalResults results
                    )
    {
        return _create( OvalResults.class, results );
    }



    //==============================================================
    //  OvalSystemCharacteristics
    //==============================================================

    public OvalSystemCharacteristics findSystemCharacteristics(
                    final String pid
                    )
    {
        return _find( OvalSystemCharacteristics.class, pid );
    }



    public String createSystemCharacteristics(
                    final OvalSystemCharacteristics sc
                    )
    {
        return _create( OvalSystemCharacteristics.class, sc );
    }




    //==============================================================
    //  OvalDefinitions
    //==============================================================

    public String createOvalDefinitions(
                    final OvalDefinitions defs
                    )
    {
        return _create( OvalDefinitions.class, defs );
    }



    public Definition findDefinition(
                    final String id
                    )
    {
        SearchCriteria  criteria = new SearchCriteria( RelationalBinding.equalBinding( "ovalID", id ));
        List<Definition>  list = _search( Definition.class, criteria );

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
        return _sync( Definition.class, def );
    }



    public Test syncTest(
                    final Test test
                    )
    {
        return _sync( Test.class, test );
    }



    public SystemObject syncObject(
                    final SystemObject object
                    )
    {
        return _sync( SystemObject.class, object );
    }



    public State syncState(
                    final State state
                    )
    {
        return _sync( State.class, state );
    }



    public List<Definition> searchDefinition(
                    final SearchCriteria criteria
                    )
    {
        return _search( Definition.class, criteria );
    }

}
// OvalStoreImpl
