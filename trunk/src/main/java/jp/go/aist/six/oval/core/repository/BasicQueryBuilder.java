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

import jp.go.aist.six.oval.model.OvalObject;
import jp.go.aist.six.oval.repository.CommonQueryKey;
import com.google.code.morphia.query.Query;




/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class BasicQueryBuilder
    extends MongoQueryBuilder
{

    public static final String  DEFAULT_LIMIT = "10";



    /**
     * Constructor.
     */
    public BasicQueryBuilder()
    {
        Handler  offsetHandler = new Handler( CommonQueryKey.OFFSET, null )
        {
            @Override
            public <S extends OvalObject>
            void build(
                            final Query<S> query,
                            final String key,
                            final Object value
                            )
            {
                query.offset( Integer.valueOf( String.valueOf( value ) ).intValue() );
            }
        };

        Handler  limitHandler = new Handler( CommonQueryKey.LIMIT, null )
        {
            @Override
            public <S extends OvalObject>
            void build(
                            final Query<S> query,
                            final String key,
                            final Object value
                            )
            {
                query.limit( Integer.valueOf( String.valueOf( value ) ).intValue() );
            }
        };

        _addHandler( offsetHandler );
        _addHandler( limitHandler );
        _addHandler( new OrderHandler( _getHandlers() ) );
    }

}
// BasicQueryBuilder

