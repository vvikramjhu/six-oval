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



/**
 * The TextFileContent54Behaviors defines a number of behaviors
 * that allow a more detailed definition of the textfilecontent54 object
 * being specified.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class TextfileContent54BehaviorsX
    extends FileBehaviors
{

    public static final boolean  DEFAULT_IGNORE_CASE = false;
    private boolean  _ignoreCase = DEFAULT_IGNORE_CASE;
    //{optional, default='false'}


    public static final boolean  DEFAULT_MULTILINE = true;
    private boolean  _multiline = DEFAULT_MULTILINE;
    //{optional, default='true'}


    public static final boolean  DEFAULT_SINGLELINE = false;
    private boolean  _singleline = DEFAULT_SINGLELINE;
    //{optional, default='false'}



    /**
     * Constructor.
     */
    public TextfileContent54BehaviorsX()
    {
    }



    /**
     */
    public void setIgnoreCase(
                    final boolean ignoreCase
                    )
    {
        _ignoreCase = ignoreCase;
    }


    public TextfileContent54BehaviorsX ignoreCase(
                    final boolean ignoreCase
                    )
    {
        setIgnoreCase( ignoreCase );
        return this;
    }


    public boolean isIgnoreCase()
    {
        return _ignoreCase;
    }



    /**
     */
    public void setMultiline(
                    final boolean multiline
                    )
    {
        _multiline = multiline;
    }


    public TextfileContent54BehaviorsX multiline(
                    final boolean multiline
                    )
    {
        setMultiline( multiline );
        return this;
    }


    public boolean isMultiline()
    {
        return _multiline;
    }



    /**
     */
    public void setSingleline(
                    final boolean singleline
                    )
    {
        _singleline = singleline;
    }


    public TextfileContent54BehaviorsX singleline(
                    final boolean singleline
                    )
    {
        setSingleline( singleline );
        return this;
    }


    public boolean isSingleline()
    {
        return _singleline;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        result = prime * result + (isIgnoreCase() ? 0 : 1);
        result = prime * result + (isMultiline()  ? 0 : 1);
        result = prime * result + (isSingleline() ? 0 : 1);

        return result;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof TextfileContent54BehaviorsX)) {
            return false;
        }

        if (super.equals( obj )) {
            TextfileContent54BehaviorsX  other = (TextfileContent54BehaviorsX)obj;
            if (isIgnoreCase() == other.isIgnoreCase()) {
                if (isMultiline() == other.isMultiline()) {
                    if (isSingleline() == other.isSingleline()) {
                        return true;
                    }
                }
            }
        }

        return false;
    }



    @Override
    public String toString()
    {
        return super.toString()
                        + ", ignore_case=" + isIgnoreCase()
                        + ", multiline=" + isMultiline()
                        + ", singleline=" + isSingleline()
                        ;
    }

}
// TextFileContent54Behaviors
