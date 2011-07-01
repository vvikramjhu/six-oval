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
import jp.go.aist.six.oval.model.v5.definitions.DefinitionType;
import jp.go.aist.six.oval.model.v5.definitions.DefinitionsType;
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




    //==============================================================
    // /build_oval_definitions
    //==============================================================



    //==============================================================
    // /oval_definitions
    //==============================================================


    //==============================================================
    // /oval_definitions/definitions
    //==============================================================

    // GET (query) /oval_definitions/definitions
    public DefinitionsType findDefinitions(
                    final DefinitionsQueryParams params
                    )
    throws OvalException
    {
        _LOG_.debug( "query params: " + params );

        List<DefinitionType>  def_list = null;
        try {
            DAO<DefinitionType, String>  dao = _datastore.getDAO( DefinitionType.class );
            Query<DefinitionType>  q = dao.createQuery();
            params.buildQuery( q );

//            String  definitionClass = params.getDefinitionClass();
//            if (definitionClass != null) {
//                q.filter( "class", ClassEnumeration.fromValue( definitionClass ) );
//            }
//
//            String  family = params.getFamily();
//            if (family != null) {
//                q.filter( "metadata.affected.family", FamilyEnumeration.fromValue( family ) );
//            }
//
//            String  platform = params.getPlatform();
//            if (platform != null) {
//                q.filter( "metadata.affected.platform", platform );
//            }
//
//            String  product = params.getProduct();
//            if (product != null) {
//                q.filter( "metadata.affected.product", product );
//            }

            def_list = dao.find( q ).asList();
            _LOG_.debug( "#definitions found: " + def_list.size() );
        } catch (Exception ex) {
            throw new OvalException( ex );
        }

        DefinitionsType  defs = new DefinitionsType();
        if (def_list != null  &&  def_list.size() > 0) {
            for (DefinitionType  d : def_list) {
                defs.addDefinition( d );
            }
        }
        _LOG_.debug( "#definitions in results: " + defs.size() );

        return defs;
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



}
// MongoOvalService

