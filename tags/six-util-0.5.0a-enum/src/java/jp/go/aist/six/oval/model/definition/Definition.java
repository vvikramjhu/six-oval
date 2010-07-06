/*
 *  @ProductName@
 *  Copyright (C) @CopyrightYear@
 *    National Institute of Advanced Industrial Science and Technology (AIST)
 *    Registration Number: @AISTRegistrationNumber@
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

package jp.go.aist.six.oval.model.definition;

import jp.go.aist.six.oval.core.service.StandardOvalService;
import jp.go.aist.six.oval.model.OvalEntity;
import jp.go.aist.six.oval.model.linux.CveReference;
import jp.go.aist.six.oval.model.linux.LinuxSecurityAdvisory;
import jp.go.aist.six.util.IsoDate;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;



/**
 * A single OVAL Definition.
 * <p>Properties:</p>
 * <ul>
 *   <li>metadata (required)</li>
 *   <li>criteria (option)</li>
 *   <li>definitionClass (required)</li>
 * </ul>
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class Definition
    extends OvalEntity //, Noted
{

    private Metadata  _metadata;
    //{1..1}

//  private Notes  _notes;
    //{0..1}

    private Criteria  _criteria;
    //{0..1}

    private String  _criteriaXml;


    private DefinitionClass  _definitionClass;
    //{ClassEnumeration, required}


    // metadata //
//    private String  _title;             //{required}
//    private String  _description;       //{required}
//    private Collection<Reference>  _references = new ArrayList<Reference>();    //{0..*}
//
//    // metadata/affected //
//    private Affected  _affected;    //{0..*}
//                                    //We found NO definition with multiple 'affected' elements.
//
//    private Collection<MetadataElement>  _metadataElements =
//        new ArrayList<MetadataElement>();   //{xsd:any, 0..*}



    // derived properties //
    private Collection<Cve>  _cves;
    private String  _lastModified;

//  private Collection<SystemObject>  _relatedObjects;



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



    public void setMetadata(
                    final Metadata metadata
                    )
    {
        _metadata = metadata;
    }


    public Metadata getMetadata()
    {
        return _metadata;
    }



    public void setCriteria(
                    final Criteria criteria
                    )
    {
        _criteria = criteria;
    }


    public Criteria getCriteria()
    {
        return _criteria;
    }



    /**
     */
    public void setCriteriaXml(
                    final String criteriaXml
                    )
    {
        _criteriaXml = criteriaXml;
    }


    /**
     * TODO: Don't depend on StandardOvalService!!!
     */
    public String getCriteriaXml()
    {
        if (_criteria != null  &&  _criteriaXml == null) {
            try {
                _criteriaXml = StandardOvalService.INSTANCE.getXml().marshalToString( _criteria );
            } catch (Exception ex) {

            }
        }
        return _criteriaXml;
    }



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



    ////////////////////////////////////////////////////////////////
    //  SIX extension
    ////////////////////////////////////////////////////////////////

    /**
     * Returns the last modified date of this definition.
     * For the definitions in the Mitre OVAL repository, it is retrieved
     * from the "metadata/oval_repository/dates/" element.
     * For the Red Hat definition, it is retrieved
     * from the "metadata/advisory/updated" element.
     */
    private String _getLastModifiedDate(
                    final MetadataItem meta
                    )
    {
        Date  date = null;

        if (meta instanceof OvalRepository ) {
            OvalRepository  repo = OvalRepository.class.cast( meta );
            for (OvalRepositoryEvent  event : repo.getDates()) {
                if (date == null  &&  event instanceof DefinitionSubmittedEvent) {
                    date = event.getDate();
                } else if (event instanceof DefinitionModifiedEvent) {
                    if (date == null) {
                        date = event.getDate();
                    } else if (date.compareTo( event.getDate() ) < 0) {
                        date = event.getDate();
                    }
                }

            }
        } else if (meta instanceof LinuxSecurityAdvisory) {
            LinuxSecurityAdvisory  adv = LinuxSecurityAdvisory.class.cast( meta );
            date = adv.getUpdated();
        }

        return (date == null ? null : IsoDate.formatDate( date ));

//            SimpleDateFormat  formatter = new SimpleDateFormat( "yyyy-MM-dd" );
//            return formatter.format( date );
    }



    /**
     *
     */
    private Collection<Cve> _getCves()
    {
        Set<Cve>  cves = new HashSet<Cve>();
        final String  cve_source = "CVE";

        // Mitre OVAL repository
        for (Reference  ref : getMetadata().getReference()) {
            if (cve_source.equals( ref.getSource() )) {
                Cve  cve = new Cve( ref.getRefID() );
                cves.add( cve );
            }
        }

        // Red Hat definition
        for (MetadataItem  metadata : getMetadataElements()) {
            if (metadata instanceof LinuxSecurityAdvisory) {
                for (CveReference  ref : ((LinuxSecurityAdvisory)metadata).getCve()) {
                    Cve  cve = new Cve( ref.getRefID() );
                    cves.add( cve );
                }
            }
        }

        return cves;
    }



    public void setLastModified( final String date )
    {
        _lastModified = date;
    }


    public String getLastModified()
    {
        if (_lastModified == null  &&  getMetadataElements().size() > 0) {
            MetadataItem  meta = getMetadataElements().iterator().next();
            _lastModified = _getLastModifiedDate( meta );
        }

        return _lastModified;
    }


    public void setRelatedCves(
                    final Collection<Cve> cves
                    )
    {
        if (cves != _cves) {
            if (_cves != null) {
                _cves.clear();
            }

            if (cves == null  ||  cves.size() == 0) {
                return;
            }

            for (Cve  cve : cves) {
                addRelatedCve( cve );
            }
        }
    }


    public boolean addRelatedCve(
                    final Cve cve
                    )
    {
        if (cve == null) {
            return false;
        }

        Collection<Cve>  cves = getRelatedCves();
        if (! cves.contains( cve )) {
            return cves.add( cve );
        }

        return false;
    }


    public Collection<Cve> getRelatedCves()
    {
        if (_cves == null) {
            _cves = _getCves();
        }

        return _cves;
    }



    public void setMetadataElements(
                    final Collection<MetadataItem> any
                    )
    {
//        _metadataElements.clear();
//        if (any == null  ||  any.size() == 0) {
//            return;
//        }
//
//        for (MetadataElement  e : any) {
//            addMetadataElement( e );
//        }
    }


    public boolean addMetadataElement(
                    final MetadataItem any
                    )
    {
        if (any == null) {
            return false;
        }

        return _metadata.addMetadataItem( any );
    }


    public Collection<MetadataItem> getMetadataElements()
    {
        return _metadata.getMetadataItem();
    }



//    /**
//     */
//    public String getCriteriaAsString()
//    {
//        if (_criteriaAsString == null) {
//            Criteria  criteria = getCriteria();
//            if (criteria != null) {
//                _criteriaAsString = criteria.asString();
//            }
//        }
//
//        return _criteriaAsString;
//    }
//
//
//    /**
//     */
//    public void setCriteriaAsString( final String criteria )
//    {
//        this._criteriaAsString = criteria;
//    }



//    /**
//     * @param notes the notes to set
//     */
//    public void setNotes( final Notes notes )
//    {
//        _notes = notes;
//    }
//
//
//    /**
//     * @return the notes
//     */
//    public Notes getNotes()
//    {
//        return _notes;
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
        if (!(obj instanceof Definition)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "Definition[" + super.toString()
                        + ", class=" + getDefinitionClass()
                        + ", metadata=" + getMetadata()
//                        + ", criteria=" + getCriteria()
//                        + ", notes=" + getNotes()
                        + "]";
    }

}
// Definition
