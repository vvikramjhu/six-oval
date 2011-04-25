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

package jp.go.aist.six.oval.model.v5.results;



/**
 * An abstract base class for the criteria-related leaf types.
 *
 * @author	Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public abstract class CriteriaResultLeafElement
    extends CriteriaResultElement
{

    private String  _entityRef;
    //{test_ref, oval:TestIDPattern}
    //{definition_ref, oval:DefinitionIDPattern}


    private int  _version;
    //{xsd:nonNegativeInteger, required}


    public static final Integer DEFAULT_VARIABLE_INSTANCE = 1;
    private Integer  _variableInstance;
    //{xsd:nonNegativeInteger, optional, default="1"}



    /**
     * Constructor.
     */
    public CriteriaResultLeafElement()
    {
    }


    public CriteriaResultLeafElement(
                    final String id,
                    final int version
                    )
    {
        _setEntityRef( id );
        setVersion( version );
    }


    public CriteriaResultLeafElement(
                    final String id,
                    final int version,
                    final ResultEnumeration result
                    )
    {
        this( id, version );
        setResult( result );
    }



    /**
     */
    protected void _setEntityRef(
                    final String entityID
                    )
    {
        _entityRef = entityID;
    }


    protected String _getEntityRef()
    {
        return _entityRef;
    }



    /**
     */
    public void setVersion(
                    final int version
                    )
    {
        if (version < 0) {
            throw new IllegalArgumentException(
                            "negative version: " + version );
        }

        _version = version;
    }


    public int getVersion()
    {
        return _version;
    }



    /**
     */
    public void setVariableInstance(
                    final Integer variableInstance
                    )
    {
        if (variableInstance != null) {
            if (variableInstance < 0) {
                throw new IllegalArgumentException(
                                "negative variable instance: " + variableInstance );
            }
        }

        _variableInstance = variableInstance;
    }


    public Integer getVariableInstance()
    {
        return _variableInstance;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return "version=" + getVersion()
                        + ", variable_instance=" + getVariableInstance()
                        + ", " + super.toString();
    }

}
// CriterionResultLeafElement