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

package jp.go.aist.six.oval.model;




/**
 * An OVAL entity.
 * The kinds are definition, test, state, object, and variable.
 * Every OVAL entity is identified by a pair of its identifier and version.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class OvalEntity
    extends OvalElement
{

    public static final boolean  DEFAULT_DEPRECATED = false;
    private boolean  _deprecated = DEFAULT_DEPRECATED;
    //{optional, default="false"}



    /**
     * Constructor.
     */
    public OvalEntity()
    {
    }


    /**
     * Constructor.
     */
    public OvalEntity(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }



    public void setDeprecated(
                    final boolean deprecated
                    )
    {
        _deprecated = deprecated;
    }


    public boolean isDeprecated()
    {
        return _deprecated;
    }



    //**************************************************************
    //  Persistable
    //**************************************************************

    @Override
    public String getPersistentID()
    {
        return getOvalGlobalID();

//        String  pid = super.getPersistentID();
//        if (pid == null) {
//            pid = getOvalGlobalID();
//            super.setPersistentID( pid );
//        }
//
//        return pid;
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
        if (!(obj instanceof OvalEntity)) {
            return false;
        }

        return super.equals( obj );
    }

}
// OvalEntity
