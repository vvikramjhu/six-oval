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

package jp.go.aist.six.oval.core.repository.mongodb;

import jp.go.aist.six.oval.repository.OvalRepositoryException;
import com.google.code.morphia.query.Query;





/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public interface QueryBuilder
{

    // predefined filter
    public <T> Query<T> build(
                    Query<T> query
                    )
    throws OvalRepositoryException;


//    // paging
//    public Query<T> build(
//                    Query<T> query,
//                    List<? extends Order> orders,
//                    Limit limit
//                    )
//    throws OvalRepositoryException;

}
// QueryBuilder

