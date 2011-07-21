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

package jp.go.aist.six.oval.core.ws;

import java.util.List;
import jp.go.aist.six.oval.OvalException;
import jp.go.aist.six.oval.core.datastore.mongodb.MongoDatastore;
import jp.go.aist.six.oval.model.v5.OvalObject;
import jp.go.aist.six.oval.model.v5.definitions.DefinitionType;
import jp.go.aist.six.oval.model.v5.results.OvalResults;
import jp.go.aist.six.oval.model.v5.results.ResultsType;
import jp.go.aist.six.oval.model.v5.results.SystemType;
import jp.go.aist.six.oval.model.v5.sc.OvalSystemCharacteristics;
import jp.go.aist.six.util.persist.Persistable;
import jp.go.aist.six.util.persist.PersistenceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.google.code.morphia.Key;
import com.google.code.morphia.dao.DAO;
import com.google.code.morphia.query.Query;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class MongoOvalService
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ =
        LoggerFactory.getLogger( MongoOvalService.class );



    /**
     * The data store sole instance.
     */
    private MongoDatastore  _datastore;



    /**
     * Constructor.
     */
    public MongoOvalService()
    {
    }



    /**
     */
    public void setDatastore(
                    final MongoDatastore datastore
                    )
    {
        _datastore = datastore;
    }



    /**
     * Returns the OVAL resource.
     */
    public <K, T extends Persistable<K>>
    T getObject(
                    final Class<T> type,
                    final K id
                    )
    throws OvalException
    {
        _LOG_.debug( "type=" + type + ", id=" + id );

        T  p_object = null;
        try {
            p_object = _datastore.load( type, id );
        } catch (PersistenceException ex) {
            throw new OvalException( ex );
        }

        return p_object;
    }



    /**
     * Returns the OVAL resource IDs.
     */
    public <K, T extends Persistable<K>>
    List<Key<T>> getObjectIDs(
                    final Class<T> type
                    )
    throws OvalException
    {
        _LOG_.debug( "type=" + type );

        List<Key<T>>  ids = null;
        try {
            DAO<T, K>  dao = _datastore.getDAO( type );
            ids = dao.find().asKeyList(); //dao.findIds();
//            ids = dao.findIds();
        } catch (PersistenceException ex) {
            throw new OvalException( ex );
        }

        return ids;
    }



    /**
     * Creates an OVAL resource.
     */
    public <K, T extends Persistable<K>>
    K createObject(
                    final Class<T> type,
                    final T object
                    )
    throws OvalException
    {
        _LOG_.debug( "type=" + type + ", object=" + object );

        K  id = null;
        try {
            id = _datastore.create( type, object );
        } catch (PersistenceException ex) {
            throw new OvalException( ex );
        }

        return id;
    }



    /**
     * Generic query API.
     *
     */
    public <T extends OvalObject> OvalQueryResult find(
                    final Class<T> type,
                    final QueryParams<T> params
                    )
    throws OvalException
    {
        _LOG_.debug( "query: type=" + type + ", params: " + params );

        List<T>  list = null;
        try {
            DAO<T, String>  dao = _datastore.getDAO( type );
            Query<T>  q = dao.createQuery();
            if (params != null) {
                params.buildQuery( q );
            }

            list = dao.find( q ).asList();
            _LOG_.debug( "#objects found: " + list.size() );
        } catch (Exception ex) {
            throw new OvalException( ex );
        }

        OvalQueryResult  result = new OvalQueryResult( list );
        return result;
    }


    //==============================================================
    // /build_oval_definitions
    //==============================================================



    //==============================================================
    // /oval_definitions
    //==============================================================


    //==============================================================
    // /d/definitions
    //==============================================================

    // GET (query)
    public OvalQueryResult findDefinitions(
                    final DefinitionsQueryParams params
                    )
    throws OvalException
    {
        return find( DefinitionType.class, params );
    }
