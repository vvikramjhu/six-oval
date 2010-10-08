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



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class ExtendDefinitionResult
    extends CriteriaResultLeafElement
{

    /**
     * Constructor.
     */
    public ExtendDefinitionResult()
    {
    }


    /**
     * Constructor.
     */
    public ExtendDefinitionResult(
                    final String testID,
                    final int version
                    )
    {
        super( testID, version );
    }


    /**
     * Constructor.
     */
    public ExtendDefinitionResult(
                    final String id,
                    final int version,
                    final Result result
                    )
    {
        super( id, version, result );
    }



    public void setDefinitionRef(
                    final String definitionID
                    )
    {
        _setEntityRef( definitionID );
    }


    public String getDefinitionRef()
    {
        return _getEntityRef();
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "Criterion[definition_ref=" + getDefinitionRef()
                        + ", " + super.toString()
                        + "]";
    }

}
// ExtendDefinitionResult
