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

import jp.go.aist.six.oval.model.EntityType;
import jp.go.aist.six.oval.model.common.Datatype;



/**
 * The LocalVariable extends the Variable and defines a variable
 * with some local source.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class LocalVariable
    extends Variable
{

    private Component  _component;
    //{1..1}


    private String  _contentXml;



    /**
     * Constructor.
     */
    public LocalVariable()
    {
    }


    /**
     * Constructor.
     */
    public LocalVariable(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    /**
     * Constructor.
     */
    public LocalVariable(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );
    }



    /**
     * Constructor.
     */
    public LocalVariable(
                    final String id,
                    final int version,
                    final String comment,
                    final Datatype datatype
                    )
    {
        super( id, version, comment, datatype );
    }



    /**
     */
    public void setComponent(
                    final Component component
                    )
    {
        _component = component;
    }


    public LocalVariable component(
                    final Component component
                    )
    {
        setComponent( component );
        return this;
    }


    public Component getComponent()
    {
        return _component;
    }



    /**
     */
    public void setComponentXml(
                    final String xml
                    )
    {
        _contentXml = xml;
    }


    public String getComponentXml()
    {
        return _contentXml;
    }



    //**************************************************************
    //  Variable
    //**************************************************************

    @Override
    public EntityType getEntityType()
    {
        return EntityType.VARIABLE_LOCAL;
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