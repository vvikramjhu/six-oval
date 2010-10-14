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

package jp.go.aist.six.oval.model.common;

import jp.go.aist.six.util.castor.AbstractPersistable;



/**
 * The Message type defines the structure for which messages
 * are relayed from the data collection engine.
 * Each message is a text string that has an associated
 * level attribute identifying the type of message being sent.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class Message
    extends AbstractPersistable
{

    private String  _content;

    public static final MessageLevel  DEFAULT_LEVEL = MessageLevel.INFO;
    private MessageLevel  _level = DEFAULT_LEVEL;
    //{optional, default="info"}



    /**
     * Constructor.
     */
    public Message()
    {
    }



    public String getContent()
    {
        return _content;
    }


    public void setContent(
                    final String content
                    )
    {
        _content = content;
    }



    public MessageLevel getLevel()
    {
        return (_level == null ? DEFAULT_LEVEL : _level);
    }


    public void setLevel(
                    final MessageLevel level
                    )
    {
        _level = level;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "[level=" + getLevel()
                        + ", " + getContent()
                        + "]";
    }

}
// Message
