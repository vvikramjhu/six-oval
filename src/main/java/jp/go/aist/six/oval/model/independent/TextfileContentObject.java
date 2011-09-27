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
import jp.go.aist.six.oval.model.PlatformEntityType;
import jp.go.aist.six.oval.model.definitions.EntityObjectStringType;
import jp.go.aist.six.oval.model.definitions.Set;
import jp.go.aist.six.oval.model.definitions.SystemObjectType;



/**
 * The textfilecontent object is used by a text file content test
 * to define the specific line(s) of a file(s) to be evaluated.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 * @deprecated Deprecated as of version 5.4:
 *             Replaced by the textfilecontent54 object and
 *             will be removed in a future version of the language.
 */
@Deprecated
public class TextfileContentObject
    extends SystemObjectType
{
    // XSD model:
    // choice(
    //         set
    //         sequence(
    //                   behaviors
    //                   path
    //                   filename
    //                   line
    //          )
    // )

    private Set  set;
    //{1..1}


    private FileBehaviors  behaviors;
    //{0..1}


    private EntityObjectStringType  path;
    //{1..1}

    private EntityObjectStringType  filename;
    //{1..1}


    private EntityObjectStringType  line;
    //{1..1}



    /**
     * Constructor.
     */
    public TextfileContentObject()
    {
        this( null, 0 );
    }


    public TextfileContentObject(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public TextfileContentObject(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

        _oval_platform_type = OvalPlatformType.independent;
        _oval_component_type = OvalComponentType.textfilecontent;
    }


//    public TextfileContent54Object(
//                    final String id,
//                    final int version,
//                    final String path,
//                    final String filename,
//                    final String pattern,
//                    final String instance
//                    )
//    {
//        this( id, version,
//                        (path == null     ? null : new EntityObjectStringType( path )),
//                        (filename == null ? null : new EntityObjectStringType( filename )),
//                        (pattern == null  ? null : new EntityObjectStringType( pattern )),
//                        (instance == null ? null : new EntityObjectIntType( instance ))
//                        );
//    }
//
//
//    public TextfileContent54Object(
//                    final String id,
//                    final int version,
//                    final EntityObjectStringType path,
//                    final EntityObjectStringType filename,
//                    final EntityObjectStringType pattern,
//                    final EntityObjectIntType instance
//                    )
//    {
//        super( id, version );
//        setPath( path );
//        setFilename( filename );
//        setPattern( pattern );
//        setInstance( instance );
//    }



    /**
     */
    public void setSet(
                    final Set set
                    )
    {
        this.set = set;
    }


    public Set getSet()
    {
        return this.set;
    }



    /**
     */
    public void setBehaviors(
                    final FileBehaviors behaviors
                    )
    {
        this.behaviors = behaviors;
    }


    public FileBehaviors getBehaviors()
    {
        return this.behaviors;
    }



    /**
     */
    public void setPath(
                    final EntityObjectStringType path
                    )
    {
        this.path = path;
    }


    public EntityObjectStringType getPath()
    {
        return path;
    }



    /**
     */
    public void setFilename(
                    final EntityObjectStringType filename
                    )
    {
        this.filename = filename;
    }


    public EntityObjectStringType getFilename()
    {
        return this.filename;
    }



    /**
     */
    public void setLine(
                    final EntityObjectStringType line
                    )
    {
        this.line = line;
    }


    public EntityObjectStringType getLine()
    {
        return this.line;
    }



    //**************************************************************
    //  SystemObject
    //**************************************************************

    @Override
    public PlatformEntityType getEntityType()
    {
        return PlatformEntityType.INDEPENDENT_TEXTFILECONTENT;
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
        if (!(obj instanceof TextfileContentObject)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "textfilecontent_object[" + super.toString()
                        + ", set=" + getSet()
                        + ", behaviors=" + getBehaviors()
                        + ", path=" + getPath()
                        + ", filename=" + getFilename()
                        + ", line=" + getLine()
                        + "]";
    }

}
// TextfileContentObject
