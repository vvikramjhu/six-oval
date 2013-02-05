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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import jp.go.aist.six.oval.model.OvalObject;



/**
 * The PossibleRestrictionType outlines a range of possible expected value
 * of an external variable.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class PossibleRestrictionType
    implements OvalObject
{

    private final Collection<RestrictionType>  restriction = new ArrayList<RestrictionType>();
    //{1..*}

    private String  hint;
    //{required}



    /**
     * Constructor.
     */
    public PossibleRestrictionType()
    {
    }



    /**
     */
    public void setRestriction(
                    final Collection<? extends RestrictionType> restrictions
                    )
    {
        if (restrictions != restriction) {
            restriction.clear();
            if (restrictions != null  &&  restrictions.size() > 0) {
                for (RestrictionType  restriction : restrictions) {
                    addRestriction( restriction );
                }
//                this.restriction.addAll( restrictions );
            }
        }
    }


    public boolean addRestriction(
                    final RestrictionType restriction
                    )
    {
        if (restriction == null) {
            return false;
        }

        return this.restriction.add( restriction );
    }


    public Collection<RestrictionType> getRestriction()
    {
        return restriction;
    }


    public Iterator<RestrictionType> iterateRestriction()
    {
        return restriction.iterator();
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
        return "[restriction="  + getRestriction()
                        + ", hint=" + getHint()
                        + "]";
    }

}
//PossibleRestrictionType
