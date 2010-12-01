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

import jp.go.aist.six.oval.model.common.Generator;
import jp.go.aist.six.oval.model.definitions.OvalDefinitions;
import jp.go.aist.six.util.castor.DefaultPersistenceHelper;



/**
 * TODO: Change this class as a nested class of OvalDefinitionsDao.
 * Do the same change to other helper classes and Dao classes
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class OvalDefinitionsHelper
    extends DefaultPersistenceHelper<OvalDefinitions>
{

    public OvalDefinitionsHelper()
    {
    }



    //**************************************************************
    //  PersistenceHelper
    //**************************************************************

    public Object getUnique(
                    final OvalDefinitions object
                    )
    {
        Generator  generator = object.getGenerator();
        String  digest = object.getDefinitionsDigest();

        return (new Object[] {
                        generator.getSchemaVersion(),
                        generator.getTimestamp(),
                        generator.getProductName(),
                        digest
        });
    }



    public String getUniqueFilter()
    {
        return "WHERE o.generator.schemaVersion = $1 AND o.generator.timestamp = $2 AND o.generator.productName = $3 AND o.definitionsDigest = $4";
    }

}
// OvalDefinitionsHelper

