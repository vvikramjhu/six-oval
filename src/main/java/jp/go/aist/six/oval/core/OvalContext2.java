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

package jp.go.aist.six.oval.core;

import jp.go.aist.six.oval.core.repository.mongodb.MongoOvalRepository;
import jp.go.aist.six.oval.core.repository.web.HttpOvalRepositoryClient;
import jp.go.aist.six.oval.repository.OvalDatabase;
import jp.go.aist.six.oval.repository.OvalRepository;
import jp.go.aist.six.util.spring.Context;
import jp.go.aist.six.util.xml.XmlMapper;



/**
 * Application Context using Spring Framework.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class OvalContext2
    extends Context
{

//    /**
//     * Logger.
//     */
//    private static final Logger  _LOG_ = LoggerFactory.getLogger( OvalContext2.class );



    public static final OvalLocalContext  LOCAL = new OvalLocalContext();
    public static final OvalRemoteContext  REMOTE = new OvalRemoteContext();



    private static final String[]  _PROPERTY_BEANS_ = new String[] {
        "six-oval-default-properties",
        "six-oval-properties"
    };



    /**
     * Constructor.
     */
    protected OvalContext2()
    {
    }


    protected OvalContext2(
                    final String config_location
                    )
    {
        super( config_location, _PROPERTY_BEANS_ );
    }



    /**
     * Returns an XmlMapper instance which is dedicated to the OVAL Domain Model.
     *
     * @throws  OvalConfigurationException
     *  when it is NOT possible to create an XmlMapper instance.
     */
    public XmlMapper getXmlMapper()
    {
        XmlMapper  mapper = null;
        try {
            mapper = getBean( "oval-xml-mapper", XmlMapper.class );
                     //throws ConfigurationException/runtime
        } catch (Exception ex) {
                throw new OvalConfigurationException( ex );
        }

        return mapper;
    }



    ///////////////////////////////////////////////////////////////////////
    //  nested classes
    ///////////////////////////////////////////////////////////////////////


    /**
     */
    public static class OvalLocalContext
    extends OvalContext2
    {
        public static final String  CONTEXT_PATH
        = "jp/go/aist/six/oval/core/six-oval_context-local.xml";


        public OvalLocalContext()
        {
            super( CONTEXT_PATH );
        }



        public OvalRepository getRepository()
        {
            OvalRepository  repository = null;
            try {
                repository = getBean( MongoOvalRepository.class );
                //throws ConfigurationException/runtime
            } catch (Exception ex) {
                throw new OvalConfigurationException( ex );
            }

            return repository;
        }



        /**
         * Returns an OvalDatastore instance.
         *
         * @throws  OvalConfigurationException
         *  when it is NOT possible to create OvalDatastore instance.
         */
        public OvalDatabase getDatabase()
        {
            OvalDatabase  database = null;
            try {
                database = getBean( OvalDatabase.class );
                //throws ConfigurationException/runtime
            } catch (Exception ex) {
                throw new OvalConfigurationException( ex );
            }

            return database;
        }
    }
    //OvalServerContext



    /**
     */
    public static class OvalRemoteContext
    extends OvalContext2
    {
        public static final String  CONTEXT_PATH
        = "jp/go/aist/six/oval/core/six-oval_context-remote.xml";


        public OvalRemoteContext()
        {
            super( CONTEXT_PATH );
        }


        public OvalRepository getRepository()
        {
            OvalRepository  repository = null;
            try {
                repository = getBean( HttpOvalRepositoryClient.class );
                //throws ConfigurationException/runtime
            } catch (Exception ex) {
                throw new OvalConfigurationException( ex );
            }

            return repository;
        }
    }
    //

}
//

