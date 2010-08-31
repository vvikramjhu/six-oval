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

import jp.go.aist.six.oval.model.Container;
import java.util.Collection;
import java.util.Iterator;



/**
 * A collection of DefinitionResult objects.
 *
 * @author  Akihito Nakamura, AIST
 * @version $Id: DefinitionResults.java 742 2010-05-07 09:22:53Z akihito $
 */
public class DefinitionResults
    extends Container<DefinitionResult>  //{1..*}
//extends OvalElementContainer<DefinitionResult>  //{1..*}
{

    /**
     * Constructor.
     */
    public DefinitionResults()
    {
    }


    /**
     * Constructor.
     */
    public DefinitionResults(
                    final Collection<? extends DefinitionResult> definitions
                    )
    {
        super( definitions );
    }


    /**
     * Constructor.
     */
    public DefinitionResults(
                    final DefinitionResult[] elements
                    )
    {
        super( elements );
    }



    public boolean addDefinition(
                    final DefinitionResult definition
                    )
    {
        return add( definition );
    }


    public Collection<DefinitionResult> getDefinition()
    {
        return _getElement();
    }


    public Iterator<DefinitionResult> iterateDefinition()
    {
        return iterator();
    }

}
// DefinitionResults
