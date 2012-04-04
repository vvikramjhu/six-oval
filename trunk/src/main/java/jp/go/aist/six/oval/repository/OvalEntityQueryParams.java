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

package jp.go.aist.six.oval.repository;

import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.OvalComponentType;
import jp.go.aist.six.oval.model.definitions.DefinitionsElement;



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

        public static final String  TYPE                = "type";
        //DefinitionsElement.Type {definition, test, object, state, variable}

        public static final String  SCHEMA_VERSION      = "schemaVersion";

        public static final String  FAMILY              = "family";
        //Family {linux, unix, windows, ...}

        public static final String  COMPONENT           = "component";
        //Component {file, rpminfo, registry, ...}

        public static final String  REFERER             = "referer";

        public static final String  COMMENT             = "comment";
    }
    // Key



//    /**
//     * The default sorting order.
//     */
//    public static final String  DEFAULT_ORDER = Key.ID;



    /**
     * Constructor.
     */
    public OvalEntityQueryParams()
    {
//        setOrder( DEFAULT_ORDER );

        //NOTE: Since the type of the OVAL-IDs is String,
        //      this ordering specifies the lexicographical sorting,
        //      e.g. def:99 is bigger than def:111.
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
    public void setType(
                    final String type
                    )
    {
        if (type != null) {
            DefinitionsElement.Type.fromValue( type );
//            OvalEntityType.valueOf( type );
        }

        set( Key.TYPE, type );
    }


    public String getType()
    {
        return get( Key.TYPE );
    }



    /**
     */
    public void setSchemaVersion(
                    final String schema_version
    )
    {
        set( Key.SCHEMA_VERSION, schema_version );
    }


    public String getSchemaVersion()
    {
        return get( Key.SCHEMA_VERSION );
    }



    /**
     */
    public void setFamily(
                    final String family
                    )
    {
        if (family != null) {
            Family.valueOf( family );
        }

        set( Key.FAMILY, family );
    }


    public String getFamily()
    {
        return get( Key.FAMILY );
    }



    /**
     */
    public void setComponent(
                    final String component
                    )
    {
        if (component != null) {
            OvalComponentType.valueOf( component );
        }

        set( Key.COMPONENT, component );
    }


    public String getComponent()
    {
        return get( Key.COMPONENT );
    }



    /**
     */
    public void setReferer(
                    final String referer
    )
    {
        set( Key.REFERER, referer );
    }


    public String getReferer()
    {
        return get( Key.REFERER );
    }



    /**
     */
    public void setComment(
                    final String comment
    )
    {
        set( Key.COMMENT, comment );
    }


    public String getComment()
    {
        return get( Key.COMMENT );
    }

}
//

