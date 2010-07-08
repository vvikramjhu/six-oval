/*
 *  @ProductName@
 *  Copyright (C) @CopyrightYear@
 *    National Institute of Advanced Industrial Science and Technology (AIST)
 *    Registration Number: @AISTRegistrationNumber@
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

package jp.go.aist.six.oval.core.service;

import jp.go.aist.six.oval.core.model.definition.DefinitionCriteria;
import jp.go.aist.six.oval.core.store.OvalStore;
import jp.go.aist.six.oval.core.xml.OvalXml;
import jp.go.aist.six.oval.model.OvalEntity;
import jp.go.aist.six.oval.model.definition.Criteria;
import jp.go.aist.six.oval.model.definition.Definition;
import jp.go.aist.six.oval.service.OvalServiceException;
import jp.go.aist.six.util.search.RelationalBinding;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.Collection;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class LocalOvalRepository
{

    /**
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( LocalOvalRepository.class );



    /**
     * The data store sole instance.
     */
    private OvalStore  _store;


    /**
     * The XML processor sole instance.
     */
    private OvalXml  _xml;



    /**
     * Constructor.
     */
    public LocalOvalRepository()
    throws Exception
    {
        _initialize();
    }



    /**
     */
    private void _initialize()
    throws Exception
    {
        OvalContext  context = new OvalContext();
        _store = context.getStore();
        _xml = context.getXml();
    }



    //**************************************************************
    //  OvalRepository
    //**************************************************************


    public Collection<String> findDefinitionIDByCve(
                    final String cve
                    )
    throws OvalServiceException
    {
        RelationalBinding  filter = RelationalBinding.equalBinding(
                        "relatedCves.persistentID", cve );
        Collection<String>  ovalIDList = _store.findIdentity( Definition.class, filter );

        return ovalIDList;
    }



    public Criteria getDefinitionCriteria(
                    final Definition  def
                    )
    throws OvalServiceException
    {
        return getDefinitionCriteria( def.getOvalID(), def.getOvalVersion() );
    }


    public Criteria getDefinitionCriteria(
                    final String defID,
                    final int defVersion
                    )
    throws OvalServiceException
    {
        String  pid = OvalEntity.generatePersistentID( defID, defVersion );
        DefinitionCriteria  dc = _store.get( DefinitionCriteria.class, pid );
        Criteria  criteria = null;
        if (dc != null) {
            try {
                criteria = (Criteria)_xml.unmarshalFromString( dc.getCriteriaXml() );
            } catch (Exception ex) {
                _LOG.error( "unmarshal criteria: " + ex.getMessage() );
                throw new OvalServiceException( ex );
            }
        }

        return criteria;
    }

}
// LocalOvalRepository

