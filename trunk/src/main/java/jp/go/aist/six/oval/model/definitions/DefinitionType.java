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

import java.util.HashSet;
import jp.go.aist.six.oval.model.Component;
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
@Entity( "oval.def.definition" )
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
    protected final Component    _oval_component = null;

//    private String  _lastModifiedDate;
//    private final Collection<Cve>  _relatedCve = new ArrayList<Cve>();

//    private static <K,V> HashMap<K,V> _createHashMap()
//    {
//        return new HashMap<K,V>();
//    }
//
//    private final Map<DefinitionsElement.Type,Set<String>>  _referencing_elements = _createHashMap();


    //NOTE: Create Assoc class and persist the instances in the isolated collection.
//    private final Map<DefinitionsElement.Type,Set<String>>  _referencing_elements =
//                    new EnumMap<DefinitionsElement.Type,Set<String>>( DefinitionsElement.Type.class );


    /**
     * Constructor.
     */
    public DefinitionType()
    {
        this( null, 0 );
    }


    public DefinitionType(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public DefinitionType(
                    final String id,
                    final int version,
                    final ClassEnumeration clazz
                    )
    {
        this( id, version, clazz, null );
    }


    public DefinitionType(
                    final String id,
                    final int version,
                    final ClassEnumeration clazz,
                    final MetadataType metadata
                    )
    {
        super( id, version );
        setDefinitionClass( clazz );
        setMetadata( metadata );

//        _definitions_element_type = DefinitionsElement.Type.definition;
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
        if (metadata == null) {
            metadata = new MetadataType();
        }
        return metadata;
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
        return notes;
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
        return criteria;
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
        definitionClass = clazz;
    }


    public ClassEnumeration getDefinitionClass()
    {
        return definitionClass;
    }



    //**************************************************************
    //  SIX extension
    //**************************************************************

    @Override
    public final Type ovalGetElementType()
    {
        return DefinitionsElement.Type.DEFINITION;
    }

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


    /**
     */
    public java.util.Set<String> referingElementIds()
    {
        java.util.Set<String>  ids = new HashSet<String>();
        _collectReferingElementIds( ids, getCriteria() );

        return ids;
    }


    private void _collectReferingElementIds(
                    final java.util.Set<String> ids,
                    final CriteriaType criteria
                    )
    {
        if (criteria == null) {
            return;
        }

        for (CriteriaElement  e : criteria.getElements()) {
            if (CriterionType.class.isInstance( e )) {
                CriterionType  criterion = CriterionType.class.cast( e );
                _collectReferingElementIds( ids, criterion );
            } else if (ExtendDefinitionType.class.isInstance( e )) {
                ExtendDefinitionType  extend_definition = ExtendDefinitionType.class.cast( e );
                _collectReferingElementIds( ids, extend_definition );
            } else if (CriteriaType.class.isInstance( e )) {
                CriteriaType  inner_criteria = CriteriaType.class.cast( e );
                _collectReferingElementIds( ids, inner_criteria );
            }
        }
    }


    private void _collectReferingElementIds(
                    final java.util.Set<String> ids,
                    final CriterionType criterion
                    )
    {
        if (criterion == null) {
            return;
        }

        String  tst_id = criterion.getTestRef();
        ids.add( tst_id );
    }


    private void _collectReferingElementIds(
                    final java.util.Set<String> ids,
                    final ExtendDefinitionType extend_definition
                    )
    {
        if (extend_definition == null) {
            return;
        }

        String  def_id = extend_definition.getDefinitionRef();
        ids.add( def_id );
    }




    //**************************************************************
    //  MongoDB/Morphia Lifecycle
    //**************************************************************

//    @PrePersist
//    protected void _computeReferencingElements()
//    {
//        for (DefinitionsElement.Type  type : DefinitionsElement.Type.values()) {
//            Set<String>  set = _referencing_elements.get( type );
//            if (set != null) {
//                set.clear();
//            }
//        }
//
//        CriteriaType  criteria = getCriteria();
//        if (criteria == null) {
//            return;
//        }
//
//        //TODO: collect test and definition references!!!
//    }
//
//

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
