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

import jp.go.aist.six.oval.model.OvalComponentType;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.definitions.EntityStateRecordType;
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.definitions.StateType;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class Wmi57State
    extends StateType
{

    private EntityStateStringType  namespace;
    //{0..1}

    private EntityStateStringType  wql;
    //{0..1}

    private EntityStateRecordType  result;
    //{0..1, unique="field/@name"}



    /**
     * Constructor.
     */
    public Wmi57State()
    {
        this( null, 0 );
    }


    public Wmi57State(
                    final String id,
                    final int version
                    )
    {
        super( id, version );

        _oval_platform_type = OvalPlatformType.windows;
        _oval_component_type = OvalComponentType.wmi57;
    }



    /**
     */
    public void setNamespace(
                    final EntityStateStringType namespace
                    )
    {
        this.namespace = namespace;
    }


    public EntityStateStringType getNamespace()
    {
        return this.namespace;
    }



    /**
     */
    public void setWql(
                    final EntityStateStringType wql
                    )
    {
        this.wql = wql;
    }


    public EntityStateStringType getWql()
    {
        return this.wql;
    }



    /**
     */
    public void setResult(
                    final EntityStateRecordType result
                    )
    {
        this.result = result;
    }


    public EntityStateRecordType getResult()
    {
        return this.result;
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
        if (!(obj instanceof Wmi57State)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "wmi57_state[" + super.toString()
                        + ", " + getNamespace()
                        + ", " + getWql()
                        + ", " + getResult()
                        + "]";
    }

}
//Wmi57State
