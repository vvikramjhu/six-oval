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

package jp.go.aist.six.oval.model.independent;

import jp.go.aist.six.oval.model.OvalComponentType;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.sc.EntityItemStringType;
import jp.go.aist.six.oval.model.sc.ItemType;



/**
 * The filehash item stores the different hash values associated with a specific file.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 * @deprecated Deprecated as of version 5.8:
 *             Replaced by the filehash58 item and
 *             will be removed in a future version of the language.
 */
@Deprecated
public class FileHashItem
    extends ItemType
{

    private EntityItemStringType  filepath;
    //{0..1}

    private EntityItemStringType  path;
    //{0..1}

    private EntityItemStringType  filename;
    //{0..1}

    private EntityItemStringType  md5;
    //{0..1}

    private EntityItemStringType  sha1;
    //{0..1}


    private EntityItemWindowsViewType  windows_view;
    //{0..1}



    /**
     * Constructor.
     */
    public FileHashItem()
    {
        this( 0 );
    }


    public FileHashItem(
                    final int id
                    )
    {
        super( id );

        _oval_platform_type = OvalPlatformType.independent;
        _oval_component_type = OvalComponentType.filehash;
    }



    /**
     */
    public void setFilepath(
                    final EntityItemStringType filepath
                    )
    {
        this.filepath = filepath;
    }


    public EntityItemStringType getFilepath()
    {
        return this.filepath;
    }



    /**
     */
    public void setPath(
                    final EntityItemStringType path
                    )
    {
        this.path = path;
    }


    public EntityItemStringType getPath()
    {
        return this.path;
    }



    /**
     */
    public void setFilename(
                    final EntityItemStringType filename
                    )
    {
        this.filename = filename;
    }


    public EntityItemStringType getFilename()
    {
        return this.filename;
    }



    /**
     */
    public void setMd5(
                    final EntityItemStringType md5
                    )
    {
        this.md5 = md5;
    }


    public EntityItemStringType getMd5()
    {
        return this.md5;
    }



    /**
     */
    public void setSha1(
                    final EntityItemStringType sha1
                    )
    {
        this.sha1 = sha1;
    }


    public EntityItemStringType getSha1()
    {
        return this.sha1;
    }



    /**
     */
    public void setWindowsView(
                    final EntityItemWindowsViewType windows_view
                    )
    {
        this.windows_view = windows_view;
    }


    public EntityItemWindowsViewType getWindowsView()
    {
        return this.windows_view;
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
        if (!(obj instanceof FileHashItem)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "filehash_item[" + super.toString()
                        + ", filepath="     + getFilepath()
                        + ", path="         + getPath()
                        + ", filename="     + getFilename()
                        + ", md5="          + getMd5()
                        + ", sha1="         + getSha1()
                        + ", windows_view=" + getWindowsView()
                        + "]";
    }

}
// FileHashState
