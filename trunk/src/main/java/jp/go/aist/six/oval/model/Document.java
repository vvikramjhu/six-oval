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

import java.util.UUID;
import jp.go.aist.six.util.persist.Persistable;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.PrePersist;



/**
 * The abstract superclass of the OVAL documents.
 *
 * <p>
 * IMPLEMENTATION NOTE:
 * This implementation of the schemaLocation property is a dirty hack.
 * Because the Spring OXM support for Castor does NOT provide the property.
 * </p>
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class Document
    implements OvalObject, Persistable<String>
{

    //MongoDB
    @Id
    private String  _id;


    private String  schemaLocation;



    /**
     * Constructor.
     */
    public Document()
    {
    }



    /**
     */
    public void setSchemaLocation(
                    final String schemaLocation
                    )
    {
        this.schemaLocation = schemaLocation;
    }


    public String getSchemaLocation()
    {
        return schemaLocation;
//        return (_schemaLocation == null ? RESULTS_SCHEMA_LOCATION : _schemaLocation);
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
            pid = UUID.randomUUID().toString();
            setPersistentID( pid );
        }
    }



    //**************************************************************
    //  Persistable
    //**************************************************************

//    @Override
//    public synchronized String getPersistentID()
//    {
//        String  pid = super.getPersistentID();
//        if (pid == null) {
//            pid = UUID.randomUUID().toString();
//            setPersistentID( pid );
//        }
//
//        return pid;
//    }


    @Override
    public void setPersistentID(
                    final String pid
                    )
    {
        _id = pid;
    }


    @Override
    public String getPersistentID()
    {
        return _id;
    }

}
//Document
