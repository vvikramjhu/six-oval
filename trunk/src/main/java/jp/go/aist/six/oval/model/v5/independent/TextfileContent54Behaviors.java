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
public class TextfileContent54Behaviors
    extends FileBehaviors
{

    public static final Boolean  DEFAULT_IGNORE_CASE = Boolean.FALSE;
    private Boolean  _ignoreCase;
    //{optional, default='false'}


    public static final Boolean  DEFAULT_MULTILINE = Boolean.TRUE;
    private Boolean  _multiline;
    //{optional, default='true'}


    public static final Boolean  DEFAULT_SINGLELINE = Boolean.FALSE;
    private Boolean  _singleline;
    //{optional, default='false'}



    /**
     * Constructor.
     */
    public TextfileContent54Behaviors()
    {
    }



    /**
     */
    public void setIgnoreCase(
                    final Boolean ignoreCase
                    )
    {
        _ignoreCase = ignoreCase;
    }


    public TextfileContent54Behaviors ignoreCase(
                    final Boolean ignoreCase
                    )
    {
        setIgnoreCase( ignoreCase );
        return this;
    }


    public Boolean getIgnoreCase()
    {
        return _ignoreCase;
    }


    protected final boolean _ignoreCase()
    {
        Boolean  ignoreCase = getIgnoreCase();
        return (ignoreCase == null ? DEFAULT_IGNORE_CASE.booleanValue() : ignoreCase.booleanValue());
    }



    /**
     */
    public void setMultiline(
                    final Boolean multiline
                    )
    {
        _multiline = multiline;
    }


    public TextfileContent54Behaviors multiline(
                    final Boolean multiline
                    )
    {
        setMultiline( multiline );
        return this;
    }


    public Boolean getMultiline()
    {
        return _multiline;
    }


    protected final boolean _multiline()
    {
        Boolean  multiline = getMultiline();
        return (multiline == null ? DEFAULT_MULTILINE.booleanValue() : multiline.booleanValue());
    }



    /**
     */
    public void setSingleline(
                    final Boolean singleline
                    )
    {
        _singleline = singleline;
    }


    public TextfileContent54Behaviors singleline(
                    final Boolean singleline
                    )
    {
        setSingleline( singleline );
        return this;
    }


    public Boolean getSingleline()
    {
        return _singleline;
    }


    protected final boolean _singleline()
    {
        Boolean  singleline = getSingleline();
        return (singleline == null ? DEFAULT_SINGLELINE.booleanValue() : singleline.booleanValue());
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        result = prime * result + (_ignoreCase() ? 0 : 1);
        result = prime * result + (_multiline()  ? 0 : 1);
        result = prime * result + (_singleline() ? 0 : 1);

        return result;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof TextfileContent54Behaviors)) {
            return false;
        }

        if (super.equals( obj )) {
            TextfileContent54Behaviors  other = (TextfileContent54Behaviors)obj;
            if (this._ignoreCase() == other._ignoreCase()) {
                if (this._multiline() == other._multiline()) {
                    if (this._singleline() == other._singleline()) {
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
                        + ", ignore_case=" + getIgnoreCase()
                        + ", multiline=" + getMultiline()
                        + ", singleline=" + getSingleline()
                        ;
    }

}
// TextFileContent54Behaviors
