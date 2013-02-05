/**
 * SIX OVAL - http://code.google.com/p/six-oval/
 * Copyright (C) 2010
 *   National Institute of Advanced Industrial Science and Technology (AIST)
 *   Registration Number: H22PRO-1124
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
package jp.go.aist.six.oval.model.definitions;

import jp.go.aist.six.oval.model.OvalObject;



/**
 * The PossibleValueType is used to outline a single expected value
 * of an external variable.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class PossibleValueType
    implements OvalObject
{

    private String  content;

    private String  hint;
    //{required}



    /**
     * Constructor.
     */
    public PossibleValueType()
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
    public void setHint(
                    final String hint
                    )
    {
        this.hint = hint;
    }


    public String getHint()
    {
        return hint;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "[" + getContent()
                        + ", hint=" + getHint()
                        + "]";
    }

}
//PossibleValueType
