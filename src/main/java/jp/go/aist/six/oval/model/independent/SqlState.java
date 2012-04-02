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
import jp.go.aist.six.oval.model.definitions.EntityStateAnySimpleType;
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.definitions.StateType;



/**
 * The SQL state contains two entities that are used to check
 * the name of the specified field and the value associated with it.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 * @deprecated Deprecated as of version 5.7:
 *             Replaced by the sql57 state and
 *             will be removed in a future version of the language.
 */
@Deprecated
public class SqlState
    extends StateType
{

    private EntityStateEngineType  engine;
    //{0..1}

    private EntityStateStringType  version;
    //{0..1}

    private EntityStateStringType  connection_string;
    //{0..1}

    private EntityStateStringType  sql;
    //{0..1}

    private EntityStateAnySimpleType  result;
    //{0..1}



    /**
     * Constructor.
     */
    public SqlState()
    {
        this( null, 0 );
    }


    public SqlState(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public SqlState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

//        _oval_platform_type = OvalPlatformType.independent;
//        _oval_component_type = OvalComponentType.sql;
        _oval_family = Family.INDEPENDENT;
        _oval_component = Component.SQL;
    }



    /**
     */
    public void setEngine(
                    final EntityStateEngineType engine
                    )
    {
        this.engine = engine;
    }


    public EntityStateEngineType getEngine()
    {
        return engine;
    }



    /**
     */
    public void setVersion(
                    final EntityStateStringType version
                    )
    {
        this.version = version;
    }


    public EntityStateStringType getVersion()
    {
        return version;
    }



    /**
     */
    public void setConnectionString(
                    final EntityStateStringType connection_string
                    )
    {
        this.connection_string = connection_string;
    }


    public EntityStateStringType getConnectionString()
    {
        return connection_string;
    }



    /**
     */
    public void setSql(
                    final EntityStateStringType sql
                    )
    {
        this.sql = sql;
    }


    public EntityStateStringType getSql()
    {
        return sql;
    }



    /**
     */
    public void setResult(
                    final EntityStateAnySimpleType result
                    )
    {
        this.result = result;
    }


    public EntityStateAnySimpleType getResult()
    {
        return result;
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
        if (!(obj instanceof SqlState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "sql_state[" + super.toString()
                        + ", engine="           + getEngine()
                        + ", version="          + getVersion()
                        + ", conection_string=" + getConnectionString()
                        + ", sql="              + getSql()
                        + ", result="           + getResult()
                        + "]";
    }

}
// SqlState
