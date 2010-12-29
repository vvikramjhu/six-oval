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

import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.Definitions;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.util.persist.DataStore;
import jp.go.aist.six.util.persist.PersistenceException;
import jp.go.aist.six.util.search.Binding;
import jp.go.aist.six.util.search.RelationalBinding;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalDefinitionsWorker
    extends Worker<String, OvalDefinitions>
{

//    /**
//     * Logger.
//     */
//    private static Log  _LOG = LogFactory.getLog( LocalOvalRepository.class );


    /**
     * Constructor.
     */
    public OvalDefinitionsWorker(
                    final DataStore store
                    )
    {
        super( OvalDefinitions.class, store );
    }



    /**
     */
    private void _syncRelated(
                    final OvalDefinitions object
                    )
    throws PersistenceException
    {
        Definitions  definitions = object.getDefinitions();
        if (definitions != null) {
            for (Definition  d : definitions) {
                _getStore().sync( Definition.class, d );
            }
        }

        // TODO: Tests, Objects, States, Variables
    }


//    private void _syncAssociation(
//                    final DataStore store,
//                    final OvalDefinitions object
//                    )
//    throws OvalRepositoryException
//    {
//        Definitions  definitions = object.getDefinitions();
//        if (definitions != null) {
//            for (Definition  d : definitions) {
//                // AssociationEntry
//                OvalDefinitionsDefinitionAssociationEntry  assoc =
//                    new OvalDefinitionsDefinitionAssociationEntry( object, d );
//                store.sync( OvalDefinitionsDefinitionAssociationEntry.class, assoc );
//            }
//        }
//    }



    /**
     */
    private void _loadRelated(
                    final OvalDefinitions object
                    )
    throws PersistenceException
    {
        Binding  filter =
            RelationalBinding.equalBinding( "antecendentPersistentID", object.getPersistentID() );
        Collection<OvalDefinitionsDefinitionAssociationEntry>  list =
            _getStore().find( OvalDefinitionsDefinitionAssociationEntry.class, filter );

        Definitions  defs = new Definitions();
        if (list.size() > 0) {
            Set<String>  defPIDs = new HashSet<String>();
            for (OvalDefinitionsDefinitionAssociationEntry  assoc : list) {
                String  defPID = assoc.getDependentPersistentID();
                defPIDs.add( defPID );
            }

            List<String>  defPID_list = new ArrayList<String>( defPIDs );

            Collection<Definition>  p_defs = _getStore().loadAll( Definition.class, defPID_list );
            defs.addAll( p_defs );
        }

        object.setDefinitions( defs );
    }



    //**************************************************************
    // StoreWorker
    //**************************************************************

    @Override
    public String create(
                    final OvalDefinitions object
                    )
    throws PersistenceException
    {
        _syncRelated( object );

        return _getStore().create( getType(), object );
    }



    @Override
    public OvalDefinitions sync(
                    final OvalDefinitions object
                    )
    throws PersistenceException
    {
        _syncRelated( object );
//        _syncAssociation( store, object );

        return _getStore().sync( getType(), object );
    }



    @Override
    public OvalDefinitions load(
                    final String identity
                    )
    throws PersistenceException
    {
        OvalDefinitions  defs = _getStore().load( getType(), identity );
        _loadRelated( defs );

        return defs;
    }

}
// OvalDefinitionsWorker

