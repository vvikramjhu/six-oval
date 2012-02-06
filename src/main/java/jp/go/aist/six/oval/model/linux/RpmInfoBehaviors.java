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

package jp.go.aist.six.oval.model.linux;

import jp.go.aist.six.oval.model.OvalObject;



/**
 * The RpmInfoBehaviors defines a set of behaviors for controlling what data, 
 * for installed rpms, is collected.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class RpmInfoBehaviors
    implements OvalObject
{

    public static final Boolean  DEFAULT_FILEPATHS = Boolean.FALSE;

    //{optional, default='false'}
    private Boolean  filepaths;



    /**
     * Constructor.
     */
    public RpmInfoBehaviors()
    {
    }



    /**
     */
    public void setFilepaths(
                    final Boolean filepaths
                    )
    {
        this.filepaths = filepaths;
    }


    public Boolean getFilepaths()
    {
        return this.filepaths;
    }


    public static boolean filepaths( 
                    final RpmInfoBehaviors behaviors
                    )
    {
        Boolean  filepaths = behaviors.getFilepaths();
        
        return (filepaths == null ? DEFAULT_FILEPATHS.booleanValue() : filepaths.booleanValue());
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        result = prime * result + (filepaths( this ) ? 0 : 1);

        return result;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof RpmInfoBehaviors)) {
            return false;
        }

        if (super.equals( obj )) {
            RpmInfoBehaviors  other = (RpmInfoBehaviors)obj;
            if (filepaths( this ) == filepaths( other )) {
                return true;
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return super.toString()
                        + ", filepaths="    + getFilepaths()
                        ;
    }

}
//RpmInfoBehaviors
