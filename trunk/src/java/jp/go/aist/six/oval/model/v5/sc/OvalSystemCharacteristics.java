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

package jp.go.aist.six.oval.model.v5.sc;

import jp.go.aist.six.oval.model.v5.OvalDocument;
import jp.go.aist.six.oval.model.v5.common.GeneratorType;



/**
 * An OVAL System Characteristics Document.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class OvalSystemCharacteristics
    extends OvalDocument
{

    private GeneratorType  _generator;
    //{1..1}


    private SystemInfoType  _systemInfo;
    //{1..1}


//    private CollectedSystemObjects  _collectedObjects = new CollectedSystemObjects();
//    //{0..1}
//
//
//    private SystemData  _systemData = new SystemData();
//    //{0..1}



    /**
     * Constructor.
     */
    public OvalSystemCharacteristics()
    {
    }


//    public OvalSystemCharacteristics(
//                    final Generator generator,
//                    final SystemInfo system
//                    )
//    {
//        setGenerator( generator );
//        setSystemInfo( system );
//    }
//
//
//    public OvalSystemCharacteristics(
//                    final Generator generator,
//                    final SystemInfo system,
//                    final CollectedSystemObjects collectedObjects,
//                    final SystemData systemData
//                    )
//    {
//        this( generator, system );
//        setCollectedObjects( collectedObjects );
//        setSystemData( systemData );
//    }
//
//
//    public OvalSystemCharacteristics(
//                    final Generator generator,
//                    final SystemInfo system,
//                    final Collection<CollectedSystemObject> collectedObjects,
//                    final Collection<Item> systemData
//                    )
//    {
//        this( generator, system );
//        setCollectedObjects( new CollectedSystemObjects( collectedObjects ) );
//        setSystemData( new SystemData( systemData ) );
//    }
//
//
//    public OvalSystemCharacteristics(
//                    final Generator generator,
//                    final SystemInfo system,
//                    final CollectedSystemObject[] collectedObjects,
//                    final Item[] systemData
//                    )
//    {
//        this( generator, system );
//        setCollectedObjects( new CollectedSystemObjects( collectedObjects ) );
//        setSystemData( new SystemData( systemData ) );
//    }



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



    /**
     */
    public void setGenerator(
                    final GeneratorType generator
                    )
    {
        _generator = generator;
    }


    public GeneratorType getGenerator()
    {
        return _generator;
    }



    /**
     */
    public void setSystemInfo(
                    final SystemInfoType systemInfo
                    )
    {
        _systemInfo = systemInfo;
    }


    public SystemInfoType getSystemInfo()
    {
        return _systemInfo;
    }



//    /**
//     */
//    public void setCollectedObjects(
//                    final CollectedSystemObjects objects
//                    )
//    {
//        _collectedObjects = objects;
//    }
//
//
//    public CollectedSystemObjects getCollectedObjects()
//    {
//        return _collectedObjects;
//    }
//
//
//
//    /**
//     */
//    public void setSystemData(
//                    final SystemData systemData
//                    )
//    {
//        _systemData = systemData;
//    }
//
//
//    public SystemData getSystemData()
//    {
//        return _systemData;
//    }



    //**************************************************************
    //  OvalDocument
    //**************************************************************

//    @Override
//    public String getSchemaLocation()
//    {
//        return SC_SCHEMA_LOCATION;
//    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
//        CollectedSystemObjects  collectedObjects = getCollectedObjects();
//        SystemData  systemData = getSystemData();

        return "OvalSystemCharacteristics[generator=" + getGenerator()
                        + ", system_info=" + getSystemInfo()
//                        + ", #collected_objects="
//                        + (collectedObjects == null ? 0 : collectedObjects.size())
//                        + ", #items="
//                        + (systemData == null ? 0 : systemData.size())
                        + "]";
    }

}
// OvalSystemCharacteristics
