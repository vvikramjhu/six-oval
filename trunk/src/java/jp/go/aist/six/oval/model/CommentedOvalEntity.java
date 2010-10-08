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

package jp.go.aist.six.oval.model;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public abstract class CommentedOvalEntity
    extends OvalEntity
{

    private String  _comment;



    /**
     * Constructor.
     */
    public CommentedOvalEntity()
    {
    }


    /**
     * Constructor.
     */
    public CommentedOvalEntity(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    /**
     * Constructor.
     */
    public CommentedOvalEntity(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version );
        setComment( comment );
    }



    public CommentedOvalEntity comment(
                    final String comment
                    )
    {
        setComment( comment );
        return this;
    }


    public void setComment(
                    final String comment
                    )
    {
        _comment = comment;
    }


    public String getComment()
    {
        return _comment;
    }

}
// CommentedOvalEntity
