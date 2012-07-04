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

package jp.go.aist.six.oval.model.definitions;



/**
 * The begin function takes a single string component
 * and defines a character (or string) that the component string should start with.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class BeginFunctionType
    extends FunctionGroup
{

    private ComponentGroup  component;
    //{1..1}


    private String  character;
    //{required}




    /**
     * Constructor.
     */
    public BeginFunctionType()
    {
    }



    /**
     */
    public void setComponent(
                    final ComponentGroup component
                    )
    {
        this.component = component;
    }


    public ComponentGroup getComponent()
    {
        return component;
    }



    /**
     */
    public void setCharacter(
                    final String character
                    )
    {
        this.character = character;
    }


    public String getCharacter()
    {
        return character;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "begin[" + getComponent()
             + ", character=" + getCharacter()
             + "]";
    }

}
//BeginFunctionType
