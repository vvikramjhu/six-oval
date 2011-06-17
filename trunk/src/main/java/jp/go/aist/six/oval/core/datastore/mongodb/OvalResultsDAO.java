package jp.go.aist.six.oval.core.datastore.mongodb;

import java.util.Collection;
import jp.go.aist.six.oval.model.v5.definitions.OvalDefinitions;
import jp.go.aist.six.oval.model.v5.results.OvalResults;
import jp.go.aist.six.oval.model.v5.results.ResultsType;
import jp.go.aist.six.oval.model.v5.results.SystemType;
import jp.go.aist.six.oval.model.v5.sc.OvalSystemCharacteristics;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Key;
import com.google.code.morphia.dao.DAO;



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
            DAO<OvalDefinitions, String>  dao = _getForwardingDAO( OvalDefinitions.class );

            //Test if the OvalDefinitions instance is already persisted.
            OvalDefinitions  p_oval_definitions = null;
            String  digest = oval_definitions.getDefinitionsDigest();
            if (digest != null) {
                p_oval_definitions = dao.findOne( "definitions_digest", digest );
            }

            if (p_oval_definitions == null) {
                dao.save( oval_definitions );
            } else {
                oval_results.setOvalDefinitions( p_oval_definitions );
            }
        }

        //oval_system_characteristics
        ResultsType  results = oval_results.getResults();
        if (results != null) {
            Collection<SystemType> systems = results.getSystem();
            if (systems != null) {
                for (SystemType  s : systems) {
                    OvalSystemCharacteristics  oval_sc = s.getOvalSystemCharacteristics();
                    DAO<OvalSystemCharacteristics, String>  dao = _getForwardingDAO( OvalSystemCharacteristics.class );
                    dao.save( oval_sc );
                }
            }
        }

        return super.save( oval_results );
    }

//    {
//        //oval_definitions
//        OvalDefinitions  oval_definitions = oval_results.getOvalDefinitions();
//        if (oval_definitions != null) {
//            String  digest = oval_definitions.getDefinitionsDigest();
//
//            //Test if the OvalDefinitions instance is already persisted.
//            DAO<OvalDefinitions, String>  dao = _getForwardingDAO( OvalDefinitions.class );
//            OvalDefinitions  p_oval_definitions = dao.findOne( "definitions_digest", digest );
//
//            if (p_oval_definitions == null) {
//                dao.save( oval_definitions );
//            } else {
//                oval_results.setOvalDefinitions( p_oval_definitions );
//            }
//        }
//
//        //oval_system_characteristics
//        ResultsType  results = oval_results.getResults();
//        if (results != null) {
//            Collection<SystemType> systems = results.getSystem();
//            if (systems != null) {
//                for (SystemType  s : systems) {
//                    OvalSystemCharacteristics  oval_sc = s.getOvalSystemCharacteristics();
//                    DAO<OvalSystemCharacteristics, String>  dao = _getForwardingDAO( OvalSystemCharacteristics.class );
//                    dao.save( oval_sc );
//                }
//            }
//        }
//
//        return super.save( oval_results );
//    }
}
// OvalResultsDAO

