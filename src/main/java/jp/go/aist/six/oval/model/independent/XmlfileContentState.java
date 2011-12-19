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
import jp.go.aist.six.oval.model.definitions.EntityStateAnySimpleType;
import jp.go.aist.six.oval.model.definitions.EntityStateIntType;
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.definitions.StateType;



/**
 * The textfilecontent54 state contains entities that are used to check
 * the file path and name, as well as the text block in question
 * and the value of the subexpressions.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class TextfileContent54State
    extends StateType
{

    private EntityStateStringType  filepath;
    //{0..1}

    private EntityStateStringType  path;
    //{0..1}

    private EntityStateStringType  filename;
    //{0..1}

    private EntityStateStringType  pattern;
    //{0..1}

    private EntityStateIntType  instance;
    //{0..1}

    private EntityStateAnySimpleType  text;
    //{0..1}

    private EntityStateAnySimpleType  subexpression;
    //{0..1}


//    private final EntityPropertyMap<TextfileContentProperty>  _properties =
//        TextfileContentProperty.createPropertyMap();



    /**
     * Constructor.
     */
    public TextfileContent54State()
    {
        this( null, 0 );
    }


    public TextfileContent54State(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public TextfileContent54State(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

        _oval_platform_type = OvalPlatformType.independent;
        _oval_component_type = OvalComponentType.textfilecontent54;
    }



    /**
     */
    public void setFilepath(
                    final EntityStateStringType filepath
                    )
    {
        this.filepath = filepath;
//        _properties.setProperty( TextfileContentProperty.FILEPATH, filepath );
    }


    public EntityStateStringType getFilepath()
    {
        return this.filepath;
//        return _properties.getProperty(
//                        TextfileContentProperty.FILEPATH, EntityStateStringType.class );
    }


    public TextfileContent54State filepath(
                    final EntityStateStringType filepath
                    )
    {
        setFilepath( filepath );
        return this;
    }



    /**
     */
    public void setPath(
                    final EntityStateStringType path
                    )
    {
        this.path = path;
//        _properties.setProperty( TextfileContentProperty.PATH, path );
    }


    public EntityStateStringType getPath()
    {
        return this.path;
//        return _properties.getProperty(
//                        TextfileContentProperty.PATH, EntityStateStringType.class );
    }


    public TextfileContent54State path(
                    final EntityStateStringType path
                    )
    {
        setPath( path );
        return this;
    }



    /**
     */
    public void setFilename(
                    final EntityStateStringType filename
                    )
    {
        this.filename = filename;
//        _properties.setProperty( TextfileContentProperty.FILENAME, filename );
    }


    public EntityStateStringType getFilename()
    {
        return this.filename;
//        return _properties.getProperty(
//                        TextfileContentProperty.FILENAME, EntityStateStringType.class );
    }


    public TextfileContent54State filename(
                    final EntityStateStringType filename
                    )
    {
        setFilename( filename );
        return this;
    }



    /**
     */
    public void setPattern(
                    final EntityStateStringType pattern
                    )
    {
        this.pattern = pattern;
//        _properties.setProperty( TextfileContentProperty.PATTERN, pattern );
    }


    public EntityStateStringType getPattern()
    {
        return this.pattern;
//        return _properties.getProperty(
//                        TextfileContentProperty.PATTERN, EntityStateStringType.class );
    }


    public TextfileContent54State pattern(
                    final EntityStateStringType pattern
                    )
    {
        setPattern( pattern );
        return this;
    }



    /**
     */
    public void setInstance(
                    final EntityStateIntType instance
                    )
    {
        this.instance = instance;
//        _properties.setProperty( TextfileContentProperty.INSTANCE, instance );
    }


    public EntityStateIntType getInstance()
    {
        return this.instance;
//        return _properties.getProperty(
//                        TextfileContentProperty.INSTANCE, EntityStateIntType.class );
    }


    public TextfileContent54State instance(
                    final EntityStateIntType instance
                    )
    {
        setInstance( instance );
        return this;
    }



    /**
     */
    public void setText(
                    final EntityStateAnySimpleType text
                    )
    {
        this.text = text;
//        _properties.setProperty( TextfileContentProperty.TEXT, text );
    }


    public EntityStateAnySimpleType getText()
    {
        return this.text;
//        return _properties.getProperty(
//                        TextfileContentProperty.TEXT, EntityStateAnySimpleType.class );
    }


    public TextfileContent54State text(
                    final EntityStateAnySimpleType text
                    )
    {
        setText( text );
        return this;
    }



    /**
     */
    public void setSubexpression(
                    final EntityStateAnySimpleType subexpression
                    )
    {
        this.subexpression = subexpression;
//        _properties.setProperty( TextfileContentProperty.SUBEXPRESSION, subexpression );
    }


    public EntityStateAnySimpleType getSubexpression()
    {
        return this.subexpression;
//        return _properties.getProperty(
//                        TextfileContentProperty.SUBEXPRESSION, EntityStateAnySimpleType.class );
    }


    public TextfileContent54State subexpression(
                    final EntityStateAnySimpleType subexpression
                    )
    {
        setSubexpression( subexpression );
        return this;
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
        if (!(obj instanceof TextfileContent54State)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "textfilecontent54_state[" + super.toString()
                        + ", filepath="      + getFilepath()
                        + ", path="          + getPath()
                        + ", filename="      + getFilename()
                        + ", pattern="       + getPattern()
                        + ", instance="      + getInstance()
                        + ", text="          + getText()
                        + ", subexpression=" + getSubexpression()
//                        + ", " + String.valueOf( _properties )
                        + "]";
    }

}
// TextFileContent54State
