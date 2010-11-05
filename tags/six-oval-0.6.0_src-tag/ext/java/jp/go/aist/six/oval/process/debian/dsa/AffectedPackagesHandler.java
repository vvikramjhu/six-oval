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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.List;

/**
 * @author   kmatsuda @ Lisonal, Akihito Nakamura @ AIST
 * @version $Id$
 */
public class AffectedPackagesHandler
implements DsaElementHandler
{

    /**
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( AffectedPackagesHandler.class );



    /**
     * Constructor.
     */
    public AffectedPackagesHandler()
    {
    }



    //**************************************************************
    // DsaElementHandler
    //**************************************************************

    // element = <dd><a href="http://packages.debian.org/src:gzip">gzip</a></dd>
    public void process(
                    final Dsa dsa,
                    final Element element
                    )
    throws DsaException
    {
		List<Element>  childElements = element.getChildElements();
		for (Element childElement : childElements) {
			if (childElement.getName().equals( "a" )) {
				final String  packageName = childElement.getTextExtractor().toString();
                final String  url = childElement.getAttributeValue( "href" );
				if (_LOG.isTraceEnabled()) {
				    _LOG.trace( "DSA Affected Package: " + packageName );
				}

				dsa.addAffectedPackage( packageName, url );

				// We don't extract the package name from AffectedPackages,
				// from FixedIn instead.
				//dsa.getAffectedPackages().put(te.toString(), starttag);
			}
		}
	}

}
// AffectedPackagesHandler

