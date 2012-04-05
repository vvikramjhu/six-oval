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

import jp.go.aist.six.oval.model.Component;
import jp.go.aist.six.oval.model.Family;




/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class DefinitionsComponent
    extends DefinitionsElement
{

    private String  comment;
    //{required:TestType}
    //{optional:ObjectType}
    //{optional:StateType}


    protected Family       _oval_family;
    protected Component    _oval_component;



    /**
     * Constructor.
     */
    public DefinitionsComponent()
    {
    }


    /**
     * Constructor.
     */
    public DefinitionsComponent(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    /**
     * Constructor.
     */
    public DefinitionsComponent(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version );
        setComment( comment );
    }



    /**
     */
    public void setComment(
                    final String comment
                    )
    {
        this.comment = comment;
    }


    public String getComment()
    {
        return comment;
    }


    public DefinitionsComponent comment(
                    final String comment
                    )
    {
        setComment( comment );
        return this;
    }

}
//
