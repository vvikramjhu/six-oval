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

import jp.go.aist.six.oval.model.linux.CveReference;
import jp.go.aist.six.oval.model.linux.LinuxSecurityAdvisory;
import jp.go.aist.six.util.IsoDate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;



/**
 * The metadata available to an OVAL Definition.
 *
 * <p>Properties:</p>
 * <ul>
 *   <li>title (required)</li>
 *   <li>affected (option)</li>
 *   <li>reference (option, 0..*)</li>
 *   <li>description (required)</li>
 *   <li>metadataItem (option, 0..*)</li>
 * </ul>
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id: Metadata.java 677 2010-04-24 08:06:29Z akihito $
 */
public class Metadata
implements Serializable
{

    private String  _title;
    //{1..1}

//    private final Collection<Affected>  _affected = new ArrayList<Affected>();
//    //{0..*}
    private Affected  _affected;
    //NOTE: So far, we found NO definition with multiple 'affected' elements.

    private final Collection<Reference>  _reference = new ArrayList<Reference>();
    //{0..*}

    private String  _description;
    //{1..1}

    private final Collection<MetadataItem>  _metadataItem = new ArrayList<MetadataItem>();
    //{xsd:any, 0..*}

    // derived properties //
    private String  _lastModifiedDate;
    private Collection<Cve>  _cves;



    /**
     * Constructor.
     */
    public Metadata()
    {
    }


    /**
     * Constructor.
     */
    public Metadata(
                    final String title,
                    final String description
                    )
    {
        setTitle( title );
        setDescription( description );
    }



    public void setTitle(
                    final String title
                    )
    {
        _title = title;
    }


    public String getTitle()
    {
        return _title;
    }



//    public void setAffected(
//                    final Collection<Affected> affectedList
//                    )
//    {
//        _affected.clear();
//        if (affectedList != null) {
//            _affected.addAll( affectedList );
//        }
//    }
//
//
//    public Collection<Affected> getAffected()
//    {
//        return _affected;
//    }

    public void setAffected(
                    final Affected affected
                    )
    {
        _affected = affected;
    }


    public Affected getAffected()
    {
        return _affected;
    }


    public void setReference(
                    final Collection<Reference> referenceList
                    )
    {
        if (referenceList != _reference) {
            _reference.clear();
            if (referenceList != null) {
                for (Reference  ref : referenceList) {
                    addReference( ref );
                }
            }
        }
    }


    public void addReference(
                    final Reference ref
                    )
    {
        _reference.add( ref );
    }


    public Collection<Reference> getReference()
    {
        return _reference;
    }


    public void setDescription(
                    final String description
                    )
    {
        _description= description;
    }


    public String getDescription()
    {
        return _description;
    }



    public void setMetadataItem(
                    final Collection<MetadataItem> anyList
                    )
    {
        if (anyList != _metadataItem) {
            _metadataItem.clear();
            if (anyList != null) {
                _metadataItem.addAll( anyList );
            }
        }
    }


    public boolean addMetadataItem(
                    final MetadataItem any
                    )
    {
        if (any == null) {
            return false;
        }

        return _metadataItem.add( any );
    }


    public Collection<MetadataItem> getMetadataItem()
    {
        return _metadataItem;
    }



    /**
     * Returns the last modified date of this definition.
     * For a definition in Mitre OVAL repository, it is retrieved
     * from the latest "oval_repository/dates/" element.
     * For a Red Hat definition, it is retrieved
     * from the "advisory/updated" element.
     */
    private String _findLastModifiedDate(
                    final MetadataItem metaItem
                    )
    {
        Date  date = null;

        if (metaItem instanceof OvalRepository ) {
            OvalRepository  or = OvalRepository.class.cast( metaItem );
            for (OvalRepositoryEvent  event : or.getEvent()) {
                if (date == null  &&  event instanceof DefinitionSubmittedEvent) {
                    date = event.getDate();
                } else if (event instanceof DefinitionModifiedEvent) {
                    Date  eventDate = event.getDate();
                    if (date == null) {
                        date = eventDate;
                    } else if (date.compareTo( eventDate ) < 0) {
                        date = eventDate;
                    }
                }

            }
        } else if (metaItem instanceof LinuxSecurityAdvisory) {
            LinuxSecurityAdvisory  adv = LinuxSecurityAdvisory.class.cast( metaItem );
            date = adv.getUpdated();
        }

        return (date == null ? null : IsoDate.formatDate( date ));
    }



    public void setLastModifiedDate(
                    final String date
                    )
    {
        _lastModifiedDate = date;
    }


    public String getLastModifiedDate()
    {
        if (_lastModifiedDate == null  &&  getMetadataItem().size() > 0) {
            MetadataItem  meta = getMetadataItem().iterator().next();
            _lastModifiedDate = _findLastModifiedDate( meta );
        }

        return _lastModifiedDate;
    }



    /**
     */
    private Collection<Cve> _getCves()
    {
        Set<Cve>  cves = new HashSet<Cve>();
        final String  cve_source = "CVE";

        // Mitre OVAL repository
        for (Reference  ref : getReference()) {
            if (cve_source.equals( ref.getSource() )) {
                Cve  cve = new Cve( ref.getReferenceID() );
                cves.add( cve );
            }
        }

        // Red Hat definition
        for (MetadataItem  metadata : getMetadataItem()) {
            if (metadata instanceof LinuxSecurityAdvisory) {
                for (CveReference  ref : ((LinuxSecurityAdvisory)metadata).getCves()) {
                    Cve  cve = new Cve( ref.getReferenceID() );
                    cves.add( cve );
                }
            }
        }

        return cves;
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



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "Metadata[title=" + getTitle()
                        + ", affected=" + getAffected()
//                        + ", description=" + getDescription()
//                        + ", references=" + getReferences()
                        + ", items=" + getMetadataItem()
                        + "]";
    }

}
// Metadata
