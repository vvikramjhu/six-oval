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

import jp.go.aist.six.oval.model.definitions.LocalVariable;
import jp.go.aist.six.oval.model.definitions.Variable;
import jp.go.aist.six.util.persist.PersistenceException;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class VariableDao
    extends OvalEntityDao<Variable>
{

    public VariableDao()
    {
        super( Variable.class );
    }



    /**
     */
    protected void _beforePersist(
                    final Variable variable
                    )
    throws PersistenceException
    {
        if (LocalVariable.class.isInstance( variable )) {
            LocalVariable  lv = LocalVariable.class.cast( variable );
            if (lv instanceof PersistentLocalVariable) {
                // callback handler
            } else {
                JdoCallbackHandler.jdoBeforeCreate( LocalVariable.class, lv );
            }
        }
    }



    //**************************************************************
    //  Dao, CastorDao
    //**************************************************************

    @Override
    protected void _createRelatedTo(
                    final Variable object
                    )
    throws PersistenceException
    {
        _beforePersist( object );
    }



    @Override
    protected void _updateDeeply(
                    final Variable object
                    )
    throws PersistenceException
    {
        _beforePersist( object );
    }



    @Override
    protected void _copyProperties(
                    final Variable p_object,
                    final Variable object
                    )
    {
        if (p_object == null) {
            return;
        }

        super._copyProperties( p_object, object );
        _beforePersist( p_object );
    }



    @Override
    protected void _syncDeeply(
                    final Variable object,
                    final Variable p_object
                    )
    throws PersistenceException
    {
        _beforePersist( object );

        super._syncDeeply( object, p_object );
        //no related object
    }

}
// VariableDao
