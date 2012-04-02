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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import jp.go.aist.six.oval.model.Component;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.sc.EntityItemAnySimpleType;
import jp.go.aist.six.oval.model.sc.EntityItemStringType;
import jp.go.aist.six.oval.model.sc.ItemType;



/**
 * The SQL item outlines information collected from a database via an SQL query.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class SqlItem
    extends ItemType
{

    private EntityItemEngineType  engine;
    //{0..1}

    private EntityItemStringType  version;
    //{0..1}

    private EntityItemStringType  connection_string;
    //{0..1}

    private EntityItemStringType  sql;
    //{0..1}

    private final Collection<EntityItemAnySimpleType>  result = new ArrayList<EntityItemAnySimpleType>();
    //{0..*}



    /**
     * Constructor.
     */
    public SqlItem()
    {
        this( 0 );
    }


    public SqlItem(
                    final int id
                    )
    {
        super( id );

//        _oval_platform_type = OvalPlatformType.independent;
//        _oval_component_type = OvalComponentType.sql;
        _oval_family = Family.INDEPENDENT;
        _oval_component = Component.SQL;
    }



    /**
     */
    public void setEngine(
                    final EntityItemEngineType engine
                    )
    {
        this.engine = engine;
    }


    public EntityItemEngineType getEngine()
    {
        return engine;
    }



    /**
     */
    public void setVersion(
                    final EntityItemStringType version
                    )
    {
        this.version = version;
    }


    public EntityItemStringType getVersion()
    {
        return version;
    }



    /**
     */
    public void setConnectionString(
                    final EntityItemStringType connection_string
                    )
    {
        this.connection_string = connection_string;
    }


    public EntityItemStringType getConnectionString()
    {
        return connection_string;
    }



    /**
     */
    public void setSql(
                    final EntityItemStringType sql
                    )
    {
        this.sql = sql;
    }


    public EntityItemStringType getSql()
    {
        return sql;
    }



    /**
     */
    public void setResult(
                    final Collection<? extends EntityItemAnySimpleType> results
                    )
    {
        result.clear();
        if (results != null  &&  results.size() > 0) {
            for (EntityItemAnySimpleType  result : results) {
                addResult( result );
            }
        }
    }


    public boolean addResult(
                    final EntityItemAnySimpleType result
                    )
    {
        if (result == null) {
            throw new IllegalArgumentException( "empty result" );
        }

        return this.result.add( result );
    }


    public Collection<EntityItemAnySimpleType> getResult()
    {
        return result;
    }


    public Iterator<EntityItemAnySimpleType> iterateResult()
    {
        return result.iterator();
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
        if (!(obj instanceof SqlItem)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "ldap_item[" + super.toString()
                        + ", engine="               + getEngine()
                        + ", version="              + getVersion()
                        + ", connection_string="    + getConnectionString()
                        + ", sql="                  + getSql()
                        + ", result="               + getResult()
                        + "]";
    }

}
// SqlItem
