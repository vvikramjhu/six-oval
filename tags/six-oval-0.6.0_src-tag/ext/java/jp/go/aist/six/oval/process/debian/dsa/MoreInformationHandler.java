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

import net.htmlparser.jericho.Element;

/**
 * @author   kmatsuda @ Lisonal, Akihito Nakamura @ AIST
 * @version $Id$
 */
public class MoreInformationHandler
implements DsaElementHandler
{

//    /**
//     * Logger.
//     */
//    private static Log  _LOG = LogFactory.getLog( MoreInformationHandler.class );



    public MoreInformationHandler()
    {
    }



    //**************************************************************
    // DsaElementHandler
    //**************************************************************

    // [element]
    // <dd>
    //   <p>Several vulnerabilities have been found in gzip, ...
    //   <ul>
    //     <li><a href="http://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2009-2624">CVE-2009-2624</a>
    //     <p>Thiemo Nagel discovered a missing input ...
    //     gzip archive.</p></li>
    //   </ul>
    //   <p>For the stable distribution (lenny), these problems have been fixed in
    //   version 1.3.12-6+lenny1.</p>
    //   .....
    // </dd>
    public void process(
                    final Dsa dsa,
                    final Element element
                    )
    throws DsaException
    {
		final String  moreInfo = element.getTextExtractor().toString();
//        if (_LOG.isTraceEnabled()) {
//            _LOG.trace( "DSA more infomration: " + moreInfo );
//        }

        dsa.setMoreInformation( moreInfo );
	}

}
// MoreInformationHandler

