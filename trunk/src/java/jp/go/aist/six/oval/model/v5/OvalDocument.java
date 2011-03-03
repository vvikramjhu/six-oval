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
import jp.go.aist.six.oval.model.AbstractOvalObject;



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

    private static final String  _COMMON_SCHEMA_LOCATION_ =
        "http://oval.mitre.org/XMLSchema/oval-common-5 oval-common-schema.xsd"
        ;


    public static final String  DEFINITIONS_SCHEMA_LOCATION =
        _COMMON_SCHEMA_LOCATION_
        + " http://oval.mitre.org/XMLSchema/oval-definitions-5 oval-definitions-schema.xsd"
        + " http://oval.mitre.org/XMLSchema/oval-definitions-5#independent independent-definitions-schema.xsd"
        + " http://oval.mitre.org/XMLSchema/oval-definitions-5#linux linux-definitions-schema.xsd"
        + " http://oval.mitre.org/XMLSchema/oval-definitions-5#unix unix-definitions-schema.xsd"
        + " http://oval.mitre.org/XMLSchema/oval-definitions-5#windows windows-definitions-schema.xsd"
        ;


    private static final String  _SC_SPECIFIC_SCHEMA_LOCATION_ =
        " http://oval.mitre.org/XMLSchema/oval-system-characteristics-5 oval-system-characteristics-schema.xsd"
        + " http://oval.mitre.org/XMLSchema/oval-system-characteristics-5#independent independent-system-characteristics-schema.xsd"
        + " http://oval.mitre.org/XMLSchema/oval-system-characteristics-5#linux linux-system-characteristics-schema.xsd"
        + " http://oval.mitre.org/XMLSchema/oval-system-characteristics-5#unix unix-system-characteristics-schema.xsd"
        + " http://oval.mitre.org/XMLSchema/oval-system-characteristics-5#windows windows-system-characteristics-schema.xsd"
        ;

    public static final String  SC_SCHEMA_LOCATION =
        _COMMON_SCHEMA_LOCATION_
        + _SC_SPECIFIC_SCHEMA_LOCATION_
        ;


    public static final String  RESULTS_SCHEMA_LOCATION =
        DEFINITIONS_SCHEMA_LOCATION
        + _SC_SPECIFIC_SCHEMA_LOCATION_
        + " http://oval.mitre.org/XMLSchema/oval-results-5 oval-results-schema.xsd"
        ;


//    public static final String  SCHEMA_LOCATION
//    = "http://oval.mitre.org/XMLSchema/oval-common-5 oval-common-schema.xsd http://oval.mitre.org/XMLSchema/oval-system-characteristics-5 oval-system-characteristics-schema.xsd http://oval.mitre.org/XMLSchema/oval-definitions-5 oval-definitions-schema.xsd http://oval.mitre.org/XMLSchema/oval-results-5 oval-results-schema.xsd http://oval.mitre.org/XMLSchema/oval-definitions-5#windows windows-definitions-schema.xsd http://oval.mitre.org/XMLSchema/oval-system-characteristics-5#windows windows-system-characteristics-schema.xsd";



    private String  _schemaLocation;



    /**
     * Constructor.
     */
    public OvalDocument()
    {
    }



    /**
     */
    public void getSchemaLocation(
                    final String location
                    )
    {
        _schemaLocation = location;
    }


    public String getSchemaLocation()
    {
        return (_schemaLocation == null ? RESULTS_SCHEMA_LOCATION : _schemaLocation);
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
