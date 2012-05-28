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

package jp.go.aist.six.oval.core.xml;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import jp.go.aist.six.util.castor.CastorXmlMapper;
import jp.go.aist.six.util.xml.OxmException;
import jp.go.aist.six.util.xml.XmlException;
import jp.go.aist.six.util.xml.XmlTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalTransformXmlMapper
    extends CastorXmlMapper
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ = LoggerFactory.getLogger( OvalTransformXmlMapper.class );


    
    private XmlTransformer  _transformer;
    
    

    /**
     * Constructor.
     */
    public OvalTransformXmlMapper()
    {
        _LOG_.debug( "instantiated" );
    }

    
    
    /**
     */
    public void setTransformer( 
                    final XmlTransformer transformer 
                    )
    {
        _transformer = transformer;
    }

    
    
    private String _simpleMarshalToString(
                    final Object obj
                    )
    throws XmlException
    {
        StringWriter  writer = new StringWriter();
        super.marshal( obj, new StreamResult( writer ) );

        return writer.toString();
    }




    //**************************************************************
    //  XmlMapper
    //**************************************************************

    public void marshal(
                    final Object obj,
                    final Result result
                    )
    throws OxmException
    {
        if (_transformer == null) {
            super.marshal( obj, result );
        } else {
            try {
                String  xml = _simpleMarshalToString( obj );
                Source  source = new StreamSource( new StringReader( xml ) );
                _transformer.transform( source, result );
            } catch (XmlException ex) {
                throw new OxmException( ex );
            }
        }
    }



    @Override
    public void marshal(
                    final Object obj,
                    final OutputStream stream
                    )
    throws OxmException
    {
        if (_transformer == null) {
            super.marshal( obj, stream );
        } else {
            try {
                String  xml = _simpleMarshalToString( obj );
                Source  source = new StreamSource( new StringReader( xml ) );
                Result  result = new StreamResult( stream );
                _transformer.transform( source, result );
            } catch (XmlException ex) {
                throw new OxmException( ex );
            }
        }
    }



    @Override
    public void marshal(
                    final Object obj,
                    final Writer writer
                    )
    throws OxmException
    {
        if (_transformer == null) {
            super.marshal( obj, writer );
        } else {
            try {
                String  xml = _simpleMarshalToString( obj );
                Source  source = new StreamSource( new StringReader( xml ) );
                Result  result = new StreamResult( writer );
                _transformer.transform( source, result );
            } catch (XmlException ex) {
                throw new OxmException( ex );
            }
        }
    }



    @Override
    public String marshalToString(
                    final Object obj
                    )
    throws OxmException
    {
        StringWriter  writer = new StringWriter();
        marshal( obj, writer );
        String  xml = writer.toString();

        return xml;
    }



    @Override
    public Object unmarshal(
                    final InputStream stream
                    )
    throws OxmException
    {
        Object  obj = null;

        if (_transformer == null) {
            obj = super.unmarshal( stream );
        } else {
            StringWriter  writer = new StringWriter();  
            Result  result = new StreamResult( writer );
            try {
                _transformer.transform( new StreamSource( stream ), result );
            } catch (XmlException ex) {
                throw new OxmException( ex );
            }

            String  xml = writer.toString();
//            _LOG_.debug( "transformed XML: \n" + xml );
            obj = super.unmarshal( new StringReader( xml ) );
        }

        return obj;
    }



    @Override
    public Object unmarshal(
                    final Reader reader
                    )
    throws OxmException
    {
        Object  obj = null;
        if (_transformer == null) {
            obj = super.unmarshal( reader );
        } else {
            StringWriter  writer = new StringWriter();  
            Result  result = new StreamResult( writer );
            try {
                _transformer.transform( new StreamSource( reader ), result );
            } catch (XmlException ex) {
                throw new OxmException( ex );
            }
            
            obj = super.unmarshal( new StringReader( writer.toString() ) );
        }

        return obj;
    }



    @Override
    public Object unmarshalFromString(
                    final String xml
                    )
    throws OxmException
    {
        Reader  reader = new BufferedReader( new StringReader( xml ) );
        Object  obj = unmarshal( reader );
                      //@throws OxmException

        return obj;
    }

}
//OvalXmlMapper

