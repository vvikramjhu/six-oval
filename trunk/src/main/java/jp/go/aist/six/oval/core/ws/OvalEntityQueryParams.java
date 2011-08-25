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

package jp.go.aist.six.oval.core.ws;

import java.util.HashMap;
import java.util.Map;





/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalEntityQueryParams
    extends CommonQueryParams
{

    public static class Key
    extends CommonQueryParams.Key
    {
        public static final String  ID                  = "id";
        public static final String  VERSION             = "version";

        public static final String  SCHEMA_VERSION      = "schema_version";
        public static final String  PLATFORM            = "platform";
        public static final String  COMPONENT           = "component";
    }
    // Key



    protected static Map<String, String> _createFieldMapping()
    {
        Map<String, String>  mapping = new HashMap<String, String>();

        mapping.put( Key.ID,                "oval_id" );
        mapping.put( Key.VERSION,           "oval_version" );

        mapping.put( Key.SCHEMA_VERSION,    "_oval_generator.schema_version" );
        mapping.put( Key.PLATFORM,          "_oval_platform_type" );
        mapping.put( Key.COMPONENT,         "_oval_component_type" );

        return mapping;
    }


    private static final Map<String, String>  _FIELDS_ = _createFieldMapping();


    @Override
    protected Map<String, String> _fieldMapping()
    {
        return _FIELDS_;
    }




    /**
     * The default sorting order.
     */
    public static final String  DEFAULT_ORDER = "oval_id";



    /**
     * Constructor.
     */
    public OvalEntityQueryParams()
    {
        setOrder( DEFAULT_ORDER );
    }



    /**
     */
    public void setId(
                    final String id
    )
    {
        set( Key.ID, id );
    }


    public String getId()
    {
        return get( Key.ID );
    }



    /**
     */
    public void setVersion(
                    final String version
    )
    {
        set( Key.VERSION, version );
    }


    public String getVersion()
    {
        return get( Key.VERSION );
    }



    /**
     */
    public void setSchema_version(
                    final String schema_version
    )
    {
        set( Key.SCHEMA_VERSION, schema_version );
    }


    public String getSchema_version()
    {
        return get( Key.SCHEMA_VERSION );
    }



    /**
     */
    public void setPlatform(
                    final String platform
    )
    {
        set( Key.PLATFORM, platform );
    }


    public String getPlatform()
    {
        return get( Key.PLATFORM );
    }



    /**
     */
    public void setComponent(
                    final String component
    )
    {
        set( Key.COMPONENT, component );
    }


    public String getComponent()
    {
        return get( Key.COMPONENT );
    }

}
// OvalEntityQueryParams

