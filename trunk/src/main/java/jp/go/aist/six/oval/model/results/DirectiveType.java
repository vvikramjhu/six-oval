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

package jp.go.aist.six.oval.model.results;

import jp.go.aist.six.oval.model.OvalObject;




/**
 * An individual directive element determines whether or not
 * a specific type of result is included in the results document.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class DirectiveType
    implements OvalObject
//    implements Dependent<SystemResult>
{

    private boolean  reported;
    //{required}


    public static final ContentEnumeration  DEFAULT_CONTENT =
        ContentEnumeration.FULL;

    private ContentEnumeration  content;
    //{optional, default="full"}



    /**
     * Constructor.
     */
    public DirectiveType()
    {
    }


    public DirectiveType(
                    final boolean reported
                    )
    {
        setReported( reported );
    }



    /**
     */
    public void setReported(
                    final boolean reported
                    )
    {
        this.reported = reported;
    }


    public boolean isReported()
    {
        return reported;
    }



    /**
     */
    public void setContent(
                    final ContentEnumeration content
                    )
    {
        this.content = content;
    }


    public ContentEnumeration getContent()
    {
        return content;
    }



    // **************************************************************
    // java.lang.Object
    // **************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        result = prime * result + (isReported() ? 0 : 1);

        ContentEnumeration  content = getContent();
        result = prime * result + ((content == null) ? 0 : content.hashCode());

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

        if (!(obj instanceof DirectiveType)) {
            return false;
        }

        DirectiveType  other = (DirectiveType)obj;
        if (this.getContent() == other.getContent()) {
            if (this.isReported() == other.isReported()) {
                return true;
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return "[reported=" + isReported()
                        + ", content=" + getContent()
                        + "]";
    }

}
// DirecitiveType
