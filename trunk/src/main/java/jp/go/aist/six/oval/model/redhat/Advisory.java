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

package jp.go.aist.six.oval.model.redhat;

import java.util.ArrayList;
import java.util.Collection;
import jp.go.aist.six.oval.model.AffectedCpeList;
import jp.go.aist.six.oval.model.definitions.MetadataItem;



/**
 * A Red Hat security advisory.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class Advisory
    extends MetadataItem
{

    private String  from;
    private SeverityEnumeration  severity;
    private String  rights;

    private Issued  issued;
    private Updated  updated;

    private final Collection<Cve>  cve = new ArrayList<Cve>();
    private final Collection<Bugzilla>  bugzilla = new ArrayList<Bugzilla>();
    private AffectedCpeList  affected_cpe_list;




    /**
     * Constructor.
     */
    public Advisory()
    {
    }



    /**
     */
    public void setFrom(
                    final String from
                    )
    {
        this.from = from;
    }


    public String getFrom()
    {
        return this.from;
    }



    /**
     */
    public void setSeverity(
                    final SeverityEnumeration severity
                    )
    {
        this.severity = severity;
    }


    public SeverityEnumeration getSeverity()
    {
        return this.severity;
    }



    /**
     */
    public void setRights(
                    final String rights
                    )
    {
        this.rights = rights;
    }


    public String getRights()
    {
        return this.rights;
    }



    /**
     */
    public void setIssued(
                    final Issued issued
                    )
    {
        this.issued = issued;
    }


    public Issued getIssued()
    {
        return this.issued;
    }



    /**
     */
    public void setUpdated(
                    final Updated updated
                    )
    {
        this.updated = updated;
    }


    public Updated getUpdated()
    {
        return this.updated;
    }



    /**
     */
    public void setCve(
                    final Collection<? extends Cve> cveList
                    )
    {
        if (cveList != this.cve) {
            this.cve.clear();
            if (cveList != null  &&  cveList.size() > 0) {
                this.cve.addAll( cveList );
            }
        }
    }


    public boolean addCve(
                    final Cve cve
                    )
    {
        return this.cve.add( cve );
    }


    public Collection<Cve> getCve()
    {
        return this.cve;
    }



    /**
     */
    public void setBugzilla(
                    final Collection<? extends Bugzilla> bugzillaList
                    )
    {
        if (bugzillaList != this.bugzilla) {
            this.bugzilla.clear();
            if (bugzillaList != null  &&  bugzillaList.size() > 0) {
                this.bugzilla.addAll( bugzillaList );
            }
        }
    }


    public boolean addBugzilla(
                    final Bugzilla bugzilla
                    )
    {
        return this.bugzilla.add( bugzilla );
    }


    public Collection<Bugzilla> getBugzilla()
    {
        return this.bugzilla;
    }



    /**
     */
    public void setAffectedCpeList(
                    final AffectedCpeList affected_cpe_list
                    )
    {
        this.affected_cpe_list = affected_cpe_list;
    }


    public AffectedCpeList getAffectedCpeList()
    {
        return this.affected_cpe_list;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "advisory[from=" + getFrom()
                        + ", severity=" + getSeverity()
                        + ", rights=" + getRights()
                        + ", " + getIssued()
                        + ", " + getUpdated()
                        + ", " + getCve()
                        + ", " + getBugzilla()
                        + ", " + getAffectedCpeList()
                        + "]";
    }

}
//Advisory
