/*
 *  @ProductName@
 *  Copyright (C) @CopyrightYear@
 *    National Institute of Advanced Industrial Science and Technology (AIST)
 *    Registration Number: @AISTRegistrationNumber@
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

import jp.go.aist.six.oval.model.EntityType;
import jp.go.aist.six.oval.model.sc.EntityItemAnySimple;
import jp.go.aist.six.oval.model.sc.EntityItemInt;
import jp.go.aist.six.oval.model.sc.EntityItemString;
import jp.go.aist.six.oval.model.sc.Item;
import jp.go.aist.six.oval.model.sc.Status;
import java.util.ArrayList;
import java.util.Collection;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
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

    private EntityItemString  _text;
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

        if (subexpression != null) {
            Collection<EntityItemAnySimple>  subexp = new ArrayList<EntityItemAnySimple>();
            for (String  s : subexpression) {
                subexp.add( new EntityItemAnySimple( s ) );
            }
            setSubexpression( subexp );
        }

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
            setText( new EntityItemString( text ) );
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
                    final EntityItemString text,
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



    public EntityItemString getText()
    {
        return _text;
    }



    public void setText(
                    final EntityItemString text
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


    /**
     */
    public Collection<EntityItemAnySimple> getSubexpression()
    {
        return _subexpression;
    }



    //**************************************************************
    //  Item
    //**************************************************************

    @Override
    public EntityType getEntityType()
    {
        return EntityType.INDEPENDENT_TEXTFILECONTENT;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "TextFileContentItem[" + super.toString()
                        + ", filepath=" + getFilepath()
                        + ", path=" + getPath()
                        + ", filename=" + getFilename()
                        + ", pattern=" + getPattern()
                        + ", line=" + getLine()
                        + ", text=" + getText()
                        + "]";
    }

}
// TextFileContentItem
