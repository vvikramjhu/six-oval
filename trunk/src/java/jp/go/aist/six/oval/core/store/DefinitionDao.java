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

package jp.go.aist.six.oval.core.store;

import jp.go.aist.six.oval.core.model.definitions.DefinitionCriteria;
import jp.go.aist.six.oval.core.service.OvalContext;
import jp.go.aist.six.oval.core.xml.OvalXml;
import jp.go.aist.six.oval.model.definitions.Affected;
import jp.go.aist.six.oval.model.definitions.Criteria;
import jp.go.aist.six.oval.model.definitions.CriteriaElement;
import jp.go.aist.six.oval.model.definitions.Cve;
import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.Metadata;
import jp.go.aist.six.oval.model.definitions.Platform;
import jp.go.aist.six.oval.model.definitions.Product;
import jp.go.aist.six.oval.model.definitions.Reference;
import jp.go.aist.six.util.xml.OxmException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.Collection;
import java.util.List;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class DefinitionDao
    extends OvalEntityDao<Definition>
{

    /**
     * Logger.
     */
    private static Log  _LOG = LogFactory.getLog( DefinitionDao.class );



    private OvalXml  _xmlMapper;



    /**
     * Constructor.
     */
    public DefinitionDao()
    {
        super( Definition.class );

        try {
            _xmlMapper = OvalContext.INSTANCE.getXml();
        } catch (Exception ex) {
            // TODO:
            _LOG.error(  "XmlMapper instantiation failed: " + ex.getMessage() );
        }
    }



//  private Dao<Product>      _productDao;

//    private synchronized
//    Dao<Product> _getProductDao()
//    {
//        if (_productDao == null) {
//            ProductDao  dao = new ProductDao();
//            dao.setJDOManager( this.getJDOManager() );
//            _productDao = dao;
//        }
//
//        return _productDao;
//    }



    //**************************************************************
    //  Dao, CastorDao
    //**************************************************************

    @Override
    public String create(
                    final Definition def
                    )
    {
        Metadata  meta = def.getMetadata();

        Collection<Reference>  references = meta.getReference();
        if (references != null  &&  references.size() > 0) {
            List<Reference>  p_references =
                getForwardingDao( Reference.class ).syncAll( references );
            meta.setReference( p_references );
        }

        Affected  affected = meta.getAffected();
        if (affected != null) {
            Collection<Platform>  platforms = affected.getPlatform();
            if (platforms != null  &&  platforms.size() > 0) {
                Collection<Platform>  p_platforms =
                    getForwardingDao( Platform.class ).syncAll( platforms );
                affected.setPlatform( p_platforms );
            }

            Collection<Product>  products = affected.getProduct();
            if (products != null  &&  products.size() > 0) {
                Collection<Product>  p_products =
                    getForwardingDao( Product.class ).syncAll( products );
                affected.setProduct( p_products );
            }
        }

        Collection<Cve>  cves = def.getRelatedCve();
        if (cves != null  &&  cves.size() > 0) {
            Collection<Cve>  p_cves =
                getForwardingDao( Cve.class ).syncAll( cves );
            def.setRelatedCve( p_cves );
        }

        Collection<CriteriaElement>  criteriaElements = def.getCriteriaElement();
        if (_LOG.isInfoEnabled()) {
            _LOG.info( "#criteria Elements: " + criteriaElements.size() );
        }
        if (criteriaElements != null  &&  criteriaElements.size() > 0) {
            for (CriteriaElement  element : criteriaElements) {
                element.setMasterObject( def );
            }
        }

        Criteria  criteria = def.getCriteria();
        if (criteria != null  &&  _xmlMapper != null) {
            try {
                String  xml = _xmlMapper.marshalToString( criteria );
                DefinitionCriteria  dc = new DefinitionCriteria();
                dc.setOvalID( def.getOvalID() );
                dc.setOvalVersion( def.getOvalVersion() );
                dc.setCriteriaXml( xml );
                getForwardingDao( DefinitionCriteria.class ).sync( dc );

//                def.setCriteriaXml( xml );
            } catch (OxmException ex) {
                // TODO:
                _LOG.warn(  "'criteria' property NOT persisted" );
            }
        }

        return super.create( def );
    }

}
// DefinitionDao
