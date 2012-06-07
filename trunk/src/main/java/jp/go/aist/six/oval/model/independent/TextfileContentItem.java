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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import jp.go.aist.six.oval.model.ComponentType;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.sc.EntityItemAnySimpleType;
import jp.go.aist.six.oval.model.sc.EntityItemIntType;
import jp.go.aist.six.oval.model.sc.EntityItemStringType;
import jp.go.aist.six.oval.model.sc.ItemType;



/**
 * The textfilecontent item looks at the contents of a text file
 * (aka a configuration file) by looking at individual lines.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class TextfileContentItem
    extends ItemType
{

    private EntityItemStringType  filepath;
    //{0..1}

    private EntityItemStringType  path;
    //{0..1}

    private EntityItemStringType  filename;
    //{0..1}

    private EntityItemStringType  pattern;
    //{0..1}

    private EntityItemIntType  instance;
    //{0..1}

    private EntityItemStringType  line;
    //{0..1}

    private EntityItemAnySimpleType  text;
    //{0..1}

    private final Collection<EntityItemAnySimpleType>  subexpression =
        new ArrayList<EntityItemAnySimpleType>();
    //{0..1}



    /**
     * Constructor.
     */
    public TextfileContentItem()
    {
        this( 0 );
    }


    public TextfileContentItem(
                    final int id
                    )
    {
        super( id );

//        _oval_platform_type = OvalPlatformType.independent;
//        _oval_component_type = OvalComponentType.textfilecontent;
        _oval_family = Family.INDEPENDENT;
        _oval_component = ComponentType.TEXTFILECONTENT;
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
        return filepath;
    }


    public TextfileContentItem filepath(
                    final EntityItemStringType filepath
                    )
    {
        setFilepath( filepath );
        return this;
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
        return path;
    }


    public TextfileContentItem path(
                    final EntityItemStringType path
                    )
    {
        setPath( path );
        return this;
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
        return filename;
    }


    public TextfileContentItem filename(
                    final EntityItemStringType filename
                    )
    {
        setFilename( filename );
        return this;
    }



    /**
     */
    public void setPattern(
                    final EntityItemStringType pattern
                    )
    {
        this.pattern = pattern;
    }


    public EntityItemStringType getPattern()
    {
        return pattern;
    }


    public TextfileContentItem pattern(
                    final EntityItemStringType pattern
                    )
    {
        setPattern( pattern );
        return this;
    }



    /**
     */
    public void setInstance(
                    final EntityItemIntType instance
                    )
    {
        this.instance = instance;
    }


    public EntityItemIntType getInstance()
    {
        return instance;
    }


    public TextfileContentItem instance(
                    final EntityItemIntType instance
                    )
    {
        setInstance( instance );
        return this;
    }



    /**
     */
    public void setLine(
                    final EntityItemStringType line
                    )
    {
        this.line = line;
    }


    public EntityItemStringType getLine()
    {
        return line;
    }


    public TextfileContentItem line(
                    final EntityItemStringType line
                    )
    {
        setLine( line );
        return this;
    }



    /**
     */
    public void setText(
                    final EntityItemAnySimpleType text
                    )
    {
        this.text = text;
    }


    public EntityItemAnySimpleType getText()
    {
        return text;
    }


    public TextfileContentItem text(
                    final EntityItemAnySimpleType text
                    )
    {
        setText( text );
        return this;
    }



    /**
     */
    public void setSubexpression(
                    final Collection<? extends EntityItemAnySimpleType> subexpression
                    )
    {
        if (this.subexpression != subexpression) {
            this.subexpression.clear();
            if (subexpression != null  &&  subexpression.size() > 0) {
                this.subexpression.addAll( subexpression );
            }
        }
    }


    public Collection<EntityItemAnySimpleType> getSubexpression()
    {
        return subexpression;
    }


    public Iterator<EntityItemAnySimpleType> iterateSubexpression()
    {
        return subexpression.iterator();
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "textfilecontent_item[" + super.toString()
             + ", filepath="        + getFilepath()
             + ", path="            + getPath()
             + ", filename="        + getFilename()
             + ", pattern="         + getPattern()
             + ", instance="        + getInstance()
             + ", line="            + getLine()
             + ", text="            + getText()
             + ", subexpression="   + getSubexpression()
//           + ", " + String.valueOf( _properties )
             + "]";
    }

}
// TextFileContentItem
