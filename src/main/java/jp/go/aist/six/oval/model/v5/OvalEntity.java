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

package jp.go.aist.six.oval.model.v5;

import jp.go.aist.six.util.persist.Persistable;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.PrePersist;




/**
 * An OVAL entity.
 * The kinds are definition, test, state, object, and variable.
 * Every OVAL entity is identified by a pair of its identifier and version.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class OvalEntity
    extends OvalElement
    implements Persistable<String>
{

    // MongoDB
    @Id
    private String  _id;


    public static final Boolean  DEFAULT_DEPRECATED = Boolean.FALSE;

    private Boolean  deprecated;
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



    /**
     */
    public void setDeprecated(
                    final Boolean deprecated
                    )
    {
        this.deprecated = deprecated;
    }


    public Boolean getDeprecated()
    {
        return this.deprecated;
    }



    //**************************************************************
    //  MongoDB/Morphia Lifecycle
    //**************************************************************

    @SuppressWarnings( "unused" )
    @PrePersist
    private void _assignPersistentID()
    {
        String  pid = getPersistentID();
        if (pid == null) {
            pid = getOvalID();
//            pid = globalRefOf( this );
            setPersistentID( pid );
        }
    }



    //**************************************************************
    //  Persistable
    //**************************************************************

//    @Override
//    public String getPersistentID()
//    {
//        return ovalGetGlobalID();
//
////        String  pid = super.getPersistentID();
////        if (pid == null) {
////            pid = getOvalGlobalID();
////            super.setPersistentID( pid );
////        }
////
////        return pid;
//    }



    @Override
    public void setPersistentID(
                    final String pid
                    )
    {
        this._id = pid;
    }


    @Override
    public String getPersistentID()
    {
        return this._id;
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
