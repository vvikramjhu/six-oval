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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author   kmatsuda @ Lisonal, Akihito Nakamura @ AIST
 * @version $Id$
 */
public class FixedInHandler
implements DsaElementHandler
{

    /**
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( FixedInHandler.class );



    /**
     * Constructor.
     */
    public FixedInHandler()
    {
    }



    //**************************************************************
    // DsaElementHandler
    //**************************************************************

    // [element]
    // <dd>
    //   <h3>Debian GNU/Linux 4.0 (etch)</h3>
    //   <dl>
    //    <dt>Source:
    //     <dd><a href="http://security.debian.org/pool/updates/main/g/gzip/gzip_1.3.5-15+etch1.dsc">http://security.debian.org/pool/updates/main/g/gzip/gzip_1.3.5-15+etch1.dsc</a><br>
    //     <dd><a href="http://security.debian.org/pool/updates/main/g/gzip/gzip_1.3.5-15+etch1.diff.gz">http://security.debian.org/pool/updates/main/g/gzip/gzip_1.3.5-15+etch1.diff.gz</a><br>
    //     <dd><a href="http://security.debian.org/pool/updates/main/g/gzip/gzip_1.3.5.orig.tar.gz">http://security.debian.org/pool/updates/main/g/gzip/gzip_1.3.5.orig.tar.gz</a><br>
    //    <dt>Alpha:
    //     <dd><a href="http://security.debian.org/pool/updates/main/g/gzip/gzip_1.3.5-15+etch1_alpha.deb">http://security.debian.org/pool/updates/main/g/gzip/gzip_1.3.5-15+etch1_alpha.deb</a><br>
    //    <dt>AMD64:
    //     <dd><a href="http://security.debian.org/pool/updates/main/g/gzip/gzip_1.3.5-15+etch1_amd64.deb">http://security.debian.org/pool/updates/main/g/gzip/gzip_1.3.5-15+etch1_amd64.deb</a><br>
    //    <dt>ARM:
    //     <dd><a href="http://security.debian.org/pool/updates/main/g/gzip/gzip_1.3.5-15+etch1_arm.deb">http://security.debian.org/pool/updates/main/g/gzip/gzip_1.3.5-15+etch1_arm.deb</a><br>
    //   </dl>
    //   <h3>Debian GNU/Linux 5.0 (lenny)</h3>
    //   <dl>
    //     <dt>Source:
    //      <dd><a href="http://security.debian.org/pool/updates/main/g/gzip/gzip_1.3.12-6+lenny1.diff.gz">http://security.debian.org/pool/updates/main/g/gzip/gzip_1.3.12-6+lenny1.diff.gz</a><br>
    //      <dd><a href="http://security.debian.org/pool/updates/main/g/gzip/gzip_1.3.12.orig.tar.gz">http://security.debian.org/pool/updates/main/g/gzip/gzip_1.3.12.orig.tar.gz</a><br>
    //      <dd><a href="http://security.debian.org/pool/updates/main/g/gzip/gzip_1.3.12-6+lenny1.dsc">http://security.debian.org/pool/updates/main/g/gzip/gzip_1.3.12-6+lenny1.dsc</a><br>
    //     <dt>Architecture-independent component:
    //      <dd><a href="http://security.debian.org/pool/updates/main/g/gzip/gzip-win32_1.3.12-6+lenny1_all.deb">http://security.debian.org/pool/updates/main/g/gzip/gzip-win32_1.3.12-6+lenny1_all.deb</a><br>
    //     <dt>Alpha:
    //      <dd><a href="http://security.debian.org/pool/updates/main/g/gzip/gzip_1.3.12-6+lenny1_alpha.deb">http://security.debian.org/pool/updates/main/g/gzip/gzip_1.3.12-6+lenny1_alpha.deb</a><br>
    //     <dt>AMD64:
    //      <dd><a href="http://security.debian.org/pool/updates/main/g/gzip/gzip_1.3.12-6+lenny1_amd64.deb">http://security.debian.org/pool/updates/main/g/gzip/gzip_1.3.12-6+lenny1_amd64.deb</a><br>
    //     .....
    //   </dl>
    //   <p>MD5 checksums of the listed files are available in the <a href="http://lists.debian.org/debian-security-announce/2010/msg00009.html">original advisory</a>.</p>
    // </dd>
    public void process(
                    final Dsa dsa,
                    final Element element   /* <dd> */
                    )
    throws DsaException
    {
		FixedIn  fixedin = null;
        List<Element>  childElements = element.getChildElements(); // h3, dl, ...
		for (Element  childElement : childElements) {
			String  debianVersion = null;
			if (childElement.getName().equals( "h3" )  ||  childElement.getName().equals( "h4" )) {
			    debianVersion = childElement.getContent().toString();
                if (_LOG.isTraceEnabled()) {
                    _LOG.trace( "DSA Fixed in Debian: " + debianVersion );
                }
				fixedin = new FixedIn();
				fixedin.setDebianVersion( debianVersion );
			} else if (childElement.getName().equals( "dl" )) {
			    if (fixedin == null) {
			        // matsuda's code
//			        Perl5Util  p5u = new Perl5Util();
//			        if(p5u.match("/Debian\\s+(GNU\\/Linux)*\\s*(\\d+\\.?\\d+)*/", dsa.getMoreInformation())){
//			            debianVersion = p5u.toString();
			        debianVersion = _findDebianVersion( dsa.getMoreInformation() );
			        if (debianVersion != null) {
		                if (_LOG.isTraceEnabled()) {
		                    _LOG.trace( "DSA Fixed in Debian: " + debianVersion );
		                }
			            fixedin = new FixedIn();
			            fixedin.setDebianVersion( debianVersion );
			        }
				}

			    _processFixedInArchitecture( dsa, fixedin, childElement );
			}

			if (fixedin != null) {
                dsa.addFixedIn( fixedin );
            }
		}
	}



    private static final String  _DEBIAN_VERSION_REGEX_ =
        "Debian\\s+(GNU\\/Linux)?\\s*(\\d+\\.?\\d*)*";
    private static Pattern  _DEBIAN_VERSION_PATTERN_ = null;


    private static String _findDebianVersion(
                    final String sequence
                    )
    {
        if (_DEBIAN_VERSION_PATTERN_ == null) {
            _DEBIAN_VERSION_PATTERN_ = Pattern.compile( _DEBIAN_VERSION_REGEX_ );
        }

        Matcher  matcher = _DEBIAN_VERSION_PATTERN_.matcher( sequence );
        if (matcher.find()) {
            return matcher.group();
        } else {
            return null;
        }
    }



    // [element]
    //   <dl>
    //     <dt>Source:
    //      <dd><a href="http://security.debian.org/pool/updates/main/g/gzip/gzip_1.3.12-6+lenny1.diff.gz">http://security.debian.org/pool/updates/main/g/gzip/gzip_1.3.12-6+lenny1.diff.gz</a><br>
    //      <dd><a href="http://security.debian.org/pool/updates/main/g/gzip/gzip_1.3.12.orig.tar.gz">http://security.debian.org/pool/updates/main/g/gzip/gzip_1.3.12.orig.tar.gz</a><br>
    //      <dd><a href="http://security.debian.org/pool/updates/main/g/gzip/gzip_1.3.12-6+lenny1.dsc">http://security.debian.org/pool/updates/main/g/gzip/gzip_1.3.12-6+lenny1.dsc</a><br>
    //     <dt>Architecture-independent component:
    //      <dd><a href="http://security.debian.org/pool/updates/main/g/gzip/gzip-win32_1.3.12-6+lenny1_all.deb">http://security.debian.org/pool/updates/main/g/gzip/gzip-win32_1.3.12-6+lenny1_all.deb</a><br>
    //     <dt>Alpha:
    //      <dd><a href="http://security.debian.org/pool/updates/main/g/gzip/gzip_1.3.12-6+lenny1_alpha.deb">http://security.debian.org/pool/updates/main/g/gzip/gzip_1.3.12-6+lenny1_alpha.deb</a><br>
    //     <dt>AMD64:
    //      <dd><a href="http://security.debian.org/pool/updates/main/g/gzip/gzip_1.3.12-6+lenny1_amd64.deb">http://security.debian.org/pool/updates/main/g/gzip/gzip_1.3.12-6+lenny1_amd64.deb</a><br>
    //     .....
    //   </dl>
	private void _processFixedInArchitecture(
	                final Dsa dsa,
	                final FixedIn fixedin,
                    final Element ele
	                )
	{
		List<Element>  childElements = ele.getChildElements(); // dt, dd
        FixedInArchitecture  fia = null;
        for (Element  childElement : childElements) {
			if (childElement.getName().equals( "dt" )) {
			    final String  arch = childElement.getContent().toString().trim();
                if (_LOG.isTraceEnabled()) {
                    _LOG.trace( "DSA Fixed in architecture: " + arch );
                }
				fia = new FixedInArchitecture();
				fia.setArchitecture( arch );
				fixedin.addArchitecture( fia );
				//_Log.info(element.getContent().toString().trim());

			} else if (childElement.getName().equals( "dd" )) {
				final String  url = childElement.getTextExtractor().toString();

				// TODO: Is this a correct way ???
//				String[]  urlsplit1 = url.split( "_" );
//				String[]  urlsplit2 = urlsplit1[0].split( "\\/" );
//				String  pkgName = urlsplit2[urlsplit2.length - 1];
//				String  pkgVersion = null;
//				if (urlsplit1.length == 3) {
//					//_Log.info("urlsplit2[urlsplit2.length-1]="+urlsplit2[urlsplit2.length-1]+"::urlsplit1[1]="+urlsplit1[1]);
//				    pkgVersion = urlsplit1[1];
//					dsa.addAffectedPackage( pkgName, pkgVersion );
//				} else if (urlsplit1.length == 2) {
//					Perl5Util  p5u = new Perl5Util();
//					if (p5u.match( "/\\.deb$/", urlsplit1[1] )) {
//						//int index = urlsplit1[1].lastIndexOf(p5u.toString());
//						String[]  a = urlsplit1[1].split( ".deb" );
//						pkgVersion = a[0];
//						dsa.addAffectedPackage( pkgName, pkgVersion );
//					}
//				}

				if (fia != null) {
				    if (_LOG.isTraceEnabled()) {
				        _LOG.trace( "DSA Fixed in package: " + url );
				    }
				    fia.addPackageURL( url );
				}
			}
		}
	}

}
// FixedInHandler

