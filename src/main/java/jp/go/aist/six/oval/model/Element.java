/*
 *  @product.title@
 *  Copyright (C) @product.copyright-year@
 *    @product.vendor@
 *    Registration Number: @product.registration-number@
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.go.aist.six.oval.model;

import com.google.code.morphia.annotations.Transient;



/**
 * An OVAL element.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class Element
    implements OvalObject, Comparable<Element>
{

//    private String  oval_id;
//    //{required, oval:XxxIDPattern}

    private Integer  oval_version;
    //{required, xsd:nonNegativeInteger}



    /**
     * Constructor.
     */
    public Element()
    {
    }


    /**
     * Constructor.
     *
     * @param   id
     *  the OVAL-ID of the entity.
     * @param   version
     *  the version of the entity.
     */
    public Element(
                    final String id,
                    final int version
                    )
    {
        setOvalId( id );
        setOvalVersion( version );
    }



    /**
     * Sets the OVAL-ID.
     *
     * @param   id
     *  the OVAL-ID.
     */
    public abstract void setOvalId( String id );
//    public void setOvalID(
//                    final String id
//                    )
//    {
//        oval_id = id;
//    }


    /**
     * Retuens the OVAL-ID.
     *
     * @return
     *  the OVAL-ID.
     */
    public abstract String getOvalId();
//    public String getOvalID()
//    {
//        return oval_id;
//    }



    /**
     * Sets the version.
     *
     * @param   version
     *  the version.
     */
    public void setOvalVersion(
                    final Integer version
                    )
    {
        if (version != null  &&  version < 0) {
            throw new IllegalArgumentException(
                            "negative version: " + version );
        }
        oval_version = version;
    }


    /**
     * Returns the version.
     *
     * @return
     *  the version.
     */
    public Integer getOvalVersion()
    {
        return oval_version;
    }



    //*********************************************************************
    //  SIX
    //*********************************************************************

    /**
     */
    public static final String globalRefOf(
                    final Element e
                    )
    {
        if (e == null) {
            throw new IllegalArgumentException( "null element" );
        }

        Integer  version = e.getOvalVersion();
        if (version == null) {
            throw new IllegalArgumentException( "null version" );
        }

        return globalRefOf( e.getOvalId(), version.intValue() );
    }


    public static final String globalRefOf(
                    final String id,
                    final int version
                    )
    {
        if (id == null || id.length() == 0) {
            throw new IllegalArgumentException( "null or empty ovalID" );
        }

        return id + ":" + version;
    }



    /**
     * ovalID + ":" + ovalVersion
     */
    @Transient
    private transient String  _ovalGlobalRef;



    /**
     */
    public final void ovalSetGlobalRef(
                    final String gid
                    )
    {
        _ovalGlobalRef = gid;
    }


    public final String ovalGetGlobalRef()
    {
        if (_ovalGlobalRef == null) {
            _ovalGlobalRef = globalRefOf( this );
        }

        return _ovalGlobalRef;
    }



    /**
     * Returns the type of this element.
     */
    public abstract ElementType ovalGetType();



    //*********************************************************************
    //  java.lang.Comparable
    //*********************************************************************

    @Override
    public int compareTo(
                    final Element o
                    )
    {
        String  id1 = getOvalId();
        String  id2 = o.getOvalId();
        int  order = id1.compareTo( id2 );
        if (order != 0) {
            return order;
        }

        int  version1 = getOvalVersion();
        int  version2 = o.getOvalVersion();
        return (version1 - version2);
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        String  id = getOvalId();
        result = prime * result + ((id == null) ? 0 : id.hashCode());

        result = prime * result + getOvalVersion();

        return result;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Element)) {
            return false;
        }

        Element  other = (Element)obj;
        String  other_id = other.getOvalId();
        String   this_id =  this.getOvalId();
        if (this_id == other_id
                        ||  (this_id != null  &&  this_id.equals( other_id ))) {
            if (this.getOvalVersion() == other.getOvalVersion()) {
                return true;
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "id=" + getOvalId()
                + ", version=" + getOvalVersion();
    }



//    /**
//     */
//    public static class ElementComparator
//    implements Comparator<Element>
//    {
//        public static final ElementComparator  INSTANCE = new ElementComparator();
//
//
//        public ElementComparator()
//        {
//        }
//
//
//
//        @Override
//        public int compare(
//                        final Element e1,
//                        final Element e2
//                        )
//        {
//            String  id1 = e1.getOvalID();
//            String  id2 = e2.getOvalID();
//            int  order = id1.compareTo( id2 );
//            if (order != 0) {
//                return order;
//            }
//
//            int  version1 = e1.getOvalVersion();
//            int  version2 = e2.getOvalVersion();
//            return (version1 - version2);
//        }
//
//
//
//        @Override
//        public boolean equals(
//                        final Object obj
//                        )
//        {
//            return (obj instanceof ElementComparator);
//        }
//    }

}
//Element
