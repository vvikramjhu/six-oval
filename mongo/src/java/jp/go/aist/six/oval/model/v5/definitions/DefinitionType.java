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

package jp.go.aist.six.oval.model.v5.definitions;

import org.bson.types.ObjectId;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Property;



/**
 * A single OVAL Definition.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
@Entity( "definition" )
public class DefinitionType
{

    @Id
    private ObjectId  _objectID;

    @Property( "id" )
    private String  _ovalID;
    //{required, oval:DefinitionIDPattern}

    @Property( "version" )
    private int  _ovalVersion;
    //{required, xsd:nonNegativeInteger}


//    private DefinitionClassEnumeration  _definitionClass;
//    //{required}


    /**
     * Constructor.
     */
    public DefinitionType()
    {
    }


//    public DefinitionType(
//                    final String id,
//                    final int version
//                    )
//    {
//        super( id, version );
//    }
//
//
//    public DefinitionType(
//                    final String id,
//                    final int version,
//                    final DefinitionClassEnumeration clazz
//                    )
//    {
//        super( id, version );
//        setDefinitionClass( clazz );
//    }
//
//
//    public DefinitionType(
//                    final String id,
//                    final int version,
//                    final DefinitionClassEnumeration clazz,
//                    final MetadataType metadata
//                    )
//    {
//        this( id, version, clazz );
//        setMetadata( metadata );
//    }




    /**
     */
    public void setObejctDI(
                    final ObjectId oid
                    )
    {
        _objectID = oid;
    }


    public ObjectId getObjectID()
    {
        return _objectID;
    }


    /**
     * Sets the OVAL-ID.
     *
     * @param   id
     *  the OVAL-ID.
     */
    public void setOvalID(
                    final String id
                    )
    {
        _ovalID = id;
    }


    /**
     * Retuens the OVAL-ID.
     *
     * @return
     *  the OVAL-ID.
     */
    public String getOvalID()
    {
        return _ovalID;
    }



    /**
     * Sets the version.
     *
     * @param   version
     *  the version.
     */
    public void setOvalVersion(
                    final int version
                    )
    {
        if (version < 0) {
            throw new IllegalArgumentException(
                            "negative version: " + version );
        }
        _ovalVersion = version;
    }


    /**
     * Returns the version.
     *
     * @return
     *  the version.
     */
    public int getOvalVersion()
    {
        return _ovalVersion;
    }





    //**************************************************************
    //  java.lang.Object
    //**************************************************************

//    @Override
//    public int hashCode()
//    {
//        return super.hashCode();
//    }
//
//
//
//    @Override
//    public boolean equals(
//                    final Object obj
//                    )
//    {
//        if (!(obj instanceof DefinitionType)) {
//            return false;
//        }
//
//        return super.equals( obj );
//    }



    @Override
    public String toString()
    {
        return "[" + "id=" + getOvalID()
                   + ", version=" + getOvalVersion()
                   + "]";
//                        + ", class=" + getDefinitionClass()
//                        + ", metadata=" + getMetadata()
////                        + ", " + getCriteria()
//                        + ", notes=" + getNotes()
//                        + "]";
    }

}
// DefinitionType
