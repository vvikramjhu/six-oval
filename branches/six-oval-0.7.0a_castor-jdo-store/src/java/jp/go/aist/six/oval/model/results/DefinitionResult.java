/*
 *  @product.title@
 *  Copyright (C) @product.copyright-year@
 *    @product.vendor@
 *    Registration Number: @product.registration-number@
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

package jp.go.aist.six.oval.model.results;

import jp.go.aist.six.oval.model.common.DefinitionClass;
import jp.go.aist.six.util.persist.Dependent;



/**
 * The DefinitionResult holds the result of the evaluation of an OVAL Definition.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class DefinitionResult
    extends OvalResultElement
    implements Dependent<SystemResult>
{

    private DefinitionClass  _definitionClass;
    //{optional}


    private CriteriaResult  _criteria;
    //{0..1}



    /**
     * Constructor.
     */
    public DefinitionResult()
    {
    }


    /**
     * Constructor.
     */
    public DefinitionResult(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    /**
     * Constructor.
     */
    public DefinitionResult(
                    final String id,
                    final int version,
                    final Result result
                    )
    {
        super( id, version, result );
    }



    /**
     */
    public void setDefinitionClass(
                    final DefinitionClass clazz
                    )
    {
        _definitionClass = clazz;
    }


    public DefinitionClass getDefinitionClass()
    {
        return _definitionClass;
    }



    /**
     */
    public void setCriteria(
                    final CriteriaResult criteria
                    )
    {
        _criteria = criteria;
    }


    public CriteriaResult getCriteria()
    {
        return _criteria;
    }


    public DefinitionResult criteria(
                    final CriteriaResult criteria
                    )
    {
        setCriteria( criteria );
        return this;
    }



    /**
     */
    public void setDefinitionID(
                    final String id
                    )
    {
        setOvalID( id );
    }


    public String getDefinitionID()
    {
        return getOvalID();
    }



    //**************************************************************
    //  Dependent
    //**************************************************************

    private SystemResult _master;



    public void setMasterObject(
                    final SystemResult master
                    )
    {
        _master = master;
    }



    public SystemResult getMasterObject()
    {
        return _master;
    }



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



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public int hashCode()
    {
        return super.hashCode();
    }



    @Override
    public boolean equals(
                    final Object obj
                    )
    {
        if (!(obj instanceof DefinitionResult)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "definition[" + super.toString()
                        + ", criteria=" + getCriteria()
                        + "]";
    }

}
// DefinitionResult
