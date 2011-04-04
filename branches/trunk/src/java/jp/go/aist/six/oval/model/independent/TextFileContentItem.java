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
import jp.go.aist.six.oval.model.sc.EntityItemAnySimple;
import jp.go.aist.six.oval.model.sc.EntityItemInt;
import jp.go.aist.six.oval.model.sc.EntityItemString;
import jp.go.aist.six.oval.model.sc.Item;
import jp.go.aist.six.oval.model.sc.Status;
import java.util.ArrayList;
import java.util.Collection;



/**
 * The textfilecontent_item looks at the contents of a text file
 * (aka a configuration file) by looking at individual lines.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class TextFileContentItem
    extends Item
{

    private EntityItemString  _filepath;
    //{0..1}

    private EntityItemString  _path;
    //{0..1}

    private EntityItemString  _filename;
    //{0..1}

    private EntityItemString  _pattern;
    //{0..1}

    private EntityItemInt  _instance;
    //{0..1}

    private EntityItemString  _line;
    //{0..1}

    private EntityItemAnySimple  _text;
    //{0..1}

    private Collection<EntityItemAnySimple>  _subexpression = new ArrayList<EntityItemAnySimple>();
    //{0..*}



    /**
     * Constructor.
     */
    public TextFileContentItem()
    {
    }


    /**
     * Constructor.
     */
    public TextFileContentItem(
                    final int id
                    )
    {
        super( id );
    }


    /**
     * Constructor.
     */
    public TextFileContentItem(
                    final int id,
                    final Status status
                    )
    {
        super( id, status );
    }


    /**
     * Constructor.
     */
    public TextFileContentItem(
                    final int id,
                    final Status status,
                    final String filepath,
                    final String path,
                    final String filename,
                    final String pattern,
                    final String instance,  //int
                    final String line,
                    final String text,
                    final Collection<String> subexpression
                    )
    {
        this( id, status );

        if (filepath != null) {
            setFilepath( new EntityItemString( filepath ) );
        }

        if (path != null) {
            setPath( new EntityItemString( path ) );
        }

        if (filename != null) {
            setFilename( new EntityItemString( filename ) );
        }

        if (pattern != null) {
            setPattern( new EntityItemString( pattern ) );
        }

        if (instance != null) {
            setInstance( new EntityItemInt( instance ) );
        }

        if (line != null) {
            setLine( new EntityItemString( line ) );
        }

        if (text != null) {
            setText( new EntityItemAnySimple( text ) );
        }

        if (subexpression != null) {
            Collection<EntityItemAnySimple>  subexp = new ArrayList<EntityItemAnySimple>();
            for (String  s : subexpression) {
                subexp.add( new EntityItemAnySimple( s ) );
            }
            setSubexpression( subexp );
        }
    }


    /**
     * Constructor.
     */
    public TextFileContentItem(
                    final int id,
                    final Status status,
                    final EntityItemString filepath,
                    final EntityItemString path,
                    final EntityItemString filename,
                    final EntityItemString pattern,
                    final EntityItemInt instance,
                    final EntityItemString line,
                    final EntityItemAnySimple text,
                    final Collection<? extends EntityItemAnySimple> subexpression
                    )
    {
        this( id, status );
        setFilepath( filepath );
        setPath( path );
        setFilename( filename );
        setPattern( pattern );
        setInstance( instance );
        setLine( line );
        setText( text );
        setSubexpression( subexpression );
    }



    public EntityItemString getFilepath()
    {
        return _filepath;
    }


    public void setFilepath(
                    final EntityItemString filepath
                    )
    {
        _filepath = filepath;
    }



    /**
     */
    public EntityItemString getPath()
    {
        return _path;
    }


    public void setPath(
                    final EntityItemString path
                    )
    {
        _path = path;
    }


    public TextFileContentItem path(
                    final String path
                    )
    {
        setPath( new EntityItemString( path ) );
        return this;
    }



    /**
     */
    public EntityItemString getFilename()
    {
        return _filename;
    }


    public void setFilename(
                    final EntityItemString filename
                    )
    {
        _filename = filename;
    }


    public TextFileContentItem filename(
                    final String filename
                    )
    {
        setFilename( new EntityItemString( filename ) );
        return this;
    }



    public EntityItemString getPattern()
    {
        return _pattern;
    }


    public void setPattern(
                    final EntityItemString pattern
                    )
    {
        _pattern = pattern;
    }



    /**
     */
    public void setInstance(
                    final EntityItemInt instance
                    )
    {
        _instance = instance;
    }


    /**
     */
    public EntityItemInt getInstance()
    {
        return _instance;
    }



    /**
     */
    public EntityItemString getLine()
    {
        return _line;
    }


    public void setLine(
                    final EntityItemString line
                    )
    {
        _line = line;
    }


    public TextFileContentItem line(
                    final String line
                    )
    {
        setLine( new EntityItemString( line ) );
        return this;
    }



    /**
     */
    public EntityItemAnySimple getText()
    {
        return _text;
    }


    public void setText(
                    final EntityItemAnySimple text
                    )
    {
        _text = text;
    }



    /**
     */
    public void setSubexpression(
                    final Collection<? extends EntityItemAnySimple> subexpression
                    )
    {
        _subexpression.clear();
        if (subexpression != null) {
            _subexpression.addAll( subexpression );
        }
    }


    public Collection<EntityItemAnySimple> getSubexpression()
    {
        return _subexpression;
    }



    //**************************************************************
    //  Item
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
    public String toString()
    {
        return "textfilecontent_item[" + super.toString()
                        + ", filepath=" + getFilepath()
                        + ", path=" + getPath()
                        + ", filename=" + getFilename()
                        + ", pattern=" + getPattern()
                        + ", instance=" + getInstance()
                        + ", line=" + getLine()
                        + ", text=" + getText()
                        + ", subexpression=" + getSubexpression()
                        + "]";
    }

}
// TextFileContentItem
