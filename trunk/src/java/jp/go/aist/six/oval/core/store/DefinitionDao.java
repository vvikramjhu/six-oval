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

import jp.go.aist.six.oval.model.definition.Affected;
import jp.go.aist.six.oval.model.definition.Cve;
import jp.go.aist.six.oval.model.definition.Definition;
import jp.go.aist.six.oval.model.definition.Metadata;
import jp.go.aist.six.oval.model.definition.Platform;
import jp.go.aist.six.oval.model.definition.Product;
import jp.go.aist.six.oval.model.definition.Reference;
import java.util.Collection;
import java.util.List;



/**
 * @author  Akihito Nakamura, AIST
 * @version $Id: DefinitionDao.java 673 2010-04-23 09:07:11Z akihito $
 */
public class DefinitionDao
    extends OvalEntityDao<Definition>
{

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

        Collection<Cve>  cves = def.getRelatedCves();
        if (cves != null  &&  cves.size() > 0) {
            Collection<Cve>  p_cves =
                getForwardingDao( Cve.class ).syncAll( cves );
            def.setRelatedCves( p_cves );
        }

        return super.create( def );
    }

}
// DefinitionDao
