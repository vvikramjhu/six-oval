package jp.go.aist.six.oval.core.repository.mongodb;

import jp.go.aist.six.oval.model.v5.sc.OvalSystemCharacteristics;
import com.google.code.morphia.Datastore;



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

}
// OvalSystemCharacteristicsDAO

