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
import jp.go.aist.six.oval.model.ComponentType;
import jp.go.aist.six.oval.model.ElementRef;
import jp.go.aist.six.oval.model.Family;
import jp.go.aist.six.oval.model.definitions.EntityStateAnySimpleType;
import jp.go.aist.six.oval.model.definitions.EntityStateStringType;
import jp.go.aist.six.oval.model.definitions.StateType;



/**
 * The textfilecontent state contains entities that are used to check
 * the file path and name, as well as the line in question and
 * the value of the specific subexpression.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 * @deprecated Deprecated as of version 5.4:
 *             Replaced by the textfilecontent54 state and
 *             will be removed in a future version of the language.
 */
@Deprecated
public class TextfileContentState
    extends StateType
{

    private EntityStateStringType  path;
    //{0..1}

    private EntityStateStringType  filename;
    //{0..1}

    private EntityStateStringType  line;
    //{0..1}

    private EntityStateAnySimpleType  subexpression;
    //{0..1}


    private EntityStateWindowsViewType  windows_view;
    //{0..1}



    /**
     * Constructor.
     */
    public TextfileContentState()
    {
        this( null, 0 );
    }


    public TextfileContentState(
                    final String id,
                    final int version
                    )
    {
        this( id, version, null );
    }


    public TextfileContentState(
                    final String id,
                    final int version,
                    final String comment
                    )
    {
        super( id, version, comment );

//        _oval_platform_type = OvalPlatformType.independent;
//        _oval_component_type = OvalComponentType.textfilecontent;
        _oval_family = Family.INDEPENDENT;
        _oval_component = ComponentType.TEXTFILECONTENT;
    }



    /**
     */
    public void setPath(
                    final EntityStateStringType path
                    )
    {
        this.path = path;
    }


    public EntityStateStringType getPath()
    {
        return path;
    }



    /**
     */
    public void setFilename(
                    final EntityStateStringType filename
                    )
    {
        this.filename = filename;
    }


    public EntityStateStringType getFilename()
    {
        return filename;
    }



    /**
     */
    public void setLine(
                    final EntityStateStringType line
                    )
    {
        this.line = line;
    }


    public EntityStateStringType getLine()
    {
        return line;
    }



    /**
     */
    public void setSubexpression(
                    final EntityStateAnySimpleType subexpression
                    )
    {
        this.subexpression = subexpression;
    }


    public EntityStateAnySimpleType getSubexpression()
    {
        return subexpression;
    }



    /**
     */
    public void setWindowsView(
                    final EntityStateWindowsViewType windows_view
                    )
    {
        this.windows_view = windows_view;
    }


    public EntityStateWindowsViewType getWindowsView()
    {
        return windows_view;
    }



    //*********************************************************************
    //  DefinitionsElement
    //*********************************************************************

    @Override
    public Collection<ElementRef> ovalGetElementRef()
    {
        Collection<ElementRef>  ref_list = new ArrayList<ElementRef>();
        ref_list.add( getPath() );
        ref_list.add( getFilename() );
        ref_list.add( getLine() );
        ref_list.add( getSubexpression() );
        ref_list.add( getWindowsView() );

        return ref_list;
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
        if (!(obj instanceof TextfileContentState)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "textfilecontent_state[" + super.toString()
                        + ", path="         + getPath()
                        + ", filename="     + getFilename()
                        + ", line="         + getLine()
                        + ", subexpression=" + getSubexpression()
                        + ", windows_view=" + getWindowsView()
                        + "]";
    }

}
// TextFileContentState
