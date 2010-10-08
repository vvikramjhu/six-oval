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

package jp.go.aist.six.oval.model.definitions;



/**
 * The ExtendDefinition allows existing definitions
 * to be extended by another definition.
 *
 * <p>Properties:</p>
 * <ul>
 *   <li>definition_ref (required)</li>
 *   <li>negate (optional -- default='false')</li>
 *   <li>comment (optional)</li>
 * </ul>
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class ExtendDefinition
    extends CriteriaElement
{

    private String  _definitionRef;
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
                    final String definitionID
                    )
    {
        this( definitionID, null );
    }


    /**
     * Constructor.
     */
    public ExtendDefinition(
                    final String definitionID,
                    final String comment
                    )
    {
        super( comment );
        setDefinitionRef( definitionID );
    }




    public void setDefinitionRef(
                    final String definitionID
                    )
    {
        _definitionRef = definitionID;
    }


    public String getDefinitionRef()
    {
        return _definitionRef;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = super.hashCode();

        String  defRef = getDefinitionRef();
        result = prime * result + ((defRef == null) ? 0 : defRef.hashCode());

        return result;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ExtendDefinition)) {
            return false;
        }

        if (super.equals( obj )) {
            ExtendDefinition  other = (ExtendDefinition)obj;
            String  other_defRef = other.getDefinitionRef();
            String   this_defRef =  this.getDefinitionRef();
            if (this_defRef == other_defRef
                            ||  (this_defRef != null
                                            &&  this_defRef.equals( other_defRef ))) {
                return true;
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "extend_definition[negate=" + isNegate()
                        + ", definition_ref=" + getDefinitionRef()
                        + ", comment=" + getComment()
                        + "]";
    }

}
// ExtendDefinition
