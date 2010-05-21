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




/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id: ExtendDefinition.java 635 2010-04-20 09:29:15Z akihito $
 */
public class ExtendDefinition
    extends CriteriaElement
{

    private String  _definitionReference;
    //{oval:DefinitionIDPattern, required}



    /**
     * Constructor.
     */
    public ExtendDefinition()
    {
    }


    /**
     * Constructor.
     */
    public ExtendDefinition(
                    final String defID
                    )
    {
        setDefinitionReference( defID );
    }



    public void setDefinitionReference(
                    final String definitionID
                    )
    {
        _definitionReference = definitionID;
    }


    public String getDefinitionReference()
    {
        return _definitionReference;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "ExtendDefinition[negate=" + isNegate()
                        + ", definition_ref=" + getDefinitionReference()
                        + ", comment=" + getComment()
                        + "]";
    }

}
// ExtendDefinition
