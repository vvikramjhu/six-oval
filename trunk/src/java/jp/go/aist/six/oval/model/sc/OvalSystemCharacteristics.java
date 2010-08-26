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

import jp.go.aist.six.oval.model.OvalDocument;
import jp.go.aist.six.oval.model.common.Generator;



/**
 * The root of an OVAL System Characteristics Document.
 *
 * <p>Properties:</p>
 * <ul>
 *   <li>generator (1..1)</li>
 *   <li>systemInfo (1..1)</li>
 *   <li>collectedObjects (0..1)</li>
 *   <li>systemData (0..1)</li>
 *   <li>signature (0..1): currently NOT supported.</li>
 * </ul>
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalSystemCharacteristics
    extends OvalDocument
{

    private Generator  _generator;
    //{1..1}


    private SystemInfo _systemInfo;
    //{1..1}


    private CollectedSystemObjects  _collectedObjects = new CollectedSystemObjects();
    //{0..1}


    private SystemData  _systemData = new SystemData();
    //{0..1}



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



    /**
     */
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



    /**
     */
    public void setSystemInfo(
                    final SystemInfo systemInfo
                    )
    {
        _systemInfo = systemInfo;
    }


    public SystemInfo getSystemInfo()
    {
        return _systemInfo;
    }



    /**
     */
    public void setCollectedObjects(
                    final CollectedSystemObjects objects
                    )
    {
        _collectedObjects = objects;
    }


    public CollectedSystemObjects getCollectedObjects()
    {
        return _collectedObjects;
    }



    /**
     */
    public void setSystemData(
                    final SystemData systemData
                    )
    {
        _systemData = systemData;
    }


    public SystemData getSystemData()
    {
        return _systemData;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        CollectedSystemObjects  collectedObjects = getCollectedObjects();
        SystemData  systemData = getSystemData();

        return "OvalSystemCharacteristics[generator=" + getGenerator()
                        + ", system_info=" + getSystemInfo()
                        + ", #collected_objects="
                        + (collectedObjects == null ? 0 : collectedObjects.size())
                        + ", #items="
                        + (systemData == null ? 0 : systemData.size())
                        + "]";
    }

}
// OvalSystemCharacteristics
