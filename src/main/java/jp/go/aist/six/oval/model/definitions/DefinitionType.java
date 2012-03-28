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

import jp.go.aist.six.oval.model.common.ClassEnumeration;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;



/**
 * A single OVAL Definition.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
@Entity( "oval.d.definition" )
public class DefinitionType
    extends DefinitionsElement
{

    private MetadataType  metadata;
    //{1..1}


    private NotesType  notes;
    //{0..1}


    private CriteriaType  criteria;
    //{0..1}

//    @Transient
//    private String  _criteriaXml;


    @Property( "class" )
    private ClassEnumeration  definitionClass;
    //{required}


    // SIX: extended properties //
//    private String  _lastModifiedDate;
//    private final Collection<Cve>  _relatedCve = new ArrayList<Cve>();



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
                    final ClassEnumeration clazz
                    )
    {
        super( id, version );
        setDefinitionClass( clazz );
    }


    public DefinitionType(
                    final String id,
                    final int version,
                    final ClassEnumeration clazz,
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
        this.metadata = metadata;
    }


    public MetadataType getMetadata()
    {
        if (this.metadata == null) {
            this.metadata = new MetadataType();
        }
        return this.metadata;
    }


    public DefinitionType metadata(
                    final MetadataType metadata
                    )
    {
        setMetadata( metadata );
        return this;
    }



    /**
     */
    public void setNotes(
                    final NotesType notes
                    )
    {
        this.notes = notes;
    }


    /**
     */
    public NotesType getNotes()
    {
        return this.notes;
    }



    /**
     */
    public void setCriteria(
                    final CriteriaType criteria
                    )
    {
        this.criteria = criteria;
    }


    public CriteriaType getCriteria()
    {
        return this.criteria;
    }


    public DefinitionType criteria(
                    final CriteriaType criteria
                    )
    {
        setCriteria( criteria );
        return this;
    }



//    /**
//     */
//    public void xmlSetCriteria(
//                    final String xml
//                    )
//    {
//        _criteriaXml = xml;
//    }
//
//
//    public String xmlGetCriteria()
//    {
//        return _criteriaXml;
//    }



    /**
     */
    public void setDefinitionClass(
                    final ClassEnumeration clazz
                    )
    {
        this.definitionClass = clazz;
    }


    public ClassEnumeration getDefinitionClass()
    {
        return this.definitionClass;
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
//                        + ", " + getCriteria()
                        + ", notes=" + getNotes()
                        + "]";
    }

}
// DefinitionType
