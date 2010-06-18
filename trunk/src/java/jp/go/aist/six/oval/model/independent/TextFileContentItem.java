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

import jp.go.aist.six.oval.core.model.system.ItemType;
import jp.go.aist.six.oval.model.system.Item;
import jp.go.aist.six.oval.model.system.ItemStatus;



/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class TextFileContentItem
    extends Item
{

    private String  _filepath;
    //{oval-sc:EntityItemStringType, 0..1}

    private String  _path;
    //{oval-sc:EntityItemStringType, 0..1}

    private String  _filename;
    //{oval-sc:EntityItemStringType, 0..1}

    private String  _pattern;
    //{oval-sc:EntityItemStringType, 0..1}

//    private String  _instance;
//    //{oval-sc:EntityItemStringType, 0..1}

    private String  _line;
    //{oval-sc:EntityItemStringType, 0..1}

    private String  _text;
    //{oval-sc:EntityItemStringType, 0..1}

//    private Collection<String>  _subexpression;
//    //{oval-sc:EntityItemAnyType, 0..*}



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
                    final ItemStatus status
                    )
    {
        super( id, status );
    }



    public String getFilepath()
    {
        return _filepath;
    }


    public void setFilepath(
                    final String filepath
                    )
    {
        _filepath = filepath;
    }



    public String getPath()
    {
        return _path;
    }


    public void setPath(
                    final String path
                    )
    {
        _path = path;
    }



    public String getFilename()
    {
        return _filename;
    }


    public void setFilename(
                    final String filename
                    )
    {
        _filename = filename;
    }



    public String getPattern()
    {
        return _pattern;
    }


    public void setPattern(
                    final String pattern
                    )
    {
        _pattern = pattern;
    }



    public String getLine()
    {
        return _line;
    }


    public void setLine(
                    final String line
                    )
    {
        _line = line;
    }



    public String getText()
    {
        return _text;
    }



    public void setText(
                    final String text
                    )
    {
        _text = text;
    }



    //**************************************************************
    //  Item
    //**************************************************************

    @Override
    public ItemType getItemType()
    {
        return ItemType.INDEPENDENT_TEXTFILECONTENT;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "textfilecontent_item[" + super.toString()
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
