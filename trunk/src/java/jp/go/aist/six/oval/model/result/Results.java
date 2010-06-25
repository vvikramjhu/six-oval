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

package jp.go.aist.six.oval.model.system;

import jp.go.aist.six.util.orm.AbstractPersistable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;



/**
 * A collection of CollectedSystemObject instances.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class CollectedSystemObjects
    extends AbstractPersistable
//    extends Container<CollectedSystemObjectKey,CollectedSystemObject>
{

    private Collection<CollectedSystemObject>  _object = new ArrayList<CollectedSystemObject>();
    //{1..*}



    /**
     * Constructor.
     */
    public CollectedSystemObjects()
    {
    }


    /**
     * Constructor.
     */
    public CollectedSystemObjects(
                    final Collection<? extends CollectedSystemObject> elements
                    )
    {
        setObject( elements );
    }


    /**
     * Constructor.
     */
    public CollectedSystemObjects(
                    final CollectedSystemObject[] elements
                    )
    {
        setObject( Arrays.asList( elements ) );
    }



    public void setObject(
                    final Collection<? extends CollectedSystemObject> objectList
                    )
    {
        _object.clear();
        _object.addAll( objectList );
    }


    public Collection<CollectedSystemObject> getObject()
    {
        return _object;
    }



//    //**************************************************************
//    //  Container
//    //**************************************************************
//
//    protected CollectedSystemObjectKey _getKey(
//                    final CollectedSystemObject object
//                    )
//    {
//        return (new CollectedSystemObjectKey( object.getOvalID(), object.getOvalVersion(), object.getVariableInstance() ));
//    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "CollectedSystemObjects["
                        + String.valueOf( _object )
                        + "]";
    }

}
// CollectedSystemObjects
