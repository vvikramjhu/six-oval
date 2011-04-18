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

package jp.go.aist.six.oval.model.v5;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.HashMap;
import com.google.code.morphia.mapping.MappingException;




/**
 * An OVAL entity or an object to refer an entity.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class OvalEnumeration
    implements Serializable
{

    private static final HashMap<Class<?>, Method>  _VALUE_OF_METHODS_ = new HashMap<Class<?>, Method>();


    /**
     */
    public static Object valueOf(
                    final Class<?> targetClass,
                    final String value
                    )
    {
//        if (OvalEnumeration.class.isAssignableFrom( targetClass )) {
            Object  obj = null;

            Method  method = _VALUE_OF_METHODS_.get( targetClass );
            try {
                if (method == null) {
                    //reflection
                    method = targetClass.getMethod( "valueOf", String.class );
                    _VALUE_OF_METHODS_.put( targetClass, method );
                }
                obj = method.invoke( null, value );
            } catch (Exception ex) {
                throw new MappingException( ex.getMessage() );
            }

            return obj;
//        }

//        throw new MappingException( "unsupported type: " + String.valueOf( targetClass ) );
    }




    private final String  _value;



    /**
     * Constructor.
     */
    protected OvalEnumeration()
    {
        this( null );
    }


    public OvalEnumeration(
                    final String value
                    )
    {
        _value = value;
//        _instances.put( value, this );
    }



    /**
     */
    public final String value()
    {
        return _value;
    }





//    //**************************************************************
//    //  Comparable
//    //**************************************************************
//
//    @Override
//    public int compareTo(
//                    final OvalElement<K> o
//                    )
//    {
//        String  id1 = getOvalID();
//        String  id2 = o.getOvalID();
//        int  order = id1.compareTo( id2 );
//        if (order != 0) {
//            return order;
//        }
//
//        int  version1 = getOvalVersion();
//        int  version2 = o.getOvalVersion();
//        return (version1 - version2);
//    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

//    @Override
//    public int hashCode()
//    {
//        final int  prime = 37;
//        int  result = 17;
//
//        String  id = getOvalID();
//        result = prime * result + ((id == null) ? 0 : id.hashCode());
//
//        result = prime * result + getOvalVersion();
//
//        return result;
//    }
//
//
//
//    @Override
//    public boolean equals(
//                    final Object obj
//                    )
//    {
//        if (this == obj) {
//            return true;
//        }
//
//        if (!(obj instanceof OvalEnumeration)) {
//            return false;
//        }
//
//        @SuppressWarnings( "unchecked" )
//        OvalEnumeration<K>  other = (OvalEnumeration<K>)obj;
//        String  other_id = other.getOvalID();
//        String   this_id =  this.getOvalID();
//        if (this_id == other_id
//                        ||  (this_id != null  &&  this_id.equals( other_id ))) {
//            if (this.getOvalVersion() == other.getOvalVersion()) {
//                return true;
//            }
//        }
//
//        return false;
//    }



    @Override
    public final String toString()
    {
        return _value;
    }

}
// OvalEnumeration
