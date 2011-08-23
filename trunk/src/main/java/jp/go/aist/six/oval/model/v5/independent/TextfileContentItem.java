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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import jp.go.aist.six.oval.model.OvalComponentType;
import jp.go.aist.six.oval.model.OvalPlatformType;
import jp.go.aist.six.oval.model.v5.PlatformEntityType;
import jp.go.aist.six.oval.model.v5.sc.EntityItemAnySimpleType;
import jp.go.aist.six.oval.model.v5.sc.EntityItemIntType;
import jp.go.aist.six.oval.model.v5.sc.EntityItemStringType;
import jp.go.aist.six.oval.model.v5.sc.ItemType;



/**
 * The textfilecontent54 state contains entities that are used to check
 * the file path and name, as well as the text block in question
 * and the value of the subexpressions.
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

        _oval_platform_type = OvalPlatformType.independent;
        _oval_component_type = OvalComponentType.textfilecontent;
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
        return this.path;
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
        return this.filename;
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
        return this.pattern;
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
        return this.instance;
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
        return this.line;
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
        return this.text;
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
        return this.subexpression;
    }


    public Iterator<EntityItemAnySimpleType> iterateSubexpression()
    {
        return this.subexpression.iterator();
    }



    //**************************************************************
    //  Item
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
