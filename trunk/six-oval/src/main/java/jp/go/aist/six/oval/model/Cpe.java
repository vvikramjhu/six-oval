/*
 *  @product.title@
 *  Copyright (C) @product.copyright-year@
 *    @product.vendor@
 *    Registration Number: @product.registration-number@
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.go.aist.six.oval.model;



/**
 * A CPE name.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class Cpe
    extends Name
    implements Comparable<Cpe>
{

//    @Property( "cpe" )
//    private String  name;



    /**
     * Constructor.
     */
    public Cpe()
    {
    }


    public Cpe(
                    final String name
                    )
    {
        super( name );
    }



    //**************************************************************
    //  Comparable
    //**************************************************************

    public int compareTo(
                    final Cpe o
                    )
    {
        return String.CASE_INSENSITIVE_ORDER.compare( getName(), o.getName() );
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
        if (!(obj instanceof Cpe)) {
            return false;
        }

        return super.equals( obj );
    }

}
// Cpe
