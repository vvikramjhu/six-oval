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

package jp.go.aist.six.oval.model.v5.windows;

import java.util.Iterator;
import jp.go.aist.six.oval.model.v5.PlatformEntityType;
import jp.go.aist.six.oval.model.v5.definitions.EntityAttributeGroup;
import jp.go.aist.six.oval.model.v5.definitions.EntityObjectStringType;
import jp.go.aist.six.oval.model.v5.definitions.EntityPropertyMap;
import jp.go.aist.six.oval.model.v5.definitions.SystemObjectType;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 * @deprecated Deprecated as of version 5.7:
 *             Replaced by the wmi57 object and
 *             will be removed in a future version of the language.
 */
@Deprecated
public class WmiObject
    extends SystemObjectType
{

    private final EntityPropertyMap<WmiProperty>  _properties =
        WmiProperty.createPropertyMap();


//    private EntityObjectStringType  _namespace;
//    //{1..1}
//
//    private EntityObjectStringType  _wql;
//    //{1..1}



    /**
     * Constructor.
     */
    public WmiObject()
    {
    }


    public WmiObject(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    public WmiObject(
                    final String id,
                    final int version,
                    final String namespace,
                    final String wql
                    )
    {
        this( id, version,
                        (namespace == null ? null : (new EntityObjectStringType( namespace ))),
                        (wql == null ? null : (new EntityObjectStringType( wql )))
        );
    }


    public WmiObject(
                    final String id,
                    final int version,
                    final EntityObjectStringType namespace,
                    final EntityObjectStringType wql
                    )
    {
        super( id, version );

        setNamespace( namespace );
        setWql( wql );
    }



    /**
     */
    public void setNamespace(
                    final EntityObjectStringType namespace
                    )
    {
        _properties.setProperty( WmiProperty.NAMESPACE, namespace );
    }


    public EntityObjectStringType getNamespace()
    {
        return _properties.getProperty(
                        WmiProperty.NAMESPACE, EntityObjectStringType.class );
    }



    /**
     */
    public void setWql(
                    final EntityObjectStringType wql
                    )
    {
        _properties.setProperty( WmiProperty.WQL, wql );
    }


    public EntityObjectStringType getWql()
    {
        return _properties.getProperty(
                        WmiProperty.WQL, EntityObjectStringType.class );
    }



    //**************************************************************
    //  SystemObject
    //**************************************************************

    @Override
    public PlatformEntityType getEntityType()
    {
        return PlatformEntityType.WINDOWS_WMI;
    }



    @Override
    public Iterator<EntityAttributeGroup> iterateProperties()
    {
        return _properties.iterateProperties();
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
        if (!(obj instanceof WmiObject)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "wmi_object[" + super.toString()
                        + ", " + String.valueOf( _properties )
                        + "]";
    }

}
// WmiObject
