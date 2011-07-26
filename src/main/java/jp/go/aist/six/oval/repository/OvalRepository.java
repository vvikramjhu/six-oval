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

package jp.go.aist.six.oval.repository;

import jp.go.aist.six.oval.OvalException;
import jp.go.aist.six.oval.core.ws.OvalQueryResult;
import jp.go.aist.six.oval.model.OvalObject;
import jp.go.aist.six.oval.model.v5.definitions.DefinitionType;



/**
 * A pre-description of the OVAL repository operations.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public interface OvalRepository
{

    /**
     */
    public <K, T extends OvalObject>
    T get( Class<T> type, K id )
    throws OvalException;



    /**
     */
    public <K, T extends OvalObject>
    K create( Class<T> type, T object )
    throws OvalException;



    /**
     */
    public <T extends OvalObject>
    OvalQueryResult find( Class<T> type, QueryParams<T> params )
    throws OvalException;



    //==============================================================
    // /oval_definitions
    //==============================================================



    //==============================================================
    // /d/definitions
    //==============================================================

    /**
     */
    public DefinitionType getDefinition(
                    String oval_id,
                    String oval_version
                    )
    throws OvalException;



    public DefinitionType getLatestDefinition(
                    final String oval_id
                    )
    throws OvalException;



    //==============================================================
    // /oval_system_characteristics
    //==============================================================



    //==============================================================
    // Results
    //==============================================================

}
// OvalRepository

