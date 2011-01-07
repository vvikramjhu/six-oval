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

package jp.go.aist.six.test.oval.core.store.inherit;

import jp.go.aist.six.util.BeansUtil;
import jp.go.aist.six.util.persist.PersistenceException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.Collection;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id: TestDao.java 1079 2010-12-24 10:35:24Z nakamura5akihito $
 */
public class TestDao
    extends OvalEntityDao<Test>
{

    /**
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( TestDao.class );



    public TestDao()
    {
        super( Test.class );
    }



    private void _associateDependents(
                    final Test object
                    )
    throws PersistenceException
    {
//        if (_LOG.isTraceEnabled()) {
//            _LOG.trace( "associating dependents: object=" + object );
//        }
//
//        final Test  test = object;
//        Collection<StateRef>  states = test.getState();
//        if (states != null  &&  states.size() > 0) {
//            for (StateRef  state : states) {
//                state.setMasterObject( test );
//            }
//        }
    }



    //**************************************************************
    //  Dao, CastorDao
    //**************************************************************

    @Override
    protected void _createRelated(
                    final Test object
                    )
    throws PersistenceException
    {
        _associateDependents( object );
    }



    @Override
    protected void _updateRelated(
                    final Test object
                    )
    throws PersistenceException
    {
        if (_LOG.isTraceEnabled()) {
            _LOG.trace( "update related: object=" + object );
        }

//        _associateDependents( object );
    }



    @Override
    protected void _syncProperties(
                    final Test object,
                    final Test p_object
                    )
    {
        if (p_object == null) {
            return;
        }

        if (_LOG.isTraceEnabled()) {
            _LOG.trace( "copy properties: object=" + object );
        }

        final Test  test = object;
        final Test  p_test = p_object;

        BeansUtil.copyPropertiesExcept(
                        p_test, test,
                        new String[] { "persistentID", "state" }
        );
//        p_test.setComment( test.getComment() );
//        p_test.setCheckExistence( test.getCheckExistence() );
//        p_test.setCheck( test.getCheck() );
//        p_test.setStateOperator( test.getStateOperator() );
//
//        SystemObjectRef  objectRef = test.getObject();
//        if (objectRef == null) {
//            if (p_test.getObject() != null) {
//                p_test.setObject( null );
//            }
//        } else {
//            p_test.setObject( objectRef );
//        }

        Collection<StateRef>  states = test.getState();
        if (states != null  &&  states.size() > 0) {
            p_test.clearState();
            for (StateRef  state : states) {
                p_test.addState( state );
                state.setMasterObject( p_test );
            }
        }
    }



    @Override
    protected void _syncRelated(
                    final Test object,
                    final Test p_object
                    )
    throws PersistenceException
    {
        _associateDependents( object );

//        super._syncDeeply( object, p_object );
        //no related object
    }

}
// TestDao
