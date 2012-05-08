package jp.go.aist.six.oval.core.repository.mongodb;

import java.util.UUID;
import jp.go.aist.six.oval.model.sc.OvalSystemCharacteristics;
import com.google.code.morphia.Datastore;
import com.google.code.morphia.Key;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalSystemCharacteristicsDAO
    extends BaseDAO<OvalSystemCharacteristics, String>
{

    /**
     */
    public OvalSystemCharacteristicsDAO(
                    final Datastore ds
                    )
    {
        super( OvalSystemCharacteristics.class, ds );
    }



    //**************************************************************
    //  DAO
    //**************************************************************

    @Override
    public Key<OvalSystemCharacteristics> save(
                    final OvalSystemCharacteristics oval_sc
                    )
    {
        String  pid = oval_sc.getPersistentID();
        if (pid == null) {
            pid = UUID.randomUUID().toString();
            oval_sc.setPersistentID( pid );
        }

        return super.save( oval_sc );
    }

}
// OvalSystemCharacteristicsDAO

