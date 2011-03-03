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

import java.util.UUID;



/**
 * A marker for all the OVAL Documents.
 *
 * <p>
 * This implementation of the schemaLocation property is a dirty hack.
 * Because the Spring OXM support for Castor does NOT provide the property.
 * </p>
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class OvalDocument
    extends AbstractOvalObject
{

    private String  _schemaLocation;



    /**
     * Constructor.
     */
    public OvalDocument()
    {
    }



    /**
     */
    public void setSchemaLocation(
                    final String location
                    )
    {
        _schemaLocation = location;
    }


    public String getSchemaLocation()
    {
        return _schemaLocation;
//        return (_schemaLocation == null ? RESULTS_SCHEMA_LOCATION : _schemaLocation);
    }



    //**************************************************************
    //  Persistable
    //**************************************************************

    @Override
    public synchronized String getPersistentID()
    {
        String  pid = super.getPersistentID();
        if (pid == null) {
            pid = UUID.randomUUID().toString();
            setPersistentID( pid );
        }

        return pid;
    }

}
// OvalDocument
