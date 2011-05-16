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

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import jp.go.aist.six.oval.model.v5.Container;



/**
 * The DefinitionResults is a container for one or more DefinitionResult instances.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class DefinitionsType
    extends Container<DefinitionType>  //{1..*}
//extends OvalElementContainer<DefinitionResult>  //{1..*}
{

    private final Set<DefinitionType>  definition = new HashSet<DefinitionType>();



    /**
     * Constructor.
     */
    public DefinitionsType()
    {
    }


    public DefinitionsType(
                    final Collection<? extends DefinitionType> definitions
                    )
    {
        super( definitions );
    }


    public DefinitionsType(
                    final DefinitionType[] definitions
                    )
    {
        super( definitions );
    }



    public void setDefinition(
                    final Collection<? extends DefinitionType> definitions
                    )
    {
        _setElements( definitions );
    }


    public boolean addDefinition(
                    final DefinitionType definition
                    )
    {
        return _addElement( definition );
    }


    public Collection<DefinitionType> getDefinition()
    {
        return _getElements();
    }


    public Iterator<DefinitionType> iterateDefinition()
    {
        return _iterateElements();
    }



    //**************************************************************
    //  Container
    //**************************************************************

    @Override
    protected Collection<DefinitionType> _getElements()
    {
        return this.definition;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

    @Override
    public String toString()
    {
        return String.valueOf( getDefinition() );
    }

}
// DefinitionsType
