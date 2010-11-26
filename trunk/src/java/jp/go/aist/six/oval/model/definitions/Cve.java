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

package jp.go.aist.six.oval.model.definitions;

import jp.go.aist.six.oval.model.NameEntity;
import java.util.regex.Pattern;




/**
 * A CVE name.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class Cve
    extends NameEntity
{

    /**
     * Constructor.
     */
    public Cve()
    {
    }


    /**
     * Constructor.
     */
    public Cve(
                    final String name
                    )
    {
        super( name );
    }



    public static final String  PATTERN = "CVE-[12]\\d{3}-\\d{4}";

    private Pattern  _pattern = null;

    public void validate(
                    final String name
                    )
    {
        if (_pattern == null) {
            _pattern = Pattern.compile( PATTERN );
        }

        if (_pattern.matcher( name ).matches()) {
            //valid
        } else {
            throw new IllegalArgumentException( "invalid CVE name: " + name );
        }
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof Cve)) {
            return false;
        }

        return super.equals( obj );
    }

}
// Cve
