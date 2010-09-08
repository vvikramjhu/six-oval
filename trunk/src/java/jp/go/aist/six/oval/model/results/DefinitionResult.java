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

package jp.go.aist.six.oval.model.results;

import jp.go.aist.six.util.orm.Dependent;



/**
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id: DefinitionResult.java 759 2010-05-10 06:56:29Z akihito $
 */
public class DefinitionResult
    extends OvalResultElement
    implements Dependent<SystemResult>
{

//  private Collection<Message>  _messages = new ArrayList<Message>();

    private CriteriaResult  _criteria;
    //{0..1}


    public static final int  DEFAULT_VARIABLE_INSTANCE = 1;
    private int  _variableInstance = DEFAULT_VARIABLE_INSTANCE;
    //{xsd:nonNegativeInteger, optional, default="1"}



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



    /**
     */
    public void setVariableInstance(
                    final int variableInstance
                    )
    {
        if (variableInstance < 0) {
            throw new IllegalArgumentException(
                            "negative variable instance: " + variableInstance );
        }

        _variableInstance = variableInstance;
    }


    public int getVariableInstance()
    {
        return _variableInstance;
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



    private String _masterPersistentID;



    public void setMasterPersistentID(
                    final String id
                    )
    {
        _masterPersistentID = id;
    }



    public String getMasterPersistentID()
    {
        if (_masterPersistentID == null) {
            SystemResult  master = getMasterObject();
            if (master != null) {
                setMasterPersistentID( master.getPersistentID() );
            }
        }

        return _masterPersistentID;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "DefinitionResult[" + super.toString() + "]";
    }

}
// DefinitionResult
