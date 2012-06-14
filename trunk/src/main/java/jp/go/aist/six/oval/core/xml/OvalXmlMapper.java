/*
 *  @product.title@
 *  Copyright (C) @product.copyright-year@
 *    @product.vendor@
 *    Registration Number: @product.registration-number@
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

package jp.go.aist.six.oval.core.xml;

import jp.go.aist.six.util.castor.CastorXmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id: OvalXmlImpl.java 440 2010-03-23 05:11:44Z akihito $
 */
public class OvalXmlMapper
    extends CastorXmlMapper
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ = LoggerFactory.getLogger( OvalXmlMapper.class );



    /**
     * Constructor.
     */
    public OvalXmlMapper()
    {
        _LOG_.trace( "instantiated" );
    }

}
//

