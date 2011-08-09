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

package jp.go.aist.six.oval.core.repository;

import jp.go.aist.six.oval.repository.OvalSystemCharacteristicsQueryKey;




/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalSystemCharacteristicsQueryBuilder
    extends BasicQueryBuilder
{

    /**
     * Constructor.
     */
    public OvalSystemCharacteristicsQueryBuilder()
    {
        // SC
        _addHandler( DatetimeHandler.newStartHandler(  this, "generator.timestamp" ) );
        _addHandler( DatetimeHandler.newEndHandler(    this, "generator.timestamp" ) );
        _addHandler( new PatternHandler( OvalSystemCharacteristicsQueryKey.PRIMARY_HOST_NAME, "system_info.primary_host_name" ) );
        _addHandler( new PatternHandler( OvalSystemCharacteristicsQueryKey.OS_NAME,           "system_info.os_name"           ) );
    }

}
// OvalSystemCharacteristicsQueryBuilder

