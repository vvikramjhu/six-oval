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

package jp.go.aist.six.oval.model.definitions;

import jp.go.aist.six.oval.model.common.Datatype;



/**
 * The LiteralComponent type defines a literal value to be used as a component.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class LiteralComponent
    extends ComponentGroup
{

    private String  _data;
    //{xsd:anySimpleType}


    public static final Datatype  DEFAULT_DATATYPE = Datatype.STRING;
    private Datatype  _datatype;
    //{optional, defualt="string"}



    /**
     * Constructor.
     */
    public LiteralComponent()
    {
    }


    /**
     * Constructor.
     */
    public LiteralComponent(
                    final String data
                    )
    {
        this( data, DEFAULT_DATATYPE );
    }


    /**
     * Constructor.
     */
    public LiteralComponent(
                    final String data,
                    final Datatype datatype
                    )
    {
        setData( data );
        setDatatype( datatype );
    }



    /**
     */
    public void setData(
                    final String data
                    )
    {
        _data = data;
    }


    public String getData()
    {
        return _data;
    }



    /**
     */
    public void setDatatype(
                    final Datatype datatype
                    )
    {
        _datatype = datatype;
    }


    public Datatype getDatatype()
    {
        return (_datatype == null ? DEFAULT_DATATYPE : _datatype);
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "literal_component[datatype=" + getDatatype()
                        + ", " + getData()
                        + "]";
    }

}
// LiteralComponent
