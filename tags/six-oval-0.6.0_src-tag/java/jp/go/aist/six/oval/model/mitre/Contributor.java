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

package jp.go.aist.six.oval.model.mitre;

import jp.go.aist.six.util.castor.AbstractPersistable;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class Contributor
    extends AbstractPersistable
{

    private String  _name;
    //{xsd:string?}


    private String  _organization;
    //{xsd:string}



    /**
     * Constructor.
     */
    public Contributor()
    {
    }


    /**
     * Constructor.
     */
    public Contributor(
                    final String name,
                    final String organization
                    )
    {
        setName( name );
        setOrganization( organization );
    }



    /**
     */
    public void setName(
                    final String name
                    )
    {
        _name = name;
    }


    public String getName()
    {
        return _name;
    }



    /**
     */
    public void setOrganization(
                    final String organization
                    )
    {
        _organization = organization;
    }


    public String getOrganization()
    {
        return _organization;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "contributor[organization=" + getOrganization()
                        + ", name=" + getName()
                        + "]";
    }

}
// Contributor
