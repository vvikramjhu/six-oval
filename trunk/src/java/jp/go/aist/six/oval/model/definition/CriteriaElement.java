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

package jp.go.aist.six.oval.model.definition;

import jp.go.aist.six.util.orm.Persistable;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id: CriteriaElement.java 634 2010-04-20 09:14:26Z akihito $
 */
public abstract class CriteriaElement
    implements Persistable
{

    public static final boolean  DEFAULT_NEGATE = false;



    private boolean  _negate = DEFAULT_NEGATE;
    //{xsd:boolean, optional, default="false"}

    private String  _comment;
    //{xsd:string, optional}



    /**
     * Constructor.
     */
    public CriteriaElement()
    {
    }



    public void setNegate(
                    final boolean negate
                    )
    {
        _negate = negate;
    }


    public boolean isNegate()
    {
        return _negate;
    }



    public void setComment(
                    final String comment
                    )
    {
        _comment = comment;
    }


    public String getComment()
    {
        return _comment;
    }



    //**************************************************************
    //  Persistable
    //**************************************************************

    /**
     * The persistent identifier.
     */
    private  String  _persistentID;


    public
    void setPersistentID( final String id )
    {
        _persistentID = id;
    }


    public
    String getPersistentID()
    {
        return _persistentID;
    }

}
// CriteriaElement
