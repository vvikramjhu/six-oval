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
import jp.go.aist.six.oval.repository.DefinitionQueryKey;
import jp.go.aist.six.oval.repository.TestQueryKey;
import com.google.code.morphia.query.Query;




/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class TestQueryBuilder
    extends BasicQueryBuilder
{

    /**
     * Constructor.
     */
    public TestQueryBuilder()
    {
        Handler  versionHandler = new Handler( DefinitionQueryKey.VERSION, "oval_version" )
        {
            @Override
            public <S extends OvalObject>
            void build(
                            final Query<S> query,
                            final String key,
                            final Object value
                            )
            {
                query.filter( toField( key ), Integer.valueOf( String.valueOf( value ) ).intValue() );
            }
        };


        _addHandler( new FilterHandler( DefinitionQueryKey.ID,               "oval_id"                    ) );
        _addHandler( versionHandler );
        _addHandler( new FilterHandler( TestQueryKey.OBJECT_REF,  "object.object_ref"  ) );
        _addHandler( new FilterHandler( TestQueryKey.STATE_REF,   "state.state_ref"  ) );
    }

}
// TestQueryBuilder

