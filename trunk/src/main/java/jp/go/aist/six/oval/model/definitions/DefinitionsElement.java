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

package jp.go.aist.six.oval.model.definitions;

import java.util.Collection;
import jp.go.aist.six.oval.model.DocumentGenerator;
import jp.go.aist.six.oval.model.Element;
import jp.go.aist.six.oval.model.ElementRef;
import jp.go.aist.six.util.persist.Persistable;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.PrePersist;




/**
 * An OVAL entity.
 * The kinds are definition, test, state, object, and variable.
 * Every OVAL entity is identified by a pair of its identifier and version.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class DefinitionsElement
    extends Element
    implements Persistable<String>
{

//    public enum Type
//    implements OvalEnumeration
//    {
//        DEFINITION( OvalId.Type.def ),
//        TEST(       OvalId.Type.tst ),
//        OBJECT(     OvalId.Type.obj ),
//        STATE(      OvalId.Type.ste ),
//        VARIABLE(   OvalId.Type.var );
//
//
//        ////////////////////////////////////////////////////////////
//
//        /**
//         * A factory method.
//         */
//        public static Type fromValue(
//                        final String value
//                        )
//        {
//            for (Type  e : Type.values()) {
//                if (e.value.equals( value )) {
//                    return e;
//                }
//            }
//
//            throw new IllegalArgumentException( value );
//        }
//
//
//        public static Type fromOvalIdType(
//                        final OvalId.Type id_type
//                        )
//        {
//            for (Type  e : Type.values()) {
//                if (e.getOvalIdType() == id_type) {
//                    return e;
//                }
//            }
//
//            throw new IllegalArgumentException( String.valueOf( id_type ) );
//        }
//
//
//        public static Type fromOvalId(
//                        final String oval_id
//                        )
//        {
//            return fromOvalIdType( OvalId.typeOf( oval_id ) );
//        }
//
//
//        private String  value;
//        private OvalId.Type  id_type = null;
//
//
//        Type(
//                        final OvalId.Type type
//                        )
//        {
//            value = name().toLowerCase();
//            id_type = type;
//        }
//
//
//
//        /**
//         * The type indicator in the OVAL-ID.
//         */
//        public OvalId.Type getOvalIdType()
//        {
//            return id_type;
//        }
//
//
//
//        //OvalEnumeration
//        @Override
//        public String value()
//        {
//            return value;
//        }
//
//
//        // java.lang.String
//        @Override
//        public String toString()
//        {
//            return value;
//        }
//    }
//    //Type



    // MongoDB
    @Id
    private String  _id;


    public static final Boolean  DEFAULT_DEPRECATED = Boolean.FALSE;

    private Boolean  deprecated;
    //{optional, default="false"}


    // SIX extension
    protected DocumentGenerator      _oval_generator;
//    protected OvalEntityType     _oval_entity_type;
//    protected OvalPlatformType   _oval_platform_type;
//    protected OvalComponentType  _oval_component_type;

//    @Transient
//    protected Type  _definitions_element_type;



    /**
     * Constructor.
     */
    public DefinitionsElement()
    {
    }


    /**
     * Constructor.
     */
    public DefinitionsElement(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }



    /**
     */
    public void setDeprecated(
                    final Boolean deprecated
                    )
    {
        this.deprecated = deprecated;
    }


    public Boolean getDeprecated()
    {
        return deprecated;
    }



    //*********************************************************************
    //  SIX
    //*********************************************************************

    public void ovalGetGenerator(
                    final DocumentGenerator generator
                    )
    {
        _oval_generator = generator;
    }



//    public abstract Type ovalGetElementType();



    /**
     * Returns the element references.
     * The result collection may contain null.
     *
     * If this element is a Definition, this method returns
     * the Test and Definition references contained in the "criteria" part.
     *
     * @return
     *  a collection of the references.
     */
    public abstract Collection<ElementRef> ovalGetElementRef();



    //**************************************************************
    //  MongoDB/Morphia Lifecycle
    //**************************************************************

    @SuppressWarnings( "unused" )
    @PrePersist
    private void _assignPersistentID()
    {
        String  pid = getPersistentID();
        if (pid == null) {
            pid = getOvalID();
//            pid = globalRefOf( this );
            setPersistentID( pid );
        }
    }



    //**************************************************************
    //  Persistable
    //**************************************************************

//    @Override
//    public String getPersistentID()
//    {
//        return ovalGetGlobalID();
//
////        String  pid = super.getPersistentID();
////        if (pid == null) {
////            pid = getOvalGlobalID();
////            super.setPersistentID( pid );
////        }
////
////        return pid;
//    }



    @Override
    public void setPersistentID(
                    final String pid
                    )
    {
        _id = pid;
    }


    @Override
    public String getPersistentID()
    {
        return _id;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof DefinitionsElement)) {
            return false;
        }

        return super.equals( obj );
    }

}
//
