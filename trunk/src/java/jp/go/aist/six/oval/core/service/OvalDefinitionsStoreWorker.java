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

package jp.go.aist.six.oval.core.service;

import jp.go.aist.six.oval.core.store.OvalDefinitionsDefinitionAssociationEntry;
import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.Definitions;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.service.OvalRepositoryException;
import jp.go.aist.six.oval.service.ViewLevel;
import jp.go.aist.six.util.persist.DataStore;
import java.util.UUID;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalDefinitionsStoreWorker
    extends StoreWorker<String, OvalDefinitions>
{

//    /**
//     * Logger.
//     */
//    private static Log  _LOG = LogFactory.getLog( LocalOvalRepository.class );


    /**
     * Constructor.
     */
    public OvalDefinitionsStoreWorker()
    {
        super( OvalDefinitions.class );
    }



    private void _syncRelated(
                    final DataStore store,
                    final OvalDefinitions object
                    )
    throws OvalRepositoryException
    {
        Definitions  definitions = object.getDefinitions();
        if (definitions != null) {
            for (Definition  d : definitions) {
                store.sync( Definition.class, d );

                // AssociationEntry
                OvalDefinitionsDefinitionAssociationEntry  assoc =
                    new OvalDefinitionsDefinitionAssociationEntry( object, d );
                store.sync( OvalDefinitionsDefinitionAssociationEntry.class, assoc );
            }
        }
    }



    //**************************************************************
    // StoreWorker
    //**************************************************************

    @Override
    public String create(
                    final DataStore store,
                    final OvalDefinitions object
                    )
    throws OvalRepositoryException
    {
        Definitions  definitions = object.getDefinitions();
        if (definitions != null) {
            for (Definition  d : definitions) {
                store.sync( Definition.class, d );

                // AssociationEntry
            }
        }

        return store.create( getType(), object );
    }



    @Override
    public OvalDefinitions sync(
                    final DataStore store,
                    final OvalDefinitions object
                    )
    throws OvalRepositoryException
    {
        if (object.getPersistentID() == null) {
            String  uuid = UUID.randomUUID().toString();
            object.setPersistentID( uuid );
        }
        _syncRelated( store, object );

        return store.sync( getType(), object );
    }



    @Override
    public OvalDefinitions get(
                    final DataStore store,
                    final String pid,
                    final ViewLevel view
                    )
    throws OvalRepositoryException
    {
        OvalDefinitions  object = store.get( getType(), pid );
        if (view == ViewLevel.SUMMARY) {
            //
        } else if (view == ViewLevel.ALL) {
            //
        }

        return object;
    }

}
// OvalDefinitionsStoreWorker

