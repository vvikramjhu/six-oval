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

package jp.go.aist.six.oval.model.common;

import jp.go.aist.six.util.orm.Persistable;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id: Message.java 434 2010-03-23 05:01:24Z akihito $
 */
public class Message
    implements Persistable
{

    private String  _content;
    private MessageLevel  _level;



    /**
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
        return _level;
    }


    public void setLevel(
                    final MessageLevel level
                    )
    {
        _level = level;
    }



    //**************************************************************
    //  Persistable
    //**************************************************************

    /**
     * The persistent identifier.
     */
    private  String  _persistentID;


    public void setPersistentID(
                    final String id
                    )
    {
        _persistentID = id;
    }


    public String getPersistentID()
    {
        return _persistentID;
    }

}
// Message
