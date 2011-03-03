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

package jp.go.aist.six.oval.model.v5.definitions;

import java.util.ArrayList;
import java.util.Collection;
import jp.go.aist.six.oval.model.definitions.Criteria;
import jp.go.aist.six.oval.model.definitions.Cve;
import jp.go.aist.six.oval.model.v5.OvalEntity;
import jp.go.aist.six.oval.model.v5.common.DefinitionClassEnumeration;



/**
 * A single OVAL Definition.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class DefinitionType
    extends OvalEntity
{

    private MetadataType  _metadata;
    //{1..1}


    private NotesType  _notes;
    //{0..1}


    private Criteria  _criteria;
    //{0..1}

    private String  _criteriaXml;


    private DefinitionClassEnumeration  _definitionClass;
    //{required}


    // SIX: extended properties //
    private String  _lastModifiedDate;
    private final Collection<Cve>  _relatedCve = new ArrayList<Cve>();



    /**
     * Constructor.
     */
    public DefinitionType()
    {
    }


    public DefinitionType(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    public DefinitionType(
                    final String id,
                    final int version,
                    final DefinitionClassEnumeration clazz
                    )
    {
        super( id, version );
        setDefinitionClass( clazz );
    }


    public DefinitionType(
                    final String id,
                    final int version,
                    final DefinitionClassEnumeration clazz,
                    final MetadataType metadata
                    )
    {
        this( id, version, clazz );
        setMetadata( metadata );
    }



    /**
     */
    public void setMetadata(
                    final MetadataType metadata
                    )
    {
        _metadata = metadata;
    }


    public DefinitionType metadata(
                    final MetadataType metadata
                    )
    {
        setMetadata( metadata );
        return this;
    }


    public MetadataType getMetadata()
    {
        if (_metadata == null) {
            _metadata = new MetadataType();
        }
        return _metadata;
    }



    /**
     */
    public void setNotes(
                    final NotesType notes
                    )
    {
        _notes = notes;
    }


    /**
     */
    public NotesType getNotes()
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


    public DefinitionType criteria(
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
                    final DefinitionClassEnumeration clazz
                    )
    {
        _definitionClass = clazz;
    }


    public DefinitionClassEnumeration getDefinitionClass()
    {
        return _definitionClass;
    }



    //==============================================================
    //  SIX: extended properties
    //==============================================================

//    /**
//     */
//    public void setLastModifiedDate(
//                    final String date
//                    )
//    {
//        _lastModifiedDate = date;
//    }
//
//
//    public String getLastModifiedDate()
//    {
//        if (_lastModifiedDate == null) {
//            MetadataType  meta = getMetadata();
//            if (meta != null) {
//                _lastModifiedDate = meta.getLastModifiedDate();
//            }
//        }
//
//        return _lastModifiedDate;
//    }
//
//
//
//    /**
//     */
//    public void setRelatedCve(
//                    final Collection<Cve> cves
//                    )
//    {
//        if (cves != _relatedCve) {
//            _relatedCve.clear();
//
//            if (cves != null  &&  cves.size() > 0) {
//                _relatedCve.addAll( cves );
//            }
//        }
//    }
//
//
//    private transient boolean  _relatedCveComputed = false;
//
//    public Collection<Cve> getRelatedCve()
//    {
//        if (! _relatedCveComputed) {
//            MetadataType  meta = getMetadata();
//            if (meta != null) {
//                _relatedCve.addAll( meta.getRelatedCve() );
//            }
//            _relatedCveComputed = true;
//        }
//
//        return _relatedCve;
//    }



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
        if (!(obj instanceof DefinitionType)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "[" + super.toString()
                        + ", class=" + getDefinitionClass()
                        + ", metadata=" + getMetadata()
//                        + ", criteria=" + getCriteria()
                        + ", notes=" + getNotes()
                        + "]";
    }

}
// DefinitionType
