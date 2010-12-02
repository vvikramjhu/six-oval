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

package jp.go.aist.six.oval.service;

import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.definitions.State;
import jp.go.aist.six.oval.model.definitions.SystemObject;
import jp.go.aist.six.oval.model.definitions.Test;
import jp.go.aist.six.oval.model.definitions.Variable;
import jp.go.aist.six.oval.model.results.OvalResults;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import jp.go.aist.six.util.persist.Persistable;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public enum OvalObjectType
{
    OVAL_DEFINITION( "oval_definitions", OvalDefinitions.class ),
    DEFINITION( "definition", Definition.class ),
    TEST( "test", Test.class ),
    SYSTEM_OBJECT( "object", SystemObject.class ),
    STATE( "state", State.class ),
    VARIABLE( "variable", Variable.class ),
    OVAL_SC( "oval_sc", OvalSystemCharacteristics.class ),
    OVAL_RESULTS( "oval_results", OvalResults.class );


    public static OvalObjectType fromValue(
                    final String value
                    )
    {
        for (OvalObjectType  e : OvalObjectType.values()) {
            if (e._value.equals( value )) {
                return e;
            }
        }

        throw new IllegalArgumentException( value );
    }



    private final String  _value;
    private final Class<? extends Persistable<?>>  _type;


    /**
     * Constructor.
     */
    OvalObjectType(
                    final String value,
                    final Class<? extends Persistable<?>> type
                  )
    {
        _value = value;
        _type = type;
    }



    public Class<? extends Persistable<?>> type()
    {
        return _type;
    }



    @Override
    public String toString()
    {
        return _value;
    }

}
// OvalObjectType