//    public List<DefinitionType> findDefinitions(
//                    final DefinitionsQueryParams params
//                    )
//    throws OvalException
//    {
//        _LOG_.debug( "query params: " + params );
//
//        List<DefinitionType>  def_list = null;
//        try {
//            DAO<DefinitionType, String>  dao = _datastore.getDAO( DefinitionType.class );
//            Query<DefinitionType>  q = dao.createQuery();
//            params.buildQuery( q );
//
//            def_list = dao.find( q ).asList();
//            _LOG_.debug( "#definitions found: " + def_list.size() );
//        } catch (Exception ex) {
//            throw new OvalException( ex );
//        }
//
//        return def_list;
//    }



    /**
     */
    public DefinitionType getDefinition(
                    final String oval_id,
                    final String oval_version
                    )
    throws OvalException
    {
        _LOG_.debug( "oval id=" + oval_id + ", version=" + oval_version );

        DefinitionType  def = null;
        try {
            DAO<DefinitionType, String>  dao = _datastore.getDAO( DefinitionType.class );
            Query<DefinitionType>  q = dao.createQuery().filter( "oval_id", oval_id );

            if (oval_version == null  ||  "latest".equalsIgnoreCase( oval_version )) {
                q.order( "-oval_version" );
            } else {
                q.filter( "oval_version", Integer.valueOf( oval_version ) );
            }

            def = dao.findOne( q );
            if (def == null) {
                _LOG_.debug( "no definition found: oval id=" + oval_id );
            } else {
                _LOG_.debug( "definition found: persistent id=" + def.getPersistentID() );
            }
        } catch (Exception ex) {
            throw new OvalException( ex );
        }

        return def;

    }



    public DefinitionType getLatestDefinition(
                    final String oval_id
                    )
    throws OvalException
    {
        _LOG_.debug( "oval id: " + oval_id );

        DefinitionType  def = null;
        try {
            DAO<DefinitionType, String>  dao = _datastore.getDAO( DefinitionType.class );
            Query<DefinitionType>  q = dao.createQuery().filter( "oval_id", oval_id ).order( "-oval_version" );

            def = dao.findOne( q );
            if (def == null) {
                _LOG_.debug( "no definition found: oval id=" + oval_id );
            } else {
                _LOG_.debug( "definition found: persistent id=" + def.getPersistentID() );
            }
        } catch (Exception ex) {
            throw new OvalException( ex );
        }

        return def;

    }

    //==============================================================
    // /oval_system_characteristics
    //==============================================================

    // GET (query) /oval_system_characteristics
    public List<Key<OvalSystemCharacteristics>> findOvalSystemCharacteristics(
                    final OvalSystemCharacteristicsQueryParams params
                    )
    throws OvalException
    {
        _LOG_.debug( "query params: " + params );

        List<Key<OvalSystemCharacteristics>>  list = null;
        try {
            DAO<OvalSystemCharacteristics, String>  dao = _datastore.getDAO( OvalSystemCharacteristics.class );
            Query<OvalSystemCharacteristics>  q = dao.createQuery();
            params.buildQuery( q );
            _LOG_.debug( "MongoDB query: " + q );

            list = dao.find( q ).asKeyList();
            _LOG_.debug( "#oval_system_characteristics found: " + list.size() );
        } catch (Exception ex) {
            throw new OvalException( ex );
        }

        return list;
    }



    //==============================================================
    // Results
    //==============================================================

    public String createOvalResults(
                    final OvalResults ovalResults
    )
    throws OvalException
    {
        return createObject( OvalResults.class, ovalResults );
    }



    public OvalResults getOvalResults(
                    final String id
                    )
    throws OvalException
    {
        return getObject( OvalResults.class, id );
    }



    // curl -v -o query_primary_host_name.xml -X GET -HAccept:application/xml
    //   http://localhost:8080/oval_repo/oval_results/results?primary_host_name=host1
    @RequestMapping(
                    method=RequestMethod.GET
                    ,value="/oval_results/results"
                    ,headers="Accept=application/xml"
    )
    public ResultsType findResults(
                    final String primary_host_name
                    )
    throws OvalException
    {
        _LOG_.debug( "primary_host_name=" + primary_host_name );

        // (1) searches SC keys
        List<Key<OvalSystemCharacteristics>>  sc_keys = null;
        try {
            DAO<OvalSystemCharacteristics, String>  dao = _datastore.getDAO( OvalSystemCharacteristics.class );
            Query<OvalSystemCharacteristics>  q = dao.createQuery()
            .filter( "system_info.primary_host_name", primary_host_name );

            sc_keys = dao.find( q ).asKeyList();
        } catch (Exception ex) {
            throw new OvalException( ex );
        }
        _LOG_.debug( "SC keys: " + sc_keys );

        ResultsType  results = new ResultsType();
        try {
            DAO<OvalResults, String>  dao = _datastore.getDAO( OvalResults.class );
            List<OvalResults>  qr = dao.createQuery()
            .field( "results.system.oval_system_characteristics" ).hasAnyOf( sc_keys ).asList();
            for (OvalResults  r : qr) {
                _LOG_.debug( "OvalResults: pid=" + r.getPersistentID() );
                ResultsType  rs = r.getResults();
                if (rs != null  &&  rs.size() > 0) {
                    for (SystemType  s : rs.getSystem()) {
                        _LOG_.debug( "  system: " + s.getOvalSystemCharacteristics().getSystemInfo() );
                        results.addSystem( s );
                    }
                }
            }


//            for (Key<OvalSystemCharacteristics>  sc_key : sc_keys) {
//                List<OvalResults>  qr = dao.createQuery()
//                .filter( "results.system.oval_system_characteristics", sc_key ).retrievedFields( true, "reults.system" ).asList();
//
//                for (OvalResults  r : qr) {
//                    _LOG_.debug( "OvalResults: pid=" + r.getPersistentID() );
//                    ResultsType  rs = r.getResults();
//                    if (rs != null  &&  rs.size() > 0) {
//                        for (SystemType  s : rs.getSystem()) {
//                            _LOG_.debug( "  system: " + s.getOvalSystemCharacteristics().getSystemInfo() );
//                            results.addSystem( s );
//                        }
//                    }
//                }
//            }

        } catch (PersistenceException ex) {
            throw new OvalException( ex );
        }

//        HttpHeaders  headers = new HttpHeaders();
//        _LOG_.debug( "HTTP response headers=" + headers );

        return results;
    }



    // GET (query) /oval_results/results
    public ResultsType findResults(
                    final ResultsQueryParams params
                    )
    throws OvalException
    {
        _LOG_.debug( "query params: " + params );

        List<SystemType>  result_list = null;
        try {
            DAO<SystemType, String>  dao = _datastore.getDAO( SystemType.class );
            Query<SystemType>  q = dao.createQuery();
            params.buildQuery( q );

            result_list = dao.find( q ).asList();
            _LOG_.debug( "#results found: " + result_list.size() );
        } catch (Exception ex) {
            throw new OvalException( ex );
        }

        ResultsType  results = new ResultsType();
        if (result_list != null  &&  result_list.size() > 0) {
            for (SystemType  d : result_list) {
                results.addSystem( d );
            }
        }
        _LOG_.debug( "#results in results: " + results.size() );

        return results;
    }

}
// MongoOvalService

