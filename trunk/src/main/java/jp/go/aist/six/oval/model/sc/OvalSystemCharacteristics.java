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

package jp.go.aist.six.oval.model.sc;

import jp.go.aist.six.oval.model.common.AbstractDocument;
import jp.go.aist.six.oval.model.common.GeneratorType;
import com.google.code.morphia.annotations.Entity;



/**
 * An OVAL System Characteristics Document.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
@Entity( "oval.sc.oval_system_characteristics" )
public class OvalSystemCharacteristics
    extends AbstractDocument
{

//    private GeneratorType  generator;
//    //{1..1}


    private SystemInfoType  system_info;
    //{1..1}


    private CollectedSystemObjectsType  collected_objects;
    //{0..1}


    private SystemDataType  system_data;
    //{0..1}



    /**
     * Constructor.
     */
    public OvalSystemCharacteristics()
    {
    }


    public OvalSystemCharacteristics(
                    final GeneratorType generator
                    )
    {
        super( generator );
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



//    public void setCollectedObjectsDigest( final String digest )
//    {
//        _objectsDigest = digest;
//    }
//
//
//    public String getCollectedObjectsDigest()
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



//    /**
//     */
//    public void setGenerator(
//                    final GeneratorType generator
//                    )
//    {
//        this.generator = generator;
//    }
//
//
//    public GeneratorType getGenerator()
//    {
//        return this.generator;
//    }



    /**
     */
    public void setSystemInfo(
                    final SystemInfoType system_info
                    )
    {
        this.system_info = system_info;
    }


    public SystemInfoType getSystemInfo()
    {
        return system_info;
    }



    /**
     */
    public void setCollectedObjects(
                    final CollectedSystemObjectsType collected_objects
                    )
    {
        this.collected_objects = collected_objects;
    }


    public CollectedSystemObjectsType getCollectedObjects()
    {
        return collected_objects;
    }



    /**
     */
    public void setSystemData(
                    final SystemDataType system_data
                    )
    {
        this.system_data = system_data;
    }


    public SystemDataType getSystemData()
    {
        return system_data;
    }



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
        CollectedSystemObjectsType  collected_objects = getCollectedObjects();
        SystemDataType  system_data = getSystemData();

        return "oval_system_characteristics[generator=" + getGenerator()
                        + ", system_info=" + getSystemInfo()
//                        + ", collected_objects=" + collected_objects
                        + ", #collected_objects=" + (collected_objects == null ? 0 : collected_objects.size())
//                        + ", system_data=" + system_data
                        + ", #system_data=" + (system_data == null ? 0 : system_data.size())
                        + "]";
    }

}
//OvalSystemCharacteristics
