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

package jp.go.aist.six.oval.model.results;

import jp.go.aist.six.oval.model.ElementRef;
import jp.go.aist.six.oval.model.ElementType;



/**
 * The ExtendDefinitionResult identifies a specific definition
 * that has been extended by the criteria.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class ExtendDefinitionType
    extends CriteriaResultLeafElement
    implements ElementRef
{

    private String  definition_ref;
    //{oval:DefinitionIDPattern, required}



    /**
     * Constructor.
     */
    public ExtendDefinitionType()
    {
    }


    public ExtendDefinitionType(
                    final String testID,
                    final int version
                    )
    {
        super( testID, version );
    }


    public ExtendDefinitionType(
                    final String id,
                    final int version,
                    final ResultEnumeration result
                    )
    {
        super( id, version, result );
    }



    /**
     */
    public void setDefinitionRef(
                    final String definition_ref
                    )
    {
        _setEntityRef( definition_ref );
    }


    public String getDefinitionRef()
    {
        return _getEntityRef();
    }



    //**************************************************************
    //  CriteriaResultElement
    //**************************************************************

    @Override
    protected void _setEntityRef(
                    final String definition_ref
    )
    {
        this.definition_ref = definition_ref;
    }


    @Override
    protected String _getEntityRef()
    {
        return definition_ref;
    }



    //*********************************************************************
    //  ElementRef
    //*********************************************************************

    @Override
    public String ovalGetRefId()
    {
        return getDefinitionRef();
    }



    @Override
    public ElementType ovalGetRefType()
    {
        return ElementType.DEFINITION;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "extend_definition[definition_ref=" + getDefinitionRef()
                        + ", " + super.toString()
                        + "]";
    }

}
// ExtendDefinitionType
