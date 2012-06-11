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

    /* moved to the subclasses */
//    private String  _entityRef;
    //{test_ref, oval:TestIDPattern}
    //{definition_ref, oval:DefinitionIDPattern}


    private int  version;
    //{xsd:nonNegativeInteger, required}


    public static final Integer DEFAULT_VARIABLE_INSTANCE = 1;

    private Integer  variable_instance;
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
    protected abstract void _setEntityRef( String entityID );
    protected abstract String _getEntityRef();

//    protected void _setEntityRef(
//                    final String entityID
//                    )
//    {
//        _entityRef = entityID;
//    }
//
//
//    protected String _getEntityRef()
//    {
//        return _entityRef;
//    }



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

        this.version = version;
    }


    public int getVersion()
    {
        return version;
    }



    /**
     */
    public void setVariableInstance(
                    final Integer variable_instance
                    )
    {
        if (variable_instance != null) {
            if (variable_instance < 0) {
                throw new IllegalArgumentException(
                                "negative variable instance: " + variable_instance );
            }
        }

        this.variable_instance = variable_instance;
    }


    public Integer getVariableInstance()
    {
        return variable_instance;
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
