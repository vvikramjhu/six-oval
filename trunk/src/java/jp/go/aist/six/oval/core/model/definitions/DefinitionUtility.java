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

package jp.go.aist.six.oval.core.model.definitions;

import jp.go.aist.six.oval.model.definitions.Cve;
import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.Metadata;
import jp.go.aist.six.oval.model.definitions.MetadataItem;
import jp.go.aist.six.oval.model.definitions.Reference;
import jp.go.aist.six.oval.model.linux.CveReference;
import jp.go.aist.six.oval.model.linux.LinuxSecurityAdvisory;
import jp.go.aist.six.oval.model.mitre.DefinitionModifiedEvent;
import jp.go.aist.six.oval.model.mitre.DefinitionSubmittedEvent;
import jp.go.aist.six.oval.model.mitre.MitreRepositoryMetadataItem;
import jp.go.aist.six.oval.model.mitre.OvalRepositoryEvent;
import jp.go.aist.six.util.IsoDate;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class DefinitionUtility
{

    /**
     * Returns the last modified date of the specified definition.
     * For a definition in Mitre OVAL repository, it is retrieved
     * from the latest "oval_repository/dates/" element.
     * For a Red Hat definition, it is retrieved
     * from the "advisory/updated" element.
     *
     * @return
     *  the last modified date of the specified definition,
     *  or null if the date was not found.
     */
    public static String getLastModifiedDate(
                    final Definition def
                    )
    {
        Metadata  meta = def.getMetadata();

        if (meta == null) {
            return null;
        }

        Collection<MetadataItem>  items = meta.getAdditionalMetadata();
        if (items == null  ||  items.size() == 0) {
            return null;
        }

        String  lastModifiedDate = null;
        for (MetadataItem  item : items) {
            String  date = _getLastModifiedDate( item );
            if (date != null) {
                if (lastModifiedDate == null
                                ||  lastModifiedDate.compareTo( date ) < 0) {
                    lastModifiedDate = date;
                }
            }
        }

        return lastModifiedDate;
    }


    private static String _getLastModifiedDate(
                    final MetadataItem item
                    )
    {
        Date  lastModifiedDate = null;

        if (item instanceof MitreRepositoryMetadataItem) {
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
            LinuxSecurityAdvisory  adv = LinuxSecurityAdvisory.class.cast( item );
            lastModifiedDate = adv.getUpdated();
        }

        return (lastModifiedDate == null ? null : IsoDate.formatDate( lastModifiedDate ));
    }




    /**
     */
    public static Collection<Cve> getAffectCves(
                    final Definition def
                    )
    {
        Set<Cve>  cves = new HashSet<Cve>();
        Metadata  meta = def.getMetadata();

        if (meta == null) {
            return cves;
        }

        final String  cveSource = "CVE";

        // Mitre OVAL repository
        for (Reference  ref : meta.getReference()) {
            if (cveSource.equals( ref.getSource() )) {
                Cve  cve = new Cve( ref.getRefID() );
                cves.add( cve );
            }
        }

        // Red Hat definition
        for (MetadataItem  item : meta.getAdditionalMetadata()) {
            if (item instanceof LinuxSecurityAdvisory) {
                LinuxSecurityAdvisory  advisory = (LinuxSecurityAdvisory)item;
                for (CveReference  ref : advisory.getCve()) {
                    Cve  cve = new Cve( ref.getRefID() );
                    cves.add( cve );
                }
            }
        }

        return cves;
    }

}
// DefinitionUtility
