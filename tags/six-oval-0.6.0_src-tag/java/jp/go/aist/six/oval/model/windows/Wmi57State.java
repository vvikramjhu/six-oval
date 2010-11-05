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

import jp.go.aist.six.oval.model.EntityType;
import jp.go.aist.six.oval.model.definitions.EntityStateRecord;
import jp.go.aist.six.oval.model.definitions.EntityStateString;
import jp.go.aist.six.oval.model.definitions.State;




/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class Wmi57State
    extends State
{

    private EntityStateString  _namespace;
    //{0..1}

    private EntityStateString  _wql;
    //{0..1}

    private EntityStateRecord  _result;
    //{0..1}



    /**
     * Constructor.
     */
    public Wmi57State()
    {
    }


    /**
     * Constructor.
     */
    public Wmi57State(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }



    /**
     */
    public void setNamespace(
                    final EntityStateString namespace
                    )
    {
        _namespace = namespace;
    }


    public EntityStateString getNamespace()
    {
        return _namespace;
    }



    /**
     */
    public void setWql(
                    final EntityStateString wql
                    )
    {
        _wql = wql;
    }


    public EntityStateString getWql()
    {
        return _wql;
    }



    /**
     */
    public void setResult(
                    final EntityStateRecord result
                    )
    {
        _result = result;
    }


    public EntityStateRecord getResult()
    {
        return _result;
    }



    //**************************************************************
    //  State
    //**************************************************************

    @Override
    public EntityType getEntityType()
    {
        return EntityType.WINDOWS_WMI57;
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
                        + ", namespace=" + getNamespace()
                        + ", wql=" + getWql()
                        + ", result=" + getResult()
                        + "]";
    }

}
// Wql57State
