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
public abstract class OvalContext
    extends Context
{

//    /**
//     * Logger.
//     */
//    private static final Logger  _LOG_ = LoggerFactory.getLogger( OvalContext2.class );



    public static final OvalBasicContext  BASIC = new OvalBasicContext();
    public static final OvalServerContext  SERVER = new OvalServerContext();



    /**
     * Returns the default context.
     *
     * @return
     */
    public static OvalBasicContext getInstance()
    {
        return BASIC;
    }


    /**
     * Returns the default context.
     *
     * @return
     */
    public static OvalServerContext getServerInstance()
    {
        return SERVER;
    }



    private static final String[]  _PROPERTY_BEANS_ = new String[] {
        "six-oval-default-properties",
        "six-oval-properties"
    };



    /**
     * Constructor.
     */
    protected OvalContext()
    {
    }


    protected OvalContext(
                    final String config_location
                    )
    {
        super( config_location, _PROPERTY_BEANS_ );
    }



    /**
     * Returns an XmlMapper instance which is dedicated to the OVAL Domain Model.
     *
     * @throws  OvalConfigurationException
     *  when it is NOT possible to create an instance.
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



    /**
     * Returns an OvalRepository instance.
     *
     * @throws  OvalConfigurationException
     *  when it is NOT possible to create an instance.
     */
    public abstract OvalRepository getRepository();




    ///////////////////////////////////////////////////////////////////////
    //  nested classes
    ///////////////////////////////////////////////////////////////////////

    /**
     */
    public static class OvalBasicContext
    extends OvalContext
    {
        public static final String  CONTEXT_PATH
        = "jp/go/aist/six/oval/core/six-oval_context-basic.xml";


        public OvalBasicContext()
        {
            super( CONTEXT_PATH );
        }


        @Override
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



    /**
     */
    public static class OvalServerContext
    extends OvalContext
    {
        public static final String  CONTEXT_PATH
        = "jp/go/aist/six/oval/core/six-oval_context-server.xml";


        public OvalServerContext()
        {
            super( CONTEXT_PATH );
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



        @Override
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

    }
    //

}
//

