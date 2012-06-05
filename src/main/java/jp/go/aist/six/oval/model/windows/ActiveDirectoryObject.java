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

package jp.go.aist.six.oval.model.windows;

import java.util.ArrayList;
import java.util.Collection;
import jp.go.aist.six.oval.model.Component;
import jp.go.aist.six.oval.model.ElementRef;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.definitions.EntityObjectStringType;
import jp.go.aist.six.oval.model.definitions.Set;
import jp.go.aist.six.oval.model.definitions.SystemObjectType;



/**
 * The activedirectory object is used by an active directory test
 * to define those objects to evaluated based on a specified state.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class ActiveDirectoryObject
    extends SystemObjectType
{

    // xsd:choice

    private Set  set;


    private EntityObjectNamingContextType  naming_context;
    //{1..1}

    private EntityObjectStringType  relative_dn;
    //{1..1, nillable="true"}

    private EntityObjectStringType  attribute;
    //{1..1, nillable="true"}



    /**
     * Constructor.
     */
    public ActiveDirectoryObject()
    {
        this( null, 0 );
    }


    public ActiveDirectoryObject(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public ActiveDirectoryObject(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        this( id, version, comment,
                        (EntityObjectNamingContextType)null,
                        (EntityObjectStringType)null,
                        (EntityObjectStringType)null
                        );
    }


    public ActiveDirectoryObject(
                    final String id,
                    final int version,
                    final String comment,
                    final NamingContextEnumeration naming_context,
                    final String relative_dn,
                    final String attribute
                    )
    {
        this( id, version, comment,
                        (naming_context == null ? null : (new EntityObjectNamingContextType( naming_context.value() ))),
                        (relative_dn  == null ? null : (new EntityObjectStringType( relative_dn ))),
                        (attribute == null ? null : (new EntityObjectStringType( attribute )))
        );
    }


    public ActiveDirectoryObject(
                    final String id,
                    final int version,
                    final String comment,
                    final EntityObjectNamingContextType naming_context,
                    final EntityObjectStringType relative_dn,
                    final EntityObjectStringType attribute
                    )
    {
        super( id, version, comment );
        setNamingContext( naming_context );
        setRelativeDn( relative_dn );
        setAttribute( attribute );

//        _oval_platform_type = OvalPlatformType.windows;
//        _oval_component_type = OvalComponentType.activedirectory;
        _oval_family = Family.WINDOWS;
        _oval_component = Component.ACTIVEDIRECTORY;
    }



    /**
     */
    public void setSet(
                    final Set set
                    )
    {
        this.set = set;
    }


    public Set getSet()
    {
        return set;
    }



    /**
     */
    public void setNamingContext(
                    final EntityObjectNamingContextType naming_context
                    )
    {
        this.naming_context = naming_context;
    }


    public EntityObjectNamingContextType getNamingContext()
    {
        return naming_context;
    }




    public void setRelativeDn(
                    final EntityObjectStringType relative_dn
                    )
    {
        this.relative_dn = relative_dn;
    }


    public EntityObjectStringType getRelativeDn()
    {
        return relative_dn;
    }



    public void setAttribute(
                    final EntityObjectStringType attribute
                    // nillable ="true"
                    )
    {
        this.attribute = attribute;
    }


    public EntityObjectStringType getAttribute()
    {
        return attribute;
    }



    //*********************************************************************
    //  DefinitionsElement
    //*********************************************************************

    @Override
    public Collection<ElementRef> ovalGetElementRef()
    {
        Collection<ElementRef>  ref_list = new ArrayList<ElementRef>();

        ref_list.add( getNamingContext() );
        ref_list.add( getRelativeDn() );
        ref_list.add( getAttribute() );

        return ref_list;
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
        if (!(obj instanceof ActiveDirectoryObject)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "activedirectory_object[" + super.toString()
                        + ", set="              + getSet()
                        + ", naming_context="   + getNamingContext()
                        + ", relative_dn="      + getRelativeDn()
                        + ", attribute="        + getAttribute()
                        + "]";
    }

}
//ActiveDirectoryObject
