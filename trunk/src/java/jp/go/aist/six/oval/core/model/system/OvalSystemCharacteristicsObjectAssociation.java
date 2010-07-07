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

package jp.go.aist.six.oval.core.model.system;

import jp.go.aist.six.oval.model.system.CollectedSystemObject;
import jp.go.aist.six.oval.model.system.OvalSystemCharacteristics;
import jp.go.aist.six.util.castor.StandardAssociation;


/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalSystemCharacteristicsObjectAssociation
    extends StandardAssociation<String, String, OvalSystemCharacteristics, CollectedSystemObject>
{

    /**
     * Constructor.
     */
    public OvalSystemCharacteristicsObjectAssociation()
    {
    }


    /**
     * Constructor.
     */
    public OvalSystemCharacteristicsObjectAssociation(
                    final OvalSystemCharacteristics antecendent,
                    final CollectedSystemObject dependent
                    )
    {
        super( antecendent, dependent );
    }

}
// OvalSystemCharacteristicsObjectAssociation
