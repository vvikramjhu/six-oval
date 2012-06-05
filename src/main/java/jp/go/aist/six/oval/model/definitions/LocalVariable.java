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

import java.util.ArrayList;
import java.util.Collection;
import jp.go.aist.six.oval.model.ElementRef;
import jp.go.aist.six.oval.model.common.DatatypeEnumeration;



/**
 * The LocalVariable extends the Variable and defines a variable
 * with some local source.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class LocalVariable
    extends VariableType
{

    private ComponentGroup  component;
    //{1..1}


    private String  _componentXml;



    /**
     * Constructor.
     */
    public LocalVariable()
    {
        this( null, 0 );
    }


    public LocalVariable(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public LocalVariable(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        this( id, version, comment, null );
    }


    public LocalVariable(
                    final String id,
                    final int version,
                    final String comment,
                    final DatatypeEnumeration datatype
                    )
    {
        super( id, version, comment, datatype );

//        _oval_component_type = OvalComponentType.local;
    }



    /**
     */
    public void setComponent(
                    final ComponentGroup component
                    )
    {
        this.component = component;
    }


    public ComponentGroup getComponent()
    {
        return component;
    }


    public LocalVariable component(
                    final ComponentGroup component
                    )
    {
        setComponent( component );
        return this;
    }



    /**
     */
    public void xmlSetComponent(
                    final String xml
                    )
    {
        _componentXml = xml;
    }


    public String xmlGetComponent()
    {
        return _componentXml;
    }



    //*********************************************************************
    //  SIX extension
    //*********************************************************************

    @Override
    public VariableType.Type ovalGetVariableType()
    {
        return VariableType.Type.LOCAL;
    }



    @Override
    public Collection<ElementRef> ovalGetElementRef()
    {
        Collection<ElementRef>  ref_list = super.ovalGetElementRef();
        ComponentGroup  component = getComponent();
        if (component == null) {
            return ref_list;
        }

        ref_list = new ArrayList<ElementRef>( ref_list );
        _collectElementRef( ref_list, component );

        return ref_list;
    }



    private void _collectElementRef(
                    final Collection<ElementRef> ref_list,
                    final ComponentGroup component
                    )
    {
        if (ElementRef.class.isInstance( component )) {
            ref_list.add( ElementRef.class.cast( component ) );
        }

        Collection<ComponentGroup>  subcomponent_list = component.ovalGetSubComponent();
        if (subcomponent_list != null  &&  subcomponent_list.size() > 0) {
            for (ComponentGroup  subcomponent : subcomponent_list) {
                _collectElementRef( ref_list, subcomponent );
            }
        }
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
        if (!(obj instanceof LocalVariable)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "local_variable[" + super.toString()
             + ", " + getComponent()
             + "]";
    }

}
// LocalVariable
