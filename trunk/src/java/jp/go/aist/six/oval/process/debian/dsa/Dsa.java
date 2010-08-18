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

package jp.go.aist.six.oval.process.debian.dsa;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;




/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class Dsa
{

    private String  _title;
    private String  _dateReported;

    // <name,url>
    private Map<String,String>  _affectedPackages = new HashMap<String,String>();

    private String  _vulnerable;

    // <referenceID,url>
    private Map<String,String>  _references = new HashMap<String,String>();

    private String  _moreInformation;

    // <Debian version,FixedIn>
    private Map<String,FixedIn>  _fixedInMapping = new HashMap<String,FixedIn>();



    /**
     * Constructor.
     */
    public Dsa()
    {
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
    public void setDateReported(
                    final String date
                    )
    {
        _dateReported = date;
    }


    public String getDateReported()
    {
        return _dateReported;
    }



    /**
     */
    public void addAffectedPackage(
                    final String name,
                    final String url
                    )
    {
        _affectedPackages.put( name, url);
    }


    public Collection<String> getAffectedPackages()
    {
        return _affectedPackages.keySet();
    }


    public String getAffectedPackageURL(
                    final String pkgName
                    )
    {
        return _affectedPackages.get( pkgName );
    }




    /**
     */
    public void setVulnerable(
                    final String vulnerable
                    )
    {
        _vulnerable = vulnerable;
    }


    public String getVulnerable()
    {
        return _vulnerable;
    }



    /**
     */
    public void addSecurityDatabaseReference(
                    final String referenceID,
                    final String referenceURL
                    )
    {
        _references.put( referenceID, referenceURL );
    }


    public Map<String,String> getSecurityDatabaseReferences()
    {
        return _references;
    }



    /**
     */
    public void setMoreInformation(
                    final String info
                    )
    {
        _moreInformation = info;
    }


    public String getMoreInformation()
    {
        return _moreInformation;
    }



    /**
     */
    public void addFixedIn(
                    final FixedIn fixedIn
                    )
    {
        _fixedInMapping.put( fixedIn.getDebianVersion(), fixedIn );
    }


    public Collection<String> getFixedInDebianVersions()
    {
        return _fixedInMapping.keySet();
    }


    public Map<String,FixedIn> getFixedInMapping()
    {
        return _fixedInMapping;
    }




    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        StringBuilder  s = new StringBuilder( "DSA[title=" );
        s.append( getTitle() );
        s.append( ", Date Reported=" + getDateReported() );
        s.append( ", Affected Packages=" + getAffectedPackages() );
        s.append( ", Vulnerable=" + getVulnerable() );
        s.append( ", Security database references=" + getSecurityDatabaseReferences() );
        s.append( ", Fixed in=" + getFixedInMapping() );
        s.append( "]" );

        return s.toString();
    }

}
// Dsa

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

