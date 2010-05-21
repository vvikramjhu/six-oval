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
import java.util.HashMap;
import java.util.Map;

/**
 * @author   kmatsuda @ Lisonal, Akihito Nakamura @ AIST
 * @version $Id: DateReportedHandler.java 434 2010-03-23 05:01:24Z akihito $
 */
public class DateReportedHandler
implements DsaElementHandler
{

    /**
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( DateReportedHandler.class );


	private static Map<String,String> _createMonthMapping()
	{
	    Map<String,String>  map = new HashMap<String,String>();

		map.put( "Jan", "01" );
		map.put( "Feb", "02" );
		map.put( "Mar", "03" );
		map.put( "Apr", "04" );
		map.put( "May", "05" );
		map.put( "Jun", "06" );
		map.put( "Jul", "07" );
		map.put( "Aug", "08" );
		map.put( "Sep", "09" );
		map.put( "Oct", "10" );
		map.put( "Nov", "11" );
		map.put( "Dec", "12" );

		return map;
	}


    private static final Map<String,String>  MONTH_MAPPING = _createMonthMapping();



    /**
     * Constructor.
     */
    public DateReportedHandler() {
    }



	//**************************************************************
	// DsaElementHandler
    //**************************************************************

    public void process(
                    final Dsa dsa,
                    final Element element   /* <dd>20 Jan 2010</dd> */
                    )
    throws DsaException
    {
		String  date = element.getTextExtractor().toString();
		String[]  dateArray = date.split(" ");
		if (dateArray.length < 3) {
		    throw new DsaException( "unexpected format of DSA 'Date Reported': " + date );
		}

		date = dateArray[2] + "-" + MONTH_MAPPING.get( dateArray[1] ) + "-" + dateArray[0];
		if (_LOG.isTraceEnabled()) {
		    _LOG.trace( "DSA Date Reported: " + date );
		}

		dsa.setDateReported( date );
	}

}
// DateReportedHandler

