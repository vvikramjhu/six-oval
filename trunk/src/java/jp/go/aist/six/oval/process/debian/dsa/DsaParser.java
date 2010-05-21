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
import net.htmlparser.jericho.Source;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author   kmatsuda @ Lisonal, Akihito Nakamura @ AIST
 * @version $Id: DsaParser.java 469 2010-03-27 07:17:33Z akihito $
 */
public class DsaParser
{

    /**
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( DsaParser.class );



    public static final String DATE_REPORTED                 = "Date Reported:";
    public static final String AFFECTED_PACKAGES             = "Affected Packages:";
    public static final String VULNERABLE                    = "Vulnerable:";
    public static final String SECURITY_DATABASE_REFERENCES  = "Security database references:";
    public static final String MORE_INFORMATION              = "More information:";
    public static final String FIXED_IN                      = "Fixed in:";



    /**
     */
    private static Map<String,DsaElementHandler> _createElementHandlerMapping()
    {
        Map<String,DsaElementHandler>  map =
            new HashMap<String,DsaElementHandler>();

        map.put(DATE_REPORTED,                 new DateReportedHandler());
        map.put(AFFECTED_PACKAGES,             new AffectedPackagesHandler());
        map.put(VULNERABLE,                    new VulnerableHandler());
        map.put(SECURITY_DATABASE_REFERENCES,  new SecurityDatabaseReferencesHandler());
        map.put(MORE_INFORMATION,              new MoreInformationHandler());
        map.put(FIXED_IN,                      new FixedInHandler() );

        return map;
    }



    private Map<String,DsaElementHandler>  _elementHandlerMapping =
        _createElementHandlerMapping();



    /**
     * Constructor.
     */
    public DsaParser()
    {
    }



    /**
     */
    private DsaElementHandler _getHandler(
                    final String name
                    )
    {
        return _elementHandlerMapping.get( name );
    }




    /**
     * Parses the DSA read from the given input stream.
     */
    public Dsa parse(
                    final InputStream input
                    )
    throws DsaException, IOException
    {
        BufferedInputStream  is = null;
        if (input instanceof BufferedInputStream) {
            is = BufferedInputStream.class.cast( input );
        } else {
            is = new BufferedInputStream( input );
        }

        Source  source = new Source( is );
                         //@throws IOException
        Dsa  dsa = new Dsa();
        _build( dsa, source );
        //@throws DsaException

        return dsa;
    }



    /**
     */
    protected void _build(
                    final Dsa dsa,
                    final Source source
                    )
    throws DsaException
    {
        Element  innerElement = source.getElementById( "inner" );
        if (innerElement == null) {
            throw new DsaException( "no 'inner' element found" );
        }

        List<Element>  childElements = innerElement.getChildElements();
        for (Element  element : childElements) {
            if (element.getName().equals( "h2" )){
                final String  title = element.getTextExtractor().toString();
                if (_LOG.isTraceEnabled()) {
                    _LOG.trace( "DSA title: " + title );
                }
                dsa.setTitle( title );

            } else if(element.getName().equals( "dl" )){
                _build2( dsa, element );
            }
        }

    }



    /**
     */
	protected void _build2(
                    final Dsa dsa,
	                final Element dlElement
	                )
	throws DsaException
	{
		List<Element>  childElements = dlElement.getChildElements();
		int  size = childElements.size();
		for (int  i = 0; i < size; i++) {
			Element  element = childElements.get( i );
			if (element.getName().equals( "dt" )) {
			    final int  next_i = i + 1;
			    if (next_i < size) {
			        Element  element2 = childElements.get( next_i );
			        if (element2.getName().equals( "dd" )) {
			            final String  handlingName = element.getTextExtractor().toString();
			            final DsaElementHandler  handler = _getHandler( handlingName );
			            if (handler != null) {
                            if (_LOG.isTraceEnabled()) {
                                _LOG.trace( "process handler: " + handlingName );
                            }
			                handler.process( dsa, element2 );
			            }

			            i = next_i;
			        }
				}
			}
		}
	}

}
// DsaParser
