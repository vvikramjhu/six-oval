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

package jp.go.aist.six.oval.model.v5.definitions;




/**
 * The Filter provides a reference to an existing OVAL State
 * and includes an optional action property.
 * The action property is used to specify whether items
 * that match the referenced OVAL State will be included in the resulting set
 * or excluded from the resulting set.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class Filter
//    extends AbstractOvalObject
{

    private String  content;
    //{simpleContent, base="oval:StateIDPattern"}


    public static final FilterActionEnumeration  DEFAULT_ACTION =
        FilterActionEnumeration.EXCLUDE;

    private FilterActionEnumeration  action;
    //{optional, default='exclude'}



    /**
     * Constructor.
     */
    public Filter()
    {
    }


    public Filter(
                    final String content
                    )
    {
        this( content, DEFAULT_ACTION );
    }


    public Filter(
                    final String content,
                    final FilterActionEnumeration action
                    )
    {
        setContent( content );
        setAction( action );
    }



    /**
     */
    public void setContent(
                    final String content
                    )
    {
        this.content = content;
    }


    public String getContent()
    {
        return this.content;
    }



    /**
     */
    public void setAction(
                    final FilterActionEnumeration action
                    )
    {
        this.action = action;
    }


    public FilterActionEnumeration getAction()
    {
        return this.action;
    }


    public FilterActionEnumeration action()
    {
        FilterActionEnumeration  action = getAction();
        return (action == null ? DEFAULT_ACTION : action);
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        String  content = getContent();
        result = prime * result + ((content == null) ? 0 : content.hashCode());

        FilterActionEnumeration  action = getAction();
        result = prime * result + ((action == null) ? 0 : action.hashCode());

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

        if (!(obj instanceof Filter)) {
            return false;
        }

        Filter  other = (Filter)obj;
        String  otherContent = other.getContent();
        String   thisContent =  this.getContent();
        if (thisContent == otherContent
                        ||  (thisContent != null  &&  thisContent.equals( otherContent ))) {
            if (this.action() == other.action()) {
                return true;
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "filter[" + getContent()
                        + ", action=" + getAction()
                        + "]";
    }

}
// Filter
