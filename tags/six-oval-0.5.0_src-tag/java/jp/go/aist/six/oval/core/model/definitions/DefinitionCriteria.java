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

package jp.go.aist.six.oval.core.model.definitions;

import jp.go.aist.six.oval.model.OvalEntity;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class DefinitionCriteria
    extends OvalEntity //, Noted
{

    private String  _criteriaXml;



    /**
     * Constructor.
     */
    public DefinitionCriteria()
    {
    }


    /**
     * Constructor.
     */
    public DefinitionCriteria(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    /**
     * Constructor.
     */
    public DefinitionCriteria(
                    final String id,
                    final int version,
                    final String criteriaXml
                    )
    {
        super( id, version );
        setCriteriaXml( criteriaXml );
    }



    /**
     */
    public void setCriteriaXml(
                    final String criteriaXml
                    )
    {
        _criteriaXml = criteriaXml;
    }


    /**
     */
    public String getCriteriaXml()
    {
        return _criteriaXml;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "Criteria[" + getCriteriaXml() + "]";
    }

}
// DefinitionCriteria
