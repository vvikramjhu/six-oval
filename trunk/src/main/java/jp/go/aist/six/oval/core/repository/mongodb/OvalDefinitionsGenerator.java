/*
 *  @product.title@
 *  Copyright (C) @product.copyright-year@
 *    @product.vendor@
 *    Registration Number: @product.registration-number@
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.go.aist.six.oval.core.repository.mongodb;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import jp.go.aist.six.oval.OvalException;
import jp.go.aist.six.oval.core.OvalContext;
import jp.go.aist.six.oval.core.model.EntityUtil;
import jp.go.aist.six.oval.model.common.GeneratorType;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.model.definitions.DefinitionsElement;
import jp.go.aist.six.oval.model.definitions.DefinitionsType;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.repository.OvalDatabase;
import jp.go.aist.six.oval.repository.OvalRepositoryException;
import jp.go.aist.six.oval.repository.QueryParams;
import jp.go.aist.six.util.IsoDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalDefinitionsGenerator
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ =
        LoggerFactory.getLogger( OvalDefinitionsGenerator.class );



    private static final String  _SCHEMA_VERSION_ = "5.10.1";
    private static final String  _PRODUCT_NAME_ = "cpe:/a:aist:six-oval:0.7.0";
    private static final String  _PRODUCT_VERSION_ = "0.7.0";

    private static final String  _XML_SCHEMA_LOCATION_ =
                    "http://oval.mitre.org/XMLSchema/oval-common-5 oval-common-schema.xsd"
                                    + " http://oval.mitre.org/XMLSchema/oval-definitions-5 oval-definitions-schema.xsd"
                                    + " http://oval.mitre.org/XMLSchema/oval-definitions-5#independent independent-definitions-schema.xsd"
                                    + " http://oval.mitre.org/XMLSchema/oval-definitions-5#linux linux-definitions-schema.xsd"
                                    + " http://oval.mitre.org/XMLSchema/oval-definitions-5#unix unix-definitions-schema.xsd"
                                    + " http://oval.mitre.org/XMLSchema/oval-definitions-5#windows windows-definitions-schema.xsd"
                                    ;



    private static OvalDatabase  _DATASTORE_;



    /**
     * Constructor.
     */
    public OvalDefinitionsGenerator()
    {
    }



    /**
     */
    private static OvalDatabase _getDatastore()
    {
        if (_DATASTORE_ == null) {
            _DATASTORE_ = OvalContext.getDatabase();
        }

        return _DATASTORE_;
    }



    /**
     */
    protected GeneratorType _newGenerator()
    {
        return _newGenerator( new Date() );
    }


    protected GeneratorType _newGenerator(
                    final Date timestamp
                    )
    {
        GeneratorType  generator = new GeneratorType();
        generator.setSchemaVersion(  _SCHEMA_VERSION_ );
        generator.setTimestamp(      IsoDate.format( timestamp ) );
        generator.setProductName(    _PRODUCT_NAME_ );
        generator.setProductVersion( _PRODUCT_VERSION_ );

        return generator;
    }



    /**
     * @throws  OvalException
     */
    public String generateByQuery(
                    final QueryParams params
                    )
    {
        _LOG_.debug( "params=" + params );

        List<DefinitionType>  def_list = _getDatastore().find( DefinitionType.class, params );
        if (def_list == null) {
            throw new OvalException( "no Definition found" );
        }

        DefinitionsType  defs = new DefinitionsType( def_list );

        OvalDefinitions  oval_defs = new OvalDefinitions();
        oval_defs.setDefinitions( defs );
        for (DefinitionType  def : def_list) {
            Collection<String>  ref_ids = EntityUtil.getElementRefId( def );
            _addElements( oval_defs, ref_ids );
        }

        oval_defs.setSchemaLocation( _XML_SCHEMA_LOCATION_ );
        oval_defs.setGenerator( _newGenerator() );
        String  id = _getDatastore().save( OvalDefinitions.class, oval_defs );
        return id;
    }



    /**
     * @throws  OvalException
     */
    private void _addElements(
                    final OvalDefinitions oval_defs,
                    final Collection<String> oval_ids
                    )
    {
        _LOG_.debug( "OVAL IDs: " + String.valueOf( oval_ids ) );
//        Collection<DefinitionsElement>  added_elements = new HashSet<DefinitionsElement>();
        for (String  oval_id : oval_ids) {
            DefinitionsElement  element = _addElement( oval_defs, oval_id );
            if (element != null) {
//                added_elements.add( element );
                Collection<String>  ref_ids = EntityUtil.getElementRefId( element );
                _addElements( oval_defs, ref_ids );
            }
        }

//        if (added_elements.size() > 0) {
//            Collection<String>  added_ids = new HashSet<String>();
//            for (DefinitionsElement  e : added_elements) {
//                added_ids.add( e.getOvalID() );
//            }
//
//            _addElements( oval_defs, added_ids );
//        }
    }


    /**
     * @throws  OvalException
     */
    private DefinitionsElement _addElement(
                    final OvalDefinitions oval_defs,
                    final String oval_id
                    )
    {
        _LOG_.debug( "OVAL ID: " + oval_id );
        boolean  contained = EntityUtil.containsElement( oval_defs, oval_id );
        if(contained) {
            _LOG_.debug( "element already contained: " + oval_id );
            return null;
        }

        Class<? extends DefinitionsElement>  java_type = EntityUtil.javaTypeOf( oval_id );
//        Class<? extends DefinitionsElement>  java_type = EntityUtil.objectTypeOf( oval_id );
        DefinitionsElement  element = _getDatastore().findById( java_type, oval_id );
        if (element == null) {
            throw new OvalRepositoryException( "no such definitions element: " + oval_id );
        }
        EntityUtil.addElement( oval_defs, element );
        return element;
    }

}
//
