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

package jp.go.aist.six.oval.model.linux;

import jp.go.aist.six.oval.model.definition.Cpe;
import jp.go.aist.six.oval.model.definition.MetadataItem;
import jp.go.aist.six.util.IsoDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: LinuxSecurityAdvisory.java 683 2010-04-24 13:27:18Z akihito $
 */
public class LinuxSecurityAdvisory
    extends MetadataItem
{

    private String  _from;
    private String  _rights;
    private Severity  _severity;
    private Date  _issued;
    private Date  _updated;

    private Collection<CveReference>  _cves = new ArrayList<CveReference>();
    private Collection<CertReference>  _certs = new ArrayList<CertReference>();
    private Collection<BugzillaReference>  _bugzillas = new ArrayList<BugzillaReference>();
    private Collection<DebianBugReference>  _bugs = new ArrayList<DebianBugReference>();
    private Collection<Cpe>  _cpes = new ArrayList<Cpe>();



    /**
     * Constructor.
     */
    public LinuxSecurityAdvisory()
    {
    }


    /**
     * Constructor.
     */
    public LinuxSecurityAdvisory(
                    final String from,
                    final String rights,
                    final Severity severity,
                    final String issued,
                    final String updated
                    )
    {
        setFrom( from );
        setRights( rights );
        setSeverity( severity );
        setIssued( IsoDate.dateValueOf( issued ) );
        setUpdated( IsoDate.dateValueOf( updated ) );
    }


    /**
     * Constructor.
     */
    public LinuxSecurityAdvisory(
                    final String from,
                    final String rights,
                    final Severity severity,
                    final String issued,
                    final String updated,
                    final Collection<CveReference> cves,
                    final Collection<BugzillaReference> bugzillas,
                    final Collection<Cpe> cpes)
    {
        this( from, rights, severity, issued, updated );
        setCves( cves );
        setBugzillas( bugzillas );
        setAffectedCpes( cpes );
    }



    public void setFrom(
                    final String from
                    )
    {
        _from = from;
    }


    public String getFrom()
    {
        return _from;
    }



    public void setRights(
                    final String rights
                    )
    {
        _rights = rights;
    }


    public String getRights()
    {
        return _rights;
    }



    public void setSeverity(
                    final Severity severity
                    )
    {
        _severity = severity;
    }


    public Severity getSeverity()
    {
        return _severity;
    }



    public void setIssued(
                    final Date issued
                    )
    {
        _issued = issued;
    }


    public Date getIssued()
    {
        return _issued;
    }



    public void setUpdated(
                    final Date updated
                    )
    {
        _updated = updated;
    }


    public Date getUpdated()
    {
        return _updated;
    }



    public void setCves(
                    final Collection<CveReference> cves
                    )
    {
        if (cves != _cves) {
            _cves.clear();
            if (cves == null  ||  cves.size() == 0) {
                return;
            }

            for (CveReference  cve : cves) {
                addCve( cve );
            }
        }
    }


    public boolean addCve(
                    final CveReference cve
                    )
    {
        if (cve == null) {
            return false;
        }

        if (!_cves.contains( cve )) {
            return _cves.add( cve );
        }

        return false;
    }


    public Collection<CveReference> getCves()
    {
        return _cves;
    }



    public void setBugzillas(
                    final Collection<BugzillaReference> bugzillas
                    )
    {
        if (bugzillas != _bugzillas) {
            _bugzillas.clear();
            if (bugzillas == null  ||  bugzillas.size() == 0) {
                return;
            }

            for (BugzillaReference  bugzilla : bugzillas) {
                addBugzilla( bugzilla );
            }
        }
    }


    public boolean addBugzilla(
                    final BugzillaReference bugzilla
                    )
    {
        if (bugzilla == null) {
            return false;
        }

        if (!_bugzillas.contains( bugzilla )) {
            return _bugzillas.add( bugzilla );
        }

        return false;
    }


    public Collection<BugzillaReference> getBugzillas()
    {
        return _bugzillas;
    }



    public void setAffectedCpes(
                    final Collection<Cpe> cpes
                    )
    {
        if (cpes != _cpes) {
            _cpes.clear();
            if (cpes == null  ||  cpes.size() == 0) {
                return;
            }

            for (Cpe  cpe : cpes) {
                addAffectedCpe( cpe );
            }
        }
    }


    public boolean addAffectedCpe(
                    final Cpe cpe
                    )
    {
        if (cpe == null) {
            return false;
        }

        if (!_cpes.contains( cpe )) {
            return _cpes.add( cpe );
        }

        return false;
    }


    public Collection<Cpe> getAffectedCpes()
    {
        return _cpes;
    }



    public void setCerts(
                    final Collection<CertReference> certs
                    )
    {
        if (certs != _certs) {
            _certs.clear();
            if (certs == null  ||  certs.size() == 0) {
                return;
            }

            for (CertReference  cert : certs) {
                addCert( cert );
            }
        }
    }


    public boolean addCert(
                    final CertReference cert
                    )
    {
        if (cert == null) {
            return false;
        }

        if (!_certs.contains( cert )) {
            return _certs.add( cert );
        }

        return false;
    }


    public Collection<CertReference> getCerts()
    {
        return _certs;
    }



    public void setBugs(
                    final Collection<DebianBugReference> bugs
                    )
    {
        if (bugs != _bugs) {
            _bugs.clear();
            if (bugs == null  ||  bugs.size() == 0) {
                return;
            }

            for (DebianBugReference  bug : bugs) {
                addBug( bug );
            }
        }
    }


    public boolean addBug(
                    final DebianBugReference bug
                    )
    {
        if (bug == null) {
            return false;
        }

        if (!_bugs.contains( bug )) {
            return _bugs.add( bug );
        }

        return false;
    }


    public Collection<DebianBugReference> getBugs()
    {
        return _bugs;
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
        return "Advisory [from=" + getFrom()
                        + ", severity=" + getSeverity()
                        + ", rights=" + getRights()
                        + ", issued=" + getIssued()
                        + ", updated=" + getUpdated()
                        + ", cve=" + getCves()
                        + ", bugzilla=" + getBugzillas()
                        + ", affected_cpe_list=" + getAffectedCpes()
                        + "]";
    }

}
// LinuxSecurityAdvisory
