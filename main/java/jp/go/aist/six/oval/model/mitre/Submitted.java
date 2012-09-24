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




/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class Submitted
    extends Event
{

    private Contributor  contributor;
    //{0..1}



    /**
     * Constructor.
     */
    public Submitted()
    {
    }


    public Submitted(
                    final String date,
                    final Contributor contributor
                    )
    {
        super( date );
        setContributor( contributor );
    }



    /**
     */
    public void setContributor(
                    final Contributor contributor
                    )
    {
        this.contributor = contributor;
    }


    public Contributor getContributor()
    {
        return contributor;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "submitted[date=" + getDate()
                        + ", contributor=" + getContributor()
                        + "]";
    }

}
// Submitted
