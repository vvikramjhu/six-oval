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

import jp.go.aist.six.oval.model.v5.OvalEntity;
import jp.go.aist.six.oval.model.v5.common.DefinitionClassEnumeration;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Property;



/**
 * A single OVAL Definition.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
//@Converters( EnumerationConverter.class )
@Entity( "definition" )
public class DefinitionType
    extends OvalEntity
{

    private MetadataType  metadata;
    //{1..1}


    @Property( "class" )
    private DefinitionClassEnumeration  _definitionClass;
    //{required}


//    @Property( "family" )
//    private FamilyEnumeration  _family;
//    //{required}



    /**
     * Constructor.
     */
    public DefinitionType()
    {
    }


    public DefinitionType(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


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
    public void setMetadata(
                    final MetadataType metadata
                    )
    {
        this.metadata = metadata;
    }


    public DefinitionType metadata(
                    final MetadataType metadata
                    )
    {
        setMetadata( metadata );
        return this;
    }


    public MetadataType getMetadata()
    {
        if (metadata == null) {
            metadata = new MetadataType();
        }
        return metadata;
    }



    /**
     */
    public void setDefinitionClass(
                    final DefinitionClassEnumeration clazz
                    )
    {
        _definitionClass = clazz;
    }


    public DefinitionClassEnumeration getDefinitionClass()
    {
        return _definitionClass;
    }



//    public void setFamily(
//                    final FamilyEnumeration family
//                    )
//    {
//        _family = family;
//    }
//
//
//    public FamilyEnumeration getFamily()
//    {
//        return _family;
//    }


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
        return "definition[" + super.toString()
                        + ", class=" + getDefinitionClass()
                        + ", metadata=" + getMetadata()
////                        + ", " + getCriteria()
//                        + ", notes=" + getNotes()
                        + "]";
    }

}
// DefinitionType