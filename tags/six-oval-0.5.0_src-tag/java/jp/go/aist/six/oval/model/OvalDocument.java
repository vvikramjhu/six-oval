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

package jp.go.aist.six.oval.model;

import jp.go.aist.six.util.castor.AbstractPersistable;



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
 */
public abstract class OvalDocument
    extends AbstractPersistable
{

    public static final String  SCHEMA_LOCATION
        = "http://oval.mitre.org/XMLSchema/oval-common-5 oval-common-schema.xsd http://oval.mitre.org/XMLSchema/oval-system-characteristics-5 oval-system-characteristics-schema.xsd http://oval.mitre.org/XMLSchema/oval-definitions-5 oval-definitions-schema.xsd http://oval.mitre.org/XMLSchema/oval-results-5 oval-results-schema.xsd http://oval.mitre.org/XMLSchema/oval-definitions-5#windows windows-definitions-schema.xsd http://oval.mitre.org/XMLSchema/oval-system-characteristics-5#windows windows-system-characteristics-schema.xsd";


    private String  _schemaLocation;



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
        return (_schemaLocation == null ? SCHEMA_LOCATION : _schemaLocation);
    }

}
// OvalDocument
