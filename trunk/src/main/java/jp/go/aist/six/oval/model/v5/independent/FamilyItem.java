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

package jp.go.aist.six.oval.model.v5.independent;

import jp.go.aist.six.oval.model.OvalComponentType;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.PlatformEntityType;
import jp.go.aist.six.oval.model.common.FamilyEnumeration;
import jp.go.aist.six.oval.model.v5.sc.ItemType;



/**
 * This element stores high level system OS type,
 * otherwise known as the family.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class FamilyItem
    extends ItemType
{

    private EntityItemFamilyType  family;
    //{0..1}



    /**
     * Constructor.
     */
    public FamilyItem()
    {
        this( 0 );
    }


    public FamilyItem(
                    final int id
                    )
    {
        super( id );

        _oval_platform_type = OvalPlatformType.independent;
        _oval_component_type = OvalComponentType.family;
    }



    /**
     */
    public void setFamily(
                    final EntityItemFamilyType family
                    )
    {
        this.family = family;
    }


    public EntityItemFamilyType getFamily()
    {
        return this.family;
    }


    public FamilyItem family(
                    final FamilyEnumeration family
                    )
    {
        setFamily( new EntityItemFamilyType( family ) );
        return this;
    }


    public FamilyItem family(
                    final EntityItemFamilyType family
                    )
    {
        setFamily( family );
        return this;
    }



    //**************************************************************
    //  Item
    //**************************************************************

    @Override
    public PlatformEntityType getEntityType()
    {
        return PlatformEntityType.INDEPENDENT_FAMILY;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "family_item[family=" + getFamily()
             + ", " + super.toString()
             + "]";
    }

}
// FamilyItem
