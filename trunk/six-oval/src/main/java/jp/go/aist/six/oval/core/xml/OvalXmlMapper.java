/*
 *  @product.title@
 *  Copyright (C) @product.copyright-year@
 *    @product.vendor@
 *    Registration Number: @product.registration-number@
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.go.aist.six.oval.core.xml;

import jp.go.aist.six.util.castor.CastorXmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id: OvalXmlMapper.java 3006 2013-02-12 09:25:26Z nakamura5akihito@gmail.com $
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

