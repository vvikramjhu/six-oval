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

import java.util.HashMap;
import java.util.Map;

/**
 * @author   kmatsuda @ Lisonal, Akihito Nakamura @ AIST
 * @version $Id: FixedIn.java 434 2010-03-23 05:01:24Z akihito $
 */
public class FixedIn
{

    private String  _debianVersion;

//    private String  _updatePackageVersion;

    // <architecture,FixedInArchitecture>
    private Map<String,FixedInArchitecture>  _architectureMapping =
        new HashMap<String,FixedInArchitecture>();



    public FixedIn()
    {
    }



    public String getDebianVersion()
    {
		return _debianVersion;
	}


    public void setDebianVersion(
                    final String version
                    )
    {
		_debianVersion = version;
	}



    public void addArchitecture(
                    final FixedInArchitecture fia
                    )
    {
        _architectureMapping.put( fia.getArchitecture(), fia );
    }


    public Map<String,FixedInArchitecture> getArchitectureMapping()
    {
		return _architectureMapping;
	}


//	public void setArchitectureMapping(
//			Map<String,FixedInArchitecture> mapping
//			)
//	{
//	    _architectureMapping.clear();
//		_architectureMapping.putAll( mapping );
//	}



//	public String getUpdatePackageVersion()
//	{
//		return _updatePackageVersion;
//	}
//
//
//	public void setUpdatePackageVersion(
//	                final String version
//	                )
//	{
//		_updatePackageVersion = version;
//	}



	//**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        StringBuilder  s = new StringBuilder( "FixedIn[Debian version=" );
        s.append( getDebianVersion() );
        s.append( ", " + getArchitectureMapping() );
        s.append( "]" );

        return s.toString();
    }

}
// FixedIn
