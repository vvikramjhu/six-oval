package jp.go.aist.six.oval.core.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import jp.go.aist.six.oval.model.definitions.EntityAttributeGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public final class EntityUtil
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ = LoggerFactory.getLogger( EntityUtil.class );



    /**
     */
    public static Collection<String> collectVariableId(
                    final EntityAttributeGroup[] entity_list
                    )
    {
        Set<String>  ids = new HashSet<String>();

        if (entity_list == null  ||  entity_list.length == 0) {
            // Do nothing.
        } else {
            for (EntityAttributeGroup  e : entity_list) {
                ids.add( e.getVarRef() );
            }
        }

        return ids;
    }

}
//

