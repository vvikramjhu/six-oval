/**
 * SIX OVAL - http://code.google.com/p/six-oval/
 * Copyright (C) 2010
 *   National Institute of Advanced Industrial Science and Technology (AIST)
 *   Registration Number: H22PRO-1124
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

import jp.go.aist.six.oval.core.repository.morphia.OvalRepositoryImpl;
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
//    private static final Logger  _LOG_ = LoggerFactory.getLogger( OvalContext.class );



    private static OvalBasicContext  _BASIC_;
    private static OvalServerContext  _SERVER_;



    /**
     * Returns the default context for client applications.
     *
     * @return
     *  the default context.
     */
    public static synchronized OvalContext getInstance()
    {
        if (_BASIC_ == null) {
            _BASIC_ = new OvalBasicContext();
        }

        return _BASIC_;
    }


    /**
     * Returns the server context which is configured for server applications.
     * This context contains OVAL database, repository, and XML mapper.
     *
     * @return
     *  the server context.
     */
    public static synchronized OvalServerContext getServerInstance()
    {
        if (_SERVER_ == null) {
            _SERVER_ = new OvalServerContext();
        }

        return _SERVER_;
    }



//    private static final String[]  _PROPERTY_BEANS_ = new String[] {
//        "six-oval-default-properties",
//        "six-oval-properties"
//    };



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
        super( config_location, new String[] {
                        "six-oval-default-properties",
                        "six-oval-properties"
                    } );

        //The following code does not work.
        //The second parameter is passed to the super class as a null.
//        super( config_location, _PROPERTY_BEANS_ );
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
                repository = getBean( OvalRepositoryImpl.class );
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

