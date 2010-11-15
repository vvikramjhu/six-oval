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

package jp.go.aist.six.oval.core.model.definitions;

import jp.go.aist.six.oval.core.model.JdoCallbackHandler;
import jp.go.aist.six.oval.model.common.DefinitionClass;
import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.Metadata;
import org.exolab.castor.jdo.Database;
import org.exolab.castor.jdo.Persistent;
import org.exolab.castor.mapping.AccessMode;



/**
 * A single OVAL Definition.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class PersistentDefinition
    extends Definition
    implements Persistent
{

    /**
     * Constructor.
     */
    public PersistentDefinition()
    {
    }


    /**
     * Constructor.
     */
    public PersistentDefinition(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    /**
     * Constructor.
     */
    public PersistentDefinition(
                    final String id,
                    final int version,
                    final DefinitionClass clazz
                    )
    {
        super( id, version, clazz );
    }


    /**
     * Constructor.
     */
    public PersistentDefinition(
                    final String id,
                    final int version,
                    final DefinitionClass clazz,
                    final Metadata metadata
                    )
    {
        super( id, version, clazz, metadata );
    }



    //**************************************************************
    //  Persistent
    //**************************************************************

    public void jdoPersistent( final Database db ) { }

    public void jdoTransient() { }


    public Class<?> jdoLoad(
                    final AccessMode accessMode
                    )
    {
        return JdoCallbackHandler.jdoLoad( PersistentDefinition.class, this );
    }


    public void jdoBeforeCreate(
                    final Database db
                    )
    {
        JdoCallbackHandler.jdoBeforeCreate( PersistentDefinition.class, this );
    }


    public void jdoAfterCreate() { }

    public void jdoStore( final boolean modified ) { }

    public void jdoBeforeRemove() { }

    public void jdoAfterRemove() { }

    public void jdoUpdate() { }

}
// Definition
