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
import jp.go.aist.six.oval.model.definitions.SystemObjectRef;
import jp.go.aist.six.oval.model.definitions.Test;
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



    public TestDao()
    {
        super( Test.class );
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
        final Test  test = object;
        Collection<StateRef>  states = test.getState();
        if (states != null  &&  states.size() > 0) {
            for (StateRef  state : states) {
                state.setMasterObject( test );
            }
        }
    }



//    @Override
//    protected void _updateDeeply(
//                    final Test object
//                    )
//    throws PersistenceException
//    {
//        //no related object
//    }



    @Override
    protected void _copySimpleProperties(
                    final Test object,
                    final Test p_object
                    )
    {
        if (p_object == null) {
            return;
        }

        if (_LOG.isTraceEnabled()) {
            _LOG.trace( "copy simple properties: object=" + object );
        }

        final Test  test = object;
        final Test  p_test = p_object;

        p_test.setComment( test.getComment() );
        p_test.setCheckExistence( test.getCheckExistence() );
        p_test.setCheck( test.getCheck() );
        p_test.setStateOperator( test.getStateOperator() );

        SystemObjectRef  objectRef = test.getObject();
        if (objectRef == null) {
            if (p_test.getObject() != null) {
                p_test.setObject( null );
            }
        } else {
            p_test.setObject( objectRef );
        }

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
    protected void _syncDeeply(
                    final Test object,
                    final Test p_object
                    )
    throws PersistenceException
    {
        final Test  test = object;

        Collection<StateRef>  states = test.getState();
        if (states != null  &&  states.size() > 0) {
            for (StateRef  state : states) {
                state.setMasterObject( test );
            }
        }

        super._syncDeeply( object, p_object );
        //no related object
    }

}
// TestDao
