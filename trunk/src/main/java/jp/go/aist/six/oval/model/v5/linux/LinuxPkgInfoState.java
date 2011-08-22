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

package jp.go.aist.six.oval.model.v5.linux;

import jp.go.aist.six.oval.model.v5.definitions.EntityStateAnySimpleType;
import jp.go.aist.six.oval.model.v5.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.v5.definitions.StateType;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class LinuxPkgInfoState
    extends StateType
{

    private EntityStateStringType  name;
    //{0..1}

    private EntityStateStringType  arch;
    //{0..1}

    private EntityStateAnySimpleType  version;
    //{0..1}


//    private final EntityPropertyMap<LinuxPkgProperty>  _properties =
//        LinuxPkgProperty.createPropertyMap();



    /**
     * Constructor.
     */
    public LinuxPkgInfoState()
    {
        this( null, 0 );
    }


    public LinuxPkgInfoState(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }



//    /**
//     */
//    protected EntityPropertyMap<LinuxPkgProperty> _getProperties()
//    {
//        return _properties;
//    }



    /**
     */
    public void setName(
                    final EntityStateStringType name
                    )
    {
        this.name = name;
//        _setProperty( LinuxPkgProperty.NAME, name );
    }


    public EntityStateStringType getName()
    {
        return this.name;
//        return _getProperty(
//                        LinuxPkgProperty.NAME, EntityStateStringType.class );
    }



    /**
     */
    public void setArch(
                    final EntityStateStringType arch
                    )
    {
        this.arch = arch;
//        _setProperty( LinuxPkgProperty.ARCH, arch );
    }


    public EntityStateStringType getArch()
    {
        return this.arch;
//        return _getProperty(
//                        LinuxPkgProperty.ARCH, EntityStateStringType.class );
    }



    /**
     */
    public void setVersion(
                    final EntityStateAnySimpleType version
                    )
    {
        this.version = version;
//        _setProperty( LinuxPkgProperty.VERSION, version );
    }


    public EntityStateAnySimpleType getVersion()
    {
        return this.version;
//        return _getProperty(
//                        LinuxPkgProperty.VERSION, EntityStateAnySimpleType.class );
    }



    //**************************************************************
    //  State
    //**************************************************************

//    @Override
//    public Iterator<EntityAttributeGroup> iterateProperties()
//    {
//        return _properties.iterateProperties();
//    }



//    /**
//     */
//    protected <T extends EntityAttributeGroup> T _getProperty(
//                    final LinuxPkgProperty key,
//                    final Class<T> type
//                    )
//    {
//        return _properties.getProperty( key, type );
//    }
//
//
//
//    /**
//     */
//    protected void _setProperty(
//                    final LinuxPkgProperty key,
//                    final EntityAttributeGroup value
//                    )
//    {
//        _properties.setProperty( key, value );
//    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return super.toString()
                        + ", name=" + getName()
                        + ", arch=" + getArch()
                        + ", version=" + getVersion()
                        ;
    }

}
// LinuxPkgInfoState
