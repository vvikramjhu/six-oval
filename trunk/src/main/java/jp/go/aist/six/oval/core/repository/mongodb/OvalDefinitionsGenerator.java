package jp.go.aist.six.oval.core.repository.mongodb;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import jp.go.aist.six.oval.OvalException;
import jp.go.aist.six.oval.core.OvalContext;
import jp.go.aist.six.oval.core.model.EntityUtil;
import jp.go.aist.six.oval.model.definitions.DefinitionType;
import jp.go.aist.six.oval.model.definitions.DefinitionsElement;
import jp.go.aist.six.oval.model.definitions.DefinitionsType;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.oval.repository.OvalRepositoryException;
import jp.go.aist.six.oval.repository.QueryParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalDefinitionsGenerator
{

    /**
     * Logger.
     */
    private static final Logger  _LOG_ =
        LoggerFactory.getLogger( OvalDefinitionsGenerator.class );




    private static MongoOvalDatastore  _DATASTORE_;



    /**
     * Constructor.
     */
    public OvalDefinitionsGenerator()
    {
    }



    /**
     */
    private static MongoOvalDatastore _getDatastore()
    {
        if (_DATASTORE_ == null) {
            _DATASTORE_ = OvalContext.INSTANCE.getBean( MongoOvalDatastore.class );
        }

        return _DATASTORE_;
    }



    public String generateByQuery(
                    final QueryParams params
                    )
    throws OvalException
    {
        _LOG_.debug( "params=" + params );

        List<DefinitionType>  def_list = _getDatastore().find( DefinitionType.class, params );
        if (def_list == null) {
            throw new OvalException( "no Definition found" );
        }

        OvalDefinitions  oval_defs = new OvalDefinitions();

        DefinitionsType  defs = new DefinitionsType();
        defs.setDefinition( def_list );
        oval_defs.setDefinitions( defs );
        for (DefinitionType  def : def_list) {
            Collection<String>  ref_ids = EntityUtil.getElementRefId( def );
            _addElements( oval_defs, ref_ids );
        }

        String  id = _getDatastore().save( OvalDefinitions.class, oval_defs );
        return id;
    }



    private void _addElements(
                    final OvalDefinitions oval_defs,
                    final Collection<String> oval_ids
                    )
    throws OvalException
    {
        Collection<DefinitionsElement>  added_elements = new HashSet<DefinitionsElement>();
        for (String  oval_id : oval_ids) {
            DefinitionsElement  element = _addElement( oval_defs, oval_id );
            if (element != null) {
                added_elements.add( element );
            }
        }

        if (added_elements.size() > 0) {
            Collection<String>  added_ids = new HashSet<String>();
            for (DefinitionsElement  e : added_elements) {
                added_ids.add( e.getOvalID() );
            }

            _addElements( oval_defs, added_ids );
        }
    }


    private DefinitionsElement _addElement(
                    final OvalDefinitions oval_defs,
                    final String oval_id
                    )
    throws OvalException
    {
        boolean  contained = EntityUtil.containsElement( oval_defs, oval_id );
        if(contained) {
            return null;
        }

        Class<? extends DefinitionsElement>  java_type = EntityUtil.objectTypeOf( oval_id );
        DefinitionsElement  element = _getDatastore().findById( java_type, oval_id );
        if (element == null) {
            throw new OvalRepositoryException( "no such definitions element: " + oval_id );
        }
        EntityUtil.addElement( oval_defs, element );
        return element;
    }

}
//
