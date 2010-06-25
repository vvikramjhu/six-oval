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

package jp.go.aist.six.oval.model.result;

import jp.go.aist.six.util.orm.AbstractPersistable;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 */
public class Directive
    extends AbstractPersistable
//    implements Dependent<SystemResult>
{

    private boolean  _reported;
    //{required}

    public static final Content  DEFAULT_CONTENT = Content.FULL;
    private Content  _content;
    //{optional, default="full"}



    /**
     * Constructor.
     */
    public Directive()
    {
    }


    /**
     * Constructor.
     */
    public Directive(
                    final boolean reported
                    )
    {
        this( reported, DEFAULT_CONTENT );
    }


    /**
     * Constructor.
     */
    public Directive(
                    final boolean reported,
                    final Content content
                    )
    {
        setReported( reported );
        setContent( content );
    }



    public void setReported(
                    final boolean reported
                    )
    {
        _reported = reported;
    }



    public boolean isReported()
    {
        return _reported;
    }



    public void setContent(
                    final Content content
                    )
    {
        _content = content;
    }



    public Content getContent()
    {
        return _content;
    }



//    //**************************************************************
//    //  Dependent
//    //**************************************************************
//
//    private SystemResult _master;
//
//
//
//    public void setMasterObject(
//                    final SystemResult master
//                    )
//    {
//        _master = master;
//    }
//
//
//
//    public SystemResult getMasterObject()
//    {
//        return _master;
//    }
//
//
//
//    private String _masterPersistentID;
//
//
//
//    public void setMasterPersistentID(
//                    final String id
//                    )
//    {
//        _masterPersistentID = id;
//    }
//
//
//
//    public String getMasterPersistentID()
//    {
//        if (_masterPersistentID == null) {
//            SystemResult  master = getMasterObject();
//            if (master != null) {
//                setMasterPersistentID( master.getPersistentID() );
//            }
//        }
//
//        return _masterPersistentID;
//    }



    // **************************************************************
    // java.lang.Object
    // **************************************************************

    @Override
    public String toString()
    {
        return "Directive[reported=" + isReported()
                        + ", content=" + getContent()
                        + "]";
    }

}
// Direcitive
