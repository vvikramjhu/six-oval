/*
 *  @ProductName@
 *  Copyright (C) @CopyrightYear@
 *    National Institute of Advanced Industrial Science and Technology (AIST)
 *    Registration Number: @AISTRegistrationNumber@
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
import jp.go.aist.six.oval.model.definitions.EntityStateAnySimple;
import jp.go.aist.six.oval.model.definitions.EntityStateString;
import jp.go.aist.six.oval.model.definitions.State;




/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class WmiState
    extends State
{

    private EntityStateString  _namespace;
    //{0..1}

    private EntityStateString  _wql;
    //{0..1}

    private EntityStateAnySimple  _result;
    //{0..1}



    /**
     * Constructor.
     */
    public WmiState()
    {
    }


    /**
     * Constructor.
     */
    public WmiState(
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
                    final EntityStateAnySimple result
                    )
    {
        _result = result;
    }


    public EntityStateAnySimple getResult()
    {
        return _result;
    }



    //**************************************************************
    //  State
    //**************************************************************

    @Override
    public EntityType getEntityType()
    {
        return EntityType.WINDOWS_WMI;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  code = super.hashCode();

        EntityStateString  namespace = getNamespace();
        code = prime * code + ((namespace == null) ? 0 : namespace.hashCode());

        EntityStateString  wql = getWql();
        code = prime * code + ((wql == null) ? 0 : wql.hashCode());

        EntityStateAnySimple  result = getResult();
        code = prime * code + ((result == null) ? 0 : result.hashCode());

        return code;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof WmiState)) {
            return false;
        }

        if (super.equals( obj )) {
            WmiState  other = (WmiState)obj;
            EntityStateString  other_namespace = other.getNamespace();
            EntityStateString   this_namespace =  this.getNamespace();
            if (this_namespace == other_namespace
                            ||  (this_namespace != null  &&  this_namespace.equals( other_namespace ))) {
                EntityStateString  other_wql = other.getWql();
                EntityStateString   this_wql =  this.getWql();
                if (this_wql == other_wql
                                ||  (this_wql != null  &&  this_wql.equals( other_wql ))) {
                    EntityStateAnySimple  other_result = other.getResult();
                    EntityStateAnySimple   this_result =  this.getResult();
                    if (this_result == other_result
                                    ||  (this_result != null  &&  this_result.equals( other_result ))) {
                        return true;
                    }
                }
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "WqlState[" + super.toString() + "]";
    }

}
// WqlState
