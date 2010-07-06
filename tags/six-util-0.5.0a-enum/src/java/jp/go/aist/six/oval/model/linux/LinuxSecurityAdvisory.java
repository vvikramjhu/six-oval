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
 * A security advisory.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: LinuxSecurityAdvisory.java 683 2010-04-24 13:27:18Z akihito $
 */
public class LinuxSecurityAdvisory
    extends MetadataItem
{

    private String  _from;
    private Severity  _severity;
    private String  _rights;
    private Date  _issued;
    private Date  _updated;

    private Collection<CveReference>  _cve = new ArrayList<CveReference>();
    private Collection<CertReference>  _cert = new ArrayList<CertReference>();
    private Collection<BugzillaReference>  _bugzilla = new ArrayList<BugzillaReference>();
    private Collection<DebianBugReference>  _bug = new ArrayList<DebianBugReference>();
    private Collection<Cpe>  _affectedCpeList = new ArrayList<Cpe>();



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
        setCve( cves );
        setBugzilla( bugzillas );
        setAffectedCpeList( cpes );
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



    public void setCve(
                    final Collection<? extends CveReference> cveList
                    )
    {
        if (cveList != _cve) {
            _cve.clear();
            if (cveList == null  ||  cveList.size() == 0) {
                return;
            }

            for (CveReference  cve : cveList) {
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

        if (!_cve.contains( cve )) {
            return _cve.add( cve );
        }

        return false;
    }


    public Collection<CveReference> getCve()
    {
        return _cve;
    }



    public void setBugzilla(
                    final Collection<? extends BugzillaReference> bugzillaList
                    )
    {
        if (bugzillaList != _bugzilla) {
            _bugzilla.clear();
            if (bugzillaList == null  ||  bugzillaList.size() == 0) {
                return;
            }

            for (BugzillaReference  bugzilla : bugzillaList) {
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

        if (!_bugzilla.contains( bugzilla )) {
            return _bugzilla.add( bugzilla );
        }

        return false;
    }


    public Collection<BugzillaReference> getBugzilla()
    {
        return _bugzilla;
    }



    public void setAffectedCpeList(
                    final Collection<Cpe> cpeList
                    )
    {
        if (cpeList != _affectedCpeList) {
            _affectedCpeList.clear();
            if (cpeList == null  ||  cpeList.size() == 0) {
                return;
            }

            for (Cpe  cpe : cpeList) {
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

        if (!_affectedCpeList.contains( cpe )) {
            return _affectedCpeList.add( cpe );
        }

        return false;
    }


    public Collection<Cpe> getAffectedCpeList()
    {
        return _affectedCpeList;
    }



    public void setCert(
                    final Collection<? extends CertReference> certList
                    )
    {
        if (certList != _cert) {
            _cert.clear();
            if (certList == null  ||  certList.size() == 0) {
                return;
            }

            for (CertReference  cert : certList) {
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

        if (!_cert.contains( cert )) {
            return _cert.add( cert );
        }

        return false;
    }


    public Collection<CertReference> getCert()
    {
        return _cert;
    }



    public void setBug(
                    final Collection<? extends DebianBugReference> bugList
                    )
    {
        if (bugList != _bug) {
            _bug.clear();
            if (bugList == null  ||  bugList.size() == 0) {
                return;
            }

            for (DebianBugReference  bug : bugList) {
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

        if (!_bug.contains( bug )) {
            return _bug.add( bug );
        }

        return false;
    }


    public Collection<DebianBugReference> getBug()
    {
        return _bug;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "Advisory [from=" + getFrom()
                        + ", severity=" + getSeverity()
                        + ", rights=" + getRights()
                        + ", issued=" + getIssued()
                        + ", updated=" + getUpdated()
                        + ", cve=" + getCve()
                        + ", bugzilla=" + getBugzilla()
                        + ", affected_cpe_list=" + getAffectedCpeList()
                        + "]";
    }

}
// LinuxSecurityAdvisory
