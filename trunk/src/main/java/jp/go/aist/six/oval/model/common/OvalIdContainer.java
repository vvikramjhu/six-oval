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

package jp.go.aist.six.oval.model.common;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import jp.go.aist.six.oval.model.Container;



/**
 * A container for one or more OVAL IDs.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class OvalIdContainer
    extends Container<OvalId>
{

    private final Set<OvalId>  id = new HashSet<OvalId>();



    /**
     * Constructor.
     */
    public OvalIdContainer()
    {
    }


    public OvalIdContainer(
                    final Collection<OvalId> id_list
                    )
    {
//        super( id_list );

        id.addAll( id_list );
    }


    public OvalIdContainer(
                    final OvalId[] id_list
                    )
    {
//        super( id_list );

        this( Arrays.asList( id_list ) );
    }



    /**
     */
    public void setIds(
                    final Collection<OvalId> id_list
                    )
    {
        _setElement( id_list );
    }


    public void setIds(
                    final OvalId[] id_list
                    )
    {
        _setElement( id_list );
    }


    public Collection<OvalId> getIds()
    {
        return _getElement();
    }


    public Iterator<OvalId> iterateIds()
    {
        return iterator();
    }


    public boolean addId(
                    final OvalId id
                    )
    {
        return _addElement( id );
    }



    //**************************************************************
    //  Container
    //**************************************************************

    @Override
    protected Collection<OvalId> _getElement()
    {
        return id;
    }



    //**************************************************************
    //  java.lang.String
    //**************************************************************

}
//