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

import java.util.Collection;
import java.util.Collections;
import jp.go.aist.six.oval.model.OvalObject;




/**
 * Any value that is pulled directly off the local system
 * is defined by the basic component.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class ComponentGroup
    implements OvalObject
//    implements Dependent<LocalVariable>
{

    /**
     * Constructor.
     */
    public ComponentGroup()
    {
    }



    /**
     */
    public Collection<ComponentGroup> ovalGetSubComponent()
    {
        return Collections.emptyList();
    }

}
// ComponentGroup
