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

import jp.go.aist.six.oval.model.common.Generator;
import jp.go.aist.six.util.orm.Persistable;
import java.util.ArrayList;
import java.util.Collection;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: OvalSystemCharacteristics.java 772 2010-05-11 03:03:12Z akihito $
 */
public class OvalSystemCharacteristics
    implements Persistable
{

    private Generator  _generator;
    //{1..1}

    private SystemInfo _systemInfo;
    //{1..1}

    private Collection<SystemObjectStatus>  _objects = new ArrayList<SystemObjectStatus>();
//    private String  _objectsDigest;

    private SystemData  _systemData;
    //{0..1}
//    private Collection<Item>  _items = new ArrayList<Item>();



    /**
     * Constructor.
     */
    public OvalSystemCharacteristics()
    {
    }


    /**
     * Constructor.
     */
    public OvalSystemCharacteristics(
                    final Generator generator,
                    final SystemInfo system
                    )
    {
        setGenerator( generator );
        setSystemInfo( system );
    }



//    public
//    void setCollectedObjectsDigest( final String digest )
//    {
//        _objectsDigest = digest;
//    }
//
//
//    public
//    String getCollectedObjectsDigest()
//    {
//        if (_objectsDigest == null) {
//            try {
//                _objectsDigest = OvalDigest.digestIDs( getCollectedObjects() );
//            } catch (Exception ex) {
//                // the digest is undefined.
//            }
//        }
//        return _objectsDigest;
//    }



    public void setGenerator(
                    final Generator generator
                    )
    {
        _generator = generator;
    }


    public Generator getGenerator()
    {
        return _generator;
    }



    public void setSystemInfo(
                    final SystemInfo systemInfo
                    )
    {
        _systemInfo = systemInfo;
//        if (_systemInfo != null) {
//            _systemInfo.setSystemCharacteristics( this );
//        }
    }


    public SystemInfo getSystemInfo()
    {
        return _systemInfo;
    }



    public void setCollectedObjects(
                    final Collection<SystemObjectStatus> objects
                    )
    {
        if (objects != _objects) {
            _objects.clear();
            if (objects == null  ||  objects.size() == 0) {
                return;
            }

            for (SystemObjectStatus  object : objects) {
                addCollectedObject( object );
            }
        }
    }


    public boolean addCollectedObject(
                    final SystemObjectStatus object
                    )
    {
        if (object == null) {
            return false;
        }

        return _objects.add( object );
    }


    public Collection<SystemObjectStatus> getCollectedObjects()
    {
        return _objects;
    }



//    public void setCollectedItems(
//                    final Collection<Item> items
//                    )
//    {
//        _items.clear();
//        if (items == null  ||  items.size() == 0) {
//            return;
//        }
//
//        for (Item  item : items) {
//            addCollectedItem( item );
//        }
//    }
//
//
//    public boolean addCollectedItem(
//                    final Item item
//                    )
//    {
//        if (item == null) {
//            return false;
//        }
//
//        return _items.add( item );
//    }
//
//
//    public Collection<Item> getCollectedItems()
//    {
//        return _items;
//    }



    /**
     */
    public void setSystemData(
                    final SystemData systemData
                    )
    {
        _systemData = systemData;
    }


    /**
     */
    public SystemData getSystemData()
    {
        return _systemData;
    }



    //**************************************************************
    //  Persistable
    //**************************************************************

    /**
     * The persistent identifier.
     */
    private  String  _persistentID;


    public void setPersistentID(
                    final String id
                    )
    {
        _persistentID = id;
    }


    public String getPersistentID()
    {
        return _persistentID;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        SystemData  sd = getSystemData();
        return "OvalSystemCharacteristics[generator=" + getGenerator()
                        + ", system_info=" + getSystemInfo()
                        + ", #collected_objects=" + getCollectedObjects().size()
                        + ", #items=" + (sd == null ? 0 : sd.size())
//                        + ", collected_objects=" + getCollectedObjects()
                        + "]";
    }

}
// OvalSystemCharacteristics
