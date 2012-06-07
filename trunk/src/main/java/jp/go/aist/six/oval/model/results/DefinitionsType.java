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

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import jp.go.aist.six.oval.model.Container;



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

    private final Collection<DefinitionType>  definition = new HashSet<DefinitionType>();



    /**
     * Constructor.
     */
    public DefinitionsType()
    {
    }


    public DefinitionsType(
                    final Collection<? extends DefinitionType> definition_list
                    )
    {
//        super( definitions );

//        definition.addAll( definition_list );
        _copy( definition, definition_list );
    }


    public DefinitionsType(
                    final DefinitionType[] definition_list
                    )
    {
//        super( definitions );

        this( Arrays.asList( definition_list ) );
    }



    /**
     */
    public void setDefinition(
                    final Collection<? extends DefinitionType> definition_list
                    )
    {
        reset( definition_list );
//        _setElement( definition_list );
    }


    public void setDefinition(
                    final DefinitionType[] definition_list
                    )
    {
        reset( definition_list );
//        _setElement( definition_list );
    }


    public Collection<DefinitionType> getDefinition()
    {
        return _getCollection();
    }


//    public boolean addDefinition(
//                    final DefinitionType definition
//                    )
//    {
//        return add( definition );
//    }
//
//
//    public Iterator<DefinitionType> iterateDefinition()
//    {
//        return iterator();
//    }



    //**************************************************************
    //  Container
    //**************************************************************

    @Override
    protected Collection<DefinitionType> _getCollection()
    {
        return definition;
    }



    //**************************************************************
    //  java.lang.Object
    //**************************************************************

}
//
