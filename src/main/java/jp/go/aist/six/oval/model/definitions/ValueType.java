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

import jp.go.aist.six.oval.model.OvalObject;




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
public class MessageType
    implements OvalObject
{

    private String  content;


    public static final MessageLevelEnumeration  DEFAULT_LEVEL =
        MessageLevelEnumeration.INFO;

    private MessageLevelEnumeration  level;
    //{optional, default="info"}



    /**
     * Constructor.
     */
    public MessageType()
    {
    }



    /**
     */
    public void setContent(
                    final String content
                    )
    {
        this.content = content;
    }


    public String getContent()
    {
        return this.content;
    }



    /**
     */
    public void setLevel(
                    final MessageLevelEnumeration level
                    )
    {
        this.level = level;
    }


    public MessageLevelEnumeration getLevel()
    {
        return this.level;
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
// MessageType
