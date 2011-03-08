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

package jp.go.aist.six.oval.model.v5.independent;

import java.util.Iterator;
import jp.go.aist.six.oval.model.PlatformEntityType;
import jp.go.aist.six.oval.model.v5.definitions.EntityAttributeGroup;
import jp.go.aist.six.oval.model.v5.definitions.EntityPropertyMap;
import jp.go.aist.six.oval.model.v5.definitions.EntityStateAnySimpleType;
import jp.go.aist.six.oval.model.v5.definitions.EntityStateIntType;
import jp.go.aist.six.oval.model.v5.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.v5.definitions.StateType;



/**
 * The textfilecontent54 state contains entities that are used to check
 * the file path and name, as well as the text block in question
 * and the value of the subexpressions.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class Textfilecontent54StateTmp
    extends StateType
{

    private final EntityPropertyMap<TextfilecontentPropertyTmp>  _properties =
        TextfilecontentPropertyTmp.createPropertyMap();



//    protected static enum Property
//    {
//        FILEPATH,       //{EntityStateString, 0..1}
//        PATH,           //{EntityStateString, 0..1}
//        FILENAME,       //{EntityStateString, 0..1}
//        PATTERN,        //{EntityStateString, 0..1}
//        INSTANCE,       //{EntityStateInt, 0..1}
//        TEXT,           //{EntityStateAnySimple, 0..1}
//        SUBEXPRESSION;  //{EntityStateAnySimple, 0..1}
//    }



    /**
     * Constructor.
     */
    public Textfilecontent54StateTmp()
    {
    }


    public Textfilecontent54StateTmp(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    public Textfilecontent54StateTmp(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );
    }



    /**
     */
    public void setFilepath(
                    final EntityStateStringType filepath
                    )
    {
        _properties.setProperty( TextfilecontentPropertyTmp.FILEPATH, filepath );
    }


    public Textfilecontent54StateTmp filepath(
                    final EntityStateStringType filepath
                    )
    {
        setFilepath( filepath );
        return this;
    }


    public EntityStateStringType getFilepath()
    {
        return _properties.getProperty(
                        TextfilecontentPropertyTmp.FILEPATH, EntityStateStringType.class );
    }



    /**
     */
    public void setPath(
                    final EntityStateStringType path
                    )
    {
        _properties.setProperty( TextfilecontentPropertyTmp.PATH, path );
    }


    public Textfilecontent54StateTmp path(
                    final EntityStateStringType path
                    )
    {
        setPath( path );
        return this;
    }


    public EntityStateStringType getPath()
    {
        return _properties.getProperty(
                        TextfilecontentPropertyTmp.PATH, EntityStateStringType.class );
    }



    /**
     */
    public void setFilename(
                    final EntityStateStringType filename
                    )
    {
        _properties.setProperty( TextfilecontentPropertyTmp.FILENAME, filename );
    }


    public Textfilecontent54StateTmp filename(
                    final EntityStateStringType filename
                    )
    {
        setFilename( filename );
        return this;
    }


    public EntityStateStringType getFilename()
    {
        return _properties.getProperty(
                        TextfilecontentPropertyTmp.FILENAME, EntityStateStringType.class );
    }



    /**
     */
    public void setPattern(
                    final EntityStateStringType pattern
                    )
    {
        _properties.setProperty( TextfilecontentPropertyTmp.PATTERN, pattern );
    }


    public Textfilecontent54StateTmp pattern(
                    final EntityStateStringType pattern
                    )
    {
        setPattern( pattern );
        return this;
    }


    public EntityStateStringType getPattern()
    {
        return _properties.getProperty(
                        TextfilecontentPropertyTmp.PATTERN, EntityStateStringType.class );
    }



    /**
     */
    public void setInstance(
                    final EntityStateIntType instance
                    )
    {
        _properties.setProperty( TextfilecontentPropertyTmp.INSTANCE, instance );
    }


    public Textfilecontent54StateTmp instance(
                    final EntityStateIntType instance
                    )
    {
        setInstance( instance );
        return this;
    }


    public EntityStateIntType getInstance()
    {
        return _properties.getProperty(
                        TextfilecontentPropertyTmp.INSTANCE, EntityStateIntType.class );
    }



    /**
     */
    public void setText(
                    final EntityStateAnySimpleType text
                    )
    {
        _properties.setProperty( TextfilecontentPropertyTmp.TEXT, text );
    }


    public Textfilecontent54StateTmp text(
                    final EntityStateAnySimpleType text
                    )
    {
        setText( text );
        return this;
    }


    public EntityStateAnySimpleType getText()
    {
        return _properties.getProperty(
                        TextfilecontentPropertyTmp.TEXT, EntityStateAnySimpleType.class );
    }



    /**
     */
    public void setSubexpression(
                    final EntityStateAnySimpleType subexpression
                    )
    {
        _properties.setProperty( TextfilecontentPropertyTmp.SUBEXPRESSION, subexpression );
    }


    public Textfilecontent54StateTmp subexpression(
                    final EntityStateAnySimpleType subexpression
                    )
    {
        setSubexpression( subexpression );
        return this;
    }


    public EntityStateAnySimpleType getSubexpression()
    {
        return _properties.getProperty(
                        TextfilecontentPropertyTmp.SUBEXPRESSION, EntityStateAnySimpleType.class );
    }



    //**************************************************************
    //  State
    //**************************************************************

    @Override
    public PlatformEntityType getEntityType()
    {
        return PlatformEntityType.INDEPENDENT_TEXTFILECONTENT54;
    }



    @Override
    public Iterator<EntityAttributeGroup> iterateProperties()
    {
        return _properties.iterateProperties();
    }



//    protected <T extends EntityStateBase> T _getProperty(
//                    final Property key,
//                    final Class<T> type
//                    )
//    {
//        EntityBase  p = _properties.get( key );
//        return type.cast( p );
//    }
//
//
//
//    protected void _setProperty(
//                    final Property key,
//                    final EntityStateBase value
//                    )
//    {
//        _properties.put( key, value );
//    }



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
        if (!(obj instanceof Textfilecontent54StateTmp)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "textfilecontent54_state[" + super.toString()
                        + ", " + String.valueOf( _properties )
//                        + ", filepath="      + getFilepath()
//                        + ", path="          + getPath()
//                        + ", filename="      + getFilename()
//                        + ", pattern="       + getPattern()
//                        + ", instance="      + getInstance()
//                        + ", text="          + getText()
//                        + ", subexpression=" + getSubexpression()
                        + "]";
    }

}
// TextFileContent54State
