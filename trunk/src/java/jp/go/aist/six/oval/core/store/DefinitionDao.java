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

package jp.go.aist.six.oval.core.store;

import jp.go.aist.six.oval.model.definitions.Affected;
import jp.go.aist.six.oval.model.definitions.Cve;
import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.Metadata;
import jp.go.aist.six.oval.model.definitions.Platform;
import jp.go.aist.six.oval.model.definitions.Product;
import jp.go.aist.six.oval.model.definitions.Reference;
import jp.go.aist.six.util.persist.PersistenceException;
import java.util.Collection;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class DefinitionDao
    extends OvalEntityDao<Definition>
{

//    /**
//     * Logger.
//     */
//    private static Log  _LOG = LogFactory.getLog( DefinitionDao.class );



//    private static OvalXml  _mapper = null;
//
//    protected static OvalXml _getMapper()
//    {
//        if (_mapper == null) {
//            _mapper = OvalContext.INSTANCE.getXml();
//        }
//
//        return _mapper;
//    }



    /**
     * Constructor.
     */
    public DefinitionDao()
    {
        super( Definition.class );
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

//    @Override
//    public void update(
//                    final Definition def
//                    )
//    throws PersistenceException
//    {
//        Metadata  meta = def.getMetadata();
//
//        Collection<Reference>  references = meta.getReference();
//        if (references != null  &&  references.size() > 0) {
//            Collection<Reference>  p_references = new ArrayList<Reference>( references.size() );
//            for (Reference  r : references) {
//                getForwardingDao( Reference.class ).createIfNotExist( r );
//                Reference  p_r = getForwardingDao( Reference.class ).get( r.getPersistentID() );
//                p_references.add( p_r );
//            }
//            meta.setReference( p_references );
//        }
//
//        super.update( def );
//    }


    @Override
    public String create(
                    final Definition def
                    )
    throws PersistenceException
    {
        Metadata  meta = def.getMetadata();

        Collection<Reference>  references = meta.getReference();
        if (references != null  &&  references.size() > 0) {
            for (Reference  r : references) {
                getForwardingDao( Reference.class ).createIfNotExist( r );
            }
        }

        Affected  affected = meta.getAffected();
        if (affected != null) {
            Collection<Platform>  platforms = affected.getPlatform();
            for (Platform  p : platforms) {
                getForwardingDao( Platform.class ).createIfNotExist( p );
            }

            Collection<Product>  products = affected.getProduct();
            for (Product  p : products) {
                getForwardingDao( Product.class ).createIfNotExist( p );
            }
        }

        Collection<Cve>  cves = def.getRelatedCve();
        if (cves != null  &&  cves.size() > 0) {
            for (Cve  c : cves) {
                getForwardingDao( Cve.class ).createIfNotExist( c );
            }
        }


        if (def instanceof PersistentDefinition) {
            // callback handler
        } else {
            JdoCallbackHandler.jdoBeforeCreate( Definition.class, def );

//            if (_LOG.isDebugEnabled()) {
//                _LOG.debug( "***** criteria Object to XML *****" );
//            }
//            Criteria  criteria = def.getCriteria();
//            if (criteria != null) {
//                try {
//                    String  xml = _getMapper().marshalToString( criteria );
//                    def.xmlSetCriteria( xml );
//                } catch (Exception ex) {
//                    // TODO:
//                    _LOG.warn( ex.getMessage() );
//                }
//            }
        }

        return super.create( def );
    }
//    {
//        Metadata  meta = def.getMetadata();
//
//        Collection<Reference>  references = meta.getReference();
//        if (references != null  &&  references.size() > 0) {
//            List<Reference>  p_references =
//                getForwardingDao( Reference.class ).syncAll( references );
//            meta.setReference( p_references );
//        }
//
//        Affected  affected = meta.getAffected();
//        if (affected != null) {
//            Collection<Platform>  platforms = affected.getPlatform();
//            if (platforms != null  &&  platforms.size() > 0) {
//                Collection<Platform>  p_platforms =
//                    getForwardingDao( Platform.class ).syncAll( platforms );
//                affected.setPlatform( p_platforms );
//            }
//
//            Collection<Product>  products = affected.getProduct();
//            if (products != null  &&  products.size() > 0) {
//                Collection<Product>  p_products =
//                    getForwardingDao( Product.class ).syncAll( products );
//                affected.setProduct( p_products );
//            }
//        }
//
//        Collection<Cve>  cves = def.getRelatedCve();
//        if (cves != null  &&  cves.size() > 0) {
//            Collection<Cve>  p_cves =
//                getForwardingDao( Cve.class ).syncAll( cves );
//            def.setRelatedCve( p_cves );
//        }
//
//
//        if (def instanceof PersistentDefinition) {
//            // callback handler
//        } else {
//            JdoCallbackHandler.jdoBeforeCreate( Definition.class, def );
//
////            if (_LOG.isDebugEnabled()) {
////                _LOG.debug( "***** criteria Object to XML *****" );
////            }
////            Criteria  criteria = def.getCriteria();
////            if (criteria != null) {
////                try {
////                    String  xml = _getMapper().marshalToString( criteria );
////                    def.xmlSetCriteria( xml );
////                } catch (Exception ex) {
////                    // TODO:
////                    _LOG.warn( ex.getMessage() );
////                }
////            }
//        }
//
//        return super.create( def );
//    }

}
// DefinitionDao
