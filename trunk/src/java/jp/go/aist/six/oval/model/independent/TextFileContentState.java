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
import jp.go.aist.six.oval.model.definitions.EntityBase;
import jp.go.aist.six.oval.model.definitions.EntityStateAnySimple;
import jp.go.aist.six.oval.model.definitions.EntityStateString;
import jp.go.aist.six.oval.model.definitions.State;
import java.util.EnumMap;
import java.util.Iterator;



/**
 * The textfilecontent_state element contains entities that are used
 * to check the file path and name, as well as the line in question
 * and the value of the specific subexpression.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 * @deprecated Deprecated as of version 5.4:
 *             Replaced by the textfilecontent54 state and
 *             will be removed in version 6.0 of the language.
 */
public class TextFileContentState
    extends State
{

    protected static enum Property
    {
        PATH,           //{EntityStateString, 0..1}
        FILENAME,       //{EntityStateString, 0..1}
        LINE,        //{EntityStateString, 0..1}
        SUBEXPRESSION;  //{EntityStateAnySimple, 0..1}
    }

    private EnumMap<Property, EntityBase>  _properties =
        new EnumMap<Property, EntityBase>( Property.class );



//    private EntityStateString  _path;
//    //{0..1}
//
//    private EntityStateString  _filename;
//    //{0..1}
//
//    private EntityStateString  _line;
//    //{0..1}
//
//    private EntityStateAnySimple  _subexpression;
//    //{0..1}



    /**
     * Constructor.
     */
    public TextFileContentState()
    {
    }


    /**
     * Constructor.
     */
    public TextFileContentState(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }



    /**
     */
    public void setPath(
                    final EntityStateString path
                    )
    {
        _properties.put( Property.PATH, path );
    }



    public TextFileContentState path(
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


    public TextFileContentState filename(
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
    public void setLine(
                    final EntityStateString line
                    )
    {
        _properties.put( Property.LINE, line );
    }


    public TextFileContentState line(
                    final EntityStateString line
                    )
    {
        setLine( line );
        return this;
    }


    public EntityStateString getLine()
    {
        return (EntityStateString)_properties.get( Property.LINE );
    }



    /**
     */
    public void setSubexpression(
                    final EntityStateAnySimple subexpression
                    )
    {
        _properties.put( Property.SUBEXPRESSION, subexpression );
    }


    public TextFileContentState subexpression(
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
        return PlatformEntityType.INDEPENDENT_TEXTFILECONTENT;
    }



    @Override
    public Iterator<EntityBase> iterateProperties()
    {
        return _properties.values().iterator();
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
        if (!(obj instanceof TextFileContentState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "textfilecontent_state[" + super.toString() + "]";
    }

}
// TextFileContentState
