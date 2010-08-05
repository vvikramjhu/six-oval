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

package jp.go.aist.six.oval.core.model.definitions;

import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.definitions.Variable;
import jp.go.aist.six.util.castor.StandardAssociation;


/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalDefinitionsVariableAssociation
    extends StandardAssociation<String, String, OvalDefinitions, Variable>
{

    /**
     * Constructor.
     */
    public OvalDefinitionsVariableAssociation()
    {
    }



    /**
     * Constructor.
     */
    public OvalDefinitionsVariableAssociation(
                    final OvalDefinitions antecendent,
                    final Variable dependent
                    )
    {
        super( antecendent, dependent );
    }

}
// OvalDefinitionsVariableAssociation
