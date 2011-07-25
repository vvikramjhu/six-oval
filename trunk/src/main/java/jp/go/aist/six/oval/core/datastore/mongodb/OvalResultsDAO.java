package jp.go.aist.six.oval.core.datastore.mongodb;

import java.util.Collection;
import jp.go.aist.six.oval.model.v5.common.GeneratorType;
import jp.go.aist.six.oval.model.v5.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.v5.results.OvalResults;
import jp.go.aist.six.oval.model.v5.results.ResultsType;
import jp.go.aist.six.oval.model.v5.results.SystemType;
import jp.go.aist.six.oval.model.v5.sc.OvalSystemCharacteristics;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Key;
import com.google.code.morphia.dao.DAO;
import com.google.code.morphia.query.Query;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalResultsDAO
    extends BaseDAO<OvalResults, String>
{

    /**
     */
    public OvalResultsDAO(
                    final Datastore ds
                    )
    {
        super( OvalResults.class, ds );
    }



    //**************************************************************
    //  DAO
    //**************************************************************

    @Override
    public Key<OvalResults> save(
                    final OvalResults oval_results
                    )
    {
        //oval_definitions
        OvalDefinitions  oval_definitions = oval_results.getOvalDefinitions();
        if (oval_definitions != null) {
            DAO<OvalDefinitions, String>  defs_dao = _getForwardingDAO( OvalDefinitions.class );

            //Test if the OvalDefinitions instance is already persisted.
            OvalDefinitions  p_oval_definitions = null;
            String  digest = oval_definitions.getDefinitionsDigest();
            if (digest != null) {
                //TODO: correct the matching condition!!!
                // Obtains correct digest value, id + version.
                Query<OvalDefinitions>  q = defs_dao.createQuery();
//                q.filter( "definitions_digest", digest );
                GeneratorType  generator = oval_definitions.getGenerator();
                q.filter( "generator.timestamp", generator.getTimestamp() );
                q.filter( "generator.schema_version", generator.getSchemaVersion() );
                p_oval_definitions = defs_dao.findOne( q );
            }

            if (p_oval_definitions == null) {
                defs_dao.save( oval_definitions );
//            } else {
//                oval_results.setOvalDefinitions( p_oval_definitions );
            }
        }

        //oval_system_characteristics
        ResultsType  results = oval_results.getResults();
        if (results != null) {
            Collection<SystemType> systems = results.getSystem();
            if (systems != null) {
                DAO<OvalSystemCharacteristics, String>  sc_dao = _getForwardingDAO( OvalSystemCharacteristics.class );
                for (SystemType  s : systems) {
                    OvalSystemCharacteristics  oval_sc = s.getOvalSystemCharacteristics();
                    sc_dao.save( oval_sc );
                }
            }
        }

        return super.save( oval_results );
    }

}
// OvalResultsDAO

