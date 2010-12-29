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

import jp.go.aist.six.oval.model.PlatformEntityType;
import jp.go.aist.six.oval.model.definitions.EntityStateAnySimple;
import jp.go.aist.six.oval.model.definitions.EntityStateBase;
import jp.go.aist.six.oval.model.definitions.EntityStateInt;
import jp.go.aist.six.oval.model.definitions.EntityStateString;
import jp.go.aist.six.oval.model.definitions.State;
import java.util.EnumMap;
import java.util.Map;



/**
 * The textfilecontent54 state contains entities that are used to check
 * the file path and name, as well as the text block in question
 * and the value of the subexpressions.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class TextFileContent54State
    extends State
{

    protected static enum Property
    {
        FILEPATH,       //{EntityStateString, 0..1}
        PATH,           //{EntityStateString, 0..1}
        FILENAME,       //{EntityStateString, 0..1}
        PATTERN,        //{EntityStateString, 0..1}
        INSTANCE,       //{EntityStateInt, 0..1}
        TEXT,           //{EntityStateAnySimple, 0..1}
        SUBEXPRESSION;  //{EntityStateAnySimple, 0..1}
    }

    private Map<Property, EntityStateBase>  _properties =
        new EnumMap<Property, EntityStateBase>( Property.class );



    /**
     * Constructor.
     */
    public TextFileContent54State()
    {
    }


    /**
     * Constructor.
     */
    public TextFileContent54State(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    /**
     * Constructor.
     */
    public TextFileContent54State(
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
                    final EntityStateString filepath
                    )
    {
        _properties.put( Property.FILEPATH, filepath );
    }


    public TextFileContent54State filepath(
                    final EntityStateString filepath
                    )
    {
        setFilepath( filepath );
        return this;
    }


    public EntityStateString getFilepath()
    {
        return (EntityStateString)_properties.get( Property.FILEPATH );
    }



    /**
     */
    public void setPath(
                    final EntityStateString path
                    )
    {
        _properties.put( Property.PATH, path );
    }


    public TextFileContent54State path(
                    final EntityStateString path
                    )
    {
        setPath( path );
        return this;
    }


    public EntityStateString getPath()
    {
        return (EntityStateString)_properties.get( Property.PATH );
    }



    /**
     */
    public void setFilename(
                    final EntityStateString filename
                    )
    {
        _properties.put( Property.FILENAME, filename );
    }


    public TextFileContent54State filename(
                    final EntityStateString filename
                    )
    {
        setFilename( filename );
        return this;
    }


    public EntityStateString getFilename()
    {
        return (EntityStateString)_properties.get( Property.FILENAME );
    }



    /**
     */
    public void setPattern(
                    final EntityStateString pattern
                    )
    {
        _properties.put( Property.PATTERN, pattern );
    }


    public TextFileContent54State pattern(
                    final EntityStateString pattern
                    )
    {
        setPattern( pattern );
        return this;
    }


    public EntityStateString getPattern()
    {
        return (EntityStateString)_properties.get( Property.PATTERN );
    }



    /**
     */
    public void setInstance(
                    final EntityStateInt instance
                    )
    {
        _properties.put( Property.INSTANCE, instance );
    }


    public TextFileContent54State instance(
                    final EntityStateInt instance
                    )
    {
        setInstance( instance );
        return this;
    }


    public EntityStateInt getInstance()
    {
        return (EntityStateInt)_properties.get( Property.INSTANCE );
    }



    /**
     */
    public void setText(
                    final EntityStateAnySimple text
                    )
    {
        _properties.put( Property.TEXT, text );
    }


    public TextFileContent54State text(
                    final EntityStateAnySimple text
                    )
    {
        setText( text );
        return this;
    }


    public EntityStateAnySimple getText()
    {
        return (EntityStateAnySimple)_properties.get( Property.TEXT );
    }



    /**
     */
    public void setSubexpression(
                    final EntityStateAnySimple subexpression
                    )
    {
        _properties.put( Property.SUBEXPRESSION, subexpression );
    }


    public TextFileContent54State subexpression(
                    final EntityStateAnySimple subexpression
                    )
    {
        setSubexpression( subexpression );
        return this;
    }


    public EntityStateAnySimple getSubexpression()
    {
        return (EntityStateAnySimple)_properties.get( Property.SUBEXPRESSION );
    }



    //**************************************************************
    //  State
    //**************************************************************

    @Override
    public PlatformEntityType getEntityType()
    {
        return PlatformEntityType.INDEPENDENT_TEXTFILECONTENT54;
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
        if (!(obj instanceof TextFileContent54State)) {
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
                        + "]";
    }

}
// TextFileContent54State
