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

import jp.go.aist.six.oval.model.ElementType;
import jp.go.aist.six.oval.model.common.ClassEnumeration;



/**
 * The DefinitionResult holds the result of the evaluation of an OVAL Definition.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class DefinitionType
    extends ResultsElement
//    implements Dependent<SystemType>
{

    //TODO: Is this class a subclass of ElementRef?
    private String  definition_id;
    //{oval:DefinitionIDPattern, required}



    private CriteriaType  criteria;
    //{0..1}


    private ClassEnumeration  definition_class;
    //{optional}



    /**
     * Constructor.
     */
    public DefinitionType()
    {
    }


    public DefinitionType(
                    final String id,
                    final int version
                    )
    {
        super( id, version );
    }


    public DefinitionType(
                    final String id,
                    final int version,
                    final ResultEnumeration result
                    )
    {
        super( id, version, result );
    }



    /**
     */
    public void setCriteria(
                    final CriteriaType criteria
                    )
    {
        this.criteria = criteria;
    }


    public CriteriaType getCriteria()
    {
        return criteria;
    }


    public DefinitionType criteria(
                    final CriteriaType criteria
                    )
    {
        setCriteria( criteria );
        return this;
    }



    /**
     */
    public void setDefinitionId(
                    final String definition_id
                    )
    {
        this.definition_id = definition_id;
    }


    public String getDefinitionId()
    {
        return definition_id;
    }



    /**
     */
    public void setDefinitionClass(
                    final ClassEnumeration definition_class
                    )
    {
        this.definition_class = definition_class;
    }


    public ClassEnumeration getDefinitionClass()
    {
        return definition_class;
    }



    //*********************************************************************
    //  Element
    //*********************************************************************

    @Override
    public void setOvalId(
                    final String id
                    )
    {
        setDefinitionId( id );
    }


    @Override
    public String getOvalId()
    {
        return getDefinitionId();
    }



    @Override
    public final ElementType ovalGetType()
    {
        return ElementType.DEFINITION;
    }



//    //**************************************************************
//    //  Dependent
//    //**************************************************************
//
//    private SystemType _master;
//
//
//
//    @Override
//    public void setMasterObject(
//                    final SystemType master
//                    )
//    {
//        _master = master;
//    }
//
//
//
//    @Override
//    public SystemType getMasterObject()
//    {
//        return _master;
//    }



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
        if (!(obj instanceof DefinitionType)) {
            return false;
        }

        return super.equals( obj );
    }



    @Override
    public String toString()
    {
        return "[" + super.toString()
                        + ", criteria=" + getCriteria()
                        + "]";
    }

}
// DefinitionType
