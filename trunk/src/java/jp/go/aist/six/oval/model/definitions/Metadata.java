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

package jp.go.aist.six.oval.model.definitions;

import jp.go.aist.six.oval.model.linux.CveReference;
import jp.go.aist.six.oval.model.linux.LinuxSecurityAdvisory;
import jp.go.aist.six.oval.model.mitre.DefinitionModifiedEvent;
import jp.go.aist.six.oval.model.mitre.DefinitionSubmittedEvent;
import jp.go.aist.six.oval.model.mitre.MitreRepositoryMetadataItem;
import jp.go.aist.six.oval.model.mitre.OvalRepositoryEvent;
import jp.go.aist.six.util.IsoDate;
import jp.go.aist.six.util.castor.AbstractPersistable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;



/**
 * All the metadata available to an OVAL Definition.
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
 * @version $Id$
 */
public class Metadata
    extends AbstractPersistable
{

    private String  _title;
    //{1..1}

//    private final Collection<Affected>  _affected = new ArrayList<Affected>();
    private Affected  _affected;
    //{0..*}
    //NOTE: So far, we found NO definition with multiple 'affected' elements.

    private final Collection<Reference>  _reference = new ArrayList<Reference>();
    //{0..*}

    private String  _description;
    //{1..1}

    private final Collection<MetadataItem>  _additionalMetadata = new ArrayList<MetadataItem>();
    //{xsd:any, 0..*}



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



    /**
     */
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



    /**
     */
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



    /**
     */
    public void setReference(
                    final Collection<? extends Reference> references
                    )
    {
        if (references != _reference) {
            _reference.clear();
            if (references != null  &&  references.size() > 0) {
                _reference.addAll( references );
            }
        }
    }


    public boolean addReference(
                    final Reference reference
                    )
    {
        if (reference == null) {
            return false;
        } else {
            return _reference.add( reference );
        }
    }


    public Collection<Reference> getReference()
    {
        return _reference;
    }


    public Iterator<Reference> iterateReference()
    {
        return _reference.iterator();
    }



    /**
     */
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



    /**
     */
    public void setAdditionalMetadata(
                    final Collection<? extends MetadataItem> items
                    )
    {
        if (items != _additionalMetadata) {
            _additionalMetadata.clear();
            if (items != null  &&  items.size() > 0) {
                _additionalMetadata.addAll( items );
            }
        }
    }


    public boolean addAdditionalMetadata(
                    final MetadataItem item
                    )
    {
        if (item == null) {
            return false;
        }

        return _additionalMetadata.add( item );
    }


    public Collection<MetadataItem> getAdditionalMetadata()
    {
        return _additionalMetadata;
    }


    public Iterator<MetadataItem> iterateAdditionalMetadata()
    {
        return _additionalMetadata.iterator();
    }



    //==============================================================
    //  SIX: extended properties
    //==============================================================

    /**
     * Returns the last modified date of this definition.
     * For a definition in Mitre OVAL repository, it is retrieved
     * from the latest "oval_repository/dates/" element.
     * For a Red Hat definition, it is retrieved
     * from the "advisory/updated" element.
     */
    public String getLastModifiedDate()
    {
        String  lastModifiedDate = null;

        Collection<MetadataItem>  items = getAdditionalMetadata();
        if (items != null  &&  items.size() > 0) {
            for (MetadataItem  item : items) {
                String  itemDate = _getLastModifiedDate( item );
                if (lastModifiedDate == null
                                    ||  lastModifiedDate.compareTo( itemDate ) < 0) {
                    lastModifiedDate = itemDate;
                }
            }
        }

        return lastModifiedDate;
    }


    private String _getLastModifiedDate(
                    final MetadataItem item
                    )
    {
        Date  lastModifiedDate = null;

        if (item instanceof MitreRepositoryMetadataItem) {
            // Mitre OVAL repository
            MitreRepositoryMetadataItem  or = MitreRepositoryMetadataItem.class.cast( item );
            for (OvalRepositoryEvent  event : or.getDates()) {
                if (lastModifiedDate == null  &&  (event instanceof DefinitionSubmittedEvent)) {
                    lastModifiedDate = event.getDate();
                } else if (event instanceof DefinitionModifiedEvent) {
                    Date  eventDate = event.getDate();
                    if (lastModifiedDate == null
                                    ||  lastModifiedDate.compareTo( eventDate ) < 0) {
                        lastModifiedDate = eventDate;
                    }
                }

            }
        } else if (item instanceof LinuxSecurityAdvisory) {
            // Red Hat definition
            LinuxSecurityAdvisory  adv = LinuxSecurityAdvisory.class.cast( item );
            lastModifiedDate = adv.getUpdated();
        }

        return (lastModifiedDate == null ? null : IsoDate.formatDate( lastModifiedDate ));
    }



    /**
     */
    public Collection<Cve> getRelatedCve()
    {
        Set<Cve>  cves = new HashSet<Cve>();
        final String  cveSource = "CVE";

        // Mitre OVAL repository
        Collection<Reference>  references = getReference();
        if (references != null  &&  references.size() > 0) {
            for (Reference  ref : references) {
                if (cveSource.equals( ref.getSource() )) {
                    Cve  cve = new Cve( ref.getRefID() );
                    cves.add( cve );
                }
            }
        }

        // Red Hat definition
        Collection<MetadataItem>  items = getAdditionalMetadata();
        if (items != null  &&  items.size() > 0) {
            for (MetadataItem  item : items) {
                if (item instanceof LinuxSecurityAdvisory) {
                    LinuxSecurityAdvisory  advisory = (LinuxSecurityAdvisory)item;
                    for (CveReference  ref : advisory.getCve()) {
                        Cve  cve = new Cve( ref.getRefID() );
                        cves.add( cve );
                    }
                }
            }
        }

        return cves;
    }




    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "Metadata[title=" + getTitle()
                        + ", affected=" + getAffected()
                        + ", description=(omitted)" //+ getDescription()
                        + ", references" + getReference()
                        + ", additionalMetadata=" + getAdditionalMetadata()
                        + "]";
    }

}
// Metadata
