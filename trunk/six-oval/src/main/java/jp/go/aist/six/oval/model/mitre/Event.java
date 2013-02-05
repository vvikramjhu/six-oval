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

package jp.go.aist.six.oval.model.mitre;

import jp.go.aist.six.oval.model.OvalObject;




/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class Event
    implements OvalObject
{

    private String  date;
//    private Date  _date;



    /**
     * Constructor.
     */
    public Event()
    {
    }


    public Event(
                    final String date
                    )
    {
        setDate( date );
    }



    /**
     */
    public void setDate(
                    final String date
                    )
    {
        this.date = date;
    }


    public String getDate()
    {
        return date;
    }

}
// Event
