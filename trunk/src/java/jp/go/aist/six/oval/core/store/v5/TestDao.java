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

package jp.go.aist.six.oval.core.store.v5;

import java.util.Collection;
import jp.go.aist.six.oval.model.v5.definitions.StateRefType;
import jp.go.aist.six.oval.model.v5.definitions.TestType;
import jp.go.aist.six.util.BeansUtil;
import jp.go.aist.six.util.persist.PersistenceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class TestDao
    extends OvalEntityDao<TestType>
{

    /**
     * Logger.
     */
    private static final Logger  _LOG = LoggerFactory.getLogger( TestDao.class );



    /**
     * Constructor.
     */
    public TestDao()
    {
        super( TestType.class );
    }



    /**
     */
    private void _associateDependents(
                    final TestType object
                    )
    throws PersistenceException
    {
        if (_LOG.isTraceEnabled()) {
            _LOG.trace( "associating dependents: object=" + object );
        }

        final TestType  test = object;
        Collection<StateRefType>  states = test.getState();
        if (states != null  &&  states.size() > 0) {
            for (StateRefType  state : states) {
                state.setMasterObject( test );
            }
        }
    }



    //**************************************************************
    //  Dao, CastorDao
    //**************************************************************

    @Override
    protected void _daoBeforeCreate(
                    final TestType object
                    )
    throws PersistenceException
    {
        _associateDependents( object );
    }



    @Override
    protected void _daoBeforeUpdate(
                    final TestType object
                    )
    throws PersistenceException
    {
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
    protected void _syncProperties(
                    final TestType object,
                    final TestType p_object
                    )
    {
        if (p_object == null) {
            return;
        }

//        if (_LOG.isTraceEnabled()) {
//            _LOG.trace( "copy properties: object=" + object );
//        }

        BeansUtil.copyPropertiesExcept( p_object, object, _EXCEPTED_PROPERTIES_ );

    }



    @Override
    protected void _daoBeforeSync(
                    final TestType object,
                    final TestType p_object
                    )
    throws PersistenceException
    {
//        super._syncDeeply( object, p_object );
        _associateDependents( object );
        //no related object
    }

}
// TestDao
