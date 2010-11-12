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

import jp.go.aist.six.oval.core.service.OvalContext;
import jp.go.aist.six.oval.core.xml.OvalXml;
import jp.go.aist.six.oval.model.common.DefinitionClass;
import jp.go.aist.six.oval.model.definitions.Criteria;
import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.Metadata;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( PersistentDefinition.class );



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

    private OvalXml  mapper = null;


    public void jdoPersistent( final Database db ) { }

    public void jdoTransient() { }


    public Class<?> jdoLoad(
                    final AccessMode accessMode
                    )
    {
        if (_LOG.isTraceEnabled()) {
            _LOG.trace( "***** jdoLoad *****" );
        }
        String  xml = xmlGetCriteria();
        if (xml != null) {
            if (_LOG.isTraceEnabled()) {
                _LOG.trace( "criteria (XML)=" + xml );
            }

            try {
                if (mapper == null) {
                    mapper = OvalContext.INSTANCE.getXml();
                }
                Criteria  criteria = (Criteria)mapper.unmarshalFromString( xml );
                setCriteria( criteria );
                if (_LOG.isTraceEnabled()) {
                    _LOG.trace( "criteria (Object)=" + criteria );
                }
            } catch (Exception ex) {
                if (_LOG.isErrorEnabled()) {
                    _LOG.error( ex.getMessage() );
                }
            }
        }

        return null;
    }


    public void jdoBeforeCreate(
                    final Database db
                    )
    {
        if (_LOG.isTraceEnabled()) {
            _LOG.trace( "***** jdoBeforeCreate *****" );
        }
        Criteria  criteria = getCriteria();
        if (criteria != null) {
            if (_LOG.isTraceEnabled()) {
                _LOG.trace( "criteria (Object)=" + criteria );
            }

            try {
                if (mapper == null) {
                    mapper = OvalContext.INSTANCE.getXml();
                }
                String  xml = mapper.marshalToString( criteria );
                xmlSetCriteria( xml );
                if (_LOG.isTraceEnabled()) {
                    _LOG.trace( "criteria (XML)=" + xml );
                }
            } catch (Exception ex) {
                if (_LOG.isErrorEnabled()) {
                    _LOG.error( ex.getMessage() );
                }
            }
        }
    }


    public void jdoAfterCreate() { }

    public void jdoStore( final boolean modified ) { }

    public void jdoBeforeRemove() { }

    public void jdoAfterRemove() { }

    public void jdoUpdate() { }

}
// Definition
