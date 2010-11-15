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

import jp.go.aist.six.oval.model.common.Datatype;
import jp.go.aist.six.oval.model.definitions.LocalVariable;
import org.exolab.castor.jdo.Database;
import org.exolab.castor.jdo.Persistent;
import org.exolab.castor.mapping.AccessMode;



/**
 * The LocalVariable extends the Variable and defines a variable
 * with some local source.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class PersistentLocalVariable
    extends LocalVariable
    implements Persistent
{

    private String  _componentXml;



    /**
     * Constructor.
     */
    public PersistentLocalVariable()
    {
    }


    /**
     * Constructor.
     */
    public PersistentLocalVariable(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    /**
     * Constructor.
     */
    public PersistentLocalVariable(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );
    }



    /**
     * Constructor.
     */
    public PersistentLocalVariable(
                    final String id,
                    final int version,
                    final String comment,
                    final Datatype datatype
                    )
    {
        super( id, version, comment, datatype );
    }



    /**
     */
    public void xmlSetComponent(
                    final String xml
                    )
    {
        _componentXml = xml;
    }


    public String xmlGetComponent()
    {
        return _componentXml;
    }



    //**************************************************************
    //  Persistent
    //**************************************************************

//    private OvalXml  mapper = null;


    public void jdoPersistent( final Database db ) { }

    public void jdoTransient() { }


    public Class<?> jdoLoad(
                    final AccessMode accessMode
                    )
    {
        return JdoCallbackHandler.jdoLoad( PersistentLocalVariable.class, this );
    }


    public void jdoBeforeCreate(
                    final Database db
                    )
    {
        JdoCallbackHandler.jdoBeforeCreate( PersistentLocalVariable.class, this );
    }


    public void jdoAfterCreate() { }

    public void jdoStore( final boolean modified ) { }

    public void jdoBeforeRemove() { }

    public void jdoAfterRemove() { }

    public void jdoUpdate() { }

}
// LocalVariable
