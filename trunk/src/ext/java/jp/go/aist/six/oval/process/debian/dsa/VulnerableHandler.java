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

/**
 * @author   kmatsuda @ Lisonal, Akihito Nakamura @ AIST
 * @version $Id$
 */
public class VulnerableHandler
implements DsaElementHandler
{

    /**
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( VulnerableHandler.class );



    /**
     * Constructor.
     */
    public VulnerableHandler()
    {
    }



    //**************************************************************
    // DsaElementHandler
    //**************************************************************

    public void process(
                    final Dsa dsa,
                    final Element element
                    )
    throws DsaException
    {
        final String  vulnerable = element.getTextExtractor().toString();
        if (_LOG.isTraceEnabled()) {
            _LOG.trace( "DSA Vulnerable: " + vulnerable );
        }

		dsa.setVulnerable( vulnerable );
	}

}
// VulnerableHandler

