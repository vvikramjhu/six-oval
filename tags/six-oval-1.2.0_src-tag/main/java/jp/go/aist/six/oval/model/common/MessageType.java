/*
 *  @product.title@
 *  Copyright (C) @product.copyright-year@
 *    @product.vendor@
 *    Registration Number: @product.registration-number@
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
        return content;
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
        return level;
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