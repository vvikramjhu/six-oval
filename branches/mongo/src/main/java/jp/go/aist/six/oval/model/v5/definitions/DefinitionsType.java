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

package jp.go.aist.six.oval.model.v5.definitions;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import com.google.code.morphia.annotations.Reference;



/**
 * A container for one or more Definition instances.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id$
 * @see <a href="http://oval.mitre.org/language/">OVAL Language</a>
 */
public class DefinitionsType
//    implements Iterable<DefinitionType>
//    extends OvalElementContainer<DefinitionType>    //{1..*}
{

    @Reference
    private final Set<DefinitionType>  definition = new HashSet<DefinitionType>();



    /**
     * Constructor.
     */
    public DefinitionsType()
    {
    }


    public DefinitionsType(
                    final Collection<? extends DefinitionType> definitionList
                    )
    {
        setDefinition( definitionList );
    }


    /**
     * Constructor.
     */
    public DefinitionsType(
                    final DefinitionType[] definitions
                    )
    {
        setDefinition( definitions );
    }



    /**
     */
    public void setDefinition(
                    final Collection<? extends DefinitionType> definitionList
                    )
    {
        if (this.definition != definitionList) {
            this.definition.clear();
            if (definitionList != null  &&  definitionList.size() > 0) {
                this.definition.addAll( definitionList );
            }
        }
    }


    public void setDefinition(
                    final DefinitionType[] definitionList
                    )
    {
        if (definitionList != null) {
            setDefinition( Arrays.asList( definitionList ) );
        }
    }


    public Collection<DefinitionType> getDefinition()
    {
        return this.definition;
    }


    public Iterator<DefinitionType> iterateDefinition()
    {
        return this.definition.iterator();
    }


    public boolean addDefinition(
                    final DefinitionType definition
                    )
    {
        return this.definition.add( definition );
    }



    //**************************************************************
    //  Set I/F
    //**************************************************************

    public int size()
    {
        return this.definition.size();
    }



    //**************************************************************
    //  Iterable
    //**************************************************************

//    @Override
//    public Iterator<DefinitionType> iterator()
//    {
//        return this.definition.iterator();
//    }


    public Iterable<DefinitionType> it()
    {
        return this.definition;
    }

}
// DefinitionsType
