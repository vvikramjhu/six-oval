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

import jp.go.aist.six.oval.model.ComponentType;
import jp.go.aist.six.oval.model.definition.EntityStateAnySimple;
import jp.go.aist.six.oval.model.definition.EntityStateString;
import jp.go.aist.six.oval.model.definition.State;




/**
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 */
public class TextFileContentState
    extends State
{

    private EntityStateString  _path;
    //{0..1}

    private EntityStateString  _fileName;
    //{0..1}

    private EntityStateString  _line;
    //{0..1}

    private EntityStateAnySimple  _subExpression;
    //{0..1}



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
        _path = path;
    }


    public EntityStateString getPath()
    {
        return _path;
    }



    /**
     */
    public void setFileName(
                    final EntityStateString filename
                    )
    {
        _fileName = filename;
    }


    public EntityStateString getFileName()
    {
        return _fileName;
    }



    /**
     */
    public void setLine(
                    final EntityStateString line
                    )
    {
        _line = line;
    }


    /**
     */
    public EntityStateString getLine()
    {
        return _line;
    }



    /**
     */
    public void setSubExpression(
                    final EntityStateAnySimple subexpression
                    )
    {
        _subExpression = subexpression;
    }


    public EntityStateAnySimple getSubExpression()
    {
        return _subExpression;
    }



    //**************************************************************
    //  State
    //**************************************************************

    @Override
    public ComponentType getStateType()
    {
        return ComponentType.INDEPENDENT_TEXTFILECONTENT;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = super.hashCode();

        EntityStateString  path = getPath();
        result = prime * result + ((path == null) ? 0 : path.hashCode());

        EntityStateString  filename = getFileName();
        result = prime * result + ((filename == null) ? 0 : filename.hashCode());

        EntityStateString  line = getLine();
        result = prime * result + ((line == null) ? 0 : line.hashCode());

        EntityStateAnySimple  subexpression = getSubExpression();
        result = prime * result + ((subexpression == null) ? 0 : subexpression.hashCode());

        return result;
    }



    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof TextFileContentState)) {
            return false;
        }

        if (super.equals( obj )) {
            TextFileContentState  other = (TextFileContentState)obj;
            EntityStateString  other_path = other.getPath();
            EntityStateString   this_path =  this.getPath();
            if (this_path == other_path
                            ||  (this_path != null  &&  this_path.equals( other_path ))) {
                EntityStateString  other_filename = other.getFileName();
                EntityStateString   this_filename =  this.getFileName();
                if (this_filename == other_filename
                                ||  (this_filename != null  &&  this_filename.equals( other_filename ))) {
                    EntityStateString  other_line = other.getLine();
                    EntityStateString   this_line =  this.getLine();
                    if (this_line == other_line
                                    ||  (this_line != null  &&  this_line.equals( other_line ))) {
                        EntityStateAnySimple  other_subexpression = other.getSubExpression();
                        EntityStateAnySimple   this_subexpression =  this.getSubExpression();
                        if (this_subexpression == other_subexpression
                                        ||  (this_subexpression != null  &&  this_subexpression.equals( other_subexpression ))) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }



    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "TextFileContentState[" + super.toString() + "]";
    }

}
// TextFileContentState
