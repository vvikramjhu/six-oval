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

package jp.go.aist.six.oval.model;

import java.io.Serializable;
import java.util.Arrays;



/**
 * An OVAL-ID.
 * The instances are immutable.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public final class OvalId
    implements Cloneable, Serializable
{

    public static final String  PREFIX = "oval";

    public static final char  SEPARATOR = ':';


    /**
     * The types of OVAL entity for which the OVAL-ID is used.
     */
    public enum Type
    {
        def,
        tst,
        obj,
        ste,
        var
    }



//    private String  _ovalIdString;


    private String  _namespace;
    private Type  _type;
    private int  _idValue;



    /**
     * Constructor.
     */
    protected OvalId()
    {
    }


    public OvalId(
                    final String oval_id
                    )
    throws OvalIdSyntaxException
    {
        this( oval_id.split( ":" ) );
    }


    public OvalId(
                    final String[] components
                    )
    throws OvalIdSyntaxException
    {
        if (components.length == 3) {
            _set( PREFIX, components[0], components[1], components[2] );
        } else if (components.length == 4) {
            _set( components[0], components[1], components[2], components[3] );
        } else {

            throw new OvalIdSyntaxException(
                            "insufficient or surplus components: "
                                            + Arrays.toString( components ) );
        }
    }


    public OvalId(
                    final String namespace,
                    final String type,
                    final String id_value
                    )
    throws OvalIdSyntaxException
    {
        this( PREFIX, namespace, type, id_value );
    }


    public OvalId(
                    final String namespace,
                    final Type type,
                    final int id_value
                    )
    throws OvalIdSyntaxException
    {
        this( PREFIX, namespace, type, id_value );
    }


    public OvalId(
                    final String prefix,
                    final String namespace,
                    final String type,
                    final String id_value
                    )
    throws OvalIdSyntaxException
    {
        _set( prefix, namespace, type, id_value );
    }


    public OvalId(
                    final String prefix,
                    final String namespace,
                    final Type type,
                    final int id_value
                    )
    throws OvalIdSyntaxException
    {
        _set( prefix, namespace, type, id_value );
    }



    /**
     */
    public static final void validate(
                    final String oval_id
                    )
    throws OvalIdSyntaxException
    {
        if (oval_id == null) {
            throw new IllegalArgumentException( "empty OVAL-ID (null)" );
        }

        //validation
        new OvalId( oval_id );
    }



    /**
     */
    public static final Type typeOf(
                    final String oval_id
                    )
    {
        String[]  components = oval_id.split( ":" );
        if (components.length != 4) {
            throw new OvalIdSyntaxException( "invalid OVAL-ID: " + oval_id );
        }

        return Type.valueOf( components[2] );
    }



    /**
     */
    private void _set(
                    final String prefix,
                    final String namespace,
                    final String type,
                    final String id_value
                    )
    {
        try {
            _set( prefix, namespace, Type.valueOf( type ), Integer.valueOf( id_value ).intValue() );
        } catch (OvalIdSyntaxException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new OvalIdSyntaxException( "invalid OVAL-ID: prefix=" + prefix
                            + ", namespace=" + namespace
                            + ", type=" + type
                            + ", ID value=" + id_value
                            );
        }
    }



    /**
     */
    private void _set(
                    final String prefix,
                    final String namespace,
                    final Type type,
                    final int id_value
                    )
    {
        _setPrefix( prefix );
        _setNamespace( namespace );
        _setType( type );
        _setIdValue( id_value );
    }



    /**
     */
    private void _setPrefix(
                    final String prefix
                    )
    {
        if (PREFIX == prefix  ||  PREFIX.equals( prefix )) {
            //valid
        } else {
            throw new OvalIdSyntaxException( "invalid prefix: " + prefix );
        }
    }


    public String getPrefix()
    {
        return PREFIX;
    }



    /**
     */
    private void _setNamespace(
                    final String namespace
                    )
    {
        if (namespace == null  ||  namespace.length() == 0) {
            throw new OvalIdSyntaxException( "invalid namespace: " + namespace );
        }

        _namespace = namespace;
    }


    public String getNamespace()
    {
        return _namespace;
    }



    /**
     */
    private void _setType(
                    final Type type
                    )
    {
        if (type == null) {
            throw new OvalIdSyntaxException( "invalid type: " + type );
        }

        _type = type;
    }


    public Type getType()
    {
        return _type;
    }



    /**
     */
    private void _setIdValue(
                    final int idValue
                    )
    {
        _idValue = idValue;
    }


    public int getIdValue()
    {
        return _idValue;
    }



    /**
     */
    public boolean isDefinition()
    {
        return (Type.def == _type);
    }


    public boolean isTest()
    {
        return (Type.tst == _type);
    }


    public boolean isSystemObject()
    {
        return (Type.obj == _type);
    }


    public boolean isState()
    {
        return (Type.ste == _type);
    }


    public boolean isVariable()
    {
        return (Type.var == _type);
    }



    //**************************************************************
    //  Comparable
    //**************************************************************

//    @Override
//    public int compareTo(
//                    final OvalIdD o
//                    )
//    {
//        String  id1 = getValue();
//        String  id2 = o.getValue();
//
//        return id1.compareTo( id2 );
//    }



    //**************************************************************
    //  java.lang.Cloneable
    //**************************************************************

    @Override
    public Object clone()
    throws CloneNotSupportedException
    {
        return (new OvalId( _namespace, _type, _idValue ));
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        result = prime * result + (_namespace == null ? 0 : _namespace.hashCode());
        result = prime * result + (_type == null ? 0 : _type.hashCode());
        result = prime * result + _idValue;

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

        if (!(obj instanceof OvalId)) {
            return false;
        }

        OvalId  other = (OvalId)obj;
        if (this.getIdValue() == other.getIdValue()) {
            if (this.getType() == other.getType()) {
                String  this_namespace = getNamespace();
                String  other_namespace = other.getNamespace();
                if (this_namespace == other_namespace
                                ||  (this_namespace != null  &&  this_namespace.equals( other_namespace ))) {
                    return true;
                }
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return PREFIX + SEPARATOR + _namespace + SEPARATOR + _type.name() + SEPARATOR + _idValue;
    }

}
//
