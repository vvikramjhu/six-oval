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

package jp.go.aist.six.oval.model.independent;

import jp.go.aist.six.oval.model.EntityType;
import jp.go.aist.six.oval.model.common.Family;
import jp.go.aist.six.oval.model.sc.Item;
import jp.go.aist.six.oval.model.sc.Status;



/**
 * This element stores high level system OS type,
 * otherwise known as the family.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class FamilyItem
    extends Item
{

    private EntityItemFamily  _family;
    //{0..1}



    /**
     * Constructor.
     */
    public FamilyItem()
    {
    }


    /**
     * Constructor.
     */
    public FamilyItem(
                    final int id
                    )
    {
        super( id );
    }


    /**
     * Constructor.
     */
    public FamilyItem(
                    final int id,
                    final Status status
                    )
    {
        super( id, status );
    }


    /**
     * Constructor.
     */
    public FamilyItem(
                    final int id,
                    final Status status,
                    final Family family
                    )
    {
        this( id, status,
                        (family == null ? null : (new EntityItemFamily( family )))
                        );
    }



    /**
     * Constructor.
     */
    public FamilyItem(
                    final int id,
                    final Status status,
                    final EntityItemFamily family
                    )
    {
        super( id, status );
        setFamily( family );
    }



    public void setFamily(
                    final EntityItemFamily family
                    )
    {
        _family = family;
    }


    public EntityItemFamily getFamily()
    {
        return _family;
    }



    //**************************************************************
    //  Item
    //**************************************************************

    @Override
    public EntityType getEntityType()
    {
        return EntityType.INDEPENDENT_FAMILY;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "FamilyItem[family=" + getFamily()
                        + super.toString()
                        + "]";
    }

}
// FamilyItem
