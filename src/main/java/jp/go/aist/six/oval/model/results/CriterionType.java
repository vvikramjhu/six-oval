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
 * The CriterionResult identifies a specific test that is included
 * in the definition's criteria.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class CriterionType
    extends CriteriaResultLeafElement
{

    private String  test_ref;
    //{oval:TestIDPattern, required}



    /**
     * Constructor.
     */
    public CriterionType()
    {
    }


    public CriterionType(
                    final String testID,
                    final int version
                    )
    {
        super( testID, version );
    }


    public CriterionType(
                    final String id,
                    final int version,
                    final ResultEnumeration result
                    )
    {
        super( id, version, result );
    }



    /**
     */
    public void setTestRef(
                    final String test_ref
                    )
    {
        _setEntityRef( test_ref );
    }


    public String getTestRef()
    {
        return _getEntityRef();
    }



    //**************************************************************
    //  CriteriaResultElement
    //**************************************************************

    @Override
    protected void _setEntityRef(
                    final String test_ref
    )
    {
        this.test_ref = test_ref;
    }


    @Override
    protected String _getEntityRef()
    {
        return this.test_ref;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "criterion[test_ref=" + getTestRef()
                        + ", " + super.toString()
                        + "]";
    }

}
// CriterionType
