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
import jp.go.aist.six.oval.model.definitions.Definition;
import jp.go.aist.six.oval.model.definitions.Metadata;
import jp.go.aist.six.oval.model.definitions.Platform;
import jp.go.aist.six.oval.model.definitions.Product;
import jp.go.aist.six.oval.model.definitions.Reference;
import jp.go.aist.six.util.BeansUtil;
import jp.go.aist.six.util.persist.PersistenceException;
import java.util.ArrayList;
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



    /**
     */
    protected void _beforePersist(
                    final Definition def
                    )
    throws PersistenceException
    {
        JdoCallbackHandler.jdoBeforeCreate( Definition.class, def );
    }
//    {
//        if (def instanceof PersistentDefinition) {
//            // callback handler
//        } else {
//            JdoCallbackHandler.jdoBeforeCreate( Definition.class, def );
//        }
//    }


    //**************************************************************
    //  Dao, CastorDao
    //**************************************************************

//    @Override
//    protected Definition _jdoLoad(
//                    final String id
//                    )
//    throws PersistenceException
//    {
//
//    }


    @Override
    protected void _daoAfterLoad(
                    final Definition object
                    )
    {
        JdoCallbackHandler.jdoLoad( Definition.class, object );
    }



    @Override
    protected void _daoBeforeCreate(
                    final Definition object
                    )
    throws PersistenceException
    {
        final Definition  def = object;
        _beforePersist( def );

        Metadata  meta = def.getMetadata();

        Collection<Reference>  refs = meta.getReference();
        if (refs != null  &&  refs.size() > 0) {
            Collection<Reference>  p_refs = new ArrayList<Reference>();
            for (Reference  ref : refs) {
                Reference  p_ref = _daoLoadOrCreate( Reference.class, ref );
                if (p_ref == null) {
                    p_refs.add( ref );
                } else {
                    p_refs.add( p_ref );
                }
            }
            meta.setReference( p_refs );
        }

        Affected  affected = meta.getAffected();
        if (affected != null) {
            Collection<Platform>  platforms = affected.getPlatform();
            if (platforms != null  &&  platforms.size() > 0) {
                Collection<Platform>  p_platforms = new ArrayList<Platform>();
                for (Platform  platform : platforms) {
                    Platform  p_platform = _daoLoadOrCreate( Platform.class, platform );
                    if (p_platform == null) {
                        p_platforms.add( platform );
                    } else {
                        p_platforms.add( p_platform );
                    }
                }
                affected.setPlatform( p_platforms );
            }

            Collection<Product>  products = affected.getProduct();
            if (products != null  &&  products.size() > 0) {
                Collection<Product>  p_products = new ArrayList<Product>();
                for (Product  product : products) {
                    Product  p_product = _daoLoadOrCreate( Product.class, product );
                    if (p_product == null) {
                        p_products.add( product );
                    } else {
                        p_products.add( p_product );
                    }
                }
                affected.setProduct( p_products );
            }
        }

//        Collection<Cve>  cves = def.getRelatedCve();
//        if (cves != null  &&  cves.size() > 0) {
//            Collection<Cve>  p_cves = new ArrayList<Cve>();
//            for (Cve  cve : cves) {
//                Cve  p_cve = _loadOrCreate( Cve.class, cve );
//                p_cves.add( p_cve );
//            }
//            def.setRelatedCve( p_cves );
//        }
    }



    @Override
    protected void _daoBeforeUpdate(
                    final Definition object
                    )
    throws PersistenceException
    {
        final Definition  def = object;

        _beforePersist( def );

        Metadata  meta = def.getMetadata();

        Collection<Reference>  refs = meta.getReference();
        if (refs != null  &&  refs.size() > 0) {
            for (Reference  ref : refs) {
                _update( Reference.class, ref );
            }
        }

        Affected  affected = meta.getAffected();
        if (affected != null) {
            Collection<Platform>  platforms = affected.getPlatform();
            if (platforms != null  &&  platforms.size() > 0) {
                for (Platform  platform : platforms) {
                    _update( Platform.class, platform );
                }
            }

            Collection<Product>  products = affected.getProduct();
            if (products != null  &&  products.size() > 0) {
                for (Product  product : products) {
                    _update( Product.class, product );
                }
            }
        }

//        Collection<Cve>  cves = def.getRelatedCve();
//        if (cves != null  &&  cves.size() > 0) {
//            for (Cve  cve : cves) {
//                _update( Cve.class, cve );
//            }
//        }
    }



    protected static final String[]  _EXCEPTED_PROPERTIES_ =
        new String[] {
        "persistentID",
        "ovalID",
        "ovalVersion",
        "metadata",
        "relatedCve"
        };

    protected static final String[]  _EXCEPTED_METADATA_PROPERTIES_ =
        new String[] {
        "reference",
        "affected"
        };

    protected static final String[]  _EXCEPTED_AFFECTED_PROPERTIES_ =
        new String[] {
        "platform",
        "product"
        };


    @Override
    protected void _syncProperties(
                    final Definition   object,
                    final Definition p_object
                    )
    {
        if (p_object == null) {
            return;
        }

        BeansUtil.copyPropertiesExcept(
                        p_object, object, _EXCEPTED_PROPERTIES_ );

        Metadata  meta = object.getMetadata();
        Metadata  p_meta = p_object.getMetadata();
        BeansUtil.copyPropertiesExcept(
                        p_meta, meta, _EXCEPTED_METADATA_PROPERTIES_ );

        Affected  affected = meta.getAffected();
        Affected  p_affected = p_meta.getAffected();
        if (affected == null) {
            p_meta.setAffected( null );
        } else {
            if (p_affected == null) {
                p_affected = new Affected();
            }
            BeansUtil.copyPropertiesExcept(
                            p_affected, affected, _EXCEPTED_AFFECTED_PROPERTIES_ );
        }

        _beforePersist( p_object );
    }



    @Override
    protected void _daoBeforeSync(
                    final Definition object,
                    final Definition p_object
                    )
    throws PersistenceException
    {
//        super._syncDeeply( object, p_object );
        _beforePersist( object );

        Metadata  meta = object.getMetadata();

        // metadata.reference
        Collection<Reference>  refs = meta.getReference();
        Collection<Reference>  p_refs = new ArrayList<Reference>();
        if (refs != null) {
            for (Reference  ref : refs) {
                Reference  p_ref = _sync( Reference.class, ref );
                if (p_ref == null) {
                    p_refs.add( ref );
                } else {
                    p_refs.add( p_ref );
                }
            }
        }
        if (p_object == null) {
            meta.setReference( p_refs );
        } else {
            p_object.getMetadata().setReference( p_refs );
        }

        Affected  affected = meta.getAffected();
        if (affected != null) {
            Collection<Platform>  platforms = affected.getPlatform();
            Collection<Platform>  p_platforms = new ArrayList<Platform>();
            if (platforms != null  &&  platforms.size() > 0) {
                for (Platform  platform : platforms) {
                    Platform  p_platform = _sync( Platform.class, platform );
                    if (p_platform == null) {
                        p_platforms.add( platform );
                    } else {
                        p_platforms.add( p_platform );
                    }
                }
            }

            Collection<Product>  products = affected.getProduct();
            Collection<Product>  p_products = new ArrayList<Product>();
            if (products != null  &&  products.size() > 0) {
                for (Product  product : products) {
                    Product  p_product = _sync( Product.class, product );
                    if (p_product == null) {
                        p_products.add( product );
                    } else {
                        p_products.add( p_product );
                    }
                }
            }

            if (p_object == null) {
                affected.setPlatform( p_platforms );
                affected.setProduct( p_products );
            } else {
                //NOTE: In _copyProperties(), affected of p_object is created,
                // if it does not exist.
                p_object.getMetadata().getAffected().setPlatform( p_platforms );
                p_object.getMetadata().getAffected().setProduct( p_products );
            }
        }

//        // relatedCve
//        Collection<Cve>  cves = object.getRelatedCve();
//        Collection<Cve>  p_cves = new ArrayList<Cve>();
//        if (cves != null  &&  cves.size() > 0) {
//            for (Cve  cve : cves) {
//                Cve  p_cve = _sync( Cve.class, cve );
//                if (p_cve == null) {
//                    p_cves.add( cve );
//                } else {
//                    p_cves.add( p_cve );
//                }
//            }
//        }
//
//        if (p_object == null) {
//            object.setRelatedCve( p_cves );
//        } else {
//            p_object.setRelatedCve( p_cves );
//        }
    }

}
// DefinitionDao
