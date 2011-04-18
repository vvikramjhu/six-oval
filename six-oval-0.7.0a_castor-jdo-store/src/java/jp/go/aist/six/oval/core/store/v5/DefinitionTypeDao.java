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

package jp.go.aist.six.oval.core.store.v5;

import java.util.ArrayList;
import java.util.Collection;
import jp.go.aist.six.oval.model.v5.definitions.AffectedType;
import jp.go.aist.six.oval.model.v5.definitions.DefinitionType;
import jp.go.aist.six.oval.model.v5.definitions.MetadataType;
import jp.go.aist.six.oval.model.v5.definitions.Platform;
import jp.go.aist.six.oval.model.v5.definitions.Product;
import jp.go.aist.six.oval.model.v5.definitions.ReferenceType;
import jp.go.aist.six.util.BeansUtil;
import jp.go.aist.six.util.persist.PersistenceException;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class DefinitionTypeDao
    extends OvalEntityDao<DefinitionType>
{

    /**
     * Constructor.
     */
    public DefinitionTypeDao()
    {
        super( DefinitionType.class );
    }



    /**
     */
    protected void _beforePersist(
                    final DefinitionType def
                    )
    throws PersistenceException
    {
        JdoCallbackHandler.jdoBeforeCreate( DefinitionType.class, def );
    }



    //**************************************************************
    //  Dao, CastorDao
    //**************************************************************

    @Override
    protected void _daoAfterLoad(
                    final DefinitionType object
                    )
    {
        JdoCallbackHandler.jdoLoad( DefinitionType.class, object );
    }



    @Override
    protected void _daoBeforeCreate(
                    final DefinitionType object
                    )
    throws PersistenceException
    {
        final DefinitionType  def = object;
        _beforePersist( def );

        MetadataType  meta = def.getMetadata();

        Collection<ReferenceType>  refs = meta.getReference();
        if (refs != null  &&  refs.size() > 0) {
            Collection<ReferenceType>  p_refs = new ArrayList<ReferenceType>();
            for (ReferenceType  ref : refs) {
                ReferenceType  p_ref = _daoLoadOrCreate( ReferenceType.class, ref );
                if (p_ref == null) {
                    p_refs.add( ref );
                } else {
                    p_refs.add( p_ref );
                }
            }
            meta.setReference( p_refs );
        }

        AffectedType  affected = meta.getAffected();
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
                    final DefinitionType object
                    )
    throws PersistenceException
    {
        final DefinitionType  def = object;

        _beforePersist( def );

        MetadataType  meta = def.getMetadata();

        Collection<ReferenceType>  refs = meta.getReference();
        if (refs != null  &&  refs.size() > 0) {
            for (ReferenceType  ref : refs) {
                _update( ReferenceType.class, ref );
            }
        }

        AffectedType  affected = meta.getAffected();
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
                    final DefinitionType   object,
                    final DefinitionType p_object
                    )
    {
        if (p_object == null) {
            return;
        }

        BeansUtil.copyPropertiesExcept(
                        p_object, object, _EXCEPTED_PROPERTIES_ );

        MetadataType  meta = object.getMetadata();
        MetadataType  p_meta = p_object.getMetadata();
        BeansUtil.copyPropertiesExcept(
                        p_meta, meta, _EXCEPTED_METADATA_PROPERTIES_ );

        AffectedType  affected = meta.getAffected();
        AffectedType  p_affected = p_meta.getAffected();
        if (affected == null) {
            p_meta.setAffected( null );
        } else {
            if (p_affected == null) {
                p_affected = new AffectedType();
            }
            BeansUtil.copyPropertiesExcept(
                            p_affected, affected, _EXCEPTED_AFFECTED_PROPERTIES_ );
        }

        _beforePersist( p_object );
    }



    @Override
    protected void _daoBeforeSync(
                    final DefinitionType object,
                    final DefinitionType p_object
                    )
    throws PersistenceException
    {
//        super._syncDeeply( object, p_object );
        _beforePersist( object );

        MetadataType  meta = object.getMetadata();

        // metadata.reference
        Collection<ReferenceType>  refs = meta.getReference();
        Collection<ReferenceType>  p_refs = new ArrayList<ReferenceType>();
        if (refs != null) {
            for (ReferenceType  ref : refs) {
                ReferenceType  p_ref = _sync( ReferenceType.class, ref );
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

        AffectedType  affected = meta.getAffected();
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
// DefinitionTypeDao
