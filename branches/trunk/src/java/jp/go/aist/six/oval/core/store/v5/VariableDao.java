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

import jp.go.aist.six.oval.model.v5.definitions.LocalVariable;
import jp.go.aist.six.oval.model.v5.definitions.VariableType;
import jp.go.aist.six.util.persist.PersistenceException;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class VariableDao
    extends OvalEntityDao<VariableType>
{

    public VariableDao()
    {
        super( VariableType.class );
    }



    /**
     */
    protected void _beforePersist(
                    final VariableType variable
                    )
    throws PersistenceException
    {
        if (LocalVariable.class.isInstance( variable )) {
            LocalVariable  lv = LocalVariable.class.cast( variable );
            JdoCallbackHandler.jdoBeforeCreate( LocalVariable.class, lv );
        }
    }
//    {
//        if (LocalVariable.class.isInstance( variable )) {
//            LocalVariable  lv = LocalVariable.class.cast( variable );
//            if (lv instanceof PersistentLocalVariable) {
//                // callback handler
//            } else {
//                JdoCallbackHandler.jdoBeforeCreate( LocalVariable.class, lv );
//            }
//        }
//    }



    //**************************************************************
    //  Dao, CastorDao
    //**************************************************************

    @Override
    protected void _daoAfterLoad(
                    final VariableType object
                    )
    {
        if (LocalVariable.class.isInstance( object )) {
            LocalVariable  lv = LocalVariable.class.cast( object );
            JdoCallbackHandler.jdoLoad( LocalVariable.class, lv );
        }
    }



    @Override
    protected void _daoBeforeCreate(
                    final VariableType object
                    )
    throws PersistenceException
    {
        _beforePersist( object );
    }



    @Override
    protected void _daoBeforeUpdate(
                    final VariableType object
                    )
    throws PersistenceException
    {
        _beforePersist( object );
    }



    @Override
    protected void _syncProperties(
                    final VariableType object,
                    final VariableType p_object
                    )
    {
        if (p_object == null) {
            return;
        }

        super._syncProperties( object, p_object );
        _beforePersist( p_object );
    }



    @Override
    protected void _daoBeforeSync(
                    final VariableType object,
                    final VariableType p_object
                    )
    throws PersistenceException
    {
        _beforePersist( object );

//        super._syncDeeply( object, p_object );
        //no related object
    }

}
// VariableDao
