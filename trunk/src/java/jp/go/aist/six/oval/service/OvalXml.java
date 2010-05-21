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

package jp.go.aist.six.oval.service;

import jp.go.aist.six.util.xml.OxmException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id: OvalXml.java 434 2010-03-23 05:01:24Z akihito $
 */
public interface OvalXml
{

    /**
     * Marshals the given object as XML to the specified output.
     *
     * @param   obj
     *  the object to marshal.
     * @param   stream
     *  the result to marshal to.
     */
    public void marshal(
                    Object obj,
                    OutputStream stream
                    )
    throws OxmException;



    /**
     * Marshals the given object as XML to the specified output.
     *
     * @param   obj
     *  the object to marshal.
     * @param   writer
     *  the result to marshal to.
     */
    public void marshal(
                    Object obj,
                    Writer writer
                    )
    throws OxmException;



    /**
     * Marshals the given object as XML and returns it as a string.
     *
     * @param   obj
     *  the object to marshal.
     * @return
     *  the marshalled XML as a string.
     */
    public String marshalToString(
                    Object obj
                    )
    throws OxmException;



//    /**
//     * Unmarshals the given XML source into an object.
//     *
//     * @param   source
//     *  the source to unmarshal from.
//     * @return
//     *  the object.
//     */
//    public Object unmarshal(
//                    Source source
//                    )
//    throws OxmException;



    /**
     * Unmarshals the given XML source into an object.
     *
     * @param   stream
     *  the source to unmarshal from.
     * @return
     *  the object.
     */
    public Object unmarshal(
                    InputStream stream
                    )
    throws OxmException;



    /**
     * Unmarshals the given XML source into an object.
     *
     * @param   reader
     *  the source to unmarshal from.
     * @return
     *  the object.
     */
    public Object unmarshal(
                    Reader reader
                    )
    throws OxmException;



    /**
     * Unmarshals the given XML string into an object.
     *
     * @param   xml
     *  the source XML string to unmarshal from.
     * @return
     *  the object.
     */
    public Object unmarshalFromString(
                    String xml
                    )
    throws OxmException;

}
// OvalXml

/* vim:set tabstop=4:set expandtab:set shiftwidth=4: */

