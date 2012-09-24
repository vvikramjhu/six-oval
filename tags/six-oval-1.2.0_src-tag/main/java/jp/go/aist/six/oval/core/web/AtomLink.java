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

package jp.go.aist.six.oval.core.web;

import java.io.Serializable;



/**
 * A helper class for feeds.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class AtomLink
    implements Serializable
{

    private String  _href;
    //attribute {1..1, atomUri}

    private String  _rel;
    //attribute {0..1}

    private String  _type;
    //{0..1, MIME media type}

    private String  _title;
    //{0..1}



    /**
     * Constructor.
     */
    public AtomLink()
    {
    }



    /**
     */
    public void setHref(
                    final String href
                    )
    {
        _href = href;
    }


    public String getHref()
    {
        return _href;
    }



    /**
     */
    public void setRel(
                    final String rel
                    )
    {
        _rel = rel;
    }


    public String getRel()
    {
        return _rel;
    }



    /**
     */
    public void setType(
                    final String type
                    )
    {
        _type = type;
    }


    public String getType()
    {
        return _type;
    }



    /**
     */
    public void setTitle(
                    final String title
                    )
    {
        _title = title;
    }


    public String getTitle()
    {
        return _title;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "AtomLink[href=" + getHref()
             + ", rel=" + getRel()
             + ", type=" + getType()
             + ", title=" + getTitle()
             + "]"
             ;
    }

}
// AtomFeed
