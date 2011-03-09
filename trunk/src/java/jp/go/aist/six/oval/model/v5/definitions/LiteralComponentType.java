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

package jp.go.aist.six.oval.model.v5.definitions;

import jp.go.aist.six.oval.model.v5.common.DatatypeEnumeration;



/**
 * The LiteralComponent type defines a literal value to be used as a component.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class LiteralComponentType
    extends ComponentGroup
{

    private String  _content;
    //{xsd:anySimpleType}


    public static final DatatypeEnumeration  DEFAULT_DATATYPE = DatatypeEnumeration.STRING;
    private DatatypeEnumeration  _datatype;
    //{optional, defualt="string"}



    /**
     * Constructor.
     */
    public LiteralComponentType()
    {
    }



    /**
     */
    public void setContent(
                    final String content
                    )
    {
        _content = content;
    }


    public String getContent()
    {
        return _content;
    }



    /**
     */
    public void setDatatype(
                    final DatatypeEnumeration datatype
                    )
    {
        _datatype = datatype;
    }


    public DatatypeEnumeration getDatatype()
    {
        return _datatype;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "[datatype=" + getDatatype()
                        + ", " + getContent()
                        + "]";
    }

}
// LiteralComponentType
