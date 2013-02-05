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
 * An abstract base class for Criteria, Criterion, and ExtendDefinition.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class CriteriaElement
    implements OvalObject
//    implements Dependent<DefinitionType>
{

    public static final Boolean  DEFAULT_NEGATE = Boolean.FALSE;
    private Boolean  negate;
    //{optional, xsd:boolean, default="false"}

    private String  comment;
    //{optional}



    /**
     * Constructor.
     */
    public CriteriaElement()
    {
    }


    /**
     * Constructor.
     */
    public CriteriaElement(
                    final String comment
                    )
    {
        setComment( comment );
    }



    /**
     */
    public void setNegate(
                    final Boolean negate
                    )
    {
        this.negate = negate;
    }


    public Boolean getNegate()
    {
        return negate;
    }



    /**
     */
    public void setComment(
                    final String comment
                    )
    {
        this.comment = comment;
    }


    public String getComment()
    {
        return comment;
    }



//    //**************************************************************
//    //  Dependent
//    //**************************************************************
//
//    private DefinitionType  _master;
//
//
//
//    @Override
//    public void setMasterObject(
//                    final DefinitionType master
//                    )
//    {
//        _master = master;
//    }
//
//
//    @Override
//    public DefinitionType getMasterObject()
//    {
//        return _master;
//    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        final int  prime = 37;
        int  result = 17;

        Boolean  negate = getNegate();
        if (negate == null) {
            negate = DEFAULT_NEGATE;
        }
        result = prime * result + (negate ? 0 : 1);

        return result;
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof CriteriaElement)) {
            return false;
        }

        CriteriaElement  other = (CriteriaElement)obj;
        Boolean  otherNegate = other.getNegate();
        if (otherNegate == null) {
            otherNegate = DEFAULT_NEGATE;
        }
        Boolean  thisNegate = this.getNegate();
        if (thisNegate == null) {
            thisNegate = DEFAULT_NEGATE;
        }
        if (thisNegate.booleanValue() == otherNegate.booleanValue()) {
            return true;
        }

        return false;
    }

}
// CriteriaElement
