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

package jp.go.aist.six.oval.model.definition;

import java.io.Serializable;
import java.util.HashMap;




/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public final class DefinitionClass
    implements Serializable
{

    private static final String  _COMPLIANCE_     = "compliance";
    private static final String  _INVENTORY_      = "inventory";
    private static final String  _MISCELLANEOUS_  = "miscellaneous";
    private static final String  _PATCH_          = "patch";
    private static final String  _VULNERABILITY_  = "vulnerability";


    public static final DefinitionClass  COMPLIANCE     = new DefinitionClass( _COMPLIANCE_ );
    public static final DefinitionClass  INVENTORY      = new DefinitionClass( _INVENTORY_ );
    public static final DefinitionClass  MISCELLANEOUS  = new DefinitionClass( _MISCELLANEOUS_ );
    public static final DefinitionClass  PATCH          = new DefinitionClass( _PATCH_ );
    public static final DefinitionClass  VULNERABILITY  = new DefinitionClass( _VULNERABILITY_ );



    private static HashMap<String, DefinitionClass> _INIT_()
    {
        HashMap<String, DefinitionClass>  map = new HashMap<String, DefinitionClass>();
        map.put( _COMPLIANCE_,     COMPLIANCE     );
        map.put( _INVENTORY_,      INVENTORY      );
        map.put( _MISCELLANEOUS_,  MISCELLANEOUS  );
        map.put( _PATCH_,          PATCH          );
        map.put( _VULNERABILITY_,  VULNERABILITY  );
        return map;
    }

    private static final HashMap<String, DefinitionClass>  _INSTANCES_ = _INIT_();




    /**
     */
    public static DefinitionClass valueOf( final String name )
    {
        DefinitionClass  flag = null;
        if (name != null) {
            flag = _INSTANCES_.get( name );
        }

        if (flag == null) {
            throw new IllegalArgumentException( "invalid definition class: " + name );
        }

        return flag;
    }



    private String  _name = null;



    /**
     */
    private DefinitionClass( final String name )
    {
        _name = name;
    }



    /**
     */
    public String getName()
    {
        return _name;
    }



    ////////////////////////////////////////////////////////////////
    //  java.lang.Object
    ////////////////////////////////////////////////////////////////

    @Override
    public String toString()
    {
        return getName();
    }

}
// DefinitionClass
