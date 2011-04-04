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

package jp.go.aist.six.oval.core.service;

import jp.go.aist.six.oval.core.store.OvalStore;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.service.OvalServiceException;
import jp.go.aist.six.util.search.Binding;
import jp.go.aist.six.util.search.Limit;
import jp.go.aist.six.util.search.Order;
import java.util.List;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalResultsRepository
{

//    /**
//     * Logger.
//     */
//    private static Log  _LOG = LogFactory.getLog( OvalResultsRepository.class );



    /**
     * The data store sole instance.
     */
    private OvalStore  _store;



    /**
     * Constructor.
     */
    public OvalResultsRepository()
    throws Exception
    {
        _initialize();
    }



    /**
     */
    private void _initialize()
    throws Exception
    {
        OvalContext  context = new OvalContext();
        _store = context.getStore();
    }



    //==============================================================
    // Results
    //==============================================================

    public String create(
                    final OvalResults resutls
                    )
    throws OvalServiceException
    {
        String  pid = null;
        try {
            pid = _store.create( OvalResults.class, resutls );
        } catch (Exception ex) {
            throw new OvalServiceException( ex );
        }

        return pid;
    }


    public OvalResults get(
                    final String pid
                    )
    throws OvalServiceException
    {
        OvalResults  results = null;
        try {
            results = _store.get( OvalResults.class, pid );
        } catch (Exception ex) {
            throw new OvalServiceException( ex );
        }

        return results;
    }



    public List<OvalResults> find(
                    final Binding filter,
                    final List<Order> ordering,
                    final Limit limit
                    )
    throws OvalServiceException
    {
        List<OvalResults>  results = null;
        try {
            results = _store.find( OvalResults.class, filter, ordering, limit );
        } catch (Exception ex) {
            throw new OvalServiceException( ex );
        }

        return results;
    }

}
// OvalResultsRepository

