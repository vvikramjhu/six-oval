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

package jp.go.aist.six.oval.model.definitions;

import jp.go.aist.six.oval.model.CommentedOvalEntity;
import jp.go.aist.six.oval.model.EntityType;



/**
 * An OVAL Object describes a set of items to look for on a system.
 * The class name "SystemObject" is used because the name "Object"
 * has the special meaning in Java.
 *
 * <p>Properties:</p>
 * <ul>
 *   <li>id (required)</li>
 *   <li>version (required)</li>
 *   <li>comment (optional)</li>
 *   <li>deprecated (optional -- default='false')</li>
 *   <li>Signature (0..1): currently NOT supported.</li>
 *   <li>notes (0..1): currently NOT supported.</li>
 * </ul>
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class SystemObject
    extends CommentedOvalEntity
{

    /**
     * Constructor.
     */
    public SystemObject()
    {
    }


    /**
     * Constructor.
     */
    public SystemObject(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }



    /**
     */
    public void setEntityType(
                    final EntityType type
                    )
    {
    }


    public abstract EntityType getEntityType();



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

}
// SystemObject
