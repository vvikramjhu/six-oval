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

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author   kmatsuda @ Lisonal, Akihito Nakamura @ AIST
 * @version $Id$
 */
public class FixedInArchitecture
{

	private String  _architecture;
	private Collection<String>  _urls = new ArrayList<String>();



	public FixedInArchitecture()
	{
	}



	public String getArchitecture()
	{
		return _architecture;
	}


	public void setArchitecture(
	                final String architecture
	                )
	{
		_architecture = architecture;
	}



    public void addPackageURL(
                    final String url
                    )
    {
        _urls.add( url );
    }


    public Collection<String> getPackageURLs()
	{
		return _urls;
	}


//	public void setURLs(
//	                final List<String> urls
//	                )
//	{
//	    _urls.clear();
//		_urls.addAll( urls );
//	}



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        StringBuilder  s = new StringBuilder( "[architecture=" );
        s.append( getArchitecture() );
        s.append( ", packages=" + getPackageURLs() );
        s.append( "]" );

        return s.toString();
    }

}
// FixedInArchitecture

