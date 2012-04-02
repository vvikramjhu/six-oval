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

package jp.go.aist.six.oval.model.independent;

import jp.go.aist.six.oval.model.Component;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.definitions.EntityObjectStringType;
import jp.go.aist.six.oval.model.definitions.Set;
import jp.go.aist.six.oval.model.definitions.SystemObjectType;



/**
 * The environmentvariable58_object is used by an environmentvariable_test
 * to define the specific environment variable(s) and process IDs to be evaluated.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 * @deprecated Deprecated as of version 5.8:
 *             Replaced by the environmentvariable58 object and
 *             will be removed in a future version of the language.
 */
@Deprecated
public class EnvironmentVariableObject
    extends SystemObjectType
{
    // XSD model:
    // choice(
    //         set
    //         name
    // )

    private Set  set;
    //{1..1}


    private EntityObjectStringType  name;
    //{1..1}



    /**
     * Constructor.
     */
    public EnvironmentVariableObject()
    {
        this( null, 0 );
    }


    public EnvironmentVariableObject(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public EnvironmentVariableObject(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

//        _oval_platform_type = OvalPlatformType.independent;
//        _oval_component_type = OvalComponentType.environmentvariable;
        _oval_family = Family.INDEPENDENT;
        _oval_component = Component.ENVIRONMENTVARIABLE;
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
    public void setName(
                    final EntityObjectStringType name
                    )
    {
        this.name = name;
    }


    public EntityObjectStringType getName()
    {
        return name;
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
        if (!(obj instanceof EnvironmentVariableObject)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "environmentvariable_object[" + super.toString()
                        + ", set=" + getSet()
                        + ", name=" + getName()
                        + "]";
    }

}
// EnvironmentVariableObject
