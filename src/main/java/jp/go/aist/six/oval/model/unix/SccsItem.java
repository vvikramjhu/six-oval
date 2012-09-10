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

package jp.go.aist.six.oval.model.unix;

import jp.go.aist.six.oval.model.ComponentType;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.sc.ItemType;
import jp.go.aist.six.oval.model.sc.StatusEnumeration;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 * @deprecated Deprecated as of version 5.10:
 *             The Source Code Control System (SCCS) is obsolete.
 *             The sccs_test may be removed in a future version of the language.
 */
@Deprecated
public class SccsItem
    extends ItemType
{

    //{0..1}
    private EntityStateStringType   filepath;
    private EntityStateStringType   path;
    private EntityStateStringType   filename;
    private EntityStateStringType   module_name;
    private EntityStateStringType   module_type;
    private EntityStateStringType   release;
    private EntityStateStringType   level;
    private EntityStateStringType   branch;
    private EntityStateStringType   sequence;
    private EntityStateStringType   what_string;



    /**
     * Constructor.
     */
    public SccsItem()
    {
        this( 0 );
    }


    public SccsItem(
                    final int id
                    )
    {
        this( id, null );
    }


    public SccsItem(
                    final int id,
                    final StatusEnumeration status
                    )
    {
        super( id, status );

        _oval_family = Family.UNIX;
        _oval_component = ComponentType.SCCS;
    }



    /**
     */
    public void setFilepath(
                    final EntityStateStringType filepath
                    )
    {
        this.filepath = filepath;
    }


    public EntityStateStringType getFilepath()
    {
        return filepath;
    }



    /**
     */
    public void setPath(
                    final EntityStateStringType path
                    )
    {
        this.path = path;
    }


    public EntityStateStringType getPath()
    {
        return path;
    }



    /**
     */
    public void setFilename(
                    final EntityStateStringType filename
                    )
    {
        this.filename = filename;
    }


    public EntityStateStringType getFilename()
    {
        return filename;
    }



    /**
     */
    public void setModuleName(
                    final EntityStateStringType module_name
                    )
    {
        this.module_name = module_name;
    }


    public EntityStateStringType getModuleName()
    {
        return module_name;
    }



    /**
     */
    public void setModuleType(
                    final EntityStateStringType module_type
                    )
    {
        this.module_type = module_type;
    }


    public EntityStateStringType getModuleType()
    {
        return module_type;
    }



    /**
     */
    public void setRelease(
                    final EntityStateStringType release
                    )
    {
        this.release = release;
    }


    public EntityStateStringType getRelease()
    {
        return release;
    }



    /**
     */
    public void setLevel(
                    final EntityStateStringType level
                    )
    {
        this.level = level;
    }


    public EntityStateStringType getLevel()
    {
        return level;
    }



    /**
     */
    public void setBranch(
                    final EntityStateStringType branch
                    )
    {
        this.branch = branch;
    }


    public EntityStateStringType getBranch()
    {
        return branch;
    }



    /**
     */
    public void setSequence(
                    final EntityStateStringType sequence
                    )
    {
        this.sequence = sequence;
    }


    public EntityStateStringType getSequence()
    {
        return sequence;
    }



    /**
     */
    public void setWhatString(
                    final EntityStateStringType what_string
                    )
    {
        this.what_string = what_string;
    }


    public EntityStateStringType getWhatString()
    {
        return what_string;
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
        if (!(obj instanceof SccsItem)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "sccs_item[" + super.toString()
                        + ", filepath="        + getFilepath()
                        + ", path="            + getPath()
                        + ", filename="        + getFilename()
                        + ", module_name="     + getModuleName()
                        + ", module_type="     + getModuleType()
                        + ", release="         + getRelease()
                        + ", level="           + getLevel()
                        + ", branch="          + getBranch()
                        + ", sequence="        + getSequence()
                        + ", what_string="     + getWhatString()
             + "]";
    }

}
//
