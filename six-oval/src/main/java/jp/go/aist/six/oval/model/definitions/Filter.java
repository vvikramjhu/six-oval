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

package jp.go.aist.six.oval.model.definitions;

import jp.go.aist.six.oval.model.ElementRef;
import jp.go.aist.six.oval.model.ElementType;
import jp.go.aist.six.oval.model.OvalObject;




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
    implements ElementRef, OvalObject
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
        return content;
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
        return action;
    }


    protected FilterActionEnumeration _action()
    {
        FilterActionEnumeration  action = getAction();
        return (action == null ? DEFAULT_ACTION : action);
    }



    //*********************************************************************
    //  ElementRef
    //*********************************************************************

    public String ovalGetRefId()
    {
        String  state_id = getContent();

        return state_id;
    }



    public ElementType ovalGetRefType()
    {
        return ElementType.STATE;
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

        FilterActionEnumeration  action = _action();
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
            if (this._action() == other._action()) {
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
