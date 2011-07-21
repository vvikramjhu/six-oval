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

package jp.go.aist.six.oval.model.sc;

import java.io.Serializable;



/**
 * A collection of CollectedSystemObject instances.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class CollectedSystemObjectKey
    implements Serializable
{

    public final String  ovalID;
    public final int  ovalVersion;
    public final int  variableInstance;

    public CollectedSystemObjectKey(
                    final String id,
                    final int version,
                    final int variableInstance
                    )
    {
        this.ovalID = id;
        this.ovalVersion = version;
        this.variableInstance = variableInstance;
    }

}
// CollectedSystemObjectKey