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

package jp.go.aist.six.oval.model.definitions;

import jp.go.aist.six.oval.core.service.OvalContext;
import jp.go.aist.six.oval.core.xml.OvalXml;
import jp.go.aist.six.oval.model.OvalEntity;
import jp.go.aist.six.oval.model.common.DefinitionClass;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.exolab.castor.jdo.Database;
import org.exolab.castor.jdo.Persistent;
import org.exolab.castor.mapping.AccessMode;
import java.util.ArrayList;
import java.util.Collection;



/**
 * A single OVAL Definition.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class Definition
    extends OvalEntity
    implements Persistent
{

    /**
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( Definition.class );



    private Metadata  _metadata;
    //{1..1}


    private Notes  _notes;
    //{0..1}


    private Criteria  _criteria;
    //{0..1}

    private String  _criteriaXml;


    private DefinitionClass  _definitionClass;
    //{required}


    // SIX: extended properties //
    private String  _lastModifiedDate;
    private Collection<Cve>  _relatedCve = new ArrayList<Cve>();



    /**
     * Constructor.
     */
    public Definition()
    {
    }


    /**
     * Constructor.
     */
    public Definition(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    /**
     * Constructor.
     */
    public Definition(
                    final String id,
                    final int version,
                    final DefinitionClass clazz
                    )
    {
        super( id, version );
        setDefinitionClass( clazz );
    }


    /**
     * Constructor.
     */
    public Definition(
                    final String id,
                    final int version,
                    final DefinitionClass clazz,
                    final Metadata metadata
                    )
    {
        this( id, version, clazz );
        setMetadata( metadata );
    }



    /**
     */
    public void setMetadata(
                    final Metadata metadata
                    )
    {
        _metadata = metadata;
    }


    public Definition metadata(
                    final Metadata metadata
                    )
    {
        setMetadata( metadata );
        return this;
    }


    public Metadata getMetadata()
    {
        if (_metadata == null) {
            _metadata = new Metadata();
        }
        return _metadata;
    }



    /**
     */
    public void setNotes(
                    final Notes notes
                    )
    {
        _notes = notes;
    }


    /**
     */
    public Notes getNotes()
    {
        return _notes;
    }



    /**
     */
    public void setCriteria(
                    final Criteria criteria
                    )
    {
        _criteria = criteria;
    }


    public Definition criteria(
                    final Criteria criteria
                    )
    {
        setCriteria( criteria );
        return this;
    }


    public Criteria getCriteria()
    {
        return _criteria;
    }



    /**
     */
    public void xmlSetCriteria(
                    final String xml
                    )
    {
        _criteriaXml = xml;
    }


    public String xmlGetCriteria()
    {
        return _criteriaXml;
    }



    /**
     */
    public void setDefinitionClass(
                    final DefinitionClass clazz
                    )
    {
        _definitionClass = clazz;
    }


    public DefinitionClass getDefinitionClass()
    {
        return _definitionClass;
    }



    //==============================================================
    //  SIX: extended properties
    //==============================================================

    /**
     */
    public void setLastModifiedDate(
                    final String date
                    )
    {
        _lastModifiedDate = date;
    }


    public String getLastModifiedDate()
    {
        if (_lastModifiedDate == null) {
            Metadata  meta = getMetadata();
            if (meta != null) {
                _lastModifiedDate = meta.getLastModifiedDate();
            }
        }

        return _lastModifiedDate;
    }



    /**
     */
    public void setRelatedCve(
                    final Collection<Cve> cves
                    )
    {
        if (cves != _relatedCve) {
            _relatedCve.clear();

            if (cves != null  &&  cves.size() > 0) {
                _relatedCve.addAll( cves );
            }
        }
    }


    private transient boolean  _relatedCveComputed = false;

    public Collection<Cve> getRelatedCve()
    {
        if (! _relatedCveComputed) {
            Metadata  meta = getMetadata();
            if (meta != null) {
                _relatedCve.addAll( meta.getRelatedCve() );
            }
            _relatedCveComputed = true;
        }

        return _relatedCve;
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



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof Definition)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "definition[" + super.toString()
                        + ", class=" + getDefinitionClass()
                        + ", metadata=" + getMetadata()
//                        + ", criteria=" + getCriteria()
//                        + ", notes=" + getNotes()
                        + "]";
    }

}
// Definition
