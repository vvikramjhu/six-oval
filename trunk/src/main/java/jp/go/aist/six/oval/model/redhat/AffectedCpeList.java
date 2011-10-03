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

package jp.go.aist.six.oval.model.redhat;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import jp.go.aist.six.oval.model.Container;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class AffectedCpeList
    extends Container<Cpe> //{0..* ?}
{

    private final Set<Cpe>  cpe = new HashSet<Cpe>();


    /**
     * Constructor.
     */
    public AffectedCpeList()
    {
    }


    public AffectedCpeList(
                    final Collection<? extends Cpe> cpes
                    )
    {
        super( cpes );
    }


    public AffectedCpeList(
                    final Cpe[] cpes
                    )
    {
        super( cpes );
    }



    /**
     */
    public void setCpe(
                    final Collection<? extends Cpe> cpes
                    )
    {
        _setElement( cpes );
    }


    public boolean addCpe(
                    final Cpe cpe
                    )
    {
        return _addElement( cpe );
    }


    public Collection<Cpe> getCpe()
    {
        return _getElement();
    }


    public Iterator<Cpe> iterateCpe()
    {
        return _iterateElement();
    }



    //**************************************************************
    //  Container
    //**************************************************************

    @Override
    protected Collection<Cpe> _getElement()
    {
        return this.cpe;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

}
// AffectedCpeList