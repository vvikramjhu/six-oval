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

package jp.go.aist.six.oval.model;




/**
 * A reference to the OvalEntity.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id: OvalAnalysisElement.java 434 2010-03-23 05:01:24Z akihito $
 */
public abstract class OvalAnalysisElement
    extends OvalElement
{

    private transient String  _targetEntityPersistentID;



    /**
     * Constructor.
     */
    public OvalAnalysisElement()
    {
    }


    /**
     * Constructor.
     */
    public OvalAnalysisElement(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }



    /**
     */
    public void setTargetEntityPersistentID(
                    final String pid
                    )
    {
        _targetEntityPersistentID = pid;
    }


    /**
     */
    public String getTargetEntityPersistentID()
    {
        if (_targetEntityPersistentID == null) {
            _targetEntityPersistentID = getOvalID() + ":" + getOvalVersion();
        }

        return _targetEntityPersistentID;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        return super.hashCode();
    }



    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof OvalAnalysisElement)) {
            return false;
        }

        return super.equals( obj );
    }

}
// OvalAnalysisElement
