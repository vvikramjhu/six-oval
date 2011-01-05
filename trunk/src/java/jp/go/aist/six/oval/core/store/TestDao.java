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

package jp.go.aist.six.oval.core.store;

import jp.go.aist.six.oval.model.definitions.StateRef;
import jp.go.aist.six.oval.model.definitions.Test;
import jp.go.aist.six.util.BeansUtil;
import jp.go.aist.six.util.persist.PersistenceException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.Collection;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class TestDao
    extends OvalEntityDao<Test>
{

    /**
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( TestDao.class );



    /**
     * Constructor.
     */
    public TestDao()
    {
        super( Test.class );
    }



    /**
     */
    private void _associateDependents(
                    final Test object
                    )
    throws PersistenceException
    {
        if (_LOG.isTraceEnabled()) {
            _LOG.trace( "associating dependents: object=" + object );
        }

        final Test  test = object;
        Collection<StateRef>  states = test.getState();
        if (states != null  &&  states.size() > 0) {
            for (StateRef  state : states) {
                state.setMasterObject( test );
            }
        }
    }



    //**************************************************************
    //  Dao, CastorDao
    //**************************************************************

    @Override
    protected void _createRelatedTo(
                    final Test object
                    )
    throws PersistenceException
    {
        _associateDependents( object );
    }



    @Override
    protected void _updateDeeply(
                    final Test object
                    )
    throws PersistenceException
    {
        if (_LOG.isTraceEnabled()) {
            _LOG.trace( "update deeply: object=" + object );
        }

        _associateDependents( object );
    }



    private static final String[]  _EXCEPTED_PROPERTIES_ =
        new String[] {
        "persistentID",
        "ovalID",
        "ovalVersion",
        "entityType"
//        "state"
        };


    @Override
    protected void _copyProperties(
                    final Test p_object,
                    final Test object
                    )
    {
        if (p_object == null) {
            return;
        }

//        if (_LOG.isTraceEnabled()) {
//            _LOG.trace( "copy properties: object=" + object );
//        }

        BeansUtil.copyPropertiesExcept( p_object, object, _EXCEPTED_PROPERTIES_ );

//        Collection<StateRef>  states = object.getState();
//        p_object.setState( states );


//        _associateDependents( p_object );
    }



    @Override
    protected void _syncDeeply(
                    final Test object,
                    final Test p_object
                    )
    throws PersistenceException
    {

        super._syncDeeply( object, p_object );
        _associateDependents( object );
        //no related object
    }
//    {
//        _associateDependents( object );
//
//        super._syncDeeply( object, p_object );
//        //no related object
//    }

}
// TestDao
